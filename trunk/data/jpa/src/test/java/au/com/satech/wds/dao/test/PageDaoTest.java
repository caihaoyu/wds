/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import au.com.satech.wds.model.Survey;
import au.com.satech.wds.dao.SurveyDao;
import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.PageBranchDao;
import au.com.satech.wds.dao.PageDao;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author sam
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional()
public class PageDaoTest extends BaseDaoTestCase {
    
    @Autowired
    private PageDao pDao;
    
    @Autowired
    private SurveyDao sDao;
    @Autowired 
    private PageBranchDao pBDao;
    
    private Page page1;
    private Page page2;
    private Page page3;
    private Survey survey;
    private PageBranch branch1;
    private PageBranch branch2;
    
    @Before
    public void prepareTestData(){
        page1 = new Page();
        page1.setPagetitle("Test Page One");
        page1.setPageheader("Test Page One Page Header");
        page1.setPagefooter("Test Page One Page Footer");
        page1.setPageorder(1);
        
        page2 = new Page();
        page2.setPagetitle("Test Page Two");
        page2.setPageheader("Test Page Two Page Header");
        page2.setPagefooter("Test Page Two Page Footer");
        page2.setPageorder(2);
        
        page3 = new Page();
        page3.setPagetitle("Test Page three");
        page3.setPageheader("Test Page three Page Header");
        page3.setPagefooter("Test Page three Page Footer");
        page3.setPageorder(3);
        
        survey = new Survey();
        survey.setSurveytitle("Test Survey");
        
        branch1 = new PageBranch();
        branch1.setMain(true);
        branch1.setBranchname("Test branch 1 (default)");
        
        branch2 = new PageBranch();
        branch2.setMain(false);
        branch2.setBranchname("Test branch 2");
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testGetAllPages(){
        page1 = pDao.save(page1);
        page2 = pDao.save(page2);
        page3 = pDao.save(page3);
        List<Page> pages = pDao.getAll();
        assertTrue(pages.size()>0);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testAddPage(){
        int numberOfPageBefore = pDao.getAll().size();
        page1 = pDao.save(page1);
        int numberOfPageAfter = pDao.getAll().size();
        assertTrue(numberOfPageBefore+1 == numberOfPageAfter);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testAssignPageToSurvey(){
        page1 = pDao.save(page1);
        page2 = pDao.save(page2);
        page3 = pDao.save(page3);
        int numberOfPageBefore = survey.getPages().size();
        survey.getPages().add(page1);
        survey.getPages().add(page2);
        survey.getPages().add(page3);
 
        log.debug("Survey id: "+survey.getSid());
        log.debug("survey.getPages().size() before persist: "+survey.getPages().size());
        
        survey = sDao.save(survey);
        int surveyId = survey.getSid();
        log.debug("survey.getPages().size(): "+survey.getPages().size());
        assertTrue(sDao.get(surveyId).getPages().size() == (numberOfPageBefore+3));
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testAssignPageBranchToPage(){
        branch1 = pBDao.save(branch1);
        branch2 = pBDao.save(branch2);
        int numberOfPageBefore = survey.getPages().size();
        page1.getPagebranches().add(branch1);
        page1.getPagebranches().add(branch2);
        
        page1 = pDao.save(page1);
        int page1Id = page1.getPageid();
        page1 = null;
        page1 = pDao.get(page1Id);
        assertTrue(page1.getPagebranches().size() == (numberOfPageBefore+2));
    }
}
