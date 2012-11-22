/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.ScenarioDao;
import au.com.satech.wds.model.Scenario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cai
 */
@Repository("scenarioDao")
public class ScenarioDaoJpa extends GenericDaoJpa<Scenario, Integer> implements ScenarioDao{

    public ScenarioDaoJpa(){
        super(Scenario.class);
    }

    @Override
     public List<Scenario> getScenarioListBySubQuestionId(Integer subQuestionId,Integer[] scenarioIds){
        String hql="from "+Scenario.class.getName()+" as s where s.subquestionId='" + subQuestionId+"' and s.scenarionid in :scenarioIds ";
        Query query=  getEntityManager().createQuery(hql,Scenario.class);
        List<Integer> ids=new ArrayList<Integer>();
        ids.addAll(Arrays.asList(scenarioIds));
        query.setParameter("scenarioIds", ids);
        return query.getResultList();
    }
}
