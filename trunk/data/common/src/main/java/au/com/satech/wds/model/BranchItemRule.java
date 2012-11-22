/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model;

import au.com.satech.wds.model.constant.QuestionruleConstant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author sam
 */
@Entity
@Table(name="branchitemrule")
public class BranchItemRule extends BaseObject {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(BranchItemRule.class);

    private Integer ruleid; // pk
    private String rulename; // not null
    private Condition condition;
    private Integer ruletype;
    private String htmlRuleName; // with html <span>s
    // One to Many
    private List<Result> results = new ArrayList<Result>();
    private List<Result> resultsList = new ArrayList<Result>();
    
    public BranchItemRule(){ 
        
    }

    public BranchItemRule(String rulename, Condition condition, Integer ruletype) {
        this.rulename = rulename;
        this.condition = condition;
        this.ruletype = ruletype;
    }

    public BranchItemRule(String rulename, Condition condition, Integer ruletype, List<Result> results) {
        this.rulename = rulename;
        this.condition = condition;
        this.ruletype = ruletype;
        this.results = results;
    }
    

    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("rule id:", this.ruleid)
                .append("rule name:", this.rulename)
                .append("rule type:", this.ruletype)
                .append("condition", this.condition)
                .append("results:"+this.results);
        
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BranchItemRule)) {
            return false;
        }
        final BranchItemRule questionrule = (BranchItemRule) o;
        return !(ruleid != null ? !(ruleid == questionrule.getRuleid()) : questionrule.getRuleid() != null);
    }

    @Override
    public int hashCode() {
        return (ruleid != null ? ruleid.hashCode() : 0);
    }

    @Column(nullable = false, unique = true)
    @GeneratedValue
    @Id
    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }
    
    @NotEmpty
    @Size(max = 200)
    @Column(nullable = false, length = 200)
    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename;
    }

    /**
     * @return the condition
     */
    @JoinColumn(name = "conditionid", unique = true)
    @OneToOne(cascade= CascadeType.ALL)
    public Condition getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    /**
     * @return the results
     */
    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable(name = "branchitemrule_result", joinColumns = @JoinColumn(name = "ruleid"), inverseJoinColumns = @JoinColumn(name = "resultid"))
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * @return the ruletype
     */
    @Column(nullable = false, length = 11)
    public Integer getRuletype() {
        return ruletype;
    }
    
    @Transient
    public String getRuletypeByName() {
        if(ruletype == 1) return QuestionruleConstant.SHOW_HIDDEN_QUESTION;
        if(ruletype == 2) return QuestionruleConstant.CHANGE_DEFAULT_BRANCH_OF_PAGE;
        if(ruletype == 3) return QuestionruleConstant.JUMP_TO_PAGE_RIGHT_AFTER;
        if(ruletype == 4) return QuestionruleConstant.JUMP_TO_PAGE_AFTER_PAGE;
        return "";
    }

    /**
     * @param ruletype the ruletype to set
     */
    public void setRuletype(Integer ruletype) {
        this.ruletype = ruletype;
    }

    @Transient
    public String getHtmlRuleName() {
        return htmlRuleName;
    }

    public void setHtmlRuleName(String htmlRuleName) {
        this.htmlRuleName = htmlRuleName;
    }

    /**
     * @return the resultsList
     */
    @Transient
    public List<Result> getResultsList() {
        return resultsList;
    }

    /**
     * @param resultsList the resultsList to set
     */
    public void setResultsList(List<Result> resultsList) {
        this.resultsList = resultsList;
    }
    
    
}
