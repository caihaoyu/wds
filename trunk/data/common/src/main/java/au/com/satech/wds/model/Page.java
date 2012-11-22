package au.com.satech.wds.model;
// Generated 27/04/2011 2:03:13 AM by Hibernate Tools 3.2.1.GA


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
 * Page generated by hbm2java
 */
@Entity
@Table(name="page")
public class Page extends BaseObject implements java.io.Serializable {
     private Integer pageid;
     private Integer pageorder;
     private String pagetitle;
     private String pageheader;
     private String pagefooter;
     private Set<PageBranch> pagebranches = new HashSet<PageBranch>();
     private List<PageBranch> pageBranchList=new ArrayList<PageBranch>();

    public Page() {
    }

    public Page(Integer pageorder, String pagetitle, String pageheader, String pagefooter, Set<PageBranch> pagebranches) {
       this.pageorder = pageorder;
       this.pagetitle = pagetitle;
       this.pageheader = pageheader;
       this.pagefooter = pagefooter;
       this.pagebranches = pagebranches;
    }

    public Page(Integer pageorder, String pagetitle, String pageheader, String pagefooter, Set<PageBranch> pagebranches, List<PageBranch> pageBranchList) {
       this.pageorder = pageorder;
       this.pagetitle = pagetitle;
       this.pageheader = pageheader;
       this.pagefooter = pagefooter;
       this.pagebranches = pagebranches;
       this.pageBranchList = pageBranchList;
    }
   
@Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="pageid", unique=true, nullable=false)
    public Integer getPageid() {
        return this.pageid;
    }
    
    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    @Column(name="pageorder")
    public Integer getPageorder() {
        return this.pageorder;
    }
    
    public void setPageorder(Integer pageorder) {
        this.pageorder = pageorder;
    }
    
    
    /**
     * @return the pagetitle
     */
    @Column(name="pagetitle", length=200)
    public String getPagetitle() {
        return pagetitle;
    }

    /**
     * @param pagetitle the pagetitle to set
     */
    public void setPagetitle(String pagetitle) {
        this.pagetitle = pagetitle;
    }

    /**
     * @return the pageheader
     */
    @Column(name="pageheader", length=600)
    public String getPageheader() {
        return pageheader;
    }

    /**
     * @param pageheader the pageheader to set
     */
    public void setPageheader(String pageheader) {
        this.pageheader = pageheader;
    }

    /**
     * @return the pagefooter
     */
    @Column(name="pagefooter", length=600)
    public String getPagefooter() {
        return pagefooter;
    }

    /**
     * @param pagefooter the pagefooter to set
     */
    public void setPagefooter(String pagefooter) {
        this.pagefooter = pagefooter;
    }

    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("page id", this.pageid)
                .append("page order",this.pageorder)
                .append("page title", this.pagetitle)
                .append("page header",this.pageheader)
                .append("page footer",this.pagefooter)
                .append("pageBranchList",this.pageBranchList);
        return sb.toString();
    }


    @Override
    public int hashCode() {
        return (pageid != null ? pageid.hashCode() : 0);
    }

    /**
     * @return the pagebranches
     */
@OneToMany(cascade=CascadeType.ALL)
@JoinTable(
            name = "page_branch",
            joinColumns = { @JoinColumn(name = "pageid") },
            inverseJoinColumns = @JoinColumn(name = "branchid")
    )
    public Set<PageBranch> getPagebranches() {
        return pagebranches;
    }

    /**
     * @param pagebranches the pagebranches to set
     */
    public void setPagebranches(Set<PageBranch> pagebranches) {
        this.pagebranches = pagebranches;
    }

    @Transient
    public List<PageBranch> getPageBranchList() {
        return pageBranchList;
    }

    public void setPageBranchList(List<PageBranch> pageBranchList) {
        this.pageBranchList = pageBranchList;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Page)) {
            return false;
        }

        final Page page = (Page) o;

        return !(pageid != null ? !(pageid == page.getPageid()) : page.getPageid() != null);
    }

}