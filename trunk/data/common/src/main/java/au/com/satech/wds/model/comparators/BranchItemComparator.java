/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model.comparators;

import au.com.satech.wds.model.BranchItem;
import java.util.Comparator;

/**
 * 该类用于比较BranchItem的比较器
 * 根据BranchItem的Itemorder属性的大小来比较
 * @author sam
 */
public class BranchItemComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int branchItem1Order = ((BranchItem)o1).getItemorder();
        int branchItem2Order = ((BranchItem)o2).getItemorder();
        if(branchItem1Order<branchItem2Order) return -1;
        if(branchItem2Order<branchItem1Order) return 1;
        return 0;
    }
    
}
