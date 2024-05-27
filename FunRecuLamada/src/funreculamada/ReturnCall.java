/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funreculamada;

public class ReturnCall {
    public static void main(String[] args) {
        performOperation(10, 5, new Callback() {
            @Override
            public void callback(int result) {
                System.out.println("El resultado de la operación es: " + result);
            }
        });
    }

    public static void performOperation(int a, int b, Callback callback) {
        int result = a * b;
        callback.callback(result);
    }

    interface Callback {
        void callback(int result);
    }
}

