/*
Nombre: Samuel Alarcón Granados 
Fecha:30/03/2024
Descripción: Este código permite al usuario ingresar los elementos de la matriz
3x3 y luego calcula la determinante de la matriz utilizando el método de 
expansión por cofactores.
 */
package JuegoMonedas;

import java.util.Scanner;

public class JuegoMonedas {

    public static void main(String[] args) {
        int opcion;
        int tablero[][] = new int[9][9];
        int i, j;
        int moneda;
        int moneditas = 0;
        int monedax, moneday;
        int personajex = 9, personajey = 0;
        int vida = 100;
        int minas = 3;
        int gasolina = 1;
        Scanner leer = new Scanner(System.in);

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                tablero[i][j] = 0;
            }
        }

        System.out.print("Tablero inicial\n\n");

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print("- ");
                }
                if (tablero[i][j] == 1) {
                    System.out.print("P ");
                }
                if (tablero[i][j] == 2) {
                    System.out.print("M ");
                }
                if (tablero[i][j] == 3) {
                    System.out.print("S ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        tablero[personajex][personajey] = 1;
        tablero[9][9] = 3;

        System.out.print("Tablero con Personaje y Salida\n\n");

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print("- ");

                    for (moneda = 1; moneda <= 5; moneda++) {
                        System.out.print("Digite en cual fila desea poner la moneda "
                                + moneda + ": ");
                        monedax = leer.nextInt();
                        System.out.print("Digite en cual columna desea poner la moneda "
                                + moneda + ": ");
                        moneday = leer.nextInt();

                        if (monedax < 0 || monedax > 9 || moneday < 0 || moneday > 9) {
                            System.out.print("\nSolo se pueden digitar "
                                    + "numeros entre 0 y 9\n\n");
                            moneda--;
                        } else {
                            if (tablero[monedax][moneday] == 0) {
                                tablero[monedax][moneday] = 2;
                            } else {
                                System.out.print("\nLa posición está ocupada\n\n");
                                moneda--;
                            }
                        }
                    }

                    // Colocar minas aleatoriamente
                    for (i = 0; i < minas; i++) {
                        int minax = (int) (Math.random() * 10);
                        int minay = (int) (Math.random() * 10);

                        if (tablero[minax][minay] == 0) {
                            tablero[minax][minay] = 4; // Representación de mina con el número 4
                        } else {
                            i--; // Volver a intentar colocar la mina en otra posición
                        }
                    }

                    // Colocar gasolina aleatoriamente
                    int gasolinax = (int) (Math.random() * 10);
                    int gasolinay = (int) (Math.random() * 10);

                    if (tablero[gasolinax][gasolinay] == 0) {
                        tablero[gasolinax][gasolinay] = 5; // Representación de gasolina con el número 5
                    }

                    System.out.print("\nTablero con Personaje, Salida, Monedas, Minas y Gasolina\n\n");

                    for (i = 0; i < 10; i++) {
                        for (j = 0; j < 10; j++) {
                            if (tablero[i][j] == 0) {
                                System.out.print("- ");
                            }
                            if (tablero[i][j] == 1) {
                                System.out.print("P ");
                            }
                            if (tablero[i][j] == 2) {
                                System.out.print("M ");
                            }
                            if (tablero[i][j] == 3) {
                                System.out.print("S ");
                            }
                            if (tablero[i][j] == 4) {
                                System.out.print("X "); // Minas X
                            }
                            if (tablero[i][j] == 5) {
                                System.out.print("G "); // Gasolina G
                            }
                        }
                        System.out.print("\n");
                    }
                    System.out.print("\n");

                    do {
                        System.out.print("JUEGO MONEDITAS\n\n");
                        System.out.print("[1] Derecha\n");
                        System.out.print("[2] Izquierda\n");
                        System.out.print("[3] Arriba\n");
                        System.out.print("[4] Abajo\n");
                        System.out.print("[5] Salir\n\n");
                        System.out.print("Digite una opción: ");
                        opcion = leer.nextInt();
                        switch (opcion) {
                            case 1:

                                if (personajey + 1 > 9) {
                                    tablero[personajex][personajey] = 1;
                                } else {
                                    if (tablero[personajex][personajey + 1] == 2) {
                                        tablero[personajex][personajey + 1] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajey++;
                                        moneditas++;
                                    } else if (tablero[personajex][personajey + 1] == 3) {
                                        tablero[personajex][personajey] = 0;
                                        if (moneditas == 5) {
                                            System.out.print("\nGanó - Monedas: " + moneditas + "\n");
                                            opcion = 5;
                                        } else {
                                            System.out.print("\nPerdió - Le faltaron "
                                                    + (5 - moneditas) + " Moneditas\n");
                                            opcion = 5;
                                        }
                                    } else if (tablero[personajex][personajey + 1] == 4) {
                                        tablero[personajex][personajey] = 0;
                                        vida -= 30;
                                        if (vida <= 0) {
                                            System.out.print("\nPerdió - Has quedado sin vida\n");
                                            opcion = 5;
                                        } else {
                                            System.out.print("\nTe has comido una mina -"
                                                    + " Vida restante: " + vida + "\n");
                                            opcion = 5;
                                        }
                                    } else if (tablero[personajex][personajey + 1] == 5) {
                                        tablero[personajex][personajey + 1] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajey++;
                                        vida += 20;
                                        if (vida > 100) {
                                            vida = 100;
                                        }
                                        System.out.print("\nRecogiste gasolina - "
                                                + "Vida actual: " + vida + "\n");
                                    } else {
                                        tablero[personajex][personajey + 1] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajey++;
                                    }
                                }

                                break;

                            case 2:

                                if (personajey - 1 < 0) {
                                    tablero[personajex][personajey] = 1;
                                } else {
                                    if (tablero[personajex][personajey - 1] == 2) {
                                        tablero[personajex][personajey - 1] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajey--;
                                        moneditas++;
                                    } else if (tablero[personajex][personajey - 1] == 3) {
                                        tablero[personajex][personajey] = 0;
                                        if (moneditas == 5) {
                                            System.out.print("\nGanó - Monedas: "
                                                    + moneditas + "\n");
                                            opcion = 5;
                                        } else {
                                            System.out.print("\nPerdió - Le faltaron "
                                                    + (5 - moneditas) + " Moneditas\n");
                                            opcion = 5;
                                        }
                                    } else if (tablero[personajex][personajey - 1] == 4) {
                                        tablero[personajex][personajey] = 0;
                                        vida -= 30;
                                        if (vida <= 0) {
                                            System.out.print("\nPerdió - Se quedó sin vida\n");
                                            opcion = 5;
                                        } else {
                                            System.out.print("\nChocó con una mina - "
                                                    + "Vida restante: " + vida + "\n");
                                            opcion = 5;
                                        }
                                    } else if (tablero[personajex][personajey - 1] == 5) {
                                        tablero[personajex][personajey - 1] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajey--;
                                        vida += 20;
                                        if (vida > 100) {
                                            vida = 100;
                                        }
                                        System.out.print("\nRecogió gasolina - Vida actual: "
                                                + "" + vida + "\n");
                                    } else {
                                        tablero[personajex][personajey - 1] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajey--;
                                    }
                                }

                                break;

                            case 3:

                                if (personajex - 1 < 0) {
                                    tablero[personajex][personajey] = 1;
                                } else {
                                    if (tablero[personajex - 1][personajey] == 2) {
                                        tablero[personajex - 1][personajey] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajex--;
                                        moneditas++;
                                    } else if (tablero[personajex - 1][personajey] == 3) {
                                        tablero[personajex][personajey] = 0;
                                        if (moneditas == 5) {
                                            System.out.print("\nGanó - Monedas: "
                                                    + moneditas + "\n");
                                            opcion = 5;
                                        } else {
                                            System.out.print("\nPerdió - Le faltaron "
                                                    + (5 - moneditas) + " Moneditas\n");
                                            opcion = 5;
                                        }
                                    } else if (tablero[personajex - 1][personajey] == 4) {
                                        tablero[personajex][personajey] = 0;
                                        vida -= 30;
                                        if (vida <= 0) {
                                            System.out.print("\nPerdió - "
                                                    + "Se quedó sin vida\n");
                                            opcion = 5;
                                        } else {
                                            System.out.print("\nTe has comido una mina - "
                                                    + "Vida restante: " + vida + "\n");
                                            opcion = 5;
                                        }
                                    } else if (tablero[personajex - 1][personajey] == 5) {
                                        tablero[personajex - 1][personajey] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajex--;
                                        vida += 20;
                                        if (vida > 100) {
                                            vida = 100;
                                        }
                                        System.out.print("\nRecogiste gasolina - "
                                                + "Vida actual: " + vida + "\n");
                                    } else {
                                        tablero[personajex - 1][personajey] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajex--;
                                    }
                                }

                                break;

                            case 4:

                                if (personajex + 1 > 9) {
                                    tablero[personajex][personajey] = 1;
                                } else {
                                    if (tablero[personajex + 1][personajey] == 2) {
                                        tablero[personajex + 1][personajey] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajex++;
                                        moneditas++;
                                    } else if (tablero[personajex + 1][personajey] == 3) {
                                        tablero[personajex][personajey] = 0;
                                        if (moneditas == 5) {
                                            System.out.print("\n HAS GANADO! -"
                                                    + " Monedas: " + moneditas + "\n");
                                            opcion = 5;
                                        } else {
                                            System.out.print("\nPERDISTE:( - Le faltaron "
                                                    + (5 - moneditas) + " Moneditas\n");
                                            opcion = 5;
                                        }
                                    } else if (tablero[personajex + 1][personajey] == 4) {
                                        tablero[personajex][personajey] = 0;
                                        vida -= 30;
                                        if (vida <= 0) {
                                            System.out.print("\nPERDISTE:( - "
                                                    + "Se quedó sin vida\n");
                                            opcion = 5;
                                        } else {
                                            System.out.print("\nTe has comido una mina - "
                                                    + "Vida restante: " + vida + "\n");
                                            opcion = 5;
                                        }
                                    } else if (tablero[personajex + 1][personajey] == 5) {
                                        tablero[personajex + 1][personajey] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajex++;
                                        vida += 20;
                                        if (vida > 100) {
                                            vida = 100;
                                        }
                                        System.out.print("\nRecogiste gasolina - "
                                                + "Vida actual: " + vida + "\n");
                                    } else {
                                        tablero[personajex + 1][personajey] = 1;
                                        tablero[personajex][personajey] = 0;
                                        personajex++;
                                    }
                                }

                                break;

                            case 5:
                                System.out.print("\nHasta luego\n");
                                break;

                            default:
                                System.out.print("\nOpción no válida\n");
                                break;
                        }
                    } while (opcion != 5);
                }
            }
        }
    }
}
