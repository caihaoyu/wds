/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.test;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Result;
import au.com.satech.wds.model.Survey;

/**
 *
 * @author xiong
 */
public class TestUtil {    
    private Condition condition;
    private Result result;
    private BranchItemRule branchItemRule;
    private BranchItem branchItem;
    private PageBranch pageBranch;
    private Page page;
    private Survey survey;

    public Condition getCondition() {
        return condition;
    }

    public Result getResult() {
        return result;
    }

    public BranchItemRule getBranchItemRule() {
        return branchItemRule;
    }

    public BranchItem getBranchItem() {
        return branchItem;
    }

    public PageBranch getPageBranch() {
        return pageBranch;
    }

    public Page getPage() {
        return page;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setBranchItemRule(BranchItemRule branchItemRule) {
        this.branchItemRule = branchItemRule;
    }

    public void setBranchItem(BranchItem branchItem) {
        this.branchItem = branchItem;
    }

    public void setPageBranch(PageBranch pageBranch) {
        this.pageBranch = pageBranch;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "TestUtil{" + "condition=" + condition + ", result=" + result + ", branchItemRule=" + branchItemRule + ", branchItem=" + branchItem + ", pageBranch=" + pageBranch + ", page=" + page + ", survey=" + survey + '}';
    }
    
    
    public TestUtil() {
        
    }

    public TestUtil(Condition condition, Result result, BranchItemRule branchItemRule, BranchItem branchItem, PageBranch pageBranch, Page page, Survey survey) {
        this.condition = condition;
        this.result = result;
        this.branchItemRule = branchItemRule;
        this.branchItem = branchItem;
        this.pageBranch = pageBranch;
        this.page = page;
        this.survey = survey;
    }
    
    
  /*
 * 测试save方法
 */    
    public void testSaveFun(Object obj){
        if(obj instanceof Condition){
            
        }
       
        
        

    }
  /*
 * 测试get方法
 */
   
    public void testGetFun(){
        
    }
/*
 * 测试getAll方法
 */    
 
    public void testGetallFun(){
           
    }
/*
 * 测试remove方法
 */    

    public  void testRemoveFun(){
        
        
    }
/*
 * 测试isExits方法
 */    
  
    public void testIsExitsFun(){
    
    }
}
