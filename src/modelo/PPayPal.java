package modelo;

public class PPayPal extends PagoVirtual{
    private int id_cuenta;


    public PPayPal(double monto, String email, int id_cuenta) {
        super(monto, email);
        this.id_cuenta = id_cuenta;
    }
}
