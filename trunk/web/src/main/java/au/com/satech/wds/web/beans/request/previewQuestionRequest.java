/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.request;

import au.com.satech.wds.model.constant.QuestionConstant;
import au.com.satech.wds.web.beans.BaseBean;
import au.com.satech.wds.web.beans.view.AddQuestionView;
import au.com.satech.wds.web.beans.view.EditQuestionView;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sam
 */
@ManagedBean(name ="previewQuestionRequest")
@RequestScoped
public class previewQuestionRequest extends BaseBean implements Serializable {
    
    @ManagedProperty(value="#{addQuestionView}")
    private AddQuestionView addQuestionView;
    
    @ManagedProperty(value="#{editQuestionView}")
    private EditQuestionView editQuestionView;
    
    @PostConstruct
    public void setup(){
        
    }
    
    private void previewMatrix(){
        
    }
    
    public void previewQuestion(){
        RequestContext rqContext = RequestContext.getCurrentInstance();
        if(FacesContext.getCurrentInstance().getViewRoot().getViewId().equalsIgnoreCase("/admin/add-question.xhtml")){
            if(addQuestionView.getNewQuestion().getQuestiontitle().equals(QuestionConstant.DEFAULTBODYTEXT)){
                addQuestionView.displayWarningPopup("Cannot Generate Preview. Question title undefined.");
                return;
            }
            if(addQuestionView.getNewQuestion().getQuestiontype() == 1){
                rqContext.execute("previewFreeTextDlg.show()");
            } else if(addQuestionView.getNewQuestion().getQuestiontype() ==  2) {
                rqContext.execute("previewRatingDlg.show()");
            } else  if(addQuestionView.getNewQuestion().getQuestiontype() == 3) {
                rqContext.execute("previewChoiceDlg.show()");
            } else if(addQuestionView.getNewQuestion().getQuestiontype() == 4) {
                rqContext.execute("previewMatrixDlg.show()");
            }   
        }
        if(FacesContext.getCurrentInstance().getViewRoot().getViewId().equalsIgnoreCase("/admin/edit-question.xhtml")){
            if(editQuestionView.getSelectedQuestion().getQuestiontitle().equals(QuestionConstant.DEFAULTBODYTEXT)){
                editQuestionView.displayWarning("Please use a different question title.");
                return;
            }
            if(editQuestionView.getSelectedQuestion().getQuestiontype() == 1){
                rqContext.execute("previewFreeTextDlg.show()");
            } else if(editQuestionView.getSelectedQuestion().getQuestiontype() == 2){
                rqContext.execute("previewRatingDlg.show()");
            } else if(editQuestionView.getSelectedQuestion().getQuestiontype() == 3){
                rqContext.execute("previewChoiceDlg.show()");
            } else if(editQuestionView.getSelectedQuestion().getQuestiontype() == 4){
                rqContext.execute("previewMatrixDlg.show()");
            }
        } 
    }
    
    public void processMultipleAnswerClicked(){
        
    }

    /**
     * @return the addQuestionView
     */
    public AddQuestionView getAddQuestionView() {
        return addQuestionView;
    }

    /**
     * @param addQuestionView the addQuestionView to set
     */
    public void setAddQuestionView(AddQuestionView addQuestionView) {
        this.addQuestionView = addQuestionView;
    }

    /**
     * @return the editQuestionView
     */
    public EditQuestionView getEditQuestionView() {
        return editQuestionView;
    }

    /**
     * @param editQuestionView the editQuestionView to set
     */
    public void setEditQuestionView(EditQuestionView editQuestionView) {
        this.editQuestionView = editQuestionView;
    }
}
