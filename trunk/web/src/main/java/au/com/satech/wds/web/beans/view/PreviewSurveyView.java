/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Entry;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Survey;
import au.com.satech.wds.model.comparators.BranchItemComparator;
import au.com.satech.wds.model.comparators.PageComparator;
import au.com.satech.wds.service.QuestionManager;
import au.com.satech.wds.service.SurveyManager;
import au.com.satech.wds.web.beans.BaseBean;
import au.com.satech.wds.web.beans.session.PreviewSurveySession;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sam
 */
@ManagedBean(name ="previewSurveyView")
@ViewScoped
public class PreviewSurveyView extends BaseBean implements Serializable {
    @PostConstruct
    public void setup(){
        log.debug("### setup");
        FacesContext context = FacesContext.getCurrentInstance();
        if(getPreviewSurveySession().getSelectedSurveyId() == null){
            try {
                //redirect
                context.getExternalContext().redirect("edit-survey.xhtml");
            } catch (IOException ex) {
                log.error(ex);
            }
            //stop rendering the current page
            context.responseComplete();
        } else {
            setSurvey(surveyManager.get(previewSurveySession.getSelectedSurveyId()));
            List<Page> _pages = new ArrayList<Page>();
            for(Page p:getSurvey().getPages()){
                _pages.add(p);
            }
            if(_pages.size()>0){
                Collections.sort(_pages, new PageComparator());
                Page _page = getSurvey().getPages().get(previewSurveySession.getCurrentPageIndex());
                setPage(_page);
                List<PageBranch> branches = getPage().getPagebranches();
                if(branches.size()>0){
                    for(PageBranch branch:branches){
                        if(branch.getMain()){
                            setPageBranch(branch);
                        }
                    }
                    if(getPageBranch() == null){
                        log.warn("WARN: No Main branch under page.");                             
                    } else {
                        if(getPageBranch().getItems().size()>0){
                            List<BranchItem> _items = new ArrayList<BranchItem>();
                            for(BranchItem i:getPageBranch().getItems()){
                                _items.add(i);
                            }
                            Collections.sort(_items, new BranchItemComparator());
                            setItems(_items);
                            setQuestions(new ArrayList<Question>());
                            for(BranchItem item:getItems()){
                                getQuestions().add(questionManager.get(item.getQuestionid()));
                            }
                        } else {
                            log.warn("WARN: There is no question under this branch.");
                        }
                    }
                } else {
                    log.warn("WARN: This page doesnt contain any branch.");
                }                
            } else {
                log.warn("WARN: This survey doesn't contain any page.");
            }
        }
    }
    
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager surveyManager;
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    @ManagedProperty(value="#{previewSurveySession}")
    private PreviewSurveySession previewSurveySession;
    
    private Survey survey;
    private Page page;
    private PageBranch pageBranch;
    private List<BranchItem> items;
    private List<Question> questions;
    
    private Integer selectedAnswerId;
    
    private List<Entry> entries = new ArrayList<Entry>();
    
    public String existPreview(){
        previewSurveySession.existPreview();
        return "editSurvey";
    }
    
    public void choiceValueChange(Integer questionid){
        if(entries.isEmpty()){
            Entry entry = new Entry();
            entry.setQuestionid(questionid);
            entry.setAnswerid(selectedAnswerId);
            entries.add(entry);
            FacesContext context = FacesContext.getCurrentInstance(); 
            context.addMessage(null, new FacesMessage("INFO:","Your answer is saved."));  
        } else {
            // check if question is been answered
            
        }
        
    }

    /**
     * @return the previewSurveySession
     */
    public PreviewSurveySession getPreviewSurveySession() {
        return previewSurveySession;
    }

    /**
     * @param previewSurveySession the previewSurveySession to set
     */
    public void setPreviewSurveySession(PreviewSurveySession previewSurveySession) {
        this.previewSurveySession = previewSurveySession;
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
     * @return the pageBranch
     */
    public PageBranch getPageBranch() {
        return pageBranch;
    }

    /**
     * @param pageBranch the pageBranch to set
     */
    public void setPageBranch(PageBranch pageBranch) {
        this.pageBranch = pageBranch;
    }

    /**
     * @return the items
     */
    public List<BranchItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<BranchItem> items) {
        this.items = items;
    }

    /**
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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
     * @return the page
     */
    public Page getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Page page) {
        this.page = page;
    }

    /**
     * @return the entries
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    /**
     * @return the selectedAnswerId
     */
    public Integer getSelectedAnswerId() {
        return selectedAnswerId;
    }

    /**
     * @param selectedAnswerId the selectedAnswerId to set
     */
    public void setSelectedAnswerId(Integer selectedAnswerId) {
        this.selectedAnswerId = selectedAnswerId;
    }
}
