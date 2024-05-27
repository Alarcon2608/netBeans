/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funaltorden;

import java.util.function.IntBinaryOperator;

public class FunAltOrden {
    public static void main(String[] args) {
        IntBinaryOperator operation = (a, b) -> a * b;
        int result = performOperation(3, 5, operation);
        System.out.println("Resultado de la operación: " + result);
    }

    public static int performOperation(int a, int b, IntBinaryOperator operation) {
        return operation.applyAsInt(a, b);
    }
}

