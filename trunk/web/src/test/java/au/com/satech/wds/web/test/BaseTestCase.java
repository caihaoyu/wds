/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.test;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 *
 * @author sam
 */

public class BaseTestCase {
    
    private static ChromeDriverService service;
    protected WebDriver driver;
    
    @BeforeClass
    public static void createAndStartService() {
        
    }
    
    @AfterClass
    public static void createAndStopService() {
        
    }
    
    
    @Before
    public void before() throws Exception {
        driver = new FirefoxDriver();
     }
     
    @After
    public void after() {
        driver.quit();
    } 
    
    public void testPost(WebElement webElement,final String with){
        System.out.println("Page title is: " + driver.getTitle());
        webElement.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return  d.getTitle().toLowerCase().endsWith(with);
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
    }
    
        //need get path
    public Document openXML(String xmlName) throws DocumentException{
        SAXReader reader = new SAXReader();
        String path = BaseTestCase.class.getClassLoader().getResource(xmlName).getPath();
        System.out.println(path);
        Document document = reader.read(path);
        return document;
    }
    
}
