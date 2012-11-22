/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.BranchItemDao;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
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
 * @author xiong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional()
public class ItemDaoTest extends BaseDaoTestCase{
   @Autowired
   BranchItemDao dao;
    
    private BranchItemRule branchItemRule1 = new BranchItemRule("test rulname 1", null, Integer.SIZE, null);
   
   private BranchItem branchItem1 = new BranchItem();
   private BranchItem branchItem2 = new BranchItem();
   
   @Before
   @Transactional
   public void prepareTestData(){
       
       branchItem1 = dao.save(branchItem1);
       
   }
  /*
 * 测试Survey的assignPageToSurvey方法
 */     
    @Test
    public void assignRultsToBranchItem(){
        branchItem1.getRules().add(branchItemRule1);
        dao.save(branchItem1);
        assertTrue(branchItem1.getRules().size()==1);
    }
   /*
 * 测试BranchItemDao的save方法
 */
    @Test
    @Transactional(readOnly = false)
    public void testSaveBranchItem(){
        int branchItem1Id = branchItem1.getBranchitemid();
        assertNotNull(dao.get(branchItem1Id));
    }
/*
 * 测试BranchItemDao的get方法
 */
    @Test
    @Transactional(readOnly=true)
    public void testGetBranchItem(){
        int branchItem1Id = branchItem1.getBranchitemid();
        assertTrue(dao.get(branchItem1Id) == branchItem1);
    }
/*
 * 测试BranchItemDao的getAll方法
 */    
    @Test
    @Transactional(readOnly=false)
    public void testGetallBranchItem(){
        dao.save(branchItem2);
        assertTrue(dao.getAll().size() >= 2);      
    }
/*
 * 测试BranchItemDao的remove方法
 */    
    @Test
    @Transactional(readOnly=false)
    public  void testRemoveBranchItem(){
        branchItem2 = dao.save(branchItem2);
        int beforeNumber = dao.getAll().size();
        dao.remove( branchItem2.getBranchitemid());
        int afterNumber = dao.getAll().size();
        assertTrue(afterNumber == beforeNumber - 1);
        // assertTrue(afterNumber < beforeNumber);
        
    }
/*
 * 测试BranchItemDao的isExits方法
 */    
    @Test
    @Transactional(readOnly=true)
    public void testIsExitsBranchItem(){
        int  branchItem1Id =  branchItem1.getBranchitemid();
        assertTrue(dao.exists(branchItem1Id));
    }

}
