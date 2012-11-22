/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;
import au.com.satech.wds.dao.ColumnChoiceResponseDao;
import au.com.satech.wds.model.ColumnChoiceResponse;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhao
 */
@Repository("columnChoiceResponseDao")
public class ColumnChoiceResponseDaoJpa extends GenericDaoJpa<ColumnChoiceResponse, Integer> implements ColumnChoiceResponseDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public ColumnChoiceResponseDaoJpa(){
        super(ColumnChoiceResponse.class);
    }

    @Override
    public void removeColumnChoiceResponsesByQrid(Integer qr_id) {
        String hql = "delete from " + ColumnChoiceResponse.class.getName() + " as ccr where ccr.qr_id=" + qr_id;
        getEntityManager().createQuery(hql).executeUpdate();
    }
}
