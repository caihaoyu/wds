/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.EntryDao;
import au.com.satech.wds.dao.ResponseDao;
import au.com.satech.wds.model.Entry;
import au.com.satech.wds.model.QuestionResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 *
 * @author sam
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
@Transactional()
public class ReponseTest extends BaseDaoTestCase {
    @Autowired
    EntryDao eDao;
    
    @Autowired
    ResponseDao rDao;
    
    private QuestionResponse r1 = new QuestionResponse();
    private QuestionResponse r2 = new QuestionResponse();
    
    private Entry e1 = new Entry();
    private Entry e2 = new Entry();
    
    @Before
    public void prepareTestData(){
//        r1.setSid(5);
//        r2.setSid(6);
//        
//        e1.setQuestionid(19);
//        e1.setAnswerid(267);
//        
//        e2.setQuestionid(305);
//        e2.setSubquestionid(8);
//        e2.setColumnchoiceid(11);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testSaveReponse(){
//        int sizeB4 = rDao.getAll().size();
//        r1 = rDao.save(r1);
//        log.debug("New response r1 added: "+r1.getResponseid());
//        r2 = rDao.save(r2);
//        log.debug("New response r2 added: "+r2.getResponseid());
//        int sizeAfter = rDao.getAll().size();
//        assertTrue(sizeAfter == sizeB4 + 2);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testSaveEntry(){
//        int sizeB4 = eDao.getAll().size();
//        e1 = eDao.save(e1);
//        log.debug("New entry e1 added: "+e1.getEntryid());
//        e2 = eDao.save(e2);
//        log.debug("New entry e2 added: "+e2.getEntryid());
//        int sizeAfter = eDao.getAll().size();
//        assertTrue(sizeAfter == sizeB4 + 2);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testAddEntryToResponse(){
//        r1.getEntries().add(e1);
//        r1.getEntries().add(e2);
//        assertTrue(r1.getEntries().size() == 2);
//        int rSizeB4 = rDao.getAll().size();
//        int eSizeB4 = eDao.getAll().size();
//        r1 = rDao.save(r1);
//        int rSizeAfter = rDao.getAll().size();
//        int eSizeAfter = eDao.getAll().size();
//        assertTrue(rSizeB4+1 == rSizeAfter);
//        assertTrue(eSizeB4+2 == eSizeAfter);
    }
}
