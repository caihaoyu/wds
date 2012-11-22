/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.ResultDao;
import au.com.satech.wds.model.Result;
import au.com.satech.wds.service.ResultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *ResultManager的实现类
 * @author sam
 */
@SuppressWarnings("serial")
@Service("resultManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ResultManagerImpl extends GenericManagerImpl<Result, Integer> implements ResultManager {
    ResultDao resultDao;
    
    @Autowired
    public ResultManagerImpl(ResultDao resultDao){
        super(resultDao);
        this.resultDao = resultDao;
    }
}
