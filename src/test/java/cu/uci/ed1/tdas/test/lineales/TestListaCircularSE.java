package cu.uci.ed1.tdas.test.lineales;

import cu.uci.ed1.tdas.lineales.Lista;
import cu.uci.ed1.tdas.lineales.impl.ListaCircularSE;
import cu.uci.ed1.tdas.lineales.impl.ListaDE;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lisset
 */
public class TestListaCircularSE {
    
    public TestListaCircularSE() {
    }
    @Test public void adicionar() throws Exception{
        Lista<Integer> lista = new ListaCircularSE<>();
        assertEquals(0, lista.longitud()); //inicialmente en cero
         lista.adicionar(1);
         lista.adicionar(2);
         lista.adicionar(3);
         assertEquals(3, lista.longitud());
    }
    
   @Test public void obtener() throws Exception{
         
         Lista<String> listaStr = new ListaCircularSE<>();
         
         listaStr.adicionar("uno");
         listaStr.adicionar("dos");
         listaStr.adicionar("tres");
         
         assertEquals("uno", listaStr.obtener(0));
         assertEquals("tres",listaStr.obtener(2));
         
         assertThrows(Exception.class, ()->{listaStr.obtener(3);});
     }
     
     @Test public void eliminar() throws Exception{
         Lista<Integer> lista = new ListaCircularSE<>();
         lista.adicionar(1);
         lista.adicionar(2);
         lista.adicionar(3);
         lista.adicionar(4);
         lista.adicionar(5);
         lista.adicionar(6);
         lista.adicionar(7);
         lista.adicionar(8);
         lista.adicionar(9);
         
         lista.eliminar(0);                     //elimino el primero
         assertNotEquals(1, lista.obtener(0));  //el primero no puede ser 1
         assertEquals(8, lista.longitud());     //la longitud se decrementa en 1
         assertEquals(2, lista.obtener(0));     //ahora en la primera posicion esta el 2
         
         lista.eliminar(4); //elimino el elemento de la 5ta posicion. 
         assertEquals(7, lista.obtener(4)); //comprobar si ahora se encuentra en la 5ta posicion el 7.
         
         assertThrows(Exception.class, ()->{
             lista.eliminar(10);
         });
     }
     
     @Test public void insertar() throws Exception{
         
         Lista<Integer> lista = new ListaCircularSE<>();
         lista.adicionar(1);
         lista.adicionar(2);
         lista.adicionar(3);
         lista.adicionar(4);
         lista.adicionar(5);
         assertEquals(5, lista.longitud()); //la longitud es 5
         lista.insertar(0, 0);
         assertEquals(6, lista.longitud()); //se incremento la longitud
         assertEquals(0, lista.obtener(0)); //el elemento de la posicion 0 es 0
         lista.insertar(10, 3);
         assertEquals(10, lista.obtener(3));//ahora el elemento en la posicion 3 es 10.
         
     }
     
     @Test public void toStringTest() throws Exception{
         ListaCircularSE<Integer> lista = new ListaCircularSE<>();
         
         assertEquals("[]", lista.toString());
         
         lista.adicionar(1);
         lista.adicionar(2);
         lista.adicionar(3);
         lista.adicionar(4);
         lista.adicionar(5);
         
         assertEquals("[1,2,3,4,5]", lista.toString());
     }
}
