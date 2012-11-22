/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.com.satech.wds.model.comparators;

import au.com.satech.wds.model.Answer;
import java.util.Comparator;

/**
 *
 * @author sam
 */
public class MultipleAnswerComparator implements Comparator  {
    public int compare(Object o1, Object o2) {
        int answerOrder1 = ((Answer)o1).getAnswerorder();
        int answerOrder2 = ((Answer)o2).getAnswerorder();
        if(answerOrder1<answerOrder2) return -1;
        if(answerOrder2<answerOrder1) return 1;
        return 0;
    }
}
