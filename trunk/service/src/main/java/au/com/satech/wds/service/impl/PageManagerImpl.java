/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.PageBranchDao;
import au.com.satech.wds.dao.PageDao;
import au.com.satech.wds.dao.QuestionDao;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.Scenario;
import au.com.satech.wds.model.comparators.BranchItemComparator;
import au.com.satech.wds.service.PageManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * PageManager接口的实现类
 * @author sam
 */
@SuppressWarnings("serial")
@Service("pageManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class PageManagerImpl extends GenericManagerImpl<Page, Integer> implements PageManager {
    PageDao pageDao;
    
    @Autowired
    QuestionDao questionDao;
    @Autowired
    PageBranchDao pbDao;
    
    @Autowired
    public PageManagerImpl(PageDao pageDao){
        super(pageDao);
        this.pageDao = pageDao;
    }
    /**
     * 获取指定Page下的PageBranch集合
     * @param pageid 
     * @return pageBranchList
     */
    @Transactional(readOnly=true)
    @Override
    public List<PageBranch> getPageBranchsByPageId(Integer pageid) {
        Page page=dao.get(pageid);
        List<PageBranch> list=new ArrayList<PageBranch>();
        //获取page的PageBranch对象集合属性添加到一个list集合
        list.addAll(page.getPagebranches());
        return list;
    }
   /**
    * 保存pageBranche到指定的Page里
    * @param pageId 
    * @param newBranch 需要添加的Branch对象
    */ 
    @Transactional
    @Override
    public void savePageBranchWithPage(Integer pageId, PageBranch newBranch) {
        Page page=dao.get(pageId);
        page.getPagebranches().add(newBranch);
        dao.save(page);
    }

    @Override
    @Transactional(readOnly=true)
    public Page getPageTillRule(Integer pId) {
       Page p=pageDao.get(pId);
       List<PageBranch> branchs=new ArrayList<PageBranch>();
       branchs.addAll(p.getPagebranches());
              for (PageBranch branch : branchs) {
                if(branch.isHaveItem()){
                List<BranchItem> items = new ArrayList<BranchItem>();
                items.addAll(branch.getItems());
                for(int i=0;i<items.size();i++){
                    BranchItem item=items.get(i);
                    int size= item.getRules().size();
                    item.setQuestion(questionDao.get(item.getQuestionid()));
                    items.set(i, item);
                    if(size>0){
                        item.setHasRules(true);
                        item.setRulesSize(1);
                        BranchItemRule rule=item.getRules().get(0);
                        List<Scenario> sceanrioList=new ArrayList<Scenario>();
                        sceanrioList.addAll(rule.getCondition().getScenarios());
                        rule.getCondition().setScenarioList(sceanrioList);
                        item.setRule(rule);
                        items.set(i, item);
                    }
                }
                Collections.sort(items,new BranchItemComparator());
                branch.setItemList(items);
                }
                
            }
            p.setPageBranchList(branchs);
            return p;
    }

    @Override
    @Transactional(readOnly=false)
    public void setDefaultBranch(Integer pageId, PageBranch targetBranch) {
        Page page = dao.get(pageId);
        for(PageBranch branch:page.getPagebranches()){
            branch.setMain(Boolean.FALSE);
            pbDao.save(branch);
        }
        targetBranch.setMain(Boolean.TRUE);
        pbDao.save(targetBranch);
    }
}
