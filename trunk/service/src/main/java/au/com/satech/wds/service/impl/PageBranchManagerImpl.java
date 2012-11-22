/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.service.impl;

import au.com.satech.wds.dao.BranchItemDao;
import au.com.satech.wds.dao.PageBranchDao;
import au.com.satech.wds.dao.QuestionDao;
import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.model.comparators.BranchItemComparator;
import au.com.satech.wds.service.PageBranchManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 此类是PageBranManager的实现类
 *
 * @author sam
 */
@SuppressWarnings("serial")
@Service("pageBranchManager")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class PageBranchManagerImpl extends GenericManagerImpl<PageBranch, Integer> implements PageBranchManager {

    PageBranchDao pbDao;
    @Autowired
    BranchItemDao iDao;
    @Autowired
    QuestionDao qDao;

    @Autowired
    public PageBranchManagerImpl(PageBranchDao pbDao) {
        super(pbDao);
        this.pbDao = pbDao;
    }

    /**
     * 获取指定pageBranch下Hidden属性为true的List<BranchItem>
     *
     * @param pageBranchId
     * @return List<BranchItem>
     */
    @Transactional(readOnly = true)
    @Override
    public List<BranchItem> getHiddens(Integer pageBranchId, Integer branchItemId) {
        List<BranchItem> items = getBranchItemsByPageBranchId(pageBranchId);
        List<BranchItem> hiddens = new ArrayList<BranchItem>();
        //循环迭代list集合判断里面每个branchItem的hidden属性如果是true则添加到一个新的BranchItem集合
        boolean isTrueItem = false;
        for (BranchItem item : items) {
            if (isTrueItem) {
                if (item.isHidden()) {
                    hiddens.add(item);
                }
            }
            if (item.getBranchitemid().equals(branchItemId)) {
                isTrueItem = true;
            }
        }
        return hiddens;
    }

    /**
     * 删除指定Pagebranch里指定的branchItem
     *
     * @param itemid branchItemId
     * @param branchid pageBranchId
     */
    @Transactional(readOnly = false)
    @Override
    public void removeBranchItemFromBranch(Integer itemid, Integer branchid) {
        BranchItem item = iDao.get(itemid);
        PageBranch pageBranch = super.get(branchid);
        pageBranch.getItems().remove(item);
        super.save(pageBranch);
        iDao.remove(itemid);
        Integer questionid = item.getQuestionid();
    }

    /**
     * 将BranchItem的haveItem属性该为true并赋上指定id保存到指定pageBranch里
     *
     * @param branchid
     * @param questionid
     */
    @Transactional(readOnly = false)
    @Override
    public void addQuestionToBranch(Integer branchid, Integer questionid) {
        PageBranch branch = pbDao.get(branchid);
        // create new branch item
        BranchItem item = new BranchItem();
        item.setItemorder(branch.getItems().size() + 1);
        item.setHidden(false);
        // attach question to item
        item.setQuestionid(questionid);
        // save item
        item = iDao.save(item);
        // attach item to branch
        branch.getItems().add(item);
        if (!branch.isHaveItem()) {
            branch.setHaveItem(true);
        }
        // save branch
        pbDao.save(branch);

    }

    /**
     * 给List<BranchItem>的所有Id从新赋值并返回
     *
     * @param items
     * @return List<BranchItem>
     */
    private List<BranchItem> reorderItems(List<BranchItem> items) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setItemorder(i + 1);
        }
        return items;
    }

    /**
     * 获取指定pageBranch里面的排序后的List<BranchItem>
     *
     * @param id
     * @return List<BranchItem>
     */
    @Transactional(readOnly = true)
    @Override
    public List<BranchItem> getBranchItemsByPageBranchId(Integer id) {
        PageBranch pb = dao.get(id);
        List<BranchItem> list = new ArrayList<BranchItem>();
        list.addAll(pb.getItems());
        Collections.sort(list, new BranchItemComparator());
        return list;

    }

    /**
     * 保存BranchItem到指定pageBranch里面并修改其HaveItem属性为true
     *
     * @param branchid
     * @param item
     */
    @Transactional(readOnly = false)
    @Override
    public void addItemToBranch(Integer branchid, BranchItem item) {
        PageBranch branch = pbDao.get(branchid);
        // create new branch item
        // attach item to branch
        branch.getItems().add(item);
        if (!branch.isHaveItem()) {
            branch.setHaveItem(true);
        }
        // save branch
        pbDao.save(branch);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BranchItem> getHiddens(Integer pageBranchId) {
        List<BranchItem> items = getBranchItemsByPageBranchId(pageBranchId);
        List<BranchItem> hiddens = new ArrayList<BranchItem>();
        for (BranchItem item : items) {
            if (item.isHidden()) {
                hiddens.add(item);
            }
        }
        return hiddens;
    }
}
