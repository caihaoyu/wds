/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.session;

import au.com.satech.wds.model.Question;
import au.com.satech.wds.service.QuestionManager;
import au.com.satech.wds.web.beans.BaseBean;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sam
 */
@ManagedBean(name ="editQuestionSession")
@SessionScoped
public class EditQuestionSession extends BaseBean implements Serializable {
    @PostConstruct
    public void setup(){
        questionList = new ArrayList<Question>(getQuestionManager().getAllQuestions());
    }
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    private ArrayList<Question> questionList;
    
    public void refreshList(){
        setQuestionList(new ArrayList<Question>(questionManager.getAll()));
    }
    
    
     /**
        * -------================ Getter and Setter ================-------
        */

    /**
     * @return the questionList
     */
    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    /**
     * @param questionList the questionList to set
     */
    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
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
