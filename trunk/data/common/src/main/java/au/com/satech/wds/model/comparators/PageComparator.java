/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model.comparators;

import au.com.satech.wds.model.Page;
import java.util.Comparator;

/**
 *
 * @author sam
 */
public class PageComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int pageOrder1 = ((Page)o1).getPageorder();
        int pageOrder2 = ((Page)o2).getPageorder();
        if(pageOrder1<pageOrder2) return -1;
        if(pageOrder2<pageOrder1) return 1;
        return 0;
    }
    
}
