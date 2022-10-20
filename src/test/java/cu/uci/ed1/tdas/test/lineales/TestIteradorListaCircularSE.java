package cu.uci.ed1.tdas.test.lineales;

import cu.uci.ed1.tdas.lineales.Lista;
import cu.uci.ed1.tdas.lineales.impl.ListaCircularSE;
import cu.uci.ed1.tdas.lineales.impl.ListaSE;
import cu.uci.ed1.tdas.lineales.impl.ListaCircularSE.IteradorListaCircularSE;
import java.util.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lisset
 */
public class TestIteradorListaCircularSE {
    
    public TestIteradorListaCircularSE() {
    }
    
    @Test public void iterar() throws Exception{
        Lista<Integer> lista = new ListaCircularSE<>();
        //adicionando los elementos de la lista fibonnaci
        lista.adicionar(1);
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(5);
        lista.adicionar(8);
        lista.adicionar(13);
        lista.adicionar(21);
        
        
        Iterator<Integer> it = lista.iterator();
        Assertions.assertTrue(it.hasNext());
        
        String cadena = "[";
        cadena += it.next();
        while(it.hasNext()){
            Integer valor = it.next();
            cadena += ","+valor;
        }
        cadena += "]";
        
        Assertions.assertEquals("[1,1,2,3,5,8,13,21]",cadena);
        
        Iterator<Integer> it2 = lista.iterator();
        //eliminar los valores pares
        
        while(it2.hasNext()){
            Integer valor = it2.next();
            if(valor%2 == 0){
                it2.remove();
            }
        }
        
        Assertions.assertEquals("[1,1,3,5,13,21]",lista.toString());
        
    }
    
    @Test public void iteraPosicionImpar() throws Exception{
        ListaCircularSE<Integer> lista = new ListaCircularSE<>();
        //adicionando los elementos de la lista fibonnaci
        lista.adicionar(1);
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(5);
        lista.adicionar(8);
        lista.adicionar(13);
        lista.adicionar(21);
        
    }
    
}
