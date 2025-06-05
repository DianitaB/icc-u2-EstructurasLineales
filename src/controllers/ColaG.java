package controllers;

import java.util.EmptyStackException;

import models.NodeGeneric;
import models.Persona;

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
        while (current != null) {
            Persona persona = (Persona) current.getValue(); 
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona; 
            }
            current = current.getNext(); 
        }
        return null; 
    }

    public Persona removeByName(String nombre) {
        NodeGeneric<T> actuaal = primero;
        NodeGeneric<T> anterioir = null;
        if (isEmpty()) throw new EmptyStackException();
        while (actuaal != null) {
        Persona persona = (Persona) actuaal.getValue();
        if (persona.getNombre().equalsIgnoreCase(nombre)) {
            if (anterioir == null) {
                primero = actuaal.getNext(); // aqui se elimina al primeroo
                if (primero == null) {
                    ultimo = null; // dejamos vacia la 
                }
            } else {
                anterioir.setNext(actuaal.getNext()); // saltamos el nodo actual
                if (actuaal == ultimo) {
                    ultimo = anterioir; 
                }
            }
            size--;
            return persona; 
        }
        anterioir = actuaal;
        actuaal = actuaal.getNext();
    }
    return null; 
    }
}