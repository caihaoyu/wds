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
@Table(name="columnchoiceresponse")
public class ColumnChoiceResponse extends BaseObject implements java.io.Serializable {
    private Integer ccr_id;
    private Integer qr_id;
    private Integer columnchoiceorder;
    private String columnchoicetitle;
    
    public ColumnChoiceResponse(){
        
    }
    
    public ColumnChoiceResponse(Columnchoice columnchoice){
        this.columnchoiceorder = columnchoice.getColumnchoiceorder();
        this.columnchoicetitle = columnchoice.getColumnchoicetitle();
    }
    
    
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("Column Choice Response ID: ", this.getCcr_id())
                .append("Question Response ID: ", this.getQr_id())
                .append("Column Choice Order: ", this.getColumnchoiceorder())
                .append("Column Choice Title: ", this.getColumnchoicetitle());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ColumnChoiceResponse)) {
            return false;
        }

        final ColumnChoiceResponse e = (ColumnChoiceResponse) o;

        return !(ccr_id != null ? !(ccr_id == e.getCcr_id()) : e.getCcr_id() != null);
    }

    @Override
    public int hashCode() {
        return (getCcr_id() != null ? getCcr_id().hashCode() : 0);
    }

    /**
     * @return the ccr_id
     */
    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="ccr_id", unique=true, nullable=false)
    public Integer getCcr_id() {
        return ccr_id;
    }

    /**
     * @param ccr_id the ccr_id to set
     */
    public void setCcr_id(Integer ccr_id) {
        this.ccr_id = ccr_id;
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
     * @return the columnchoiceorder
     */
    @Column
    public Integer getColumnchoiceorder() {
        return columnchoiceorder;
    }

    /**
     * @param columnchoiceorder the columnchoiceorder to set
     */
    public void setColumnchoiceorder(Integer columnchoiceorder) {
        this.columnchoiceorder = columnchoiceorder;
    }

    /**
     * @return the columnchoicetitle
     */
    @Column
    public String getColumnchoicetitle() {
        return columnchoicetitle;
    }

    /**
     * @param columnchoicetitle the columnchoicetitle to set
     */
    public void setColumnchoicetitle(String columnchoicetitle) {
        this.columnchoicetitle = columnchoicetitle;
    }

}
