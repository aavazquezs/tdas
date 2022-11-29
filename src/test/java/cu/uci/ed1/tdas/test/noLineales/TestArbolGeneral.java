package cu.uci.ed1.tdas.test.noLineales;

import cu.uci.ed1.tdas.lineales.Lista;
import cu.uci.ed1.tdas.noLineales.ArbolGeneral;
import cu.uci.ed1.tdas.noLineales.impl.ArbolGeneralImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author angel
 */
public class TestArbolGeneral {
    
    ArbolGeneral<Integer> arbol;
    
    public TestArbolGeneral() {
        
        arbol = new ArbolGeneralImpl<>(1);
        
        ArbolGeneral<Integer> arbol6 = new ArbolGeneralImpl<>(6);
        ArbolGeneral<Integer> arbol7 = new ArbolGeneralImpl<>(7);
        ArbolGeneral<Integer> arbol8 = new ArbolGeneralImpl<>(8);
        ArbolGeneral<Integer> arbol9 = new ArbolGeneralImpl<>(9);
        ArbolGeneral<Integer> arbol10 = new ArbolGeneralImpl<>(10);
        
        ArbolGeneral<Integer> arbol3 = new ArbolGeneralImpl<>(3);
        arbol3.adicionarSubArbol(arbol6);
        arbol3.adicionarSubArbol(arbol7);
        
        ArbolGeneral<Integer> arbol4 = new ArbolGeneralImpl<>(4);
        arbol4.adicionarSubArbol(arbol8);
        
        ArbolGeneral<Integer> arbol5 = new ArbolGeneralImpl<>(5);
        arbol5.adicionarSubArbol(arbol9);
        arbol5.adicionarSubArbol(arbol10);
        
        arbol.adicionarSubArbol(arbol3);
        arbol.adicionarSubArbol(arbol4);
        arbol.adicionarSubArbol(arbol5);
        
    }
    
    @Test void arbol(){
        assertEquals(1, arbol.raiz());
        assertEquals(3, arbol.grado());
        assertEquals(3, arbol.altura());
        assertFalse(arbol.esHoja());
    }
    
    @Test void preOrden(){
        Lista<Integer> preOrden = arbol.preOrden();
        String cadena = preOrden.toString();
        assertEquals("[1,3,6,7,4,8,5,9,10]", cadena);
    }
    
    @Test void entreOrden(){
        Lista<Integer> entreOrden = arbol.entreOrden();
        String cadena = entreOrden.toString();
        assertEquals("[6,3,7,1,8,4,9,5,10]", cadena);
    }
    
    @Test void postOrden(){
        Lista<Integer> postOrden = arbol.postOrden();
        String cadena = postOrden.toString();
        assertEquals("[6,7,3,8,4,9,10,5,1]", cadena);
    }
    
    @Test void aLoAncho(){
        Lista<Integer> aLoAncho = arbol.aLoAncho();
        String cadena = aLoAncho.toString();
        assertEquals("[1,3,4,5,6,7,8,9,10]", cadena);
    }
    
    @Test void copiaEnTest(){
        ArbolGeneralImpl<Integer> nuevoArbol = new ArbolGeneralImpl<>(0);
        arbol.copiaEn(nuevoArbol);
        Lista<Integer> aLoAnchoCopia = nuevoArbol.aLoAncho();
        assertEquals("[1,3,4,5,6,7,8,9,10]",aLoAnchoCopia.toString());
    }
}
