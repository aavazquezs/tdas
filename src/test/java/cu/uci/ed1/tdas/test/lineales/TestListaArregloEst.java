/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cu.uci.ed1.tdas.test.lineales;

import cu.uci.ed1.tdas.lineales.Lista;
import cu.uci.ed1.tdas.lineales.impl.ListaArregloEst;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lisset
 */
public class TestListaArregloEst {
    
    public TestListaArregloEst() {
    }
     @Test public void adicionar() throws Exception {
         Lista<Integer> lista = new ListaArregloEst<>(10);
         assertEquals(0, lista.longitud()); //inicialmente en cero
         lista.adicionar(1);
         lista.adicionar(2);
         lista.adicionar(3);
         assertEquals(3, lista.longitud());
         
         assertThrows(Exception.class, ()->{
             lista.adicionar(4);
             lista.adicionar(5);
             lista.adicionar(6);
             lista.adicionar(7);
             lista.adicionar(8);
             lista.adicionar(9);
             lista.adicionar(10);
             lista.adicionar(11);
         });
         
     }
     
     @Test public void obtener() throws Exception{
         
         Lista<String> listaStr = new ListaArregloEst<>(10);
         
         listaStr.adicionar("uno");
         listaStr.adicionar("dos");
         listaStr.adicionar("tres");
         
         assertEquals("uno", listaStr.obtener(0));
         assertEquals("tres",listaStr.obtener(2));
         
         Exception thrown = assertThrows(Exception.class, ()->{listaStr.obtener(3);});
     }
     
     @Test public void eliminar() throws Exception{
         Lista<Integer> lista = new ListaArregloEst<>(10);
         lista.adicionar(1);
         lista.adicionar(2);
         lista.adicionar(3);
         lista.adicionar(4);
         lista.adicionar(5);
         lista.adicionar(6);
         lista.adicionar(7);
         lista.adicionar(8);
         lista.adicionar(9);
         
         lista.eliminar(0); //elimino el primero
         assertEquals(8, lista.longitud()); //la longitud se decrementa en 1
         assertEquals(2, lista.obtener(0)); //ahora en la primera posicion esta el 2
         
         lista.eliminar(4); //elimino el elemento de la 5ta posicion. 
         assertEquals(7, lista.obtener(4)); //comprobar si ahora se encuentra en la 5ta posicion el 7.
         
         assertThrows(Exception.class, ()->{
             lista.eliminar(10);
         });
     }
     
     @Test public void insertar() throws Exception{
         Lista<Integer> lista = new ListaArregloEst<>(10);
         lista.adicionar(1);
         lista.adicionar(2);
         lista.adicionar(3);
         lista.adicionar(4);
         lista.adicionar(5);
         lista.insertar(0, 0);
         assertEquals(6, lista.longitud()); //se incremento la longitud
         assertEquals(0, lista.obtener(0)); //el elemento de la posicion 0 es 0
         lista.insertar(10, 3);
         assertEquals(10, lista.obtener(3));//ahora el elemento en la posicion 3 es 10.
         
     }
}
