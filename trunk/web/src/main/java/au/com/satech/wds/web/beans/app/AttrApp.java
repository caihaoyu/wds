/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.app;

import au.com.satech.wds.web.beans.BaseBean;
import au.com.satech.wds.web.beans.view.DashboardView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author sam
 */
@ManagedBean(name ="attrApp")
@ApplicationScoped
public class AttrApp extends BaseBean {
    @PostConstruct
    public void setup(){
        this.localSvnRevision = readLocalSvnRevisionFromResource();
        this.setUserBrowserType(readUserBrowserType());
    }
    
    @PreDestroy
    public void destroy(){
        
    }
    
    private String userBrowserType;
    private String localSvnRevision;
    
    private String readLocalSvnRevisionFromResource(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext eContext = context.getExternalContext();
        InputStream in = eContext.getResourceAsStream("/WEB-INF/svnver.propertise");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        String revision = "0";
        try {
            while ((strLine = br.readLine()) != null && !"".equals(strLine = br.readLine()))   {
                StringBuilder sb = new StringBuilder(strLine);
                int indexOfDivider = sb.indexOf(":");
                String key = sb.substring(0, indexOfDivider);
                if(key.equals("Revision")){
                    revision = sb.substring(indexOfDivider+1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DashboardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return revision;
    }
    
    private String readUserBrowserType(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext eContext = context.getExternalContext();
        String userBrowserType = "";
        Map requestHeaders = eContext.getRequestHeaderMap();
        String userAgent = requestHeaders.get("user-agent").toString();
        if(userAgent.contains("MSIE")){
            userBrowserType = "Internet Explorer";
            int occurIndex = userAgent.indexOf("MSIE");
            String version = userAgent.substring(occurIndex+"MSIE".length()+1, occurIndex+"MSIE".length()+4);
            userBrowserType = userBrowserType + " " + version;
        }
        if(userAgent.contains("Firefox")){
            userBrowserType = "FireFox";
            int occurIndex = userAgent.lastIndexOf("FireFox");
            String version = userAgent.substring(occurIndex+"FireFox".length()+2, occurIndex+"FireFox".length()+3);
            userBrowserType = userBrowserType + " " + version;
        }
        if(userAgent.contains("Chrome")){
            userBrowserType = "Chrome";
            int occurIndex = userAgent.indexOf("Chrome");
            String version = userAgent.substring(occurIndex+"Chrome".length()+1, occurIndex+"Chrome".length()+3);
            userBrowserType = userBrowserType + " " + version;
        }
        return userBrowserType;
    }

    /**
     * @return the localSvnRevision
     */
    public String getLocalSvnRevision() {
        return localSvnRevision;
    }

    /**
     * @param localSvnRevision the localSvnRevision to set
     */
    public void setLocalSvnRevision(String localSvnRevision) {
        this.localSvnRevision = localSvnRevision;
    }

    /**
     * @return the userBrowserType
     */
    public String getUserBrowserType() {
        return userBrowserType;
    }

    /**
     * @param userBrowserType the userBrowserType to set
     */
    public void setUserBrowserType(String userBrowserType) {
        this.userBrowserType = userBrowserType;
    }
}
