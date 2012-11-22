/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import au.com.satech.wds.model.Answer;
import au.com.satech.wds.service.AnswerManager;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AnswerManagerTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(getClass());
    
    @Autowired
    private AnswerManager mgr;
    
    private Answer answer;
    
    /*
     * 测试前装配Answer对象属性
     */  
    @Before
    public void setUp() {
        Random rd = new Random();
        int randomValue = rd.nextInt();//取得一个随机数
        answer = new Answer();
        answer.setAnswerorder(1);
        answer.setAnswertitle("Answer generated for test " + randomValue);
    }
    /**
     * 测试AnswerManagerImpl的save方法
     * @throws Exception 
     */
    @Test
    public void testSaveAnswer() throws Exception{
        int numberOfAnswersBeforeAdd = mgr.getAll().size();
        answer = mgr.save(answer);
        int numberOfAnswersAfterAdd = mgr.getAll().size();
        assertTrue(numberOfAnswersBeforeAdd+1 == numberOfAnswersAfterAdd);
    }
    /**
     * 测试AnswerManagerImpl的get方法
     * @throws Exception 
     */
    
    @Test
    // 中文
    public void testGetAnswer() throws Exception {
        answer = mgr.save(answer);
        int answerId = answer.getAnswerid();
        answer = null;
        assertNull(answer);
        answer = mgr.get(answerId);
        assertNotNull(answer);
    }
    /**
     * 测试AnswerManagerImpl的getALl方法
     * @throws Exception 
     */
    
    @Test
    public void testGetAnswers() throws Exception{
        answer = mgr.save(answer);
        ArrayList<Answer> answers = new ArrayList<Answer>(mgr.getAll());
        assertTrue(answers.size()>0);
    }
    /**
     * 测试AnswerManagerImpl的remove方法
     * @throws Exception 
     */
    @Test
    public void testDeleteAnswer() throws Exception {
        answer = mgr.save(answer);
        int numberOfAnswersBefore = mgr.getAll().size();
        mgr.remove(answer.getAnswerid());
        int numberOfAnswersAfter = mgr.getAll().size();
        assertTrue(numberOfAnswersAfter == numberOfAnswersBefore-1);
    }
    
}
