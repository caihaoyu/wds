/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.PageDao;
import au.com.satech.wds.model.Page;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("pageDao")
public class PageDaoJpa extends GenericDaoJpa<Page, Integer> implements PageDao {

    public PageDaoJpa(){
        super(Page.class);
    }

    public Page savePage(Page page) {
        Page p = super.save(page);
        getEntityManager().flush();
        return p;
    }    
}
