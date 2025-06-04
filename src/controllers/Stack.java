package controllers;

import java.util.EmptyStackException;
import models.Node;

//PILAS
public class Stack {
    
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Método q ingrese una valor int
    public void push(int value){

        Node newNode = new Node(value);
        newNode.setNext(top); 
        top = newNode; 
    }

    public int pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int value = top.getValue();
        top = top.getNext();

        return value;
    }

    public int peek() {
        
        if (isEmpty()) 
            throw new EmptyStackException();
        return top.getValue();
        
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
    Node current = top;
    while (current != null) {
        System.out.print(current.getValue() + " ");
        current = current.getNext();
    }
    System.out.println(); 
    }

    public int size() {
    Node aux = top;
    int count = 0;
        while (aux != null) {
            aux = aux.getNext();
            count++;
        }
    return count;
    }

} 
