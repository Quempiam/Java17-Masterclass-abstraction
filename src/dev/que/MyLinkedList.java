package dev.que;

public class MyLinkedList implements NodeList {
    ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    /**
     * Adds item to Nodelist providing ascending order of items
     */
    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem actItem = this.root;
        while (actItem != null) {
            int comp = actItem.compareTo(newItem);
            if (comp < 0) {                             // actItem < newItem - newItem should be placed right if right is null
                if (actItem.next() == null) {
                    actItem.setNext(newItem);
                    newItem.setPrevious(actItem);
                    return true;
                } else {                                // there is another Item, loop should repeat
                    actItem = actItem.next();
                }
            } else if (comp > 0) {                      // actItem > newItem - newItem should be placed left
                if (actItem.previous() == null) {       // no item at letfLink - actItem is root of the list
                    actItem.setPrevious(newItem);
                    newItem.setNext(actItem);
                    this.root = newItem;
                    return true;
                } else {                                //placing newItem between actItem and actItem.previous()
                    actItem.previous().setNext(newItem);
                    newItem.setPrevious(actItem.previous());
                    actItem.setPrevious(newItem);
                    newItem.setNext(actItem);
                }
            }
        }
        // they are equal or something went wrong
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem actItem = this.root;
        while (actItem != null){
            int comp = actItem.compareTo(item);
            if (comp == 0){
                if (actItem.previous() == null){
                    this.root = actItem.next();
                    actItem.next().setPrevious(null);
                }
                else{
                    actItem.previous().setNext(actItem.next());
                    if (actItem.next() != null) {
                        actItem.next().setPrevious(actItem.previous());
                    }
                }
                return true;
            }
            else if (comp < 0){
                actItem = actItem.next();
            }
            else {
//              if actItem > item there is no need to search further
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null){
            System.out.println("The list is empty");
        }

        while (root != null){
            System.out.println(root.getValue());
            root = root.next();
        }
    }
}
