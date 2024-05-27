/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package polindrok;

import java.util.Scanner;

public class VerificadorPalindromo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Verificador de palíndromos");
        System.out.print("Ingrese una palabra: ");
        
        String palabra = scanner.nextLine();
        
        if (esPalindromo(palabra)) {
            System.out.println("La palabra '" + palabra + "' es un palíndromo.");
        } else {
            System.out.println("La palabra '" + palabra + "' no es un palíndromo.");
        }
        
        scanner.close();
    }
    
    public static boolean esPalindromo(String palabra) {
        // Eliminamos los espacios en blanco y convertimos la palabra a minúsculas
        palabra = palabra.replaceAll("\\s+", "").toLowerCase();
        
        // Verificamos si la palabra es igual a su reverso
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(longitud - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
