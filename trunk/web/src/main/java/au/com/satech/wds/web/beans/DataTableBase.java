/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.satech.wds.web.beans;

/**
 *
 * @author sam
 */
public abstract class DataTableBase extends BaseBean {
    // Table DataPaginator variables
    private int numberOfRowsOnPage;

    /**
     * @return the numberOfRowsOnPage
     */
    public int getNumberOfRowsOnPage() {
        return numberOfRowsOnPage;
    }

    /**
     * @param numberOfRowsOnPage the numberOfRowsOnPage to set
     */
    public void setNumberOfRowsOnPage(int numberOfRowsOnPage) {
        this.numberOfRowsOnPage = numberOfRowsOnPage;
    }
}
