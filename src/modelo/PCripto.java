package modelo;

public class PCripto extends PagoVirtual{
    private int wallet_id;


    public PCripto(double monto, String email, int wallet_id) {
        super(monto, email);
        this.wallet_id=wallet_id;
    }
}
