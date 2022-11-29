package cu.uci.ed1.cp.cp10.ejercicio3;

import cu.uci.ed1.tdas.noLineales.impl.ArbolBinarioImpl;

/**
 *
 * @author angel
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        ArbolBinarioImpl<Integer> arbol4 = new ArbolBinarioImpl<>(4);
        ArbolBinarioImpl<Integer> arbol5 = new ArbolBinarioImpl<>(5);
        ArbolBinarioImpl<Integer> arbol6 = new ArbolBinarioImpl<>(6);
        
        ArbolBinarioImpl<Integer> arbol2 = new ArbolBinarioImpl<>(2, arbol4, arbol5);
        ArbolBinarioImpl<Integer> arbol3 = new ArbolBinarioImpl<>(3, null, arbol6);
        
        ArbolBinarioImpl<Integer> arbol1 = new ArbolBinarioImpl<>(1, arbol2, arbol3);
        
        System.out.println("Cantidad de hojas del arbol 1: "+ arbol1.cantidadDeHojas());
        System.out.println("Cantidad de hojas del arbol 3: "+ arbol3.cantidadDeHojas());
        System.out.println("Cantidad de hojas del arbol 4: "+ arbol4.cantidadDeHojas());
    }
}
