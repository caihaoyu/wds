/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model;

import java.util.*;
import javax.persistence.*;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import static javax.persistence.GenerationType.IDENTITY;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author sam
 */
@Entity
@Indexed
@Table(name="branchitem")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BranchItem extends BaseObject {
    private Integer branchitemid;
    private boolean hidden;
    private Integer itemorder;
    private Integer questionid;
    private List<BranchItemRule> rules = new ArrayList<BranchItemRule>();
    private boolean hasRules;
    private int rulesSize;
    private List<String> responseAnswerIds;
    private Question question;
    private Entry entry = new Entry();
    private boolean mandatory;
    private Integer index;
    private BranchItemRule rule;
    
    public BranchItem(){
        
    }
    
    public BranchItem(Integer questionid, boolean hidden, Integer itemorder){
        this.questionid = questionid;
        this.hidden = hidden;
        this.itemorder = itemorder;
    }

    public BranchItem(boolean hidden, Integer itemorder, Integer questionid, List<BranchItemRule> rules) {
        this.hidden = hidden;
        this.itemorder = itemorder;
        this.questionid = questionid;
        this.rules = rules;
    }
    
    
    
    /**
     * @return the rules
     */
    @JoinTable(name = "branchitem_branchitemrule", joinColumns = @JoinColumn(name = "itemid"), inverseJoinColumns = @JoinColumn(name = "ruleid"))
    @OneToMany(cascade=CascadeType.ALL)
    public List<BranchItemRule> getRules() {
        return rules;
    }

    /**
     * @param rules the rules to set
     */
    public void setRules(List<BranchItemRule> rules) {
        this.rules = rules;
    }
    
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
        sb.append("Branch Item ID:", this.branchitemid);
        sb.append("Branch Item is hidden:",this.hidden);
        sb.append("Branch Item order:", this.itemorder);
        sb.append("Question Id:",this.questionid);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BranchItem)) {
            return false;
        }

        final BranchItem item = (BranchItem) o;

        return !(branchitemid != null ? !(branchitemid == item.getBranchitemid()) : item.getBranchitemid() != null);
    }

    @Override
    public int hashCode() {
        return (branchitemid != null ? branchitemid.hashCode() : 0);
    }

    /**
     * @return the branchitemid
     */
    @Id 
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="branchitemid", unique=true, nullable=false)
    public Integer getBranchitemid() {
        return branchitemid;
    }

    /**
     * @param branchitemid the branchitemid to set
     */
    public void setBranchitemid(Integer branchitemid) {
        this.branchitemid = branchitemid;
    }

    /**
     * @return the hidden
     */
    @Column(name="hidden")
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param hidden the hidden to set
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return the itemorder
     */
    @Column(name="itemorder")
    public Integer getItemorder() {
        return itemorder;
    }

    /**
     * @param itemorder the itemorder to set
     */
    public void setItemorder(Integer itemorder) {
        this.itemorder = itemorder;
    }

    /**
     * @return the questionid
     */
    @Column(name="questionid")
    public Integer getQuestionid() {
        return questionid;
    }

    /**
     * @param questionid the questionid to set
     */
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }
    
    /**
     * @return the mandatory
     */
    @Column
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * @param mandatory the mandatory to set
     */
    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
    
    @Transient
    public boolean isHasRules() {
        return hasRules;
    }

    public void setHasRules(boolean hasRules) {
        this.hasRules = hasRules;
    }
    
    @Transient
    public int getRulesSize() {
        return rulesSize;
    }

    public void setRulesSize(int rulesSize) {
        this.rulesSize = rulesSize;
    }

    /**
     * @return the question
     */
    @Transient
    public Question getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * @return the responseAnswerIds
     */
    @Transient
    public List<String> getResponseAnswerIds() {
        return responseAnswerIds;
    }

    /**
     * @param responseAnswerIds the responseAnswerIds to set
     */
    public void setResponseAnswerIds(List<String> responseAnswerIds) {
        this.responseAnswerIds = responseAnswerIds;
    }

    /**
     * @return the entry
     */
    @Transient
    public Entry getEntry() {
        return entry;
    }

    /**
     * @param entry the entry to set
     */
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    /**
     * @return the index
     */
    @Transient
    public Integer getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    @Transient
    public BranchItemRule getRule() {
        return rule;
    }

    public void setRule(BranchItemRule rule) {
        this.rule = rule;
    }
    

}
