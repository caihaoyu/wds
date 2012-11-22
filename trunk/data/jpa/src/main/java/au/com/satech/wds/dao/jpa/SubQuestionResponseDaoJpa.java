/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;
import au.com.satech.wds.dao.SubQuestionResponseDao;
import au.com.satech.wds.model.SubQuestionResponse;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("subQuestionResponseDao")
public class SubQuestionResponseDaoJpa extends GenericDaoJpa<SubQuestionResponse, Integer> implements SubQuestionResponseDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public SubQuestionResponseDaoJpa(){
        super(SubQuestionResponse.class);
    }

    @Override
    public void removeSubQuestionResponsesByQrid(Integer qr_id) {
        String hql = "delete from " + SubQuestionResponse.class.getName() + " as sqr where sqr.qr_id=" + qr_id;
        getEntityManager().createQuery(hql).executeUpdate();
    }
}
