/*
Nombre: Samuel Alarcón Granados 
Fecha:30/03/2024
Descripción: Este codigo muestra una matriz representando un tablero de ajedrez
teniendo las piezas representadas con letras.
 */
package ajedrez;

public class Ajedrez {

    public static void main(String[] args) {

        char[][] tablero = {
            {'T', 'C', 'A', 'R', 'K', 'A', 'C', 'T'},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'|', 'x', '|', 'x', '|', 'x', '|', 'x'},
            {'x', '|', 'x', '|', 'x', '|', 'x', '|'},
            {'|', 'x', '|', 'x', '|', 'x', '|', 'x'},
            {'x', '|', 'x', '|', 'x', '|', 'x', '|'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'t', 'c', 'a', 'r', 'k', 'a', 'c', 't'}
        };
    
        mostrarMatriz(tablero);
    }
    public static void mostrarMatriz(char[][] tablero) {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();

        }
    }
}
   