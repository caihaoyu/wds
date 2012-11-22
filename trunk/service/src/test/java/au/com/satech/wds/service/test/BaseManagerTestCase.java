package au.com.satech.wds.service.test;

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


import au.com.satech.wds.util.ConvertUtil;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import static org.junit.Assert.*;

/**
 * 指定加载配置文件
 * @author xiong
 */
@ContextConfiguration(locations = {
        "classpath:/applicationContext-dao.xml","classpath:/applicationContext-resources.xml", 
        "classpath:/applicationContext-service.xml", "classpath*:/**/applicationContext.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class BaseManagerTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    /**
     * A simple logger
     */
    protected final Log log = LogFactory.getLog(getClass());
    /**
     * The resourceBundle
     */
    protected ResourceBundle rb;
    
    /**
     * Default constructor will set the ResourceBundle if needed.
     */
    public BaseManagerTestCase() {
        // Since a ResourceBundle is not required for each class, just
        // do a simple check to see if one exists
        String className = this.getClass().getName();

        try {
            rb = ResourceBundle.getBundle(className);
        } catch (MissingResourceException mre) {
            // log.warn("No resource bundle found for: " + className);
        }
    }

    /**
     * Utility method to populate an object with values from a properties file
     *
     * @param obj the model object to populate
     * @return Object populated object
     * @throws Exception if BeanUtils fails to copy properly
     */
    protected Object populate(Object obj) throws Exception {
        // loop through all the beans methods and set its properties from
        // its .properties file
        Map map = ConvertUtil.convertBundleToMap(rb);

        BeanUtils.copyProperties(obj, map);

        return obj;
    }
}
