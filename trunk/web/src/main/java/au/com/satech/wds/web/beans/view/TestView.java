/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans.view;

import au.com.satech.wds.model.BranchItem;
import au.com.satech.wds.model.Page;
import au.com.satech.wds.model.PageBranch;
import au.com.satech.wds.service.PageBranchManager;
import au.com.satech.wds.service.SurveyManager;
import au.com.satech.wds.web.beans.BaseBean;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author sam
 */
@ManagedBean(name ="testView")
@ViewScoped
public class TestView extends BaseBean {
    @ManagedProperty(value="#{surveyManager}")
    private SurveyManager smr;
    
    @ManagedProperty(value="#{pageBranchManager}")
    private PageBranchManager pbm;
    @PostConstruct
    public void setup(){
        log.debug("Setup");
    }
    
    public void doIT(){
        log.debug("DOIT");
//        List<Page> list= smr.getPagesBySurveyId();
//        List<Page> pages= new ArrayList<Page>();
//        for(Page page:list){
//            List<PageBranch> branchs=new ArrayList<PageBranch>();
//            branchs.addAll(page.getPagebranches());
//            List<PageBranch> branchsList=new ArrayList<PageBranch>();
//            for(PageBranch branch:branchs){
////                log.debug("DOIT");
//               List<BranchItem> items=new ArrayList<BranchItem>();
//               items.addAll(pbm.getBranchItemsByPageBranchId(branch.getBranchid()));
//               PageBranch newBranch=branch;
//               newBranch.setItems(items);
//               branchsList.add(newBranch);
//           }
//            Page newPage=page;
//            newPage.setPagebranches(branchsList);
//            pages.add(newPage);
//        }
        smr.retrievePagesBySurveyId(104);
        //smr.getPagesbySurveyId(104);
        
    }

    public SurveyManager getSmr() {
        return smr;
    }

    public void setSmr(SurveyManager smr) {
        this.smr = smr;
    }

    public PageBranchManager getPbm() {
        return pbm;
    }

    public void setPbm(PageBranchManager pbm) {
        this.pbm = pbm;
    }
    
    
}
