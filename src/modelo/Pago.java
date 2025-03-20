package modelo;

import interfaces.PagoProcesable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Pago implements PagoProcesable {
    private static int contador=0;
    private int idPago;
    private double monto;
    private LocalDateTime fechaDePago;
    private List<Pago> lista;

    public Pago(double monto) {
        this.idPago = +contador;
        this.monto = monto;
        this.fechaDePago = LocalDateTime.now();
        this.lista = new ArrayList<>();
    }


    public int getIdPago() {
        return idPago;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", monto=" + monto +
                ", fechaDePago=" + fechaDePago +
                '}';
    }
}
