/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aa;

import java.util.Scanner;

public class PracticaFunciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos al usuario
        String nombre = pedirDatos(sc);
        double peso = pedirPeso(sc);
        double altura = pedirAltura(sc);

        // Calcular el IMC
        double imc = calcularIMC(peso, altura);

        // Mostrar el resultado
        mostrarResultado(nombre, imc);
    }

    private static String pedirDatos(Scanner sc) {
        System.out.print("Introduzca su nombre: ");
        return sc.nextLine();
    }

    private static double pedirPeso(Scanner sc) {
        System.out.print("Introduzca su peso (en kg): ");
        return sc.nextDouble();
    }

    private static double pedirAltura(Scanner sc) {
        System.out.print("Introduzca su altura (en metros): ");
        return sc.nextDouble();
    }

    private static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    private static void mostrarResultado(String nombre, double imc) {
        System.out.println("--------------------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("IMC: " + String.format("%.2f", imc));
        System.out.println("--------------------------------------");
    }
}
