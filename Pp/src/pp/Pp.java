
package pp;

import java.util.Scanner;

public class Pp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Persona persona = pedirDatos(sc);

        double imc = calcularIMC(persona.peso, persona.altura);

        mostrarResultado(persona.nombre, imc);
    }

    private static Persona pedirDatos(Scanner sc) {
        System.out.print("Introduzca su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduzca su peso (en kg): ");
        double peso = sc.nextDouble();

        System.out.print("Introduzca su altura (en metros): ");
        double altura = sc.nextDouble();

        return new Persona(nombre, peso, altura);
    }
    
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
    
    public static void mostrarResultado(String nombre, double IMC) {
        System.out.println("El IMC de " + nombre + " es: " + String.format
        ("%.2f", IMC));
    }
}
