package cu.uci.ed1.cp.cp5.ejercicio4;

import cu.uci.ed1.tdas.lineales.impl.ListaDE;
import cu.uci.ed1.tdas.lineales.impl.NodoDE;

/**
 *
 * @author angel
 * @param <T>
 */
public class Coleccion<T> extends ListaDE<T>{
    
    public void invertir() throws Exception{
        
        NodoDE<T> tail = this.ultimo;
        
        this.cabeza = null;
        
        this.ultimo = null;
        
        NodoDE<T> cursor = tail;
        
        while(cursor!=null){
            
            this.adicionar(cursor.getDato());
            
            cursor = cursor.getAnterior();
            
        }
        
    }
    
}
