package modelo;

public class PEfectivo extends PagoFisico{
    private int vuelto;

    public PEfectivo(double monto, int id_local, int vuelto) {
        super(monto, id_local);
        this.vuelto = vuelto;
    }
}
