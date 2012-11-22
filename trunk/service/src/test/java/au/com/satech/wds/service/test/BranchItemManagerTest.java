/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Question;
import static org.junit.Assert.*;
import au.com.satech.wds.service.BranchItemManager;
import au.com.satech.wds.service.BranchItemRuleManager;
import au.com.satech.wds.service.PageBranchManager;
import au.com.satech.wds.service.QuestionManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试BranchItemManagerImpl的方法
 * @author wu
 */
public class BranchItemManagerTest extends BaseManagerTestCase{

    @Autowired
    private BranchItemManager branchItemManager;
    
    @Autowired
    private PageBranchManager pbm;
    
    @Autowired
    private BranchItemRuleManager bmgr;
    
    @Autowired
    private QuestionManager qmgr;
    
    private BranchItem branchItem;
    private BranchItemRule branchItemRule1;
    private BranchItemRule branchItemRule2;
    private BranchItemRule branchItemRule3;
    private Condition condition;
    private Question question1;
    private Question question2;
    
     /**
     * 测试前创建BranchItem 和BranchItemRule对象并且给部分属性赋值
     */   
    @Before
    public void set(){
        branchItem = new BranchItem();
        branchItemRule1 = new BranchItemRule();
        branchItemRule2 = new BranchItemRule();
        branchItemRule3 = new BranchItemRule();
        condition = new Condition();
        question1 = new Question();
        question2 = new Question();
    
        branchItem.setHidden(true);
        branchItem.setItemorder(1);
        branchItem.setQuestionid(2);
        
        branchItemRule1.setRulename("This is a rule");
        branchItemRule1.setRuletype(2);
        branchItemRule1.setRulename("This is a rule");
        branchItemRule1.setRuletype(2);
        branchItemRule1.setCondition(condition);
        
        branchItemRule2.setRulename("rule2");
        branchItemRule2.setRuletype(2);
        branchItemRule3.setRulename("rule3");
        branchItemRule3.setRuletype(3);
        
        question1.setQuestiontitle("q1");
        question1.setQuestiontype(2);
        question1.setColumntype(2);
        
        question2.setQuestiontitle("q2");
        question2.setQuestiontype(2);
        question2.setColumntype(2);
    }
    /**
     * 测试BranchItemManagerImpl的Save 和 get 以及getAll方法 
     */
    @Test
    public void testAddBranchItem() throws  Exception{
       int oldSize = branchItemManager.getAll().size();
       branchItem = branchItemManager.save(branchItem);
       int newSize = branchItemManager.getAll().size();
       assertTrue(oldSize+1==newSize);
    }
    /**
     * 测试BranchItemManagerImpl的remove方法
     */
    @Test
    public void testRemoveBranchItem(){
        branchItem = branchItemManager.save(branchItem);
        int oldSize = branchItemManager.getAll().size();
        branchItemManager.remove(branchItem.getBranchitemid());
        int newSize = branchItemManager.getAll().size();
       assertTrue(oldSize-1==newSize);
       
    }
    /**
     * 测试BranchItem关联到BranchItemRule的方法
     */
    @Test
    public void testBranchItemAndBranchItemRule(){
        branchItem = branchItemManager.save(branchItem);
        int branchItemIdI = branchItem.getBranchitemid();
        int oldRuleSize = branchItemManager.get(branchItemIdI).getRules().size();
        branchItem.getRules().add(branchItemRule1);
        branchItem.getRules().add(branchItemRule2);
        int newRuleSize = branchItemManager.get(branchItemIdI).getRules().size();
       assertTrue(oldRuleSize+2==newRuleSize);
    }
     /**
     * 测试BranchItemManager的getRulesByItemId()方法
     */
    @Test
    public void testGetRulesByItemId(){
        branchItem = branchItemManager.save(branchItem);
        branchItem.getRules().add(branchItemRule1);
        branchItem.getRules().add(branchItemRule2);
        assertTrue(branchItemManager.getRulesByItemId(branchItem.getBranchitemid()).size() == 2);
    }


    /**
     * 测试删除BranchItem层是否会连带删除Rule层
     */
    @Test
    public void testRemoveItemAndRule(){
        branchItemRule2 = bmgr.save(branchItemRule2);
        branchItemRule3 = bmgr.save(branchItemRule3);
        List<BranchItemRule> list = new ArrayList<BranchItemRule>();
        list.add(branchItemRule2);
        list.add(branchItemRule3);
        branchItem.setRules(list);
        branchItem = branchItemManager.save(branchItem);
        
        int oldBranchSize = branchItemManager.getAll().size();
        int oldRuleNum = bmgr.getAll().size();
        branchItemManager.remove(branchItem.getBranchitemid());
        int newBranchSize = branchItemManager.getAll().size();
        int newRuleNum = bmgr.getAll().size();
        assertEquals(oldBranchSize - 1, newBranchSize);
        assertEquals(oldRuleNum - 2, newRuleNum);
    }
   
    /**
     * 测试getRuleNamebyItemId()
     */
    @Test
    public void testGetRuleNamebyItemId(){
        branchItemRule2 = bmgr.save(branchItemRule2);
        branchItemRule3 = bmgr.save(branchItemRule3);
        String oldRuleTitle1 = branchItemRule2.getRulename();
        List<BranchItemRule> list = new ArrayList<BranchItemRule>();
        list.add(branchItemRule2);
        list.add(branchItemRule3);
        branchItem.setRules(list);
        branchItem = branchItemManager.save(branchItem);
        
        String newOldRuleTitle1 = branchItemManager.getRuleNamebyItemId(branchItem.getBranchitemid());
        log.info(newOldRuleTitle1);
        assertEquals(oldRuleTitle1, newOldRuleTitle1);
    }
    
    @Test
    public void testGetRuleNotTill(){
        branchItemRule2 = bmgr.save(branchItemRule2);
        branchItemRule3 = bmgr.save(branchItemRule3);
        List<BranchItemRule> list = new ArrayList<BranchItemRule>();
        list.add(branchItemRule2);
        list.add(branchItemRule3);
        branchItem.setRules(list);
        branchItem = branchItemManager.save(branchItem);
        
        BranchItemRule rule = branchItemManager.getRuleNotTill(branchItem.getBranchitemid());
        
        assertEquals(rule.getRuleid(), branchItemRule2.getRuleid());
    }
    
    @Test
    public void testIsQuestionInUse()
    {
        log.info("############" + branchItemManager.isQuestionInUse(942));
    }
}
