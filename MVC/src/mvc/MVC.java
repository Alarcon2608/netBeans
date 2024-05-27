/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc;

import Controlador.controlador;
import Modelo.modelo;
import Vista.vista;

/**
 *
 * @author DELL
 */
public class MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        modelo model = new modelo();
        vista view = new vista();
        controlador controller = new controlador(view, model);
        controller.calcular();
    }
    

}
