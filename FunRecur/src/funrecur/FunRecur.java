/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funrecur;

import java.util.Scanner;

public class FunRecur {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un numero entero: ");
        int numero = scanner.nextInt();

        long factorial = 1;

        if (numero < 0) {
            System.out.println("El factorial de un número negativo no existe");
        } else {
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }
            System.out.println("El factorial de " + numero + " es: " + factorial);
        }
        scanner.close();
    }
}

