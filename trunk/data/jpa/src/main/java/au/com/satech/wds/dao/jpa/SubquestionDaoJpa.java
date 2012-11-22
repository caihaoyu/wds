/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.SubquestionDao;
import au.com.satech.wds.model.Subquestion;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("SubquestionDao")
public class SubquestionDaoJpa extends GenericDaoJpa<Subquestion, Integer> implements SubquestionDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public SubquestionDaoJpa(){
        super(Subquestion.class);
    }

    public Subquestion saveSubquestion(Subquestion subquestion) {
        Subquestion s = super.save(subquestion);
        getEntityManager().flush();
        return s;
    }
}
