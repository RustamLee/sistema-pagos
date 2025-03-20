package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compra <T extends Pago> {
    private static int contador=0;
    private int idCompra;
    private final List<T> pagosDeCompra;

    public Compra(){
        this.idCompra = ++contador;
        this.pagosDeCompra = new ArrayList<>();
    }

    public void agregarPago(T pago) {
        pagosDeCompra.add(pago);
    }

    public List<T> obtenerPagos() {
        return pagosDeCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

}
