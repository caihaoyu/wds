/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.ColumnchoiceDao;
import au.com.satech.wds.model.Columnchoice;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("ColumnchoiceDao")
public class ColumnchoiceDaoJpa extends GenericDaoJpa<Columnchoice, Integer> implements ColumnchoiceDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public ColumnchoiceDaoJpa(){
        super(Columnchoice.class);
    }

    public Columnchoice saveColumnchoice(Columnchoice columnchoice) {
        Columnchoice c = super.save(columnchoice);
        getEntityManager().flush();
        return c;
    }
    
    
}
