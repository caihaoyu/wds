/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.BranchItemDao;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Scenario;
import au.com.satech.wds.model.Scenariocc;
import au.com.satech.wds.service.BranchItemManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *BranchItemManager的实现类
 * @author sam
 */
@SuppressWarnings("serial")
@Service("branchItemManager")
@Scope("singleton")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class BranchItemManagerImpl extends GenericManagerImpl<BranchItem, Integer> implements BranchItemManager {
    BranchItemDao iDao;
    
    @Autowired
    public BranchItemManagerImpl(BranchItemDao iDao){
        super(iDao);
        this.iDao = iDao;
    }

    /**
     *获得指定branchItem下的List<BranchItemRule>
     * @param id  
     * @return List<BranchItemRule>
     */
    @Override
    @Transactional(readOnly=true)
    public List<BranchItemRule> getRulesByItemId(Integer id) {
        BranchItem bi=iDao.get(id);
        List<BranchItemRule> list=new ArrayList<BranchItemRule>();
        list.addAll(bi.getRules());
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public List<BranchItemRule> getRulesListTillScenariocc(Integer id) {
        List<BranchItemRule> list=getRulesByItemId(id);
        for(BranchItemRule rule:list){
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
        }
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public String getRuleNamebyItemId(Integer itemid) {
        return iDao.get(itemid).getRules().get(0).getRulename();
    }
    @Transactional(readOnly=true)
    @Override
    public BranchItemRule getRuleNotTill(Integer id){
        return iDao.get(id).getRules().get(0);
    }

    @Transactional(readOnly=true)
    @Override
    public BranchItemRule getRule(Integer id) {
      List<BranchItemRule> rules=getRulesListTillScenariocc(id);
      BranchItemRule rule= rules!=null&&rules.size()>0?rules.get(0):null;
        return rule;
    }

    @Transactional(readOnly=true)
    @Override
    public boolean isQuestionInUse(Integer questionId) {
        List<BranchItem> itemsList = iDao.getAll();
        
        for(BranchItem item : itemsList)
        {
            if(item.getQuestionid().hashCode() == questionId.hashCode())
            {
                return true;
            }
        }
        return false;
    }
    
}
