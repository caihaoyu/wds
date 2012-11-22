/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.AnswerDao;
import au.com.satech.wds.dao.ColumnchoiceDao;
import au.com.satech.wds.dao.QuestionDao;
import au.com.satech.wds.dao.SubquestionDao;
import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Columnchoice;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Subquestion;
import au.com.satech.wds.model.comparators.ColumnChoiceComparator;
import au.com.satech.wds.model.comparators.MultipleAnswerComparator;
import au.com.satech.wds.model.comparators.SubQuestionComparator;
import au.com.satech.wds.service.QuestionManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * QuestionManager 的实现类
 *
 * @author sam
 */
@Service("questionManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class QuestionManagerImpl extends GenericManagerImpl<Question, Integer> implements QuestionManager {

    QuestionDao questionDao;
    @Autowired
    AnswerDao aDao;
    @Autowired
    SubquestionDao sDao;
    @Autowired
    ColumnchoiceDao cDao;

    @Autowired
    public QuestionManagerImpl(QuestionDao questionDao) {
        super(questionDao);
        this.questionDao = questionDao;
    }

    /**
     * 获取正在使用的Question集合
     *
     * @return questionList
     */
    @Transactional(readOnly = true)
    @Override
    public List<Question> getAlllInUseQuestions() {
        List<Question> questions = questionDao.getAll();
        List<Question> inUseQuestions = new ArrayList<Question>();
        //循环迭代获取正在使用的Question对象
        for (Question question : questions) {
            if (question.isInuse()) {
                inUseQuestions.add(question);
            }
        }
        return inUseQuestions;
    }

    /**
     * 获取该Question下Answer的个数
     *
     * @param id
     * @return Integer question.getAnswers().size() Qustion对象中Answer的个数
     */
    @Transactional(readOnly = true)
    @Override
    public int getNumberOfAnswersByQId(Integer id) {
        Question q = questionDao.get(id);
        return q.getAnswers().size();
    }

    /**
     * 保存answersList到question
     *
     * @param question
     * @param answersList Answer集合
     * @return 含有questionId的对象
     */
    @Transactional(readOnly = false)
    @Override
    public Question addQuestionAndAnswers(Question question, ArrayList<Answer> answersList) {
        for (Answer answer : answersList) {
            answer = aDao.save(answer);
            question.getAnswers().add(answer);
        }
        return questionDao.save(question);
    }

    /**
     * 保存subquestionsList到question
     *
     * @param question Question
     * @param subquestionsList 需保存的SubQuestionlist
     * @return question 新的Question
     */
    @Transactional(readOnly = false)
    @Override
    public Question addQuestionAndSubquestions(Question question, ArrayList<Subquestion> subquestionsList) {
        for (Subquestion subquestion : subquestionsList) {
            subquestion = sDao.save(subquestion);
            question.getSubquestions().add(subquestion);
        }
        return questionDao.save(question);
    }

    /**
     * 保存subquestionsList和columnchoicesList到question
     *
     * @param question Question对象
     * @param subquestionsList SubQuestion对象的list集合
     * @param columnchoicesList Columnchoice对象的list集合
     * @return question 含有questionId的对象
     */
    @Transactional(readOnly = false)
    @Override
    public Question addQuestionSubquestionsAndColumnchoices(Question question,
            ArrayList<Subquestion> subquestionsList, ArrayList<Columnchoice> columnchoicesList) {
        for (Subquestion subquestion : subquestionsList) {
            subquestion = sDao.save(subquestion);
            question.getSubquestions().add(subquestion);
        }
        for (Columnchoice columnchoice : columnchoicesList) {
            columnchoice = cDao.save(columnchoice);
            question.getColumnchoices().add(columnchoice);
        }
        return questionDao.save(question);
    }

    /**
     * 对指定question下的Answer集合排序并返回新的List
     *
     * @param questionid
     * @return answerList 新的Answer集合
     */
    @Transactional(readOnly = true)
    @Override
    public List<Answer> getAnswersListByQuestionId(Integer questionid) {
        Question q = dao.get(questionid);
        List<Answer> answers = new ArrayList<Answer>();
        answers.addAll(q.getAnswers());
        Collections.sort(answers, new MultipleAnswerComparator());
        return answers;
    }

    /**
     * 根据String searchTerms检索Question的集合
     *
     * @param searchTerms 检索关键词
     * @param startIndex 开始索引位置
     * @param maxResults 最大检索结果集
     * @return questionList
     */
    @Transactional(readOnly = true)
    @Override
    public List<Question> searchForQuestionByTerms(String searchTerms, Integer startIndex, Integer maxResults) {
        try {
            questionDao.getFullTextEntityManager().createIndexer(Question.class).startAndWait();
        } catch (InterruptedException ex) {
            Logger.getLogger(QuestionManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questionDao.searchForQuestionByTerms(searchTerms, startIndex, maxResults);
    }

    /**
     * 获取正在被使用中的Question集合。
     *
     * @param start
     * @param size
     * @return 正在被使用中的Question集合
     */
    @Transactional(readOnly = false)
    @Override
    public List<Question> getQuestionListBySize(int start, int size) {
        List<Question> list = questionDao.getQuestionListBySize(start, size);
        return list;
    }
    @Transactional(readOnly = false)
    @Override
    public List<Question> getQuestionListBySizeOrderByAsc(int start,int size){
         List<Question> list = questionDao.getQuestionListBySizeOrderByAsc(start, size);
        return list;
    }

    /**
     * 统计Question表里面的总的数据条数
     *
     * @return QuestionCount
     */
    @Transactional(readOnly = false)
    @Override
    public int getQuestionCount() {
        return questionDao.getQuestionCount();
    }

    /**
     * 对指定Question下的Subquestion集合排序并返回
     *
     * @param questionid
     * @return subQuestionList
     */
    @Transactional(readOnly = true)
    @Override
    public List<Subquestion> getSubQuestionsListByQuestionId(Integer questionid) {
        Question q = dao.get(questionid);
        List<Subquestion> list = new ArrayList<Subquestion>();
        list.addAll(q.getSubquestions());
        Collections.sort(list, new SubQuestionComparator());
        return list;
    }

    /**
     * 对指定Question下的ColumnChoice集合排序并返回
     *
     * @param questionid
     * @return columnchoiceList
     */
    @Transactional(readOnly = true)
    @Override
    public List<Columnchoice> getColumnChoicesListByQuestionId(Integer questionid) {
        Question q = dao.get(questionid);
        List<Columnchoice> list = new ArrayList<Columnchoice>();
        list.addAll(q.getColumnchoices());
        Collections.sort(list, new ColumnChoiceComparator());
        return list;
    }

    /**
     * 根据hql语句查询Question
     *
     * @param hql
     * @return questionList
     */
    @Transactional(readOnly = false)
    @Override
    public List<Question> queryRunner(String hql) {
        return questionDao.queryRunner(hql);
    }

    /**
     * 获取指定Question的type属性值等于3的Answer的set集合
     *
     * @param questionid
     * @return set answerSet
     */
    @Transactional(readOnly = true)
    @Override
    public Set<Answer> getAnswersByQuestionId(Integer questionid) {
        Question q = questionDao.get(questionid);
        if (q.getQuestiontype() == 3) {
            return q.getAnswers();
        } else {
            log.error("Answers only belong to choice question.");
            return null;
        }
    }

    /**
     * 获取指定Question的type属性值等于4的Subquestion的set集合
     *
     * @param questionid
     * @return set answerSet
     */
    @Transactional(readOnly = true)
    @Override
    public Set<Subquestion> getSubQuestionsByQuestionId(Integer questionid) {
        Question q = questionDao.get(questionid);
        if (q.getQuestiontype() == 4) {
            return q.getSubquestions();
        } else {
            log.error("Subquestions only belong to Matrix question.");
            return null;
        }
    }

    /**
     * 获取指定Question对象的type属性值等于4的ColumnChoice的set集合
     *
     * @param questionid
     * @return set columnchoiceSet
     */
    @Transactional(readOnly = true)
    @Override
    public Set<Columnchoice> getColumnChoicesByQuestionId(Integer questionid) {
        Question q = questionDao.get(questionid);
        if (q.getQuestiontype() == 4) {
            return q.getColumnchoices();
        } else {
            log.error("Columnchoices only belong to Matrix question.");
            return null;
        }
    }

    /**
     * 判断指定id的Question对象实例是否被使用
     *
     * @param questionId
     * @return boolean
     */
    @Transactional(readOnly = true)
    @Override
    public boolean isQuestionInUse(Integer questionId) {
        return questionDao.isQuestionInUse(questionId);
    }

    @Transactional(readOnly = false)
    @Override
    public void lock(Integer selectedQuestionId, String user) {
        Question question = questionDao.get(selectedQuestionId);
        question.setOccupy(true);
        question.setLockUser(user);
        questionDao.save(question);
    }

    @Transactional(readOnly = false)
    @Override
    public void unlock(Integer selectedQuestionId) {
        Question question = questionDao.get(selectedQuestionId);
        question.setOccupy(false);
        question.setLockUser(null);
        questionDao.save(question);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Question> getQuestionByType(Integer questionTpye) {
        return questionDao.getQuestionByType(questionTpye);
    }

//    @Override
//    @Transactional(readOnly=true)
//    public List<Question> calculateStatus(List<Question> list) {
//        for(Question q:list){
//            if(q.getQuestionid()!=null){
//            q.setInuse(isQuestionInUse(q.getQuestionid()));
//            }
//        }
//        return list;
//    }
    @Override
    @Transactional(readOnly = true)
    public List<Question> getQuestionByType(Integer questionTpye, int first, int size) {
        return questionDao.getQuestionByType(questionTpye, first, size);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Question> getQuestionByTypeOrderByAsc(Integer questionTpye,int first,int size){
        return questionDao.getQuestionByTypeOrderByAsc(questionTpye, first, size);
    }

    @Override
    @Transactional(readOnly = true)
    public int getQuestionCountByType(Integer questionTpye) {
        return questionDao.getQuestionCountByType(questionTpye);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Question> getQuestionByCreatedate() {
        return questionDao.getQuestionByCreatedate();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Question> getQuestionByModifieddate() {
        return questionDao.getQuestionByModifiedDate();
    }

    @Override
    public List<Question> getQuestionByCreatedate(int start, int size) {
        return questionDao.getQuestionByCreatedate(start, size);
    }
    @Override
     public List<Question> getQuestionByCreatedateOrderByAsc(int start,int size){
        return questionDao.getQuestionByCreatedateOrderByAsc(start, size);
    }

    @Override
    public List<Question> getQuestionByModifieddate(int start, int size) {
        return questionDao.getQuestionByModifiedDate(start, size);
    }
    @Override
    public List<Question> getQuestionByModifieddateOrderByAsc(int start,int size){
         return questionDao.getQuestionByModifiedDateOrderByAsc(start, size);
    }

    @Override
    public List<Question> getQuestionByInuse(boolean inuse, int start, int size) {
        int isInuse;
        if (inuse) {
            isInuse = 1;
        } else {
            isInuse = 0;
        }
        return questionDao.getQuestionsByInuse(isInuse, start, size);
    }
     @Override
     public List<Question> getQuestionByInuseOrderByAsc(boolean inuse, int start, int size) {
        int isInuse;
        if (inuse) {
            isInuse = 1;
        } else {
            isInuse = 0;
        }
        return questionDao.getQuestionsByInuseOrderByAsc(isInuse, start, size);
    }

    @Override
    public int getCountByInuse(boolean inuse) {
        int isInuse;
        if (inuse) {
            isInuse = 1;
        } else {
            isInuse = 0;
        }
        return questionDao.getCountByInuse(isInuse);
    }

    @Override
    public int CountInuse(Integer qId) {
        return questionDao.CountInuse(qId);
    }

    ;

    @Transactional(readOnly = false)
    @Override
    public List<Question> getQuestionInExportXml(Integer filterType) {
        List<Question> list = new ArrayList<Question>();
        if (filterType == 0) {
            list = getAll();
        } else if (filterType < 6) {
            list = getQuestionByType(filterType);
        } else {
            if (filterType == 6) {
                list = getQuestionByInuse(true, 0, Integer.MAX_VALUE);
            } else {
                list = getQuestionByInuse(false, 0, Integer.MAX_VALUE);
            }
        }
       list=getQuestionsTillAll(list);

        return list;
    }

    @Transactional(readOnly = false)
    @Override
    public List<Question> getQuestionsTillAll(List<Question> list) {
        for (Question q : list) {
            if (q.getQuestiontype() == 3) {
                List<Answer> answers = new ArrayList<Answer>();
                answers.addAll(getAnswersByQuestionId(q.getQuestionid()));
                q.setAnswersList(answers);
            } else if (q.getQuestiontype() == 4) {
                List<Subquestion> subquestions = new ArrayList<Subquestion>();
                subquestions.addAll(getSubQuestionsByQuestionId(q.getQuestionid()));
                q.setSubquestionsList(subquestions);
                List<Columnchoice> columnchoices = new ArrayList<Columnchoice>();
                columnchoices.addAll(getColumnChoicesByQuestionId(q.getQuestionid()));
                q.setColumnchoicesList(columnchoices);

            }
        }
        return list;
    }
    @Transactional(readOnly=false)
    @Override
    public List<Question> saveQuestionsInImport(List<Question> list) {
        for(Question q:list){
            if(!q.getAnswersList().isEmpty()&&q.getQuestiontype()==3){
                Set<Answer> answers=new HashSet<Answer>();
                for(Answer a:q.getAnswersList()){
                    a=aDao.save(a);
                    answers.add(a);
                }
                q.setAnswers(answers);
            }else if(!q.getSubquestionsList().isEmpty()&&q.getQuestiontype()==4){
                 Set<Subquestion> subquestions=new HashSet<Subquestion>();
                for(Subquestion sub:q.getSubquestionsList()){
                    sub=sDao.save(sub);
                    subquestions.add(sub);
                }
                q.setSubquestions(subquestions);
                if(!q.getColumnchoicesList().isEmpty()&&q.getColumntype()==3){
                     Set<Columnchoice> columnchoices=new HashSet<Columnchoice>();
                    for(Columnchoice cc:q.getColumnchoicesList()){
                        cc=cDao.save(cc);
                        columnchoices.add(cc);
                    }
                    
                    q.setColumnchoices(columnchoices);
                }
            }
            q=questionDao.save(q);
        }
        return list;
    }
}