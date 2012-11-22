/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao;

import au.com.satech.wds.model.Scenario;
import java.util.List;

/**
 *
 * @author cai
 */
public interface ScenarioDao extends GenericDao<Scenario, Integer> {
    public List<Scenario> getScenarioListBySubQuestionId(Integer subQuestionId,Integer[] scenarioIds);
    
}
