/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.modelo;
import Vista.vista;

public class controlador {
    private modelo modelo;
    private vista vista;

    public controlador(modelo model, vista view) {
        this.modelo = model;
        this.vista = view;
    }

    public void ejecutar() {
        while (true) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Salir");
            System.out.print("Ingrese opción: ");
            
            int opcion = 0;
             switch (opcion) {
                case 1:
                    modelo libro = vista.pedirLibro();
                    modelo.agregarLibro(libro);
                    break;
                case 2:
                    vista.mostrarLibros(modelo.getLibros());
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
           
                    System.out.println("Opción inválida");
            }
        }
    }
