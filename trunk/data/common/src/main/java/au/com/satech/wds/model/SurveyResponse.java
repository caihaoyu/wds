/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Leo
 */
@Entity
@Table(name="surveyresponse")
public class SurveyResponse extends BaseObject implements java.io.Serializable {
    private Integer sr_id;
    private Long uid;
    private boolean active;
    private boolean allowsave;
    private boolean attributedescriptions;
    private Date datecreated;
    private Date expires;
    private String language;
    private String supervisor;
    private String supervisoremail;
    private String surveydescription;
    private String surveyendtext;
    private String surveytitle;
    private String surveywelcometext;
    private boolean usecookie;
    private List<PageResponse> pageresponses = new ArrayList<PageResponse>();
    
    public SurveyResponse(){
        
    }
    
    public SurveyResponse(Survey survey)
    {
        this.active = survey.getActive();
        this.allowsave = survey.getAllowsave();
        this.attributedescriptions = survey.getAttributedescriptions();
        this.datecreated = survey.getDatecreated();
        this.expires = survey.getExpires();
        this.language = survey.getLanguage();
        this.supervisor = survey.getSupervisor();
        this.supervisoremail = survey.getSupervisoremail();
        this.surveydescription = survey.getSurveydescription();
        this.surveyendtext = survey.getSurveyendtext();
        this.surveytitle = survey.getSurveytitle();
        this.surveywelcometext = survey.getSurveywelcometext();
        this.usecookie = survey.getUsecookie();
    }
    
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("survey id", this.sr_id)
                .append("survey title", this.surveytitle)
                .append("survey description", this.surveydescription);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SurveyResponse)) {
            return false;
        }

        final SurveyResponse r = (SurveyResponse) o;

        return !(sr_id != null ? !(sr_id == r.getSr_id()) : r.getSr_id() != null);
    }

    @Override
    public int hashCode() {
        return (getSr_id() != null ? getSr_id().hashCode() : 0);
    }

    /**
     * @return the sr_id
     */
    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="sr_id", unique=true, nullable=false)
    public Integer getSr_id() {
        return sr_id;
    }

    /**
     * @param sr_id the sr_id to set
     */
    public void setSr_id(Integer sr_id) {
        this.sr_id = sr_id;
    }

    /**
     * @return the uid
     */
    @Column
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * @return the active
     */
    @Column
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the allowsave
     */
    @Column
    public boolean isAllowsave() {
        return allowsave;
    }

    /**
     * @param allowsave the allowsave to set
     */
    public void setAllowsave(boolean allowsave) {
        this.allowsave = allowsave;
    }

    /**
     * @return the attributedescriptions
     */
    @Column
    public boolean isAttributedescriptions() {
        return attributedescriptions;
    }

    /**
     * @param attributedescriptions the attributedescriptions to set
     */
    public void setAttributedescriptions(boolean attributedescriptions) {
        this.attributedescriptions = attributedescriptions;
    }

    /**
     * @return the datecreated
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDatecreated() {
        return datecreated;
    }

    /**
     * @param datecreated the datecreated to set
     */
    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    /**
     * @return the expires
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getExpires() {
        return expires;
    }

    /**
     * @param expires the expires to set
     */
    public void setExpires(Date expires) {
        this.expires = expires;
    }

    /**
     * @return the language
     */
    @Column
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the supervisor
     */
    @Column
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the supervisoremail
     */
    @Column
    public String getSupervisoremail() {
        return supervisoremail;
    }

    /**
     * @param supervisoremail the supervisoremail to set
     */
    public void setSupervisoremail(String supervisoremail) {
        this.supervisoremail = supervisoremail;
    }

    /**
     * @return the surveydescription
     */
    @Column
    public String getSurveydescription() {
        return surveydescription;
    }

    /**
     * @param surveydescription the surveydescription to set
     */
    public void setSurveydescription(String surveydescription) {
        this.surveydescription = surveydescription;
    }

    /**
     * @return the surveyendtext
     */
    @Column
    public String getSurveyendtext() {
        return surveyendtext;
    }

    /**
     * @param surveyendtext the surveyendtext to set
     */
    public void setSurveyendtext(String surveyendtext) {
        this.surveyendtext = surveyendtext;
    }

    /**
     * @return the surveytitle
     */
    @Column
    public String getSurveytitle() {
        return surveytitle;
    }

    /**
     * @param surveytitle the surveytitle to set
     */
    public void setSurveytitle(String surveytitle) {
        this.surveytitle = surveytitle;
    }

    /**
     * @return the surveywelcometext
     */
    @Column
    public String getSurveywelcometext() {
        return surveywelcometext;
    }

    /**
     * @param surveywelcometext the surveywelcometext to set
     */
    public void setSurveywelcometext(String surveywelcometext) {
        this.surveywelcometext = surveywelcometext;
    }

    /**
     * @return the usecookie
     */
    @Column
    public boolean isUsecookie() {
        return usecookie;
    }

    /**
     * @param usecookie the usecookie to set
     */
    public void setUsecookie(boolean usecookie) {
        this.usecookie = usecookie;
    }

    /**
     * @return the pageresponses
     */
    @Transient
    public List<PageResponse> getPageresponses() {
        return pageresponses;
    }

    /**
     * @param pageresponses the pageresponses to set
     */
    public void setPageresponses(List<PageResponse> pageresponses) {
        this.pageresponses = pageresponses;
    }

}
