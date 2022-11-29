package cu.uci.ed1.cp.cp10.ejercicio1;

import cu.uci.ed1.tdas.noLineales.impl.ArbolBinarioImpl;

/**
 *
 * @author angel
 */
public class Ejercicio01 {
    public static void main(String[] args) {
        ArbolBinarioImpl<Integer> arbol4 = new ArbolBinarioImpl<>(4);
        ArbolBinarioImpl<Integer> arbol5 = new ArbolBinarioImpl<>(5);
        ArbolBinarioImpl<Integer> arbol6 = new ArbolBinarioImpl<>(6);
        
        ArbolBinarioImpl<Integer> arbol2 = new ArbolBinarioImpl<>(2, arbol4, arbol5);
        ArbolBinarioImpl<Integer> arbol3 = new ArbolBinarioImpl<>(3, null, arbol6);
        
        ArbolBinarioImpl<Integer> arbol1 = new ArbolBinarioImpl<>(1, arbol2, arbol3);
        
        boolean esta5 = arbol1.encontrarElemento(5);
        System.out.println("¿Esta el elemento 5?: "+(esta5?"si":"no"));
        
        boolean esta7 = arbol1.encontrarElemento(7);
        System.out.println("¿Esta el elemento 7?: "+(esta7?"si":"no"));
    }
}
