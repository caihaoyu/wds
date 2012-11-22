/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.test;

import au.com.satech.wds.model.Result;
import au.com.satech.wds.model.Survey;
import com.sun.jna.platform.win32.WinUser;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.seleniumemulation.GetValue;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author wu
 */
public class TestSurveyProject extends BaseTestCase{
    
    
    @Test
    public void testObjectParser(){
//        ObjectParser objectParser = new ObjectParser();
//        String path = TestSurveyProject.class.getClassLoader().getResource("").getPath().toString();
//          System.out.println(Thread.currentThread().getContextClassLoader().getResource("")); 
//        Survey survey = (Survey)objectParser.openObject(new File("C:\\Users\\wu\\Documents\\NetBeansProjects\\trunk\\web\\src\\main\\resources\\test.xml"));
//        System.out.print(survey.getSurveytitle()+"-------------");
//        
//        System.out.print(path);
        Survey survey = new Survey(); 
        try { 
                JAXBContext jaxbContext = JAXBContext.newInstance(Survey.class); 
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 
                survey = (Survey)jaxbUnmarshaller.unmarshal(new File("C:\\Users\\wu\\Documents\\NetBeansProjects\\trunk\\web\\src\\main\\resources\\test.xml"));
                System.out.println(survey);
        } catch (JAXBException e) { 
                e.printStackTrace(); 
        }
    } 
    @Test
    public void testSurveys() throws DocumentException{
        Element root = openXML("xpath.xml").getRootElement();
        Element surveyRoot = root.element("survey");
        String rows = surveyRoot.element("rows").getTextTrim().toString();
        String column = surveyRoot.element("columns").getTextTrim().toString();
        StringBuffer xpath =  null;
        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-survey.xhtml");
        for(int i=1;i<=Integer.parseInt(rows);i++){ 
            for(int j=1;j<=Integer.parseInt(column);j++){
                xpath = new StringBuffer(".//*[@id='form:surveyListTable_data']/tr[")
                    .append(i)
                    .append("]/td[")
                    .append(j)
                    .append("]/div");
                WebElement element = driver.findElement(By.xpath(xpath.toString()));
                assertNotNull(element.getText().trim());
                System.out.print("["+element.getText()+"]");
            }
            System.out.println();
        }
    }
    
    @Test
    public void testSurveyPageTitle(){
        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-survey.xhtml");
        WebElement titleElement1 = driver.findElement(By.className("admin-page-title-panel"));
        String elementText = titleElement1.getText().trim();
        System.out.println(elementText);
        assertTrue(!elementText.equals(""));
    }
       
    @Test
    public void testPostSurveys() {
        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-survey.xhtml");
        List<WebElement> elements = null; 
        elements = driver.findElements(By.xpath("//tr[@class='ui-widget-content ui-datatable-even']"));
        String elementText = elements.get(0).getText().trim();
        System.out.println(elementText);
        assertTrue(!elementText.equals(""));    
    }
    
    @Test
    public void testClickSurveyButton(){
        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-survey.xhtml");
        WebElement element = driver.findElement(By.id("form:addNewSurveyBtn"));
        testPost(element, "add new survey");
    }
    
    //about save,test careful 
//    @Test
//    public void testAddSurveyButton() throws DocumentException {
//        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-survey.xhtml");
//        WebElement element = null;
//        System.out.println();
//        element = driver.findElement(By.id("form:addNewSurveyBtn"));
//        System.out.println("Page title is: " + driver.getTitle());
//        element.click();
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            WebElement inputSurvey = null;
//            @Override
//            public Boolean apply(WebDriver d) {
//                inputSurvey = d.findElement(By.id("form:surveyTitleInputText"));
//                inputSurvey.sendKeys("apsdp");
//                inputSurvey = d.findElement(By.id("form:button"));
//                inputSurvey.click();
//                System.out.println("------------click save-------------");
//                return d.getTitle().toLowerCase().startsWith("wds");
//            }
//        });
//        
//        
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            WebElement inputSurvey = null;
//            @Override
//            public Boolean apply(WebDriver d) {
//                inputSurvey = d.findElement(By.xpath("//a[@id='form:confirmAddSurveyBtn']"));
//                inputSurvey.click();
//                System.out.println("------------click OK-------------");
//                return d.getTitle().toLowerCase().startsWith("wds");
//            }
//        });
//        
//        
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            WebElement inputSurvey = null;
//            @Override
//            public Boolean apply(WebDriver d) {
//                inputSurvey = d.findElement(By.xpath("//div[@class='ui-growl-message']//p"));
//                System.out.println("----------------it's right---------");
//                return inputSurvey.getText().toLowerCase().endsWith("added.");
//            }
//        });
//        
//        System.out.println("Page title is: " + driver.getTitle());
//    }
    
    
    @Test
    public void testRefresh(){
        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-survey.xhtml");
        System.out.println("Page title is: " + driver.getTitle());
        WebElement element = driver.findElement(By.id("form:refreshSurveyBtn"));
        element.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                WebElement element1 = d.findElement(By.xpath("//div[@class='ui-growl-message']//p"));
                String text =element1.getText();
                System.out.println(text);
//                Assert.assertEquals(text, "refreshed.");
//                Assert.assertSame(text, "refreshed.");
                assertTrue(text.endsWith("refreshed."));
                return true;
            }
        });
        
        System.out.println("Page title is: " + driver.getTitle());
    }
    
    //have problem;
//    @Test
//    public void testEdit(){
//        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-survey.xhtml");
//        System.out.println("Page title is: " + driver.getTitle());
//        WebElement element = driver.findElement(By.xpath("//a[@id='form:surveyListTable:0:editSurveyBtn']"));
//        element.click();
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver d) {
//                System.out.println("-------------------");
//                WebElement element1 = d.findElement(By.xpath("//input[@id='form:edit-SurveyTitleInput']"));
//                String value = element1.getAttribute("value");
//                System.out.println(element1.getAttribute("value"));
//                assertTrue(!value.trim().equals(""));
//                element1 = d.findElement(By.xpath("//a[@id='form:closeSurveyBtn']"));
//                element1.click();
//                System.out.println(element1);
//                return true;
//            }
//        });
//        element = driver.findElement(By.xpath("//a[@id='form:j_idt49']"));
//        System.out.println("Page title is: " + driver.getTitle());
//    }
    //test selenium method
//    @Test
//    public void testElement(){
//        driver.get("http://www.google.com");
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("cheese!");
//        searchBox.submit();
//        System.out.println("Page title is: " + driver.getTitle());
//        // Google's search is rendered dynamically with JavaScript.
//        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                WebElement element = d.findElement(By.id("ignore"));
//                System.out.println(element.getAttribute("style"));
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });
//        // Should see: "cheese! - Google Search"
//        System.out.println("Page title is: " + driver.getTitle());
//        
//    }
}
