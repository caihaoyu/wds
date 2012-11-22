/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.BranchItemDao;
import au.com.satech.wds.dao.PageBranchDao;
import au.com.satech.wds.dao.QuestionDao;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Question;
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
 * @author sam
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional()
public class PageBranchDaoTest extends BaseDaoTestCase {
    
    @Autowired
    private PageBranchDao pbDao;
    
    @Autowired
    private QuestionDao qDao;
    
    @Autowired
    private BranchItemDao iDao;
    
    private PageBranch pageBranch1;
    private PageBranch pageBranch2;
    
    private BranchItem item1;
    private BranchItem item2;
    
    private Question question1;
    private Question question2;
    
    @Before
    public void prepareTestData(){
        pageBranch1 = new PageBranch();
        pageBranch1.setBranchname("Test page branch 1");
        pageBranch1.setMain(true);
        pageBranch2 = new PageBranch();
        pageBranch2.setBranchname("Test page branch 2");
        pageBranch2.setMain(false);
        
        item1 = new BranchItem();
        item1.setHidden(false);
        item1.setItemorder(1);
        item2 = new BranchItem();
        item2.setHidden(false);
        item2.setItemorder(2);
        
        question1 = new Question();
        question1.setQuestiontitle("Test question 1");
        question1.setQuestiontype(1);
        question2 = new Question();
        question2.setQuestiontitle("Test question 2");
        question2.setQuestiontype(3);
    }
    
    @Test
    @Transactional(readOnly = true)
    public void testGetAll(){
        pageBranch1 = pbDao.save(pageBranch1);
        pageBranch2 = pbDao.save(pageBranch2);
        assertTrue(pbDao.getAll().size()>0);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testAddAndDelete(){
        int numberOfPagebranch = pbDao.getAll().size();
        pageBranch1 = pbDao.save(pageBranch1);
        int numberOfPageBranchAfterAdd = pbDao.getAll().size();
        assertTrue(numberOfPagebranch+1 == numberOfPageBranchAfterAdd);
        
        pbDao.remove(pageBranch1.getBranchid());
        int numberOfPageBranchAfterDelete = pbDao.getAll().size();
        assertTrue(numberOfPageBranchAfterAdd-1 == numberOfPageBranchAfterDelete);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testGet(){
        pageBranch1 = pbDao.save(pageBranch1);
        int pageBranch1Id = pageBranch1.getBranchid();
        pageBranch1 = null;
        pageBranch1 = pbDao.get(pageBranch1Id);
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testAssignQuestionToPageBranch(){
        question1 = qDao.save(question1);
        question2 = qDao.save(question2);
        
        item1 = iDao.save(item1);
        item2 = iDao.save(item2);
        
        pageBranch1.getItems().add(item1);
        pageBranch1.getItems().add(item2);
        
        pageBranch1 = pbDao.save(pageBranch1);
        int pageBranch1Id = pageBranch1.getBranchid();
        pageBranch1 = null;
        assertNull(pageBranch1);
        pageBranch1 = pbDao.get(pageBranch1Id);
        assertTrue(pageBranch1.getItems().size() == 2);
    }
//    
//    @Test
//    @Transactional(readOnly = false)
//    public void testGetBranchItemFromQuestion(){
//        question1 = qDao.saveQuestion(question1);
//        question2 = qDao.saveQuestion(question2);
//        item1.setQuestion(question1);
//        item1 = iDao.saveBranchItem(item1);
//        item2.setQuestion(question2);
//        item2 = iDao.saveBranchItem(item2);
//        
//        question1.setItem(item1);
//        question2.setItem(item2);
//        question1 = qDao.saveQuestion(question1);
//        question2 = qDao.saveQuestion(question2);
//        log.debug("item1ID: "+item1.getBranchitemid());
//        log.debug("item2ID: "+item2.getBranchitemid());
//        log.debug("item1 in question: "+question1.getItem().getBranchitemid());
//        int questio1ID = question1.getQuestionid();
//        question1 = null;
//        question1 = qDao.get(questio1ID);
//        log.debug("question1 item ID: "+question1.getItem().getBranchitemid());
//    }
    
//    @Test
//    @Transactional(readOnly = false)
//    public void testCountQuestionsInUse(){
//        pageBranch1.getQuestions().add(question1);
//        pageBranch1.getQuestions().add(question2);
//        
//        pageBranch1 = pbDao.savePageBranch(pageBranch1);
//        question1 = pageBranch1.getQuestions().get(0);
//        log.debug("Count result: "+qDao.countQuestionInUse(question1));
//    }
    
    
//    Data dependent test
//    @Test
//    @Transactional(readOnly = true)
//    public void testhiddenQuestions(){
//        List result = pbDao.hiddenQuestions(281);
//        for(int i=0;i<result.size();i++){
//            log.debug("result: "+result.get(i).toString());
//        }
//    }
}
