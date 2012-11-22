/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.GenericDao;
import au.com.satech.wds.dao.HibernateUtil;
import au.com.satech.wds.dao.support.NamedQueryUtil;
import au.com.satech.wds.dao.support.SearchTemplate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sam
 */
public class GenericDaoJpa<T, PK extends Serializable> implements GenericDao<T, PK> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());
    
    private EntityManager entityManager;
    
    @Autowired
    protected EntityManagerFactory entityManagerFactory;
    
    private Class<T> persistentClass;
    
    // ------------------------------------------
    // Configuration
    // ------------------------------------------
    private boolean cacheable = true;
    private String cacheRegion;
    
    // ------------------------------------------
    // Dependencies
    // ------------------------------------------
    private NamedQueryUtil namedQueryUtil;

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing or using dependency injection.
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDaoJpa(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        this.cacheRegion = persistentClass.getCanonicalName();
    }
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return this.entityManager.createQuery(
                "select obj from " + this.persistentClass.getName() + " obj")
                .getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<T> getAllDistinct() {
        Collection result = new LinkedHashSet(getAll());
        return new ArrayList(result);
    }

    public T get(PK id) {
        T entity = this.entityManager.find(this.persistentClass, id);

        if (entity == null) {
            String msg = "Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...";
            log.warn(msg);
            throw new EntityNotFoundException(msg);
        }

        return entity;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exists(PK id) {
        T entity = this.entityManager.find(this.persistentClass, id);
        return entity != null;
    }

    /**
     * {@inheritDoc}
     */
    public T save(T object) {
//        this.entityManager.persist(object);
        return this.entityManager.merge(object);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(PK id) {
        this.entityManager.remove(this.get(id));
    }
    
    public void indexEntity(T object) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.index(object);
    }

    public void indexAllItems() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        List results = fullTextEntityManager.createQuery("from " + persistentClass.getCanonicalName()).getResultList();
        int counter = 0, numItemsInGroup = 10;
        Iterator resultsIt = results.iterator();
        while (resultsIt.hasNext()) {
            fullTextEntityManager.index(resultsIt.next());
            if (counter++ % numItemsInGroup == 0) {
                fullTextEntityManager.flushToIndexes();
                fullTextEntityManager.clear();
            }
        }
    }
    
    public int findCount(T entity, SearchTemplate searchTemplate) {
        Validate.notNull(entity, "The entity cannot be null");
        SearchTemplate localSearchTemplate = getLocalSearchTemplate(searchTemplate);

        if (localSearchTemplate.hasNamedQuery()) {
            return getNamedQueryUtil().numberByNamedQuery(localSearchTemplate, entity).intValue();
        }

        Criteria criteria = getCriteria(entity, searchTemplate);
        criteria.setProjection(Projections.rowCount());

        Number count = (Number) criteria.uniqueResult();

        if (count != null) {
            return count.intValue();
        } else {
            log.warn("findCount returned null!");
            return 0;
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<T> find(T entity, SearchTemplate searchTemplate) {
        Validate.notNull(entity, "The passed entity cannot be null");
        SearchTemplate localSearchTemplate = getLocalSearchTemplate(searchTemplate);

        if (localSearchTemplate.hasNamedQuery()) {
            return (List<T>) getNamedQueryUtil().findByNamedQuery(localSearchTemplate, entity);
        }

        Criteria criteria = getCriteria(entity, localSearchTemplate);
        HibernateUtil.applyPaginationAndOrderOnCriteria(criteria, localSearchTemplate);

        List<T> entities = (List<T>) criteria.list();
        if (log.isDebugEnabled()) {
            log.debug("Returned " + entities.size() + " elements");
        }

        return entities;
    }
    
    /**
     * Create a new search template, taking into account the passed searchTemplate and the cacheable and cacheRegion properties of this instance.
     */
    public SearchTemplate getLocalSearchTemplate(SearchTemplate searchTemplate) {
        if (searchTemplate == null) {
            SearchTemplate localSearchTemplate = new SearchTemplate();
            localSearchTemplate.setCacheable(isCacheable());
            localSearchTemplate.setCacheRegion(getCacheRegion());
            return localSearchTemplate;
        }

        SearchTemplate localSearchTemplate = new SearchTemplate(searchTemplate);

        if (searchTemplate.isCacheable() == null) {
            localSearchTemplate.setCacheable(isCacheable());
        }

        if (!searchTemplate.hasCacheRegion()) {
            localSearchTemplate.setCacheRegion(getCacheRegion());
        }

        return localSearchTemplate;
    }
    
    /**
     * Simple helper to obtain the current Session.
     */
    protected Session getCurrentSession() {
        return (Session) getEntityManager().getDelegate();
    }
    
    /**
     * Create a criteria with caching enabled
     * 
     * @param entity the entity to use in search by Example
     * @param searchTemplate the specific parameters such as named queries, extra infos, limitations, order, ...
     * @return an hibernate criteria
     */
    protected Criteria getCriteria(T entity, SearchTemplate searchTemplate) {
        Criteria criteria = getCurrentSession().createCriteria(persistentClass);
        setUpCacheOnCriteria(criteria, searchTemplate);

        List<Criterion> criterions = getCriterions(entity, searchTemplate);
        for (Criterion criterion : criterions) {
            criteria.add(criterion); // AND
        }

        return criteria;
    }
    
    protected List<Criterion> getCriterions(T entity, SearchTemplate searchTemplate) {
        List<Criterion> criterions = new ArrayList<Criterion>();

        // search by date range
        Criterion dateCriterion = getByDateCriterion(searchTemplate);
        if (dateCriterion != null) {
            criterions.add(dateCriterion);
        }

        // search by example
        Criterion exampleCriterion = getByExampleCriterion(entity, searchTemplate);
        if (exampleCriterion != null) {
            criterions.add(exampleCriterion);
        }

        // search by pattern
        Criterion patternCriterion = getByPatternCriterion(searchTemplate);
        if (patternCriterion != null) {
            criterions.add(patternCriterion);
        }

        // additional criterion (for example isNull criterion on x-to-many association)
        for (Criterion c : searchTemplate.getCriterions()) {
            criterions.add(c);
        }

        return criterions;
    }
    
    protected void setUpCacheOnCriteria(Criteria criteria, SearchTemplate searchTemplate) {
        if (searchTemplate.isCacheable()) {
            criteria.setCacheable(true);

            if (searchTemplate.hasCacheRegion()) {
                criteria.setCacheRegion(searchTemplate.getCacheRegion());
            } else {
                criteria.setCacheRegion(getCacheRegion());
            }
        }
    }
    
    protected Criterion getByDateCriterion(SearchTemplate searchTemplate) {
        return HibernateUtil.constructDate(searchTemplate);
    }
    
    protected Criterion getByExampleCriterion(T entity, SearchTemplate searchTemplate) {
        Criterion example = HibernateUtil.constructExample(entity, searchTemplate);
        List<Criterion> extras = getByExampleExtraCriterions(entity, searchTemplate);

        if (extras != null && extras.size() > 0) {
            Junction conjunction = Restrictions.conjunction();
            for (Criterion extra : extras) {
                conjunction.add(extra);
            }
            conjunction.add(example);
            return conjunction;
        } else {
            return example;
        }
    }

    protected Criterion getByPatternCriterion(SearchTemplate searchTemplate) {
        return HibernateUtil.constructPattern(persistentClass, searchTemplate);
    }
    
    /**
     * Subclass may provide extra criterion. Used along with search by example. Default implementation does nothing. Principal use case is to add criterion so
     * the id fields part of the composite primary key are included in a search by example.
     * 
     * @param entity
     * @param searchTemplate
     * @return a criterion that will be appended (AND) to the example criterion. Null if no criterion should be appended.
     */
    protected List<Criterion> getByExampleExtraCriterions(T entity, SearchTemplate searchTemplate) {
        return null;
    }

    /**
     * @return the cacheable
     */
    public boolean isCacheable() {
        return cacheable;
    }

    /**
     * @param cacheable the cacheable to set
     */
    public void setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
    }

    /**
     * @return the cacheRegion
     */
    public String getCacheRegion() {
        return cacheRegion;
    }

    /**
     * @param cacheRegion the cacheRegion to set
     */
    public void setCacheRegion(String cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

    /**
     * @return the namedQueryUtil
     */
    public NamedQueryUtil getNamedQueryUtil() {
        return namedQueryUtil;
    }

    /**
     * @param namedQueryUtil the namedQueryUtil to set
     */
    public void setNamedQueryUtil(NamedQueryUtil namedQueryUtil) {
        this.namedQueryUtil = namedQueryUtil;
    }
}
