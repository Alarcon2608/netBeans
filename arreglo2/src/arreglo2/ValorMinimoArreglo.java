/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arreglo2;

public class ValorMinimoArreglo {
    
    public static int encontrarMinimo(int[] arreglo) {
        if (arreglo.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío.");
        }
        
        int minimo = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] < minimo) {
                minimo = arreglo[i];
            }
        }
        return minimo;
    }
    
    public static void main(String[] args) {
        int[] arreglo = {5, 2, 8, 1, 9};
        int minimo = encontrarMinimo(arreglo);
        System.out.println("El valor mínimo en el arreglo es: " + minimo);
    }
}

