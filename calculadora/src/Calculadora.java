/*
Nombre: Samuel Alarcón Granados 
Fecha:10/02/2024
Docente:
Descripción: En este codigo se crea una calculadora con las cuatro operaciones
básicas
 */
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double num1, num2, resultado;
        char operador;
        int contador =0;

        System.out.println("Ingrese el primer numero: ");
        num1 = scanner.nextInt();

        System.out.println("Ingrese el segundo numero: ");
        num2 = scanner.nextInt();

        System.out.println("Ingrese el operador (+, -, *, /): ");
        operador = scanner.next().charAt(0);

        switch (operador) {
            case '+':
                resultado = num1 + num2;
                System.out.println("El resultado de la suma es: " + resultado);
                break;
            case '-':
                resultado = num1 - num2;
                System.out.println("El resultado de la resta es: " + resultado);
                break;
            case '*':
                resultado = num1 * num2;
                System.out.println("El resultado de la multiplicación es: " +
                        resultado);
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("El resultado de la division es: " + 
                            resultado);
                } else {
                    System.out.println("No es posible dividir entre cero.");
                }
                break;
            default:
                System.out.println("Operador no válido.");
        }
    }
}

