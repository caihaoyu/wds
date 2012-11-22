/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.ScenarioccDao;
import au.com.satech.wds.model.Scenariocc;
import au.com.satech.wds.service.ScenarioccManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author cai
 */
@SuppressWarnings("serial")
@Service("scenarioccManager")
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
public class ScenarioccManagerImpl extends GenericManagerImpl<Scenariocc,Integer> implements ScenarioccManager{
    @Autowired
    ScenarioccDao scenarioccDao;
    
     @Autowired
    public ScenarioccManagerImpl(ScenarioccDao scenarioccDao){
        super(scenarioccDao);
        this.scenarioccDao = scenarioccDao;
    }
    
}
