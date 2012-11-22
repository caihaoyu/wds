/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.ResponseDao;
import au.com.satech.wds.model.QuestionResponse;
import au.com.satech.wds.service.ResponseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author sam
 */
@SuppressWarnings("serial")
@Service("responseManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ResponseManagerImpl extends GenericManagerImpl<QuestionResponse, Integer> implements ResponseManager {
    ResponseDao responseDao;
    
    @Autowired
    public ResponseManagerImpl(ResponseDao responseDao){
        super(responseDao);
        this.responseDao = responseDao;
    }
}
