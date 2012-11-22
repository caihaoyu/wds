/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author sam
 */
@Entity
@Table(name="entry")
public class Entry extends BaseObject implements java.io.Serializable {
    private Integer entryid;
    private Integer qr_id;
    private Integer sqr_id;
    private Integer ar_id;
    private Integer ccr_id;
    private Integer rating;
    private String answercontent;
    
    public Entry(){
        
    }
    
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("Entry ID: ", this.entryid)
                .append("Question Response ID: ", this.qr_id)
                .append("Subquestion Response ID: ", this.sqr_id)
                .append("Answer Response ID: ", this.ar_id)
                .append("Column Choice Response ID: ", this.ccr_id)
                .append("Rating: ", this.rating)
                .append("Answer Content: ", this.getAnswercontent());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entry)) {
            return false;
        }

        final Entry e = (Entry) o;

        return !(entryid != null ? !(entryid == e.getEntryid()) : e.getEntryid() != null);
    }

    @Override
    public int hashCode() {
        return (entryid != null ? entryid.hashCode() : 0);
    }

    /**
     * @return the entryid
     */
    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="entryid", unique=true, nullable=false)
    public Integer getEntryid() {
        return entryid;
    }

    /**
     * @param entryid the entryid to set
     */
    public void setEntryid(Integer entryid) {
        this.entryid = entryid;
    }

    /**
     * @return the answercontent
     */
    @Column(name="answercontent",columnDefinition="TEXT")
    public String getAnswercontent() {
        return answercontent;
    }

    /**
     * @param answercontent the answercontent to set
     */
    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent;
    }

    /**
     * @return the rating
     */
    @Column
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * @return the qr_id
     */
    @Column
    public Integer getQr_id() {
        return qr_id;
    }

    /**
     * @param qr_id the qr_id to set
     */
    public void setQr_id(Integer qr_id) {
        this.qr_id = qr_id;
    }

    /**
     * @return the sqr_id
     */
    @Column
    public Integer getSqr_id() {
        return sqr_id;
    }

    /**
     * @param sqr_id the sqr_id to set
     */
    public void setSqr_id(Integer sqr_id) {
        this.sqr_id = sqr_id;
    }

    /**
     * @return the ar_id
     */
    @Column
    public Integer getAr_id() {
        return ar_id;
    }

    /**
     * @param ar_id the ar_id to set
     */
    public void setAr_id(Integer ar_id) {
        this.ar_id = ar_id;
    }

    /**
     * @return the ccr_id
     */
    @Column
    public Integer getCcr_id() {
        return ccr_id;
    }

    /**
     * @param ccr_id the ccr_id to set
     */
    public void setCcr_id(Integer ccr_id) {
        this.ccr_id = ccr_id;
    }

}
