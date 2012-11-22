/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.BranchItemDao;
import au.com.satech.wds.dao.BranchItemRuleDao;
import au.com.satech.wds.dao.ResultDao;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Result;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author wu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
@Transactional()
public class BranchItemRuleTest extends BaseDaoTestCase {
    @Autowired
    BranchItemRuleDao dao;
    
    @Autowired
    BranchItemDao bDao;
    
    @Autowired
    ResultDao rDao;
    
    private BranchItem bi1 = new BranchItem();
    private BranchItemRule bir1 = new BranchItemRule();
    private BranchItemRule bir2 = new BranchItemRule();
    private Result rs = new Result();
    
    @Before
    public void prepareTestData(){
        rs.setDisplays(2);
       
        bi1.setHidden(true);
        bi1.setItemorder(1);
        bi1.setQuestionid(2);
        
        bir1.setRulename("Test branchItemRule 1");
        bir1.setRuletype(1);
        
        
        bir2.setRulename("Test branchItemRule 2");
        bir2.setRuletype(2);
    } 
    
    @Test
    @Transactional(readOnly = false)
    public void testAddBranchItem(){
         bi1 = bDao.save(bi1);
         assertTrue(bDao.getAll().size()>0);
    }
    
    @Test
    @Transactional(readOnly = false)
    public  void testAddBranchItemRule(){
        bir1 = dao.save(bir1);
        bir2 = dao.save(bir2);
        assertTrue(dao.getAll().size()>0);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testGetAllBranchItemRules(){
        bi1 = bDao.save(bi1);
        bir1 = dao.save(bir1);
        bir2 = dao.save(bir2);
        bi1.getRules().add(bir1);
        bi1.getRules().add(bir2);
        assertTrue(bDao.getAll().size()>0);
        assertTrue(dao.getAll().size()>0);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testResultDao(){
        rs = rDao.save(rs);
        assertTrue(rDao.getAll().size()>0);
    }
    
    @Test
    @Transactional(readOnly = true)
    public void testBranchItemRuleDao() {
        rs =rDao.save(rs);
        bir1 = dao.save(bir1);
        bir1.getResults().add(rs);
        assertTrue(dao.getAll().size()>0);
        assertTrue(rDao.getAll().size()>0);
    } 
        
}
