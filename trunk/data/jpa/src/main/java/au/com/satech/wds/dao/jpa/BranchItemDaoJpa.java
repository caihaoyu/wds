/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.BranchItemDao;
import au.com.satech.wds.model.BranchItem;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("branchItemDao")
public class BranchItemDaoJpa extends GenericDaoJpa<BranchItem, Integer> implements BranchItemDao {
    
    public BranchItemDaoJpa(){
        super(BranchItem.class);
    }
    
}
