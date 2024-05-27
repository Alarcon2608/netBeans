
import java.util.Scanner;

public class BorradorCine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 8;
        int cols = 8;
        Seat[][] seats = new Seat[rows][cols];
        initializeSeats(seats);

        displaySeats(seats);

        while (true) {
            bookSeat(seats);
            System.out.println("¿Desea reservar otro asiento? (s/n)");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }

        displaySeats(seats);
    }

    public static void initializeSeats(Seat[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    public static void displaySeats(Seat[][] seats) {
        System.out.println("Estado de los asientos:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].isAvailable()) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public static void bookSeat(Seat[][] seats) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de fila y número de asiento que desea reservar:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (row >= 1 && row <= seats.length && col >= 1 && col <= seats[0].length) {
            if (seats[row - 1][col - 1].isAvailable()) {
                seats[row - 1][col - 1].setAvailable(false);
                System.out.println("¡Reserva exitosa!");
            } else {
                System.out.println("¡Lo siento, ese asiento ya está ocupado!");
            }
        } else {
            System.out.println("¡Número de fila o asiento inválido!");
        }
    }

    public static class Seat {
        private boolean available;

        public Seat() {
            this.available = true;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }
}