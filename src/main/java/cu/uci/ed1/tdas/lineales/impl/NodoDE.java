package cu.uci.ed1.tdas.lineales.impl;

/**
 *
 * @author angel
 */
public class NodoDE<T> {
    protected T dato;
    protected NodoDE<T> anterior;
    protected NodoDE<T> siguiente;

    public NodoDE() {
        this.dato = null;
        this.siguiente = null;
        this.anterior = null;
    }

    public NodoDE(T dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDE<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDE<T> anterior) {
        this.anterior = anterior;
    }

    public NodoDE<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDE<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
