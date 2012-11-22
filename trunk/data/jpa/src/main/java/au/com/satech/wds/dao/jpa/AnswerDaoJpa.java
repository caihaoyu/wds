/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.dao.jpa;

import au.com.satech.wds.dao.AnswerDao;
import au.com.satech.wds.model.Answer;
import au.com.satech.wds.model.Question;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("answerDao")
public class AnswerDaoJpa extends GenericDaoJpa<Answer, Integer> implements AnswerDao {
    /**
     * Constructor that sets the entity to User.class.
     */
    public AnswerDaoJpa(){
        super(Answer.class);
    }

    public Answer saveAnswer(Answer answer) {
        Answer a = super.save(answer);
        getEntityManager().flush();
        return a;
    }
}
