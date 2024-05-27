/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package promedio1;

import java.util.Scanner;

public class Promedio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de numeros a promediar: ");
        int cantnum = scanner.nextInt();

        int suma = 0;
        for (int i = 1; i <= cantnum; i++) {
            System.out.print("Ingrese el numero " + i + ": ");
            int numero = scanner.nextInt();
            suma += numero;
        }

        double promedio = (double) suma / cantnum;

        System.out.println("El promedio de los numeros ingresados es: "
                + promedio);

        scanner.close();
    }
}
