/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package area.de.un.circulo;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class AreaDeUnCirculo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de áreas");
        System.out.println("1. Calcular área de un cuadrado");
        System.out.println("2. Calcular área de un círculo");
        System.out.print("Ingrese su opción (1 o 2): ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el lado del cuadrado: ");
                double lado = scanner.nextDouble();
                double areaCuadrado = calcularAreaCuadrado(lado);
                System.out.println("El área del cuadrado es: " + areaCuadrado);
                break;
            case 2:
                System.out.print("Ingrese el radio del círculo: ");
                double radio = scanner.nextDouble();
                double areaCirculo = calcularAreaCirculo(radio);
                System.out.println("El área del círculo es: " + areaCirculo);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();
    }

    public static double calcularAreaCuadrado(double lado) {
        return lado * lado;
    }

    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}
