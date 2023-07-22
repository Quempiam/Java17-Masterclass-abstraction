package dev.que;

public interface NodeList {
    /**
     *
     * @return root of NodeList
     */
    ListItem getRoot();

    /**
     * Adds item to Nodelist
     * Place to add the item depends on conditions Implementor imposes
     * @param newItem ListItem to add
     * @return true if success, false otherwise
     */
    boolean addItem(ListItem newItem);

    /**
     * Removes an item from NodeList
     * @param item ListItem to be removed
     * @return true if success, false otherwise
     */
    boolean removeItem(ListItem item);

    /**
     * Prints Nodelist starting from given root
     * @param root ListItem to start printing from
     */
    void traverse(ListItem root);
}
