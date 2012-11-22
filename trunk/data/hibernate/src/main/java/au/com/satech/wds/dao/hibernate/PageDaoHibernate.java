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

import au.com.satech.wds.dao.PageDao;
import au.com.satech.wds.model.Page;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sam
 */
@Repository("pageDao")
public class PageDaoHibernate extends GenericDaoHibernate<Page, Integer> implements PageDao {
    public PageDaoHibernate() {
        super(Page.class);
    }

}