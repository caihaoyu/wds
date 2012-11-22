/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.dao.QuestionDao;
import org.junit.Before;
import org.springframework.dao.DataAccessException;
import au.com.satech.wds.model.Answer;
import au.com.satech.wds.dao.AnswerDao;
import au.com.satech.wds.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AnswerDaoTest extends BaseDaoTestCase {
    @Autowired
    AnswerDao dao;
    
    @Autowired
    QuestionDao qDao;
    
    private Answer answer1 = new Answer();
    private Answer answer2 = new Answer();
    private Question newQuestion = new Question();
    
    @Before
    @Transactional
    public void prepareTestData(){
        answer1.setAnswertitle("Test answer 1");
        answer2.setAnswertitle("Test answer 2");
        newQuestion.setQuestiontitle("Test question 1");
        newQuestion.setQuestiontype(3);
        
        newQuestion.getAnswers().add(answer1);
        newQuestion.getAnswers().add(answer2);
        
    }
    
    @Test
    @Transactional(readOnly = true)
    public void testGetAllAnswers(){
        answer1 = dao.save(answer1);
//        answer2 = dao.saveAnswer(answer2);
        assertTrue(dao.getAll().size()>0);
    }
    
    @Test
    @Transactional(readOnly = true)
    public void testGetQuestionAndAnswers(){
        newQuestion = qDao.save(newQuestion);
        newQuestion = qDao.get(newQuestion.getQuestionid());
        assertTrue(newQuestion.getAnswers().size()>0);
                
    }
    
    @Test
    @Transactional(rollbackFor=DataAccessException.class, readOnly=false)
    public void testAddNewAnswer(){
        answer1 = dao.save(answer1);
        answer2 = dao.save(answer2);
        assertTrue(answer1.getAnswerid() != null);
        assertTrue(answer2.getAnswerid() != null);
    }
    
    @Test
    @Transactional(rollbackFor=DataAccessException.class, readOnly=false)
    public void testDeleteAnswer(){
        answer1 = dao.save(answer1);
        answer2 = dao.save(answer2);
        int answersSize = dao.getAll().size();
        dao.remove(answer1.getAnswerid());
        int answersSizeAfter = dao.getAll().size();
        assertTrue(answersSize == answersSizeAfter + 1);
    }
}
