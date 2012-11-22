/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.ColumnchoiceDao;
import au.com.satech.wds.model.Columnchoice;
import au.com.satech.wds.service.ColumnchoiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 此类是ColumnchoiceManger的实现类
 * @author sam
 */
@SuppressWarnings("serial")
@Scope("singleton")
@Service("columnchoiceManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ColumnchoiceManagerImpl extends GenericManagerImpl<Columnchoice, Integer> implements ColumnchoiceManager {
    ColumnchoiceDao columnChoiceDao;
    
    @Autowired
    public ColumnchoiceManagerImpl(ColumnchoiceDao columnChoiceDao){
        super(columnChoiceDao);
        this.columnChoiceDao = columnChoiceDao;        
    }

}
