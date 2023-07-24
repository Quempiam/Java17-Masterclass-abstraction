package dev.que;

public class Node extends ListItem{

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        rightLink = item;
        return rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        leftLink = item;
        return leftLink;
    }

    /*
     * I got this idea from comment section of the course. Object doesn't implement Comparable
     * so it can not be simply compared to another object. Casting it to String allows me to do so
     * It surely throws errors in certain cases witch I'm not able yet to deal with at this moment
     **/
    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        }
        return -1;
    }
}
