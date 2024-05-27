/*
Nombre: Samuel Alarcón Granados 
Fecha:30/03/2024
Descripción: En este ejemplo, crearemos una función para contar la cantidad de 
números pares en un arreglo de enteros.
 */
package contadorpares;

import java.util.Scanner;

public class ContadorPares {

    public static int contarPares(int[] arreglo) {

        int contador = 0;
        for (int numero : arreglo) {
            if (numero % 2 == 0) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de numeros en el arreglo");
        int cantidadNumeros = scanner.nextInt();
        int[] arreglo = new int[cantidadNumeros];
        System.out.println("Ingrese los numeros del arreglo:");
        for (int i = 0; i < cantidadNumeros; i++) {
            arreglo[i] = scanner.nextInt();
        }
        scanner.close();
        int cantidadPares = contarPares(arreglo);
        System.out.print("La cantidad de numeros pares en el arreglo es:"
                + cantidadPares);
    }
}


