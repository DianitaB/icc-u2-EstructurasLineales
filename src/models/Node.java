package models;

public class Node {
    private int value;
    private Node next;

    public Node( int value){
        this.value = value; // valor del nodo
        this.next = null; // Referencia al siguiente nodo
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "next:" + next + "]";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    
}
