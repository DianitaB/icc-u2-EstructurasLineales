package Materia.Ejercicio_01_sign;
import Controllers.StackG;

public class SignValidator {

    public boolean esValido(String cadena) {
        StackG<Character> pila = new StackG<>();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            if (caracter == '(' || caracter == '{' || caracter == '[') {
                pila.push(caracter);
            } else {
                if (pila.isEmpty()) return false;
                char top = pila.pop();
                if (caracter == ')') {
                    if (top != '(') return false;
                } else if (caracter == '}') {
                    if (top != '{') return false;
                } else if (caracter == ']') {
                    if (top != '[') return false;
                }
            }
        }
        return pila.isEmpty(); 
    }
}




