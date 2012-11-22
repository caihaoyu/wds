/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans;

import au.com.satech.wds.model.Question;
import au.com.satech.wds.service.QuestionManager;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.Version;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author sam
 */
@ManagedBean(name="testbean")
@ViewScoped
public class TestBean extends DataTableBase implements Serializable {
    @PostConstruct
    public void setup(){
        setQuestionList(new ArrayList<Question>(getQuestionManager().getAllQuestions()));
    }
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    private ArrayList<Question> questionList;
    private DataTable questionListTable;
    
    
    public void doSomething(){
        log.debug(" ### Do nothing");
    }
    
    
    /**
     * -------================ Getter and Setter ================-------
     */

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
     * @return the questionListTable
     */
    public DataTable getQuestionListTable() {
        return questionListTable;
    }

    /**
     * @param questionListTable the questionListTable to set
     */
    public void setQuestionListTable(DataTable questionListTable) {
        this.questionListTable = questionListTable;
    }
}
