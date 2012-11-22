/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.PageBranchDao;
import au.com.satech.wds.model.PageBranch;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("pageBranchDao")
public class PageBranchDaoJpa extends GenericDaoJpa<PageBranch, Integer> implements PageBranchDao {
    
    public PageBranchDaoJpa(){
        super(PageBranch.class);
    }
}
