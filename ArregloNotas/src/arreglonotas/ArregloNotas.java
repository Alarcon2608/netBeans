/*
Nombre: Samuel Alarcón Granados 
Fecha:10/02/2024
Docente:
Descripción: En este código se hará un programa que permita gestionar las 
calificaciónes de los estudantes de un curso.
 */
package arreglonotas;

import java.util.Scanner;

public class ArregloNotas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese los estudiantes del curso: ");
        int n = scanner.nextInt();

        int[] calificaciones = new int[n];

        System.out.println("Ingrese las notas:");
        for (int i = 0; i < n; i++) {
            System.out.print("Estudiante " + (i + 1) + ": ");
            calificaciones[i] = scanner.nextInt();
        }

        int calificacionMaxima = calificaciones[0];
        int calificacionMinima = calificaciones[0];
        int sumaCalificaciones = 0;

        for (int calificacion : calificaciones) {
            if (calificacion > calificacionMaxima) {
                calificacionMaxima = calificacion;
            }
            if (calificacion < calificacionMinima) {
                calificacionMinima = calificacion;
            }
            sumaCalificaciones += calificacion;
        }

        double promedio = (double) sumaCalificaciones / n;

        int excelente = 0, bueno = 0, regular = 0, insuficiente = 0;
        for (int calificacion : calificaciones) {
            if (calificacion >= 90) {
                excelente++;
            } else if (calificacion >= 70) {
                bueno++;
            } else if (calificacion >= 50) {
                regular++;
            } else {
                insuficiente++;
            }
        }
        System.out.println("<3----------------------------------- ");
        System.out.println("Nota mas alta: " + calificacionMaxima);
        System.out.println("Nota mas baja: " + calificacionMinima);
        System.out.println("Promedio de notas: " + promedio);

        System.out.println("<3----------------------------------- ");
        System.out.println("Excelente (90 a 100): " + excelente 
                + " estudiantes");
        System.out.println("Bueno (70 a 89): " + bueno + " estudiantes");
        System.out.println("Regular (50 a 69): " + regular + " estudiantes");
        System.out.println("Insuficiente (menos de 50): " + insuficiente 
                + " estudiantes");

    }
}
