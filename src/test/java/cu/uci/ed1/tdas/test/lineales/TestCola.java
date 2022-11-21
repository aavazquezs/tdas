package cu.uci.ed1.tdas.test.lineales;

import cu.uci.ed1.tdas.lineales.Cola;
import cu.uci.ed1.tdas.lineales.impl.ColaSE;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lisset
 */
public class TestCola {
    
    public TestCola() {
    }
    
    @Test void adicionarYEsVacio(){
        Cola<Integer> cola = new ColaSE<>();
        
        assertTrue(cola.esVacio());
        
        cola.adicionar(1);
        cola.adicionar(2);
        
        assertFalse(cola.esVacio());
        
    }
    
    @Test void extraer(){
        Cola<Integer> cola = new ColaSE<>();
        cola.adicionar(3);
        cola.adicionar(6);
        cola.adicionar(9);
        assertEquals(3, cola.frente());
        cola.extraer();
        assertEquals(6, cola.frente());
    }
    
    @Test void frenteYFondo(){
         Cola<Integer> cola = new ColaSE<>();
         
         cola.adicionar(1);
         cola.adicionar(3);
         cola.adicionar(5);
         
         assertEquals(1, cola.frente());
         assertEquals(5, cola.fondo());
         
         
    }
}
