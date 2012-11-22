/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.Entry;
import java.util.List;

/**
 *
 * @author sam
 */
public interface EntryDao extends GenericDao<Entry, Integer> {
    
    /**
     * Remove entrys by qr_id
     * @param qr_id 
     */
    public void removeEntrysByQrid(Integer qr_id);
}
