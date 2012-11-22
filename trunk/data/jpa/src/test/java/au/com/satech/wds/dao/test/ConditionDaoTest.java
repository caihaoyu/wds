/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.ConditionDao;
import au.com.satech.wds.model.Condition;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *此类用来测试ConditionDao的方法和其实现类的方法
 * @author xiong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional()
public class ConditionDaoTest extends BaseDaoTestCase{
    @Autowired
    ConditionDao dao;
    //构造器属性注入
    private Condition condition1  =  new Condition(true,0,0);
    private Condition condition2  =  new Condition(true,0,0);
    private Condition condition3  =  new Condition(false,0,0);
    
    @Before
    @Transactional
    public void prepareTestData(){
      condition1 = dao.save(condition1);//测试方法前先获得一个有Id的condition
    }
/*
 * 测试ConditionDao的save方法
 */
    @Test
    @Transactional(readOnly = false)
    public void testSaveCondition(){
        int condition1Id = condition1.getConditionid();
        assertNotNull(dao.get(condition1Id));
    }
/*
 * 测试ConditionDao的get方法
 */
    @Test
    @Transactional(readOnly=true)
    public void testGetCondition(){
        int condition1Id = condition1.getConditionid();
        assertTrue(dao.get(condition1Id) == condition1);
    }
 /*
 * 测试ConditionDao的getAll方法
 */ 
    @Test
    @Transactional(readOnly=false)
    public void testGetallCondition(){
        dao.save(condition2);
        dao.save(condition3);
        assertTrue(dao.getAll().size()>0);
    }
 /*
 * 测试ConditionDao的remove方法
 */
    @Test
    @Transactional(readOnly=false)
    public  void testRemoveCondition(){
        condition2 = dao.save(condition2);
        dao.save(condition2);
        int beforeNumber = dao.getAll().size();
        dao.remove(condition2.getConditionid());
        int afterNumber = dao.getAll().size();
        assertTrue(afterNumber == beforeNumber - 1);
        
    }
/*
 * 测试ConditionDao的isExitits方法
 */
    @Test
    @Transactional(readOnly=true)
    public void testIsExitsCondition(){
        int condition1Id = condition1.getConditionid();
        assertTrue(dao.exists(condition1Id));
    }

}
