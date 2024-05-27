/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenciadeviajes;

import java.util.Scanner;

public class CalculadoraViaje {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char destino, claseVuelo;
        int dias;
        double costoTiquete = 0, costoHospedaje = 0, costoVehiculo = 0, precioViaje = 0, descuento = 0, precioDescuento = 0;

        System.out.print("Ingrese el destino (a: Atenas, b: Bogota, c: Cartagena, d: Dallas, e: Estambul): ");
        destino = scanner.next().charAt(0);

        System.out.print("Ingrese la cantidad de dias del viaje: ");
        dias = scanner.nextInt();

        System.out.print("¿Quiere volar en clase ejecutiva? (s/n): ");
        claseVuelo = scanner.next().charAt(0);

        // Calcular costo del tiquete
        switch (destino) {
            case 'a':
                costoTiquete = 5500000;
                break;
            case 'b':
                costoTiquete = 0; // Bogotá es el origen, no se cobra el tiquete
                break;
            case 'c':
                costoTiquete = 350000;
                break;
            case 'd':
                costoTiquete = 4000000;
                break;
            case 'e':
                costoTiquete = 6700000;
                break;
            default:
                System.out.println("Destino no valido.");
                return;
        }
        // Aplicar costo adicional por clase ejecutiva
        if (claseVuelo == 's') {
            costoTiquete *= 2; // Doble del precio normal
            // Calcular costo del hospedaje
            switch (destino) {
                case 'a':
                    costoHospedaje = 300000;
                    break;
                case 'b':
                    costoHospedaje = 150000;
                    break;
                case 'c':
                    costoHospedaje = 100000;
                    break;
                case 'd':
                    costoHospedaje = 400000;
                    break;
                case 'e':
                    costoHospedaje = 120000;
                    break;
            }

            // Aplicar descuento si el cliente viaja a 5 ciudades
            if (destino != 'b') {
                descuento = 0.1;
            }

            // Calcular costo del vehículo
            char tipoVehiculo;
            System.out.print("Ingrese el tipo de vehiculo (m: Moto, c: Carro, v: Camioneta): ");
            tipoVehiculo = scanner.next().charAt(0);

            switch (tipoVehiculo) {
                case 'm':
                    costoVehiculo = 70000;
                    break;
                case 'c':
                    costoVehiculo = 150000;
                    break;
                case 'v':
                    costoVehiculo = 300000;
                    break;
                default:
                    System.out.println("Tipo de vehiculo no válido.");
                    return;
            }

            // Calcular precio del viaje sin descuentos
            precioViaje = (costoTiquete * (dias > 1 ? dias : 1)) + (costoHospedaje * dias) + (costoVehiculo * dias);

            // Aplicar descuento
            precioDescuento = precioViaje - (precioViaje * descuento);

            // Mostrar reporte
            System.out.println("\n--- Reporte del Viaje ---");
            System.out.print("Destino: ");
            switch (destino) {
                case 'a':
                    System.out.println("Atenas");
                    break;
                case 'b':
                    System.out.println("Bogota");
                    break;
                case 'c':
                    System.out.println("Cartagena");
                    break;
                case 'd':
                    System.out.println("Dallas");
                    break;
                case 'e':
                    System.out.println("Estambul");
                    break;
            }
            System.out.println("Cantidad de dias: " + dias);
            System.out.println("Precio tiquetes: " + (costoTiquete * (dias > 1 ? dias : 1)));
            System.out.println("Precio hospedaje: " + (costoHospedaje * dias));
            System.out.println("Precio vehiculo: " + (costoVehiculo * dias));
            System.out.println("Precio del viaje sin descuentos: " + precioViaje);
            System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
            System.out.println("Precio con descuento: " + precioDescuento);

            scanner.close();
        }
    }
}
