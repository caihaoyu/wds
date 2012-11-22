package au.com.satech.wds.model;
// Generated 27/04/2011 2:03:13 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Columnchoice generated by hbm2java
 */
@Entity
@Table(name="columnchoice")
public class Columnchoice extends BaseObject  implements java.io.Serializable {

     private Integer columnchoiceid;
     private String columnchoicetitle;
     private Integer columnchoiceorder;

    public Columnchoice() {
    }

    public Columnchoice(Question question, String columnchoicetitle, Integer columnchoiceorder) {
       this.columnchoicetitle = columnchoicetitle;
       this.columnchoiceorder = columnchoiceorder;
    }
   
@Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="columnchoiceid", unique=true, nullable=false)
    public Integer getColumnchoiceid() {
        return this.columnchoiceid;
    }
    
    public void setColumnchoiceid(Integer columnchoiceid) {
        this.columnchoiceid = columnchoiceid;
    }
    
    @Transient
    public boolean isIdSet(){
        if(getColumnchoiceid()==null) {
            return false;
        }
        return true;
    }
    
    @Column(name="columnchoicetitle", length=600)
    public String getColumnchoicetitle() {
        return this.columnchoicetitle;
    }
    
    public void setColumnchoicetitle(String columnchoicetitle) {
        this.columnchoicetitle = columnchoicetitle;
    }
    
    @Column(name="columnchoiceorder")
    public Integer getColumnchoiceorder() {
        return this.columnchoiceorder;
    }
    
    public void setColumnchoiceorder(Integer columnchoiceorder) {
        this.columnchoiceorder = columnchoiceorder;
    }

    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("column choice id", this.columnchoiceid)
                .append("column choice title", this.columnchoicetitle)
                .append("column choice order",this.columnchoiceorder);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Columnchoice)){
            return false;
        }
        final Columnchoice columnChoice = (Columnchoice)o;
        
        return !(columnchoiceid != null ? !(columnChoice.getColumnchoiceid() == columnchoiceid) : columnChoice.getColumnchoiceid() != null);
    }

    @Override
    public int hashCode() {
        return (columnchoiceid != null ? columnchoiceid.hashCode() : 0);
    }

}


