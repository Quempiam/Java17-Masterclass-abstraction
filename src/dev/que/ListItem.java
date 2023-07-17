package dev.que;

public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext();
    abstract ListItem previous();
    abstract ListItem setPrevious();
    abstract int compareTo();
}
