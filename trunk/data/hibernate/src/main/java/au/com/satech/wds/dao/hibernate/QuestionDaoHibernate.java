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

import au.com.satech.wds.dao.QuestionDao;
import au.com.satech.wds.model.Question;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("questionDao")
public class QuestionDaoHibernate extends GenericDaoHibernate<Question, Integer> implements QuestionDao {
    public QuestionDaoHibernate() {
        super(Question.class);
    }
    
    public Question saveQuestion(Question question){
        getHibernateTemplate().saveOrUpdate(question);
        getHibernateTemplate().flush();
        return question;
    }
}
