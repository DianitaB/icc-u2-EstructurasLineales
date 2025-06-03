package controllers;
import java.util.EmptyStackException;

import models.Node;
// Stack - es nuestra lista, nuestra caja, nuestro contenedor, nuestra estructura de datos 
public class Stack { 
    private Node top;
    
    public Stack(){
        this.top = null;
    }
    // Metodo que ingrese un valor int
    public void push(int getValue){
        Node newNode = new Node(getValue); // Instanciar
        newNode.setNext(top); //¿Porque top? -> porque top es null
        top = newNode; // 
    }
    
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException(); // Error: Vacío 
        }
        int value = top.getValue();
        top = top.getNext(); // Esta linea elimina al anterior
        return value;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException(); // Error: Vacío 
        }
        return top.getValue();
    }

    public boolean isEmpty(){
        return top == null;
    }
    public void printStack(){
        System.out.println();
        
    }
}
