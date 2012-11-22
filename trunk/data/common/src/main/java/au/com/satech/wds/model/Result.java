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
import javax.persistence.Transient;
import org.apache.log4j.Logger;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "result")
public class Result extends BaseObject{
    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(Result.class);

    
    // Raw attributes
    private Integer resultid; // pk
    private Integer displays;
    private Integer pageid;
    private Integer pagebranchid;
    private Integer pageid_aq;
    private Integer pageid_ap;
    private String resultName;
    
    public Result(){
        
    }

    public Result(Integer displays, Integer pageid, Integer pagebranchid, Integer pageid_aq, Integer pageid_ap, String resultName) {
        this.displays = displays;
        this.pageid = pageid;
        this.pagebranchid = pagebranchid;
        this.pageid_aq = pageid_aq;
        this.pageid_ap = pageid_ap;
        this.resultName = resultName;
    }
    

    /**
     * @return the resultid
     */
    @Column(nullable = false, unique = true)
    @GeneratedValue
    @Id
    public Integer getResultid() {
        return resultid;
    }

    /**
     * @param resultid the resultid to set
     */
    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    /**
     * @return the displays
     */
    @Column
    public Integer getDisplays() {
        return displays;
    }

    /**
     * @param displays the displays to set
     */
    public void setDisplays(Integer displays) {
        this.displays = displays;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("result.resultid=[").append(getResultid()).append("]\n");
        result.append("result.displays=[").append(getDisplays()).append("]\n");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Result)) {
            return false;
        }
        
        final Result result = (Result) o;
        
        return !(resultid != null ? !(resultid == result.getResultid()) : result.getResultid() != null);
    }

    @Override
    public int hashCode() {
        return (resultid != null ? resultid.hashCode() : 0);
    }

    /**
     * @return the pageid
     */
    @Column
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
     * @return the pagebranchid
     */
    @Column
    public Integer getPagebranchid() {
        return pagebranchid;
    }

    /**
     * @param pagebranchid the pagebranchid to set
     */
    public void setPagebranchid(Integer pagebranchid) {
        this.pagebranchid = pagebranchid;
    }

    /**
     * @return the pageid_aq
     */
    @Column
    public Integer getPageid_aq() {
        return pageid_aq;
    }

    /**
     * @param pageid_aq the pageid_aq to set
     */
    public void setPageid_aq(Integer pageid_aq) {
        this.pageid_aq = pageid_aq;
    }

    /**
     * @return the pageid_ap
     */
    @Column
    public Integer getPageid_ap() {
        return pageid_ap;
    }

    /**
     * @param pageid_ap the pageid_ap to set
     */
    public void setPageid_ap(Integer pageid_ap) {
        this.pageid_ap = pageid_ap;
    }

    @Transient
    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }
    
    
}
