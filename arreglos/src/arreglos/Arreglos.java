
/*
Nombre: Samuel Alarcón Granados 
Fecha:10/02/2024
Docente:
Descripción: En este código se desarrollara un arreglo que pida 5 números 
 */
 
package arreglos;

import java.util.Scanner;

public class Arreglos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arreglo = new int[5];

        System.out.println("ingrese 5 numeros:");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println("Los numeros ingresados son:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Elemento " + i + ": " + arreglo[i]);
        }
    }
}
