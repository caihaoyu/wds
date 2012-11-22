/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Transient;

/**
 *
 * @author zhao
 */
@Entity
@Table(name="pageresponse")
public class PageResponse extends BaseObject implements java.io.Serializable {
    private Integer pr_id;
    private Integer sr_id;
    private Integer pageorder;
    private String pagetitle;
    private String pageheader;
    private String pagefooter;
    private List<QuestionResponse> questionresponses = new ArrayList<QuestionResponse>();

    
    public PageResponse(){
        
    }
    
    public PageResponse(Page page){
        this.pageorder = page.getPageorder();
        this.pagetitle = page.getPagetitle();
        this.pageheader = page.getPageheader();
        this.pagefooter = page.getPagefooter();
    }
    
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("page response id", this.pr_id)
                .append("page sr_id",this.sr_id)
                .append("page order", this.getPageorder())
                .append("page title", this.getPagetitle())
                .append("page header",this.pageheader)
                .append("page footer",this.pagefooter);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PageResponse)) {
            return false;
        }

        final PageResponse r = (PageResponse) o;

        return !(pr_id != null ? !(pr_id == r.getPr_id()) : r.getPr_id() != null);
    }

    @Override
    public int hashCode() {
        return (getPr_id() != null ? getPr_id().hashCode() : 0);
    }

    /**
     * @return the pr_id
     */
    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="pr_id", unique=true, nullable=false)
    public Integer getPr_id() {
        return pr_id;
    }

    /**
     * @param pr_id the pr_id to set
     */
    public void setPr_id(Integer pr_id) {
        this.pr_id = pr_id;
    }

    /**
     * @return the pageorder
     */
    @Column
    public Integer getPageorder() {
        return pageorder;
    }

    /**
     * @param pageorder the pageorder to set
     */
    public void setPageorder(Integer pageorder) {
        this.pageorder = pageorder;
    }

    /**
     * @return the pagetitle
     */
    @Column
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
    @Column
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
    @Column
    public String getPagefooter() {
        return pagefooter;
    }

    /**
     * @param pagefooter the pagefooter to set
     */
    public void setPagefooter(String pagefooter) {
        this.pagefooter = pagefooter;
    }

    /**
     * @return the questionresponses
     */
    @Transient
    public List<QuestionResponse> getQuestionresponses() {
        return questionresponses;
    }

    /**
     * @param questionresponses the questionresponses to set
     */
    public void setQuestionresponses(List<QuestionResponse> questionresponses) {
        this.questionresponses = questionresponses;
    }

    /**
     * @return the sr_id
     */
    @Column
    public Integer getSr_id() {
        return sr_id;
    }

    /**
     * @param sr_id the sr_id to set
     */
    public void setSr_id(Integer sr_id) {
        this.sr_id = sr_id;
    }

}
