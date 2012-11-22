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

import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Columnchoice;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Subquestion;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

/**
 *
 * @author sam
 */
public class QuestionDaoTest extends BaseDaoTestCase {
    Log log = LogFactory.getLog(QuestionDaoTest.class);
    
    @Autowired
    QuestionDao dao;
    
    @Test
    public void testLoadQuestion(){
        Question question = dao.get(1);
        log.debug("Title: " + question.getQuestiontitle());
        assertNotNull(question);
    }
    
    @Test
    public void testLoadQuestionAndAnswers(){
        Question question = dao.get(3);
        log.debug("Title: " + question.getQuestiontitle());
        ArrayList<Answer> answers = new ArrayList<Answer>(question.getAnswers());
        for(Answer answer:answers){
            log.debug("answers of this question: " + answer.getAnswertitle());
        }
        assertTrue(answers.size()>0);
    }
    
    @Test
    public void testLoadQuestionAndMatrix(){
        Question question = dao.get(8);
        log.debug("Title: " + question.getQuestiontitle());
        ArrayList<Subquestion> subQuestions = new ArrayList<Subquestion>(question.getSubquestions());
        for(Subquestion subQuestion:subQuestions){
            log.debug("sub questions of this question are: " + subQuestion.getSubquestiontitle());
        }
        assertTrue(subQuestions.size()>0);
        ArrayList<Columnchoice> columnChoices = new ArrayList<Columnchoice>(question.getColumnchoices());
        for(Columnchoice columnChoice:columnChoices){
            log.debug("column choices of this question are: " + columnChoice.getColumnchoicetitle());
        }
        assertTrue(columnChoices.size()>0);
    }
}
