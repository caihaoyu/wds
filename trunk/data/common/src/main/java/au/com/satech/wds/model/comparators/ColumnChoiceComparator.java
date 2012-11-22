/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.com.satech.wds.model.comparators;

import au.com.satech.wds.model.Columnchoice;
import java.util.Comparator;

/**
 *
 * @author sam
 */
public class ColumnChoiceComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        int columnChoiceOrder1 = ((Columnchoice)o1).getColumnchoiceorder();
        int columnChoiceOrder2 = ((Columnchoice)o2).getColumnchoiceorder();
        if(columnChoiceOrder1<columnChoiceOrder2) return -1;
        if(columnChoiceOrder2<columnChoiceOrder1) return 1;
        return 0;
    }

}
