package LinkedList;

import Helper.CommandLineTable;
import Helper.PromptHandler;
import Items.AbstractItem;

public class List {
    public Node head;
    public Node tail;
    public int size;

    protected AbstractItem item;

    public List(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void setItemInstance(AbstractItem item){
        this.item = item;
    }
    public AbstractItem getItemInstance(){
        return this.item;
    }

    public void unsetItemInstance(){
        this.item = null;
    }

    public AbstractItem new_item(){
        PromptHandler PromptHandler = item.PromptInput();
        item.setString_data(PromptHandler.getStringData());
        item.setInteger_data(PromptHandler.getIntData());
        return item;
    }

    public void print_item(){
        Node current_item = this.head;
        while (current_item != null){
            String[] key_string_data = current_item.item.getString_name_data();
            String[] key_integer_data = current_item.item.getInteger_name_data();

            for (int i = 0; i < key_string_data.length; i++) {
                //System.out.println(key_string_data[i] + ": " + current_item.item.getString_data()[i]);
                // capitalize first letter
                String key = key_string_data[i].substring(0, 1).toUpperCase() + key_string_data[i].substring(1);
                System.out.println("[+] " + key + ": " + current_item.item.getString_data()[i]);
            }

            for (int i = 0; i < key_integer_data.length; i++) {
                //System.out.println(key_integer_data[i] + ": " + current_item.item.getInteger_data()[i]);
                // capitalize first letter
                String key = key_integer_data[i].substring(0, 1).toUpperCase() + key_integer_data[i].substring(1);
                System.out.println("[+] " + key + ": " + current_item.item.getInteger_data()[i]);
            }
            System.out.println();
            current_item = current_item.next;
        }
    }

    public void add(AbstractItem item){
        Node node = new Node(item);
        if (head == null){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    public void add_first(){
        Node node = new Node(new_item());
        if (head == null){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        size++;
    }

    public void add_last(){
        Node node = new Node(new_item());
        Node current_item = this.head;
        if (head == null){
            head = node;
        } else {
            while (current_item.next != null){
                current_item = current_item.next;
            }
            current_item.next = node;
            node.previous = current_item;
        }
        tail = node;
    }

    public void add_after(int index){
        Node node = new Node(new_item());
        Node current_item = this.head;
        if (head == null){
            head = node;
        } else {
            for (int i = 0; i < index; i++){
                current_item = current_item.next;
            }
            node.next = current_item.next;
            current_item.next = node;
            node.previous = current_item;
        }
    }

    public void add_before(int index){
        Node node = new Node(new_item());
        Node current_item = this.head;
        if (head == null){
            head = node;
        } else {
            for (int i = 0; i < index; i++){
                current_item = current_item.next;
            }
            node.previous = current_item.previous;
            current_item.previous = node;
            node.next = current_item;
        }
    }

    public void add_at(int index){
        Node node = new Node(new_item());
        Node current_item = this.head;
        if (head == null){
            head = node;
        } else {
            for (int i = 0; i < index; i++){
                current_item = current_item.next;
            }
            node.next = current_item;
            node.previous = current_item.previous;
            current_item.previous.next = node;
            current_item.previous = node;
        }
    }


    public AbstractItem get(int itemNumber) {
        Node current_item = this.head;
        for (int i = 0; i < itemNumber; i++) {
            current_item = current_item.next;
        }
        return current_item.item;
    }

    public void remove(int itemNumber4) {
        Node current_item = this.head;
        for (int i = 0; i < itemNumber4; i++) {
            current_item = current_item.next;
        }
        current_item.previous.next = current_item.next;
        current_item.next.previous = current_item.previous;
        size--;
    }

    public String get_total_price() {
        Node current_item = this.head;
        int total_price = 0;
        while (current_item != null){
            total_price += current_item.item.getInteger_data()[0];
            current_item = current_item.next;
        }
        return String.valueOf(total_price);
    }

    public void remove_first() {
        Node current_item = this.head;
        current_item.next.previous = null;
        head = current_item.next;
        size--;
    }

    public void remove_last() {
        Node current_item = this.head;
        while (current_item.next != null){
            current_item = current_item.next;
        }
        current_item.previous.next = null;
        tail = current_item.previous;
        size--;
    }
}
