/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.BranchItemRuleDao;
import au.com.satech.wds.dao.ConditionDao;
import au.com.satech.wds.dao.ResultDao;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Result;
import au.com.satech.wds.service.BranchItemRuleManager;
import au.com.satech.wds.util.RuleNameParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *此类是BranchItemRuleManager的实现类
 * @author wu
 */
@SuppressWarnings("serial")
@Service("branchItemRuleManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class BranchItemRuleManagerImpl extends GenericManagerImpl<BranchItemRule, Integer> implements BranchItemRuleManager{
    BranchItemRuleDao branchItemRuleDao;
    @Autowired
    ConditionDao conditionDao;
    @Autowired
    ResultDao resultDao;
    
    @Autowired
    public BranchItemRuleManagerImpl(BranchItemRuleDao branchItemRuleDao){
        super(branchItemRuleDao);
        this.branchItemRuleDao = branchItemRuleDao;
    }
    
    /**
     * 根据ruleId 获得branchItemRule的result集合，返回一个result的list集合
     * @param ruleId  BranchItem的Id号
     * @return list<Result> rules集合。
     */
    @Override
    public List<Result> getResultsById(Integer ruleId) {
        List<Result> list=new ArrayList<Result>();
        list.addAll(get(ruleId).getResults());
        return list;
    }

    @Transactional(readOnly=false)
    @Override
    public void romveBranchItemRule(Integer ruleId) {
        BranchItemRule rule= branchItemRuleDao.get(ruleId);
        conditionDao.remove(rule.getCondition().getConditionid());
        
        
    }

    @Override
    public String getHTMLRuleTitle(BranchItemRule rule) {
        return RuleNameParser.getParsedName(rule);
    }
    
}
