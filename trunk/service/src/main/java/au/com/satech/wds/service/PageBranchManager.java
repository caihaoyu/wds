/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.PageBranch;
import java.util.List;

/**
 *
 * @author sam
 */
public interface PageBranchManager extends GenericManager<PageBranch, Integer> {
    
    public List<BranchItem> getHiddens(Integer pageBranchId);
    /**
    * 获取指定pageBranch下Hidden属性为true的List<BranchItem>
    * @param pageBranchId
    * @param branchItemId 
    * @return List<BranchItem>
    */
    public List<BranchItem> getHiddens(Integer pageBranchId,Integer branchItemId);
    /**
     * 删除指定Pagebranch里指定的branchItem
     * @param itemid branchItemId
     * @param branchid pageBranchId
     */
    public void removeBranchItemFromBranch(Integer itemid, Integer branchid);
    /**
    * 将BranchItem的haveItem属性该为true并赋上指定id保存到指定pageBranch里
    * @param branchid
    * @param questionid 
    */
    public void addQuestionToBranch(Integer branchid, Integer questionid);
    /**
     * 保存BranchItem到指定pageBranch里面并修改其HaveItem属性为true
     * @param branchid
     * @param item 
     */
    public void addItemToBranch(Integer branchid, BranchItem item);
    /**
     * 获取指定pageBranch里面的排序后的List<BranchItem>
     * @param id
     * @return List<BranchItem>
     */
    public List<BranchItem> getBranchItemsByPageBranchId(Integer id);
}
