/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Survey;
import au.com.satech.wds.service.PageManager;
import au.com.satech.wds.service.SurveyManager;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sam
 */
public class SurveyManagerTest extends BaseManagerTestCase {
    @Autowired
    private SurveyManager smgr;
    @Autowired
    private PageManager pmgr;
    
    private Survey survey;
    private Page page1;
    private Page page2;
    private BranchItem branchItem;
    private PageBranch pageBranch;
    private Question question;
    private Answer answer;

    
    @Before
    public void setUp() {
        question = new Question();
        question.setQuestiontype(1);
        question.setQuestiontitle("Test question");
        
        branchItem = new BranchItem();
        branchItem.setHidden(true);
        branchItem.setItemorder(1);
        
        pageBranch = new PageBranch();
        pageBranch.setBranchname("Test page branch");
        pageBranch.setMain(true);
    
        
        answer = new Answer();
        answer.setAnswertitle("Test answer");
        
        page1 = new Page();
        page2 = new Page();
        page1.setPagetitle("Test page 1");
        page2.setPagetitle("Test page 2");
        
        
        
        survey = new Survey();
        survey.setSurveytitle("Test survey");
        survey.setActive(true);
        survey.setUsecookie(true);
        survey.setAllowsave(true);
        survey.setAttributedescriptions(true);
        

        
    }
    
    @Test
    public void testAddChainedSurvey(){
        question.getAnswers().add(answer);
        branchItem.setQuestionid(question.getQuestionid());
        pageBranch.getItems().add(branchItem);
        page1.getPagebranches().add(pageBranch);
        survey.getPages().add(page1);
        
        survey = smgr.save(survey);

        int surveyId = survey.getSid();
        
        survey = null;
        
        survey = smgr.get(surveyId);
        assertTrue(survey.getActive());
        assertTrue(survey.getAllowsave());
        assertTrue(survey.getAttributedescriptions());
        assertTrue(survey.getUsecookie());
        assertTrue(survey.getPages().size() == 1);
    }
    
    @Test
    public void testAddPageToSurvey(){
        survey = smgr.save(survey);
        
        int sid = survey.getSid();
        
        assertTrue(survey.getPages().isEmpty());
        
        survey = null;
        
        survey = smgr.addPagetoSurvey(sid, page1);
        
        assertTrue(survey.getPages().size()>0);
    }
    
    @Test
    public void testRemovePageFromSurvey(){
        survey = smgr.save(survey);
        page1 = pmgr.save(page1);
        
        survey = smgr.addPagetoSurvey(survey.getSid(), page1);
        assertTrue(survey.getPages().size() == 1);
        
        survey = smgr.removePageFromSurvey(survey.getSid(), page1.getPageid());
        
        assertTrue(survey.getPages().isEmpty());
    }
    @Test
    public void testGetPageListTillItem(){
        pageBranch.getItemList().add(branchItem);
        pageBranch.setHaveItem(true);
        page1.getPageBranchList().add(pageBranch);
        page2.getPageBranchList().add(pageBranch);
        
        survey.getPageList().add(page1);
        survey.getPageList().add(page2);
        survey = smgr.save(survey);
        int sid = survey.getSid();
        assertNotNull(smgr.getPageListTillItem(sid));
    }
    @Test
    public void testGenerateSurveyTree(){
        pageBranch.getItemList().add(branchItem);
        pageBranch.setHaveItem(true);
        page1.getPageBranchList().add(pageBranch);
        page2.getPageBranchList().add(pageBranch);
        
        survey.getPageList().add(page1);
        survey.getPageList().add(page2);
        survey = smgr.save(survey);
        int sid = survey.getSid();
        assertNotNull(smgr.generateSurveyTree(sid));
    }
     
    @Test
    public void testRemoveSurveyAndPage(){
        page1 = pmgr.save(page1);
        page2 = pmgr.save(page2);
        
        Set<Page> set = new HashSet<Page>();
        set.add(page1);
        set.add(page2);
        survey.setPages(set);
        survey = smgr.save(survey);
        
        int oldPageSize = pmgr.getAll().size();
        int oldSurveySize = smgr.getAll().size();
        smgr.remove(survey.getSid());
        int newPageSize = pmgr.getAll().size();
        int newSurveySize = smgr.getAll().size();
        
        assertEquals(oldSurveySize-1, newSurveySize);
        assertEquals(oldPageSize-2, newPageSize);
    }
    
    /**
     * 测试loadSurveyBySurveyTitle()
     */
    @Test
    public void testLoadSurveyBySurveyTitle(){
        survey = smgr.save(survey);
        int oldSurveyId = survey.getSid();
        survey = smgr.loadSurveyBySurveyTitle("Test survey");
        int newSurveyId = survey.getSid();
        
        assertEquals(oldSurveyId, newSurveyId);
    }
    
    /**
     * 测试addPagetoSurvey()
     */
    @Test
    public void testAddPagetoSurvey(){
        survey = smgr.save(survey);
        
        int pageSize = survey.getPages().size();
        int oldSurveyId = survey.getSid();
        survey = smgr.addPagetoSurvey(survey.getSid(), page1);
        int newSurveyId = survey.getSid();
        int newPageSize = survey.getPages().size();
        
        assertEquals(pageSize+1, newPageSize);
        assertEquals(oldSurveyId, newSurveyId);
    }
    
    /**
     * 测试saveSurveyAndPage()
     */
    @Test
    public void testSaveSurveyAndPage(){
        survey = smgr.save(survey);
        
        int pageSize = survey.getPages().size();
        int pageId = smgr.saveSurveyAndPage(survey.getSid(), page1);
        int newPageSize = survey.getPages().size();
        
        assertEquals(pageSize+1, newPageSize);
        assertNotNull(pageId);
    }
    
    /**
     * 测试getPagesList()
     */
    @Test
    public void testGetPagesList(){
        
    }
    
    /**
     * 测试getPageListTillRule()
     */
    @Test
    public void testGetPageListTillRule(){
        
    }
    
    /**
     * 测试lock() 和unlock()
     */
    @Test
    public void testLock(){
        survey = smgr.save(survey);
        
        smgr.lock(survey.getSid(), "Lock");
        assertEquals(survey.getLockUser(), "Lock");
        assertTrue(survey.isOccupy());
        
        smgr.unlock(survey.getSid());
        assertTrue(!survey.isOccupy());
    }
}
