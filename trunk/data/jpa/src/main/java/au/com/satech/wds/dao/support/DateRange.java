package au.com.satech.wds.dao.support;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 * Support class for search by {@link java.util.Date},  
 * it carries the date search parameters for an entity's field mapped to 
 * {@link java.util.Date}, {@link org.joda.time.LocalDate} or {@link org.joda.time.LocalDateTime}.
 * @See SearchTemplate
 * @See SearchForm
 */
public class DateRange implements Serializable {
    private static final long serialVersionUID = 1L;

    private String field;
    private Object from;
    private Object to;
    private Boolean includeNull;

    /**
     * Constructs a new {@link DateRange} with no boundaries and no restrictions on date's nullability.
     * @param field the property's name of an existing entity.
     */
    public DateRange(String field) {
        this.field = field;
    }

    /**
     * Constructs a new DateRange.
     *
     * @param field the property's name of an existing entity.
     * @param from the lower boundary of this date range. Null means no lower boundary.
     * @param to the upper boundary of this date range. Null means no upper boundary.
     */
    public DateRange(String field, Object from, Object to) {
        checkArguments(from, to);
        this.field = field;
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs a new DateRange.
     *
     * @param field the property's name of an existing entity.
     * @param from the lower boundary of this date range. Null means no lower boundary.
     * @param to the upper boundary of this date range. Null means no upper boundary.
     * @param includeNull tells whether null date should be filtered out or not.
     */
    public DateRange(String field, Object from, Object to, Boolean includeNull) {
        checkArguments(from, to);
        this.field = field;
        this.from = from;
        this.to = to;
        this.includeNull = includeNull;
    }

    /**
     * Constructs a new DateRange using values of the passed DateRange.
     */
    public DateRange(DateRange other) {
        this.field = other.getField();
        this.from = other.getFrom();
        this.to = other.getTo();
        this.includeNull = other.getIncludeNull();
    }

    /**
     * @return the entity's field name this DateRange refers to.
     */
    public String getField() {
        return field;
    }

    /**
     * @return the lower date range boundary or null for unbound lower range.
     */
    public Object getFrom() {
        return from;
    }

    /**
     * Sets the lower date range boundary. Accepts null for unbound lower range.
     */
    public void setFrom(Object from) {
        checkArguments(from, getTo());
        this.from = from;
    }

    public boolean isFromSet() {
        return getFrom() != null;
    }

    /**
     * @return the upper date range boundary or null for unbound upper range.
     */
    public Object getTo() {
        return to;
    }

    /**
     * Sets the upper date range boundary. Accepts null for unbound upper range.
     */
    public void setTo(Object to) {
        checkArguments(getFrom(), to);
        this.to = to;
    }

    public boolean isToSet() {
        return getTo() != null;
    }

    public void setIncludeNull(boolean includeNull) {
        this.includeNull = includeNull;
    }

    public Boolean getIncludeNull() {
        return includeNull;
    }

    public boolean isIncludeNullSet() {
        return includeNull != null;
    }

    public boolean isBetween() {
        return isFromSet() && isToSet();
    }

    public boolean isSet() {
        return isFromSet() || isToSet() || isIncludeNullSet();
    }

    @SuppressWarnings( { "unchecked", "rawtypes" })
    public boolean isValid() {
        if (isBetween()) {
            return ((Comparable) getFrom()).compareTo(getTo()) <= 0;
        }

        return true;
    }

    private void checkArguments(Object from, Object to) {
        if ((from == null || from instanceof Date) && (to == null || to instanceof Date)) {
            return;
        }

        if ((from == null || from instanceof LocalDate) && (to == null || to instanceof LocalDate)) {
            return;
        }

        if ((from == null || from instanceof LocalDateTime) && (to == null || to instanceof LocalDateTime)) {
            return;
        }

        throw new IllegalArgumentException(
                "Expecting Date, LocalDate or LocalDateTime, not a mix of both or something else.");
    }
}
