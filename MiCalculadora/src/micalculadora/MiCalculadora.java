/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package micalculadora;

import java.util.Scanner;

public class MiCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese el primer numero");
        double n1 = scanner.nextDouble();
        System.out.println("ingrese el segundo numero");
        double n2 = scanner.nextDouble();
        

        Calculadora calcular = new Calculadora();

        System.out.println("La resta es:" + calcular.resta(n1, n2));
        System.out.println("La suma es:" + calcular.suma(n1, n2));
        System.out.println("La multiplicacion es:" + calcular.multi(n1, n2));
        System.out.println("La division es:" + calcular.division(n1, n2));
    }

}
