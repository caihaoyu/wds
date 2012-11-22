/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Result;
import au.com.satech.wds.service.BranchItemRuleManager;
import au.com.satech.wds.service.ConditionManager;
import au.com.satech.wds.service.ResultManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *测试BranchItemRuleManager的方法
 * @author wu
 */
public class BranchItemRuleManagerTest extends BaseManagerTestCase{
    
    @Autowired
    private BranchItemRuleManager branchItemRuleManager;
    
    @Autowired
    private ConditionManager cMgr;
    
    @Autowired
    private ResultManager rMgr;
    
    private BranchItemRule branchItemRule;
    private Result result1;
    private Result result2;
    private Condition condition1;
 
     /**
     * 测试前实例化BranchItemRule Result对象
     */   
    @Before
    public void set(){
        condition1 = new Condition();
        condition1.setConditionType(1);
        condition1 = cMgr.save(condition1);
        

        
        branchItemRule = new BranchItemRule();
        branchItemRule.setCondition(condition1);
        result1 = new Result();
        result2 = new Result();

        
        branchItemRule.setRulename("rule");
        branchItemRule.setRuletype(2);
        
        result1.setDisplays(1);
        result1.setPagebranchid(2);
        result2.setDisplays(1);
        result2.setPagebranchid(2);
    }
    /**
     * 测试BranchItemRuleManager的save和get以及getAll方法
     */
    @Test
    public void testSave() {
        int oldSize = branchItemRuleManager.getAll().size();
        branchItemRuleManager.save(branchItemRule);
        int newSize = branchItemRuleManager.getAll().size();
       assertTrue(oldSize+1==newSize);
    }
    /**
     * 测试BranchItemRuleManager的remove方法
     */
    @Test
    public void testRemove() {
        branchItemRule = branchItemRuleManager.save(branchItemRule);
        int oldSize = branchItemRuleManager.getAll().size();
        branchItemRuleManager.remove(branchItemRule.getRuleid());
        int newSize = branchItemRuleManager.getAll().size();
        assertTrue(oldSize-1==newSize);
    }
    /**
     * 测试BranchItemRule关联到Result的方法
     */
    @Test
    public void testRuleAndResult() {
        branchItemRule = branchItemRuleManager.save(branchItemRule);
        int ruleId = branchItemRule.getRuleid();
        int oldResultSize = branchItemRuleManager.get(ruleId).getResults().size();
        branchItemRule.getResults().add(result1);
        branchItemRule.getResults().add(result2);
        int newResultSize = branchItemRuleManager.get(ruleId).getResults().size();
        assertTrue(oldResultSize+2==newResultSize);
    }
    /**
     * 测试BranchItemRule关联到Condition的方法
     */
    @Test
    public void testRuleAndCondition(){
    
        
        branchItemRule = branchItemRuleManager.save(branchItemRule);
        assertNotNull(branchItemRuleManager.get(branchItemRule.getRuleid()).getCondition());
        
        int oldRuleSize = branchItemRuleManager.getAll().size();
        int oldConditionSize = cMgr.getAll().size();
        branchItemRuleManager.remove(branchItemRule.getRuleid());
        int newRuleSize = branchItemRuleManager.getAll().size();
        int newConditionSize = cMgr.getAll().size();
        
        assertEquals(oldRuleSize-1, newRuleSize);
        assertEquals(oldConditionSize-1, newConditionSize);
    }
    
    /**
     * 测试getResultsById()
     */
    @Test
    public void testGetResultsById(){
        result1 = rMgr.save(result1);
        result2 = rMgr.save(result2);
        
        List<Result> list = new ArrayList<Result>();
        list.add(result1);
        list.add(result2);
        branchItemRule.setResults(list);
        branchItemRule = branchItemRuleManager.save(branchItemRule);
        
        list = branchItemRuleManager.getResultsById(branchItemRule.getRuleid());
        
        assertTrue(list.size()>=2);
    }
    
    /**
     * 测试getHTMLRuleTitle（）
     */
    public void testGetHTMLRuleTitle(){
        
    }
}
