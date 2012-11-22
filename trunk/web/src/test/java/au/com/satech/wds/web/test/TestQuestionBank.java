/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.test;

import java.util.List;
import org.apache.bcel.generic.DUP;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author wu
 */
public class TestQuestionBank extends BaseTestCase{
    
    
    //test survey data list
    @Test
    public void testSurveys() throws DocumentException{
        Element root = openXML("xpath.xml").getRootElement();
        Element questionRoot = root.element("questionbank");
        String rows = questionRoot.element("rows").getTextTrim().toString();
        String column = questionRoot.element("columns").getTextTrim().toString();
        StringBuffer xpath =  null;
        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-question.xhtml");
        for(int i=1;i<=Integer.parseInt(rows);i++){ 
            for(int j=1;j<=Integer.parseInt(column);j++){
                //.//*[@id='form:questionListTable_data']/tr[1]/td[2]/div
                xpath = new StringBuffer(".//*[@id='form:questionListTable_data']/tr[")
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
    public void testPostAdd() throws DocumentException{
        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-question.xhtml");
        WebElement element = null;
        //.//*[@id='form:batchDeleteBtn']
        element = driver.findElement(By.xpath(".//*[@id='form:addQBtn']"));
        System.out.println("["+element.getText().trim()+"]");
        // click add
        element.click();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                assertNotNull(d.findElement(By.xpath(".//*[@id='form:addNewQBtn']")));
                return true;
            }
        });
        
    }
    
    @Test
    public void testAddFreeTextQuestion() throws DocumentException, InterruptedException {
        driver.get("http://localhost:8080/wds-jsf/faces/admin/add-question.xhtml");
        Element root =openXML("datatest.xml").getRootElement();
        Element questionRoot = root.element("question");
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            WebElement titleElement = null;
            @Override
            public Boolean apply(WebDriver d) {
                titleElement = d.findElement(By.xpath(".//*[@id='form:newQuestionTabView:freetextQTitleInplace_display']"));
                titleElement.click();
                return true;
            }
        });
        Thread.sleep(500l);
        WebElement element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:freetextQTitleInputText']"));
        Element freeText = questionRoot.element("freetext");
        element.sendKeys(freeText.elementText("title"));
        element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:freetextQTitleInplace_editor']/button[1]"));
        element.click();
        Thread.sleep(500l);
        element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:freetextAnswerInputText']"));
        element.sendKeys(freeText.elementText("mask"));
        
        //description
        StringBuffer rido = new StringBuffer(".//*[@id='form:newQuestionTabView:freetextAllowDescriptionSelect']/tbody/tr/td[")
                .append(freeText.elementText("description"))
                .append("]/div/div[2]");
        element = driver.findElement(By.xpath(rido.toString()));
        element.click();
        
        //answertype
        StringBuffer rido2 = new StringBuffer(".//*[@id='form:newQuestionTabView:freetextAnswerTypeSelect']/tbody/tr/td[")
                .append(freeText.elementText("answertype"))
                .append("]/div/div[2]");
        element = driver.findElement(By.xpath(rido2.toString()));
        element.click();
        
        //mask
        Thread.sleep(500l);
        element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:freetextInputMaskCheckbox']/div[2]"));
        element.click();
        element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:freetextAnswerMaskSelect_label']"));
        System.out.print(element);
        element.click();
        StringBuffer select = new StringBuffer(".//*[@id='form:newQuestionTabView:freetextAnswerMaskSelect_panel']/ul/li[")
               .append(freeText.elementText("maskType"))
               .append("]");
        element = driver.findElement(By.xpath(select.toString()));
        Thread.sleep(500l);
        element.click();
        element = driver.findElement(By.xpath(".//*[@id='form:addNewQBtn']"));
        element.click(); 
        Thread.sleep(500l);
        element = driver.findElement(By.xpath(".//*[@id='form:confirmAddQ']"));
        element.click();
        
        
        
        //assert
    }
    
//    @Test
//    public void testAddRatingQuestion() throws DocumentException, InterruptedException {
//        driver.get("http://localhost:8080/wds-jsf/faces/admin/add-question.xhtml");
//        Element root =openXML("datatest.xml").getRootElement();
//        Element questionRoot = root.element("question");
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            WebElement titleElement = null;
//            @Override
//            public Boolean apply(WebDriver d) {
//                //.//*[@id='form:newQuestionTabView:ratingTitleInplace_display']
//                System.out.println("..................");
//                titleElement = d.findElement(By.xpath(".//*[@id='form:newQuestionTabView:ratingTitleInplace_display']"));
//                System.out.println(titleElement);
//                titleElement.click();
//                return true;
//            }
//        });
//        Thread.sleep(500l);
//        WebElement element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:ratingTitleInputText']"));
//        Element rating = questionRoot.element("rating");
//        element.sendKeys(rating.elementText("title"));
//        element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:ratingTitleInplace_editor']/button[1]"));
//        element.click();
//        Thread.sleep(500l);
//        element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:ratingStars']/div[6]/a"));
//        element.click();
//        
//        //description
//        //.//*[@id='form:newQuestionTabView:ratingAllowDescriptionSelect']/tbody/tr/td[1]/div/div[2]
//        StringBuffer rido = new StringBuffer("@id='form:newQuestionTabView:ratingAllowDescriptionSelect']/tbody/tr/td[")
//                .append(rating.elementText("description"))
//                .append("]/div/div[2]");
//        element = driver.findElement(By.xpath(rido.toString()));
//        element.click();
//        
//        //mask
//        Thread.sleep(500l);
//        //.//*[@id='form:newQuestionTabView:ratingSelectMenu_label']
//        element = driver.findElement(By.xpath(".//*[@id='form:newQuestionTabView:ratingSelectMenu_label']"));
//        element.click();
//        //.//*[@id='form:newQuestionTabView:ratingSelectMenu_panel']/ul/li[2]
//        StringBuffer select = new StringBuffer(".//*[@id='form:newQuestionTabView:ratingSelectMenu_panel']/ul/li[")
//               .append(rating.elementText("rating"))
//               .append("]");
//        element = driver.findElement(By.xpath(select.toString()));
//        Thread.sleep(500l);
//        element.click();
//        element = driver.findElement(By.xpath(".//*[@id='form:addNewQBtn']"));
//        element.click(); 
//        Thread.sleep(500l);
//        element = driver.findElement(By.xpath(".//*[@id='form:confirmAddQ']"));
//        element.click();
//        
//        //assert
//    }
    
    @Test
    public void testDeleteQuestion() throws DocumentException{
        Element root = openXML("xpath.xml").getRootElement();
        Element questionRoot = root.element("questionbank");
        String deleteRows = questionRoot.element("delete").getTextTrim().toString();
        String[] num = deleteRows.split(",");
        StringBuffer xpath =  null;
        driver.get("http://localhost:8080/wds-jsf/faces/admin/edit-question.xhtml");
        for(int i=0;i<num.length;i++){ 
            //.//*[@id='form:questionListTable_data']/tr[2]/td[1]/div/div/div
            xpath = new StringBuffer(".//*[@id='form:questionListTable_data']/tr[")
                .append(num[i])
                .append("]/td[1]/div/div/div");
            System.out.println(xpath);
            WebElement element = driver.findElement(By.xpath(xpath.toString()));
            element.click();
        }
        WebElement deleteButton = driver.findElement(By.xpath(".//*[@id='form:batchDeleteBtn']"));
        deleteButton.click();
        
        //assert
    }
    
}
