package gestion;

import java.util.Scanner;

public class InputHelper {

    public static String inputString( Scanner scanner, String parametro) {
        while (true){
            System.out.print("Ingrese " + parametro );
            String input = scanner.nextLine();
            if(input.isBlank()) {
                System.out.println("El "+parametro+" no puede ser vacio!");
                continue;
            }
            return input;
        }
    }

    public static int inputInteger(Scanner scanner, String parametro) {
        while (true) {
            System.out.print("Ingrese " + parametro + ": ");
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (java.util.InputMismatchException e) {
                System.out.println("El " + parametro + " debe ser un número entero válido!");
                scanner.nextLine();
            }
        }
    }


}
