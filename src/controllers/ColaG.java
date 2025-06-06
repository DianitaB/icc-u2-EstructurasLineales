package Controllers;

import java.util.EmptyStackException;

import Models.NodeGeneric;
import Models.Persona;

public class ColaG<T> {

    private NodeGeneric<T> primero;
    private NodeGeneric<T> ultimo;
    private int size;

    public ColaG() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public void add(T value) {
        NodeGeneric<T> nuevo = new NodeGeneric<>(value);
        if (isEmpty()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setNext(nuevo);
            ultimo = nuevo;
        }
        size++;
    }

    public T remove() {
        if (isEmpty()) throw new EmptyStackException();
        T value = primero.getValue();
        primero = primero.getNext();
        size--;
        return value;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public int getSize() {
        return size;
    }

    public void printCola() {
        NodeGeneric<T> current = primero;
        while (current != null) {
            System.out.print(current.getValue() + " | ");
            current = current.getNext();
        }
        System.out.println();
    }

    public Persona findByName(String nombre) {
        NodeGeneric<T> current = primero;
        while (current != null) { // recorremos la lista mientras no lleguemos al final    
            Persona persona = (Persona) current.getValue(); 
            if (persona.getNombre().equalsIgnoreCase(nombre)) { // comparamos el nombre actual ignorando may/min con el nombre buscado
                return persona; // si encuentra - retorna la persona 
            }
            current = current.getNext();  // si no coincide avanza al siguiente nodo 
        }
        return null;  // si no encuentra nada retorna null 
    }

    public Persona removeByName(String nombre) { // recibe una persona y la elimina     
        NodeGeneric<T> actuaal = primero;
        NodeGeneric<T> anterioir = null; // lleva el anterioir nodo al actual 
        if (isEmpty()) throw new EmptyStackException(); // si la cola esta vacia lanza error
        while (actuaal != null) { // recorre noodo por nodo 
        Persona persona = (Persona) actuaal.getValue();
        if (persona.getNombre().equalsIgnoreCase(nombre)) {
            if (anterioir == null) { // sig: el nodo actual es el primeor de la cola 
                primero = actuaal.getNext(); // aqui se elimina al primeroo
                if (primero == null) {
                    ultimo = null; // dejamos vacia la 
                }
            } else {
                anterioir.setNext(actuaal.getNext()); // saltamos el nodo actual
                if (actuaal == ultimo) {
                    ultimo = anterioir;  //  si el nodo actual era el último, actualizamos el puntero ultimo
                }
            }
            size--;
            return persona; 
        }
        anterioir = actuaal;
        actuaal = actuaal.getNext(); // si no encontro nada avanzamos el anterior y el actual 
    }
    return null; 
    }
}