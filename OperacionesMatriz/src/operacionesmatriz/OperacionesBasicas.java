/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesmatriz;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class OperacionesBasicas extends OperacionesArreglos implements Operaciones {

    Scanner leer = new Scanner(System.in);

    @Override
    public void resta() {
        System.out.println("Ingrese la cantidad de números");
        double numeros = leer.nextDouble();
        double resultado = 0;
        System.out.println("Ingrese el numero");

        resultado = leer.nextDouble();

        for (int i = 0; i < numeros - 1; i++) {
            System.out.println("ingrese el numero " + (i + 2));
            resultado -= leer.nextDouble();

        }

        System.out.println("El resultado es " + resultado);

    }

    //metodo para llenar arreglo
    public void llenar() {
        OperacionesArreglos operar = new OperacionesArreglos();
        int filas = leer.nextInt();
        operar.setFilas(filas);
        operar.setCol(operar.getFilas());
        int[][] datosarreglo = new int[operar.getFilas()][operar.getCol()];
        for (int i = 0; i < datosarreglo.length; i++) {
            for (int j = 0; j < datosarreglo[i].length; j++) {
                Random aleatorio = new Random();
                datosarreglo[i][j] = aleatorio.nextInt(100);
            }
        }

        operar.setArreglonumeros(datosarreglo);

    }

    public void mostrarmenu() {
        System.out.println("Bienvenidos");
        System.out.println("1 para suma");
        System.out.println("2 para mostrar matriz");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                resta();
            case 2:
                llenar();
                break;
        }
    }

    public int getarreglonumeros() {
        for (int i = 0; i < arreglonumeros.length; i++) {
            for (int j = 0; j < arreglonumeros.length; j++) {

            }
        }
        System.out.println();

    }
}