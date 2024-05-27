/*
Nombre: Samuel Alarcón Granados 
Fecha:30/03/2024
Descripción: 
 */
package cine; // Define el paquete cine

import java.util.Scanner; // Importa la clase Scanner para leer la entrada del usuario

public class Cine { // Declara la clase Cine
    public static void main(String[] args) { // Método principal
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

        int filas = 8; // Número de filas de asientos
        int columnas = 8; // Número de columnas de asientos

        Seat[][] seats = new Seat[filas][columnas]; // Matriz de asientos
        initializeSeats(seats); // Inicializa los asientos como disponibles

        displaySeats(seats); // Muestra el estado inicial de los asientos

        // Bucle para permitir al usuario reservar asientos
        while (true) {
            bookSeat(seats); // Método para reservar un asiento
            System.out.println("¿Desea reservar otro asiento? (s/n)"); // Pregunta al usuario si desea continuar
            String choice = scanner.next(); // Lee la respuesta del usuario
            if (choice.equalsIgnoreCase("n")) { // Si la respuesta es "n" (sin importar mayúsculas o minúsculas)
                break; // Salir del bucle
            }
        }

        displaySeats(seats); // Muestra el estado final de los asientos
    }

    // Método para inicializar los asientos como disponibles
    public static void initializeSeats(Seat[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(); // Crea un nuevo objeto Seat para cada asiento
            }
        }
    }

    // Método para mostrar el estado de los asientos
    public static void displaySeats(Seat[][] seats) {
        System.out.println("Estado de los asientos:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].isAvailable()) {
                    System.out.print("O "); // Mostrar "O" si el asiento está disponible
                } else {
                    System.out.print("X "); // Mostrar "X" si el asiento está ocupado
                }
            }
            System.out.println(); // Nueva línea para la próxima fila de asientos
        }
    }

    // Método para reservar un asiento
    public static void bookSeat(Seat[][] seats) {
        Scanner scanner = new Scanner(System.in); // Objeto Scanner para leer la entrada del usuario
        System.out.println("Ingrese el número de fila y número de asiento que desea reservar:");
        int row = scanner.nextInt(); // Leer número de fila
        int col = scanner.nextInt(); // Leer número de asiento

        if (row >= 1 && row <= seats.length && col >= 1 && col <= seats[0].length) { // Verificar si la fila y columna son válidas
            if (seats[row - 1][col - 1].isAvailable()) { // Verificar si el asiento está disponible
                seats[row - 1][col - 1].setAvailable(false); // Marcar el asiento como ocupado
                System.out.println("¡Reserva exitosa!"); // Mensaje de reserva exitosa
            } else {
                System.out.println("¡Lo siento, ese asiento ya está ocupado!"); // Mensaje de asiento ocupado
            }
        } else {
            System.out.println("¡Número de fila o asiento inválido!"); // Mensaje de fila o asiento inválido
        }
    }

    // Clase interna para representar un asiento
    public static class Seat {
        private boolean available; // Estado de disponibilidad del asiento

        // Constructor para inicializar un asiento como disponible
        public Seat() {
            this.available = true; // Asigna true para indicar que el asiento está disponible
        }

        // Método para verificar la disponibilidad del asiento
        public boolean isAvailable() {
            return available; // Devuelve el estado de disponibilidad del asiento
        }

        // Método para establecer la disponibilidad del asiento
        public void setAvailable(boolean available) {
            this.available = available; // Asigna el estado de disponibilidad del asiento
        }
    }
}