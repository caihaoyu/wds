/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.Question;
import java.util.List;
import org.hibernate.search.jpa.FullTextEntityManager;

/**
 *
 * @author sam
 */
public interface QuestionDao extends GenericDao<Question, Integer> {
    /**
     * 根据Terms（关键字）查询Question
     * @param searchTerms 关键字
     * @param startIndex 开始索引值
     * @param maxResults 查询的最大结果集数
     * @return  List<Question>
     */
    public List<Question> searchForQuestionByTerms(String searchTerms, Integer startIndex, Integer maxResults);
    /**
     * 根据question type Terms（关键字）查询Question
     * @param questionTpye
     * @param startIndex
     * @param maxResults
     * @return 
     */
    public List<Question> getQuestionByType(Integer questionTpye);
    /**
     * 
     * @return 
     */
    public FullTextEntityManager getFullTextEntityManager();
    /**
     * 根据sql语句查询List<Question>
     * @param query sql语句
     * @return List<Question>
     */
    public List<Question> queryRunner(String query);
    /**
     * 
     * @param startIndex
     * @param size
     * @return 
     */
    public List<Question> getQuestionListBySize(int startIndex,int size);
    public List<Question> getQuestionListBySizeOrderByAsc(int startIndex,int size);
    public int getQuestionCount();
    public boolean isQuestionInUse(Integer questionId);
    public int getQuestionCountByType(Integer questionTpye);
    public List<Question> getQuestionByType(Integer questionTpye, int first, int size);
    public List<Question> getQuestionByTypeOrderByAsc(Integer questionTpye, int first, int size);
    public List<Question> getQuestionByCreatedate();
    public List<Question> getQuestionByCreatedate(int startI,int size);
    public List<Question> getQuestionByCreatedateOrderByAsc(int start,int size);
    public List<Question> getQuestionByModifiedDate();
    public List<Question> getQuestionByModifiedDate(int startI,int size);
    public List<Question> getQuestionByModifiedDateOrderByAsc(int startI,int size);
    
    public List<Question> getQuestionsByInuse(Integer inuse,int start, int size);
    public List<Question> getQuestionsByInuseOrderByAsc(Integer inuse,int start, int size);
    public int getCountByInuse(Integer inuse);
    /**
     * 统计一个question被多少个Item使用
     * @return 
     */
    public int CountInuse(Integer qId);
}
