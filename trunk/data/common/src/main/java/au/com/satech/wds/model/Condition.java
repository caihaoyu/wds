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
import javax.validation.constraints.NotNull;

/**
 *
 * @author sam
 */
@Entity
@Table(name="assumption")
public class Condition extends BaseObject {
    private static final long serialVersionUID = 1L;
    
    private Integer conditionid; // pk
    private Boolean skips;
    private Integer conditionType;
    private Integer comparator;
    private String conditionTitle;
    
    private Set<Scenario> scenarios=new HashSet<Scenario>();
    private List<Scenario> scenarioList=new ArrayList<Scenario>();
    
    public Condition() {
    }

    public Condition(Boolean skips,int conditionType,int comparator) {
        this.skips = skips;
        this.conditionType=conditionType;
        this.comparator=comparator;
    }
    
    
    @Column(nullable = false, unique = true)
    @GeneratedValue
    @Id
    public Integer getConditionid() {
        return conditionid;
    }

    public void setConditionid(Integer conditionid) {
        this.conditionid = conditionid;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("condition.conditionid=[").append(getConditionid()).append("]\n");
        result.append("condition.skips=[").append(getSkips()).append("]\n").append("condition.title=")
              .append(this.conditionTitle).append("condition.Type=").append(this.conditionType);
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Condition)) {
            return false;
        }
        
        final Condition condition = (Condition) o;
        
        return !(conditionid != null ? !(conditionid == condition.getConditionid()) : condition.getConditionid() != null);
    }
    
    @Override
    public int hashCode() {
        return (conditionid != null ? conditionid.hashCode() : 0);
    }

    /**
     * @return the skips
     */
    @Column
    public Boolean getSkips() {
        return skips;
    }

    /**
     * @param skips the skips to set
     */
    public void setSkips(Boolean skips) {
        this.skips = skips;
    }
    
    @Column(name="conditiontype",nullable=true)
    @NotNull
    public Integer getConditionType() {
        return conditionType;
    }

    public void setConditionType(Integer conditionType) {
        this.conditionType = conditionType;
    }

    @Column(name="comparator")
    public Integer getComparator() {
        return comparator;
    }

    public void setComparator(Integer comparator) {
        this.comparator = comparator;
    }
   
    

    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable(name="condition_scenario",
            joinColumns={@JoinColumn(name="conditionid")},
            inverseJoinColumns={@JoinColumn(name="scenarioid")}
            )
    public Set<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(Set<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    @Transient
    public List<Scenario> getScenarioList() {
        return scenarioList;
    }

    public void setScenarioList(List<Scenario> scenarioList) {
        this.scenarioList = scenarioList;
    }

    @Transient
    public String getConditionTitle() {
        return conditionTitle;
    }

    public void setConditionTitle(String conditionTitle) {
        this.conditionTitle = conditionTitle;
    }

    
    
    
}
