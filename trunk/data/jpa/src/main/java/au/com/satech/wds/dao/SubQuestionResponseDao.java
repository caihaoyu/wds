/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.SubQuestionResponse;

/**
 *
 * @author zhao
 */
public interface SubQuestionResponseDao extends GenericDao<SubQuestionResponse, Integer> {
    
    /**
     * Remove subquestionResponses by qr_id.
     * @param qr_id 
     */
    public void removeSubQuestionResponsesByQrid(Integer qr_id);
}
