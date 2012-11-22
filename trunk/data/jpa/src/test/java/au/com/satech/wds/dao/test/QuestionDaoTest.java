/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import au.com.satech.wds.dao.AnswerDao;
import au.com.satech.wds.dao.BaseDaoTestCase;
import au.com.satech.wds.dao.QuestionDao;
import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Question;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 *此类用来测试Question以及GenericDao里面的方法
 * @author sam
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
@Transactional()
public class QuestionDaoTest extends BaseDaoTestCase {
    @Autowired
    QuestionDao dao;
    
    @Autowired
    AnswerDao aDao;
    
    private Question question1 = new Question(); // Free text
    private Question question2 = new Question(); // Multiple Choice
    private Question question3 = new Question(); // Rating
    private Question question4 = new Question(); // Test column choice type
    private Answer answer1 = new Answer();
    private Answer answer2 = new Answer();
    private Set<Answer> answers = new HashSet<Answer>();
    
    @Before
    public void prepareTestData(){
        answer1.setAnswertitle("Test answer 1");
        answer1.setAnswerorder(1);
        answer2.setAnswertitle("Test answer 2");
        answer2.setAnswerorder(2);
        answers.add(answer1);
        answers.add(answer2);
        question1.setQuestiontitle("Test question 1 samueltian");
        question1.setInuse(false);
        question1.setQuestiontype(1);
        question1.setAllowcustomized(true);
        question1.setAllowdescription(true);
        question1.setAllowmultipile(true);
        question1.setAnswers(answers);
        question1.setCreateDate(Calendar.getInstance().getTime());
        question1.setModifiedDate(Calendar.getInstance().getTime());
        
        
        question2.setQuestiontitle("Test question 2 samueltian");
        question2.setQuestiontype(2);
        question2.setInuse(false);
        
        question3.setQuestiontitle("this is rating question test");
        question3.setQuestiontype(3);
        question3.setRating(3.0);
        question3.setInuse(false);
        
        question4.setQuestiontitle("this is matrix question with column choice type");
        question4.setQuestiontype(4);
        question4.setColumntype(1);
        question4.setInuse(false);
       

    }
 /**
 * 测试Question里面的getAll方法
 */
    
    @Test
    @Transactional(readOnly = false)
    public void testGetAllquestions(){
        dao.save(question1);
        dao.save(question2);
        dao.save(question3);
        assertTrue(dao.getAll().size()>0);
    }
/**
 * 测试QuestionDao里面的save方法
 */
    
    @Test
    @Transactional(readOnly = false)
    public void testAddQuestion(){
        Question q3 = new Question();
        q3.initDefaultValues();
        question1 = dao.save(question1);
        assertTrue(question1.getQuestionid() != null);
        assertTrue(question1.getAllowcustomized());
        assertTrue(question1.getAllowdescription());
        assertTrue(question1.getAllowmultipile());
        assertTrue(question1.getCreateDate()!=null);
    }
/**
 * 测试QuestionDao里面的get方法
 */
    @Test
    @Transactional(readOnly = false)
    public void testGetQuestion(){
        question1 = dao.save(question1);
        int question1Id = question1.getQuestionid();
        assertTrue(dao.get(question1Id) != null);
        
    }
/**
 * 测试QuestionDao里面的saveQuestionAndAnswer方法
 */
    @Test
    @Transactional(readOnly = false)
    public void testAddQuestionAndAnswers(){
        int numberOfAnswersBefore = aDao.getAll().size();
        int numberOfQuestionsBefore = dao.getAll().size();
        
        answer1 = aDao.save(answer1);
        answer2 = aDao.save(answer2);
        question2.getAnswers().add(answer1);
        question2.getAnswers().add(answer2);
        question2 = dao.save(question2);
        int question2Id = question2.getQuestionid();
        question2 = null;
        question2 = dao.get(question2Id);
        assertTrue(question2.getAnswers().size() == 2);
        
        int numberOfAnswersAfter = aDao.getAll().size();
        int numberOfQuestionsAfter = dao.getAll().size();
        
        assertTrue(numberOfAnswersBefore+2 == numberOfAnswersAfter);
        assertTrue(numberOfQuestionsBefore+1 == numberOfQuestionsAfter);
    }
/**
 * 测试GenericDao里面的remove 方法
 */
    @Test
    @Transactional(readOnly = false)
    public void testRemove(){
        question1 = dao.save(question1);
        int question1Id = question1.getQuestionid();
        int beforeNumber = dao.getQuestionCount();
        dao.remove(question1Id);//delete question;
        int afterNumber = dao.getQuestionCount();
        assertTrue(afterNumber < beforeNumber );
//        assertTrue(aDao.get(answer1.getAnswerid()) == null);//验证是否删除question里面的answer的内容
    }
/**
 *  测试GenericDao里面isExisits()方法
 */
    @Test
    @Transactional(readOnly = false)
    public void  testIsExists(){
        question1 = dao.save(question1);
        int question1Id = question1.getQuestionid();
        assertTrue(dao.exists(question1Id));  
    
    }
/**
 * 测试GenericDao里面的getAll()方法
 */ 
    @Test
    @Transactional(readOnly = false)
     public void testGetAll(){
       dao.save(question1);
       assertTrue(dao.getAll().size() == dao.getQuestionCount());
    }
 /**
 * 测试GenericDao里面的getAllDistinct()方法
 */
    @Test
    @Transactional(readOnly = false)
    public void testGetAllDistinct(){
        dao.save(question1);
        assertTrue(!dao.getAllDistinct().isEmpty());
    }
    
    @Test
    @Transactional(readOnly = false)
    public void testRating(){
        question3 = dao.save(question3);
        assertEquals(new Double(3.0), question3.getRating());
    }
 /**
 *  测试GenericDao里面isExisits()方法
 */  
    @Test
    @Transactional(readOnly = false)
    public void testColumnchoiceType(){
        question4 = dao.save(question4);
        
        assertNotNull(question4.getQuestionid());
        assertNotNull(question4.getColumntype());
        assertNotNull(question4.getColumntype());
    }
    
//    Inuse 已不再使用，现在使用动态计算的方式获取inuse信息
//    @Test
//    @Transactional(readOnly = false)
//    public void testInuse(){
//        question1.setInuse(true);
//        assertTrue(question1.isInuse());
//    }
    
//    // 该搜索需要提前准备数据，不参与普通测试
//    @Test
//    @Transactional
//    public void testQuestionSearch() throws Exception {
//        dao.getFullTextEntityManager().createIndexer(Question.class).startAndWait();
//        final List<Question> questions = dao.searchForQuestionByTerms("budget", 0, 20);
//        assertTrue(questions.size()>0);
//    }
    
//    @Test
//    @Transactional
//    public void testQueryRunner() throws Exception {
//        String query1 = "SELECT q FROM Question q";
//        dao.queryRunner(query1);
//        
//        String query2 = "SELECT q.questiontitle FROM Question q";
//        log.debug(" ############ ");
//        log.debug(" Query2 Result: "+dao.queryRunner(query2));
//        log.debug(" Query2 size: "+dao.queryRunner(query2).size());
//        
//        String query3 = "SELECT q.answers FROM Question q";
//        log.debug(" ############ ");
//        log.debug(" Query3 Result: "+dao.queryRunner(query3));
//        log.debug(" Query3 size: "+dao.queryRunner(query3).size());
//        
//        String query4 = "SELECT COUNT(q.questionid) FROM Page p JOIN p.questions q WHERE q.questionid = 3";
//        log.debug(" ############ ");
//        log.debug(" Query4 Result: "+dao.queryRunner(query4));
//        log.debug(" Query4 size: "+dao.queryRunner(query4).size());
//    }
    
//    @Test
//    @Transactional
//    public void testCountQuestionInUse(){
//        Question question3 = dao.get(3);
////        log.debug(dao.countQuestionInUse(question3));
//        assertTrue(dao.countQuestionInUse(question3) == 2);
//        
//        Question question4 = dao.get(4);
//        assertTrue(dao.countQuestionInUse(question4) == 1);
//        
//        Question question7 = dao.get(7);
//        assertTrue(dao.countQuestionInUse(question7) == 2);
//    }
    @Test
    public void testGetCount(){
        int before = dao.getQuestionCount();
        dao.save(question1);//因为before的方法里面添加了一次所以注释
        dao.save(question2);
        dao.save(question3);
        int after = dao.getQuestionCount();
        assertTrue(before+3 == after);
    }
    
    @Test
    public void testLazyGet(){
        dao.save(question1);
        dao.save(question2);
        dao.save(question3);
        assertTrue(dao.getQuestionListBySize(0, 2).size()==2);
    }
    
    @Test
    public void testCreateData(){
        dao.save(question1);
        dao.save(question2);
        dao.save(question3);
        List<Question> list = dao.getQuestionByCreatedate(0, 2);
        assertTrue(list.size()>=2);
        
        list = dao.getQuestionsByInuse(0, 0, 2);
        assertTrue(list.size()>0);
        int size = dao.getCountByInuse(0);
        log.info(size);
    }
    
}
