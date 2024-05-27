/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesmatriz;

/**
 *
 * @author DELL
 */
public class OperacionesArreglos {
    private int filas = 0;
    private int col = 0;
    private int arreglonumeros [][] = new int [filas][col];

   
    public int getFilas() {
        return filas;
    }

   
    public void setFilas(int filas) {
        this.filas = filas;
    }


    public int getCol() {
        return col;
    }

   
    public void setCol(int col) {
        this.col = col;
    }

    
    public int[][] getArreglonumeros() {
        return arreglonumeros;
    }

  
    public void setArreglonumeros(int[][] arreglonumeros) {
        this.arreglonumeros = arreglonumeros;
    }
    
    
}
