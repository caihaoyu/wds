/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service;

import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import java.util.List;

/**
 *
 * @author sam
 */
public interface PageManager extends GenericManager<Page, Integer> {
    /**
     * 获取指定Page下的PageBranch集合
     * @param pageid 
     * @return pageBranchList
     */
    public List<PageBranch> getPageBranchsByPageId(Integer pageid);
   /**
    * 保存带有pageBranches集合属性的Page对象
    * @param pageId Page对象的Id属性
    * @param newBranch 需要添加的Branch对象
    */
    public void savePageBranchWithPage(Integer pageId,PageBranch newBranch);
    public Page getPageTillRule(Integer pId);
    public void setDefaultBranch(Integer pageId, PageBranch targetBranch);
}
