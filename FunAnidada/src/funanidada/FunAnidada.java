/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funanidada;

public class FunAnidada {
    public static void main(String[] args) {
        int result = outerFunction(3, 5);
        System.out.println("Resultado: " + result);
    }

    public static int outerFunction(int a, int b) {
        return innerFunction(a, b);
    }

    private static int innerFunction(int a, int b) {
        return a + b;
    }
}

