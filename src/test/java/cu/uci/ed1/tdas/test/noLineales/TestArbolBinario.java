package cu.uci.ed1.tdas.test.noLineales;

import cu.uci.ed1.tdas.noLineales.ArbolBinario;
import cu.uci.ed1.tdas.noLineales.impl.ArbolBinarioImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author angel
 */
public class TestArbolBinario {
    
    ArbolBinario<Integer> arbol;
    
    public TestArbolBinario() {
        ArbolBinarioImpl<Integer> arbol9 = new ArbolBinarioImpl<>(9);
        ArbolBinarioImpl<Integer> arbol8 = new ArbolBinarioImpl<>(8);
        ArbolBinarioImpl<Integer> arbol1 = new ArbolBinarioImpl<>(1);
        ArbolBinarioImpl<Integer> arbol4 = new ArbolBinarioImpl<>(4, arbol9, arbol8);
        ArbolBinarioImpl<Integer> arbol5 = new ArbolBinarioImpl<>(5, null, arbol1);
        arbol = new ArbolBinarioImpl<>(2, arbol4, arbol5);
    }
    
    @Test void arbol(){
        assertEquals(2, arbol.raiz());
        assertEquals(2, arbol.peso());
        assertFalse(arbol.esVacio());
        assertFalse(arbol.esHoja());
    }
    
}
