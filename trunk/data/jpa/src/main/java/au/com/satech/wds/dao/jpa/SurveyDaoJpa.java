/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.SurveyDao;
import au.com.satech.wds.model.Survey;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("surveyDao")
public class SurveyDaoJpa extends GenericDaoJpa<Survey, Integer> implements SurveyDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public SurveyDaoJpa(){
        super(Survey.class);
    }

    public Survey saveSurvey(Survey survey) {
        Survey s = super.save(survey);
        getEntityManager().flush();
        return s;
    }
    /**
     * 根据Title从查询Survey
     * @param title 
     * @return Survey
     */
    @Override
    public Survey loadSurveyBySurveyTitle(String title) {
        Query q = getEntityManager().createQuery("select s from Survey s where s.surveytitle=?");
        q.setParameter(1, title);
        List<Survey> surveys = q.getResultList();
        if(surveys == null || surveys.isEmpty()){
            return null;
        } else {
            return surveys.get(0);
        }
    }
}
