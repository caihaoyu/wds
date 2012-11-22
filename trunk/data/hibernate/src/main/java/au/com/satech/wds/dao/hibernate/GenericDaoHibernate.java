/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.hibernate;

import au.com.satech.wds.dao.GenericDao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>To register this class in your Spring context file, use the following XML.
 * <pre>
 *      &lt;bean id="fooDao" class="au.com.satech.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="au.com.satech.model.Foo"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 *
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {

    private final static Logger logger = Logger.getLogger("au.com.satech.dao.hibernate");
    private Class<T> persistentClass;
    private HibernateTemplate hibernateTemplate;
    private SessionFactory sessionFactory;
    
    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
    
    /**
     * Constructor that takes in a class and sessionFactory for easy creation of DAO.
     *
     * @param persistentClass the class type you'd like to persist
     * @param sessionFactory  the pre-configured Hibernate SessionFactory
     */
    public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    public HibernateTemplate getHibernateTemplate() {
        return this.hibernateTemplate;
    }
    
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    
    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    public List<T> getAll() {
        return hibernateTemplate.loadAll(this.persistentClass);
    }

    public T get(PK id) {
        T entity = (T) hibernateTemplate.get(this.persistentClass, id);
        if (entity == null) {
            logger.warning("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }
        return entity;
    }

    public boolean exists(PK id) {
        T entity = (T) hibernateTemplate.get(this.persistentClass, id);
        return entity != null;
    }

    public T save(T object) {
        return (T) hibernateTemplate.merge(object);
    }

    public void remove(PK id) {
        hibernateTemplate.delete(this.get(id));
    }

    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        String[] params = new String[queryParams.size()];
        Object[] values = new Object[queryParams.size()];
        
        int index = 0;
        for (String s : queryParams.keySet()) {
            params[index] = s;
            values[index++] = queryParams.get(s);
        }

        return hibernateTemplate.findByNamedQueryAndNamedParam(queryName, params, values);
    }
    
}
