/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Survey;
import au.com.satech.wds.service.BranchItemManager;
import au.com.satech.wds.service.ConditionManager;
import au.com.satech.wds.service.PageBranchManager;
import au.com.satech.wds.service.PageManager;
import au.com.satech.wds.service.QuestionManager;
import au.com.satech.wds.service.SurveyManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 测试PageManager实现类的方法的测试类
 * @author xiong
 */
public class PageManagerTest extends BaseManagerTestCase{
   private Log log = LogFactory.getLog(getClass());
    
    @Autowired
    PageManager mgr;
    
    @Autowired
    PageBranchManager pBMgr;
    
    @Autowired
    QuestionManager qMgr;
   
    @Autowired
    BranchItemManager iMgr;
    
    @Autowired
    ConditionManager cMgr;
    
    @Autowired
    SurveyManager sMgr;

            
    private PageBranch pageBranch1;
    private PageBranch pageBranch2;
    private PageBranch pageBranch3;
    
    private BranchItem branchItem1;
    private BranchItem branchItem2;
    
    private Question question1;
    private Question question2;
    
    private Page page1;
    private Page page2;
    
    private Survey survey;
    
    /**
     * 测试前先创建所需对象并且给其属性赋值
     */
    @Before
    public void setup(){
        
        branchItem1 = new BranchItem();
        branchItem1.setHidden(false);
        branchItem1.setItemorder(1);
        branchItem2 = new BranchItem();
        branchItem2.setHidden(false);
        branchItem2.setItemorder(2);
        
        
        pageBranch1 = new PageBranch();
        pageBranch1.setMain(true);
        pageBranch1.setBranchname("Test branch 1");        
        pageBranch2 = new PageBranch();
        pageBranch2.setMain(false);
        pageBranch2.setBranchname("Test branch 2");     
        pageBranch3 = new PageBranch();
        pageBranch3.setMain(false);
        pageBranch3.setBranchname("Test branch 3");
        
        
        question1 = new Question();
        question1.setQuestiontype(1);
        question1.setQuestiontitle("Test question 1");        
        question2 = new Question();
        question2.setQuestiontype(3);
        question2.setQuestiontitle("Test question 2");
        
        page1 = new Page();
        page2 = new Page();
        
        survey = new Survey();
        
        question1 = qMgr.save(question1);
        question2 = qMgr.save(question2);
        branchItem1.setQuestionid(question1.getQuestionid());
        branchItem1 = iMgr.save(branchItem1);
        branchItem2.setQuestionid(question2.getQuestionid());
        branchItem2 = iMgr.save(branchItem2);
        
        pageBranch1.getItems().add(branchItem1);
        pageBranch2.getItems().add(branchItem2);
        
        pageBranch1 = pBMgr.save(pageBranch1);
        pageBranch2 = pBMgr.save(pageBranch2);
        page1.getPagebranches().add(pageBranch1);
        page1.getPagebranches().add(pageBranch2);
        
        survey.getPageList().add(page1);
        survey.getPageList().add(page2);
    }

    /**
     * 测试PageManager的的savePage方法
     */
    @Test
    
    public void testAddPage(){
        page1 = mgr.save(page1);
        //验证是存储以后的page是有含有Id
        assertNotNull(page1.getPageid());
    }
    /**
     * 测试PageManger的getAll()方法
     */
    @Test
    public void testGetAll(){
        page1 = mgr.save(page1);
        page2 = mgr.save(page2);
  
        assertTrue(mgr.getAll().size() > 0);
    }
    /**
     * 测试PageManger的get(Integer pangeId)方法
     */
    @Test
    public void testGetPage(){
        page1 = mgr.save(page1);
        int page1Id = page1.getPageid();
        page1 = null;
        assertNull(page1);
        page1 = mgr.get(page1Id);
        assertNotNull(page1);
    }
    /**
     * 测试PageManger的remove(Page page)方法
     */
    @Test
    public void testDeletePage(){
        page1 = mgr.save(page1);
        page2 = mgr.save(page2);
        int numberOfPagesBeforeDelete = mgr.getAll().size();
        mgr.remove(page1.getPageid());
        int numberOfPagesAfterDelete = mgr.getAll().size();
        assertTrue(numberOfPagesBeforeDelete-1 == numberOfPagesAfterDelete);
    }
    /**
     * 测试Page赋值到Survey的方法
     */
    @Test
    public void testAssignPageToSurvey(){
        page1 = mgr.save(page1);
        page2 = mgr.save(page2);
        
        survey.getPages().add(page1);
        survey.getPages().add(page2);
        
        survey = sMgr.save(survey);
        
        int surveyId = survey.getSid();
        survey=sMgr.get(surveyId);
        survey = null;
        assertNull(survey);
        survey = sMgr.get(surveyId);
        assertNotNull(survey);
        assertTrue(survey.getPages().size() == 2);
    }
    /**
     * 测试Page附加上PageBranches（含有questions）的pageManager类的save方法
     */
    @Test
    public void testAttachPageBranchesWhithQuestionsToPage(){
        page1= mgr.save(page1);
        int page1Id = page1.getPageid();
        page1 = null;
        assertNull(page1);
        page1 = mgr.get(page1Id);
        assertTrue(page1.getPagebranches().size() == 2);
    }
    /**
     * 测试PageBranchManager的getHiddens()方法
     */
    @Test
    public void testgetPageBranchsByPageId(){
       page1= mgr.save(page1);
       int page1Id = page1.getPageid();
       assertTrue(mgr.getPageBranchsByPageId(page1Id).size() == 2); 
    }

    /*
     * 测试remove page,是否remove branch
     */
    @Test
    public void testRemovePageAndBranch(){
        pageBranch1 = pBMgr.save(pageBranch1);
        pageBranch2 = pBMgr.save(pageBranch2);
        Set<PageBranch> set = new HashSet<PageBranch>();
        set.add(pageBranch1);
        set.add(pageBranch2);
        page1.setPagebranches(set);
        page1 = mgr.save(page1);
        
        int oldPageSize = mgr.getAll().size();
        int oldBranchSize = pBMgr.getAll().size();
        mgr.remove(page1.getPageid());
        int newPageSize = mgr.getAll().size();
        int newBranchSize = pBMgr.getAll().size();
        
        assertEquals(oldPageSize-1, newPageSize);
        assertEquals(oldBranchSize-2, newBranchSize);
    }
    
    /**
     * 测试getPageBranchsByPageId（）
     */
    @Test
    public void testGetPageBranchsByPageId(){
        pageBranch1 = pBMgr.save(pageBranch1);
        pageBranch2 = pBMgr.save(pageBranch2);
        Set<PageBranch> set = new HashSet<PageBranch>();
        set.add(pageBranch1);
        set.add(pageBranch2);
        page1.setPagebranches(set);
        page1 = mgr.save(page1);
        
        List<PageBranch> list = mgr.getPageBranchsByPageId(page1.getPageid());
        assertTrue(list.size()>=2);
    }
    
    /*
     * 测试savePageBranchWithPage（）
     */
    @Test
    public void testSavePageBranchWithPage(){
        pageBranch3 = pBMgr.save(pageBranch3);
        page1 = mgr.save(page1);
        
        int oldBranchSize = page1.getPagebranches().size();
        mgr.savePageBranchWithPage(page1.getPageid(), pageBranch3);
        int newBranchSize = page1.getPagebranches().size();
        
        assertEquals(oldBranchSize+1, newBranchSize);
    }
    
}
