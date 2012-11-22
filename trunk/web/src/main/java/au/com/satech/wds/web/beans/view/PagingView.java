/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.service.*;
import au.com.satech.wds.web.beans.BaseBean;
import au.com.satech.wds.web.beans.session.EditSurveySession;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sam
 */
@ManagedBean(name ="pagingView")
@ViewScoped
public class PagingView extends BaseBean implements Serializable {
    @PostConstruct
    public void setup(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(getEditSurveySession().getSelectedSurveyId() == null){
            try {
                //redirect
                context.getExternalContext().redirect("edit-survey.xhtml");
            } catch (IOException ex) {
                log.error(ex);
            }
            //stop rendering the current page
            context.responseComplete();
        } 
    }
    
    @ManagedProperty(value="#{editSurveySession}")
    private EditSurveySession editSurveySession;
    
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager surveyManager;
    
    @ManagedProperty(value="#{pageBranchManager}")
    private PageBranchManager pageBranchManager;
    
    @ManagedProperty(value="#{pageManager}")
    private PageManager pageManager;
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    @ManagedProperty(value="#{branchItemManager}")
    private BranchItemManager branchItemManager;
    
    private DataGrid pageGrid;
    private DataGrid pageBranchGrid;
    private DataTable itemTable;
    private DataTable searchResultTable;
    
    private List<Question> questionSearchResult = new ArrayList<Question>(0);
    
    private String warnPopContent;
    
    private boolean renderAqtpButton = false;
    private boolean renderAqtpBranches = false;
    
    public void processAddNewPageButton(){
        // Create new Page
        Page page = new Page();
        int newOrder = pageGrid.getRowCount()+1;
        page.setPageorder(newOrder);
        page.setPagetitle("New Page");
        
        // Create default branch
        PageBranch pageBranch = new PageBranch();
        pageBranch.setMain(true);
        pageBranch.setBranchname("Default Branch");
        
        // Save new branch
        pageBranch = getPageBranchManager().savePageBranch(pageBranch);
        // Attach branch to page
        page.getPagebranches().add(pageBranch);
        
        // add page to survey
        surveyManager.addPagetoSurvey(editSurveySession.getSelectedSurveyId(), page);
        // refresh page list
        FacesContext context = FacesContext.getCurrentInstance();
        editSurveySession.refreshPages();

        // Display msg
        FacesMessage fm = new FacesMessage("Info:", "New page added to survey.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void processRemovePageButton(){
        FacesContext context = FacesContext.getCurrentInstance();
        Page page = (Page)pageGrid.getRowData();
        page = getPageManager().get(page.getPageid());
        // if page contains branch
        if(page.getPagebranches().size()>0){
            // Iterator through a copy of page branch list to avoid ConcurrentModificationException
            List<PageBranch> pageBranchListCopy = new ArrayList<PageBranch>(page.getPagebranches());
            for(int i=0;i<pageBranchListCopy.size();i++){
                PageBranch pageBranch = pageBranchListCopy.get(i);
                if(pageBranch.getItems().size()>0){
                    setWarnPopContent("This page contains one or more question.<br/>Please remove all the questions from all branch before delete page.");
                    RequestContext rqContext = RequestContext.getCurrentInstance();
                    rqContext.execute("warndl.show()");
                    return;
                } else {
                    page.getPagebranches().remove(pageBranch);
                    page = pageManager.savePage(page);
                    pageBranchManager.removePageBranch(pageBranch);
                }
            }
            // Remove page from survey
            surveyManager.removePageFromSurvey(editSurveySession.getSelectedSurveyId(), page.getPageid());
            // remove page from database
            getPageManager().removePage(page);
        } else {
            surveyManager.removePageFromSurvey(editSurveySession.getSelectedSurveyId(), page.getPageid());
            getPageManager().removePage(page);
        }
        // refresh data on page
        editSurveySession.refreshPages();
        FacesMessage fm = new FacesMessage("Info:", "Page("+page.getPageid()+") removed.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void processEditPageButton(){
        Page page = (Page)pageGrid.getRowData();
        editSurveySession.setSelectedPageId(page.getPageid());
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput title = (UIInput)findComponent(root, "pageTitle");
        title.setValue(page.getPagetitle());
        UIInput header = (UIInput)findComponent(root, "pageHeader");
        header.setValue(page.getPageheader());
        UIInput footer = (UIInput)findComponent(root, "pageFooter");
        footer.setValue(page.getPagefooter());
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("editPageDialog.show()");
    }
    
    public void confirmEditPage(){
        Page page = pageManager.get(editSurveySession.getSelectedPageId());
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIInput title = (UIInput)findComponent(root, "pageTitle");
        UIInput header = (UIInput)findComponent(root, "pageHeader");
        UIInput footer = (UIInput)findComponent(root, "pageFooter");
        page.setPagetitle(title.getValue().toString());
        page.setPageheader(header.getValue().toString());
        page.setPagefooter(footer.getValue().toString());
        pageManager.savePage(page);
        editSurveySession.refreshPages();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("editPageDialog.hide()");
    }
    
    public void movingPageUp(){
        int rowIndex = pageGrid.getRowIndex();
        Page page = (Page)pageGrid.getRowData();
        int targetRowIndex = rowIndex-1;
        
        Page targetPage = editSurveySession.getPages().get(targetRowIndex);
        int pageOrder = page.getPageorder();
        int targetPageOrder = targetPage.getPageorder();
        // Exchange value
        page.setPageorder(targetPageOrder);
        getPageManager().savePage(page);
        targetPage.setPageorder(pageOrder);
        getPageManager().savePage(targetPage);
        // Reload pages
        editSurveySession.refreshPages();
        FacesMessage fm = new FacesMessage("Info:", "Page position changed.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }
    
    public void movingPageDown(){
        int rowIndex = pageGrid.getRowIndex();
        Page page = (Page)pageGrid.getRowData();
        int targetRowIndex = rowIndex+1;
        
        Page targetPage = editSurveySession.getPages().get(targetRowIndex);
        int pageOrder = page.getPageorder();
        int targetPageOrder = targetPage.getPageorder();
        // Exchange value
        page.setPageorder(targetPageOrder);
        getPageManager().savePage(page);
        targetPage.setPageorder(pageOrder);
        getPageManager().savePage(targetPage);
        // Reload pages
        editSurveySession.refreshPages();
        FacesMessage fm = new FacesMessage("Info:", "Page position changed.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }
    
    public void processAddBranchButton(){
        Page page = (Page)pageGrid.getRowData();
        int newBranchIndex = page.getPagebranches().size()+1;
        // create new page branch
        PageBranch newBranch = new PageBranch();
        newBranch.setBranchname("Branch "+newBranchIndex);
        newBranch.setMain(false);
        // persist new page branch
        newBranch = getPageBranchManager().savePageBranch(newBranch);
        page.getPagebranches().add(newBranch);
        getPageManager().savePage(page);
        // Reload pages
        editSurveySession.refreshPages();
        FacesMessage fm = new FacesMessage("Info:", "Page branch("+newBranch.getBranchid()+") added to page("+page.getPageid()+")");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }
    
    public void processRemovePageBranchFromPage(){
        Page page = (Page)pageGrid.getRowData();
        PageBranch pb = (PageBranch)pageBranchGrid.getRowData();
        if(pb.getItems().size()>0){
            setWarnPopContent("This branch contains one or more question.<br/>Please remove all the questions before you delete it.");
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("warndl.show()");
        } else {
            page.getPagebranches().remove(pb);
            getPageManager().savePage(page);
            getPageBranchManager().removePageBranch(pb);
            // Reload pages
            editSurveySession.refreshPages();
            FacesMessage fm = new FacesMessage("Info:", "Page branch("+pb.getBranchid()+") removed from page("+page.getPageid()+")");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
        }
    }
    
    public void defaultBranchValueChange(){
        Page page = (Page)pageGrid.getRowData();
        PageBranch pageBranch = (PageBranch)pageBranchGrid.getRowData();
        // Set all main to false, since we can only have one main branch
        for(int i=0;i<page.getPagebranches().size();i++){
            PageBranch pb = page.getPagebranches().get(i);
            pb.setMain(false);
            int order = i+1;
            pb.setBranchname("Branch "+order);
            getPageBranchManager().savePageBranch(pb);
        }
        // Set selected branch to main
        pageBranch.setMain(true);
        pageBranch.setBranchname("Default Branch");
        pageBranch = getPageBranchManager().savePageBranch(pageBranch);
        // Reload pages
        editSurveySession.refreshPages();
        FacesMessage fm = new FacesMessage("Info:", "Page branch("+pageBranch.getBranchid()+") set to default.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }
    
    public void processHide(){
        BranchItem rowData = (BranchItem)itemTable.getRowData();
        BranchItem item = getBranchItemManager().get(rowData.getBranchitemid());
        
        if(item.isHidden()){
            item.setHidden(false);
            branchItemManager.saveBranchItem(item);
        } else {
            item.setHidden(true);
            branchItemManager.saveBranchItem(item);
        }
        editSurveySession.refreshPages();
    }
    
    public void processRemoveQuestionFromPageBranch(){
        PageBranch branch = (PageBranch)pageBranchGrid.getRowData();
        BranchItem rowData = (BranchItem)itemTable.getRowData();
        BranchItem item = getBranchItemManager().get(rowData.getBranchitemid());
        
        // remove question from page branch
//        pageBranchManager.removeQuestionFromBranch(branch.getBranchid(), question.getQuestionid());
        // delete branch item
        pageBranchManager.removeBranchItemFromBranch(item.getBranchitemid(), branch.getBranchid());
        editSurveySession.refreshPages();
        FacesMessage fm = new FacesMessage("Info:", "Question("+item.getQuestionid()+") removed from branch("+branch.getBranchid()+").");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
    }
    
    public void movingQuestionUp(){
        FacesContext context = FacesContext.getCurrentInstance();
        PageBranch branchRowData = (PageBranch)pageBranchGrid.getRowData();
        PageBranch branch = pageBranchManager.get(branchRowData.getBranchid());
        BranchItem rowData = (BranchItem)itemTable.getRowData();
        int rowIndex = itemTable.getRowIndex();
        int targetRowIndex = rowIndex - 1;
        
        BranchItem item = branchItemManager.get(rowData.getBranchitemid());
        BranchItem targetItem = branch.getItems().get(targetRowIndex);
        
        int itemOrder = item.getItemorder();
        int targetItemOrder = targetItem.getItemorder();
        
        item.setItemorder(targetItemOrder);
        branchItemManager.saveBranchItem(item);
        targetItem.setItemorder(itemOrder);
        branchItemManager.saveBranchItem(targetItem);
        
        editSurveySession.refreshPages();
        
        FacesMessage fm = new FacesMessage("Info:", "Question position changed.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void movingQuestionDown(){
        FacesContext context = FacesContext.getCurrentInstance();
        PageBranch branchRowData = (PageBranch)pageBranchGrid.getRowData();
        PageBranch branch = pageBranchManager.get(branchRowData.getBranchid());
        BranchItem rowData = (BranchItem)itemTable.getRowData();
        int rowIndex = itemTable.getRowIndex();
        int targetRowIndex = rowIndex + 1;
        
        BranchItem item = branchItemManager.get(rowData.getBranchitemid());
        BranchItem targetItem = branch.getItems().get(targetRowIndex);
        
        int itemOrder = item.getItemorder();
        int targetItemOrder = targetItem.getItemorder();
        
        item.setItemorder(targetItemOrder);
        branchItemManager.saveBranchItem(item);
        targetItem.setItemorder(itemOrder);
        branchItemManager.saveBranchItem(targetItem);
        
        editSurveySession.refreshPages();
        
        FacesMessage fm = new FacesMessage("Info:", "Question position changed.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void processSearchQuestionButton(){
        FacesContext context = FacesContext.getCurrentInstance();
        UIInput criteriaInput = (UIInput)findComponent(context.getViewRoot(), "searchCriteria");
        
        String searchTerm = criteriaInput.getValue().toString();
        
        if(searchTerm.isEmpty()){
            setQuestionSearchResult(getQuestionManager().getAllQuestions());
        } else {
            setQuestionSearchResult(questionManager.searchForQuestionByTerms(searchTerm, 0, 20));
        }
        if(getQuestionSearchResult().isEmpty()){
            FacesMessage fm = new FacesMessage("Warn:", "No questions found for the given criteria. Change criteria and try again?");
            fm.setSeverity(FacesMessage.SEVERITY_WARN);
            context.addMessage(null, fm);
        }
    }
    
    public void clearSearchResult(){
        getQuestionSearchResult().clear();
    }
    
    public void aqtpSelectValueChange(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(editSurveySession.getSelectedPageId() != null){
            Page page = pageManager.get(editSurveySession.getSelectedPageId());
            SelectOneMenu aqtpBranchSelect = (SelectOneMenu)findComponent(context.getViewRoot(), "aqtpBranchSelect");
            aqtpBranchSelect.getChildren().clear();
            UISelectItem selectItem = new UISelectItem();
            selectItem.setItemLabel("--- select branch ---");
            selectItem.setItemDisabled(true);
            UISelectItems selectItems = new UISelectItems();
            List<SelectItem> items = new ArrayList<SelectItem>();
            for(PageBranch pageBranch:page.getPagebranches()){
                items.add(new SelectItem(pageBranch.getBranchid(), pageBranch.getBranchname()));
            }
            selectItems.setValue(items);
            aqtpBranchSelect.getChildren().add(selectItem);
            aqtpBranchSelect.getChildren().add(selectItems);
            setRenderAqtpBranches(true);
        }
        if(editSurveySession.getSelectedPageBranchId() != null){
            setRenderAqtpButton(true);
        }
    }
    
    public void aqtpDialogClose(){
        setRenderAqtpButton(false);
        setRenderAqtpBranches(false);
    }
    
    public void processAddQuestionToPage(){
        // reset selected page id in session
        editSurveySession.setSelectedPageId(null);
        editSurveySession.setSelectedPageBranchId(null);
        // get row data from data table
        Question rowData = (Question)searchResultTable.getRowData();
        // set question id in session
        editSurveySession.setSelectedQuestionId(rowData.getQuestionid());
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("addQuestionToPageDialog.show()");
    }
    
    public void confirmAddQuestionToPage(){
        FacesContext context = FacesContext.getCurrentInstance();
        // add question to branch
        pageBranchManager.addQuestionToBranch(editSurveySession.getSelectedPageBranchId(), editSurveySession.getSelectedQuestionId());
        editSurveySession.refreshPages();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("addQuestionToPageDialog.hide()");
        setRenderAqtpButton(false);
        setRenderAqtpBranches(false);
        FacesMessage fm = new FacesMessage("Info:", "Question("+editSurveySession.getSelectedQuestionId()+") added to branch("+editSurveySession.getSelectedPageBranchId()+").");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public boolean renderQuestionSearchResult(){
        if(getQuestionSearchResult().size()>0) return true;
        return false;
    }
    
    public boolean renderMoveUp(){
        int rowIndex = pageGrid.getRowIndex();
        if(rowIndex == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean renderMoveDown(){
        int rowIndex = pageGrid.getRowIndex();
        int size = pageGrid.getRowCount()-1;
        if(rowIndex == size){
            return false;
        } else {
            return true;
        }
    }
    /**
     * -------================ Getter and Setter ================-------
     */

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
     * @return the pageGrid
     */
    public DataGrid getPageGrid() {
        return pageGrid;
    }

    /**
     * @param pageGrid the pageGrid to set
     */
    public void setPageGrid(DataGrid pageGrid) {
        this.pageGrid = pageGrid;
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
     * @return the pageBranchGrid
     */
    public DataGrid getPageBranchGrid() {
        return pageBranchGrid;
    }

    /**
     * @param pageBranchGrid the pageBranchGrid to set
     */
    public void setPageBranchGrid(DataGrid pageBranchGrid) {
        this.pageBranchGrid = pageBranchGrid;
    }

    /**
     * @return the itemTable
     */
    public DataTable getItemTable() {
        return itemTable;
    }

    /**
     * @param itemTable the itemTable to set
     */
    public void setItemTable(DataTable itemTable) {
        this.itemTable = itemTable;
    }

    /**
     * @return the questionSearchResult
     */
    public List<Question> getQuestionSearchResult() {
        return questionSearchResult;
    }

    /**
     * @param questionSearchResult the questionSearchResult to set
     */
    public void setQuestionSearchResult(List<Question> questionSearchResult) {
        this.questionSearchResult = questionSearchResult;
    }

    /**
     * @return the searchResultTable
     */
    public DataTable getSearchResultTable() {
        return searchResultTable;
    }

    /**
     * @param searchResultTable the searchResultTable to set
     */
    public void setSearchResultTable(DataTable searchResultTable) {
        this.searchResultTable = searchResultTable;
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
     * @return the renderAqtpButton
     */
    public boolean isRenderAqtpButton() {
        return renderAqtpButton;
    }

    /**
     * @param renderAqtpButton the renderAqtpButton to set
     */
    public void setRenderAqtpButton(boolean renderAqtpButton) {
        this.renderAqtpButton = renderAqtpButton;
    }

    /**
     * @return the renderAqtpBranches
     */
    public boolean isRenderAqtpBranches() {
        return renderAqtpBranches;
    }

    /**
     * @param renderAqtpBranches the renderAqtpBranches to set
     */
    public void setRenderAqtpBranches(boolean renderAqtpBranches) {
        this.renderAqtpBranches = renderAqtpBranches;
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
}
