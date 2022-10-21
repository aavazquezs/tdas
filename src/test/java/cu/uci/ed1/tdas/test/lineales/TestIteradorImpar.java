/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cu.uci.ed1.tdas.test.lineales;

import cu.uci.ed1.tdas.lineales.Lista;
import cu.uci.ed1.tdas.lineales.impl.ListaCircularSE;
import java.util.Iterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lisset
 */
public class TestIteradorImpar {
    
    public TestIteradorImpar() {
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
        
        Assertions.assertEquals("[1,3,8,21]",cadena);
        
    }
    
}
