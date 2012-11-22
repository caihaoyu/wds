/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.Survey;
import au.com.satech.wds.model.SurveyResponse;
import au.com.satech.wds.model.jsf.SurveyJSFModel;
import java.util.List;

/**
 *
 * @author sam
 */
public interface SurveyManager extends GenericManager<Survey, Integer> {
    /**
     * 根据title查询Survey
     * @param title
     * @return Survey
     */
    Survey loadSurveyBySurveyTitle(String title);
    /**
     * 添加page到指定Survey里面并返回survey
     * @param sid surveyId
     * @param page 需要添加的page
     * @return Survey 新的Survey
     */
    public Survey addPagetoSurvey(Integer sid, Page page);
    /**
     * 保存page到指定survey里面并返回新的PageId
     * @param sid surveyId
     * @param page 需要保存的page
     * @return pageId 新的pageId
     */
    public Integer saveSurveyAndPage(Integer sid, Page page);
   /**
    * 删除指定survey里面指定的page并返回
    * @param sid surveyId
    * @param pageid pageId
    * @return 新的survey
    */
    public Survey removePageFromSurvey(Integer sid, Integer pageid);
   /**
    * 对survey下的pageList从新排序并返回
    * @param sid
    * @return pageList 
    */
    public List<Page> getPagesList(Integer sid);
    /**
     * 从新组装指定Survey下的Page关联到BrancItem并返回
     * @param sid
     * @return pageList
     */
    public List<Page> getPageListTillItem(Integer sid);
    /**
     * 从新组装survey下的Page关联到ItemRule并返回pageList
     * @param sid
     * @return pagesList
     */
    public List<Page> getPageListTillRule(Integer sid);
    /**
     * 重新组装survey其下层所有Object
     * @param sid
     * @return survey 新的survey
     */
    public Survey generateSurveyTree(Integer sid);
    /**
     * 锁住surey
     * 
     */
    public void lock(Integer surveyId, String user);
    /**
     * 解锁功能
     */
    public void unlock(Integer surveyId);
    
    /**
     * calculating accomplishment ratio
     */
    public void calculateAccomplishmentRatio(SurveyJSFModel surveyJSFModel);
    
    /**
     * set item index for display.
     */
    public void setItemIndex(List<BranchItem> itemsList);
    
    /**
     * check if all mandatory questions has been answered.
     */
    public boolean isAllMandatoryQAnswered(Page currPage);
    
    /**
     * check if all optional questions has been answered.
     */
    public boolean isAllOptionalQAnswered(Page currPage);
    
    /**
     * check if the answer is empty
     */
    public boolean isAnswerValueEmpty(BranchItem selectedItem);
    
    /**
     * skip has not answered optional questions
     */
    public void skipRestOptionalQuestions(Page currPage);
    
    /**
     * clean answers of one question.
     */
    public void cleanAnswer(BranchItem selectedItem);
    
    /**
     * Change survey with rules.
     * @return 
     */
    public void changeSurveywithRules(boolean skip, BranchItem selectedItem, SurveyJSFModel surveyJSFModel, Integer selectedItemIndex);
    
    /**
     * Check violation rules.
     */
    public void checkViolationRule(SurveyJSFModel surveyJSFModel);
    
    /**
     * check if questions in this page are all finished.
     */
    public boolean checkCurrPageAllFinished(SurveyJSFModel surveyJSFModel);
    
    /**
     * save answer.
     */
    public void saveAnswer(SurveyJSFModel surveyJSFModel, SurveyResponse surveyResponse);
    
    /**
     * clean answer.
     */
    public SurveyResponse cleanAnswer(SurveyJSFModel surveyJSFModel, SurveyResponse surveyResponse);
}
