/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.vista;
import Modelo.modelo;

/**
 *
 * @author DELL
 */
public class controlador {

    private vista view;
    private modelo model;

    public controlador(vista view, modelo model) {

        this.view = view;
        this.model = model;
    }

    //metodo calcular
    public void calcular() {
        view.mostrarVista("ingrese el primer numero");
        int n1 = view.getDato();

        view.mostrarVista("ingrese el segundo numero");
        int n2 = view.getDato();

        view.mostrarVista("seleccione la operacion que desea hacer + or -");
        char operador = view.getOperador();

        int resultado = 0;
        switch (operador){
            case '+':
                resultado=model.suma(n1, n2);
                break;
            case '-':
                resultado=model.resta(n1, n2);
        }
        
        view.mostrarVista("el resultado es " + resultado);
    }
}
