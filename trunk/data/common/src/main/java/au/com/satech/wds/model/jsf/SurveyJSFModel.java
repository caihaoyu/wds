/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model.jsf;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.Survey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhao
 */
public class SurveyJSFModel implements Serializable {
    
    private Survey survey;
    
    private Page currPage;
    
    private Map deletedPages;
    
    private Map defaultBranchRecorder;
    
    private Map defaultItemRecorder;
    
    private Integer currentPageIndex;
    
    private Integer answeringIndex;
    
    private Integer ratio;
    
    private List<ViolationRuleJSFModel> violationRules;
    
    private boolean isLastPage;
    
    private boolean isFirstPage;
    
    private BranchItem answeringItem;
    
    private boolean currPageAllFinished;
    
    public SurveyJSFModel()
    {
        deletedPages = new HashMap();
        defaultBranchRecorder = new HashMap();
        defaultItemRecorder = new HashMap();
        currentPageIndex = 0;
        answeringIndex = 0;
        ratio = 0;
        violationRules = new ArrayList<ViolationRuleJSFModel>();
        currPageAllFinished = false;
    }

    /**
     * @return the survey
     */
    public Survey getSurvey() {
        return survey;
    }

    /**
     * @param survey the survey to set
     */
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    /**
     * @return the deletedPages
     */
    public Map getDeletedPages() {
        return deletedPages;
    }

    /**
     * @param deletedPages the deletedPages to set
     */
    public void setDeletedPages(Map deletedPages) {
        this.deletedPages = deletedPages;
    }

    /**
     * @return the defaultBranchRecorder
     */
    public Map getDefaultBranchRecorder() {
        return defaultBranchRecorder;
    }

    /**
     * @param defaultBranchRecorder the defaultBranchRecorder to set
     */
    public void setDefaultBranchRecorder(Map defaultBranchRecorder) {
        this.defaultBranchRecorder = defaultBranchRecorder;
    }

    /**
     * @return the currentPageIndex
     */
    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    /**
     * @param currentPageIndex the currentPageIndex to set
     */
    public void setCurrentPageIndex(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    /**
     * @return the answeringIndex
     */
    public Integer getAnsweringIndex() {
        return answeringIndex;
    }

    /**
     * @param answeringIndex the answeringIndex to set
     */
    public void setAnsweringIndex(Integer answeringIndex) {
        this.answeringIndex = answeringIndex;
    }

    /**
     * @return the ratio
     */
    public Integer getRatio() {
        return ratio;
    }

    /**
     * @param ratio the ratio to set
     */
    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    /**
     * @return the violationRules
     */
    public List<ViolationRuleJSFModel> getViolationRules() {
        return violationRules;
    }

    /**
     * @param violationRules the violationRules to set
     */
    public void setViolationRules(List<ViolationRuleJSFModel> violationRules) {
        this.violationRules = violationRules;
    }

    /**
     * @return the isLastPage
     */
    public boolean isIsLastPage() {
        return isLastPage;
    }

    /**
     * @param isLastPage the isLastPage to set
     */
    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    /**
     * @return the isFirstPage
     */
    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    /**
     * @param isFirstPage the isFirstPage to set
     */
    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    /**
     * @return the answeringItem
     */
    public BranchItem getAnsweringItem() {
        return answeringItem;
    }

    /**
     * @param answeringItem the answeringItem to set
     */
    public void setAnsweringItem(BranchItem answeringItem) {
        this.answeringItem = answeringItem;
    }

    /**
     * @return the currPage
     */
    public Page getCurrPage() {
        return currPage;
    }

    /**
     * @param currPage the currPage to set
     */
    public void setCurrPage(Page currPage) {
        this.currPage = currPage;
    }

    /**
     * @return the defaultItemRecorder
     */
    public Map getDefaultItemRecorder() {
        return defaultItemRecorder;
    }

    /**
     * @param defaultItemRecorder the defaultItemRecorder to set
     */
    public void setDefaultItemRecorder(Map defaultItemRecorder) {
        this.defaultItemRecorder = defaultItemRecorder;
    }

    /**
     * @return the currPageAllFinished
     */
    public boolean isCurrPageAllFinished() {
        return currPageAllFinished;
    }

    /**
     * @param currPageAllFinished the currPageAllFinished to set
     */
    public void setCurrPageAllFinished(boolean currPageAllFinished) {
        this.currPageAllFinished = currPageAllFinished;
    }
    
}
