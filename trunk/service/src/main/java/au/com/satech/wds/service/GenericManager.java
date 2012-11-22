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
package au.com.satech.wds.service;

import au.com.satech.wds.dao.support.SearchTemplate;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sam
 */
public interface GenericManager<T, PK extends Serializable> {
    List<T> getAll();
    
    T get(PK id);
    
    boolean exists(PK id);
    
    T save(T object);
    
    void remove(PK id);
    
   List<T> find(T model, SearchTemplate searchTemplate);
    
    int findCount(T model, SearchTemplate searchTemplate);
}
