package cu.uci.ed1.cp.cp5.ejercicio3;

import cu.uci.ed1.tdas.lineales.impl.ListaSE;
import cu.uci.ed1.tdas.lineales.impl.NodoSE;

/**
 *
 * @author angel
 */
public class Ejercicio3ListaSE<T> extends ListaSE<T> {
    
    public void eliminarIntermitente(){
        
        NodoSE<T> cursor = this.cabeza;
        
        while(cursor!=null){
        
            if(cursor.getSiguiente() != null){ //eliminar al siguente
                
                cursor.setSiguiente(cursor.getSiguiente().getSiguiente());
                
            }
            
            cursor = cursor.getSiguiente();
            
        }
        
    }
    
}
