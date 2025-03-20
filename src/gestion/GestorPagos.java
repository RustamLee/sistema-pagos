package gestion;

import modelo.Pago;
import java.util.HashMap;
import java.util.Map;

public class GestorPagos <T extends Pago> {
    private Map<Integer,T> colleccionPagos;

    public GestorPagos() {
        this.colleccionPagos = new HashMap<>();
    }

    public void agregar (T pago){
        colleccionPagos.put(pago.getIdPago(), pago);
    }

    public void mostrar (){
        for(T item: colleccionPagos.values()){
            System.out.println(item);
        }
    }

}
