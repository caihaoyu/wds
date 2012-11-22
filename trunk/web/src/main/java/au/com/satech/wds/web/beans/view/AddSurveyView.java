/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.Survey;
import au.com.satech.wds.service.SurveyManager;
import au.com.satech.wds.web.beans.BaseBean;
import au.com.satech.wds.web.beans.session.EditSurveySession;
import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sam
 */
@ManagedBean(name ="addSurveyView")
@ViewScoped
public class AddSurveyView extends BaseBean implements Serializable {
    @PostConstruct
    public void setup(){
        
    }
    
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager surveyManager;
    
    @ManagedProperty(value="#{editSurveySession}")
    private EditSurveySession editSurveySession;
    
    
    private Survey newSurvey = new Survey();
    
    private String warnPopContent;
    
    public void addNewSurvey(){
        RequestContext rqContext = RequestContext.getCurrentInstance();
        if(surveyManager.loadSurveyBySurveyTitle(newSurvey.getSurveytitle()) != null){
            warnPopContent = "Cannot create survey, survey with the same name already exist.";
            rqContext.execute("warndl.show()");
        } else {
            rqContext.execute("confirmAddSurveyDialog.show()");
        }
    }
    
    public String confirmAddNewSurvey(){
        FacesContext context = FacesContext.getCurrentInstance();
        newSurvey.setDatecreated(Calendar.getInstance().getTime());
        newSurvey = surveyManager.saveSurvey(newSurvey);
        editSurveySession.refreshSurveyList();
        String msg = "New survey: \""+newSurvey.getSurveytitle()+"\" added.";
        context.getExternalContext().getFlash().putNow("msg", msg);
        return "editSurvey";
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
     * @return the newSurvey
     */
    public Survey getNewSurvey() {
        return newSurvey;
    }

    /**
     * @param newSurvey the newSurvey to set
     */
    public void setNewSurvey(Survey newSurvey) {
        this.newSurvey = newSurvey;
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
}
