/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import java.util.List;
import au.com.satech.wds.service.BranchItemManager;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.service.PageBranchManager;
import au.com.satech.wds.service.PageManager;
import au.com.satech.wds.service.QuestionManager;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 *此类用于测试PageBranchManager的方法
 * @author sam
 */
public class PageBranchManagerTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(getClass());
    
    @Autowired
    PageBranchManager mgr;
    
    @Autowired
    QuestionManager qMgr;
    
    @Autowired
    PageManager pMgr;
    
    @Autowired
    BranchItemManager iMgr;
    
    private PageBranch pageBranch1;
    private PageBranch pageBranch2;
    
    private BranchItem branchItem1;
    private BranchItem branchItem2;
    
    private Question question1;
    private Question question2;
    
    private Page page;
    /**
     * 测试前先创建所需对象并且给其属性赋值
     */
    @Before
    public void setup(){
        pageBranch1 = new PageBranch();
        pageBranch1.setMain(true);
        pageBranch1.setBranchname("Test branch 1");    
        pageBranch1.setHaveItem(false);
        pageBranch2 = new PageBranch();
        pageBranch2.setMain(false);
        pageBranch2.setBranchname("Test branch 2");
        
        branchItem1 = new BranchItem();
        branchItem1.setHidden(false);
        branchItem1.setItemorder(1);
        branchItem2 = new BranchItem();
        branchItem2.setHidden(false);
        branchItem2.setItemorder(2);
        
        question1 = new Question();
        question1.setQuestiontype(1);
        question1.setQuestiontitle("Test question 1");        
        question2 = new Question();
        question2.setQuestiontype(3);
        question2.setQuestiontitle("Test question 2");
        
        page = new Page();
        page.setPagetitle("Test page");
    }
    /**
     * 测试PageBranchManager的saveBranch方法
     */
    @Test
    
    public void testAddPageBranch(){
        pageBranch1 = mgr.save(pageBranch1);
        pageBranch2 = mgr.save(pageBranch2);
        
        assertNotNull(pageBranch1.getBranchid());
    }
    /**
     * 测试PageBranchManger的getAll()方法
     */
    @Test
    public void testGetAll(){
        pageBranch1 = mgr.save(pageBranch1);
        pageBranch2 = mgr.save(pageBranch2);
  
        assertTrue(mgr.getAll().size() > 0);
    }
    /**
     * 测试PageBranchManger的get(Integer Pageid)方法
     */
    @Test
    public void testGetPageBranch(){
        pageBranch1 = mgr.save(pageBranch1);
        pageBranch2 = mgr.save(pageBranch2);
        int pageBranch1Id = pageBranch1.getBranchid();
        pageBranch1 = null;
        assertNull(pageBranch1);
        pageBranch1 = mgr.get(pageBranch1Id);
        assertNotNull(pageBranch1);
    }
    /**
     * 测试PageBranchManger的remove(PageBranch pageBranch)方法
     */
    @Test
    public void testDeletePageBranch(){
        pageBranch1 = mgr.save(pageBranch1);
        pageBranch2 = mgr.save(pageBranch2);
        
        int numberOfPageBranchesBeforeDelete = mgr.getAll().size();
        
        mgr.remove(pageBranch1.getBranchid());
        
        int numberOfPageBranchesAfterDelete = mgr.getAll().size();
        
        assertTrue(numberOfPageBranchesBeforeDelete-1 == numberOfPageBranchesAfterDelete);
    }
    /**
     * 测试PageManger的关联到Page的方法
     */
    @Test
    public void testAssignPageBranchesToPage(){
        
        pageBranch1 = mgr.save(pageBranch1);
        pageBranch2 = mgr.save(pageBranch2);
        
        page.getPagebranches().add(pageBranch1);
        page.getPagebranches().add(pageBranch2);
        
        page = pMgr.save(page);
        
        int pageId = page.getPageid();
        page=pMgr.get(pageId);
        page = null;
        assertNull(page);
        
        page = pMgr.get(pageId);
        assertNotNull(page);
        assertTrue(page.getPagebranches().size() == 2);
    }
    /**
     * 测试PageBranchManger附加上Qustions的方法
     */
    @Test
    public void testAttachQuestionsToPageBranch(){
        question1 = qMgr.save(question1);
        question2 = qMgr.save(question2);
        
        branchItem1.setQuestionid(question1.getQuestionid());
        branchItem1 = iMgr.save(branchItem1);
        branchItem2.setQuestionid(question2.getQuestionid());
        branchItem2 = iMgr.save(branchItem2);
        
        pageBranch1.getItems().add(branchItem1);
        pageBranch1.getItems().add(branchItem2);
        
        pageBranch1 = mgr.save(pageBranch1);
        
        int pageBranch1Id = pageBranch1.getBranchid();
        
        pageBranch1 = null;
        assertNull(pageBranch1);
        
        pageBranch1 = mgr.get(pageBranch1Id);
        assertTrue(pageBranch1.getItems().size() == 2);
    }
    /**
     * 测试PageBranchManager的getHiddens()方法
     */
    @Test
    public void testGetHiddens(){
        question1 = qMgr.save(question1);
        question2 = qMgr.save(question2);
        
        branchItem1.setQuestionid(question1.getQuestionid());
        branchItem1.setHidden(true);
        branchItem1 = iMgr.save(branchItem1);
        
        branchItem2.setQuestionid(question2.getQuestionid());
        branchItem2.setHidden(true);
        branchItem2 = iMgr.save(branchItem2);
        
        pageBranch1.getItems().add(branchItem1);
        pageBranch1.getItems().add(branchItem2);
        
        pageBranch1 = mgr.save(pageBranch1);
        
        int pageBranch1Id = pageBranch1.getBranchid();
        
        List<BranchItem> hiddens = mgr.getHiddens(pageBranch1Id);
        assertTrue(hiddens.size() == 2);
    }
    
    /**
     * 测试删除branch,是否连带删除item
     */
    @Test
    public void testRemoveBranchAndItem(){
        branchItem1 = iMgr.save(branchItem1);
        branchItem2 = iMgr.save(branchItem2);
        
        Set<BranchItem> set = new HashSet<BranchItem>();
        set.add(branchItem1);
        set.add(branchItem2);
        
        pageBranch1.setItems(set);
        pageBranch1 = mgr.save(pageBranch1);
        
        int oldItemSize = iMgr.getAll().size();
        int oldBranchSize = mgr.getAll().size();
        mgr.remove(pageBranch1.getBranchid());
        int newItemSize = iMgr.getAll().size();
        int newBranchSize = mgr.getAll().size();
        
        assertEquals(oldItemSize-2, newItemSize);
        assertEquals(oldBranchSize-1, newBranchSize);
    }
    
    /**
     * 测试removeBranchItemFromBranch（）
     */
    @Test
    public void testRemoveBranchItemFromBranch(){
        branchItem1 = iMgr.save(branchItem1);
        branchItem2 = iMgr.save(branchItem2);
        
        Set<BranchItem> set = new HashSet<BranchItem>();
        set.add(branchItem1);
        set.add(branchItem2);
        
        pageBranch1.setItems(set);
        pageBranch1 = mgr.save(pageBranch1);
        
        int oldItemSize1 = pageBranch1.getItems().size();
        int oldItemSize2 = iMgr.getAll().size();
        mgr.removeBranchItemFromBranch(branchItem1.getBranchitemid(), pageBranch1.getBranchid());
        int newItemSize1 = pageBranch1.getItems().size();
        int newItemSize2 = iMgr.getAll().size();
        
        assertEquals(oldItemSize1-1, newItemSize1);
        assertEquals(oldItemSize2-1, newItemSize2);
    }
    
    /**
     * 测试addQuestionToBranch（）
     */
    @Test
    public void testAddQuestionToBranch(){
        pageBranch1 = mgr.save(pageBranch1);
        question1 = qMgr.save(question1);
        
        int oldItemSize = iMgr.getAll().size();
        mgr.addQuestionToBranch(pageBranch1.getBranchid(), question1.getQuestionid());
        int newItemSize = iMgr.getAll().size();
        assertEquals(oldItemSize+1, newItemSize);
        assertTrue(pageBranch1.isHaveItem());
    }
    
    /**
     * 测试addItemToBranch（）
     */
    @Test
    public void testAddItemToBranch(){
        branchItem1 = iMgr.save(branchItem1);
        pageBranch1 = mgr.save(pageBranch1);
        
        int oldItemSize = pageBranch1.getItems().size();
        mgr.addItemToBranch(pageBranch1.getBranchid(),branchItem1);
        int newItemSize = pageBranch1.getItems().size();
        
        assertEquals(oldItemSize+1, newItemSize);
        assertTrue(pageBranch1.isHaveItem());
    }
}
