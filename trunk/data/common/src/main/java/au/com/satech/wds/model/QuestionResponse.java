/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author zhao
 */
@Entity
@Table(name="questionresponse")
public class QuestionResponse extends BaseObject implements java.io.Serializable {
    private Integer qr_id;
    private Integer pr_id;
    private boolean allowcustomized;
    private boolean allowdescription;
    private boolean allowmultipile;
    private String questiontitle;
    private Integer questiontype;
    private boolean wysiwyg;
    private Integer answertype;
    private String answermask;
    private Integer rating;
    private Integer columntype;
    private Integer questionorder;
    private String description;
    private Date createDate;
    private Date modifiedDate;
    
    private List<AnswerResponse> answerresponses = new ArrayList<AnswerResponse>();
    private List<SubQuestionResponse> subquestionresponses = new ArrayList<SubQuestionResponse>();
    private List<ColumnChoiceResponse> columnchoiceresponses = new ArrayList<ColumnChoiceResponse>();
    private List<Entry> entries = new ArrayList<Entry>();
    
    public QuestionResponse(){
        
    }
    
    public QuestionResponse(Question question){
        this.allowcustomized = question.getAllowcustomized();
        this.allowdescription = question.getAllowdescription();
        this.allowmultipile = question.getAllowmultipile();
        this.questiontitle = question.getQuestiontitle();
        this.questiontype = question.getQuestiontype();
        this.wysiwyg = question.getWysiwyg();
        this.answertype = question.getAnswertype();
        this.answermask = question.getAnswermask();
        this.rating = question.getRating() == null ? null : question.getRating().intValue();
        this.columntype = question.getColumntype();
        this.description = question.getDescription();
        this.createDate = question.getCreateDate();
        this.modifiedDate = question.getModifiedDate();
    }
    
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("question response id", this.qr_id)
                .append("question title", this.getQuestiontitle())
                .append("question type", this.getQuestiontype());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuestionResponse)) {
            return false;
        }

        final QuestionResponse r = (QuestionResponse) o;

        return !(qr_id != null ? !(qr_id == r.getQr_id()) : r.getQr_id() != null);
    }

    @Override
    public int hashCode() {
        return (getQr_id() != null ? getQr_id().hashCode() : 0);
    }

    /**
     * @return the qr_id
     */
    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="qr_id", unique=true, nullable=false)
    public Integer getQr_id() {
        return qr_id;
    }

    /**
     * @param qr_id the qr_id to set
     */
    public void setQr_id(Integer qr_id) {
        this.qr_id = qr_id;
    }

    /**
     * @return the pr_id
     */
    @Column
    public Integer getPr_id() {
        return pr_id;
    }

    /**
     * @param pr_id the pr_id to set
     */
    public void setPr_id(Integer pr_id) {
        this.pr_id = pr_id;
    }

    /**
     * @return the allowcustomized
     */
    @Column
    public boolean isAllowcustomized() {
        return allowcustomized;
    }

    /**
     * @param allowcustomized the allowcustomized to set
     */
    public void setAllowcustomized(boolean allowcustomized) {
        this.allowcustomized = allowcustomized;
    }

    /**
     * @return the allowdescription
     */
    @Column
    public boolean isAllowdescription() {
        return allowdescription;
    }

    /**
     * @param allowdescription the allowdescription to set
     */
    public void setAllowdescription(boolean allowdescription) {
        this.allowdescription = allowdescription;
    }

    /**
     * @return the allowmultipile
     */
    @Column
    public boolean isAllowmultipile() {
        return allowmultipile;
    }

    /**
     * @param allowmultipile the allowmultipile to set
     */
    public void setAllowmultipile(boolean allowmultipile) {
        this.allowmultipile = allowmultipile;
    }

    /**
     * @return the questiontitle
     */
    @Column
    public String getQuestiontitle() {
        return questiontitle;
    }

    /**
     * @param questiontitle the questiontitle to set
     */
    public void setQuestiontitle(String questiontitle) {
        this.questiontitle = questiontitle;
    }

    /**
     * @return the questiontype
     */
    @Column
    public Integer getQuestiontype() {
        return questiontype;
    }

    /**
     * @param questiontype the questiontype to set
     */
    public void setQuestiontype(Integer questiontype) {
        this.questiontype = questiontype;
    }

    /**
     * @return the wysiwyg
     */
    @Column
    public boolean isWysiwyg() {
        return wysiwyg;
    }

    /**
     * @param wysiwyg the wysiwyg to set
     */
    public void setWysiwyg(boolean wysiwyg) {
        this.wysiwyg = wysiwyg;
    }

    /**
     * @return the answertype
     */
    @Column
    public Integer getAnswertype() {
        return answertype;
    }

    /**
     * @param answertype the answertype to set
     */
    public void setAnswertype(Integer answertype) {
        this.answertype = answertype;
    }

    /**
     * @return the answermask
     */
    @Column
    public String getAnswermask() {
        return answermask;
    }

    /**
     * @param answermask the answermask to set
     */
    public void setAnswermask(String answermask) {
        this.answermask = answermask;
    }

    /**
     * @return the rating
     */
    @Column
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * @return the columntype
     */
    @Column
    public Integer getColumntype() {
        return columntype;
    }

    /**
     * @param columntype the columntype to set
     */
    public void setColumntype(Integer columntype) {
        this.columntype = columntype;
    }

    /**
     * @return the answerresponses
     */
    @Transient
    public List<AnswerResponse> getAnswerresponses() {
        return answerresponses;
    }

    /**
     * @param answerresponses the answerresponses to set
     */
    public void setAnswerresponses(ArrayList<AnswerResponse> answerresponses) {
        this.answerresponses = answerresponses;
    }

    /**
     * @return the subquestionresponses
     */
    @Transient
    public List<SubQuestionResponse> getSubquestionresponses() {
        return subquestionresponses;
    }

    /**
     * @param subquestionresponses the subquestionresponses to set
     */
    public void setSubquestionresponses(ArrayList<SubQuestionResponse> subquestionresponses) {
        this.subquestionresponses = subquestionresponses;
    }

    /**
     * @return the columnchoiceresponses
     */
    @Transient
    public List<ColumnChoiceResponse> getColumnchoiceresponses() {
        return columnchoiceresponses;
    }

    /**
     * @param columnchoiceresponses the columnchoiceresponses to set
     */
    public void setColumnchoiceresponses(ArrayList<ColumnChoiceResponse> columnchoiceresponses) {
        this.columnchoiceresponses = columnchoiceresponses;
    }

    /**
     * @return the entries
     */
    @Transient
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to List
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    /**
     * @return the description
     */
    @Column(name="description",columnDefinition="TEXT")
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the createDate
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the modifiedDate
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return the questionorder
     */
    public Integer getQuestionorder() {
        return questionorder;
    }

    /**
     * @param questionorder the questionorder to set
     */
    public void setQuestionorder(Integer questionorder) {
        this.questionorder = questionorder;
    }

}
