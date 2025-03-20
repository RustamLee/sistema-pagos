import gestion.GestorCompras;
import gestion.GestorPagos;
import modelo.Pago;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestorCompras<Pago> gestorCompras = new GestorCompras<>();
        gestorCompras.iniciarCompra(scanner);
        GestorPagos gestorPagos = gestorCompras.getGestorPagos();
        gestorPagos.mostrar();

    }
}