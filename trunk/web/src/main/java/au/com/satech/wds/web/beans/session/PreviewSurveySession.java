/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.session;

import au.com.satech.wds.model.Response;
import au.com.satech.wds.web.beans.BaseBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sam
 */
@ManagedBean(name ="previewSurveySession")
@SessionScoped
public class PreviewSurveySession extends BaseBean implements Serializable {
    @PostConstruct
    public void setup(){
        currentPageIndex = 0;
    }
    
    private Integer selectedSurveyId;
    private Integer currentPageIndex;
    private Response response;
    
    public void enterPreview(Integer selectedSurveyId){
        // Save selected survey id
        setSelectedSurveyId(selectedSurveyId);
        // initiate response
        setResponse(new Response());
        getResponse().setSid(selectedSurveyId);
    }
    
    public void existPreview(){
        selectedSurveyId = null;
        currentPageIndex = 0;
        setResponse(null);
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
     * @return the response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(Response response) {
        this.response = response;
    }
}
