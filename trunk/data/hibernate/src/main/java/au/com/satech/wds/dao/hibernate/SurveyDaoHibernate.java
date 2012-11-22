/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.hibernate;

import au.com.satech.wds.dao.SurveyDao;
import au.com.satech.wds.model.Survey;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("surveyDao")
public class SurveyDaoHibernate extends GenericDaoHibernate<Survey, Integer> implements SurveyDao {
    
    
    public SurveyDaoHibernate() {
        super(Survey.class);
    }

}
