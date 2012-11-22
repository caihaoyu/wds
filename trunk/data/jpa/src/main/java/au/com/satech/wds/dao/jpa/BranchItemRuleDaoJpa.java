/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.BranchItemRuleDao;
import au.com.satech.wds.model.BranchItemRule;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wu
 */
@Repository("branchItemRuleDao")
public class BranchItemRuleDaoJpa extends GenericDaoJpa<BranchItemRule, Integer> implements BranchItemRuleDao {
    public BranchItemRuleDaoJpa(){
        super(BranchItemRule.class);
    }
    
}
