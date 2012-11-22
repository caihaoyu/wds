/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.QuestionResponse;
import java.util.List;

/**
 *
 * @author zhao
 */
public interface QuestionResponseDao extends GenericDao<QuestionResponse, Integer> {
    
    /**
     * get questionResponse list by pr_id.
     * @param pr_id
     * @return 
     */
    public List<QuestionResponse> getQuestionResponsesByPrid(Integer pr_id);
}
