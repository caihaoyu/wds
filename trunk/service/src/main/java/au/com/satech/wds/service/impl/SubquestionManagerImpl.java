/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.SubquestionDao;
import au.com.satech.wds.model.Subquestion;
import au.com.satech.wds.service.SubquestionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author sam
 */
@SuppressWarnings("serial")
@Scope("singleton")
@Service("subquestionManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class SubquestionManagerImpl extends GenericManagerImpl<Subquestion, Integer> implements SubquestionManager{
    SubquestionDao subQuestionDao;
    
    @Autowired
    public SubquestionManagerImpl(SubquestionDao subQuestionDao){
        super(subQuestionDao);
        this.subQuestionDao = subQuestionDao;
    }

}
