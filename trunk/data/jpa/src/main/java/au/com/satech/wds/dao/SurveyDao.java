/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.Survey;

/**
 *
 * @author sam
 */
public interface SurveyDao extends GenericDao<Survey, Integer> {
    Survey loadSurveyBySurveyTitle(String title);
}
