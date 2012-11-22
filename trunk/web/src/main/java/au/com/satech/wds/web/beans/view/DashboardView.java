 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.service.QuestionManager;
import au.com.satech.wds.service.SurveyManager;
import au.com.satech.wds.web.beans.BaseBean;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author sam
 */
@ManagedBean(name="dashboardView")
@ViewScoped
public class DashboardView extends BaseBean implements Serializable {
    @PostConstruct
    public void setup(){
        this.sysAttr = readAppAttr();
        this.wdsAttr = readWdsAttr();
    }
    
    @PreDestroy
    public void destroy(){
        
    }
    
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager surveyManager;
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    
    private List<String> sysAttr;
    private List<String> wdsAttr;
    
    private List<String> readWdsAttr(){
        List<String> attr = new ArrayList<String>();
        attr.add(String.valueOf(getSurveyManager().getAllSurveys().size()));
        attr.add(String.valueOf(questionManager.getAllQuestions().size()));
        attr.add(String.valueOf(questionManager.getAlllInUseQuestions().size()));
        return attr;
    }
    
    private List<String> readAppAttr(){
        List<String> attr = new ArrayList<String>();
        
        Properties prop = new Properties();
        
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext eContext = context.getExternalContext();
        InputStream in = eContext.getResourceAsStream("/WEB-INF/wds.properties");
        try {
            prop.load(in);
        } catch (IOException ex) {
            Logger.getLogger(DashboardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        attr.add(prop.getProperty("jdbc.url"));
        attr.add(prop.getProperty("hibernate.dialect"));
        attr.add(prop.getProperty("jdbc.version"));
        attr.add(prop.getProperty("jdbc.username"));
        attr.add(prop.getProperty("hibernate.version"));
        attr.add(prop.getProperty("hibernate.entitymanager.version"));
        attr.add(prop.getProperty("hibernate.search.version"));
        attr.add(prop.getProperty("hibernate.validator.version"));
        attr.add(prop.getProperty("jpa.version"));
        attr.add(prop.getProperty("ehcache.version"));
        attr.add(prop.getProperty("spring.version"));
        attr.add(prop.getProperty("spring.security.version"));
        attr.add(prop.getProperty("jsf.version"));
        attr.add(prop.getProperty("icefaces.version"));
        attr.add(prop.getProperty("primefaces.version"));
        return attr;
    }
    
    /**
     * @return the attr
     */
    public List<String> getSysAttr() {
        return sysAttr;
    }

    /**
     * @param attr the attr to set
     */
    public void setSysAttr(List<String> sysattr) {
        this.sysAttr = sysattr;
    }

    /**
     * @return the wdsAttr
     */
    public List<String> getWdsAttr() {
        return wdsAttr;
    }

    /**
     * @param wdsAttr the wdsAttr to set
     */
    public void setWdsAttr(List<String> wdsAttr) {
        this.wdsAttr = wdsAttr;
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
}
