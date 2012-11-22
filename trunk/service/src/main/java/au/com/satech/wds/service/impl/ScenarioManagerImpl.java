/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.ScenarioDao;
import au.com.satech.wds.model.Scenario;
import au.com.satech.wds.service.ScenarioManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cai
 */
@SuppressWarnings("serial")
@Service("scenarioManager")
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class ScenarioManagerImpl extends GenericManagerImpl<Scenario,Integer> implements ScenarioManager {
    @Autowired
    ScenarioDao scenarioDao;
    
     @Autowired
    public ScenarioManagerImpl(ScenarioDao scenarioDao){
        super(scenarioDao);
        this.scenarioDao = scenarioDao;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Scenario> getScenarioListBySubQuestionId(Integer subQuestionId,Integer[] scenarioIds) {
       return scenarioDao.getScenarioListBySubQuestionId(subQuestionId,scenarioIds);
    }
   
}
