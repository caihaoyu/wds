/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.AnswerResponseDao;
import au.com.satech.wds.dao.BranchItemDao;
import au.com.satech.wds.dao.ColumnChoiceResponseDao;
import au.com.satech.wds.dao.EntryDao;
import au.com.satech.wds.dao.PageBranchDao;
import au.com.satech.wds.dao.PageDao;
import au.com.satech.wds.dao.PageResponseDao;
import au.com.satech.wds.dao.QuestionDao;
import au.com.satech.wds.dao.QuestionResponseDao;
import au.com.satech.wds.dao.SubQuestionResponseDao;
import au.com.satech.wds.dao.SurveyDao;
import au.com.satech.wds.dao.SurveyResponseDao;
import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.AnswerResponse;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.ColumnChoiceResponse;
import au.com.satech.wds.model.Columnchoice;
import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Entry;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.PageResponse;
import au.com.satech.wds.model.Question;
import au.com.satech.wds.model.QuestionResponse;
import au.com.satech.wds.model.Result;
import au.com.satech.wds.model.Scenario;
import au.com.satech.wds.model.Scenariocc;
import au.com.satech.wds.model.SubQuestionResponse;
import au.com.satech.wds.model.Subquestion;
import au.com.satech.wds.model.Survey;
import au.com.satech.wds.model.SurveyResponse;
import au.com.satech.wds.model.comparators.BranchItemComparator;
import au.com.satech.wds.model.comparators.ColumnChoiceComparator;
import au.com.satech.wds.model.comparators.MultipleAnswerComparator;
import au.com.satech.wds.model.comparators.PageComparator;
import au.com.satech.wds.model.comparators.SubQuestionComparator;
import au.com.satech.wds.service.SurveyManager;
import au.com.satech.wds.model.jsf.SurveyJSFModel;
import au.com.satech.wds.model.jsf.ViolationRuleJSFModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
@Service("surveyManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class SurveyManagerImpl extends GenericManagerImpl<Survey, Integer> implements SurveyManager, Serializable {
    @Autowired
    SurveyDao surveyDao;
    //PageDao pageDao;
    @Autowired
    PageBranchDao pageBranchDao;
    @Autowired
    BranchItemDao branchItemDao;
    
    @Autowired
    PageDao pDao;
    
    @Autowired
    QuestionDao questionDao;
    
    @Autowired
    SurveyResponseDao surveyResponseDao;
    
    @Autowired
    PageResponseDao pageResponseDao;
    
    @Autowired
    QuestionResponseDao questionResponseDao;
    
    @Autowired
    EntryDao entryDao;
    
    @Autowired
    AnswerResponseDao answerResponseDao;
    
    @Autowired
    SubQuestionResponseDao subQuestionResponseDao;
    
    @Autowired
    ColumnChoiceResponseDao columnChoiceResponseDao;
    
    @Autowired
    public SurveyManagerImpl(SurveyDao surveyDao){
        super(surveyDao);
        this.surveyDao = surveyDao;
    }
    /**
     * 根据title查询Survey
     * @param title
     * @return Survey
     */
    @Transactional(readOnly = true)
    @Override
    public Survey loadSurveyBySurveyTitle(String title) {
        return surveyDao.loadSurveyBySurveyTitle(title);
    }
 /**
  * 添加page到指定Survey里面
  * @param sid surveyId
  * @param page 需要添加的page
  * @return Survey 新的Survey
  */
    @Transactional(readOnly = false)
    @Override
    public Survey addPagetoSurvey(Integer sid, Page page){
        Page p = pDao.save(page);
        Survey survey = surveyDao.get(sid);
        survey.getPages().add(p);
        return surveyDao.save(survey);
    }
  /**
   * 删除指定survey里面指定的page并返回
   * @param sid 指定survey的id
   * @param pageid 指定page的id
   * @return Survey 删除指定page后的survey
   */
    @Transactional(readOnly = false)
    @Override
    public Survey removePageFromSurvey(Integer sid, Integer pageid){
        Survey survey = surveyDao.get(sid);
        Page page = pDao.get(pageid);
        survey.getPages().remove(page);
        return surveyDao.save(survey);
    }
    /**
     * 对survey下的pageList从新排序并返回
     * @param sid
     * @return pageList 
     */
    @Transactional(readOnly=true)
    @Override
    public List<Page> getPagesList(Integer sid) {
        Survey s=dao.get(sid);
        List<Page> list=new ArrayList<Page>();
        list.addAll(s.getPages());
        Collections.sort(list, new PageComparator());
        return list;
    }

    /**
     * 保存page到指定survey里面并返回新的PageId
     * @param sid surveyId
     * @param page 需要保存的page
     * @return 新的pageId
     */
    @Transactional
    @Override
    public Integer saveSurveyAndPage(Integer sid, Page page) {
        Page p = pDao.save(page);
        Survey survey = surveyDao.get(sid);
        survey.getPages().add(p);
        surveyDao.save(survey);
        return p.getPageid();
    }
    /**
     * 从新组装指定Survey下的Page关联到Items并返回
     * @param sid
     * @return pageList
     */
    @Transactional(readOnly=true)
    @Override
    public List<Page> getPageListTillItem(Integer sid) {
        //根据surveyId返回排序后的List<Page>。
        List<Page> list = getPagesList(sid);
        List<Page> pageList = new ArrayList<Page>();
        //迭代排序以后的List<Page> pageList
        for (Page page : list) {
            List<PageBranch> branchList = new ArrayList<PageBranch>();
            List<PageBranch> branchs = new ArrayList<PageBranch>();
            //遍历list把page的PageBranches集合添加到新的List<PageBranch> branchs里面
            branchs.addAll(page.getPagebranches());
            //迭代List<PageBranch> branchs
            for (PageBranch branch : branchs) {
                //把IsHaveItem属性为true集合的PagebranchItems添加到一个新的branchItems里面
                //并且排序之后注入到Pagebranch里再把其添加到branchList里面，在注入到page中返回page.
                if(branch.isHaveItem()){
                List<BranchItem> items = new ArrayList<BranchItem>();
                items.addAll(branch.getItems());
                Collections.sort(items,new BranchItemComparator());
                branch.setItemList(items);
                }
                branchList.add(branch);
            }

            page.setPageBranchList(branchList);
            pageList.add(page);
        }
        return pageList;
    }
    /**
     * 从新组装survey下的Page关联到ItemRule并返回pageList
     * @param sid
     * @return pagesList
     */
    @Transactional(readOnly=true)
    @Override
    public List<Page> getPageListTillRule(Integer sid) {
        List<Page> list = getPagesList(sid);
        List<Page> pageList = new ArrayList<Page>();

        for (Page page : list) {
            List<PageBranch> branchList = new ArrayList<PageBranch>();
            List<PageBranch> branchs = new ArrayList<PageBranch>();
            branchs.addAll(page.getPagebranches());
            for (PageBranch branch : branchs) {
                if(branch.isHaveItem()){
                List<BranchItem> items = new ArrayList<BranchItem>();
                items.addAll(branch.getItems());
                for(int i=0;i<items.size();i++){
                    BranchItem item=items.get(i);
                    int size= item.getRules().size();
                    if(size>0){
                        item.setHasRules(true);
                        item.setRulesSize(size);
                        items.set(i, item);
                    }
                }
                Collections.sort(items,new BranchItemComparator());
                branch.setItemList(items);
                }
                branchList.add(branch);
            }

            page.setPageBranchList(branchList);
            pageList.add(page);
        }
        return pageList;
    }
   /**
     * 重新组装survey其下层所有Object斌返回新的survey
     * @param sid
     * @return survey 新的survey
     */
    @Transactional(readOnly=true)
    @Override
    public Survey generateSurveyTree(Integer sid) {
        Survey survey = surveyDao.get(sid);
        //TODO 获取survey 并封装survey 及其下层所有Object
        List<Page> list = getPagesList(sid);
        List<Page> pageList = new ArrayList<Page>();

        for (Page page : list) {
            List<PageBranch> branchList = new ArrayList<PageBranch>();
            List<PageBranch> branchs = new ArrayList<PageBranch>();
            branchs.addAll(page.getPagebranches());
            for (PageBranch branch : branchs) {
                if(branch.isHaveItem()){
                List<BranchItem> items = new ArrayList<BranchItem>();
                items.addAll(branch.getItems());
                Collections.sort(items,new BranchItemComparator());
                for(BranchItem item : items)
                {
                    // 先new一个question放到item中，再把dao获取到的值copy到item的question中，
                    // 避免出现相同的question时，被当做同一个对象。
                    //item.setQuestion(questionDao.get(item.getQuestionid()));
                    
                    item.setQuestion(new Question());
                    Question q = questionDao.get(item.getQuestionid());
                    // new一个question出来就能解决被当做同一个对象的问题，有没有id都不会受影响
                    //item.getQuestion().setQuestionid(item.getBranchitemid());
                    item.getQuestion().setQuestiontitle(q.getQuestiontitle());
                    item.getQuestion().setQuestiontype(q.getQuestiontype());
                    item.getQuestion().setAllowdescription(q.getAllowdescription());
                    item.getQuestion().setAllowcustomized(q.getAllowcustomized());
                    item.getQuestion().setAllowmultipile(q.getAllowmultipile());
                    item.getQuestion().setWysiwyg(q.getWysiwyg());
                    item.getQuestion().setAnswertype(q.getAnswertype());
                    item.getQuestion().setAnswermask(q.getAnswermask());
                    item.getQuestion().setRating(q.getRating());
                    item.getQuestion().setColumntype(q.getColumntype());
                    item.getQuestion().setAnswers(q.getAnswers());
                    item.getQuestion().setSubquestions(q.getSubquestions());
                    item.getQuestion().setColumnchoices(q.getColumnchoices());
                    item.getQuestion().setDescription(q.getDescription());
                    item.getQuestion().setCreateDate(q.getCreateDate());
                    item.getQuestion().setModifiedDate(q.getModifiedDate());
                    
                    // 把item中的question做成一个list，同样会被当做同一个对象。
                    // 也需要先new一个question放到list中，再把dao获取到的值copy到list的question中
                    //item.getQuestions().add(questionDao.get(item.getQuestionid()));
                    
//                    item.getQuestions().add(new Question());
//                    Question q = questionDao.get(item.getQuestionid());
//                    item.getQuestions().get(0).setQuestionid(item.getBranchitemid());
//                    item.getQuestions().get(0).setQuestiontitle(q.getQuestiontitle());
//                    item.getQuestions().get(0).setQuestiontype(q.getQuestiontype());
//                    item.getQuestions().get(0).setAllowdescription(q.getAllowdescription());
//                    item.getQuestions().get(0).setAllowcustomized(q.getAllowcustomized());
//                    item.getQuestions().get(0).setAllowmultipile(q.getAllowmultipile());
//                    item.getQuestions().get(0).setWysiwyg(q.getWysiwyg());
//                    item.getQuestions().get(0).setAnswertype(q.getAnswertype());
//                    item.getQuestions().get(0).setAnswermask(q.getAnswermask());
//                    item.getQuestions().get(0).setRating(q.getRating());
//                    item.getQuestions().get(0).setColumntype(q.getColumntype());
//                    item.getQuestions().get(0).setAnswers(q.getAnswers());
//                    item.getQuestions().get(0).setSubquestions(q.getSubquestions());
//                    item.getQuestions().get(0).setColumnchoices(q.getColumnchoices());
                    
                    if(item.getQuestion().getQuestiontype() == 3)
                    {
                        item.getQuestion().getAnswersList().addAll(item.getQuestion().getAnswers());
                        Collections.sort(item.getQuestion().getAnswersList(),new MultipleAnswerComparator());
                    }
                    else if(item.getQuestion().getQuestiontype() == 4)
                    {
                        // subquestion也存在和question同样的问题。
                        // 先new一个list，再循环new出subquestion，add到list中
                        List<Subquestion> sqs = new ArrayList<Subquestion>();
                        for(Subquestion subquestion : q.getSubquestions())
                        {
                            Subquestion tempSubquestion =  new Subquestion();
                            tempSubquestion.setSubquestionid(subquestion.getSubquestionid());
                            tempSubquestion.setSubquestiontitle(subquestion.getSubquestiontitle());
                            tempSubquestion.setSubquestionorder(subquestion.getSubquestionorder());
                            sqs.add(tempSubquestion);
                            // 不new出subquestion，直接add进去，失败。
//                            item.getQuestion().getSubquestionsList().add(subquestion);
                        }
                        // 直接把subquestions取出addAll进到new出来的list中，失败。
                        //sqs.addAll(q.getSubquestions());
                        item.getQuestion().setSubquestionsList(sqs);
//                        item.getQuestion().getSubquestionsList().addAll(item.getQuestion().getSubquestions());
                        Collections.sort(item.getQuestion().getSubquestionsList(),new SubQuestionComparator());
                        if(item.getQuestion().getColumntype() == 3)
                        {
                            item.getQuestion().getColumnchoicesList().addAll(item.getQuestion().getColumnchoices());
                            Collections.sort(item.getQuestion().getColumnchoicesList(),new ColumnChoiceComparator());
                        }
                    }
                    
                    // generate rules
                    List<BranchItemRule> branchItemRulelist = new ArrayList<BranchItemRule>();
                    branchItemRulelist.addAll(item.getRules());
                    for(BranchItemRule rule : branchItemRulelist)
                    {
                        Condition condition= rule.getCondition();
                        List<Scenario> scenarioList=new ArrayList<Scenario>();
                        if(condition.getScenarios().size()>0){
                        scenarioList.addAll(condition.getScenarios());
                        for(Scenario s:scenarioList){
                                if(s.getScenarioccs().size()>0){
                                    List<Scenariocc> scenarioccList=new ArrayList<Scenariocc>();
                                    scenarioccList.addAll(s.getScenarioccs());
                                    s.setScenarioccList(scenarioccList);
                                }
                            }
                        }
                        condition.setScenarioList(scenarioList);
                        
                        rule.getResultsList().addAll(rule.getResults());
                    }
                    item.setRules(branchItemRulelist);
                }
                branch.setItemList(items);
                }
                branchList.add(branch);
            }

            page.setPageBranchList(branchList);
            pageList.add(page);
        }
        survey.setPageList(pageList);
        return survey;
    }

    @Transactional(readOnly=false)
    @Override
    public void lock(Integer surveyId, String user) {
        Survey survey = surveyDao.get(surveyId);
        survey.setOccupy(true);
        survey.setLockUser(user);
        surveyDao.save(survey);
    }
    @Transactional(readOnly=false)
    @Override
    public void unlock(Integer surveyId) {
         Survey survey = surveyDao.get(surveyId);
        survey.setOccupy(false);
        survey.setLockUser(null);
        surveyDao.save(survey);
    }
    
    /**
     * calculating accomplishment ratio
     */
    @Override
    public void calculateAccomplishmentRatio(SurveyJSFModel surveyJSFModel)
    {
        int totalQuestions = 0;
        int answeredQuestions = 0;
        int currentPageIndex = surveyJSFModel.getCurrentPageIndex();
        
        if(surveyJSFModel.getSurvey().getPageList() == null || surveyJSFModel.getSurvey().getPageList().size() <= 0)
        {
            return ;
        }
        
        while(surveyJSFModel.getSurvey().getPageList().get(currentPageIndex) == null)
        {
            currentPageIndex = currentPageIndex - 1;
        }
        
        for(int pageIndex = 0; pageIndex < surveyJSFModel.getSurvey().getPageList().size(); pageIndex ++)
        {
            Page page = (Page)surveyJSFModel.getSurvey().getPageList().get(pageIndex);
            if(page != null)
            {
                for(PageBranch branch : page.getPageBranchList())
                {
                    if(branch.getMain())
                    {
                        for(int itemIndex = 0; itemIndex < branch.getItemList().size(); itemIndex ++)
                        {
                            BranchItem item = (BranchItem)branch.getItemList().get(itemIndex);
                            if(!item.isHidden())
                            {
                                if(item.getQuestion().getAnswered() != 0)
                                {
                                    answeredQuestions ++;
                                }
                                totalQuestions ++;
                            }
                        }
                    }
                }
            }
        }
        surveyJSFModel.setRatio(totalQuestions == 0 ? 100 : answeredQuestions * 100 / totalQuestions);
    }
    
    /**
     * set item index for display.
     */
    @Override
    public void setItemIndex(List<BranchItem> itemsList)
    {
        int index = 1;
        for(BranchItem item : itemsList)
        {
            if(!item.isHidden())
            {
                item.setIndex(index);
                index ++;
            }
        }
    }
    
    /**
     * check if all mandatory questions has been answered.
     */
    @Override
    public boolean isAllMandatoryQAnswered(Page currPage)
    {
        for(PageBranch branch : currPage.getPageBranchList())
        {
            if(branch.getMain())
            {
                for(BranchItem item : branch.getItemList())
                {
                    if(!item.isHidden() && item.isMandatory())
                    {
                        if(isAnswerValueEmpty(item))
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * check if all optional questions has been answered.
     */
    @Override
    public boolean isAllOptionalQAnswered(Page currPage)
    {
        for(PageBranch branch : currPage.getPageBranchList())
        {
            if(branch.getMain())
            {
                for(BranchItem item : branch.getItemList())
                {
                    if(!item.isHidden() && !item.isMandatory() && item.getQuestion().getAnswered() == 0)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * check if the answer is empty
     */
    @Override
    public boolean isAnswerValueEmpty(BranchItem selectedItem)
    {
        // free text
        if(selectedItem.getQuestion().getQuestiontype() == 1)
        {
            if(selectedItem.getEntry().getAnswercontent() == null || selectedItem.getEntry().getAnswercontent().equals(""))
            {
                return true;
            }
        }
        // Rating
        else if(selectedItem.getQuestion().getQuestiontype() == 2)
        {
            if(selectedItem.getEntry().getRating() == null || selectedItem.getEntry().getRating() <= 0)
            {
                return true;
            }
        }
        // choice
        else if(selectedItem.getQuestion().getQuestiontype() == 3)
        {
            // single
            if(!selectedItem.getQuestion().getAllowmultipile())
            {
                if(selectedItem.getEntry().getAr_id() == null)
                {
                    if(selectedItem.getQuestion().getAllowcustomized())
                    {
                        if(selectedItem.getEntry().getAnswercontent() == null || selectedItem.getEntry().getAnswercontent().equals(""))
                        {
                            return true;
                        }
                    }
                    else
                    {
                        return true;
                    }
                }
            }
            // multiple
            else
            {
                if(selectedItem.getResponseAnswerIds() == null || selectedItem.getResponseAnswerIds().size() <= 0)
                {
                    if(selectedItem.getQuestion().getAllowcustomized())
                    {
                        if(selectedItem.getEntry().getAnswercontent() == null || selectedItem.getEntry().getAnswercontent().equals(""))
                        {
                            return true;
                        }
                    }
                    else
                    {
                        return true;
                    }
                }
            }
        }
        // matrix
        else if(selectedItem.getQuestion().getQuestiontype() == 4)
        {
            // free text
            if(selectedItem.getQuestion().getColumntype() == 1)
            {
                for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
                {
                    if(subquestion.getEntry().getAnswercontent() != null && !subquestion.getEntry().getAnswercontent().equals(""))
                    {
                        return false;
                    }
                }
            }
            // Rating
            else if(selectedItem.getQuestion().getColumntype() == 2)
            {
                for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
                {
                    if(subquestion.getEntry().getRating() != null && !subquestion.getEntry().getRating().equals(""))
                    {
                        return false;
                    }
                }
            }
            // choice
            else if(selectedItem.getQuestion().getColumntype() == 3)
            {
                if(!selectedItem.getQuestion().getAllowmultipile())
                {
                    for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
                    {
                        if(subquestion.getEntry().getCcr_id() != null)
                        {
                            return false;
                        }
                        else
                        {
                            if(selectedItem.getQuestion().getAllowcustomized())
                            {
                                if(subquestion.getEntry().getAnswercontent() != null && !subquestion.getEntry().getAnswercontent().equals(""))
                                {
                                    return false;
                                }
                            }
                        }
                    }
                }
                else
                {
                    for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
                    {
                        if(subquestion.getResponseColumnchoiceIds() != null && subquestion.getResponseColumnchoiceIds().size() > 0)
                        {
                            return false;
                        }
                        else
                        {
                            if(selectedItem.getQuestion().getAllowcustomized())
                            {
                                if(subquestion.getEntry().getAnswercontent() != null && !subquestion.getEntry().getAnswercontent().equals(""))
                                {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    /**
     * skip has not answered optional questions
     */
    @Override
    public void skipRestOptionalQuestions(Page currPage)
    {
        for(PageBranch branch : currPage.getPageBranchList())
        {
            if(branch.getMain())
            {
                for(BranchItem item : branch.getItemList())
                {
                    if(!item.isHidden() && !item.isMandatory() && item.getQuestion().getAnswered() == 0)
                    {
                        item.getQuestion().setAnswering(false);
                        item.getQuestion().setAnswered(-1);
                    }
                }
            }
        }
    }
    
    /**
     * clean answers of one question.
     */
    @Override
    public void cleanAnswer(BranchItem selectedItem)
    {
        selectedItem.setEntry(new Entry());
        selectedItem.setResponseAnswerIds(new ArrayList());
        for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
        {
            subquestion.setEntry(new Entry());
            subquestion.setResponseColumnchoiceIds(new ArrayList());
        }
    }
    
    /**
     * Change survey with rules.
     * @return 
     */
    @Override
    public void changeSurveywithRules(boolean skip, BranchItem selectedItem, SurveyJSFModel surveyJSFModel, Integer selectedItemIndex)
    {
        for(BranchItemRule branchitemrule : selectedItem.getRules())
        {
            // Show hidden question.
            if(branchitemrule.getRuletype() == 1)
            {
                showHiddenQuestion(branchitemrule, selectedItem, skip, surveyJSFModel);
                
                // recalculate other rules
                for(PageBranch branch : surveyJSFModel.getCurrPage().getPageBranchList())
                {
                    if(branch.getMain())
                    {
                        // if skip, recalculate all rules; if answered, recalculate rules after this rule.
                        for(int itemIndex = skip ? 0 : selectedItemIndex; itemIndex < branch.getItemList().size(); itemIndex ++)
                        {
                            BranchItem item = branch.getItemList().get(itemIndex);
                            
                            for(BranchItemRule currbranchitemrule : item.getRules())
                            {
                                if(currbranchitemrule.getRuletype() == 1)
                                {
                                    if(item.getBranchitemid().hashCode() != selectedItem.getBranchitemid().hashCode() && item.getQuestion().getAnswered() == 1)
                                    {
                                        showHiddenQuestion(currbranchitemrule, item, false, surveyJSFModel);
                                    }
                                    else if(item.getBranchitemid().hashCode() != selectedItem.getBranchitemid().hashCode() && item.getQuestion().getAnswered() == 0)
                                    {
                                        // revert rule
                                        showHiddenQuestion(currbranchitemrule, item, !currbranchitemrule.getCondition().getSkips(), surveyJSFModel);
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
            // Change default branch of page (temporarily).
            else if(branchitemrule.getRuletype() == 2)
            {
                changeDefaultBranch(branchitemrule, selectedItem, skip, surveyJSFModel);
                
                // recalculate other rules
                for(PageBranch branch : surveyJSFModel.getCurrPage().getPageBranchList())
                {
                    if(branch.getMain())
                    {
                        // if skip, recalculate all rules; if answered, recalculate rules after this rule.
                        for(int itemIndex = skip ? 0 : selectedItemIndex; itemIndex < branch.getItemList().size(); itemIndex ++)
                        {
                            BranchItem item = branch.getItemList().get(itemIndex);
                            
                            for(BranchItemRule currbranchitemrule : item.getRules())
                            {
                                if(currbranchitemrule.getRuletype() == 2)
                                {
                                    if(item.getBranchitemid().hashCode() != selectedItem.getBranchitemid().hashCode() && item.getQuestion().getAnswered() == 1)
                                    {
                                        changeDefaultBranch(currbranchitemrule, item, false, surveyJSFModel);
                                    }
                                    else if(item.getBranchitemid().hashCode() != selectedItem.getBranchitemid().hashCode() && item.getQuestion().getAnswered() == 0)
                                    {
                                        changeDefaultBranch(currbranchitemrule, item, !currbranchitemrule.getCondition().getSkips(), surveyJSFModel);
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
            // Jump to page right after (skips the rest of page).
            else if(branchitemrule.getRuletype() == 3)
            {
                // revert all rules
                for(PageBranch branch : surveyJSFModel.getCurrPage().getPageBranchList())
                {
                    if(branch.getMain())
                    {
                        for(int itemIndex = 0; itemIndex < branch.getItemList().size(); itemIndex ++)
                        {
                            BranchItem item = branch.getItemList().get(itemIndex);
                            
                            for(BranchItemRule currbranchitemrule : item.getRules())
                            {
                                if(currbranchitemrule.getRuletype() == 3)
                                {
                                    jumpPageImmediately(currbranchitemrule, item, !currbranchitemrule.getCondition().getSkips(), surveyJSFModel, itemIndex);
                                }
                            }
                        }
                    }
                }
                
                // execute first rule of this page.
                for(PageBranch branch : surveyJSFModel.getCurrPage().getPageBranchList())
                {
                    if(branch.getMain())
                    {
                        for(int itemIndex = 0; itemIndex < branch.getItemList().size(); itemIndex ++)
                        {
                            BranchItem item = branch.getItemList().get(itemIndex);
                            if(item.isHidden())
                            {
                                continue;
                            }
                            
                            for(BranchItemRule currbranchitemrule : item.getRules())
                            {
                                if(currbranchitemrule.getRuletype() == 3)
                                {
                                    if(item.getQuestion().getAnswered() == 1)
                                    {
                                        jumpPageImmediately(currbranchitemrule, item, false, surveyJSFModel, itemIndex);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // Jump to page after this page.
            else if(branchitemrule.getRuletype() == 4)
            {
                jumpPageLater(branchitemrule, selectedItem, skip, surveyJSFModel);
                
                // recalculate other rules
                for(PageBranch branch : surveyJSFModel.getCurrPage().getPageBranchList())
                {
                    if(branch.getMain())
                    {
                        // if skip, recalculate all rules; if answered, recalculate rules after this rule.
                        for(int itemIndex = skip ? 0 : selectedItemIndex; itemIndex < branch.getItemList().size(); itemIndex ++)
                        {
                            BranchItem item = branch.getItemList().get(itemIndex);
                            
                            for(BranchItemRule currbranchitemrule : item.getRules())
                            {
                                if(currbranchitemrule.getRuletype() == 4)
                                {
                                    if(item.getBranchitemid().hashCode() != selectedItem.getBranchitemid().hashCode() && item.getQuestion().getAnswered() == 1)
                                    {
                                        jumpPageLater(currbranchitemrule, item, false, surveyJSFModel);
                                    }
                                    else if(item.getBranchitemid().hashCode() != selectedItem.getBranchitemid().hashCode() && item.getQuestion().getAnswered() == 0)
                                    {
                                        jumpPageLater(currbranchitemrule, item, !currbranchitemrule.getCondition().getSkips(), surveyJSFModel);
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * Show hidden question.
     */
    private void showHiddenQuestion(BranchItemRule branchitemrule, BranchItem selectedItem, boolean skip, SurveyJSFModel surveyJSFModel)
    {
        for(Result result : branchitemrule.getResultsList())
        {
            for(PageBranch pageBranch : surveyJSFModel.getCurrPage().getPageBranchList())
            {
                if(pageBranch.getMain())
                {
                    for(int itemIndex = 0; itemIndex < pageBranch.getItemList().size(); itemIndex ++)
                    {
                        BranchItem item = pageBranch.getItemList().get(itemIndex);
                        if(item.getBranchitemid().hashCode() == result.getDisplays().hashCode())
                        {
                            // answer or skip
                            if(branchitemrule.getCondition().getConditionType() < 3)
                            {
                                if(branchitemrule.getCondition().getSkips() == skip)
                                {
                                    item.setHidden(false);
                                }
                                else
                                {
                                    setItemHidden(item, surveyJSFModel, itemIndex);
                                }
                            }
                            // Rating
                            else if(branchitemrule.getCondition().getConditionType() == 3)
                            {
                                boolean matchConditionFlag = checkRating(branchitemrule, selectedItem);
                                if(matchConditionFlag)
                                {
                                    item.setHidden(false);
                                }
                                else
                                {
                                    setItemHidden(item, surveyJSFModel, itemIndex);
                                }
                            }
                            // choice
                            else if(branchitemrule.getCondition().getConditionType() == 4 || branchitemrule.getCondition().getConditionType() == 6)
                            {
                                boolean matchConditionFlag = checkChoice(branchitemrule, selectedItem);
                                if(matchConditionFlag)
                                {
                                    item.setHidden(false);
                                }
                                else
                                {
                                    setItemHidden(item, surveyJSFModel, itemIndex);
                                }
                            }
                            // Matrix
                            else if(branchitemrule.getCondition().getConditionType() == 5)
                            {
                                // Rating
                                if(selectedItem.getQuestion().getQuestiontype() == 4 && selectedItem.getQuestion().getColumntype() == 2)
                                {
                                    boolean matchConditionFlag = checkRating(branchitemrule, selectedItem);
                                    if(matchConditionFlag)
                                    {
                                        item.setHidden(false);
                                    }
                                    else
                                    {
                                        setItemHidden(item, surveyJSFModel, itemIndex);
                                    }
                                }
                                // choice
                                else if(selectedItem.getQuestion().getQuestiontype() == 4 && selectedItem.getQuestion().getColumntype() == 3)
                                {
                                    boolean matchConditionFlag = checkChoiceMatrix(branchitemrule, selectedItem);
                                    if(matchConditionFlag)
                                    {
                                        item.setHidden(false);
                                    }
                                    else
                                    {
                                        setItemHidden(item, surveyJSFModel, itemIndex);
                                    }
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    /**
     * Change default branch of page (temporarily).
     */
    private void changeDefaultBranch(BranchItemRule branchitemrule, BranchItem selectedItem, boolean skip, SurveyJSFModel surveyJSFModel)
    {
        for(Result result : branchitemrule.getResultsList())
        {
            for(int pageIndex = 0; pageIndex < surveyJSFModel.getSurvey().getPageList().size(); pageIndex ++)
            {
                Page aPage = surveyJSFModel.getSurvey().getPageList().get(pageIndex);
                if(aPage == null)
                {
                    aPage = (Page)surveyJSFModel.getDeletedPages().get(pageIndex);
                    if(aPage == null)
                    {
                        continue;
                    }
                }
                if(aPage.getPageid().hashCode() == result.getPageid().hashCode())
                {
                    // answer or skip
                    if(branchitemrule.getCondition().getConditionType() < 3)
                    {
                        if(branchitemrule.getCondition().getSkips() == skip)
                        {
                            setDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                        }
                        else
                        {
                            revertDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                        }
                    }
                    // Rating
                    else if(branchitemrule.getCondition().getConditionType() == 3)
                    {
                        boolean matchConditionFlag = checkRating(branchitemrule, selectedItem);
                        if(matchConditionFlag)
                        {
                            setDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                        }
                        else
                        {
                            revertDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                        }
                    }
                    // choice
                    else if(branchitemrule.getCondition().getConditionType() == 4 || branchitemrule.getCondition().getConditionType() == 6)
                    {
                        boolean matchConditionFlag = checkChoice(branchitemrule, selectedItem);
                        if(matchConditionFlag)
                        {
                            setDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                        }
                        else
                        {
                            revertDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                        }
                    }
                    // Matrix
                    else if(branchitemrule.getCondition().getConditionType() == 5)
                    {
                        // Rating
                        if(selectedItem.getQuestion().getQuestiontype() == 4 && selectedItem.getQuestion().getColumntype() == 2)
                        {
                            boolean matchConditionFlag = checkRating(branchitemrule, selectedItem);
                            if(matchConditionFlag)
                            {
                                setDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                            }
                            else
                            {
                                revertDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                            }
                        }
                        // choice
                        else if(selectedItem.getQuestion().getQuestiontype() == 4 && selectedItem.getQuestion().getColumntype() == 3)
                        {
                            boolean matchConditionFlag = checkChoiceMatrix(branchitemrule, selectedItem);
                            if(matchConditionFlag)
                            {
                                setDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                            }
                            else
                            {
                                revertDefaultBranch(aPage, pageIndex, result, surveyJSFModel);
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
    
    /**
     * Jump to page right after (skips the rest of page).
     */
    private void jumpPageImmediately(BranchItemRule branchitemrule, BranchItem selectedItem, boolean skip, SurveyJSFModel surveyJSFModel, Integer currItemIndex)
    {
        for(Result result : branchitemrule.getResultsList())
        {
            for(int pageIndex = 0; pageIndex < surveyJSFModel.getSurvey().getPageList().size(); pageIndex ++)
            {
                Page aPage = surveyJSFModel.getSurvey().getPageList().get(pageIndex);
                if(aPage == null)
                {
                    continue;
                }
                if(result.getPageid_aq().hashCode() == aPage.getPageid().hashCode())
                {
                    // answer or skip
                    if(branchitemrule.getCondition().getConditionType() < 3)
                    {
                        if(branchitemrule.getCondition().getSkips() == skip)
                        {
                            saveDeletedPagesAndItems(pageIndex, surveyJSFModel, currItemIndex);
                            surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                        }
                        else
                        {
                            revertDeletedPagesAndItems(pageIndex, surveyJSFModel);
                            break;
                        }
                    }
                    // Rating
                    else if(branchitemrule.getCondition().getConditionType() == 3)
                    {
                        boolean matchConditionFlag = checkRating(branchitemrule, selectedItem);
                        if(matchConditionFlag)
                        {
                            saveDeletedPagesAndItems(pageIndex, surveyJSFModel, currItemIndex);
                            surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                        }
                        else
                        {
                            revertDeletedPagesAndItems(pageIndex, surveyJSFModel);
                            break;
                        }
                    }
                    // choice
                    else if(branchitemrule.getCondition().getConditionType() == 4 || branchitemrule.getCondition().getConditionType() == 6)
                    {
                        boolean matchConditionFlag = checkChoice(branchitemrule, selectedItem);
                        if(matchConditionFlag)
                        {
                            saveDeletedPagesAndItems(pageIndex, surveyJSFModel, currItemIndex);
                            surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                        }
                        else
                        {
                            revertDeletedPagesAndItems(pageIndex, surveyJSFModel);
                            break;
                        }
                    }
                    // Matrix
                    else if(branchitemrule.getCondition().getConditionType() == 5)
                    {
                        // Rating
                        if(selectedItem.getQuestion().getQuestiontype() == 4 && selectedItem.getQuestion().getColumntype() == 2)
                        {
                            boolean matchConditionFlag = checkRating(branchitemrule, selectedItem);
                            if(matchConditionFlag)
                            {
                                saveDeletedPagesAndItems(pageIndex, surveyJSFModel, currItemIndex);
                                surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                            }
                            else
                            {
                                revertDeletedPagesAndItems(pageIndex, surveyJSFModel);
                                break;
                            }
                        }
                        else if(selectedItem.getQuestion().getQuestiontype() == 4 && selectedItem.getQuestion().getColumntype() == 3)
                        {
                            boolean matchConditionFlag = checkChoiceMatrix(branchitemrule, selectedItem);
                            if(matchConditionFlag)
                            {
                                saveDeletedPagesAndItems(pageIndex, surveyJSFModel, currItemIndex);
                                surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                            }
                            else
                            {
                                revertDeletedPagesAndItems(pageIndex, surveyJSFModel);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Jump to page after this page.
     */
    private void jumpPageLater(BranchItemRule branchitemrule, BranchItem selectedItem, boolean skip, SurveyJSFModel surveyJSFModel)
    {
        for(Result result : branchitemrule.getResultsList())
        {
            for(int pageIndex = 0; pageIndex < surveyJSFModel.getSurvey().getPageList().size(); pageIndex ++)
            {
                Page aPage = surveyJSFModel.getSurvey().getPageList().get(pageIndex);
                if(aPage == null)
                {
                    continue;
                }
                if(result.getPageid_ap().hashCode() == aPage.getPageid().hashCode())
                {
                    // answer or skip
                    if(branchitemrule.getCondition().getConditionType() < 3)
                    {
                        if(branchitemrule.getCondition().getSkips() == skip)
                        {
                            saveDeletedPages(pageIndex, surveyJSFModel);
                            surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                        }
                        else
                        {
                            revertDeletedPages(pageIndex, surveyJSFModel);
                            break;
                        }
                    }
                    // Rating
                    else if(branchitemrule.getCondition().getConditionType() == 3)
                    {
                        boolean matchConditionFlag = checkRating(branchitemrule, selectedItem);
                        if(matchConditionFlag)
                        {
                            saveDeletedPages(pageIndex, surveyJSFModel);
                            surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                        }
                        else
                        {
                            revertDeletedPages(pageIndex, surveyJSFModel);
                            break;
                        }
                    }
                    // choice
                    else if(branchitemrule.getCondition().getConditionType() == 4 || branchitemrule.getCondition().getConditionType() == 6)
                    {
                        boolean matchConditionFlag = checkChoice(branchitemrule, selectedItem);
                        if(matchConditionFlag)
                        {
                            saveDeletedPages(pageIndex, surveyJSFModel);
                            surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                        }
                        else
                        {
                            revertDeletedPages(pageIndex, surveyJSFModel);
                            break;
                        }
                    }
                    // Matrix
                    else if(branchitemrule.getCondition().getConditionType() == 5)
                    {
                        // Rating
                        if(selectedItem.getQuestion().getQuestiontype() == 4 && selectedItem.getQuestion().getColumntype() == 2)
                        {
                            boolean matchConditionFlag = checkRating(branchitemrule, selectedItem);
                            if(matchConditionFlag)
                            {
                                saveDeletedPages(pageIndex, surveyJSFModel);
                                surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                            }
                            else
                            {
                                revertDeletedPages(pageIndex, surveyJSFModel);
                                break;
                            }
                        }
                        else if(selectedItem.getQuestion().getQuestiontype() == 4 && selectedItem.getQuestion().getColumntype() == 3)
                        {
                            boolean matchConditionFlag = checkChoiceMatrix(branchitemrule, selectedItem);
                            if(matchConditionFlag)
                            {
                                saveDeletedPages(pageIndex, surveyJSFModel);
                                surveyJSFModel.setCurrentPageIndex(pageIndex - 1);
                            }
                            else
                            {
                                revertDeletedPages(pageIndex, surveyJSFModel);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Set item hidden.
     */
    private void setItemHidden(BranchItem item, SurveyJSFModel surveyJSFModel, Integer itemIndex)
    {
        item.setHidden(true);
        cleanAnswer(item);
        item.getQuestion().setAnswered(0);
        changeSurveywithRules(true, item, surveyJSFModel, itemIndex);
    }
    
    /**
     * Check violation rules.
     */
    @Override
    public void checkViolationRule(SurveyJSFModel surveyJSFModel)
    {
        surveyJSFModel.setViolationRules(new ArrayList<ViolationRuleJSFModel>());
        for(int pageIndex = 0; pageIndex < surveyJSFModel.getSurvey().getPageList().size(); pageIndex ++)
        {
            Page page = surveyJSFModel.getSurvey().getPageList().get(pageIndex);
            for(PageBranch branch : page.getPageBranchList())
            {
                for(int itemIndex = 0; itemIndex < branch.getItemList().size(); itemIndex ++)
                {
                    BranchItem item = branch.getItemList().get(itemIndex);
                    for(BranchItemRule branchitemrule : item.getRules())
                    {
                        checkViolationResult(page, branch, item, branchitemrule, pageIndex, itemIndex, surveyJSFModel);
                    }
                }
            }
        }
    }
    
    /**
     * 
     */
    private void checkViolationResult(Page currPage, PageBranch currBranch, BranchItem currItem, BranchItemRule branchitemrule, 
            int pageIndex, int itemIndex, SurveyJSFModel surveyJSFModel)
    {
        for(Result result : branchitemrule.getResultsList())
        {
            // Show hidden question.
            if(branchitemrule.getRuletype() == 1)
            {
                boolean hasTheItem = false;
                for(int hiddenItemIndex = 0; hiddenItemIndex < currBranch.getItemList().size(); hiddenItemIndex ++)
                {
                    BranchItem hiddenItem = currBranch.getItemList().get(hiddenItemIndex);
                    if(hiddenItem.getBranchitemid().hashCode() == result.getDisplays().hashCode())
                    {
                        hasTheItem = true;
                        if(hiddenItemIndex <= itemIndex)
                        {
                            addViolationRule(currPage.getPageid(), 
                                             currBranch.getBranchid(), 
                                             currItem, 
                                             "You can not show hidden questions that BEFORE this question.", 
                                             branchitemrule,
                                             surveyJSFModel);
                            return;
                        }
                        
                        if(!hiddenItem.isHidden())
                        {
                            addViolationRule(currPage.getPageid(), 
                                             currBranch.getBranchid(), 
                                             currItem, 
                                             "You can not show questions that not hidden.", 
                                             branchitemrule,
                                             surveyJSFModel);
                            return;
                        }
                    }
                }
                if(!hasTheItem)
                {
                    addViolationRule(currPage.getPageid(), 
                                     currBranch.getBranchid(), 
                                     currItem, 
                                     "Hidden questions that will be showed in this rule may deleted, please check it out.", 
                                     branchitemrule,
                                     surveyJSFModel);
                    return;
                }
            }
            // Change default branch of page (temporarily).
            else if(branchitemrule.getRuletype() == 2)
            {
                for(int pageIndex1 = 0; pageIndex1 < surveyJSFModel.getSurvey().getPageList().size(); pageIndex1 ++)
                {
                    Page aPage = surveyJSFModel.getSurvey().getPageList().get(pageIndex1);
                    if(aPage.getPageid().hashCode() == result.getPageid().hashCode())
                    {
                        if(pageIndex1 <= pageIndex)
                        {
                            addViolationRule(currPage.getPageid(), 
                                             currBranch.getBranchid(), 
                                             currItem, 
                                             "You can not change branch in page that BEFORE this page.", 
                                             branchitemrule,
                                             surveyJSFModel);
                            return;
                        }
                        for(PageBranch branch : aPage.getPageBranchList())
                        {
                            if(branch.getBranchid().hashCode() == result.getPagebranchid().hashCode())
                            {
                                return;
                            }
                        }
                        
                    }
                }
                // if can not find the branch.
                addViolationRule(currPage.getPageid(), 
                                 currBranch.getBranchid(), 
                                 currItem, 
                                 "The branch will be showed in this rule may deleted, please check it out.", 
                                 branchitemrule,
                                 surveyJSFModel);
            }
            // Jump to page right after (skips the rest of page). || Jump to page after this page.
            else
            {
                // Jump to page right after (skips the rest of page).
                if(branchitemrule.getRuletype() == 3)
                {
                    for(int behindItemIndex = itemIndex + 1; behindItemIndex < currBranch.getItemList().size(); behindItemIndex ++)
                    {
                        BranchItem item = (BranchItem)currBranch.getItemList().get(behindItemIndex);
                        
                        // 该问题之后的Hidden问题中，如果有mandatory的，暂时决定也被当做是一条violation rule；
                        // 因为Hidden的问题有可能在该题之前被显示出来，如果有mandatory的题，跳页的时候mandatory的问题就有可能被跳过。
                        if(item.isMandatory())
                        {
                            addViolationRule(currPage.getPageid(), 
                                             currBranch.getBranchid(), 
                                             currItem, 
                                             "Question with rule that jump page immediately can not exist MANDATORY question(s) below.", 
                                             branchitemrule,
                                             surveyJSFModel);
                            return;
                        }
                    }
                }
                
                for(int pageIndex1 = 0; pageIndex1 < surveyJSFModel.getSurvey().getPageList().size(); pageIndex1 ++)
                {
                    Page aPage = surveyJSFModel.getSurvey().getPageList().get(pageIndex1);
                    if((branchitemrule.getRuletype() == 3 && result.getPageid_aq().hashCode() == aPage.getPageid().hashCode())
                            || (branchitemrule.getRuletype() == 4 && result.getPageid_ap().hashCode() == aPage.getPageid().hashCode()))
                    {
                        if(pageIndex1 <= pageIndex)
                        {
                            addViolationRule(currPage.getPageid(), 
                                             currBranch.getBranchid(), 
                                             currItem, 
                                             "You can not jump to page that BEFORE this page.", 
                                             branchitemrule,
                                             surveyJSFModel);
                        }
                        return;
                    }
                }
                // if can not find the page.
                addViolationRule(currPage.getPageid(), 
                                 currBranch.getBranchid(), 
                                 currItem, 
                                 "The page will jump to in this rule may deleted, please check it out.", 
                                 branchitemrule,
                                 surveyJSFModel);
            }
        }
    }
    
    /**
     * 
     */
    private void addViolationRule(Integer pageid, Integer branchid, BranchItem item, String discription, BranchItemRule rule, SurveyJSFModel surveyJSFModel)
    {
        ViolationRuleJSFModel violationRule = new ViolationRuleJSFModel();
        violationRule.setPageid(pageid);
        violationRule.setBranchid(branchid);
        violationRule.setItem(item);
        violationRule.setViolationDiscription(discription);
        violationRule.setRule(rule);
        violationRule.setResultsList(rule.getResultsList());
        surveyJSFModel.getViolationRules().add(violationRule);
    }
    
    /**
     * check if Rating match condition
     */
    private boolean checkRating(BranchItemRule branchitemrule, BranchItem selectedItem)
    {
        List<Scenario> scenarioList = branchitemrule.getCondition().getScenarioList();
        
        if(selectedItem.getQuestion().getQuestiontype() == 2)
        {
            for(Scenario scenario : scenarioList)
            {
                if(selectedItem.getEntry().getRating() != null)
                {
                    if((branchitemrule.getCondition().getComparator() == 1 && selectedItem.getEntry().getRating() > scenario.getRating())
                            || (branchitemrule.getCondition().getComparator() == 2 && selectedItem.getEntry().getRating() < scenario.getRating())
                            || (branchitemrule.getCondition().getComparator() == 3 && selectedItem.getEntry().getRating() == scenario.getRating()))
                    {
                            return true;
                    }
                }
            }
            return false;
        }
        else
        {
            // or
            if(branchitemrule.getCondition().getComparator() == null || branchitemrule.getCondition().getComparator() == 4)
            {
                for(Scenario scenario : scenarioList)
                {
                    for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
                    {
                        if(subquestion.getSubquestionid().hashCode() == scenario.getSubquestionId().hashCode())
                        {
                            if(subquestion.getEntry().getRating() != null)
                            {
                                if((scenario.getComparator() == 1 && subquestion.getEntry().getRating() > scenario.getRating())
                                        || (scenario.getComparator() == 2 && subquestion.getEntry().getRating() < scenario.getRating())
                                        || (scenario.getComparator() == 3 && subquestion.getEntry().getRating() == scenario.getRating()))
                                {
                                        return true;
                                }
                            }
                            break;
                        }
                    }
                }
                return false;
            }
            // and 
            else
            {
                for(Scenario scenario : scenarioList)
                {
                    for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
                    {
                        if(subquestion.getSubquestionid().hashCode() == scenario.getSubquestionId().hashCode())
                        {
                            if(subquestion.getEntry().getRating() != null)
                            {
                                if((scenario.getComparator() == 1 && subquestion.getEntry().getRating() > scenario.getRating())
                                        || (scenario.getComparator() == 2 && subquestion.getEntry().getRating() < scenario.getRating())
                                        || (scenario.getComparator() == 3 && subquestion.getEntry().getRating() == scenario.getRating()))
                                {
                                        break;
                                }
                                else if((scenario.getComparator() == 1 && subquestion.getEntry().getRating() <= scenario.getRating())
                                        || (scenario.getComparator() == 2 && subquestion.getEntry().getRating() >= scenario.getRating())
                                        || (scenario.getComparator() == 3 && subquestion.getEntry().getRating() != scenario.getRating()))
                                {
                                    return false;
                                }
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }
    }
    
    /**
     * check if Choice matched condition
     */
    private boolean checkChoice(BranchItemRule branchitemrule, BranchItem selectedItem)
    {
        List<Scenario> scenarioList = branchitemrule.getCondition().getScenarioList();
        // chooses
        if(branchitemrule.getCondition().getConditionType() == 4)
        {
            // or
            if(branchitemrule.getCondition().getComparator() == null || branchitemrule.getCondition().getComparator() == 4)
            {
                for(Scenario scenario : scenarioList)
                {
                    // single
                    if(!selectedItem.getQuestion().getAllowmultipile())
                    {
                        if(checkSelectionsOR(selectedItem, scenario))
                        {
                            return true;
                        }                    
                    }
                    // multiple
                    else if(selectedItem.getQuestion().getAllowmultipile())
                    {
                        if(checkSelectionsOR(selectedItem, scenario))
                        {
                            return true;
                        }
                    }
                }

                return false;
            }
            // and
            else
            {
                for(Scenario scenario : scenarioList)
                {
                    // single
                    if(!selectedItem.getQuestion().getAllowmultipile())
                    {
                        if(!checkSelectionsOR(selectedItem, scenario))
                        {
                            return false;
                        }
                    }
                    else if(selectedItem.getQuestion().getAllowmultipile())
                    {
                        if(!checkSelectionsAND(selectedItem, scenario))
                        {
                            return false;
                        }
                    }
                }

                return true;
            }
        }
        // doesn`t choose
        else if(branchitemrule.getCondition().getConditionType() == 6)
        {
            // single
            if(!selectedItem.getQuestion().getAllowmultipile())
            {
                for(Scenario scenario : scenarioList)
                {
                    if(!checkSelectionsOR(selectedItem, scenario))
                    {
                        return true;
                    }    
                }
            }
            // multiple
            else if(selectedItem.getQuestion().getAllowmultipile())
            {
                // or
                if(branchitemrule.getCondition().getComparator() == null || branchitemrule.getCondition().getComparator() == 4)
                {
                    for(Scenario scenario : scenarioList)
                    {
                        if(!checkSelectionsOR(selectedItem, scenario))
                        {
                            return true;
                        } 
                    }
                }
                // and
                else if(branchitemrule.getCondition().getComparator() == 5)
                {
                    for(Scenario scenario : scenarioList)
                    {
                        if(checkSelectionsAND(selectedItem, scenario))
                        {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * check if Choice in Matrix matched condition
     */
    private boolean checkChoiceMatrix(BranchItemRule branchitemrule, BranchItem selectedItem)
    {
        List<Scenario> scenarioList = branchitemrule.getCondition().getScenarioList();
        // or
        if(branchitemrule.getCondition().getComparator() == null || branchitemrule.getCondition().getComparator() == 4)
        {
            for(Scenario scenario : scenarioList)
            {
                // single
                if(!selectedItem.getQuestion().getAllowmultipile())
                {
                    // column choice only one || column choice or
                    if(scenario.getComparator() == null || scenario.getComparator() == 4)
                    {
                        if(checkSelectionsOR(selectedItem, scenario))
                        {
                            return true;
                        }
                    }
                    // column choice and
                    else if(scenario.getComparator() == 5)
                    {
                        if(checkSelectionsAND(selectedItem, scenario))
                        {
                            return true;
                        }
                    }
                    
                }
                else if(selectedItem.getQuestion().getAllowmultipile())
                {
                    // column choice only one || column choice or
                    if(scenario.getComparator() == null || scenario.getComparator() == 4)
                    {
                        if(checkSelectionsOR(selectedItem, scenario))
                        {
                            return true;
                        }
                    }
                    // and 
                    else if(scenario.getComparator() == 5)
                    {
                        if(checkSelectionsAND(selectedItem, scenario))
                        {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        else
        {
            for(Scenario scenario : scenarioList)
            {
                // single
                if(!selectedItem.getQuestion().getAllowmultipile())
                {
                    // column choice only one || column choice or
                    if(scenario.getComparator() == null || scenario.getComparator() == 4)
                    {
                        if(!checkSelectionsOR(selectedItem, scenario))
                        {
                            return false;
                        }
                    }
                    // column choice and
                    else if(scenario.getComparator() == 5)
                    {
                        if(!checkSelectionsAND(selectedItem, scenario))
                        {
                            return false;
                        }
                    }
                }
                else if(selectedItem.getQuestion().getAllowmultipile())
                {
                    // or
                    if(scenario.getComparator() == null || scenario.getComparator() == 4)
                    {
                        if(!checkSelectionsOR(selectedItem, scenario))
                        {
                            return false;
                        }
                    }
                    // and 
                    else if(scenario.getComparator() == 5)
                    {
                        if(!checkSelectionsAND(selectedItem, scenario))
                        {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
    
    /**
     * Set Default branch. (sub method of changeDefaultBranch)
     */
    private void setDefaultBranch(Page aPage, int pageIndex, Result result, SurveyJSFModel surveyJSFModel)
    {
        for(int branchIndex = 0; branchIndex < aPage.getPageBranchList().size(); branchIndex ++)
        {
            PageBranch pagebranch = aPage.getPageBranchList().get(branchIndex);
            if(pagebranch.getMain() && surveyJSFModel.getDefaultBranchRecorder().get(pageIndex) == null)
            {
                surveyJSFModel.getDefaultBranchRecorder().put(pageIndex, branchIndex);
            }
            if(pagebranch.getBranchid().hashCode() == result.getPagebranchid().hashCode())
            {
                pagebranch.setMain(true);
            }
            else
            {
                pagebranch.setMain(false);
            }
        }
    }
    
    /**
     * Revert default branch. (sub method of changeDefaultBranch)
     */
    private void revertDefaultBranch(Page aPage, int pageIndex, Result result, SurveyJSFModel surveyJSFModel)
    {
        for(PageBranch pagebranch : aPage.getPageBranchList())
        {
            if(pagebranch.getBranchid().hashCode() == result.getPagebranchid().hashCode())
            {
                pagebranch.setMain(false);
                break;
            }
        }

        // revert default branch
        Object branchIndex = surveyJSFModel.getDefaultBranchRecorder().get(pageIndex);
        if(branchIndex != null)
        {
            aPage.getPageBranchList().get(Integer.parseInt(branchIndex.toString())).setMain(true);
        }
    }
    
    /**
     * save deleted pages.
     */
    private void saveDeletedPagesAndItems(int pageIndex, SurveyJSFModel surveyJSFModel, Integer currItemIndex)
    {
        for(int i = surveyJSFModel.getCurrentPageIndex() + 1; i < pageIndex; i ++)
        {
            if(surveyJSFModel.getDeletedPages().get(i) == null && surveyJSFModel.getSurvey().getPageList().get(i) != null)
            {
                surveyJSFModel.getDeletedPages().put(i, surveyJSFModel.getSurvey().getPageList().get(i));
                surveyJSFModel.getSurvey().getPageList().set(i, null);
            }
        }
        
        // hidden rest questions.
        for(PageBranch branch : surveyJSFModel.getCurrPage().getPageBranchList())
        {
            if(branch.getMain())
            {
                for(int itemIndex = currItemIndex + 1; itemIndex < branch.getItemList().size(); itemIndex ++)
                {
                    if(!branch.getItemList().get(itemIndex).isHidden())
                    {
                        setItemHidden(branch.getItemList().get(itemIndex), surveyJSFModel, itemIndex);
                        surveyJSFModel.getDefaultItemRecorder().put(branch.getItemList().get(itemIndex).getBranchitemid(), "Y");
                    }
                }
                break;
            }
        }
    }
    
    /**
     * revert deleted pages.
     */
    private void revertDeletedPagesAndItems(int pageIndex, SurveyJSFModel surveyJSFModel)
    {
        while(surveyJSFModel.getSurvey().getPageList().get(surveyJSFModel.getCurrentPageIndex()) == null)
        {
            surveyJSFModel.setCurrentPageIndex(surveyJSFModel.getCurrentPageIndex() - 1);
        }
        
        for(int i = pageIndex - 1; i > surveyJSFModel.getCurrentPageIndex(); i --)
        {
            if(surveyJSFModel.getDeletedPages().get(i) != null && surveyJSFModel.getSurvey().getPageList().get(i) == null)
            {
                surveyJSFModel.getSurvey().getPageList().set(i, (Page)surveyJSFModel.getDeletedPages().get(i));
                surveyJSFModel.getDeletedPages().remove(i);
            }
        }
        
        // revert hidded items.
        for(PageBranch branch : surveyJSFModel.getCurrPage().getPageBranchList())
        {
            if(branch.getMain())
            {
                for(BranchItem item : branch.getItemList())
                {
                    String hidden = (String) surveyJSFModel.getDefaultItemRecorder().get(item.getBranchitemid());
                    if(hidden != null)
                    {
                        item.setHidden(false);
                    }
                }
                break;
            }
        }
    }
    
    /**
     * save deleted pages.
     */
    private void saveDeletedPages(int pageIndex, SurveyJSFModel surveyJSFModel)
    {
        for(int i = surveyJSFModel.getCurrentPageIndex() + 1; i < pageIndex; i ++)
        {
            if(surveyJSFModel.getDeletedPages().get(i) == null && surveyJSFModel.getSurvey().getPageList().get(i) != null)
            {
                surveyJSFModel.getDeletedPages().put(i, surveyJSFModel.getSurvey().getPageList().get(i));
                surveyJSFModel.getSurvey().getPageList().set(i, null);
            }
        }
    }
    
    /**
     * revert deleted pages.
     */
    private void revertDeletedPages(int pageIndex, SurveyJSFModel surveyJSFModel)
    {
        while(surveyJSFModel.getSurvey().getPageList().get(surveyJSFModel.getCurrentPageIndex()) == null)
        {
            surveyJSFModel.setCurrentPageIndex(surveyJSFModel.getCurrentPageIndex() - 1);
        }
        
        for(int i = pageIndex - 1; i > surveyJSFModel.getCurrentPageIndex(); i --)
        {
            if(surveyJSFModel.getDeletedPages().get(i) != null && surveyJSFModel.getSurvey().getPageList().get(i) == null)
            {
                surveyJSFModel.getSurvey().getPageList().set(i, (Page)surveyJSFModel.getDeletedPages().get(i));
                surveyJSFModel.getDeletedPages().remove(i);
            }
        }
    }
    
    /**
     * check is multiple choice if match the selection(or)
     */
    private boolean checkSelectionsOR(BranchItem selectedItem, Scenario scenario)
    {
        if(selectedItem.getQuestion().getQuestiontype() == 3)
        {
            // single
            if(!selectedItem.getQuestion().getAllowmultipile())
            {
                if(selectedItem.getEntry().getAr_id() != null && scenario.getAnswerId().hashCode() == selectedItem.getEntry().getAr_id().hashCode())
                {
                    return true;
                }
            }
            // multiple
            else
            {
                for(String responseAnswerId : selectedItem.getResponseAnswerIds())
                {
                    if(scenario.getAnswerId().toString().equals(responseAnswerId))
                    {
                        return true;
                    }
                }
            }
        }
        else if(selectedItem.getQuestion().getQuestiontype() == 4)
        {
            for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
            {
                // single
                if(!selectedItem.getQuestion().getAllowmultipile())
                {
                    if(scenario.getSubquestionId().hashCode() == subquestion.getSubquestionid().hashCode() && subquestion.getEntry().getAr_id() != null)
                    {
                        for(Scenariocc scenariocc : scenario.getScenarioccList())
                        {
                            if(scenariocc.getColumnchoiceid().hashCode() == subquestion.getEntry().getAr_id().hashCode())
                            {
                                return true;
                            }
                        }
                    }
                }
                // multiple
                else
                {
                    for(String responseColumnchoiceId : subquestion.getResponseColumnchoiceIds())
                    {
                        if(scenario.getSubquestionId().hashCode() == subquestion.getSubquestionid().hashCode())
                        {
                            for(Scenariocc scenariocc : scenario.getScenarioccList())
                            {
                                if(scenariocc.getColumnchoiceid().toString().equals(responseColumnchoiceId))
                                {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * check is multiple choice if match the selection(and)
     */
    private boolean checkSelectionsAND(BranchItem selectedItem, Scenario scenario)
    {
        if(selectedItem.getQuestion().getQuestiontype() == 3)
        {
            for(String responseAnswerId : selectedItem.getResponseAnswerIds())
            {
                if(scenario.getAnswerId().toString().equals(responseAnswerId))
                {
                    return true;
                }
            }
        }
        else if(selectedItem.getQuestion().getQuestiontype() == 4)
        {
            for(Subquestion subquestion : selectedItem.getQuestion().getSubquestionsList())
            {
                if(scenario.getSubquestionId().hashCode() == subquestion.getSubquestionid().hashCode())
                {
                    boolean matchedFlag = false;
                    for(Scenariocc scenariocc : scenario.getScenarioccList())
                    {
                        matchedFlag = false;
                        // column choice only one || column choice or
                        if(scenario.getComparator() == null || scenario.getComparator() == 4)
                        {
                            for(String responseColumnchoiceId : subquestion.getResponseColumnchoiceIds())
                            {
                                if(scenariocc.getColumnchoiceid().toString().equals(responseColumnchoiceId))
                                {
                                    matchedFlag = true;
                                    break;
                                }
                            }

                            if(matchedFlag)
                            {
                                return true;
                            }
                        }
                        else if(scenario.getComparator() == 5)
                        {
                            for(String responseColumnchoiceId : subquestion.getResponseColumnchoiceIds())
                            {
                                if(scenariocc.getColumnchoiceid().toString().equals(responseColumnchoiceId))
                                {
                                    matchedFlag = true;
                                    break;
                                }
                            }

                            if(!matchedFlag)
                            {
                                return false;
                            }
                        }
                    }
                    
                    if(scenario.getComparator() == null || scenario.getComparator() == 4)
                    {
                        return false;
                    }
                    else if(scenario.getComparator() == 5)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * check if questions in this page are all finished.
     */
    @Override
    public boolean checkCurrPageAllFinished(SurveyJSFModel surveyJSFModel)
    {
        for(PageBranch branch : surveyJSFModel.getCurrPage().getPageBranchList())
        {
            if(branch.getMain())
            {
                for(BranchItem item : branch.getItemList())
                {
                    if(!item.isHidden() && item.getQuestion().getAnswered() == 0)
                    {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }
    
    /**
     * save answer.
     */
    @Transactional(readOnly=false)
    @Override
    public void saveAnswer(SurveyJSFModel surveyJSFModel, SurveyResponse surveyResponse)
    {
        saveSurvey(surveyResponse);
        PageResponse currPageResponse = savePage(surveyJSFModel, surveyResponse);
        
        BranchItem currItem = surveyJSFModel.getAnsweringItem();
        QuestionResponse questionResponse = saveQuestion(currItem, currPageResponse);

        // free text
        if(currItem.getQuestion().getQuestiontype() == 1)
        {
            saveFreeText(currItem.getEntry().getAnswercontent(), questionResponse);
        }
        // rating
        else if(currItem.getQuestion().getQuestiontype() == 2)
        {
            saveRating(currItem.getEntry().getRating(), questionResponse);
        }
        // choice
        else if(currItem.getQuestion().getQuestiontype() == 3)
        {
            saveChoice(currItem, questionResponse);
        }
        // matrix
        else if(currItem.getQuestion().getQuestiontype() == 4)
        {
            saveMatrix(currItem, questionResponse);
        }
    }
    
    /**
     * save survey.
     * @param surveyResponse 
     */
    private void saveSurvey(SurveyResponse surveyResponse)
    {
        if(surveyResponse.getSr_id() == null)
        {
            SurveyResponse savedSurveyResponse = surveyResponseDao.save(surveyResponse);
            surveyResponse.setSr_id(savedSurveyResponse.getSr_id());
        }
    }
    
    /**
     * save page.
     * @param surveyJSFModel
     * @param surveyResponse
     * @return 
     */
    private PageResponse savePage(SurveyJSFModel surveyJSFModel, SurveyResponse surveyResponse)
    {
        PageResponse currPageResponse = surveyResponse.getPageresponses().get(surveyJSFModel.getCurrentPageIndex());
        if(currPageResponse.getPr_id() == null)
        {
            currPageResponse.setSr_id(surveyResponse.getSr_id());
            currPageResponse = pageResponseDao.save(currPageResponse);
            surveyResponse.getPageresponses().get(surveyJSFModel.getCurrentPageIndex()).setPr_id(currPageResponse.getPr_id());
        }
        return currPageResponse;
    }
    
    /**
     * save question.
     * @param currItem
     * @param currPageResponse
     * @return 
     */
    private QuestionResponse saveQuestion(BranchItem currItem, PageResponse currPageResponse)
    {
        QuestionResponse questionResponse = new QuestionResponse(currItem.getQuestion());
        questionResponse.setPr_id(currPageResponse.getPr_id());
        questionResponse.setQuestionorder(currItem.getItemorder());
        questionResponse = questionResponseDao.save(questionResponse);
        return questionResponse;
    }
    
    /**
     * save freetext.
     * @param currItem
     * @param entry 
     */
    private void saveFreeText(String answerContent, QuestionResponse questionResponse)
    {
        Entry entry = new Entry();
        entry.setQr_id(questionResponse.getQr_id());
        entry.setAnswercontent(answerContent);
        entryDao.save(entry);
    }
    
    /**
     * save rating.
     * @param currItem
     * @param entry 
     */
    private void saveRating(Integer rating, QuestionResponse questionResponse)
    {
        Entry entry = new Entry();
        entry.setQr_id(questionResponse.getQr_id());
        entry.setRating(rating);
        entryDao.save(entry);
    }
    
    /**
     * save choice.
     * @param currItem
     * @param questionResponse
     * @param entry 
     */
    private void saveChoice(BranchItem currItem, QuestionResponse questionResponse)
    {
        Entry entry = new Entry();
        entry.setQr_id(questionResponse.getQr_id());
        // single
        if(!currItem.getQuestion().getAllowmultipile())
        {
            entry.setAnswercontent(currItem.getEntry().getAnswercontent());
            
            if(currItem.getEntry().getAr_id() == null)
            {
                if(entry.getAnswercontent() != null && !entry.getAnswercontent().equals(""))
                {
                    for(Answer answer : currItem.getQuestion().getAnswersList())
                    {
                        AnswerResponse answerResponse = new AnswerResponse(answer);
                        answerResponse.setQr_id(questionResponse.getQr_id());
                        answerResponseDao.save(answerResponse);
                    }
                    entryDao.save(entry);
                }
                return;
            }

            for(Answer answer : currItem.getQuestion().getAnswersList())
            {
                AnswerResponse answerResponse = new AnswerResponse(answer);
                answerResponse.setQr_id(questionResponse.getQr_id());
                answerResponse = answerResponseDao.save(answerResponse);
                if(answer.getAnswerid().hashCode() == currItem.getEntry().getAr_id().hashCode())
                {
                    entry.setAr_id(answerResponse.getAr_id());
                }
            }
            entryDao.save(entry);
        }
        // multiple
        else
        {
            entry.setAnswercontent(currItem.getEntry().getAnswercontent());
            
            if(currItem.getResponseAnswerIds().size() <= 0)
            {
                if(entry.getAnswercontent() != null && !entry.getAnswercontent().equals(""))
                {
                    for(Answer answer : currItem.getQuestion().getAnswersList())
                    {
                        AnswerResponse answerResponse = new AnswerResponse(answer);
                        answerResponse.setQr_id(questionResponse.getQr_id());
                        answerResponseDao.save(answerResponse);
                    }
                    entryDao.save(entry);
                }
                return;
            }
            
            for(Answer answer : currItem.getQuestion().getAnswersList())
            {
                AnswerResponse answerResponse = new AnswerResponse(answer);
                answerResponse.setQr_id(questionResponse.getQr_id());
                answerResponse = answerResponseDao.save(answerResponse);
                for(String responseAnswerId : currItem.getResponseAnswerIds())
                {
                    if(answer.getAnswerid().toString().equals(responseAnswerId))
                    {
                        entry.setAr_id(answerResponse.getAr_id());
                        entryDao.save(entry);
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * save matrix.
     * @param currItem
     * @param questionResponse
     * @param entry 
     */
    private void saveMatrix(BranchItem currItem, QuestionResponse questionResponse)
    {
        // choice
        if(currItem.getQuestion().getColumntype() == 3)
        {
            saveColumnChoice(currItem, questionResponse);
        }
        
        for(Subquestion subquestion : currItem.getQuestion().getSubquestionsList())
        {
            Entry entry = new Entry();
            entry.setQr_id(questionResponse.getQr_id());
            saveSubquestion(subquestion, questionResponse, entry);
        
            // input
            if(currItem.getQuestion().getColumntype() == 1)
            {
                if(subquestion.getEntry().getAnswercontent() != null && !subquestion.getEntry().getAnswercontent().equals(""))
                {
                    saveFreeText(subquestion.getEntry().getAnswercontent(), questionResponse);
                }
            }
            // rating
            else if(currItem.getQuestion().getColumntype() == 2)
            {
                if(subquestion.getEntry().getRating() != null)
                {
                    saveRating(subquestion.getEntry().getRating(), questionResponse);
                }
            }
            // choice
            else if(currItem.getQuestion().getColumntype() == 3)
            {
                // single
                if(!currItem.getQuestion().getAllowmultipile())
                {
                    entry.setAnswercontent(subquestion.getEntry().getAnswercontent());

                    if(subquestion.getEntry().getCcr_id() == null)
                    {
                        if(subquestion.getEntry().getAnswercontent() != null && !subquestion.getEntry().getAnswercontent().equals(""))
                        {
                            entryDao.save(entry);
                        }
                        continue;
                    }

                    for(int cholumnchoiceIndex = 0; cholumnchoiceIndex < currItem.getQuestion().getColumnchoicesList().size(); cholumnchoiceIndex ++)
                    {
                        Columnchoice columnchoice = currItem.getQuestion().getColumnchoicesList().get(cholumnchoiceIndex);
                        if(columnchoice.getColumnchoiceid().hashCode() == subquestion.getEntry().getCcr_id().hashCode())
                        {
                            entry.setCcr_id(questionResponse.getColumnchoiceresponses().get(cholumnchoiceIndex).getCcr_id());
                            entryDao.save(entry);
                            break;
                        }
                    }
                }
                // multiple
                else
                {
                    entry.setAnswercontent(subquestion.getEntry().getAnswercontent());

                    if(subquestion.getResponseColumnchoiceIds().size() <= 0)
                    {
                        if(subquestion.getEntry().getAnswercontent() != null && !subquestion.getEntry().getAnswercontent().equals(""))
                        {
                            entryDao.save(entry);
                        }
                        continue;
                    }

                    for(int cholumnchoiceIndex = 0; cholumnchoiceIndex < currItem.getQuestion().getColumnchoicesList().size(); cholumnchoiceIndex ++)
                    {
                        Columnchoice columnchoice = currItem.getQuestion().getColumnchoicesList().get(cholumnchoiceIndex);

                        for(String responseColumnchoiceId : subquestion.getResponseColumnchoiceIds())
                        {
                            if(columnchoice.getColumnchoiceid().toString().equals(responseColumnchoiceId))
                            {
                                entry.setCcr_id(questionResponse.getColumnchoiceresponses().get(cholumnchoiceIndex).getCcr_id());
                                if((subquestion.getEntry().getAnswercontent() != null && !subquestion.getEntry().getAnswercontent().equals(""))
                                    || entry.getCcr_id() != null)
                                {
                                    entryDao.save(entry);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * save subquestion.
     * @param subquestion
     * @param questionResponse
     * @param entry 
     */
    private void saveSubquestion(Subquestion subquestion, QuestionResponse questionResponse, Entry entry)
    {
        SubQuestionResponse subQuestionResponse = new SubQuestionResponse(subquestion);
        subQuestionResponse.setQr_id(questionResponse.getQr_id());
        subQuestionResponse = subQuestionResponseDao.save(subQuestionResponse);
        entry.setSqr_id(subQuestionResponse.getSqr_id());
    }
    
    /**
     * save column choice.
     * @param currItem
     * @param questionResponse 
     */
    private void saveColumnChoice(BranchItem currItem, QuestionResponse questionResponse)
    {
        for(Columnchoice columnchoice : currItem.getQuestion().getColumnchoicesList())
        {
            ColumnChoiceResponse columnChoiceResponse = new ColumnChoiceResponse(columnchoice);
            columnChoiceResponse.setQr_id(questionResponse.getQr_id());
            columnChoiceResponse = columnChoiceResponseDao.save(columnChoiceResponse);
            questionResponse.getColumnchoiceresponses().add(columnChoiceResponse);
        }
    }

    /**
     * clean answer.
     * @param surveyJSFModel
     * @param surveyResponse 
     */
    @Transactional(readOnly=false)
    @Override
    public SurveyResponse cleanAnswer(SurveyJSFModel surveyJSFModel, SurveyResponse surveyResponse)
    {
        PageResponse currPage = surveyResponse.getPageresponses().get(surveyResponse.getPageresponses().size() - 1);
        BranchItem currItem = surveyJSFModel.getAnsweringItem();
        List<QuestionResponse> questionResponses = questionResponseDao.getQuestionResponsesByPrid(currPage.getPr_id());
        QuestionResponse currQuestionResponse = null;

        for(QuestionResponse questionResponse : questionResponses)
        {
            if(questionResponse.getQuestionorder() == currItem.getItemorder())
            {
                currQuestionResponse = questionResponse;
                break;
            }
        }
        
        if(currQuestionResponse == null)
        {
            return surveyResponse;
        }
        
        answerResponseDao.removeAnswerResponsesByQrid(currQuestionResponse.getQr_id());
        subQuestionResponseDao.removeSubQuestionResponsesByQrid(currQuestionResponse.getQr_id());
        columnChoiceResponseDao.removeColumnChoiceResponsesByQrid(currQuestionResponse.getQr_id());
        entryDao.removeEntrysByQrid(currQuestionResponse.getQr_id());

        questionResponseDao.remove(currQuestionResponse.getQr_id());
        questionResponses.remove(currQuestionResponse);
        if(questionResponses.isEmpty())
        {
            pageResponseDao.remove(currPage.getPr_id());
            surveyResponse.getPageresponses().remove(currPage);
        }
        List<PageResponse> pageResponses = pageResponseDao.getPageResponsesBySrid(surveyResponse.getSr_id());
        if(pageResponses.isEmpty())
        {
            surveyResponseDao.remove(surveyResponse.getSr_id());
            surveyResponse = new SurveyResponse(surveyJSFModel.getSurvey());
            surveyResponse.getPageresponses().add(new PageResponse(surveyJSFModel.getCurrPage()));
        }
        return surveyResponse;
    }
}
