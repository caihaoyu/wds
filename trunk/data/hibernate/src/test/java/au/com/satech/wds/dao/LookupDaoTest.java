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


import au.com.satech.wds.model.Answer;
import java.util.ArrayList;
import au.com.satech.wds.model.Survey;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;
/**
 *
 * @author sam
 */
public class LookupDaoTest extends BaseDaoTestCase  {
    @Autowired
    LookupDao lookupDao;
    
    @Test
    public void testGetSurveys() {
        ArrayList<Survey> surveys = new ArrayList<Survey>(lookupDao.getSurveys());
        if(!surveys.isEmpty()){
            log.debug("Displaying content of surveys:");
            for(Survey survey:surveys){
                log.debug("Survey " + survey.getSid() + ": ");
                log.debug(survey.toString());
            }
        } else {
            log.debug("surveys is empty");
        }
        assertTrue(surveys.size() > 0);
    }
    
}
