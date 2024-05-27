/*
Nombre: Samuel Alarcón Granados 
Fecha:30/03/2024
Descripción: Este código permite al usuario ingresar los elementos de la matriz
3x3 y luego calcula la determinante de la matriz utilizando el método de 
expansión por cofactores.
 */
import java.util.Scanner;

public class Matriz3x3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[3][3];
        System.out.println("Ingrese los elementos de la matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("La matriz ingresada es:");
        mostrarMatriz(matriz);

        int determinante = calcularDeterminante(matriz);

        System.out.println("El determinante de la matriz es: " + determinante);

        scanner.close();
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int calcularDeterminante(int[][] matriz) {

        // Aplicar la fórmula del determinante: (a*e*i) + (b*f*g) + (c*d*h) 
        //- (g*e*c) - (h*f*a) - (i*d*b)
        int determinante
                = (matriz[0][0] * matriz[1][1] * matriz[2][2])
                + (matriz[0][1] * matriz[1][2] * matriz[2][0])
                + (matriz[0][2] * matriz[1][0] * matriz[2][1])
                - (matriz[0][2] * matriz[1][1] * matriz[2][0])
                - (matriz[0][1] * matriz[1][0] * matriz[2][2]);

        return determinante;

    }

}
