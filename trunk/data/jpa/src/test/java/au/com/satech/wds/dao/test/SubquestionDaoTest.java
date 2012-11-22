/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.com.satech.wds.dao.test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import au.com.satech.wds.model.Subquestion;
import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.SubquestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 *此类用来测试SubquestionDao的方法
 * @author xiong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
@Transactional()
public class SubquestionDaoTest extends BaseDaoTestCase{
    @Autowired
    SubquestionDao dao;
    //构造器属性注入
    private Subquestion subquestion1 = new Subquestion(null, "Subquestion test title 1", 1);
    private Subquestion subquestion2 = new Subquestion(null, "Subquestion test title 2", 2);
    private Subquestion subquestion3 = new Subquestion(null, "Subquestion test title 3", 3);
    @Before
    @Transactional(readOnly=false)
    public void prepareTestData(){
      subquestion1 = dao.save(subquestion1);//测试钱先获得一个含有id的Subquestion对象
    }
 /*
  * 测试SubquestionDao的save方法
  */
    @Test
    @Transactional(readOnly = true)
    public void testSaveSubquestion(){
        int subquestion1Id = subquestion1.getSubquestionid();
        assertNotNull(dao.get(subquestion1Id));
    }
 /*
  * 测试SubquestionDao的get方法
  */
    @Test
    @Transactional(readOnly=true)
    public void testGetSubquestion(){
        int subquestion1Id = subquestion1.getSubquestionid();
        assertTrue(dao.get(subquestion1Id) == subquestion1);
    }
 /*
  * 测试SubquestionDao的getAll方法
  */   
    @Test
    @Transactional(readOnly=false)
    public void testGetallSubquestion(){
        dao.save(subquestion2);
        dao.save(subquestion3);
        log.debug(dao.getAll().size());
        assertTrue(dao.getAll().size()>0);
    }
  /*
  * 测试SubquestionDao的remove方法
  */  
    @Test
    @Transactional(readOnly=false)
    public  void testRemoveSubquestion(){
        subquestion2 = dao.save(subquestion2);
        dao.save(subquestion3);
        int beforeNumber = dao.getAll().size();
        dao.remove(subquestion2.getSubquestionid());
        int afterNumber = dao.getAll().size();
        assertTrue(afterNumber == beforeNumber - 1);
        
    }
    /*
  * 测试SubquestionDao的isExits方法
  */    
    @Test
    @Transactional(readOnly=true)
    public void testIsExits(){
        int subquestion1Id = subquestion1.getSubquestionid();
        assertTrue(dao.exists(subquestion1Id));
    }

}
