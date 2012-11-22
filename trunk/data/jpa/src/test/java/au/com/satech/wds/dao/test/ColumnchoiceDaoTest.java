/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;
import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.model.Columnchoice;
import au.com.satech.wds.dao.ColumnchoiceDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

/**
 * 这个类用来测试ColumnchoiceDao的方法和其实现类的方法
 * @author xiong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
@Transactional()
public class ColumnchoiceDaoTest extends  BaseDaoTestCase{
    @Autowired
    ColumnchoiceDao dao;
    //构造器属性注入
    private Columnchoice columnchoice1 = new Columnchoice(null, "Columnchoice title test1", 1);
    private Columnchoice columnchoice2 = new Columnchoice(null, "Columnchoice title test2", 2);
    private Columnchoice columnchoice3 = new Columnchoice(null, "Columnchoice title test3", 3);
    
    @Before
    @Transactional(readOnly = false)
    public void prepareTestData(){
    columnchoice1 = dao.save(columnchoice1);//测试前先得到一个columnchoice
    }
/*
 * 测试Coloumnchoice 的save方法
 */
    @Test
    @Transactional(readOnly = false)
    public void testSaveColumnchoice(){
        int columnchoice1Id = columnchoice1.getColumnchoiceid();
        assertNotNull(dao.get(columnchoice1Id));
       
    }
 /*
 * 测试Coloumnchoice 的get方法
 */   
    @Test
    @Transactional(readOnly=true)
    public void testGetColumnchoice(){
        int columnchoice1Id = columnchoice1.getColumnchoiceid();
        assertTrue(dao.get(columnchoice1Id) == columnchoice1);
    }
 /*
 * 测试Coloumnchoice 的getAll方法
 */
    @Test
    @Transactional(readOnly=false)
    public void testGetallColumnchoice(){
        dao.save(columnchoice2);
        dao.save(columnchoice3);
        assertTrue(dao.getAll().size() >= 2);      
    }
 /*
 * 测试Coloumnchoice 的remove方法
 */  
    @Test
    @Transactional(readOnly=false)
    public  void testRemoveColumnchoice(){
        columnchoice2 = dao.save(columnchoice2);
        dao.save(columnchoice3);
        int beforeNumber = dao.getAll().size();
        dao.remove(columnchoice2.getColumnchoiceid());
        int afterNumber = dao.getAll().size();
        assertTrue(afterNumber == beforeNumber - 1);
        // assertTrue(afterNumber < beforeNumber);
        
    }
 /*
 * 测试Coloumnchoice 的isExits方法
 */   
    @Test
    @Transactional(readOnly=true)
    public void testIsExitsColumnchoice(){
        int columnchoice1Id = columnchoice1.getColumnchoiceid();
        assertTrue(dao.exists(columnchoice1Id));
    }
  
}
