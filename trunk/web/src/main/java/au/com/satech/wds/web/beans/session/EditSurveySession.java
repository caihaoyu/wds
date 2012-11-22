/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.session;

import au.com.satech.wds.model.*;
import au.com.satech.wds.model.comparators.BranchItemComparator;
import au.com.satech.wds.service.BranchItemManager;
import au.com.satech.wds.service.QuestionManager;
import au.com.satech.wds.service.SurveyManager;
import au.com.satech.wds.web.beans.BaseBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sam
 */
@ManagedBean(name ="editSurveySession")
@SessionScoped
public class EditSurveySession extends BaseBean implements Serializable {
    @PostConstruct
    public void setup(){
        setSurveyList(surveyManager.getAll());
    }
    
    @PreDestroy
    public void destroy(){
        
    }
    
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager surveyManager;
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    @ManagedProperty(value="#{branchItemManager}")
    private BranchItemManager branchItemManager;
    
    private List<Survey> surveyList;
    
    private Survey selectedSurvey;
    
    private List<Page> pages = new ArrayList<Page>();
    
    private Integer selectedSurveyId;
    private Integer selectedPageId;
    private Integer selectedPageIndex;
    private Integer selectedPageBranchId;
    
    private Integer selectedItemId;
    private Integer selectedItemruleId;
    
    private Integer selectedQuestionId;
    
    public void refreshSurveyList(){
        setSurveyList(surveyManager.getAll());
    }
    
    public void reloadSelectedBranchItem(){
        //TODO: 这里需要进一步测试
    }
    
    public void refreshPages(){
        setPages(surveyManager.retrievePagesBySurveyId(selectedSurveyId));
        loadPageBranches();
    }
        
    private void loadPageBranches(){
        // Pre load DATA before view
        for(Page page:pages){
            List<PageBranch> branches = page.getPagebranches();
            for(PageBranch branch:branches){
                Collections.sort(branch.getItems(), new BranchItemComparator());
            }
        }
    }
    
    /**
        * -------================ Getter and Setter ================-------
        */

    /**
     * @return the selectedSurveyId
     */
    public Integer getSelectedSurveyId() {
        return selectedSurveyId;
    }

    /**
     * @param selectedSurveyId the selectedSurveyId to set
     */
    public void setSelectedSurveyId(Integer selectedSurveyId) {
        this.selectedSurveyId = selectedSurveyId;
    }

    /**
     * @return the selectedPageId
     */
    public Integer getSelectedPageId() {
        return selectedPageId;
    }

    /**
     * @param selectedPageId the selectedPageId to set
     */
    public void setSelectedPageId(Integer selectedPageId) {
        this.selectedPageId = selectedPageId;
    }

    /**
     * @return the selectedPageIndex
     */
    public Integer getSelectedPageIndex() {
        return selectedPageIndex;
    }

    /**
     * @param selectedPageIndex the selectedPageIndex to set
     */
    public void setSelectedPageIndex(Integer selectedPageIndex) {
        this.selectedPageIndex = selectedPageIndex;
    }

    /**
     * @return the selectedPageBranchId
     */
    public Integer getSelectedPageBranchId() {
        return selectedPageBranchId;
    }

    /**
     * @param selectedPageBranchId the selectedPageBranchId to set
     */
    public void setSelectedPageBranchId(Integer selectedPageBranchId) {
        this.selectedPageBranchId = selectedPageBranchId;
    }

    /**
     * @return the surveyList
     */
    public List<Survey> getSurveyList() {
        return surveyList;
    }

    /**
     * @param surveyList the surveyList to set
     */
    public void setSurveyList(List<Survey> surveyList) {
        this.surveyList = surveyList;
    }

    /**
     * @return the surveyManager
     */
    public SurveyManager getSurveyManager() {
        return surveyManager;
    }

    /**
     * @param surveyManager the surveyManager to set
     */
    public void setSurveyManager(SurveyManager surveyManager) {
        this.surveyManager = surveyManager;
    }

    /**
     * @return the pages
     */
    public List<Page> getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    /**
     * @return the selectedSurvey
     */
    public Survey getSelectedSurvey() {
        return selectedSurvey;
    }

    /**
     * @param selectedSurvey the selectedSurvey to set
     */
    public void setSelectedSurvey(Survey selectedSurvey) {
        this.selectedSurvey = selectedSurvey;
    }

    /**
     * @return the questionManager
     */
    public QuestionManager getQuestionManager() {
        return questionManager;
    }

    /**
     * @param questionManager the questionManager to set
     */
    public void setQuestionManager(QuestionManager questionManager) {
        this.questionManager = questionManager;
    }

    /**
     * @return the selectedItemId
     */
    public Integer getSelectedItemId() {
        return selectedItemId;
    }

    /**
     * @param selectedItemId the selectedItemId to set
     */
    public void setSelectedItemId(Integer selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

    /**
     * @return the selectedItemruleId
     */
    public Integer getSelectedItemruleId() {
        return selectedItemruleId;
    }

    /**
     * @param selectedItemruleId the selectedItemruleId to set
     */
    public void setSelectedItemruleId(Integer selectedItemruleId) {
        this.selectedItemruleId = selectedItemruleId;
    }

    /**
     * @return the branchItemManager
     */
    public BranchItemManager getBranchItemManager() {
        return branchItemManager;
    }

    /**
     * @param branchItemManager the branchItemManager to set
     */
    public void setBranchItemManager(BranchItemManager branchItemManager) {
        this.branchItemManager = branchItemManager;
    }

    /**
     * @return the selectedQuestionId
     */
    public Integer getSelectedQuestionId() {
        return selectedQuestionId;
    }

    /**
     * @param selectedQuestionId the selectedQuestionId to set
     */
    public void setSelectedQuestionId(Integer selectedQuestionId) {
        this.selectedQuestionId = selectedQuestionId;
    }
}
