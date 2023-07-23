package dev.que;

public class SearchTree implements NodeList{
    ListItem root;

    public SearchTree(ListItem root) {
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
            if (comp < 0) {
//                                          creating only one directional links creates tree-like structure of data
//                                          where item's previous() node can have different item as next()
                if (actItem.next() == null) {
                    actItem.setNext(newItem);
                    return true;
                } else {
                    actItem = actItem.next();
                }
            } else if (comp > 0) {
                if (actItem.previous() == null) {
                    actItem.setPrevious(newItem);
                    return true;
                } else {
                    actItem = actItem.previous();
                }
            }
        }
        // they are equal or something went wrong
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem actItem = this.root;
        ListItem parent = actItem;
        while (actItem != null){
            int comp = actItem.compareTo(item);
            if (comp == 0){
                performRemoval(actItem, parent);
                return true;
            }
            else if (comp < 0){
                parent = actItem;
                actItem = actItem.next();
            }
            else {
                parent = actItem;
                actItem = actItem.previous();
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        traverse(root.previous());
        System.out.println(root.value);
        traverse(root.next());
    }
/*
This one again I was only able to write thanks to a one guy's comment.
Course instructor didn't introduce an idea of binary search tree, so it
took quite much time understand how it works - and that's why I wrote
much more comments than usual to help me understand the code when I'll be
looking at it in the future.
@Temo https://www.udemy.com/user/temo-48/ - his code was really helpfull
https://youtu.be/Gt2yBZAhsGM
https://youtu.be/b_NjndniOqY - these videos helped to understand concept of
                               search tree
 */
    private void performRemoval(ListItem item, ListItem parent){
        if (item.previous() == null){
            if (parent.previous() == item){
                parent.setPrevious(item.next());
            }
            else if (parent.next() == item){
                parent.setNext(item.next());
            }
//            item is the parent - item is root
            else {
                this.root = item.next();
            }
        }
        else if (item.next() == null){
            if (parent.next() == item){
                parent.setNext(item.previous());
            }
            else if (parent.previous() == item){
                parent.setPrevious(item.previous());
            }
        }
//        item has not null branches
        else{
//            going one place right and then left to replace item with greater value
//            and keep the logic of the tree
            ListItem actItem = item.next();
            ListItem leftParent = item;

//            till the branch end
            while(actItem.previous() != null){
                leftParent = actItem;
                actItem = actItem.previous();
            }

            item.setValue(actItem.getValue());
//            if we didn't enter while loop it means we went just one step so
//            leftparent is the item and actItem is item.next()
            if (leftParent == item){
                item.setNext(actItem.next());
            }
            else{
                leftParent.setPrevious(actItem);
            }
        }
    }
}
