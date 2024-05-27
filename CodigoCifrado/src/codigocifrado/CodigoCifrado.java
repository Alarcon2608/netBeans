/*
Nombre: Samuel Alarcón Granados 
Fecha:10/04/2024
Descripción: En este codigo se podra desencriptar una palabra recorriendo 
el abecedario desde la letra ingresada hasta 4 casillas menos 
package codigocifrado;
 */

import java.util.Scanner;

import java.util.Scanner;

public class CodigoCifrado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la palabra:");
        String PEncriptada = scanner.nextLine();
        
        String fraseDesencriptada = desencriptarFrase(PEncriptada);
        
        System.out.println("La palabra desencriptada es: " + fraseDesencriptada);
        
        scanner.close();
    }
    
    public static String desencriptarFrase(String fraseEncriptada) {
        StringBuilder fraseDesencriptada = new StringBuilder();
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        
        for (int i = 0; i < fraseEncriptada.length(); i++) {
            char caracterEncriptado = fraseEncriptada.charAt(i);
            char caracterDesencriptado;
            
            if (Character.isLetter(caracterEncriptado)) {
                //para saber si la letra es parte del abecedario
                int indiceEncriptado = abecedario.indexOf(Character.toLowerCase
        (caracterEncriptado));
                //mantener la mayuscula o la minuscula
                int indiceDesencriptado = (indiceEncriptado - 4 + 
                        abecedario.length()) % abecedario.length();
                
                caracterDesencriptado = abecedario.charAt(indiceDesencriptado);
                
                if (Character.isUpperCase(caracterEncriptado)) {
                    caracterDesencriptado = Character.toUpperCase
        (caracterDesencriptado);
                }
            } else {
                caracterDesencriptado = caracterEncriptado;
            }
            
            fraseDesencriptada.append(caracterDesencriptado);
        }
        
        return fraseDesencriptada.toString();
    }
}
