/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.AnswerResponse;

/**
 *
 * @author zhao
 */
public interface AnswerResponseDao extends GenericDao<AnswerResponse, Integer> {
    
    /**
     * Remove answerResponses by qr_id.
     * @param qr_id 
     */
    public void removeAnswerResponsesByQrid(Integer qr_id);
}
