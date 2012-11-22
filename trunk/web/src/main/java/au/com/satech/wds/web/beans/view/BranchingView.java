/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.service.QuestionManager;
import au.com.satech.wds.service.SurveyManager;
import au.com.satech.wds.web.beans.BaseBean;
import au.com.satech.wds.web.beans.session.EditSurveySession;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datagrid.DataGrid;

/**
 *
 * @author sam
 */
@ManagedBean(name ="branchingView")
@ViewScoped
public class BranchingView extends BaseBean implements Serializable {
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
        } else {
            if(editSurveySession.getSelectedSurvey() == null){
                editSurveySession.setSelectedSurvey(surveyManager.get(editSurveySession.getSelectedSurveyId()));
            }
            Object obj =  context.getExternalContext().getFlash().get("msg");
            if(!(obj == null)){
                FacesMessage fm = new FacesMessage("Info:", obj.toString());
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                context.addMessage(null, fm);
            }
        }
    }
    
    @ManagedProperty(value="#{editSurveySession}")
    private EditSurveySession editSurveySession;
    
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager surveyManager;
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    private DataGrid pageGrid;
    private DataGrid pageBranchGrid;
    private DataGrid branchItemGrid;
    
    
    public String processNewRule(){
        BranchItem item = (BranchItem)branchItemGrid.getRowData();
        getEditSurveySession().setSelectedItemId(item.getBranchitemid());
        getEditSurveySession().setSelectedItemruleId(null);
        return "newRule";
    }
    
    public String processEditRule(){
        BranchItem item = (BranchItem)branchItemGrid.getRowData();
        
        getEditSurveySession().setSelectedItemId(item.getBranchitemid());
        return "ruleList";
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
     * @return the branchItemGrid
     */
    public DataGrid getBranchItemGrid() {
        return branchItemGrid;
    }

    /**
     * @param branchItemGrid the branchItemGrid to set
     */
    public void setBranchItemGrid(DataGrid branchItemGrid) {
        this.branchItemGrid = branchItemGrid;
    }
}
