/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 *
 * @author cai
 */
@Entity
@Table(name="scenario")
public class Scenario extends BaseObject implements java.io.Serializable{
    private Integer scenarionid;
    private Integer subquestionId;
    private Integer rating;
    private Integer answerId;
    private String textAnswer;
    private Integer comparator;
    private String scenarioTitle;
    
    private Set<Scenariocc> scenarioccs=new HashSet<Scenariocc>();
    private List<Scenariocc> scenarioccList=new ArrayList<Scenariocc>();

    @Column(name="scenarioid", nullable = false, unique = true)
    @GeneratedValue
    @Id
    public Integer getScenarionid() {
        return scenarionid;
    }

    public void setScenarionid(Integer scenarionid) {
        this.scenarionid = scenarionid;
    }

    @Column(name="subquestionid")
    public Integer getSubquestionId() {
        return subquestionId;
    }

    public void setSubquestionId(Integer subquestionId) {
        this.subquestionId = subquestionId;
    }

    @Column(name="rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Column(name="answerid")
    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    @Column(name="textanswer")
    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    @Column(name="comparator")
    public Integer getComparator() {
        return comparator;
    }

    public void setComparator(Integer comparator) {
        this.comparator = comparator;
    }

    @Column(name="scenariotitle")
    public String getScenarioTitle() {
        return scenarioTitle;
    }

    public void setScenarioTitle(String scenarioTitle) {
        this.scenarioTitle = scenarioTitle;
    }

   @OneToMany(cascade= CascadeType.ALL)
   @JoinTable(name="scenario_scenariocc",
            joinColumns={@JoinColumn(name="scenarioid")},
            inverseJoinColumns={@JoinColumn(name="scenarioccid")}
            )
    public Set<Scenariocc> getScenarioccs() {
        return scenarioccs;
    }

    public void setScenarioccs(Set<Scenariocc> scenarioccs) {
        this.scenarioccs = scenarioccs;
    }

    @Transient
    public List<Scenariocc> getScenarioccList() {
        return scenarioccList;
    }

    public void setScenarioccList(List<Scenariocc> scenarioccList) {
        this.scenarioccList = scenarioccList;
    }
    
    

   
    
    
    @Override
    public String toString() {
         ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("scenarion id", this.scenarionid)
                .append("subquestion id", this.subquestionId)
                .append("answer id",this.answerId)
                .append("rating",this.rating)
                .append("answer text",this.textAnswer);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
         if(this == o) {
            return true;
        }
        if(!(o instanceof Scenario)){
            return false;
        }
        final Scenario scenario = (Scenario)o;
        
        return !(scenarionid != null ? !(scenario.getScenarionid() == scenarionid) : scenario.getScenarionid() != null);
    }

    @Override
    public int hashCode() {
        return (scenarionid != null ? scenarionid.hashCode() : 0);
    }
    
}
