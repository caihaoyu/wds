/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.com.satech.wds.model.comparators;

import au.com.satech.wds.model.Subquestion;
import java.util.Comparator;

/**
 *
 * @author sam
 */
public class SubQuestionComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        int subQuestionOrder1 = ((Subquestion)o1).getSubquestionorder();
        int subQuestionOrder2 = ((Subquestion)o2).getSubquestionorder();
        if(subQuestionOrder1<subQuestionOrder2) return -1;
        if(subQuestionOrder2<subQuestionOrder1) return 1;
        return 0;
    }

}
