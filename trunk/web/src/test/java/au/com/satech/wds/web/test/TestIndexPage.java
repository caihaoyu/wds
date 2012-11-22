/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.test;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

/**
 *
 * @author wu
 */
public class TestIndexPage extends BaseTestCase{
    
    protected final Log log = LogFactory.getLog(getClass());
    
    @Test
    public void testIndexPageTitle(){
        driver.get("http://localhost:8080/wds-jsf/faces/admin/dash-board.xhtml");
//        WebElement titleElement = driver.findElement(By.xpath("//*[contains(.,'Welcome to WDS Administrator Panel')]"));
        WebElement titleElement1 = driver.findElement(By.className("admin-page-title-panel"));
        String elementText = titleElement1.getText().trim();
        assertTrue(!elementText.equals(""));
    }
    
    @Test
    public void testPanelTitle(){
        driver.get("http://localhost:8080/wds-jsf/faces/admin/dash-board.xhtml");
        List<WebElement> list = null;
        list =driver.findElements(By.className("ui-panel-title"));
        assertTrue(list.size()>0);
        for(WebElement we:list) {
            String text = we.getText().trim();
            assertTrue(!text.equals(""));
        }
    }
    
    @Test
    public void testIndexContent(){
        driver.get("http://localhost:8080/wds-jsf/faces/admin/dash-board.xhtml");
        List<WebElement> list = null;
        
        //Test content title
        list = driver.findElements(By.xpath("//div[@class='statistics-and-attributes-content']//span"));
        assertTrue(list.size()>0);
        for(WebElement we:list){
            String text = we.getText().trim();
            assertTrue(!text.equals(""));
        }
        
        //Test content value
        list = driver.findElements(By.xpath("//td[@class='dash-board-attribute-value']"));
        assertTrue(list.size()>0);
        for(WebElement we:list){
            String text = we.getText().trim();
            assertTrue(!text.equals(""));
        }
    }
    
    @Test
    public void testSurveyProjectPage(){
        driver.get("http://localhost:8080/wds-jsf/faces/admin/dash-board.xhtml");
        String linkText = "Survey Project";
        WebElement webElement = driver.findElement(By.linkText(linkText));
        testPost(webElement,"survey");
    }
    
    @Test
    public void testQuestionBankPage(){
        driver.get("http://localhost:8080/wds-jsf/faces/admin/dash-board.xhtml");
        String linkText = "Question Bank";
        WebElement webElement = driver.findElement(By.linkText(linkText));
        testPost(webElement,"question");
    }
    
    @Test
    public void testAddSurveyPage(){
        
    }
    
    @Test
    public void testPageAndOrderPage(){
        
    }
    
    @Test
    public void testBranchingPage(){
        
    }
    
    @Test
    public void testAddQuestionPage(){
        
    }
}
