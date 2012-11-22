/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;
import au.com.satech.wds.dao.SurveyResponseDao;
import au.com.satech.wds.model.SurveyResponse;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("surveyResponseDao")
public class SurveyResponseDaoJpa extends GenericDaoJpa<SurveyResponse, Integer> implements SurveyResponseDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public SurveyResponseDaoJpa(){
        super(SurveyResponse.class);
    }
}
