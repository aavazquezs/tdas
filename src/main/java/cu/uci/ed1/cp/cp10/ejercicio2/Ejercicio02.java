package cu.uci.ed1.cp.cp10.ejercicio2;

import cu.uci.ed1.tdas.noLineales.impl.ArbolBinarioImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class Ejercicio02 {
    public static void main(String[] args) {
        ArbolBinarioImpl<Integer> arbol4 = new ArbolBinarioImpl<>(4);
        ArbolBinarioImpl<Integer> arbol5 = new ArbolBinarioImpl<>(5);
        ArbolBinarioImpl<Integer> arbol6 = new ArbolBinarioImpl<>(6);
        
        ArbolBinarioImpl<Integer> arbol2 = new ArbolBinarioImpl<>(2, arbol4, arbol5);
        ArbolBinarioImpl<Integer> arbol3 = new ArbolBinarioImpl<>(3, null, arbol6);
        
        ArbolBinarioImpl<Integer> arbol1 = new ArbolBinarioImpl<>(1, arbol2, arbol3);
        
        ArbolBinarioImpl<Integer> clone = null;
        try {
             clone = arbol1.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error");
        }
        
        System.out.println(arbol1.aLoAncho().toString());
        System.out.println(clone.aLoAncho().toString());
        
    }
}
