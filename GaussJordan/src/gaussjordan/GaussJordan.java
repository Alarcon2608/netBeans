/*
Nombre: Samuel Alarcón Granados - Johan Arley Cardenas Ruiz 
Fecha:12/04/2024
Descripción: Este código permite al usuario ingresar los elementos de la matriz
3x3 y luego calcula la determinante de la matriz utilizando el método de 
gauss jordan.
 */
package gaussjordan;

import java.util.Scanner;

public class GaussJordan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[3][4];

        System.out.println("Introduce los coeficientes de la ecuación "
                + "lineal 3x3:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Fila " + (i + 1) + ", Columna " 
                        + (j + 1) + ": ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    double factor = matriz[i][k] / matriz[k][k];
                    for (int j = k; j < 4; j++) {
                        matriz[i][j] -= factor * matriz[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            double x = matriz[i][3] / matriz[i][i];
            System.out.println("x" + (i + 1) + " = " + x);
        }
        

        scanner.close();
    }
}
