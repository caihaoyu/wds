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
package au.com.satech.wds.dao;

import java.util.ArrayList;
import au.com.satech.wds.dao.hibernate.GenericDaoHibernate;
import au.com.satech.wds.model.Survey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
/**
 *
 * @author sam
 */
public class GenericDaoTest extends BaseDaoTestCase {
    Log log = LogFactory.getLog(GenericDaoTest.class);
    GenericDao<Survey, Long> genericDao;
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Before
    public void setUp() {
        genericDao = new GenericDaoHibernate<Survey, Long>(Survey.class, sessionFactory);
    }
    
    @Test
    public void getSurvey(){
        log.debug("Reading survey sid = 2 from database....");
        Survey survey = genericDao.get(2L);
        assertNotNull(survey);
        log.debug("Survey(sid=2): survey title: " + survey.getSurveytitle());
    }            
    
}
