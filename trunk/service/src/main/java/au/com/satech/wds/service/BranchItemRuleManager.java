/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service;

import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Result;
import java.util.List;

/**
 *
 * @author wu
 */
public interface BranchItemRuleManager extends GenericManager<BranchItemRule, Integer> {
    /**
     * 根据ruleId 获得branchItemRule的result集合，返回一个result的list集合
     * @param ruleId  BranchItem的Id号
     * @return list result集合。
     */    
    public List<Result> getResultsById(Integer ruleId);
    
    public String getHTMLRuleTitle(BranchItemRule rule);
    
    public void romveBranchItemRule(Integer ruleId);
}
