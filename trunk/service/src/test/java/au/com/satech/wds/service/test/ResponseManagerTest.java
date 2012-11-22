/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import au.com.satech.wds.model.Entry;
import au.com.satech.wds.model.QuestionResponse;
import au.com.satech.wds.service.EntryManager;
import au.com.satech.wds.service.ResponseManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
/**
 *
 * @author sam
 */
public class ResponseManagerTest extends BaseManagerTestCase {
    @Autowired
    private ResponseManager rMgr;
    
    @Autowired
    private EntryManager eMgr;
    
//    private QuestionResponse r1 = new QuestionResponse();
//    private QuestionResponse r2 = new QuestionResponse();
    
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
//        int sizeB4 = rMgr.getAll().size();
//        r1 = rMgr.save(r1);
//        log.debug("New response r1 added: "+r1.getResponseid());
//        r2 = rMgr.save(r2);
//        log.debug("New response r2 added: "+r2.getResponseid());
//        int sizeAfter = rMgr.getAll().size();
//        assertTrue(sizeAfter == sizeB4 + 2);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testSaveEntry(){
//        int sizeB4 = eMgr.getAll().size();
//        e1 = eMgr.save(e1);
//        log.debug("New entry e1 added: "+e1.getEntryid());
//        e2 = eMgr.save(e2);
//        log.debug("New entry e2 added: "+e2.getEntryid());
//        int sizeAfter = eMgr.getAll().size();
//        assertTrue(sizeAfter == sizeB4 + 2);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testAddEntryToResponse(){
//        r1.getEntries().add(e1);
//        r1.getEntries().add(e2);
//        assertTrue(r1.getEntries().size() == 2);
//        int rSizeB4 = rMgr.getAll().size();
//        int eSizeB4 = eMgr.getAll().size();
//        r1 = rMgr.save(r1);
//        int rSizeAfter = rMgr.getAll().size();
//        int eSizeAfter = eMgr.getAll().size();
//        assertTrue(rSizeB4+1 == rSizeAfter);
//        assertTrue(eSizeB4+2 == eSizeAfter);
    }
}
