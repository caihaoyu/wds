/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import java.util.List;

/**
 *
 * @author sam
 */
public interface BranchItemManager extends GenericManager<BranchItem, Integer> {
    /**
    *通过Item id获取该Item的Rule
    * @param BranchItem ID  
    * @return BranchItemRule
    */
    public BranchItemRule getRule(Integer id);
    /**
    *获得指定branchItem下的List<BranchItemRule>
    * @param id  
    * @return List<BranchItemRule>
    */
    public List<BranchItemRule> getRulesByItemId(Integer id);
    
    
    /**
    *通过Item id获取该Item的Rule中的ruleName(非HTML版）
    * 当前只有一个Rule，所以获取的是第一条
    * @param id BranchItem ID
    * @return BranchItemRule的rulename
    */
    public String getRuleNamebyItemId(Integer itemid);
    
    /**
    *获得指定branchItem下的List关联到scenariocc<BranchItemRule>
    * @param id  
    * @return List<BranchItemRule>
    */
    public List<BranchItemRule> getRulesListTillScenariocc(Integer id);
    
    public BranchItemRule getRuleNotTill(Integer id);
    
    /**
     * 检测question是否被使用。
     * @param questionId  
     * @return boolean
     */
    public boolean isQuestionInUse(Integer questionId);
}
