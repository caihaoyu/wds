/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.EntryDao;
import au.com.satech.wds.model.Entry;
import au.com.satech.wds.service.EntryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author sam
 */
@SuppressWarnings("serial")
@Service("entryManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class EntryManagerImpl extends GenericManagerImpl<Entry, Integer> implements EntryManager {
    EntryDao entryDao;
    
    @Autowired
    public EntryManagerImpl(EntryDao entryDao){
        super(entryDao);
        this.entryDao = entryDao;
    }
}
