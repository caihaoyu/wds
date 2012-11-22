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
@Table(name="answerresponse")
public class AnswerResponse extends BaseObject implements java.io.Serializable {
    private Integer ar_id;
    private Integer qr_id;
    private Integer answerorder;
    private String answertitle;
    
    public AnswerResponse(){
        
    }
    
    public AnswerResponse(Answer answer){
        this.answerorder = answer.getAnswerorder();
        this.answertitle = answer.getAnswertitle();
    }
    
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("Answer Response ID: ", this.getAr_id())
                .append("Question Response ID: ", this.getQr_id())
                .append("Answer Order: ", this.getAnswerorder())
                .append("Answer Title: ", this.getAnswertitle());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnswerResponse)) {
            return false;
        }

        final AnswerResponse e = (AnswerResponse) o;

        return !(ar_id != null ? !(ar_id == e.getAr_id()) : e.getAr_id() != null);
    }

    @Override
    public int hashCode() {
        return (getAr_id() != null ? getAr_id().hashCode() : 0);
    }

    /**
     * @return the ar_id
     */
    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="ar_id", unique=true, nullable=false)
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
     * @return the answerorder
     */
    @Column
    public Integer getAnswerorder() {
        return answerorder;
    }

    /**
     * @param answerorder the answerorder to set
     */
    public void setAnswerorder(Integer answerorder) {
        this.answerorder = answerorder;
    }

    /**
     * @return the answertitle
     */
    @Column
    public String getAnswertitle() {
        return answertitle;
    }

    /**
     * @param answertitle the answertitle to set
     */
    public void setAnswertitle(String answertitle) {
        this.answertitle = answertitle;
    }
}
