package cu.uci.ed1.tdas.lineales.impl;

import cu.uci.ed1.tdas.lineales.Lista;

/**
 *
 * @author angel
 */
public class ListaDE<T> implements Lista<T> {

    protected NodoDE<T> cabeza;
    protected Integer longitud;

    public ListaDE() {
        this.longitud = 0;
        this.cabeza = null;
    }
    
    @Override
    public Integer longitud() {
        return this.longitud;
    }

    @Override
    public T obtener(Integer pos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adicionar(T x) throws Exception {
        
        NodoDE<T> nodo = new NodoDE<>(x);
        
        if(this.cabeza == null){
            this.cabeza = nodo;
        }else{
            NodoDE<T> cursor = this.cabeza;
            while(cursor.getSiguiente() != null){
                cursor = cursor.getSiguiente();
            }
            nodo.setAnterior(cursor);
            cursor.setSiguiente(nodo);
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
            while(currentPosition < this.longitud - 1 && cursor.getSiguiente()!=null){
                cursor = cursor.getSiguiente();
                currentPosition++;
            }
        }
    }

    @Override
    public void eliminar(Integer pos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
