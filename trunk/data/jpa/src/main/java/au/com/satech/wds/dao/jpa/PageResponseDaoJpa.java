/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;
import au.com.satech.wds.dao.PageResponseDao;
import au.com.satech.wds.model.PageResponse;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("pageResponseDao")
public class PageResponseDaoJpa extends GenericDaoJpa<PageResponse, Integer> implements PageResponseDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public PageResponseDaoJpa(){
        super(PageResponse.class);
    }

    @Override
    public List<PageResponse> getPageResponsesBySrid(Integer sr_id) {
        String hql = "from " + PageResponse.class.getName() + " as pr where pr.sr_id=" + sr_id;
        return getEntityManager().createQuery(hql).getResultList();
    }
}
