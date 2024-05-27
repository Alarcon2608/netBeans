/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arreglocalculadora;

import java.util.Scanner;

public class ArregloCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo numero: ");
        double num2 = scanner.nextDouble();

        double[] resultados = new double[4];

        resultados[0] = num1 + num2;
        resultados[1] = num1 - num2;
        resultados[2] = num1 * num2;
        resultados[3] = num1 / num2;

        System.out.println("Suma: " + resultados[0]);
        System.out.println("Resta: " + resultados[1]);
        System.out.println("Multiplicacion: " + resultados[2]);
        System.out.println("Division: " + resultados[3]);

        scanner.close();
    }
}
