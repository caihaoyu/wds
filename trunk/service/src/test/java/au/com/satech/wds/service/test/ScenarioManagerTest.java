/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import au.com.satech.wds.model.Scenario;
import au.com.satech.wds.model.Scenariocc;
import au.com.satech.wds.model.Subquestion;
import au.com.satech.wds.service.ScenarioManager;
import au.com.satech.wds.service.ScenarioccManager;
import au.com.satech.wds.service.SubquestionManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SecnarioManager的测试类
 * @author xiong
 */
public class ScenarioManagerTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(getClass());
    
    @Autowired
    private ScenarioManager mgr;
    
    @Autowired
    private ScenarioccManager cmgr;
    
    @Autowired
    private SubquestionManager smgr;
    
    private Scenario scenario;
    private Scenario scenario1;
    private Scenariocc scenariocc1;
    private Scenariocc scenariocc2;
    private Scenariocc scenariocc3;
    private Subquestion  subquestion;
    private Set<Scenariocc> scenarioccs;
    
    /*
     * 测试前装配对象属性
     */  
    @Before
    public void setUp() {
        scenario = new Scenario();
        scenario1 = new Scenario();
        scenariocc1 = new Scenariocc();
        scenariocc2 = new Scenariocc();
        scenariocc3 = new Scenariocc();
        scenarioccs = new HashSet<Scenariocc>();
        
        subquestion = new Subquestion();
    }
    
    @Test
    public void testScenarioAndScenarioCC(){
        int oldScenarioccNum = cmgr.getAll().size();
        scenariocc1.setColumnchoiceid(1);
        scenariocc2.setColumnchoiceid(1);
        scenariocc3.setColumnchoiceid(1);
        scenariocc1 = cmgr.save(scenariocc1);
        scenariocc2 = cmgr.save(scenariocc2);
        scenariocc3 = cmgr.save(scenariocc3);
        int newScenarioccNum = cmgr.getAll().size();
        assertEquals(oldScenarioccNum+3, newScenarioccNum);
        
        scenarioccs.add(scenariocc1);
        scenarioccs.add(scenariocc2);
        scenarioccs.add(scenariocc3);
        scenario.setScenarioccs(scenarioccs);
        
        int oldScenarioNum = mgr.getAll().size();
        scenario = mgr.save(scenario);
        int newScenarioNum = mgr.getAll().size();
        assertEquals(oldScenarioNum+1, newScenarioNum);
        assertEquals(scenario.getScenarioccs().size(), 3);
        
        
        mgr.remove(scenario.getScenarionid());
        newScenarioNum = mgr.getAll().size();
        newScenarioccNum = cmgr.getAll().size();
        assertEquals(oldScenarioNum, newScenarioNum);
        assertEquals(oldScenarioccNum, newScenarioccNum);
        
    }
    /**
     * 测试save方法
     * @throws Exception 
     */
    @Test
    public void testSaveAnswer() throws Exception{
        int numberOfAnswersBeforeAdd = mgr.getAll().size();
        scenario = mgr.save(scenario);
        int numberOfAnswersAfterAdd = mgr.getAll().size();
        assertTrue(numberOfAnswersBeforeAdd+1 == numberOfAnswersAfterAdd);
    }
    /**
     * 测试的get方法
     * @throws Exception 
     */
    
    @Test
    public void testGetScenario() throws Exception {
        log.debug(mgr);
        log.debug("ture or false:   "+mgr == null);
        scenario = mgr.save(scenario);
        log.debug("测试scenario"+scenario);
        log.debug("测试scenarioId"+scenario.getScenarionid());
        int scenarioId = scenario.getScenarionid();
        scenario = null;
        assertNull(scenario);
        scenario = mgr.get(scenarioId);
        assertNotNull(scenario);
    }
    /**
     * 测试getALl方法
     * @throws Exception 
     */
    
    @Test
    public void testGetScenarios() throws Exception{
        scenario = mgr.save(scenario);
        ArrayList<Scenario> scenarios = new ArrayList<Scenario>(mgr.getAll());
        assertTrue(scenarios.size()>0);
    }
    /**
     * 测试remove方法
     * @throws Exception 
     */
    @Test
    public void testDeleteScenario() throws Exception {
        scenario = mgr.save(scenario);
        int numberOfAnswersBefore = mgr.getAll().size();
        mgr.remove(scenario.getScenarionid());
        int numberOfAnswersAfter = mgr.getAll().size();
        assertTrue(numberOfAnswersAfter == numberOfAnswersBefore-1);
    }
    
    /**
     * 测试getScenarioListBySubQuestionId
     */
    @Test
    public void testGetScenarioListBySubQuestionId(){
        subquestion = smgr.save(subquestion);
        scenario.setSubquestionId(subquestion.getSubquestionid());
        scenario = mgr.save(scenario);
        scenario1.setSubquestionId(subquestion.getSubquestionid());
        scenario1 = mgr.save(scenario1);
        
        Integer[] scenarioIds = new Integer[]{scenario.getScenarionid(),scenario1.getScenarionid()};
        List<Scenario> list = mgr.getScenarioListBySubQuestionId(subquestion.getSubquestionid(), scenarioIds);
        assertTrue(list.size()>=2);
    }
}
