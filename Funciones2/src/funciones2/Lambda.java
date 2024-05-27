/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones2;

import java.util.function.IntBinaryOperator;

public class Lambda {

    public static void main(String[] args) {
        IntBinaryOperator add = (a, b) -> a + b;
        int result = add.applyAsInt(3, 5);
        System.out.println("Suma usando función lambda: " + result);
    }
}
