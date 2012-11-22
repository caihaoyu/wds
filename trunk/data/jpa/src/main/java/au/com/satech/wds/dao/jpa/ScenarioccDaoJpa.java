/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.ScenarioccDao;
import au.com.satech.wds.model.Scenariocc;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cai
 */
@Repository("scenarioccDao")
public class ScenarioccDaoJpa extends GenericDaoJpa<Scenariocc, Integer> implements ScenarioccDao{

    public ScenarioccDaoJpa(){
        super(Scenariocc.class);
    }
    
}
