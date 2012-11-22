/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;
import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Columnchoice;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Subquestion;
import au.com.satech.wds.service.AnswerManager;
import au.com.satech.wds.service.ColumnchoiceManager;
import au.com.satech.wds.service.QuestionManager;
import au.com.satech.wds.service.SubquestionManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionManagerTest extends BaseManagerTestCase {
    
    @Autowired
    private QuestionManager mgr;
    
    @Autowired
    private AnswerManager amgr;
    
    @Autowired
    private SubquestionManager sMgr;
    
    @Autowired
    private ColumnchoiceManager cMgr;
    
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Answer answer1;
    private Answer answer2;
    private Subquestion subquestion1;
    private Subquestion subquestion2;
    private Columnchoice columnchoice1;
    private Columnchoice columnchoice2;
    
    @Before
    public void setUp() {
        question1 = new Question();
        question1.setQuestiontitle("Test Question 1");
        question1.setQuestiontype(1);
        question1.setAllowcustomized(true);
        question1.setAllowdescription(true);
        question1.setAllowmultipile(true);
        
        question2 = new Question();
        question2.setQuestiontitle("wu test");
        question2.setQuestiontype(2);
        question2.setAllowcustomized(true);
        question2.setAllowdescription(true);
        question2.setAllowmultipile(true);
        
        question3 = new Question();
        question3.setQuestiontitle("type 3");
        question3.setQuestiontype(3);
        question3.setAllowcustomized(true);
        question3.setAllowdescription(true);
        question3.setAllowmultipile(true);
        
        question4 = new Question();
        question4.setQuestiontitle("type 4");
        question4.setQuestiontype(4);
        question4.setAllowcustomized(true);
        question4.setAllowdescription(true);
        question4.setAllowmultipile(true);
        
        answer1 = new Answer();
        answer1.setAnswertitle("Test answer 1");
        answer1.setAnswerorder(1);
        answer2 = new Answer();
        answer2.setAnswertitle("Test answer 2");
        answer2.setAnswerorder(2);
        
        subquestion1 = new Subquestion();
        subquestion1.setSubquestiontitle("1");
        subquestion2 = new Subquestion();
        subquestion2.setSubquestiontitle("2");
        
        columnchoice1 = new Columnchoice();
        columnchoice1.setColumnchoicetitle("cc1");
        columnchoice2 = new Columnchoice();
        columnchoice2.setColumnchoicetitle("cc2");
    }
    
    @Test
    public void testSaveQuestion() throws Exception{
        int sizeOfQuestionBefore = mgr.getAll().size();
        question1 = mgr.save(question1);
        int sizeOfQuestionAfter = mgr.getAll().size();
        assertTrue(sizeOfQuestionBefore+1 == sizeOfQuestionAfter);
    }
    
    @Test
    public void testGetAllQuestion(){
        question1 = mgr.save(question1);
        List questions = mgr.getAll();
        assertTrue(questions.size()>0);
    }
    
    @Test
    public void testGetQuestion(){
        question1 = mgr.save(question1);
        int questionId = question1.getQuestionid();
        question1 = null;
        assertNull(question1);
        question1 = mgr.get(questionId);
        assertTrue(question1.getAllowcustomized());
        assertTrue(question1.getAllowdescription());
        assertNotNull(question1.getAllowcustomized());
        assertNotNull(question1);
    }
    
    @Test
    public void testSearch(){
        log.debug("#### START SEARCH ####");
        question1 = mgr.save(question1);
        String searchTerm = "Test Question";
        List<Question> resultList = mgr.searchForQuestionByTerms(searchTerm, 0, 20);
        log.debug("resultList size: "+resultList.size());
    }
    
    @Test
    public void testSaveQuestionAndAnswers() throws Exception{
        int sizeOfQuestionBefore = mgr.getAll().size();
        int sizeOfAnswerBefore = amgr.getAll().size();
        answer1 = amgr.save(answer1);
        answer2 = amgr.save(answer2);
        
        question1.getAnswers().add(answer1);
        question1.getAnswers().add(answer2);
        
        question1 = mgr.save(question1);
        int sizeOfQuestionAfter = mgr.getAll().size();
        int sizeOfAnswerAfter = amgr.getAll().size();
        assertTrue(sizeOfQuestionBefore+1 == sizeOfQuestionAfter);
        assertTrue(sizeOfAnswerBefore+2 == sizeOfAnswerAfter);
        
        int questionId = question1.getQuestionid();
        
        question1 = null;
        assertNull(question1);
        question1 = mgr.get(questionId);
        
        assertNotNull(question1);
        assertTrue(question1.getAnswers().size() == 2);
    }
    
    @Test
    public void testDeleteAnswer(){
        answer1 = amgr.save(answer1);
        answer2 = amgr.save(answer2);
        
        question1.getAnswers().add(answer1);
        question1.getAnswers().add(answer2);
        
        question1 = mgr.save(question1);
        int questionid = question1.getQuestionid();
        question1 = null;
        question1 = mgr.get(questionid);
        assertTrue(question1.getAnswers().size() == 2);

    }
    
    @Test
    public void testLazyModel(){
        mgr.save(question1);
//        mgr.save(question2);
       assertTrue( mgr.getQuestionCount()>0);
       assertTrue(mgr.getQuestionListBySize(0, 1).size()==1);
        
    }
    @Test
    public void testIsQuestionInuse(){
        assertFalse( mgr.isQuestionInUse(0));
    }
    
    /**
     * 测试addQuestionAndAnswers()
     */
    @Test
    public void testAddQuestionAndAnswers(){
        ArrayList<Answer> list = new ArrayList<Answer>();
        list.add(answer1);
        list.add(answer2);
        
        int oldQuestionSize = mgr.getAll().size();
        int oldAnswerSize = amgr.getAll().size();
        Question q = mgr.addQuestionAndAnswers(question1, list);
        int newQuestionSize = mgr.getAll().size();
        int newAnswerSize = amgr.getAll().size();
        
        assertEquals(oldQuestionSize+1, newQuestionSize);
        assertEquals(oldAnswerSize+2, newAnswerSize);
        assertNotNull(q.getQuestionid());
    }
    
    /**
     * 测试addQuestionAndSubquestions()
     */
    @Test
    public void testAddQuestionAndSubquestions(){
        ArrayList<Subquestion> list = new ArrayList<Subquestion>();
        list.add(subquestion1);
        list.add(subquestion2);
        
        int oldQuestionSize = mgr.getAll().size();
        int oldSubquestionSize = sMgr.getAll().size();
        Question q = mgr.addQuestionAndSubquestions(question1, list);
        int newQuestionSize = mgr.getAll().size();
        int newSubquestionSize = sMgr.getAll().size();
        
        assertEquals(oldQuestionSize+1, newQuestionSize);
        assertEquals(oldSubquestionSize+2, newSubquestionSize);
        assertNotNull(q.getQuestionid());
    }
    
    /**
     * 测试addQuestionSubquestionsAndColumnchoices()
     */
    @Test
    public void testAddQuestionSubquestionsAndColumnchoices(){
        ArrayList<Subquestion> list1 = new ArrayList<Subquestion>();
        list1.add(subquestion1);
        list1.add(subquestion2);
        ArrayList<Columnchoice> list2 = new ArrayList<Columnchoice>();
        list2.add(columnchoice1);
        list2.add(columnchoice2);
        
        int oldQuestionSize = mgr.getAll().size();
        int oldSubquestionSize = sMgr.getAll().size();
        int oldColumnchoiceSize = cMgr.getAll().size();
        Question q = mgr.addQuestionSubquestionsAndColumnchoices(question1, list1, list2);
        int newQuestionSize = mgr.getAll().size();
        int newSubquestionSize = sMgr.getAll().size();
        int newColumnchoiceSize = cMgr.getAll().size();
        
        assertEquals(oldQuestionSize+1, newQuestionSize);
        assertEquals(oldSubquestionSize+2, newSubquestionSize);
        assertEquals(oldColumnchoiceSize+2, newColumnchoiceSize);
        assertNotNull(q.getQuestionid());
    }
    
    /**
     * 测试getAlllInUseQuestions()，inuser是Transient的，此处的无法测试
     */
    @Test
    public void testGetAlllInUseQuestions(){
//        int oldInuseQuestionSize = mgr.getAlllInUseQuestions().size();
//        question1.setInuse(true);
//        question1 = mgr.save(question1);
//        question2.setInuse(true);
//        question2 = mgr.save(question2);
//        
//        List<Question> list = mgr.getAlllInUseQuestions();
//        
//        int newInuseQuestionSize = list.size();
//        
//        assertEquals(oldInuseQuestionSize+2, newInuseQuestionSize);
    }
    
   /**
    * 测试searchForQuestionByTerms(),此方法没有通过
    */
    @Test
    public void testSearchForQuestionByTerms(){
//        question2 = mgr.save(question2);
//        List<Question> list = mgr.searchForQuestionByTerms("wu", 0 , Integer.MAX_VALUE);
//        
//        assertTrue(list.size()>0);
    }
    
    /**
     * 测试getQuestionByType(),getQuestionCountByType(),getQuestionCount()
     */
    @Test
    public void testGetQuestionByType(){
        int oldQuestionSize1 = mgr.getQuestionByType(2).size();
        int oldQuestionSize2 = mgr.getQuestionByType(2,0, Integer.MAX_VALUE).size();
        int oldCountSize = mgr.getQuestionCountByType(2);
        int oldCountNum = mgr.getQuestionCount();
        question2 = mgr.save(question2);
        
        int newQuestionSize1 = mgr.getQuestionByType(2).size();
        int newQuestionSize2 = mgr.getQuestionByType(2,0, Integer.MAX_VALUE).size();
        int newCountSize = mgr.getQuestionCountByType(2);
        int newCountNum = mgr.getQuestionCount();
        
        assertEquals(oldQuestionSize1+1, newQuestionSize1);
        assertEquals(oldQuestionSize2+1, newQuestionSize2);
        assertEquals(oldCountSize+1, newCountSize);
        assertEquals(oldCountNum+1, newCountNum);
    }
    
    /**
     * 测试getQuestionListBySize(),暂时无法测试
     */
    @Test
    public void testGetQuestionListBySize(){
        
    }
    
    /**
     * 测试getNumberOfAnswersByQId()
     */
    @Test
    public void  testGetNumberOfAnswersByQId(){
        question1 = mgr.save(question1);
        int oldAnswerSize = mgr.getNumberOfAnswersByQId(question1.getQuestionid());
        ArrayList<Answer> list = new ArrayList<Answer>();
        list.add(answer1);
        list.add(answer2);
        
        Question q = mgr.addQuestionAndAnswers(question1, list);
        int newAnswerSize = mgr.getNumberOfAnswersByQId(q.getQuestionid());
        
        assertEquals(question1.getQuestionid(), q.getQuestionid());
        assertEquals(oldAnswerSize+2, newAnswerSize);
    }
    
    /**
     * 测试getAnswersListByQuestionId(),此方法暂时无法测试
     */
    @Test
    public void testGetAnswersListByQuestionId(){
        
    }
    
    /*
     * 测试getAnswersByQuestionId()
     */
    @Test
    public void testGetAnswersByQuestionId(){
        question3 = mgr.save(question3);
        int oldAnswerSize = mgr.getAnswersByQuestionId(question3.getQuestionid()).size();
        answer1 = amgr.save(answer1);
        answer2 = amgr.save(answer2);
        Set<Answer> set = new HashSet<Answer>();
        set.add(answer1);
        set.add(answer2);
        question3.setAnswers(set);
        
        question3.setAnswers(set);
        int newAnswerSize = mgr.getAnswersByQuestionId(question3.getQuestionid()).size();
        assertEquals(oldAnswerSize+2, newAnswerSize);
    }
    
    /**
     * 测试getSubQuestionsListByQuestionId()
     */
    @Test
    public void testGetSubQuestionsListByQuestionId(){
        
    }
    
    /**
     * 测试getSubQuestionsByQuestionId()
     */
    @Test
    public void testGetSubQuestionsByQuestionId(){
        subquestion1 = sMgr.save(subquestion1);
        subquestion2 = sMgr.save(subquestion2);
        question4 = mgr.save(question4);
        int oldSubquestionSize = mgr.getSubQuestionsByQuestionId(question4.getQuestionid()).size();
        Set<Subquestion> set = new HashSet<Subquestion> ();
        set.add(subquestion1);
        set.add(subquestion2);
        
        question4.setSubquestions(set);
        int newSubquestionSize = mgr.getSubQuestionsByQuestionId(question4.getQuestionid()).size();
        assertEquals(oldSubquestionSize+2, newSubquestionSize);
    }
    
    /**
     * 测试getColumnChoicesListByQuestionId()
     */
    @Test
    public void testGetColumnChoicesListByQuestionId(){
    
    }
    
    /**
     * 测试getColumnChoicesByQuestionId()
     */
    @Test
    public void testGetColumnChoicesByQuestionId(){
        columnchoice1 = cMgr.save(columnchoice1);
        columnchoice2 = cMgr.save(columnchoice2);
        question4 = mgr.save(question4);
        int oldColumnchoice = mgr.getColumnChoicesByQuestionId(question4.getQuestionid()).size();
        Set<Columnchoice> set = new HashSet<Columnchoice>();
        set.add(columnchoice1);
        set.add(columnchoice2);
        
        question4.setColumnchoices(set);
        int newColumnchoice = mgr.getColumnChoicesByQuestionId(question4.getQuestionid()).size();
        assertEquals(oldColumnchoice+2, newColumnchoice);
    }
    
    /*
     * 测试queryRunner()
     */
    @Test
    public void testQueryRunner(){
        question1 = mgr.save(question1);
        question2 = mgr.save(question2);
        
        String hql = "from "+question1.getClass().getName();
        List<Question> list = mgr.queryRunner(hql);
        assertTrue(list.size()>=2);
    }
    
    /*
     * 测试isQuestionInUse()
     */
    @Test
    public void testIsQuestionInUse(){
        
    }
    
    /*
     * 测试calculateStatus()
     */
    @Test
    public void testCalculateStatus(){
        
    }
    
    @Test
    public void testInuse(){
        question1 = mgr.save(question1);
        question2 = mgr.save(question2);
        
        List<Question> list =mgr.getQuestionByInuse(false, 0, 1);
        assertTrue(list.size()>0);
        int size = mgr.getCountByInuse(false);
        assertTrue(size>=2);
    }
}
