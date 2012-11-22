/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Columnchoice;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.Subquestion;
import au.com.satech.wds.model.constant.QuestionConstant;
import au.com.satech.wds.service.QuestionManager;
import au.com.satech.wds.web.beans.DataTableBase;
import au.com.satech.wds.web.beans.session.EditQuestionSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.apache.commons.lang.ArrayUtils;
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author sam
 */
@ManagedBean(name="editQuestionView")
@ViewScoped
public class EditQuestionView extends DataTableBase implements Serializable {
    @PostConstruct
    public void setup(){
        setSelectedQuestion(null);
        // display face message
        FacesContext context = FacesContext.getCurrentInstance();
        Question updatedQuestion = (Question)context.getExternalContext().getFlash().get("updatedQuestion");
        if(updatedQuestion != null) {
            FacesMessage fm = new FacesMessage("Info:", "Question \""+updatedQuestion.getQuestiontitle()+"\" is saved.");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage(null, fm);
        }
        
        // build SelectItems array
        setNumberOfAnswers(buildSelectItemArray("", "", 1, 9));
        setNumberOfSubQuestions(buildSelectItemArray("", "", 1, 9));
        setNumberOfColumnChoices(buildSelectItemArray("", "", 1, 9));
        
        columnchoiceTypeItems = new ArrayList<SelectItem>();
        columnchoiceTypeItems.add(new SelectItem(1, QuestionConstant.INPUT));
        columnchoiceTypeItems.add(new SelectItem(2, QuestionConstant.RATING));
        columnchoiceTypeItems.add(new SelectItem(3, QuestionConstant.CHOICE));
    }
    
    @ManagedProperty(value="#{editQuestionSession}")
    private EditQuestionSession editQuestionSession;
    
    @ManagedProperty(value="#{questionManager}")
    private QuestionManager questionManager;
    
    private DataTable questionListTable;
    
    private DataGrid answersGrid;
    private DataGrid subQuestionsGrid;
    private DataGrid columnChoicesGrid;
    
    private Question selectedQuestion;
    private Integer selectedQuestionId;
    
    private Question[] selectedQuestions;
    
    private Question selectedQuestionToDelete;
    
    private Integer numberOfAnswersSelected;
    private Integer numberOfSubQuestionsSelected;
    private Integer numberOfColumnChoicesSelected;
    
    private SelectItem[] numberOfAnswers;
    private SelectItem[] numberOfSubQuestions;
    private SelectItem[] numberOfColumnChoices;
    private List<SelectItem> columnchoiceTypeItems;
    
    private boolean findEmptyAnswer;
    private boolean findEmptySubquestion;
    private boolean findEmptyColumnchoice;
    
    private Integer deleteAnswerOrder;
    private Integer deleteSubQuestionOrder;
    private Integer deleteColumnChoiceOrder;
    
    
    //layout control boolean
    private boolean renderInputMask;
    
    //Popup warning content
    private String warnPopContent;
    
    public void processEditQuestionButton(ActionEvent event){
        selectedQuestion = (Question)questionListTable.getRowData();
        selectedQuestionId = selectedQuestion.getQuestionid();
        setSelectedQuestion(questionManager.get(selectedQuestionId));
        if(selectedQuestion != null){
            if(selectedQuestion.getQuestiontype()>4 || selectedQuestion.getQuestiontype()<1){
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage fm = new FacesMessage("Error:", "Question type value error.");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, fm);
            }
            if(selectedQuestion.getAnswermask() != null) setRenderInputMask(true);
        }
    }
    
    public void displayWarning(String content){
        setWarnPopContent(content);
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("warndl.show()");
    }
    
    public void refreshList(){
        editQuestionSession.refreshList();
        setSelectedQuestion(null);
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Info:", "Question list table refreshed.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void (SelectEvent event){
        selectedQuestionToDelete = (Question)event.getObject();
        if(selectedQuestionToDelete.isInuse()){
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("inUseWarnDialog.show()");
        }
    }
    
    public void confirmInUse(){
        selectedQuestions = (Question[])ArrayUtils.removeElement(selectedQuestions, selectedQuestionToDelete);
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("inUseWarnDialog.hide()");
    }
    
    public void processDelete(){
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteQuestion.show()");
    }
    
    public void confirmDelete(){
        int id = selectedQuestion.getQuestionid();
        questionManager.removeQuestion(selectedQuestion);
        editQuestionSession.refreshList();
        setSelectedQuestion(null);
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteQuestion.hide()");
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Info:", "Question (ID:"+id+") deleted.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void processBatchDelete(){
        if(selectedQuestions.length > 0) {
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("confirmDeleteQuestionsDialog.show()");
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage("Warn:", "There is no question selected, select question you want to delete first.");
            fm.setSeverity(FacesMessage.SEVERITY_WARN);
            context.addMessage(null, fm);
        }
    }
    
    public void confirmBatchDelete(){
        int numberOfQuestionsDeleted = selectedQuestions.length;
        for(int i=0;i<selectedQuestions.length;i++){
            questionManager.removeQuestion(selectedQuestions[i]);
        }
        editQuestionSession.refreshList();
        setSelectedQuestions(null);
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteQuestionsDialog.hide()");
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Info:", numberOfQuestionsDeleted+" question(s) deleted.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void processSaveQuestionButton(){
        switch(selectedQuestion.getQuestiontype()) {
            case 1: {
                RequestContext rqContext = RequestContext.getCurrentInstance();
                rqContext.execute("confirmSaveQuestionDialog.show()");
                break;
            }
            case 2: {
                RequestContext rqContext = RequestContext.getCurrentInstance();
                rqContext.execute("confirmSaveQuestionDialog.show()");
                break;
            }
            case 3: {
                if(selectedQuestion.getAnswers().isEmpty()){
                    setWarnPopContent("Cannot Save question, there is no answer.");
                    RequestContext rqContext = RequestContext.getCurrentInstance();
                    rqContext.execute("warndl.show()");
                } else {
                    setFindEmptyAnswer(false);
                    int numberOfEmptyAnswer = 0;
                    for(Answer answer:selectedQuestion.getAnswers()){
                        if(answer.getAnswertitle().isEmpty()){
                            setFindEmptyAnswer(true);
                            numberOfEmptyAnswer++;
                        }
                    }
                    if(numberOfEmptyAnswer == selectedQuestion.getAnswers().size()){
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        setWarnPopContent("Cannot save question, all answers are empty.");
                        rqContext.execute("warndl.show()");
                    } else {
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        rqContext.execute("confirmSaveQuestionDialog.show()");
                    }
                }                
                break;
                }
            case 4: {
                if(selectedQuestion.getSubquestions().isEmpty()) {
                    RequestContext rqContext = RequestContext.getCurrentInstance();
                    setWarnPopContent("Cannot save question, there is no sub question.");
                    rqContext.execute("warndl.show()");
                } else {
                    setFindEmptySubquestion(false);
                    int numberOfEmptySubquestions = 0;
                    for(Subquestion subQuestion:selectedQuestion.getSubquestions()){
                        if(subQuestion.getSubquestiontitle().isEmpty()){
                            setFindEmptySubquestion(true);
                            numberOfEmptySubquestions++;
                        }
                    }
                    if(numberOfEmptySubquestions == selectedQuestion.getSubquestions().size()){
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        setWarnPopContent("Cannot save question, all sub questions are empty.");
                        rqContext.execute("warndl.show()");
                    } else if(selectedQuestion.getColumntype() == 3 && selectedQuestion.getColumnchoices().size()<=1) {
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        setWarnPopContent("Cannot save question, you need at least two column choices.");
                        rqContext.execute("warndl.show()");
                    } else {
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        rqContext.execute("confirmSaveQuestionDialog.show()");
                    }
                }
                break;
            }
        }
    }
    
    public void confirmSaveQuestion(){
        int id = selectedQuestion.getQuestionid();
        for(Answer answer:selectedQuestion.getAnswersList()){
            if(!answer.isIdSet()){
                selectedQuestion.getAnswers().add(answer);
            }
        }
        questionManager.saveQuestion(selectedQuestion);
        editQuestionSession.refreshList();
        setSelectedQuestion(null);
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmSaveQuestionDialog.hide()");
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage("Info:", "Question (ID:"+id+") saved.");
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        context.addMessage(null, fm);
    }
    
    public void processCloseButton(){
        setSelectedQuestion(null);
    }
    
    public void answerMaskValueChange(){
        
    }
    
    public void processRenderInputMaskValueChange(){
        if(!renderInputMask){
            selectedQuestion.setAnswermask(null);
        }
    }
    
    public void answerTypeValueChange(){
        
    }
    
    public void ratingChange(){
        
    }
    
    public void deleteAnswerInput(){
        Answer answer = (Answer)getAnswersGrid().getRowData();
        if(answer.getAnswertitle().isEmpty()){
            selectedQuestion.getAnswers().remove(answer.getAnswerorder()-1);
            reorderAnswers();
        } else {
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("confirmDeleteAnswerInput.show()");
            deleteAnswerOrder = answer.getAnswerorder();
        }
    }
    
    public void confirmDeleteAnswerInput(){
        selectedQuestion.getAnswers().remove(deleteAnswerOrder-1);
        reorderAnswers();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteAnswerInput.hide()");
    }
    
    public void moveAnswerUp(){
        Answer targetAnswer = (Answer)getAnswersGrid().getRowData();
        int targetIndex = targetAnswer.getAnswerorder()-1;
        //TODO: Swap function need rewrite
//        Collections.swap(selectedQuestion.getAnswers(), targetIndex, targetIndex-1);
        reorderAnswers();
    }
    
    public void moveAnswerDown(){
        Answer targetAnswer = (Answer)getAnswersGrid().getRowData();
        int targetIndex = targetAnswer.getAnswerorder()-1;
        //TODO: Swap function need rewrite
//        Collections.swap(selectedQuestion.getAnswers(), targetIndex, targetIndex+1);
        reorderAnswers();
    }
    
    public void addNewAnswerInput(){
        int newOrder = selectedQuestion.getAnswersList().size()+1;
        log.debug("###selectedQuestion.getAnswersList().size():"+selectedQuestion.getAnswersList().size());
        Answer newAnswer = new Answer();
        newAnswer.setAnswerorder(newOrder);
        selectedQuestion.getAnswersList().add(newAnswer);
        log.debug("###selectedQuestion.getAnswersList().size():"+selectedQuestion.getAnswersList().size());
    }
    
    public void processAnswersToDisplay(){
        for(int i=0;i<numberOfAnswersSelected;i++){
                Answer answer = new Answer();
                answer.setAnswerorder(i+1);
                selectedQuestion.getAnswers().add(answer);
            }
    }
    
    private void reorderAnswers(){
        Iterator it = selectedQuestion.getAnswers().iterator();
        while(it.hasNext()){
            int i = 1;
            Answer answer = (Answer)it.next();
            answer.setAnswerorder(i);
            i++;
        }
    }
    
    public boolean isRenderAddNewAnswerButtonPanel() {
        if(selectedQuestion.getAnswers().size()>8 || selectedQuestion.getAnswers().size()<1) return false;
        return true;
    }
    
    public void columnTypeChange(){
        
    }
    
    public void deleteSubQuestionInput(){
        Subquestion subQuestion = (Subquestion)subQuestionsGrid.getRowData();
        if(subQuestion.getSubquestiontitle().isEmpty()){
            selectedQuestion.getSubquestions().remove(subQuestion.getSubquestionorder()-1);
            reorderSubQuestions();
        } else {
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("confirmDeleteSubQuestionInput.show()");
            deleteSubQuestionOrder = subQuestion.getSubquestionorder();
        }
    }
    
    public void confirmDeleteSubQuestionInput(){
        selectedQuestion.getSubquestions().remove(deleteSubQuestionOrder-1);
        reorderSubQuestions();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteSubQuestionInput.hide()");
    }
    
    public void moveSubQuestionUp(){
        Subquestion targetSubquestion = (Subquestion)subQuestionsGrid.getRowData();
        int targetIndex = targetSubquestion.getSubquestionorder()-1;
        Collections.swap(selectedQuestion.getSubquestions(), targetIndex, targetIndex-1);
        reorderSubQuestions();
    }
    
    public void moveSubQuestionDown(){
        Subquestion targetSubquestion = (Subquestion)subQuestionsGrid.getRowData();
        int targetIndex = targetSubquestion.getSubquestionorder()-1;
        Collections.swap(selectedQuestion.getSubquestions(), targetIndex, targetIndex+1);
        reorderSubQuestions();
    }
    
    public void addSubQuestionInput(){
        int newOrder = selectedQuestion.getSubquestions().size()+1;
        Subquestion newSubQuestion = new Subquestion();
        newSubQuestion.setSubquestionorder(newOrder);
        selectedQuestion.getSubquestions().add(newSubQuestion);
    }
    
    public void processSubQuestionsToDisplay(){
            for(int i=0;i<getNumberOfSubQuestionsSelected();i++){
                Subquestion subquestion = new Subquestion();
                subquestion.setSubquestionorder(i+1);
                selectedQuestion.getSubquestions().add(subquestion);
            }
    }
    
    private void reorderSubQuestions(){
        for(int i=0;i<selectedQuestion.getSubquestions().size();i++){
            selectedQuestion.getSubquestions().get(i).setSubquestionorder(i+1);
        }
    }
    
    public boolean isRenderAddNewSubQuestionButtonPanel() {
        if(selectedQuestion.getSubquestions().size()>8 || selectedQuestion.getSubquestions().size()<1) return false;
        return true;
    }
    
    public void deleteColumnChoiceInput(){
        Columnchoice cc = (Columnchoice)columnChoicesGrid.getRowData();
        if(cc.getColumnchoicetitle().isEmpty()){
            selectedQuestion.getColumnchoices().remove(cc.getColumnchoiceorder()-1);
            reorderColumnChoices();
        } else {
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("confirmDeleteColumnChoiceInput.show()");
            deleteColumnChoiceOrder = cc.getColumnchoiceorder();
        }
    }
    
    public void confirmDeleteColumnChoiceInput(){
        selectedQuestion.getColumnchoices().remove(deleteColumnChoiceOrder-1);
        reorderColumnChoices();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteColumnChoiceInput.hide()");
    }
    
    public void moveColumnChoiceUp(){
        Columnchoice targetColumnChoice = (Columnchoice)columnChoicesGrid.getRowData();
        int targetIndex = targetColumnChoice.getColumnchoiceorder()-1;
        Collections.swap(selectedQuestion.getColumnchoices(), targetIndex, targetIndex-1);
        reorderColumnChoices();
    }
    
    public void moveColumnChoiceDown(){
        Columnchoice targetColumnChoice = (Columnchoice)columnChoicesGrid.getRowData();
        int targetIndex = targetColumnChoice.getColumnchoiceorder()-1;
        Collections.swap(selectedQuestion.getColumnchoices(), targetIndex, targetIndex+1);
        reorderColumnChoices();
    }
    
    private void reorderColumnChoices(){
        for(int i=0;i<selectedQuestion.getColumnchoices().size();i++){
            selectedQuestion.getColumnchoices().get(i).setColumnchoiceorder(i+1);
        }
    }
    
    public void addColumnChoiceInput(){
        int newOrder = selectedQuestion.getColumnchoices().size()+1;
        Columnchoice newColumnChoice = new Columnchoice();
        newColumnChoice.setColumnchoiceorder(newOrder);
        selectedQuestion.getColumnchoices().add(newColumnChoice);
    }
    
    public void processColumnChoicesToDisplay(){
        for(int i=0;i<numberOfColumnChoicesSelected;i++){
                Columnchoice columnChoice = new Columnchoice();
                columnChoice.setColumnchoiceorder(i+1);
                selectedQuestion.getColumnchoices().add(columnChoice);
            }
    }
    
    public boolean isRenderAddNewColumnChoicesButtonPanel() {
        if(selectedQuestion.getColumnchoices().size()>8 || selectedQuestion.getColumnchoices().size()<1) return false;
        return true;
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
     * @return the selectedQuestion
     */
    public Question getSelectedQuestion() {
        return selectedQuestion;
    }

    /**
     * @param selectedQuestion the selectedQuestion to set
     */
    public void setSelectedQuestion(Question selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
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

    /**
     * @return the renderInputMask
     */
    public boolean isRenderInputMask() {
        return renderInputMask;
    }

    /**
     * @param renderInputMask the renderInputMask to set
     */
    public void setRenderInputMask(boolean renderInputMask) {
        this.renderInputMask = renderInputMask;
    }

    /**
     * @return the numberOfAnswersSelected
     */
    public Integer getNumberOfAnswersSelected() {
        return numberOfAnswersSelected;
    }

    /**
     * @param numberOfAnswersSelected the numberOfAnswersSelected to set
     */
    public void setNumberOfAnswersSelected(Integer numberOfAnswersSelected) {
        this.numberOfAnswersSelected = numberOfAnswersSelected;
    }

    /**
     * @return the numberOfAnswers
     */
    public SelectItem[] getNumberOfAnswers() {
        return numberOfAnswers;
    }

    /**
     * @param numberOfAnswers the numberOfAnswers to set
     */
    public void setNumberOfAnswers(SelectItem[] numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    /**
     * @return the answersGrid
     */
    public DataGrid getAnswersGrid() {
        return answersGrid;
    }

    /**
     * @param answersGrid the answersGrid to set
     */
    public void setAnswersGrid(DataGrid answersGrid) {
        this.answersGrid = answersGrid;
    }

    /**
     * @return the selectedQuestionId
     */
    public Integer getSelectedQuestionId() {
        return selectedQuestionId;
    }

    /**
     * @param selectedQuestionId the selectedQuestionId to set
     */
    public void setSelectedQuestionId(Integer selectedQuestionId) {
        this.selectedQuestionId = selectedQuestionId;
    }

    /**
     * @return the columnchoiceTypeItems
     */
    public List<SelectItem> getColumnchoiceTypeItems() {
        return columnchoiceTypeItems;
    }

    /**
     * @param columnchoiceTypeItems the columnchoiceTypeItems to set
     */
    public void setColumnchoiceTypeItems(List<SelectItem> columnchoiceTypeItems) {
        this.columnchoiceTypeItems = columnchoiceTypeItems;
    }

    /**
     * @return the columnChoicesGrid
     */
    public DataGrid getColumnChoicesGrid() {
        return columnChoicesGrid;
    }

    /**
     * @param columnChoicesGrid the columnChoicesGrid to set
     */
    public void setColumnChoicesGrid(DataGrid columnChoicesGrid) {
        this.columnChoicesGrid = columnChoicesGrid;
    }

    /**
     * @return the numberOfSubQuestions
     */
    public SelectItem[] getNumberOfSubQuestions() {
        return numberOfSubQuestions;
    }

    /**
     * @param numberOfSubQuestions the numberOfSubQuestions to set
     */
    public void setNumberOfSubQuestions(SelectItem[] numberOfSubQuestions) {
        this.numberOfSubQuestions = numberOfSubQuestions;
    }

    /**
     * @return the numberOfColumnChoices
     */
    public SelectItem[] getNumberOfColumnChoices() {
        return numberOfColumnChoices;
    }

    /**
     * @param numberOfColumnChoices the numberOfColumnChoices to set
     */
    public void setNumberOfColumnChoices(SelectItem[] numberOfColumnChoices) {
        this.numberOfColumnChoices = numberOfColumnChoices;
    }

    /**
     * @return the subQuestionsGrid
     */
    public DataGrid getSubQuestionsGrid() {
        return subQuestionsGrid;
    }

    /**
     * @param subQuestionsGrid the subQuestionsGrid to set
     */
    public void setSubQuestionsGrid(DataGrid subQuestionsGrid) {
        this.subQuestionsGrid = subQuestionsGrid;
    }

    /**
     * @return the numberOfSubQuestionsSelected
     */
    public Integer getNumberOfSubQuestionsSelected() {
        return numberOfSubQuestionsSelected;
    }

    /**
     * @param numberOfSubQuestionsSelected the numberOfSubQuestionsSelected to set
     */
    public void setNumberOfSubQuestionsSelected(Integer numberOfSubQuestionsSelected) {
        this.numberOfSubQuestionsSelected = numberOfSubQuestionsSelected;
    }

    /**
     * @return the numberOfColumnChoicesSelected
     */
    public Integer getNumberOfColumnChoicesSelected() {
        return numberOfColumnChoicesSelected;
    }

    /**
     * @param numberOfColumnChoicesSelected the numberOfColumnChoicesSelected to set
     */
    public void setNumberOfColumnChoicesSelected(Integer numberOfColumnChoicesSelected) {
        this.numberOfColumnChoicesSelected = numberOfColumnChoicesSelected;
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
     * @return the selectedQuestions
     */
    public Question[] getSelectedQuestions() {
        return selectedQuestions;
    }

    /**
     * @param selectedQuestions the selectedQuestions to set
     */
    public void setSelectedQuestions(Question[] selectedQuestions) {
        this.selectedQuestions = selectedQuestions;
    }

    /**
     * @return the selectedQuestionToDelete
     */
    public Question getSelectedQuestionToDelete() {
        return selectedQuestionToDelete;
    }

    /**
     * @param selectedQuestionToDelete the selectedQuestionToDelete to set
     */
    public void setSelectedQuestionToDelete(Question selectedQuestionToDelete) {
        this.selectedQuestionToDelete = selectedQuestionToDelete;
    }

    /**
     * @return the editQuestionSession
     */
    public EditQuestionSession getEditQuestionSession() {
        return editQuestionSession;
    }

    /**
     * @param editQuestionSession the editQuestionSession to set
     */
    public void setEditQuestionSession(EditQuestionSession editQuestionSession) {
        this.editQuestionSession = editQuestionSession;
    }

    /**
     * @return the findEmptyAnswer
     */
    public boolean isFindEmptyAnswer() {
        return findEmptyAnswer;
    }

    /**
     * @param findEmptyAnswer the findEmptyAnswer to set
     */
    public void setFindEmptyAnswer(boolean findEmptyAnswer) {
        this.findEmptyAnswer = findEmptyAnswer;
    }

    /**
     * @return the findEmptySubquestion
     */
    public boolean isFindEmptySubquestion() {
        return findEmptySubquestion;
    }

    /**
     * @param findEmptySubquestion the findEmptySubquestion to set
     */
    public void setFindEmptySubquestion(boolean findEmptySubquestion) {
        this.findEmptySubquestion = findEmptySubquestion;
    }

    /**
     * @return the findEmptyColumnchoice
     */
    public boolean isFindEmptyColumnchoice() {
        return findEmptyColumnchoice;
    }

    /**
     * @param findEmptyColumnchoice the findEmptyColumnchoice to set
     */
    public void setFindEmptyColumnchoice(boolean findEmptyColumnchoice) {
        this.findEmptyColumnchoice = findEmptyColumnchoice;
    }

    /**
     * @return the deleteAnswerOrder
     */
    public Integer getDeleteAnswerOrder() {
        return deleteAnswerOrder;
    }

    /**
     * @param deleteAnswerOrder the deleteAnswerOrder to set
     */
    public void setDeleteAnswerOrder(Integer deleteAnswerOrder) {
        this.deleteAnswerOrder = deleteAnswerOrder;
    }

    /**
     * @return the deleteSubQuestionOrder
     */
    public Integer getDeleteSubQuestionOrder() {
        return deleteSubQuestionOrder;
    }

    /**
     * @param deleteSubQuestionOrder the deleteSubQuestionOrder to set
     */
    public void setDeleteSubQuestionOrder(Integer deleteSubQuestionOrder) {
        this.deleteSubQuestionOrder = deleteSubQuestionOrder;
    }

    /**
     * @return the deleteColumnChoiceOrder
     */
    public Integer getDeleteColumnChoiceOrder() {
        return deleteColumnChoiceOrder;
    }

    /**
     * @param deleteColumnChoiceOrder the deleteColumnChoiceOrder to set
     */
    public void setDeleteColumnChoiceOrder(Integer deleteColumnChoiceOrder) {
        this.deleteColumnChoiceOrder = deleteColumnChoiceOrder;
    }
}
