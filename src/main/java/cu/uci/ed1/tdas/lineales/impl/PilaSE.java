package cu.uci.ed1.tdas.lineales.impl;

import cu.uci.ed1.tdas.lineales.Pila;

/**
 *
 * @author angel
 * @param <T>
 */
public class PilaSE<T> implements Pila<T> {

    NodoSE<T> tope;

    @Override
    public T cima() {
        if(tope!=null)
            return tope.getDato();
        else
            return null;
    }

    @Override
    public T extraer() {
        if(tope!=null){
            T dato = this.tope.getDato();
            tope = tope.getSiguiente();
            return dato;
        }else{
            return null;
        }
        
    }

    @Override
    public void adicionar(T elemento) {
        NodoSE<T> nodo = new NodoSE<>(elemento);
        nodo.setSiguiente(tope);
        tope = nodo;
    }

    @Override
    public boolean esVacia() {
        return tope==null;
    }
    

}
