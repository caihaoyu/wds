/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.AnswerDao;
import au.com.satech.wds.model.Answer;
import au.com.satech.wds.service.AnswerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *  AnswerManager的实现类
 * @author sam
 * 
 */
@SuppressWarnings("serial")
@Service("answerManager")
@Scope("singleton")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class AnswerManagerImpl extends GenericManagerImpl<Answer, Integer> implements AnswerManager {
    AnswerDao answerDao;
    
    @Autowired
    public AnswerManagerImpl(AnswerDao answerDao){
        super(answerDao);
        this.answerDao = answerDao;
    }

}
