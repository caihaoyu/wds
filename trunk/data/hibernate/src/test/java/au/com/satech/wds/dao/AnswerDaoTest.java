/*
 * Copyright 2011 sam.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package au.com.satech.wds.dao;

import java.util.List;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Answer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
/**
 *
 * @author sam
 */
public class AnswerDaoTest extends BaseDaoTestCase {
    Log log = LogFactory.getLog(AnswerDaoTest.class);
    
    @Autowired
    AnswerDao dao;
    
    @Autowired
    QuestionDao qdao;
    
    @Test
    public void testAnswerExist() throws Exception {
        Answer answer = new Answer();
        answer.setAnswerid(2);
        assertTrue(dao.answerExist(answer));
    }
    
    @Test
    public void testAddNewAnswer() {
        Answer answer = new Answer();
        answer.setAnswerorder(1);
        answer.setAnswertitle("testAddNewAnswer()");
        dao.saveAnswer(answer);
    }
    
    @Test public void testAssignAnswersToQuestion() {
        Question question = qdao.get(3);
        log.debug("number of answers: " + question.getAnswers().size());
        // load answers set
        List answers = question.getAnswers();
        answers.add((Answer)dao.get(1));
        answers.add((Answer)dao.get(2));
        answers.add((Answer)dao.get(3));
        answers.add((Answer)dao.get(4));
        answers.add((Answer)dao.get(5));  
        
        qdao.saveQuestion(question);
        flush();
        
        // display result
        Question question2 = qdao.get(3);
        log.debug("number of answers after: " + question2.getAnswers().size());
    }
   
}
