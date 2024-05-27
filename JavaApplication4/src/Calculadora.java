import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            double num1, num2, resultado;
            char operador;

            System.out.println("Ingrese el primer numero: ");
            num1 = scanner.nextDouble();

            System.out.println("Ingrese el segundo numero: ");
            num2 = scanner.nextDouble();

            System.out.println("Ingrese el operador (+, -, *, /, %): ");
            operador = scanner.next().charAt(0);

            switch (operador) {
                case '+':
                    resultado = num1 + num2;
                    System.out.println("El resultado de la suma es: " + resultado);
                    break;
                case '%':
                    resultado = num1 % num2;
                    System.out.println("El resultado del mod es: " + resultado);
                    break;
                case '-':
                    resultado = num1 - num2;
                    System.out.println("El resultado de la resta es: " + resultado);
                    break;
                case '*':
                    resultado = num1 * num2;
                    System.out.println("El resultado de la multiplicación es: " +
                            resultado);
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2;
                        System.out.println("El resultado de la division es: " +
                                resultado);
                    } else {
                        System.out.println("No es posible dividir entre cero.");
                    }
                    break;
                default:
                    System.out.println("Operador no válido.");
            }

            // Preguntar al usuario si desea salir o continuar
            System.out.println("¿Desea realizar otra operación? (Sí/No)");
            String continuar = scanner.next();
            if (continuar.equalsIgnoreCase("No")) {
                salir = true;
            }
        }
    }
}

    

