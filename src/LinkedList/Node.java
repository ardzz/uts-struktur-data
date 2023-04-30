package LinkedList;

import Items.AbstractItem;

public class Node {
    public AbstractItem item;
    public Node next;
    public Node previous;

    public Node(AbstractItem item){
        this.item = item;
        this.next = null;
        this.previous = null;
    }
}
