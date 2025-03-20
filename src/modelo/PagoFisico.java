package modelo;

public class PagoFisico extends Pago{
    private int id_local;

    public PagoFisico(double monto, int id_local) {
        super(monto);
        this.id_local = id_local;
    }


    @Override
    public void registrar() {

    }

    @Override
    public void procesar() {

    }

    @Override
    public boolean validar() {
        return false;
    }
}
