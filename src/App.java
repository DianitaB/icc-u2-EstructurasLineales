import Controllers.Cola;
import Controllers.ColaG;
import Controllers.Stack;
import Controllers.StackG;
import Materia.Ejercicio_01_sign.SignValidator;
import Models.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        
        Stack stack = new Stack();

        stack.push(10);
        stack.push(-1);
        stack.push(5);
        stack.push(8);

        System.out.println("Tam = " + stack.size());
        stack.printStack();

        stack.pop();

        stack.peek();

        System.out.println("Tam = " + stack.size());
        stack.printStack();

        //Stack genérica
        StackG<Integer> stackGint = new StackG<Integer>();
        stackGint.push(1);
        stackGint.push(4);
        stackGint.printStack();

        StackG<String> stackGStrinG = new StackG<String>();
        stackGStrinG.push("Uno");
        stackGStrinG.push("Cuatro");
        stackGStrinG.printStack();

        // COLAS
        Cola cola = new Cola();
        cola.add(5);
        cola.add(7);
        cola.add(10);
        System.out.println("Tam = " + cola.size);
        cola.printCola();
        cola.remove();
        System.out.println("Tam =  " + cola.size);
        cola.printCola();

        // Tarea
        Persona p1 = new Persona("Pablito");
        Persona p2 = new Persona("Juan");
        Persona p3 = new Persona("Maria");

        ColaG<Persona> colaPersonas = new ColaG<Persona>();
        colaPersonas.add(p1);
        colaPersonas.add(p2);
        colaPersonas.add(p3);
        System.out.println(colaPersonas.getSize());
        colaPersonas.printCola();
        System.out.println("Atiende a la persona -> " + colaPersonas.remove());
        System.out.println(colaPersonas.getSize());
        colaPersonas.printCola();

        colaPersonas.findByName("David");
        System.out.println("Encontrado: " + colaPersonas.findByName("Maria"));
       
        Persona pEliminada = colaPersonas.removeByName("Juan");
        System.out.println("Eliminado: " + pEliminada);

        SignValidator signValidator = new SignValidator();
        System.out.println("Input: ([]){} -> " + signValidator.esValido("([]){}")); 
        System.out.println("Input: ({)} -> " + signValidator.esValido("({)}"));     
        System.out.println("Input: (([]{)) -> " + signValidator.esValido("(([]))")); 
        System.out.println("Input: ([)] -> " + signValidator.esValido("([)]"));
        System.out.println("Input: ([]){} -> " + signValidator.esValido("([]){}"));


       

    }
}