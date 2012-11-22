/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;
import au.com.satech.wds.dao.AnswerResponseDao;
import au.com.satech.wds.model.AnswerResponse;
import au.com.satech.wds.model.PageResponse;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhao
 */
@Repository("answerResponseDao")
public class AnswerResponseDaoJpa extends GenericDaoJpa<AnswerResponse, Integer> implements AnswerResponseDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public AnswerResponseDaoJpa(){
        super(AnswerResponse.class);
    }

    @Override
    public void removeAnswerResponsesByQrid(Integer qr_id) {
        String hql = "delete from " + AnswerResponse.class.getName() + " as ar where ar.qr_id=" + qr_id;
        getEntityManager().createQuery(hql).executeUpdate();
    }
}
