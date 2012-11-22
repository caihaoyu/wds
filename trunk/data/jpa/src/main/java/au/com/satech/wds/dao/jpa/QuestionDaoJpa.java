/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.QuestionDao;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Question;
import java.util.List;
import javax.persistence.Query;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.util.Version;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("questionDao")
public class QuestionDaoJpa extends GenericDaoJpa<Question, Integer> implements QuestionDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public QuestionDaoJpa(){
        super(Question.class);
    }
    /**
     * 
     * @param searchTerms
     * @param startIndex
     * @param maxResults
     * @return 
     */
    @Override
    public List<Question> searchForQuestionByTerms(String searchTerms, Integer startIndex, Integer maxResults) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(getEntityManager());
        String[] fieldsToMatch = new String[] {"questiontitle"};
        QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_30, fieldsToMatch, new StandardAnalyzer(Version.LUCENE_30));
        org.apache.lucene.search.Query luceneQuery = null;
        try {
            luceneQuery = parser.parse(searchTerms);
        } catch (ParseException e) {
            log.error("Error parsing lucene query: " + searchTerms);
        }
        Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Question.class);
        if (startIndex != null && maxResults != null) {
            jpaQuery.setFirstResult(startIndex);
            jpaQuery.setMaxResults(maxResults);
        }
        return jpaQuery.getResultList();
    }
    /**
     * 获得一个FullTextEntityManager类型的持久化实体管理器
     * @return 
     */
    @Override
    public FullTextEntityManager getFullTextEntityManager(){
        return Search.getFullTextEntityManager(getEntityManager());
    }
    /**
     * 根据Sql 语句获得一个List<Question>集合
     * @param query sql语句
     * @return 
     */
    @Override
    public List<Question> queryRunner(String query){
        return getEntityManager().createQuery(query).getResultList();
    }
    /**
     * 根据Hql语句获得一个List<Question>的结果集，并且返回相应条数的结果集
     * @param startIndex
     * @param size 
     * @return List<Question>
     */
    @Override
    public List<Question> getQuestionListBySize(int startIndex, int size) {
        
       String hqlString="select q from "+Question.class.getName()+" q order by q.modifiedDate desc";
       Query query=  getEntityManager().createQuery(hqlString);
       query.setFirstResult(startIndex);
       query.setMaxResults(size-startIndex);
       List<Question> list=query.getResultList();
       return list;
    }
    @Override
    public List<Question> getQuestionListBySizeOrderByAsc(int startIndex,int size){
         String hqlString="select q from "+Question.class.getName()+" q order by q.modifiedDate asc";
       Query query=  getEntityManager().createQuery(hqlString);
       query.setFirstResult(startIndex);
       query.setMaxResults(size-startIndex);
       List<Question> list=query.getResultList();
       return list;
    }    
    /**
     * 获得Question里面的总的数据条数
     * @return 
     */
    @Override
    public int getQuestionCount() {
        String hql="select count(*) from "+Question.class.getName()+" as q";
        return (Integer.parseInt( getEntityManager().createQuery(hql).getResultList().get(0).toString()));
       
    }
    /**
     * 判断该Question实例是否被使用
     * @param questionId
     * @return 
     */
    @Override
    public boolean isQuestionInUse(Integer questionId) {
        String hql="select count(*) from "+BranchItem.class.getName()+" as i where i.questionid='"+questionId+"'";
        if((Long)getEntityManager().createQuery(hql).getResultList().get(0)>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Question> getQuestionByType(Integer questionTpye) {
        String hql = "from "+Question.class.getName()+" as q where q.questiontype='"+questionTpye+"'";
        return getEntityManager().createQuery(hql).getResultList();
    }
     @Override
     public int getQuestionCountByType(Integer questionTpye) {
        String hql="select count(*) from "+Question.class.getName()+" as q where q.questiontype='"+questionTpye+"'";
        return (Integer.parseInt( getEntityManager().createQuery(hql).getResultList().get(0).toString()));
       
    }

    @Override
    public List<Question> getQuestionByType(Integer questionTpye, int first, int size) {
        String hql = "from "+Question.class.getName()+" as q where q.questiontype='"+questionTpye+"' order by q.modifiedDate desc";
        Query q=  getEntityManager().createQuery(hql);
        q.setFirstResult(first);
        q.setMaxResults(size);
        return q.getResultList();
    }
    @Override
    public List<Question> getQuestionByTypeOrderByAsc(Integer questionTpye, int first, int size){
         String hql = "from "+Question.class.getName()+" as q where q.questiontype='"+questionTpye+"' order by q.modifiedDate asc";
        Query q=  getEntityManager().createQuery(hql);
        q.setFirstResult(first);
        q.setMaxResults(size);
        return q.getResultList();
    }
     

    @Override
    public List<Question> getQuestionByCreatedate() {
        String hql = "from "+Question.class.getName()+" as q order by q.createDate desc";
        return getEntityManager().createQuery(hql).getResultList();
    }

    @Override
    public List<Question> getQuestionByModifiedDate() {
        String hql = "from "+Question.class.getName()+" as q order by q.modifiedDate desc";
        return getEntityManager().createQuery(hql).getResultList();
    }

    @Override
    public List<Question> getQuestionByCreatedate(int start, int size) {
         String hql = "from "+Question.class.getName()+" as q order by q.createDate desc";
        return getEntityManager().createQuery(hql).setFirstResult(start).setMaxResults(size).getResultList();
    }
    @Override
     public List<Question> getQuestionByCreatedateOrderByAsc(int start,int size){
         String hql = "from "+Question.class.getName()+" as q order by q.createDate asc";
        return getEntityManager().createQuery(hql).setFirstResult(start).setMaxResults(size).getResultList();
    }

    @Override
    public List<Question> getQuestionByModifiedDate(int startI, int size) {
        String hql = "from "+Question.class.getName()+" as q order by q.modifiedDate desc";
        return getEntityManager().createQuery(hql).setFirstResult(startI).setMaxResults(size).getResultList();
    }
    @Override
     public List<Question> getQuestionByModifiedDateOrderByAsc(int startI,int size){
        String hql = "from "+Question.class.getName()+" as q order by q.modifiedDate asc";
        return getEntityManager().createQuery(hql).setFirstResult(startI).setMaxResults(size).getResultList();
    }

    @Override
    public List<Question> getQuestionsByInuse(Integer inuse, int start, int size) {
        String hql = "from "+Question.class.getName()+" as q where q.inuse='"+inuse+"' order by q.modifiedDate desc";
        return getEntityManager().createQuery(hql).setFirstResult(start).setMaxResults(size).getResultList();
    }
    @Override
    public List<Question> getQuestionsByInuseOrderByAsc(Integer inuse,int start, int size){
        String hql = "from "+Question.class.getName()+" as q where q.inuse='"+inuse+"' order by q.modifiedDate asc";
        return getEntityManager().createQuery(hql).setFirstResult(start).setMaxResults(size).getResultList();
    }

    @Override
    public int getCountByInuse(Integer inuse) {
        String hql = "select count(*) from "+Question.class.getName()+" as q where q.inuse='"+inuse+"'";
        return (Integer.parseInt(getEntityManager().createQuery(hql).getResultList().get(0).toString()));
    }

    @Override
    public int CountInuse(Integer qId) {
         String hql="select count(*) from "+BranchItem.class.getName()+" as i where i.questionid='"+qId+"'";
         return  (Integer.parseInt( getEntityManager().createQuery(hql).getResultList().get(0).toString()));
    }
}   
