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
import au.com.satech.wds.model.Question;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sam
 */
public class PageDaoTest extends BaseDaoTestCase{
    Log log = LogFactory.getLog(PageDaoTest.class);
    
    
    @Autowired
    PageDao pageDao;
    
    @Autowired
    QuestionDao questionDao;
    
    @Test
    public void testAddQuestionToPage(){
        
    }
    
    @Test
    public void testLoadPage(){
        Page page = (Page) pageDao.get(new Integer(2));
        log.debug("Page Loaded: " + page.toString());
    }
}
