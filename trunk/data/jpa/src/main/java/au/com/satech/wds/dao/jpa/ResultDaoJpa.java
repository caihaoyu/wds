/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.ResultDao;
import au.com.satech.wds.model.Result;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("resultDao")
public class ResultDaoJpa extends GenericDaoJpa<Result, Integer> implements ResultDao {
    
    public ResultDaoJpa(){
        super(Result.class);
    }
}
