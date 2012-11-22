/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service;



/**
 *
 * @author cai
 */
import au.com.satech.wds.model.Scenario;
import java.util.List;
public interface ScenarioManager extends GenericManager<Scenario, Integer>{
    public List<Scenario> getScenarioListBySubQuestionId(Integer subQuestionId,Integer[] scenarioIds);
}
