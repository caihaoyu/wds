/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author sam
 */
@Entity
@Table(name="pagebranch")
public class PageBranch extends BaseObject implements java.io.Serializable {
    private Integer branchid;
    private String branchname;
    private Set<BranchItem> items = new HashSet<BranchItem>();
    private List<BranchItem> itemList=new ArrayList<BranchItem>();
    private Boolean main;
    private boolean haveItem;
    
    public PageBranch(){
        
    }
    
    public PageBranch(Integer branchid, String branchname, Set<BranchItem> items){
        this.branchid = branchid;
        this.branchname = branchname;
        this.items = items;
    }

    public PageBranch(String branchname, Boolean main, boolean haveItem, Set<BranchItem> items, List<BranchItem> itemsList) {
        this.branchname = branchname;
        this.main = main;
        this.haveItem = haveItem;
        this.items = items;
        this.itemList = itemsList;
    }
    

    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("page branch id", this.branchid)
                .append("page branch name",this.branchname)
                .append("page is Main",this.main)
                .append("page is haveItem",this.haveItem);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PageBranch)) {
            return false;
        }

        final PageBranch pageBranch = (PageBranch) o;

        return !(branchid != null ? !(branchid == pageBranch.getBranchid()) : pageBranch.getBranchid() != null);
    }

    @Override
    public int hashCode() {
        return (branchid != null ? branchid.hashCode() : 0);
    }

    /**
     * @return the branchid
     */
@Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="branchid", unique=true, nullable=false)
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
     * @return the branchname
     */
    @Column(name="branchname", length=200)
    public String getBranchname() {
        return branchname;
    }

    /**
     * @param branchname the branchname to set
     */
    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    /**
     * @return the main
     */
    @Column(name="main", nullable=false)
    public Boolean getMain() {
        return main;
    }

    /**
     * @param main the main to set
     */
    public void setMain(Boolean main) {
        this.main = main;
    }

    @Column(name="have_item",nullable=false)
    public boolean isHaveItem() {
        return haveItem;
    }

    public void setHaveItem(boolean haveItem) {
        this.haveItem = haveItem;
    }
    
    

    /**
     * @return the items
     */
    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable(name="pagebranch_branchitem", joinColumns = { 
        @JoinColumn(name="branchid", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="branchitemid", nullable=false, updatable=false) })
    public Set<BranchItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Set<BranchItem> items) {
        this.items = items;
    }

    @Transient
    public List<BranchItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BranchItem> itemList) {
        this.itemList = itemList;
    }
   
}
