/*
 * Copyright 2011 sam.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.GenericDao;
import au.com.satech.wds.dao.support.SearchMode;
import au.com.satech.wds.dao.support.SearchTemplate;
import au.com.satech.wds.service.GenericManager;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *此类是GenericManager的实现类
 * @author sam
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());
    /**
     * GenericDao instance, set by constructor of child classes
     */
    protected GenericDao<T, PK> dao;
    
    public GenericManagerImpl() {
    }
    
    public GenericManagerImpl(GenericDao<T, PK> genericDao) {
        this.dao = genericDao;
    }
    
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return dao.getAll();
    }

    @Transactional(readOnly = true)
    public T get(PK id) {
        return dao.get(id);        
    }

    @Transactional(readOnly = true)
    public boolean exists(PK id) {
        return dao.exists(id);
    }

    @Transactional(readOnly = false)
    public T save(T object) {
        return dao.save(object);
    }

    @Transactional(readOnly = false)
    public void remove(PK id) {
        dao.remove(id);
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<T> find(T model, SearchTemplate searchTemplate) {
        return dao.find(model, searchTemplate);
    }
    
    @Transactional(readOnly = true)
    @Override
    public int findCount(T model, SearchTemplate searchTemplate) {
        return dao.findCount(model, searchTemplate);
    }

}
