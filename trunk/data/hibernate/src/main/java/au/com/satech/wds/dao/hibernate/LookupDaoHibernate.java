/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.hibernate;

import au.com.satech.wds.dao.LookupDao;
import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.Survey;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
@Repository("lookupDao")
public class LookupDaoHibernate implements LookupDao {
    private HibernateTemplate hibernateTemplate;
    
    /**
     * Initialize LookupDaoHibernate with Hibernate SessionFactory.
     * @param sessionFactory
     */
    @Autowired
    public LookupDaoHibernate(final SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    public List<Survey> getSurveys() {
        return hibernateTemplate.find("from Survey");
    }

}
