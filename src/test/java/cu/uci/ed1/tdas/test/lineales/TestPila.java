package cu.uci.ed1.tdas.test.lineales;

import cu.uci.ed1.tdas.lineales.Pila;
import cu.uci.ed1.tdas.lineales.impl.PilaSE;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lisset
 */
public class TestPila {
    
    public TestPila() {
    }
    
    @Test void adicionarYEsVacia(){
        Pila<Integer> pila = new PilaSE<>();
        assertTrue(pila.esVacia());
        pila.adicionar(1);
        assertFalse(pila.esVacia());
    }

    @Test void adicionarYExtraer(){
        Pila<Integer> pila = new PilaSE<>();
        pila.adicionar(1);
        pila.adicionar(2);
        assertEquals(2, pila.extraer());
        assertEquals(1, pila.extraer());
    }
    
    @Test void tope(){
        Pila<Integer> pila = new PilaSE<>();
        pila.adicionar(1);
        assertEquals(1, pila.cima());
        pila.adicionar(2);
        pila.adicionar(3);
        assertEquals(3, pila.cima());
    }
}
