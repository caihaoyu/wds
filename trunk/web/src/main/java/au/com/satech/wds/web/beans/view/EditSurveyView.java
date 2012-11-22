/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Survey;
import au.com.satech.wds.service.SurveyManager;
import au.com.satech.wds.web.beans.BaseBean;
import au.com.satech.wds.web.beans.session.EditSurveySession;
import au.com.satech.wds.web.beans.session.PreviewSurveySession;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sam
 */
@ManagedBean(name="editSurveyView")
@ViewScoped
public class EditSurveyView extends BaseBean implements Serializable {
    @PostConstruct
    public void setup(){
        FacesContext context = FacesContext.getCurrentInstance();
        Object obj =  context.getExternalContext().getFlash().get("msg");
        if(!(obj == null)){
            FacesMessage fm = new FacesMessage("Info:", obj.toString());
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage(null, fm);
        }
    }
    
    @PreDestroy
    public void destroy(){
        
    }
    
    @ManagedProperty(value="#{editSurveySession}")
    private EditSurveySession editSurveySession;
    
    @ManagedProperty(value="#{previewSurveySession}")
    private PreviewSurveySession previewSurveySession;
    
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager surveyManager;
    
    private Survey selectedSurvey;
    
    private DataTable surveyListTable;
    
    private boolean renderEdit;
    
    public void refreshSurveys(){
        FacesContext context = FacesContext.getCurrentInstance();
        editSurveySession.refreshSurveyList();
        setSelectedSurvey(null);
        FacesMessage fm = new FacesMessage("Info:", "Survey list refreshed.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void processEditSurveyButton(){
        this.selectedSurvey = (Survey)getSurveyListTable().getRowData();
    }
    
    public void closeSurvey(){
        setSelectedSurvey(null);
    }
    
    public String toPaging(){
        if(selectedSurvey == null){
            selectedSurvey = (Survey)surveyListTable.getRowData();
        }
        editSurveySession.setSelectedSurveyId(selectedSurvey.getSid());
        editSurveySession.setSelectedSurvey(selectedSurvey);
        editSurveySession.refreshPages();
        editSurveySession.setSelectedPageBranchId(null);
        editSurveySession.setSelectedPageId(null);
        editSurveySession.setSelectedItemId(null);
        editSurveySession.setSelectedPageIndex(null);
        return "paging";
    }
    
    public String toBranching(){
        if(selectedSurvey == null){
            selectedSurvey = (Survey)surveyListTable.getRowData();
        }
        editSurveySession.setSelectedSurveyId(selectedSurvey.getSid());
        editSurveySession.setSelectedSurvey(selectedSurvey);
        editSurveySession.refreshPages();
        editSurveySession.setSelectedPageBranchId(null);
        editSurveySession.setSelectedPageId(null);
        editSurveySession.setSelectedItemId(null);
        editSurveySession.setSelectedPageIndex(null);
        return "branching";
    }
    
    public String toPreview(){
        if(selectedSurvey == null){
            selectedSurvey = (Survey)surveyListTable.getRowData();
        }
        previewSurveySession.enterPreview(selectedSurvey.getSid());
        return "previewSurvey";
    }
    
    public void processSaveSurveyButton(){
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmSaveSurvey.show()");
    }
    
    public void confirmSaveSurvey(){
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        selectedSurvey = surveyManager.saveSurvey(selectedSurvey);
        editSurveySession.refreshSurveyList();
        rqContext.execute("confirmDeleteSurvey.hide()");
        FacesMessage fm = new FacesMessage("Info:", "Survey (ID:"+selectedSurvey.getSid()+") saved.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
        setSelectedSurvey(null);
    }
    
    public void processDeleteSurveyButton(){
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteSurvey.show()");
    }
    
    public void confirmDeleteSurvey(){
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        int id = selectedSurvey.getSid();
        surveyManager.remove(selectedSurvey.getSid());
        setSelectedSurvey(null);
        editSurveySession.refreshSurveyList();
        rqContext.execute("confirmDeleteSurvey.hide()");
        FacesMessage fm = new FacesMessage("Info:", "Survey (ID:"+id+") deleted.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
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
     * @return the surveyListTable
     */
    public DataTable getSurveyListTable() {
        return surveyListTable;
    }

    /**
     * @param surveyListTable the surveyListTable to set
     */
    public void setSurveyListTable(DataTable surveyListTable) {
        this.surveyListTable = surveyListTable;
    }

    /**
     * @return the renderEdit
     */
    public boolean isRenderEdit() {
        return renderEdit;
    }

    /**
     * @param renderEdit the renderEdit to set
     */
    public void setRenderEdit(boolean renderEdit) {
        this.renderEdit = renderEdit;
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
}
