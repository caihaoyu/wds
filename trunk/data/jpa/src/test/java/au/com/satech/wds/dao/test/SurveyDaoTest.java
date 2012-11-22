/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.BranchItemDao;
import au.com.satech.wds.dao.BranchItemRuleDao;
import au.com.satech.wds.dao.ConditionDao;
import au.com.satech.wds.dao.PageBranchDao;
import au.com.satech.wds.dao.PageDao;
import au.com.satech.wds.dao.ResultDao;
import au.com.satech.wds.dao.SurveyDao;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Result;
import au.com.satech.wds.model.Survey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
/**
 *这个类是用来测试SurveyDao及其所关联的所有类的方法
 * 已注入所有关联类的属性
 * @author xiong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional()
public class SurveyDaoTest extends BaseDaoTestCase {
    @Autowired
    SurveyDao dao;
    @Autowired
    ConditionDao cDao;
    @Autowired
    BranchItemDao bDao;
    @Autowired
    PageBranchDao pBDao;
    @Autowired
    PageDao pDao;
    @Autowired
    ResultDao rDao;
    @Autowired
    BranchItemRuleDao bRDao;
    
    
    private Condition condition1 = new Condition(true,0,0);
    private Condition condition2 = new Condition(true,0,0);
    
    private Result result1 = new Result(1, 1, 1, 1, 1, "test result1");
    private Result result2 = new Result(2, 2, 2, 2, 2, "test result2");
    private List<Result> results = new ArrayList<Result>();
    
    private BranchItemRule branchItemRule1 = new BranchItemRule("test rulname 1", condition1, Integer.SIZE, results);
    private BranchItemRule branchItemRule2 = new BranchItemRule("test rulname 1", condition2, Integer.SIZE, results);
    private List<BranchItemRule> rules = new ArrayList<BranchItemRule>();
    
    private BranchItem branchItem1 = new BranchItem(true, 1, 1, rules);
    private BranchItem branchItem2 = new BranchItem(true, 2, 2, rules);
    private Set<BranchItem> branchItems = new HashSet<BranchItem>();
    private List<BranchItem> branchItemsList = new ArrayList<BranchItem> ();
    
    private PageBranch pageBranch1 = new PageBranch("test branchname 1 ", true, true, branchItems, branchItemsList);
    private PageBranch pageBranch2 = new PageBranch("test branchname 2 ", true, true, branchItems, branchItemsList);
    private Set<PageBranch> pageBranchs = new HashSet<PageBranch>();
    private List<PageBranch> pageBranchsList = new ArrayList<PageBranch>();
    
    private Page page1 = new Page(1, "test pagetitle 1", "test pageheader 1", "test pagefooter 1", pageBranchs, pageBranchsList);
    private Page page2 = new Page(2, "test pagetitle 2", "test pageheader 1", "test pagefooter 2", pageBranchs, pageBranchsList);
    
    private Survey survey1 = new Survey();
    private Survey survey2 = new Survey();
    private Survey survey3 = new Survey();
    @Before
    @Transactional
    public void prepareTestData(){
        condition1 = cDao.save(condition1);
        condition2 = cDao.save(condition2);
        result1 = rDao.save(result1);
        result2 = rDao.save(result2);

        
        branchItemRule1 = bRDao.save(branchItemRule1);
        branchItemRule2 = bRDao.save(branchItemRule2);

       
        branchItem1 = bDao.save(branchItem1);
        branchItem2 = bDao.save(branchItem2);

        pageBranch1 = pBDao.save(pageBranch1);
        pageBranch2 = pBDao.save(pageBranch2);
        
        page1 = pDao.save(page1);
        page2 = pDao.save(page2);

        
        survey1 = dao.save(survey1);//测试前先获得一个含有id的Survey对象
        survey2 = dao.save(survey2);
        survey3 = dao.save(survey3);
    }
 /*
 * 测试Survey关联到其下属类Page BranchItem BranchItemRule等的方法
 */     
    @Test
    public void assignSomeObjToSurvey(){
        branchItemRule1.getResults().add(result1);
        branchItemRule1.setCondition(condition1);
        branchItem2.getRules().add(branchItemRule1);
        pageBranch1.getItems().add(branchItem2);
        page1.getPagebranches().add(pageBranch1);
        survey1.getPages().add(page1);
        int survey1Id = survey1.getSid();
        int page1Id = page1.getPageid();
        int pageBranch1Id = pageBranch1.getBranchid(); 
        int branchItem2Id = branchItem2.getBranchitemid();
        int branchItemRule1Id = branchItemRule1.getRuleid();
        dao.save(survey1);
        assertTrue(dao.get(survey1Id).getPages().size()==1);
        assertTrue(pDao.get(page1Id).getPagebranches().size()==1);
        assertTrue(pBDao.get(pageBranch1Id).getItems().size()==1);
        assertTrue(bDao.get(branchItem2Id).getRules().size()==1);
        assertTrue(bRDao.get(branchItemRule1Id).getResults().size()==1);
        assertTrue(bRDao.get(branchItemRule1Id).getCondition() == condition1);
    }
 /*
 * 测试Survey的save方法
 */    
    
    @Test
    @Transactional(readOnly = false)
    public void testSaveSurvey(){
        int survey1Id = survey1.getSid();
        assertNotNull(dao.get(survey1Id));
    }
  /*
 * 测试Survey的get方法
 */
    @Test
    @Transactional(readOnly=true)
    public void testGetSurvey(){
        int survey1Id = survey1.getSid();
        assertTrue(dao.get(survey1Id) == survey1);
    }
/*
 * 测试Survey的getAll方法
 */    
    @Test
    @Transactional(readOnly=false)
    public void testGetallSurvey(){
        assertTrue(dao.getAll().size() >= 3);      
    }
/*
 * 测试Survey的remove方法
 */    
    @Test
    @Transactional(readOnly=false)
    public  void testRemoveSurvey(){ 
        int beforeNumber = dao.getAll().size();
        dao.remove(survey2.getSid());
        int afterNumber = dao.getAll().size();
        assertTrue(afterNumber == beforeNumber - 1);
        // assertTrue(afterNumber < beforeNumber);
        
    }
/*
 * 测试Survey的isExits方法
 */    
    @Test
    @Transactional(readOnly=true)
    public void testIsExitsSurvey(){
        int survey1Id = survey1.getSid();
        assertTrue(dao.exists(survey1Id));
    }
    
  

}
