/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Survey;
import java.util.List;

/**
 *
 * @author sam
 *  this Dao class is actually useless, since every genericDao class has it's own getAll() function
 */
public interface LookupDao {
    /**
     * Returns all surveys in database
     * @return populated list of surveys
     */
    List<Survey> getSurveys();    
}
