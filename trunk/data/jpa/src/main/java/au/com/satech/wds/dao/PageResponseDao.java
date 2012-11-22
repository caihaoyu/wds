/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.PageResponse;
import java.util.List;

/**
 *
 * @author zhao
 */
public interface PageResponseDao extends GenericDao<PageResponse, Integer> {
    
    /**
     * get pageResponses list by sr_id.
     * @param sr_id
     * @return 
     */
    public List<PageResponse> getPageResponsesBySrid(Integer sr_id);
}
