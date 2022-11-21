package cu.uci.ed1.tdas.lineales.impl;

import cu.uci.ed1.tdas.lineales.Cola;

/**
 *
 * @author angel
 */
public class ColaSE<T> implements Cola<T>{
    private NodoSE<T> frente;
    private NodoSE<T> fondo;

    @Override
    public T frente() {
        if(!esVacio()){
            return this.frente.getDato();
        }else{
            return null;
        }
    }

    @Override
    public T fondo() {
        if(!esVacio()){
            return this.fondo.getDato();
        }else{
            return null;
        }
    }

    @Override
    public T extraer() {
        if(esVacio()){
            return null;
        }
        T dato = this.frente.getDato();
        
        if(frente==fondo){
            frente = null;
            fondo = null;
        }else{
            this.frente = this.frente.getSiguiente();
        }

        return dato;
    }

    @Override
    public void adicionar(T elemento) {
        NodoSE<T> nodo = new NodoSE<>(elemento);
        if(fondo==null){
            frente = nodo;
            fondo = nodo;
        }else{
            fondo.setSiguiente(nodo);
            fondo = nodo;
        }
        
        
    }

    @Override
    public boolean esVacio() {
        return this.frente == null && this.fondo == null;
    }
}
