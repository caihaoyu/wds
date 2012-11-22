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
 * @author zhao
 */
@Entity
@Table(name="subquestionresponse")
public class SubQuestionResponse extends BaseObject implements java.io.Serializable {
    private Integer sqr_id;
    private Integer qr_id;
    private Integer subquestionorder;
    private String subquestiontitle;
    
    public SubQuestionResponse(){
        
    }
    
    public SubQuestionResponse(Subquestion subquestion){
        this.subquestionorder = subquestion.getSubquestionorder();
        this.subquestiontitle = subquestion.getSubquestiontitle();
    }
    
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("Sub Question Response ID: ", this.getSqr_id())
                .append("Question Response ID: ", this.getQr_id())
                .append("Sub Question Order: ", this.getSubquestionorder())
                .append("Sub Question Title: ", this.getSubquestiontitle());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubQuestionResponse)) {
            return false;
        }

        final SubQuestionResponse e = (SubQuestionResponse) o;

        return !(sqr_id != null ? !(sqr_id == e.getSqr_id()) : e.getSqr_id() != null);
    }

    @Override
    public int hashCode() {
        return (getSqr_id() != null ? getSqr_id().hashCode() : 0);
    }

    /**
     * @return the sqr_id
     */
    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="sqr_id", unique=true, nullable=false)
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
     * @return the subquestionorder
     */
    @Column
    public Integer getSubquestionorder() {
        return subquestionorder;
    }

    /**
     * @param subquestionorder the subquestionorder to set
     */
    public void setSubquestionorder(Integer subquestionorder) {
        this.subquestionorder = subquestionorder;
    }

    /**
     * @return the subquestiontitle
     */
    @Column
    public String getSubquestiontitle() {
        return subquestiontitle;
    }

    /**
     * @param subquestiontitle the subquestiontitle to set
     */
    public void setSubquestiontitle(String subquestiontitle) {
        this.subquestiontitle = subquestiontitle;
    }

}
