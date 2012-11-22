/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model.jsf;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.BranchItemRule;
import au.com.satech.wds.model.Result;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhao
 */
public class ViolationRuleJSFModel implements Serializable {
    
    private Integer pageid;
    
    private Integer branchid;
    
    private BranchItem item;
    
    private String violationDiscription;
    
    private BranchItemRule rule;
    
    private List<Result> resultsList = new ArrayList<Result>();
    
    private boolean editRendered = false;

    /**
     * @return the pageid
     */
    public Integer getPageid() {
        return pageid;
    }

    /**
     * @param pageid the pageid to set
     */
    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    /**
     * @return the branchid
     */
    public Integer getBranchid() {
        return branchid;
    }

    /**
     * @param branchid the branchid to set
     */
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    /**
     * @return the rule
     */
    public BranchItemRule getRule() {
        return rule;
    }

    /**
     * @param rule the rule to set
     */
    public void setRule(BranchItemRule rule) {
        this.rule = rule;
    }

    /**
     * @return the violationDiscription
     */
    public String getViolationDiscription() {
        return violationDiscription;
    }

    /**
     * @param violationDiscription the violationDiscription to set
     */
    public void setViolationDiscription(String violationDiscription) {
        this.violationDiscription = violationDiscription;
    }

    /**
     * @return the resultsList
     */
    public List<Result> getResultsList() {
        return resultsList;
    }

    /**
     * @param resultsList the resultsList to set
     */
    public void setResultsList(List<Result> resultsList) {
        this.resultsList = resultsList;
    }

    /**
     * @return the editRendered
     */
    public boolean isEditRendered() {
        return editRendered;
    }

    /**
     * @param editRendered the editRendered to set
     */
    public void setEditRendered(boolean editRendered) {
        this.editRendered = editRendered;
    }

    /**
     * @return the item
     */
    public BranchItem getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(BranchItem item) {
        this.item = item;
    }
}
