/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.ColumnChoiceResponse;

/**
 *
 * @author zhao
 */
public interface ColumnChoiceResponseDao extends GenericDao<ColumnChoiceResponse, Integer> {
    
    /**
     * Remove columnChoiceResponses by qr_id.
     * @param qr_id 
     */
    public void removeColumnChoiceResponsesByQrid(Integer qr_id);
}
