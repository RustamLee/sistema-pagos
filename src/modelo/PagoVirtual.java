package modelo;

public class PagoVirtual extends Pago{
    private String email;

    public PagoVirtual(double monto,String email){
        super(monto);
        this.email = email;
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
