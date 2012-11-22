/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.EntryDao;
import au.com.satech.wds.model.Entry;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("entryDao")
public class EntryDaoJpa extends GenericDaoJpa<Entry, Integer> implements EntryDao {
    
    public EntryDaoJpa(){
        super(Entry.class);
    }

    @Override
    public void removeEntrysByQrid(Integer qr_id) {
        String hql = "delete from " + Entry.class.getName() + " as e where e.qr_id=" + qr_id;
        getEntityManager().createQuery(hql).executeUpdate();
    }
}
