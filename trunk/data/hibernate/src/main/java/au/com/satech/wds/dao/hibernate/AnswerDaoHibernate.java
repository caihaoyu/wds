/*
 * Copyright 2011 sam.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package au.com.satech.wds.dao.hibernate;

import au.com.satech.wds.dao.AnswerDao;
import au.com.satech.wds.model.Answer;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("answerDao")
public class AnswerDaoHibernate extends GenericDaoHibernate<Answer, Integer> implements AnswerDao {
    
    public AnswerDaoHibernate() {
        super(Answer.class);
    }

    public boolean answerExist(Answer answer) {
        return getHibernateTemplate().load(Answer.class, answer.getAnswerid()) != null ? true:false;
    }

    public Answer saveAnswer(Answer answer) {
        getHibernateTemplate().saveOrUpdate(answer);
        getHibernateTemplate().flush();
        return answer;
    }
    
}
