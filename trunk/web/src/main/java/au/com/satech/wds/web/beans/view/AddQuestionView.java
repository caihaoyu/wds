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
import au.com.satech.wds.web.beans.BaseBean;
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
import org.primefaces.component.datagrid.DataGrid;
import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author sam
 */
@ManagedBean(name ="addQuestionView")
@ViewScoped
public class AddQuestionView extends BaseBean implements Serializable {
    
    @PostConstruct
    public void setup(){
        FacesContext context = FacesContext.getCurrentInstance();
        Question updatedQuestion = (Question)context.getExternalContext().getFlash().get("updatedQuestion");
        if(updatedQuestion != null) {
            FacesMessage fm = new FacesMessage("Info:", "Question \""+updatedQuestion.getQuestiontitle()+"\" is added.");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage(null, fm);
        }
        setNewQuestion(new Question());
        newQuestion.setQuestiontitle(QuestionConstant.DEFAULTBODYTEXT);
        newQuestion.setQuestiontype(1);
        newQuestion.setAnswertype(1);
        newQuestion.setAllowcustomized(false);
        newQuestion.setAllowdescription(false);
        newQuestion.setAllowmultipile(false);
        setFocusIndex(0); // focus index 0 equals question type free text is the first tab in view.
        
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
    
    // answers
    private DataGrid answersGrid;
    
    private DataGrid subQuestionsGrid;
    private DataGrid columnChoicesGrid;
    
    
    // tab view focus index
    private Integer focusIndex;
    private Integer numberOfAnswersSelected;
    private Integer numberOfSubQuestionsSelected;
    private Integer numberOfColumnChoicesSelected;
    
    // new question
    private Question newQuestion;
    
    private SelectItem[] numberOfAnswers;
    private SelectItem[] numberOfSubQuestions;
    private SelectItem[] numberOfColumnChoices;
    private List<SelectItem> columnchoiceTypeItems;
    
    private Integer deleteAnswerOrder;
    private Integer deleteSubQuestionOrder;
    private Integer deleteColumnChoiceOrder;
    
    private boolean findEmptyAnswer;
    private boolean findEmptySubquestion;
    private boolean findEmptyColumnchoice;
    
    // layout control booleans
    private boolean renderInputMask;
        
    // popup content
    private String warnPopContent;
    
    public void processSaveQuestionTitle(){
        
    }
    
    public void displayWarningPopup(String warnPopContent){
        RequestContext rqContext = RequestContext.getCurrentInstance();
        setWarnPopContent(warnPopContent);
        rqContext.execute("warndl.show()");
    }
    
    public void processAddQuestionButton(ActionEvent event){
        if(newQuestion.getQuestiontitle().equals(QuestionConstant.DEFAULTBODYTEXT)){
            RequestContext rqContext = RequestContext.getCurrentInstance();
            setWarnPopContent("Please set question title before save.");
            rqContext.execute("warndl.show()");
        } else {
            if(newQuestion.getQuestiontype() == 1){
                RequestContext rqContext = RequestContext.getCurrentInstance();
                rqContext.execute("confirmAddQuestionDialog.show()");
            } else if(newQuestion.getQuestiontype() == 2) {
                RequestContext rqContext = RequestContext.getCurrentInstance();
                rqContext.execute("confirmAddQuestionDialog.show()");
            } else if(newQuestion.getQuestiontype() == 3) {
                if(newQuestion.getAnswers().isEmpty()) {
                    RequestContext rqContext = RequestContext.getCurrentInstance();
                    setWarnPopContent("Cannot create question, there is no answer.");
                    rqContext.execute("warndl.show()");
                } else {
                    setFindEmptyAnswer(false);
                    int numberOfEmptyAnswer = 0;
                    for(Answer answer:newQuestion.getAnswers()){
                        if(answer.getAnswertitle().isEmpty()){
                            setFindEmptyAnswer(true);
                            numberOfEmptyAnswer++;
                        }
                    }
                    if(numberOfEmptyAnswer == newQuestion.getAnswers().size()){
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        setWarnPopContent("Cannot create question, all answers are empty.");
                        rqContext.execute("warndl.show()");
                    } else {
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        rqContext.execute("confirmAddQuestionDialog.show()");
                    }
                }
            } else if(newQuestion.getQuestiontype() == 4) {
                if(newQuestion.getSubquestions().isEmpty()) {
                    RequestContext rqContext = RequestContext.getCurrentInstance();
                    setWarnPopContent("Cannot create question, there is no sub question.");
                    rqContext.execute("warndl.show()");
                } else {
                    setFindEmptySubquestion(false);
                    int numberOfEmptySubquestions = 0;
                    for(Subquestion subQuestion:newQuestion.getSubquestions()){
                        if(subQuestion.getSubquestiontitle().isEmpty()){
                            setFindEmptySubquestion(true);
                            numberOfEmptySubquestions++;
                        }
                    }
                    if(numberOfEmptySubquestions == newQuestion.getSubquestions().size()){
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        setWarnPopContent("Cannot create question, all answers are empty.");
                        rqContext.execute("warndl.show()");
                    } else if(newQuestion.getColumntype() == 3 && newQuestion.getColumnchoices().size()<=1) {
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        setWarnPopContent("Cannot create question, you need at least two column choices.");
                        rqContext.execute("warndl.show()");
                    } else {
                        RequestContext rqContext = RequestContext.getCurrentInstance();
                        rqContext.execute("confirmAddQuestionDialog.show()");
                    }
                }
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage fm = new FacesMessage("Error:", "Question type value error.");
                fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, fm);
            }
        }
    }
    
    private void deleteExtraAttributes(){
        switch(newQuestion.getQuestiontype()){
            case 1: { 
                newQuestion.setRating(null);
                newQuestion.setAnswers(null);
                newQuestion.setColumnchoices(null);
                newQuestion.setSubquestions(null);
                break;
            }
            case 2: {
                newQuestion.setAnswertype(null);
                newQuestion.setAnswermask(null);
                newQuestion.setAnswers(null);
                newQuestion.setColumnchoices(null);
                newQuestion.setSubquestions(null);
                break;
            }
            case 3: {
                newQuestion.setAnswertype(null);
                newQuestion.setAnswermask(null);
                newQuestion.setRating(null);
                newQuestion.setColumnchoices(null);
                newQuestion.setSubquestions(null);
                break;
            }
            case 4: {
                newQuestion.setAnswertype(null);
                newQuestion.setAnswermask(null);
                newQuestion.setRating(null);
                newQuestion.setAnswers(null);
                break;
            }
        }
    }
    
    private void deleteEmptyAnswer(){
        Iterator it = newQuestion.getAnswers().iterator();
        while(it.hasNext()){
            Answer answer = (Answer)it.next();
            if(answer.getAnswertitle().isEmpty()) newQuestion.getAnswers().remove(answer);
        }
        reorderAnswers();
    }
    
    private void deleteEmptySubQuestion(){
        for(int i=0;i<newQuestion.getSubquestions().size();i++){
            if(newQuestion.getSubquestions().get(i).getSubquestiontitle().isEmpty()) newQuestion.getSubquestions().remove(i);
        }
        reorderSubQuestions();
    }
    
    private void deleteEmptyColumnChoice(){
        for(int i=0;i<newQuestion.getColumnchoices().size();i++){
            if(newQuestion.getColumnchoices().get(i).getColumnchoicetitle().isEmpty()) newQuestion.getColumnchoices().remove(i);
        }
        reorderColumnChoices();
    }
    
    public String confirmAddQuestion(){
        deleteExtraAttributes();
        if(newQuestion.getQuestiontype() == 3){
            if(findEmptyAnswer) deleteEmptyAnswer();
        }
        if(newQuestion.getQuestiontype() == 4){
            if(findEmptySubquestion) deleteEmptySubQuestion();
            if(findEmptyColumnchoice) deleteEmptyColumnChoice();
        }
        newQuestion = getQuestionManager().saveQuestion(newQuestion);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().putNow("updatedQuestion", newQuestion);
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmAddQuestionDialog.hide()");
        editQuestionSession.refreshList();
        return "editQuestion";     
    }
    
    public void processTabChange(TabChangeEvent event){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(focusIndex.equals(0)){
            newQuestion.setQuestiontype(1); // set question type to free text
        } else if(focusIndex.equals(1)){
            newQuestion.setQuestiontype(2); // set question type to rating
            newQuestion.setRating(new Double(5.0));
        } else if(focusIndex.equals(2)){
            newQuestion.setQuestiontype(3); // set question type to choice
        } else if(focusIndex.equals(3)){
            newQuestion.setQuestiontype(4); // set question type to matrix
            newQuestion.setColumntype(3);
        } else {
            FacesMessage fm = new FacesMessage("Error:", "Question type value error.");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, fm);
        }
    }
    
    public void columnTypeChange(){
        
    }
    
    public void processRenderInputMaskValueChange(){
        if(!renderInputMask){
            newQuestion.setAnswermask(null);
        }
    }
    
    public void answerMaskValueChange(){
        
    }
    
    public void answerTypeValueChange(){
        if(newQuestion.getQuestiontype()>4 || newQuestion.getQuestiontype()<1){
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage("Error:", "Question type value error.");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, fm);
        }
    }
    
    public void ratingChange(){
        
    }
    
    public void addNewAnswerInput(){
        int newOrder = newQuestion.getAnswers().size()+1;
        Answer newAnswer = new Answer();
        newAnswer.setAnswerorder(newOrder);
        newQuestion.getAnswers().add(newAnswer);
    }
    
    public void deleteAnswerInput(){      
        Answer answer = (Answer)answersGrid.getRowData();
        if(answer.getAnswertitle().isEmpty()){
            newQuestion.getAnswers().remove(answer.getAnswerorder()-1);
            reorderAnswers();
        } else {
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("confirmDeleteAnswerInput.show()");
            deleteAnswerOrder = answer.getAnswerorder();
        }
    }
    
    public void confirmDeleteAnswerInput(){
        newQuestion.getAnswers().remove(deleteAnswerOrder-1);
        reorderAnswers();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteAnswerInput.hide()");
    }
    
    public void moveAnswerUp(ActionEvent event){
        Answer targetAnswer = (Answer)answersGrid.getRowData();
        int targetIndex = targetAnswer.getAnswerorder()-1;
        //TODO: Swap function need rewrite
//        Collections.swap(newQuestion.getAnswers(), targetIndex, targetIndex-1);
        reorderAnswers();
    }
    
    public void moveAnswerDown(ActionEvent event){
        Answer targetAnswer = (Answer)answersGrid.getRowData();
        int targetIndex = targetAnswer.getAnswerorder()-1;
        //TODO: Swap function need rewrite
//        Collections.swap(newQuestion.getAnswers(), targetIndex, targetIndex+1);
        reorderAnswers();
    }
    
    public void answerNumberSelect(){
        
    }
    
    private void reorderAnswers(){
        Iterator it = newQuestion.getAnswers().iterator();
        while(it.hasNext()){
            int i = 1;
            Answer answer = (Answer)it.next();
            answer.setAnswerorder(i);
            i++;
        }
    }
    
    public void processAnswersToDisplay(){
            for(int i=0;i<numberOfAnswersSelected;i++){
                Answer answer = new Answer();
                answer.setAnswerorder(i+1);
                newQuestion.getAnswers().add(answer);
            }
    }
    
    public void deleteSubQuestionInput(){
        Subquestion subQuestion = (Subquestion)subQuestionsGrid.getRowData();
        if(subQuestion.getSubquestiontitle().isEmpty()){
            newQuestion.getSubquestions().remove(subQuestion.getSubquestionorder()-1);
            reorderSubQuestions();
        } else {
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("confirmDeleteSubQuestionInput.show()");
            deleteSubQuestionOrder = subQuestion.getSubquestionorder();
        }
    }
    
    public void confirmDeleteSubQuestionInput(){
        newQuestion.getSubquestions().remove(deleteSubQuestionOrder-1);
        reorderSubQuestions();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteSubQuestionInput.hide()");
    }
    
    public void moveSubQuestionUp(){
        Subquestion targetSubquestion = (Subquestion)subQuestionsGrid.getRowData();
        int targetIndex = targetSubquestion.getSubquestionorder()-1;
        Collections.swap(newQuestion.getSubquestions(), targetIndex, targetIndex-1);
        reorderSubQuestions();
    }
    
    public void moveSubQuestionDown(){
        Subquestion targetSubquestion = (Subquestion)subQuestionsGrid.getRowData();
        int targetIndex = targetSubquestion.getSubquestionorder()-1;
        Collections.swap(newQuestion.getSubquestions(), targetIndex, targetIndex+1);
        reorderSubQuestions();
    }
    
    public void addSubQuestionInput(){
        int newOrder = newQuestion.getSubquestions().size()+1;
        Subquestion newSubQuestion = new Subquestion();
        newSubQuestion.setSubquestionorder(newOrder);
        newQuestion.getSubquestions().add(newSubQuestion);
    }
    
    private void reorderSubQuestions(){
        for(int i=0;i<newQuestion.getSubquestions().size();i++){
            newQuestion.getSubquestions().get(i).setSubquestionorder(i+1);
        }
    }
    
    public void processSubQuestionsToDisplay(){
        for(int i=0;i<numberOfSubQuestionsSelected;i++){
            Subquestion subquestion = new Subquestion();
            subquestion.setSubquestionorder(i+1);
            newQuestion.getSubquestions().add(subquestion);
        }
    }
    
    public void deleteColumnChoiceInput(){
        Columnchoice cc = (Columnchoice)columnChoicesGrid.getRowData();
        if(cc.getColumnchoicetitle().isEmpty()){
            newQuestion.getColumnchoices().remove(cc.getColumnchoiceorder()-1);
            reorderColumnChoices();
        } else {
            RequestContext rqContext = RequestContext.getCurrentInstance();
            rqContext.execute("confirmDeleteColumnChoiceInput.show()");
            deleteColumnChoiceOrder = cc.getColumnchoiceorder();
        }
    }
    
    public void confirmDeleteColumnChoiceInput(){
        newQuestion.getColumnchoices().remove(deleteColumnChoiceOrder-1);
        reorderColumnChoices();
        RequestContext rqContext = RequestContext.getCurrentInstance();
        rqContext.execute("confirmDeleteColumnChoiceInput.hide()");
    }
    
    public void moveColumnChoiceUp(){
        Columnchoice targetColumnChoice = (Columnchoice)columnChoicesGrid.getRowData();
        int targetIndex = targetColumnChoice.getColumnchoiceorder()-1;
        Collections.swap(newQuestion.getColumnchoices(), targetIndex, targetIndex-1);
        reorderColumnChoices();
    }
    
    public void moveColumnChoiceDown(){
        Columnchoice targetColumnChoice = (Columnchoice)columnChoicesGrid.getRowData();
        int targetIndex = targetColumnChoice.getColumnchoiceorder()-1;
        Collections.swap(newQuestion.getColumnchoices(), targetIndex, targetIndex+1);
        reorderColumnChoices();
    }
    
    private void reorderColumnChoices(){
        for(int i=0;i<newQuestion.getColumnchoices().size();i++){
            newQuestion.getColumnchoices().get(i).setColumnchoiceorder(i+1);
        }
    }
    
    public void addColumnChoiceInput(){
        int newOrder = newQuestion.getColumnchoices().size()+1;
        Columnchoice newColumnChoice = new Columnchoice();
        newColumnChoice.setColumnchoiceorder(newOrder);
        newQuestion.getColumnchoices().add(newColumnChoice);
    }
    
    public void processColumnChoicesToDisplay(){
        for(int i=0;i<numberOfColumnChoicesSelected;i++){
                Columnchoice columnChoice = new Columnchoice();
                columnChoice.setColumnchoiceorder(i+1);
                newQuestion.getColumnchoices().add(columnChoice);
            }
    }

    
    public boolean isRenderAddNewSubQuestionButtonPanel() {
        if(newQuestion.getSubquestions().size()>8 || newQuestion.getSubquestions().size()<1) return false;
        return true;
    }
    
    public boolean isRenderAddNewColumnChoicesButtonPanel() {
        if(newQuestion.getColumnchoices().size()>8 || newQuestion.getColumnchoices().size()<1) return false;
        return true;
    }
    
    public boolean isRenderAddNewAnswerButtonPanel() {
        if(newQuestion.getAnswers().size()>8 || newQuestion.getAnswers().size()<1) return false;
        return true;
    }
    
    /**
        * -------================ Getter and Setter ================-------
        */

    /**
     * @return the focusIndex
     */
    public Integer getFocusIndex() {
        return focusIndex;
    }

    /**
     * @param focusIndex the focusIndex to set
     */
    public void setFocusIndex(Integer focusIndex) {
        this.focusIndex = focusIndex;
    }

    /**
     * @return the newQuestion
     */
    public Question getNewQuestion() {
        return newQuestion;
    }

    /**
     * @param newQuestion the newQuestion to set
     */
    public void setNewQuestion(Question newQuestion) {
        this.newQuestion = newQuestion;
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
}
