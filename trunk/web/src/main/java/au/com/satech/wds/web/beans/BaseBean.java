/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans;

import au.com.satech.wds.web.util.MessageBundleLoader;

import java.io.Serializable;
import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.model.SelectItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author sam
 */
public abstract class BaseBean implements Serializable {
    protected final Log log = LogFactory.getLog(getClass());
    
     /**
     * Utility method for building SelectItem[] from a series of
     * localised entries in a MessageBundle. The SelectItem value
     * is the MessageBundle key, and the label is the localised
     * MessageBundle value.
     *
     * @param prefix Beginning part of the MessageBundle key
     * @param suffix Ending part of the MessageBundle key
     * @param first First number of the series
     * @param last Lat number of the series
     */
    protected static SelectItem[] buildSelectItemArray(
            String prefix, String suffix, int first, int last) {
        int num = last - first + 1;
        SelectItem[] ret = new SelectItem[num];
        for(int i = 0; i < num; i++) {
            String key = prefix + Integer.toString(first+i) + suffix;
            ret[i] = buildSelectItem(key);
        }
        return ret;
    }
    
    protected static SelectItem buildSelectItem(String key) {
        return new SelectItem(
                key, MessageBundleLoader.getMessage(key));
    }
    
    public UIComponent findComponent(UIComponent c, String id) {
        if (id.equals(c.getId())) {
          return c;
        }
        Iterator<UIComponent> kids = c.getFacetsAndChildren();
        while (kids.hasNext()) {
          UIComponent found = findComponent(kids.next(), id);
          if (found != null) {
            return found;
          }
        }
        return null;
      }
}
