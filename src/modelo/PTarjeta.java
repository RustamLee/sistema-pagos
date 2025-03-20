package modelo;

import excepciones.PagoInvalidoException;

public class PTarjeta extends PagoFisico{
    private String numTarjeta;


    public PTarjeta(double monto, int id_local, String numTarjeta) throws PagoInvalidoException {
        super(monto, id_local);
        if (monto <= 0) {
            throw new PagoInvalidoException("El monto debe ser positivo.");
        }
        this.numTarjeta=numTarjeta;
    }

}
