/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.ResultDao;
import au.com.satech.wds.model.Result;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *此类用来测ResultDao里面的方法
 * @author xiong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
@Transactional()
public class ResultDaoTest extends BaseDaoTestCase{
    @Autowired
    ResultDao dao;
    
    //构造器属性注入
    private Result result1 = new Result(1, 1, 1, 1, 1,"test result 1");
    private Result result2 = new Result(2, 2, 2, 2, 2,"test result 2");
    private Result result3 = new Result(3, 3, 3, 3, 3,"test result 3");

    @Before
    @Transactional(readOnly=false)
    public void prepareTestData(){
    result1 = dao.save(result1);//测试前先获得一个含有Id属性的Result对象
    }
/*
 * 测试Resultdao的save方法
 */
    @Test
    @Transactional(readOnly = false)
    public void testSaveResult(){
        int result1Id = result1.getResultid();
        assertNotNull(dao.get(result1Id));
    }
/*
 * 测试Resultdao的get方法
 */
    @Test
    @Transactional(readOnly=true)
    public void testGetResult(){
        int result1Id = result1.getResultid();
        assertTrue(dao.get(result1Id) == result1);
    }
/*
 * 测试Resultdao的getAll方法
 */    
    @Test
    @Transactional(readOnly=false)
    public void testGetallResult(){
        dao.save(result2);
        dao.save(result3);
        assertTrue(dao.getAll().size() >= 2);      
    }
/*
 * 测试Resultdao的remove方法
 */    
    @Test
    @Transactional(readOnly=false)
    public  void testRemoveResult(){
        result2 = dao.save(result2);
        dao.save(result3);
        int beforeNumber = dao.getAll().size();
        dao.remove(result2.getResultid());
        int afterNumber = dao.getAll().size();
        assertTrue(afterNumber == beforeNumber - 1);
        // assertTrue(afterNumber < beforeNumber);
        
    }
/*
 * 测试Resultdao的isExits方法
 */    
    @Test
    @Transactional(readOnly=true)
    public void testIsExitsResult(){
        int result1Id = result1.getResultid();
        assertTrue(dao.exists(result1Id));
    }
  
    
}
