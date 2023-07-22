package dev.que;

public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    /**
     *
     * @return next ListItem
     */
    abstract ListItem next();

    /**
     * Sets next linked item with given value
     * @param value value to set next Listitem with
     * @return next Listitem
     */
    abstract ListItem setNext(Object value);

    /**
     *
     * @return previous ListItem
     */
    abstract ListItem previous();

     /**
     * Sets previous linked item with given value
     * @param value value to set previous Listitem with
     * @return previous Listitem
     */
    abstract ListItem setPrevious(Object value);

    /**
     * Compares this ListItem to given one.
     * Values of both LisItems must be Comparable
     * @param item ListItem to compare with this
     * @return positive if item is greater than this,
     * negative if it's less than this and 0 if they are equal
     */
    abstract int compareTo(ListItem item);

    /**
     *
     * @return value of this ListItem
     */
    public Object getValue() {
        return value;
    }

    /**
     *
     * @param value Value to set this ListItem with
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
