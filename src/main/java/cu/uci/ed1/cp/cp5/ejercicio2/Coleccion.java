package cu.uci.ed1.cp.cp5.ejercicio2;

import cu.uci.ed1.tdas.lineales.impl.ListaSE;
import cu.uci.ed1.tdas.lineales.impl.NodoSE;

/**
 *
 * @author angel
 */
public class Coleccion extends ListaSE<Integer>{

    public Coleccion() {
    }
    
    public boolean esZigZag(){
        
        boolean esZigZag = true;
        
        NodoSE<Integer> cursor = this.cabeza;
        
        int posActual = 0;
        
        while(cursor != null && !esZigZag){
            
            if(posActual %2 ==0 && cursor.getDato() % 2 == 1 //posicion par y valor impar
                    || posActual % 2 == 1 && cursor.getDato() % 2 == 0){ //posicion impar y valor par
                
                esZigZag = false;
                
            }
            
            posActual++;
            
            cursor = cursor.getSiguiente();
            
            
        }
        
        return esZigZag;
        
    }
    
}
