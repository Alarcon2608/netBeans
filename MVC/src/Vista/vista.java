/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class vista {

    private Scanner scanner;

    public vista() {
        scanner = new Scanner(System.in);

    }

    public void mostrarVista(String mensaje) {
        System.out.println(mensaje);

    }

    public int getDato() {
        return scanner.nextInt();

    }

    public char getOperador() {
        String entrada = scanner.next();
        char operador = entrada.charAt(0);
        return operador;
    }

}
