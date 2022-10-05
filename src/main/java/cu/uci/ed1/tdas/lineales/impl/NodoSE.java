package cu.uci.ed1.tdas.lineales.impl;

/**
 *
 * @author angel
 */
public class NodoSE<T> {
    
    private T dato;
    private NodoSE<T> siguiente;

    public NodoSE(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoSE(T dato, NodoSE<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoSE<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSE<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
