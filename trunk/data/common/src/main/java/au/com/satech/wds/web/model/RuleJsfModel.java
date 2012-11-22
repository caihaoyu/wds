/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.model;

import java.io.Serializable;

/**
 *
 * @author cai
 */
public class RuleJsfModel implements Serializable {
    private Integer currentPageId;
    private Integer currentPageBranchId;
    private Integer selectedItemId;
    private Integer selectedItemruleId;
    private Integer selectedSurveyId;
    private Integer selectedPageId;
    private Integer selectedPageIndex;
    private Integer selectedPageBranchId;

    public RuleJsfModel(Integer currentPageId, Integer currentPageBranchId, Integer selectedItemId, Integer selectedItemruleId, Integer selectedSurveyId) {
        this.currentPageId = currentPageId;
        this.currentPageBranchId = currentPageBranchId;
        this.selectedItemId = selectedItemId;
        this.selectedItemruleId = selectedItemruleId;
        this.selectedSurveyId = selectedSurveyId;
    }

    public Integer getCurrentPageId() {
        return currentPageId;
    }

    public void setCurrentPageId(Integer currentPageId) {
        this.currentPageId = currentPageId;
    }

    public Integer getCurrentPageBranchId() {
        return currentPageBranchId;
    }

    public void setCurrentPageBranchId(Integer currentPageBranchId) {
        this.currentPageBranchId = currentPageBranchId;
    }

    public Integer getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(Integer selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

    public Integer getSelectedItemruleId() {
        return selectedItemruleId;
    }

    public void setSelectedItemruleId(Integer selectedItemruleId) {
        this.selectedItemruleId = selectedItemruleId;
    }

    public Integer getSelectedSurveyId() {
        return selectedSurveyId;
    }

    public void setSelectedSurvey(Integer selectedSurveyId) {
        this.selectedSurveyId = selectedSurveyId;
    }

    public Integer getSelectedPageId() {
        return selectedPageId;
    }

    public void setSelectedPageId(Integer selectedPageId) {
        this.selectedPageId = selectedPageId;
    }

    public Integer getSelectedPageIndex() {
        return selectedPageIndex;
    }

    public void setSelectedPageIndex(Integer selectedPageIndex) {
        this.selectedPageIndex = selectedPageIndex;
    }

    public Integer getSelectedPageBranchId() {
        return selectedPageBranchId;
    }

    public void setSelectedPageBranchId(Integer selectedPageBranchId) {
        this.selectedPageBranchId = selectedPageBranchId;
    }

  
    
    
    
}
