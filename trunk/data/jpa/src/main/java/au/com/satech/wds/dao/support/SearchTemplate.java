package au.com.satech.wds.dao.support;

import au.com.satech.wds.dao.GenericDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static au.com.satech.wds.dao.support.OrderByDirection.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.criterion.Criterion;
import org.springframework.util.Assert;

/**
 * The SearchTemplate is used to pass search parameters to the DAO layer.
 *
 * By having all the search parameters in one place (the SearchTemplate), 
 * we prevents combinatory explosion of 'find' method signatures in the DAO/Service layer.
 * This leads to more stable DAO/Service interfaces as you can add search parameters to the
 * SearchTemplate without adding new methods to your interfaces.
 *
 * A SearchTemplate helps you drive your search in the following areas:
 * <ul>
 * <li>Configure the search mode (EQUALS, LIKE, ...)</li>
 * <li>Pagination: it allows you to limit your search results to a specific range.</li>
 * <li>Allow you to specify ORDER BY and ASC/DESC</li>
 * <li>Enable/Disable case sensitivity</li>
 * <li>Simple support for date range search criteria</li>
 * <li>LIKE search against all string values: simply set the searchPattern property</li>
 * <li>Named query: if you set a named query, it will be executed please read src/main/resources/META-INF/orm.xml</li>
 * <li>Configuration of the 2d level cache for the search results</li>
 * </ul>
 * @see GenericDao
 * @see SearchMode
 * @see OrderBy
 * @see DateRange
 * @see NamedQueryUtil
 * @see http://docs.jboss.org/hibernate/core/3.3/reference/en/html/queryhql.html
 */
public class SearchTemplate implements Serializable {
    static final private long serialVersionUID = 1L;

    private SearchMode searchMode = SearchMode.EQUALS;

    // named query related
    private String namedQuery;
    private Map<String, Object> parameters = new HashMap<String, Object>();

    private List<OrderBy> orderBys = new ArrayList<OrderBy>();

    public List<OrderBy> getOrderBys() {
        return orderBys;
    }

    public void setOrderBys(List<OrderBy> orderBys) {
        this.orderBys = orderBys;
    }

    // technical parameters
    private boolean caseSensitive = false;

    // Pagination
    private int maxResultsLimit = 500;
    private int maxResults = 500;
    private int firstResult = 0;

    // date ranges
    private Map<String, DateRange> dateRanges = new HashMap<String, DateRange>();

    // raw Criterions
    private List<Criterion> criterions = new ArrayList<Criterion>();

    // pattern to match against all strings.
    private String searchPattern;

    // cache
    private Boolean cacheable = true;
    private String cacheRegion;

    public SearchTemplate() {
    }

    /**
     * Constructs a new search template and initializes it with the values of the passed search template.
     */
    public SearchTemplate(SearchTemplate searchTemplate) {
        setSearchMode(searchTemplate.getSearchMode());
        setNamedQuery(searchTemplate.getNamedQuery());

        // copy parameters
        for (Entry<String, Object> entry : searchTemplate.getParameters().entrySet()) {
            addParameter(entry.getKey(), entry.getValue());
        }

        setSearchPattern(searchTemplate.getSearchPattern());
        setCaseSensitive(searchTemplate.isCaseSensitive());

        // copy order by
        for (OrderBy ob : searchTemplate.getOrderBys()) {
            addOrderBy(ob); // order by is read-only, we can use the same
        }

        setFirstResult(searchTemplate.getFirstResult());
        setMaxResults(searchTemplate.getMaxResults());

        // copy date ranges
        for (DateRange dr : searchTemplate.getDateRanges()) {
            add(new DateRange(dr)); // date range is not readonly, we must clone it
        }

        // copy criterions
        for (Criterion c : searchTemplate.getCriterions()) {
            addCriterion(c); // criterion is read-only, we can use the same 
        }

        setCacheable(searchTemplate.isCacheable());
        setCacheRegion(searchTemplate.getCacheRegion());
    }

    // -----------------------------------
    // SearchMode
    // -----------------------------------

    public SearchTemplate setSearchMode(SearchMode searchMode) {
        Validate.notNull(searchMode, "searchMode must not be null");
        this.searchMode = searchMode;
        return this;
    }

    /**
     * Returns the SearchMode. It defaults to SearchMode.EQUALS.
     * 
     * @param searchMode
     */
    public SearchMode getSearchMode() {
        return searchMode;
    }

    // -----------------------------------
    // Named query support
    // -----------------------------------

    /**
     * Returns true if a named query has been set, false otherwise. When it returns true, the DAO layer will call the namedQuery.
     */
    public boolean hasNamedQuery() {
        return StringUtils.isNotBlank(namedQuery);
    }

    /**
     * Set the named query to be used by the DAO layer. Null by default.
     * 
     * @param namedQuery
     *            the name of the namedQuery.
     */
    public SearchTemplate setNamedQuery(String namedQuery) {
        this.namedQuery = namedQuery;
        return this;
    }

    /**
     * Return the name of the named query to be used by the DAO layer.
     */
    public String getNamedQuery() {
        return namedQuery;
    }

    /**
     * Set the parameters for the named query.
     */
    public SearchTemplate setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * The parameters associated with the named query, if any.
     */
    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * Add a namedQuery parameter.
     */
    public SearchTemplate addParameter(String parameterName, Object parameterValue) {
        if (parameters == null) {
            parameters = new HashMap<String, Object>();
        }

        parameters.put(parameterName, parameterValue);
        return this;
    }

    /**
     * Return the value of the passed parameter name.
     */
    public Object getParameter(String parameterName) {
        return parameters.get(parameterName);
    }

    // -----------------------------------
    // Search pattern support
    // -----------------------------------

    /**
     * When it returns true, it indicates to the DAO layer to use the passed searchPattern on all string properties.
     */
    public boolean hasSearchPattern() {
        return StringUtils.isNotBlank(searchPattern);
    }

    /**
     * Set the pattern which may contains wildcards (ex: "e%r%ka" ). The passed searchPattern is used by the DAO layer on all string properties. Null by
     * default.
     * 
     * @param searchPattern
     */
    public SearchTemplate setSearchPattern(String searchPattern) {
        this.searchPattern = searchPattern;
        return this;
    }

    /**
     * Returns the search pattern to be used by the DAO layer.
     */
    public String getSearchPattern() {
        return searchPattern;
    }

    // -----------------------------------
    // Case sensitiveness support
    // -----------------------------------

    /**
     * Set the case sensitiveness. Defaults to false.
     * 
     * @param caseSensitive
     */
    public SearchTemplate setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }

    public SearchTemplate setCaseSensitive() {
        return setCaseSensitive(true);
    }

    public SearchTemplate setCaseInsensitive() {
        return setCaseSensitive(false);
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public boolean isCaseInsensitive() {
        return !caseSensitive;
    }

    // -----------------------------------
    // Order by support
    // -----------------------------------

    public boolean hasOrderBy() {
        return !orderBys.isEmpty();
    }

    /**
     * please use #setOrderBy instead
     * 
     * @param column
     * @return
     */
    @Deprecated
    public SearchTemplate setOrderBy(String column) {
        int orderBySize = this.orderBys.size();
        if (orderBySize == 0) {
            this.orderBys.add(new OrderBy(column));
        } else if (orderBySize == 1) {
            OrderBy orderBy = this.orderBys.get(0);
            this.orderBys.clear();
            this.orderBys.add(new OrderBy(column, orderBy.getDirection()));
        } else {
            throw new IllegalStateException("Please use addOderBy");
        }
        return this;
    }

    /**
     * please use #setOrderBy instead
     * 
     * @param column
     * @return
     */
    @Deprecated
    public SearchTemplate setOrderDesc(boolean desc) {
        int orderBySize = this.orderBys.size();
        if (orderBySize == 0) {
            this.orderBys.add(new OrderBy("", desc ? DESC : ASC));
        } else if (orderBySize == 1) {
            OrderBy orderBy = this.orderBys.get(0);
            this.orderBys.clear();
            this.orderBys.add(new OrderBy(orderBy.getColumn(), desc ? DESC : ASC));
        } else {
            throw new IllegalStateException("Please use addOderBy");
        }
        return this;
    }

    public SearchTemplate setOrderBy(String column, OrderByDirection direction) {
        Assert.isTrue(this.orderBys.size() == 0);
        this.orderBys.add(new OrderBy(column, direction));
        return this;
    }

    public SearchTemplate setOrderBy(OrderBy orderBy) {
        this.orderBys.clear();
        this.orderBys.add(orderBy);
        return this;
    }

    public SearchTemplate addOrderBy(OrderBy orderBy) {
        this.orderBys.add(orderBy);
        return this;
    }

    public SearchTemplate addOrderBy(String column, OrderByDirection direction) {
        this.orderBys.add(new OrderBy(column, direction));
        return this;
    }

    // -----------------------------------
    // Order ASC/DESC support
    // -----------------------------------

    // -----------------------------------
    // Pagination support
    // -----------------------------------

    public SearchTemplate setMaxResults(int maxResults) {
        Validate.isTrue(maxResults > 0, "maxResults must be > 0");
        this.maxResults = Math.min(maxResults, maxResultsLimit);
        return this;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public SearchTemplate setFirstResult(int firstResult) {
        Validate.isTrue(firstResult >= 0, "firstResult must be >= 0");
        this.firstResult = firstResult;
        return this;
    }

    public int getFirstResult() {
        return this.firstResult;
    }

    // -----------------------------------
    // Caching support
    // -----------------------------------

    /**
     * Default to true.
     * 
     * @param cacheable
     *            true to enable caching, false to disable caching or null to let the DAO layer decide.
     */
    public SearchTemplate setCacheable(Boolean cacheable) {
        this.cacheable = cacheable;
        return this;
    }

    /**
     * When not null, indicates if the DAO layer should cache or not the search results. If null is returned, it is up to the DAO layer to decide what to do.
     */
    public Boolean isCacheable() {
        return cacheable;
    }

    /**
     * cache region
     */

    public boolean hasCacheRegion() {
        return StringUtils.isNotBlank(cacheRegion);
    }

    public SearchTemplate setCacheRegion(String cacheRegion) {
        this.cacheRegion = cacheRegion;
        return this;
    }

    public String getCacheRegion() {
        return cacheRegion;
    }

    // -----------------------------------
    // Search by date support
    // -----------------------------------

    public Collection<DateRange> getDateRanges() {
        return dateRanges.values();
    }

    public SearchTemplate setDateRanges(Collection<DateRange> dateRanges) {
        this.dateRanges = new HashMap<String, DateRange>();
        add(dateRanges.toArray(new DateRange[dateRanges.size()]));
        return this;
    }

    public SearchTemplate add(DateRange... dateRanges) {
        for (DateRange dateRange : dateRanges) {
            this.dateRanges.put(dateRange.getField(), dateRange);
        }
        return this;
    }

    public boolean hasDatePattern() {
        if (dateRanges.size() == 0) {
            return false;
        }
        for (Entry<String, DateRange> dateRange : dateRanges.entrySet()) {
            if (dateRange.getValue().isSet()) {
                return true;
            }
        }
        return false;
    }

    public DateRange getDateRange(String columnName) {
        return dateRanges.get(columnName);
    }

    // -----------------------------------
    // Search criterion support
    // -----------------------------------
    /**
     * Add a criterion.
     * It allows you to add NullCriterion on x-to-one relation.
     * For example add(Restrictions.isNull("linkedEntity")) 
     */
    public void addCriterion(Criterion criterion) {
        criterions.add(criterion);
    }

    public void setCriterions(List<Criterion> criterions) {
        this.criterions = criterions;
    }

    public List<Criterion> getCriterions() {
        return criterions;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}