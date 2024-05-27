/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Controlador.controlador;
import Modelo.modelo;
import Vista.vista;

public class MVCBiblioteca{
    public static void main(String[] args) {
        vista view = new vista();
        controlador controlador = new controlador(modelo, vista);
        controlador.ejecutar();
    }
}
