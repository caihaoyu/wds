/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.ResponseDao;
import au.com.satech.wds.model.QuestionResponse;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("responseDao")
public class ResponseDaoJpa extends GenericDaoJpa<QuestionResponse, Integer> implements ResponseDao {
    public ResponseDaoJpa(){
        super(QuestionResponse.class);
    }
}
