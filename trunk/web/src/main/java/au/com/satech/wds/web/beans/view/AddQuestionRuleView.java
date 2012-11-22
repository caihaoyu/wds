/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.*;
import au.com.satech.wds.service.*;
import au.com.satech.wds.web.beans.BaseBean;
import au.com.satech.wds.web.beans.session.EditSurveySession;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author sam
 */
@ManagedBean(name ="addQuestionRuleView")
@ViewScoped
public class AddQuestionRuleView extends BaseBean implements Serializable {
    
    @PostConstruct
    public void setup(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(editSurveySession.getSelectedSurveyId() == null || editSurveySession.getSelectedSurvey() == null){
            try {
                //redirect
                context.getExternalContext().redirect("edit-survey.xhtml");
            } catch (IOException ex) {
                log.error(ex);
            }
            //stop rendering the current page
            context.responseComplete();
        } else  if(editSurveySession.getSelectedItemId() == null){
            try {
                //redirect
                context.getExternalContext().redirect("branching-and-logic.xhtml");
            } catch (IOException ex) {
                log.error(ex);
            }
            //stop rendering the current page
            context.responseComplete();
        } else {
            condition = new Condition();
            condition.setSkips(true);
            branchItemRule = new BranchItemRule();
            BranchItem selectedBranchItem = getBranchItemManager().get(editSurveySession.getSelectedItemId());
            Question question = questionManager.get(selectedBranchItem.getQuestionid());
            setQuestionTitle(question.getQuestiontitle());
        }
    }
    
    @ManagedProperty(value="#{editSurveySession}")
    private EditSurveySession editSurveySession;
    
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager surveyManager;
    
    @ManagedProperty(value="#{pageManager}")
    private PageManager pageManager;
    
    @ManagedProperty(value="#{pageBranchManager}")
    private PageBranchManager pageBranchManager;
    
    @ManagedProperty(value="#{conditionManager}")
    private ConditionManager conditionManager;
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    @ManagedProperty(value="#{branchItemManager}")
    private BranchItemManager branchItemManager;
    
    @ManagedProperty(value="#{resultManager}")
    private ResultManager resultManager;
    
    @ManagedProperty(value="#{branchItemRuleManager}")
    private BranchItemRuleManager branchItemRuleManager;
    
    private String QuestionTitle;
    
    private BranchItemRule branchItemRule;
    private Condition condition;
    private List<Result> results;
    
    private List pageItems = new ArrayList();
    private List pageBranchItems = new ArrayList();
    private BranchItem[] selectedItems;
    private List<BranchItem> hiddenItems;
    private DataTable hiddenItemTable = new DataTable();
        
    // popup content
    private String warnPopContent;
    
    public String processBackButton(){
        editSurveySession.setSelectedItemId(null);
        editSurveySession.setSelectedItemruleId(null);
        return "branching";
    }
    
    public void resetRuleType(){
        branchItemRule.setRuletype(null);
        editSurveySession.setSelectedPageId(null);
        editSurveySession.setSelectedPageBranchId(null);
        setHiddenItems(null);
    }
    
    public void actionSelectionValueChange(){
        getPageItems().clear();
        Survey selectedSurvey = getSurveyManager().get(editSurveySession.getSelectedSurveyId());
        selectedSurvey.setPageList(surveyManager.getPageListBySurveyId(selectedSurvey.getSid()));
        List<Page> pages = selectedSurvey.getPageList();
        for(Page page:pages){
            getPageItems().add(new SelectItem(page.getPageid(), page.getPagetitle()));
        }
        editSurveySession.setSelectedPageId(null);
        editSurveySession.setSelectedPageBranchId(null);
    }
    
    public void pageSelectionValueChange(){
        if(editSurveySession.getSelectedPageId() != null){
            if(branchItemRule.getRuletype()==1||branchItemRule.getRuletype()==2){
                getPageBranchItems().clear();
                Page page = getPageManager().get(editSurveySession.getSelectedPageId());
                page.setPageBranchList(pageManager.getPageBranchsByPageId(page.getPageid()));
                List<PageBranch> branches = page.getPageBranchList();
                for(PageBranch branch:branches){
                    getPageBranchItems().add(new SelectItem(branch.getBranchid(), branch.getBranchname()));
                }
            }
            
        }
    }
    
    public void pageBranchSelectionValueChange(){
        if(branchItemRule.getRuletype() == 1){
            setHiddenItems(new ArrayList<BranchItem>(pageBranchManager.getHiddens(editSurveySession.getSelectedPageBranchId())));
        }         
    }
    
    public String saveQuestionRule(){
        FacesContext context = FacesContext.getCurrentInstance();
        switch (branchItemRule.getRuletype()) {
            case 1: return savingShowHiddenQuestion(context);
            case 2: return savingChangeDefaultBranchOfPage(context);
            case 3: return savingJumpToPageRA(context);
            case 4: return savingJumpToPageAP(context);
        }
        return "";
    }
    
    // rule type == 4
    private String savingJumpToPageAP(FacesContext context){
        condition = conditionManager.saveCondition(condition);
        branchItemRule.setCondition(condition);
        Result result = new Result();
        result.setPageid_ap(editSurveySession.getSelectedPageId());
        result = resultManager.saveResult(result);
        branchItemRule.getResults().add(result);
        StringBuilder sb = new StringBuilder();
        sb.append("If the user ");
        if(branchItemRule.getCondition().getSkips()) {
            sb.append("skips ");
        } else {
            sb.append("answers ");
        }
        sb.append("this question. Jump to page (");
        sb.append(editSurveySession.getSelectedPageId());
        sb.append(") after page.");
        branchItemRule.setRulename(sb.toString());
        log.debug("### branchitemrule: "+getBranchItemRule());
        branchItemRule = getBranchItemRuleManager().savebranchItemRule(branchItemRule);
        BranchItem targetBranchItem = getBranchItemManager().get(editSurveySession.getSelectedItemId());
        targetBranchItem.getRules().add(branchItemRule);
        targetBranchItem = branchItemManager.saveBranchItem(targetBranchItem);
        // Face Message
        StringBuilder msg = new StringBuilder();
        msg.append("New question rule (ID:");
        msg.append(branchItemRule.getRuleid());
        msg.append(") created for question(");
        msg.append(targetBranchItem.getQuestionid());
        msg.append(").");
        context.getExternalContext().getFlash().putNow("msg", msg);
        // refresh pages
        editSurveySession.refreshPages();
        return "branching";
    }
    
    // rule type == 3
    private String savingJumpToPageRA(FacesContext context){
        condition = conditionManager.saveCondition(condition);
        branchItemRule.setCondition(condition);
        Result result = new Result();
        result.setPageid_aq(editSurveySession.getSelectedPageId());
        result = resultManager.saveResult(result);
        branchItemRule.getResults().add(result);
        StringBuilder sb = new StringBuilder();
        sb.append("If the user ");
        if(branchItemRule.getCondition().getSkips()) {
            sb.append("skips ");
        } else {
            sb.append("answers ");
        }
        sb.append("this question. Jump to page (");
        sb.append(editSurveySession.getSelectedPageId());
        sb.append(") immediately.");
        branchItemRule.setRulename(sb.toString());
        branchItemRule = getBranchItemRuleManager().savebranchItemRule(branchItemRule);
        BranchItem targetBranchItem = branchItemManager.get(editSurveySession.getSelectedItemId());
        targetBranchItem.getRules().add(branchItemRule);
        targetBranchItem = branchItemManager.saveBranchItem(targetBranchItem);
        // Face Message
        StringBuilder msg = new StringBuilder();
        msg.append("New question rule (ID:");
        msg.append(branchItemRule.getRuleid());
        msg.append(") created for question(");
        msg.append(targetBranchItem.getQuestionid());
        msg.append(").");
        context.getExternalContext().getFlash().putNow("msg", msg);
        // refresh pages
        editSurveySession.refreshPages();
        return "branching";
    }
    
    // rule type = 2
    private String savingChangeDefaultBranchOfPage(FacesContext context){
        condition = conditionManager.saveCondition(condition);
        branchItemRule.setCondition(condition);
        Result result = new Result();
        result.setPageid(editSurveySession.getSelectedPageId());
        result.setPagebranchid(editSurveySession.getSelectedPageBranchId());
        result = getResultManager().saveResult(result);
        branchItemRule.getResults().add(result);
        StringBuilder sb = new StringBuilder();
        sb.append("If the user ");
        if(branchItemRule.getCondition().getSkips()) {
            sb.append("skips ");
        } else {
            sb.append("answers ");
        }
        sb.append("this question. ");
        sb.append("Temporarily set pagebranch (");
        sb.append(editSurveySession.getSelectedPageBranchId());
        sb.append(") of page (");
        sb.append(editSurveySession.getSelectedPageId());
        sb.append(") as default.");
        branchItemRule.setRulename(sb.toString());
        branchItemRule = getBranchItemRuleManager().savebranchItemRule(branchItemRule);
        BranchItem targetBranchItem =branchItemManager.get(editSurveySession.getSelectedItemId());
        targetBranchItem.getRules().add(branchItemRule);
        targetBranchItem = branchItemManager.saveBranchItem(targetBranchItem);
        // Face Message
        StringBuilder msg = new StringBuilder();
        msg.append("New question rule (ID:");
        msg.append(branchItemRule.getRuleid());
        msg.append(") created for question(");
        msg.append(targetBranchItem.getQuestionid());
        msg.append(").");
        context.getExternalContext().getFlash().putNow("msg", msg);
        // refresh pages
        editSurveySession.refreshPages();
        return "branching";
    }

    // rule type == 1
    private String savingShowHiddenQuestion(FacesContext context){
        condition = conditionManager.saveCondition(condition);
        branchItemRule.setCondition(condition);
        for(int i=0;i<getSelectedItems().length;i++){
            Result result = new Result();
            result.setDisplays(getSelectedItems()[i].getBranchitemid());
            result = getResultManager().saveResult(result);
            branchItemRule.getResults().add(result);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("If the user ");
        if(branchItemRule.getCondition().getSkips()) {
            sb.append("skips ");
        } else {
            sb.append("answers ");
        }
        sb.append("this question. Show ");
        if(branchItemRule.getResults().size()==1) {
            sb.append("one hidden question.");
        } else {
            sb.append(branchItemRule.getResults().size());
            sb.append(" hidden questions.");
        }
        branchItemRule.setRulename(sb.toString());
        branchItemRule =  getBranchItemRuleManager().savebranchItemRule(branchItemRule);
        BranchItem targetBranchItem =branchItemManager.get(editSurveySession.getSelectedItemId());
        targetBranchItem.getRules().add(branchItemRule);
        targetBranchItem = branchItemManager.saveBranchItem(targetBranchItem);
        StringBuilder msg = new StringBuilder();
        msg.append("New question rule (ID:");
        msg.append(branchItemRule.getRuleid());
        msg.append(") created for question(ID:");
        msg.append(targetBranchItem.getQuestionid());
        msg.append(").");
        context.getExternalContext().getFlash().putNow("msg", msg);
        editSurveySession.refreshPages();
        return "branching";
    }
    
    public boolean renderSaveButton(){
        if(branchItemRule.getRuletype() == null){
            return false;
        } else {
            switch(branchItemRule.getRuletype()){
                case 1: 
                    if(selectedItems == null) return false;
                    if(editSurveySession.getSelectedPageId()!=null&&editSurveySession.getSelectedPageBranchId()!=null&&selectedItems.length>0){
                        return true;
                    } else {
                        return false;
                    }
                case 2: 
                    if(editSurveySession.getSelectedPageId()!=null&&editSurveySession.getSelectedPageBranchId()!=null){
                        return true;
                    } else {
                        return false;
                    }
                case 3: 
                    if(editSurveySession.getSelectedPageId()!= null){
                        return true;
                    } else {
                        return false;
                    }
                case 4:
                    if(editSurveySession.getSelectedPageId()!= null){
                        return true;
                    } else {
                        return false;
                    }
            }
        }
        return false;
    }
    
    /**
        * -------================ Getter and Setter ================-------
        */

    /**
     * @return the editSurveySession
     */
    public EditSurveySession getEditSurveySession() {
        return editSurveySession;
    }

    /**
     * @param editSurveySession the editSurveySession to set
     */
    public void setEditSurveySession(EditSurveySession editSurveySession) {
        this.editSurveySession = editSurveySession;
    }

    /**
     * @return the condition
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    /**
     * @return the results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * @return the pageItems
     */
    public List getPageItems() {
        return pageItems;
    }

    /**
     * @param pageItems the pageItems to set
     */
    public void setPageItems(List pageItems) {
        this.pageItems = pageItems;
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
     * @return the pageBranchItems
     */
    public List getPageBranchItems() {
        return pageBranchItems;
    }

    /**
     * @param pageBranchItems the pageBranchItems to set
     */
    public void setPageBranchItems(List pageBranchItems) {
        this.pageBranchItems = pageBranchItems;
    }

    /**
     * @return the pageManager
     */
    public PageManager getPageManager() {
        return pageManager;
    }

    /**
     * @param pageManager the pageManager to set
     */
    public void setPageManager(PageManager pageManager) {
        this.pageManager = pageManager;
    }

    /**
     * @return the hiddenItems
     */
    public List<BranchItem> getHiddenItems() {
        return hiddenItems;
    }

    /**
     * @param hiddenItems the hiddenItems to set
     */
    public void setHiddenItems(List<BranchItem> hiddenItems) {
        this.hiddenItems = hiddenItems;
    }

    /**
     * @return the hiddenItemTable
     */
    public DataTable getHiddenItemTable() {
        return hiddenItemTable;
    }

    /**
     * @param hiddenItemTable the hiddenItemTable to set
     */
    public void setHiddenItemTable(DataTable hiddenItemTable) {
        this.hiddenItemTable = hiddenItemTable;
    }

    /**
     * @return the selectedItems
     */
    public BranchItem[] getSelectedItems() {
        return selectedItems;
    }

    /**
     * @param selectedItems the selectedItems to set
     */
    public void setSelectedItems(BranchItem[] selectedItems) {
        this.selectedItems = selectedItems;
    }

    /**
     * @return the pageBranchManager
     */
    public PageBranchManager getPageBranchManager() {
        return pageBranchManager;
    }

    /**
     * @param pageBranchManager the pageBranchManager to set
     */
    public void setPageBranchManager(PageBranchManager pageBranchManager) {
        this.pageBranchManager = pageBranchManager;
    }

    /**
     * @return the warnPopContent
     */
    public String getWarnPopContent() {
        return warnPopContent;
    }

    /**
     * @param warnPopContent the warnPopContent to set
     */
    public void setWarnPopContent(String warnPopContent) {
        this.warnPopContent = warnPopContent;
    }

    /**
     * @return the conditionManager
     */
    public ConditionManager getConditionManager() {
        return conditionManager;
    }

    /**
     * @param conditionManager the conditionManager to set
     */
    public void setConditionManager(ConditionManager conditionManager) {
        this.conditionManager = conditionManager;
    }

    /**
     * @return the resultManager
     */
    public ResultManager getResultManager() {
        return resultManager;
    }

    /**
     * @param resultManager the resultManager to set
     */
    public void setResultManager(ResultManager resultManager) {
        this.resultManager = resultManager;
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
     * @return the branchItemRule
     */
    public BranchItemRule getBranchItemRule() {
        return branchItemRule;
    }

    /**
     * @param branchItemRule the branchItemRule to set
     */
    public void setBranchItemRule(BranchItemRule branchItemRule) {
        this.branchItemRule = branchItemRule;
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
     * @return the branchItemRuleManager
     */
    public BranchItemRuleManager getBranchItemRuleManager() {
        return branchItemRuleManager;
    }

    /**
     * @param branchItemRuleManager the branchItemRuleManager to set
     */
    public void setBranchItemRuleManager(BranchItemRuleManager branchItemRuleManager) {
        this.branchItemRuleManager = branchItemRuleManager;
    }

    /**
     * @return the QuestionTitle
     */
    public String getQuestionTitle() {
        return QuestionTitle;
    }

    /**
     * @param QuestionTitle the QuestionTitle to set
     */
    public void setQuestionTitle(String QuestionTitle) {
        this.QuestionTitle = QuestionTitle;
    }
}
