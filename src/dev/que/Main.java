package dev.que;

public class Main {
    public static void main(String[] args) {
        ListItem node = new Node("4");
        NodeList list = new SearchTree(node);
        list.addItem(new Node("1"));
        list.addItem(new Node("3"));
        list.addItem(new Node("2"));
        list.addItem(new Node("7"));
        list.addItem(new Node("5"));
        list.addItem(new Node("6"));

        list.addItem(new Node("4"));

        list.traverse(node);
    }
}