package gestion;

import excepciones.PagoInvalidoException;
import modelo.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestorCompras<Pago> {

    private GestorPagos<modelo.Pago> gestorPagos;

    public GestorCompras() {
        this.gestorPagos = new GestorPagos<>();
    }

    public GestorPagos<modelo.Pago> getGestorPagos() {
        return gestorPagos;
    }

    public void iniciarCompra(Scanner scanner) {
        double montoTotal = obtenerMonto(scanner, "el monto total:");
        double saldoRestante = montoTotal;
        System.out.println("El monto total de la compra es: " + montoTotal);
        saldoRestante = realizarPago(scanner, saldoRestante);

        if (saldoRestante > 0) {
            System.out.println("Saldo restante: " + saldoRestante);
            System.out.println("Puedes pagar el saldo restante con otro método.");
            saldoRestante = realizarPago(scanner, saldoRestante);
        }

        if (saldoRestante > 0) {
            System.out.println("No se pudo completar el pago. La compra ha sido cancelada.");
        } else {
            System.out.println("¡Compra pagada completamente!");
        }
    }

    private double realizarPago(Scanner scanner, double saldoRestante) {
        listaMetodosDePago("Elige el método de pago.");
        int option = scanner.nextInt();
        scanner.nextLine();

        double subTotal;
        switch (option) {
            case 1: // Pago cripto
                subTotal = obtenerMonto(scanner, "Monto en criptomonedas:");
                if (subTotal > saldoRestante) {
                    System.out.println("No puedes pagar más de lo que falta! Falta: " + saldoRestante);
                    return saldoRestante;
                }
                String email = InputHelper.inputString(scanner, "email");
                int walletId = InputHelper.inputInteger(scanner, "wallet id");
                gestorPagos.agregar(new PCripto(subTotal, email, walletId));
                break;

            case 2: // Pago PayPal
                subTotal = obtenerMonto(scanner, "Monto en PayPal:");
                if (subTotal > saldoRestante) {
                    System.out.println("No puedes pagar más de lo que falta!");
                    return saldoRestante;
                }
                String email2 = InputHelper.inputString(scanner, "email");
                int idCuenta = InputHelper.inputInteger(scanner, "id cuenta");
                gestorPagos.agregar(new PPayPal(subTotal, email2, idCuenta));
                break;

            case 3: // Pago tarjeta
                subTotal = obtenerMonto(scanner, "Monto en tarjeta:");
                if (subTotal > saldoRestante) {
                    System.out.println("No puedes pagar más de lo que falta!");
                    return saldoRestante;
                }
                String numTarjeta = InputHelper.inputString(scanner, "numero de tarjeta");
                int idLocal = InputHelper.inputInteger(scanner, "id local");
                try {
                    gestorPagos.agregar(new PTarjeta(subTotal, idLocal, numTarjeta));
                } catch (PagoInvalidoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 4: // Pago efectivo
                subTotal = obtenerMonto(scanner, "Monto en efectivo:");
                if (subTotal > saldoRestante) {
                    System.out.println("No puedes pagar más de lo que falta!");
                    return saldoRestante;
                }
                int idLocal2 = InputHelper.inputInteger(scanner, "id local2");
                int idvuelta = InputHelper.inputInteger(scanner, "id vuelta");
                gestorPagos.agregar(new PEfectivo(subTotal, idLocal2, idvuelta));
                break;

            case 5: // Salir
                System.out.println("Cancelando pago...");
                return saldoRestante;

            default:
                System.out.println("Opción no válida, intenta de nuevo.");
                return saldoRestante;
        }

        return saldoRestante - subTotal;
    }

    public double obtenerMonto(Scanner scanner, String parametro) {
        double monto = 0.0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Especifique " + parametro);
                monto = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número válido.");
                scanner.nextLine();
            }
        }
        return monto;
    }

    public void listaMetodosDePago(String parametro) {
        System.out.println(parametro);
        System.out.println("1. Pago Cripto.");
        System.out.println("2. Pago PayPal.");
        System.out.println("3. Pago Tarjeta.");
        System.out.println("4. Pago Efectivo.");
        System.out.println("5. Salir");
    }


}
