package cu.uci.ed1.tdas.noLineales.impl;

import cu.uci.ed1.tdas.lineales.Cola;
import cu.uci.ed1.tdas.lineales.Lista;
import cu.uci.ed1.tdas.lineales.impl.ColaSE;
import cu.uci.ed1.tdas.lineales.impl.ListaSE;
import cu.uci.ed1.tdas.noLineales.ArbolBinario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class ArbolBinarioImpl<T> implements ArbolBinario<T>{

    protected T raiz;
    protected ArbolBinarioImpl<T> izq;
    protected ArbolBinarioImpl<T> der;

    /**
     * Arbol vacio
     */
    public ArbolBinarioImpl() {
        this.raiz = null;
        this.izq = null;
        this.der = null;
    }

    /**
     * Crea un arbol hoja. Tiene raiz, pero no tiene hijos.
     * @param raiz 
     */
    public ArbolBinarioImpl(T raiz) {
        this.raiz = raiz;
        this.izq = null;
        this.der = null;
    }

    public ArbolBinarioImpl(T raiz, ArbolBinarioImpl<T> izq, ArbolBinarioImpl<T> der) {
        this.raiz = raiz;
        this.izq = izq;
        this.der = der;
    }
    
    @Override
    public ArbolBinario<T> crearVacio() {
        ArbolBinarioImpl<T> vacio = new ArbolBinarioImpl<>();
        return vacio;
    }

    @Override
    public T raiz() {
        return this.raiz;
    }

    @Override
    public boolean esVacio() {
        return this.raiz==null && this.izq == null && this.der == null;
    }

    /**
     * Equivalente a la altura
     * @return 
     */
    @Override
    public Integer peso() {
        if(this.esHoja()){
            return 0;
        }
        Integer pesoIzq = this.izq.peso();
        Integer pesoDer = this.der.peso();
        if(pesoIzq > pesoDer){
            return pesoIzq + 1;
        }else{
            return pesoDer + 1;
        }
    }

    @Override
    public void copiaEn(ArbolBinario<T> nuevoArbol) {
        ((ArbolBinarioImpl<T>)nuevoArbol).raiz = this.raiz;
        ArbolBinarioImpl<T> copiaIzq = new ArbolBinarioImpl<>();
        this.izq.copiaEn(copiaIzq);
        ArbolBinarioImpl<T> copiaDer = new ArbolBinarioImpl<>();
        this.der.copiaEn(copiaDer);
    }

    @Override
    public ArbolBinario<T> devolverIzquierdo() {
        return this.izq;
    }

    @Override
    public ArbolBinario<T> devolverDerecho() {
        return this.der;
    }

    @Override
    public Lista<T> preOrden() {
        Lista<T> resultado = new ListaSE<>();
        visitarEnPreOrden(resultado);
        return resultado;
    }
    
    private void visitarEnPreOrden(Lista<T> lista){
        try {
            lista.adicionar(this.raiz);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.izq.visitarEnPreOrden(lista);
        this.der.visitarEnPreOrden(lista);
    }

    @Override
    public Lista<T> entreOrden() {
        Lista<T> resultado = new ListaSE<>();
        visitarEnEntreOrden(resultado);
        return resultado;
    }
    
    private void visitarEnEntreOrden(Lista<T> lista){
        this.izq.visitarEnEntreOrden(lista);
        try {
            lista.adicionar(this.raiz);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.der.visitarEnEntreOrden(lista);
    }

    @Override
    public Lista<T> postOrden() {
        Lista<T> resultado = new ListaSE<>();
        visitarEnPostOrden(resultado);
        return resultado;
    }
    
    private void visitarEnPostOrden(Lista<T> lista){
        this.izq.visitarEnPostOrden(lista);
        this.der.visitarEnPostOrden(lista);
        try {
            lista.adicionar(this.raiz);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Lista<T> aLoAncho() {
        Lista<T> lista = new ListaSE<>();
        Cola<ArbolBinarioImpl<T>> cola = new ColaSE<>();
        cola.adicionar(this);
        while(!cola.esVacio()){
            ArbolBinarioImpl<T> actual = cola.extraer();
            try {
                lista.adicionar(actual.raiz);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            if(actual.izq!=null)
                cola.adicionar(actual.izq);
            if(actual.der!=null)
                cola.adicionar(actual.der);
        }
        return lista;
    }

    @Override
    public boolean esHoja() {
        return this.izq == null && this.der == null;
    }
    
    /**
     * Ejercicio 1 de la clase practica 10
     */
    public boolean encontrarElemento(T elem){
        if(this.raiz.equals(elem)){
            return true;
        }else{
            boolean estaIzq = false;
            boolean estaDer = false;
            
            if(this.izq != null)
                estaIzq = this.izq.encontrarElemento(elem);
            
            if(this.der != null)
                estaDer = this.der.encontrarElemento(elem);
            
            return estaIzq || estaDer;
        }
    }
    
    /**
     * Ejercicio 2
     * @return
     * @throws CloneNotSupportedException 
     */
    @Override
    public ArbolBinarioImpl<T> clone() throws CloneNotSupportedException {
        ArbolBinarioImpl<T> clone = new ArbolBinarioImpl<>();
        clone.raiz = this.raiz;
        if(this.izq!=null)
            clone.izq = this.izq.clone();
        
        if(this.der!=null)
            clone.der = this.der.clone();
        
        return clone;
    }
    /**
     * Ejercicio 3
     * @return 
     */
    public Integer cantidadDeHojas(){
        if(this.esHoja()){
            return 1;
        }
        Integer cantIzq = 0, cantDer = 0;
        if(izq!=null)
            cantIzq = izq.cantidadDeHojas();
        if(der!=null)
            cantDer = der.cantidadDeHojas();
        return cantIzq + cantDer;
    }
    
    /**
     * Ejercicio 4
     */
    public Integer cantidadDeNodosPorNivel(Integer k){
        
        if(k < 0)
            return 0;
        
        if(k == 0 && !esVacio())
            return 1;
        
        Integer cantIzq = 0, cantDer = 0;
        
        if(izq!=null)
            cantIzq = izq.cantidadDeNodosPorNivel(k-1);
        
        if(der!=null)
            cantDer = der.cantidadDeNodosPorNivel(k-1);
        
        return cantIzq + cantDer;
    }
    
}
