/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;
import au.com.satech.wds.dao.QuestionResponseDao;
import au.com.satech.wds.model.QuestionResponse;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zhao
 */
@Repository("questionResponseDao")
public class QuestionResponseDaoJpa extends GenericDaoJpa<QuestionResponse, Integer> implements QuestionResponseDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public QuestionResponseDaoJpa(){
        super(QuestionResponse.class);
    }

    @Override
    public List<QuestionResponse> getQuestionResponsesByPrid(Integer pr_id)
    {
        String hql = "from " + QuestionResponse.class.getName() + " as qr where qr.pr_id=" + pr_id;
        return getEntityManager().createQuery(hql).getResultList();
    }
}
