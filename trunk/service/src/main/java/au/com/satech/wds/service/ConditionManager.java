/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service;

import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Scenario;
import au.com.satech.wds.model.Subquestion;
import java.util.List;

/**
 *
 * @author sam
 */
public interface ConditionManager extends GenericManager<Condition, Integer> {
    public List<Scenario> getScenarioList(Integer conditionId);
    
    public List<Subquestion> getReadySubquestionList(List<Subquestion> list,Condition condition,Integer columntype);
}
