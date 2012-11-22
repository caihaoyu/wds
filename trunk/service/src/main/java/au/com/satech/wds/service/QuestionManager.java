/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service;

import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Columnchoice;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Subquestion;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

   /**
    *
    * @author sam
    */
public interface QuestionManager extends GenericManager<Question, Integer> {
     /**
     * 保存answersList到question
     * @param question 
     * @param answersList Answer集合
     * @return 含有questionId的对象
     */
    public Question addQuestionAndAnswers(Question question, ArrayList<Answer> answersList);
    /**
     * 保存subquestionsList到question
     * @param question Question
     * @param subquestionsList 需保存的SubQuestionlist
     * @return question 新的Question
     */
    public Question addQuestionAndSubquestions(Question question, ArrayList<Subquestion> subquestionsList);
    /**
     * 保存subquestionsList和columnchoicesList到question
     * @param question Question对象
     * @param subquestionsList SubQuestion对象的list集合
     * @param columnchoicesList Columnchoice对象的list集合
     * @return question 含有questionId的对象
     */
    public Question addQuestionSubquestionsAndColumnchoices(Question question, ArrayList<Subquestion> subquestionsList, ArrayList<Columnchoice> columnchoicesList);
    /**
     * 获取正在使用的Question集合
     * @return questionList  
     */
    public List<Question> getAlllInUseQuestions();
    /**
     * 根据String searchTerms检索Question的集合 
     * @param searchTerms 检索关键词
     * @param startIndex 开始索引位置
     * @param maxResults 最大检索结果集
     * @return questionList
     */
    public List<Question> searchForQuestionByTerms(String searchTerms, Integer startIndex, Integer maxResults);
    /**
     * 根据question type Terms（关键字）查询Question
     * @param searchTerms
     * @param startIndex
     * @param maxResults
     * @return 
     */
    public List<Question> getQuestionByType(Integer questionTpye);
    public List<Question> getQuestionByType(Integer questionTpye,int first,int size);
    public List<Question> getQuestionByTypeOrderByAsc(Integer questionTpye,int first,int size);
    public int getQuestionCountByType(Integer questionTpye);
    /**
     * 获取正在被使用中的Question集合。
     * @param start
     * @param size
     * @return 正在被使用中的Question集合
     */
    public List<Question> getQuestionListBySize(int start,int size);
    public List<Question> getQuestionListBySizeOrderByAsc(int srart,int size);
    /**
     * 返回Question表里面的总的数据条数
     * @return QuestionCount 
     */
    public int getQuestionCount();
   /**
    * 获取指定Question下的Answer的个数
    * @param id
    * @return Integer question.getAnswers().size() Qustion对象中Answer的个数
    */
    public int getNumberOfAnswersByQId(Integer id);
    /**
     *对指定question下的Answer集合排序并返回新的List
     * @param questionid
     * @return answerList 新的Answer集合
     */
    public List<Answer> getAnswersListByQuestionId(Integer questionid);
    /**
     * 获取指定Question的type属性值等于3的Answer的set集合
     * @param questionid
     * @return set answerSet
     */
    public Set<Answer> getAnswersByQuestionId(Integer questionid);
    /**
     * 对指定Question下的Subquestion集合排序并返回
     * @param questionid
     * @return subQuestionList
     */
    public List<Subquestion> getSubQuestionsListByQuestionId(Integer questionid);
    /**
     * 获取指定Question的type属性值等于4的Subquestion的set集合
     * @param questionid
     * @return set answerSet
     */
    public Set<Subquestion> getSubQuestionsByQuestionId(Integer questionid);
    /**
     * 对指定Question下的ColumnChoice集合排序并返回
     * @param questionid
     * @return columnchoiceList
     */
    public List<Columnchoice> getColumnChoicesListByQuestionId(Integer questionid);
    /**
     * 获取指定Question对象的type属性值等于4的ColumnChoice的set集合
     * @param questionid
     * @return set columnchoiceSet
     */
    public Set<Columnchoice> getColumnChoicesByQuestionId(Integer questionid);
    /**
     * 根据hql语句查询Question
     * @param hql
     * @return questionList
     */
    public List<Question> queryRunner(String hql);
    /**
     * 判断指定的Question是否被使用
     * @param questionId
     * @return boolean
     */
    public boolean isQuestionInUse(Integer questionId);
    /**
     * 锁住Question
     * 
     */
    public void lock(Integer selectedQuestionId, String user);
    /**
     * 解锁功能
     */
    public void unlock(Integer selectedQuestionId);
    public List<Question> getQuestionByCreatedate();
    public List<Question> getQuestionByCreatedate(int start,int size); 
    public List<Question> getQuestionByCreatedateOrderByAsc(int start,int size); 
    public List<Question> getQuestionByModifieddate();
    public List<Question> getQuestionByModifieddate(int start,int size);
    public List<Question> getQuestionByModifieddateOrderByAsc(int start,int size);
    public List<Question> getQuestionByInuse(boolean inuse,int start,int size);
    public List<Question> getQuestionByInuseOrderByAsc(boolean inuse, int start, int size);
    public int getCountByInuse(boolean inuse);
    public List<Question> getQuestionInExportXml(Integer filterType);
    public List<Question> getQuestionsTillAll(List<Question> list);
    public List<Question> saveQuestionsInImport(List<Question> list);
    /**
     * 统计这个question正在被几个item使用
     * @param qId
     * @return 
     */
    public int CountInuse(Integer qId);
}
    
