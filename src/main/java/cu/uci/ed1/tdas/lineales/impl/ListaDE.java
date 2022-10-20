package cu.uci.ed1.tdas.lineales.impl;

import cu.uci.ed1.tdas.lineales.Lista;
import java.util.Iterator;

/**
 *
 * @author angel
 */
public class ListaDE<T> implements Lista<T> {

    protected NodoDE<T> cabeza;
    protected NodoDE<T> ultimo;
    protected Integer longitud;

    public ListaDE() {
        this.longitud = 0;
        this.cabeza = null;
        this.ultimo = null;
    }
    
    @Override
    public Integer longitud() {
        return this.longitud;
    }

    @Override
    public T obtener(Integer pos) throws Exception {
        if(pos<0 || pos>=this.longitud){
            throw new Exception("ERROR: ListaDE.obtener() bad index");
        }
        NodoDE<T> cursor = this.cabeza;
        Integer posicionActual = 0;
        while(posicionActual < pos){
            cursor = cursor.getSiguiente();
            posicionActual++;
        }
        return cursor.getDato();
    }

    @Override
    public void adicionar(T x) throws Exception {
        
        NodoDE<T> nodo = new NodoDE<>(x);
        
        if(this.cabeza == null){
            this.cabeza = nodo;
            this.ultimo = nodo;
        }else{
            this.ultimo.setSiguiente(nodo);
            nodo.setAnterior(this.ultimo);
            this.ultimo = nodo;
        }
        
        this.longitud++;
    }

    @Override
    public void insertar(T x, Integer pos) throws Exception {
        if(pos <0 || pos>= this.longitud){
            throw new Exception("Posicion fuera de rango");
        }
        
        NodoDE<T> nodo = new NodoDE<>(x);
        
        if(pos == 0){
            nodo.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(nodo);
            this.cabeza = nodo;
        }else{
            Integer currentPosition = 0;
            NodoDE<T> cursor = this.cabeza;
            while(currentPosition < pos && cursor.getSiguiente()!=null){
                cursor = cursor.getSiguiente();
                currentPosition++;
            }
            NodoDE<T> anterior = cursor.getAnterior();
            anterior.setSiguiente(nodo);
            nodo.setAnterior(anterior);
            nodo.setSiguiente(cursor);
            cursor.setAnterior(nodo);
            
        }
        this.longitud++;
    }

    @Override
    public void eliminar(Integer pos) throws Exception {
        if(pos<0 || pos>=this.longitud){
            throw new Exception("ERROR: ListaDE.eliminar() bad index");
        }
        NodoDE<T> cursor = this.cabeza;
        Integer posicionActual = 0;
        while(posicionActual < pos){
            cursor = cursor.getSiguiente();
            posicionActual++;
        }
        
        if(cursor.equals(this.cabeza)){
            NodoDE<T> sgte = cursor.getSiguiente();
            sgte.setAnterior(null);
            this.cabeza = sgte;
        }else if(cursor.equals(this.ultimo)){
            NodoDE<T> anterior = cursor.getAnterior();
            anterior.setSiguiente(null);
            this.ultimo = anterior;
        }else{
            NodoDE<T> anterior = cursor.getAnterior();
            NodoDE<T> sgte = cursor.getSiguiente();
            anterior.setSiguiente(sgte);
            sgte.setAnterior(anterior);
        }
        this.longitud--;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        String cadena = "[";
        NodoDE<T> cursor = this.cabeza;
        if(cursor!=null){
            cadena += cursor.getDato().toString();
            cursor = cursor.getSiguiente();
        }
        while(cursor!=null){
            cadena += ","+cursor.getDato().toString();
            cursor = cursor.getSiguiente();
        }
        cadena += "]";
        return cadena;
    }
    
}
