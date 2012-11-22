/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.test;

import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Scenario;
import au.com.satech.wds.service.ConditionManager;
import au.com.satech.wds.service.ScenarioManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

/**
 * 测试ConditionManagerImpl的实现方法
 * @author xiong
 */
public class ConditionManagerTest extends BaseManagerTestCase{
    
    private final Log log = LogFactory.getLog(getClass());
    
    @Autowired
    private ConditionManager mgr;
    
    @Autowired
    private ScenarioManager smgr;
    
    private Condition condition;
    private Scenario scenario1;
    private Scenario scenario2;
    private Scenario scenario3;
    
    private Set<Scenario> set;
    
    @Before
    public void set(){
        condition = new Condition();
        condition.setConditionType(1);
        scenario1 = new Scenario();
        scenario2 = new Scenario();
        scenario3 = new Scenario();
        set = new HashSet<Scenario>();
    }
    
    @Test
    public void testConditionAndScenario(){
        int oldConditionNum = mgr.getAll().size();
        int oldScenarioNum = smgr.getAll().size();
        scenario1 = smgr.save(scenario1);
        scenario2 = smgr.save(scenario2);
        scenario3 = smgr.save(scenario3);
        
        set.add(scenario1);
        set.add(scenario2);
        set.add(scenario3);
        condition = mgr.save(condition);
        condition.setScenarios(set);
        
        int newConditionNum = mgr.getAll().size();
        int newScenarioNum = smgr.getAll().size();
        assertEquals(oldConditionNum+1, newConditionNum);
        assertEquals(oldScenarioNum+3, newScenarioNum);
        
        assertEquals(condition.getScenarios().size(), 3);
        
        mgr.remove(condition.getConditionid());
        newConditionNum = mgr.getAll().size();
        newScenarioNum = smgr.getAll().size();
        assertEquals(oldConditionNum, newConditionNum);
        assertEquals(oldScenarioNum, newScenarioNum);
    }
    
    /**
     * 测试getScenarioList（）
     */
    public void testGetScenarioList(){
        scenario1 = smgr.save(scenario1);
        scenario2 = smgr.save(scenario2);
        scenario3 = smgr.save(scenario3);
        
        set.add(scenario1);
        set.add(scenario2);
        set.add(scenario3);
        condition.setScenarios(set);
        condition = mgr.save(condition);
        
        List<Scenario> list = mgr.getScenarioList(condition.getConditionid());
        
        assertTrue(list.size()>=3);
    }
}
