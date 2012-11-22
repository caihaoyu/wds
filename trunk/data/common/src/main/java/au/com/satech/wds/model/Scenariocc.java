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

/**
 *
 * @author cai
 */
@Entity
@Table(name="scenariocc")
public class Scenariocc extends BaseObject implements java.io.Serializable{
    private Integer scenarioccid;
    private Integer columnchoiceid;

    @Column(name="scenarioccid", nullable = false, unique = true)
    @GeneratedValue
    @Id
    public Integer getScenarioccid() {
        return scenarioccid;
    }

    public void setScenarioccid(Integer scenarioccid) {
        this.scenarioccid = scenarioccid;
    }

    @Column(name="columnchoiceid")
    public Integer getColumnchoiceid() {
        return columnchoiceid;
    }

    public void setColumnchoiceid(Integer columnchoiceid) {
        this.columnchoiceid = columnchoiceid;
    }
    
    

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
         return (scenarioccid != null ? scenarioccid.hashCode() : 0);
    }
    
    
    
}
