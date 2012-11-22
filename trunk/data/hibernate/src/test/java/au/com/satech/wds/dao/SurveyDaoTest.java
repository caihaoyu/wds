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

import au.com.satech.wds.model.Page;
import java.util.ArrayList;
import org.junit.Test;
import au.com.satech.wds.model.Survey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
/**
 *
 * @author sam
 */
public class SurveyDaoTest extends BaseDaoTestCase{
    Log log = LogFactory.getLog(GenericDaoTest.class);
    
    @Autowired
    SurveyDao dao;
    
    
    @Test
    public void testLoadSurvey(){
        Survey survey = new Survey();
        survey.setSid(2);
        assertNotNull(dao.get(survey.getSid()));
        survey.setSid(3);
        assertNotNull(dao.get(survey.getSid()));
        survey.setSid(4);
        assertNotNull(dao.get(survey.getSid()));
    }
    
    @Test 
    public void testLoadPageFromSurvey(){
        Survey survey = (Survey)dao.get(2);
        ArrayList<Page> pages = new ArrayList<Page>(survey.getPages());
        log.debug("Pages of " + survey.getSurveytitle());
        for(Page page:pages){
            log.debug(page.toString());
        }
    }
    
    @Test
    public void testUpdateSurvey(){
        Survey survey = dao.get(2);
        log.debug("survey title: " + survey.getSurveytitle());
        survey.setSurveytitle("this is a new survey title");
        dao.save(survey);
        flush();
        Survey survey2 = dao.get(2);
        log.debug("survey title after update: "+ survey2.getSurveytitle());
    }
    
    @Test
    public void testAddSurvey(){
        log.debug("Before adding survey...");
        log.debug("Number of surveys in database: " + dao.getAll().size());
        int size = dao.getAll().size();
        Survey survey = new Survey();
        survey.setSurveytitle("This is a new Survey, anything else is null");        
        dao.save(survey);
        log.debug("After adding survey...");
        log.debug("Number of surveys in database: " + dao.getAll().size());
        assertEquals(size+1, dao.getAll().size());
    }
    
    @Test
    public void testDeleteSurvey(){
        log.debug("Before deleting survey...");
        log.debug("Number of surveys in database: " + dao.getAll().size());
        int size = dao.getAll().size();
        dao.remove(2);
        dao.remove(4);
        flush();
        log.debug("After deleting survey...");
        log.debug("Number of surveys in database: " + dao.getAll().size());
        assertEquals(size-2, dao.getAll().size());
    }
}
