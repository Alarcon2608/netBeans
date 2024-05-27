/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.modelo;
import java.util.ArrayList;
 import java.util.Scanner;

public class vista {
    private Scanner scanner;

    public vista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarLibros(ArrayList<modelo> libros) {
        for (modelo libro : libros) {
            System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor());
        }
    }

    public modelo pedirLibro() {
        System.out.print("Ingrese título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese autor del libro: ");
        String autor = scanner.nextLine();
        return new modelo(titulo, autor);
    }
}

