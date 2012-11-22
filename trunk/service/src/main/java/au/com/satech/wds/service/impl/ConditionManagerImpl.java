/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.ConditionDao;
import au.com.satech.wds.model.Condition;
import au.com.satech.wds.model.Scenario;
import au.com.satech.wds.model.Scenariocc;
import au.com.satech.wds.model.Subquestion;
import au.com.satech.wds.service.ConditionManager;
import au.com.satech.wds.service.ScenarioManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
@SuppressWarnings("serial")
@Service("conditionManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ConditionManagerImpl extends GenericManagerImpl<Condition, Integer> implements ConditionManager {
    ConditionDao conditionDao;
    @Autowired
    ScenarioManager scenarioManager;
    
    @Autowired
    public ConditionManagerImpl(ConditionDao conditionDao){
        super(conditionDao);
        this.conditionDao = conditionDao;
    }

    @Transactional(readOnly=true)
    @Override
    public List<Scenario> getScenarioList(Integer conditionId) {
        List<Scenario> list=new ArrayList<Scenario>();
        Condition condition=conditionDao.get(conditionId);
        list.addAll(condition.getScenarios());
        return list;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Subquestion> getReadySubquestionList(List<Subquestion> list, Condition condition, Integer columntype) {
        Integer[] ids=getArrayScenarioIds(condition);
        if(ids==null){
            return list;
        }
       for(Subquestion subquestion : list){
           List<Scenario> scenarios=scenarioManager.getScenarioListBySubQuestionId(subquestion.getSubquestionid(),ids);
           if(columntype==2&&scenarios.size()==1){
               subquestion.setSelectedStars(scenarios.get(0).getRating());
           }else if(columntype==3&&scenarios.size()==1){
               List<String> strList=new ArrayList<String>();
               Iterator<Scenariocc> itr=scenarios.get(0).getScenarioccs().iterator();
               while(itr.hasNext()){
                   Scenariocc scenariocc=itr.next();
                   strList.add(String.valueOf(scenariocc.getColumnchoiceid()));
               }
               subquestion.setSelectedColumnchoices(strList);
           }
           if(scenarios!=null&&scenarios.size()==1){
           subquestion.setScenarioComparator(scenarios.get(0).getComparator());
           }
       }
        
        return list;
    }
    private Integer[] getArrayScenarioIds(Condition condition){
        if(condition.getScenarioList().size()<=0){
            return null;
        }
        Integer[] array=new Integer[condition.getScenarioList().size()];
        for(int i=0;condition.getScenarioList().size()>i;i++){
            Integer scenarioId=condition.getScenarioList().get(i).getScenarionid();
            array[i]=scenarioId;
        }
        return array;
    }
    
}
