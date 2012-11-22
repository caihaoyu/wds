/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.service.BranchItemManager;
import au.com.satech.wds.service.BranchItemRuleManager;
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
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sam
 */
@ManagedBean(name ="editQuestionRuleView")
@ViewScoped
public class EditQuestionRuleView extends BaseBean implements Serializable {
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
        } else if(editSurveySession.getSelectedItemId() == null){
            try {
                //redirect
                context.getExternalContext().redirect("branching-and-logic.xhtml");
            } catch (IOException ex) {
                log.error(ex);
            }
            //stop rendering the current page
            context.responseComplete();
        } else {
            
        }
    }
    
    @ManagedProperty(value="#{branchItemRuleManager}")
    private BranchItemRuleManager branchItemRuleManager;
    
    @ManagedProperty(value="#{branchItemManager}")
    private BranchItemManager branchItemManager;
    
    @ManagedProperty(value="#{editSurveySession}")
    private EditSurveySession editSurveySession;
    
    
    private DataGrid ruleGrid;
    private DataTable ruleTable;
    
    public void editQuestionRule(){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Info:", "Havent Implemented Yet.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void deleteQuestionRule(){
        BranchItemRule  qr = (BranchItemRule)ruleGrid.getRowData();
        editSurveySession.setSelectedItemruleId(qr.getRuleid());
        
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteQuestionRule.show()");
    }
    
    public void confirmDeleteQuestionRule(){
        BranchItemRule qr = branchItemRuleManager.get(editSurveySession.getSelectedItemruleId());
        BranchItem branchItem = branchItemManager.get(editSurveySession.getSelectedItemId());
        branchItem.getRules().remove(qr);
        branchItemRuleManager.remove(qr.getRuleid());
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteQuestionRule.hide()");
        
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Info:", "Branch Item rule(ID:"+editSurveySession.getSelectedItemruleId()+") deleted.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
        
        editSurveySession.setSelectedItemId(null);
        //TODO: 这里需要进一步测试 editSurveySession.reloadSelectedBranchItem();
        editSurveySession.refreshPages();
    }
    
    /**
        * -------================ Getter and Setter ================-------
        */

    /**
     * @return the ruleGrid
     */
    public DataGrid getRuleGrid() {
        return ruleGrid;
    }

    /**
     * @param ruleGrid the ruleGrid to set
     */
    public void setRuleGrid(DataGrid ruleGrid) {
        this.ruleGrid = ruleGrid;
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
     * @return the ruleTable
     */
    public DataTable getRuleTable() {
        return ruleTable;
    }

    /**
     * @param ruleTable the ruleTable to set
     */
    public void setRuleTable(DataTable ruleTable) {
        this.ruleTable = ruleTable;
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
