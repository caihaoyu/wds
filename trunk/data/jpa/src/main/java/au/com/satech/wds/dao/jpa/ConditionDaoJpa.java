/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.ConditionDao;
import au.com.satech.wds.model.Condition;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("conditionDao")
public class ConditionDaoJpa extends GenericDaoJpa<Condition, Integer> implements ConditionDao {
    
    public ConditionDaoJpa(){
        super(Condition.class);
    }
}
