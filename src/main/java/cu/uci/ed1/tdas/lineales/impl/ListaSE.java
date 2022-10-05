package cu.uci.ed1.tdas.lineales.impl;

import cu.uci.ed1.tdas.lineales.Lista;

/**
 *
 * @author angel
 * @param <T>
 */
public class ListaSE<T> implements Lista<T> {

    protected  NodoSE<T> cabeza;
    
    protected Integer longitud;

    public ListaSE() {
        this.cabeza = null;
        this.longitud = 0;
    }

    @Override
    public Integer longitud() {
        longitud = 0;
        NodoSE<T> cursor = this.cabeza;
        
        while(cursor!=null){
            longitud++;
            cursor = cursor.getSiguiente();
        }
        
        return longitud;
    }

    @Override
    public T obtener(Integer pos) throws Exception {
        
        if(pos<0 || pos>= this.longitud){
            throw new Exception("Posicion fuera de indice");
        }
        
        Integer currentPosition = 0;
        NodoSE<T> cursor = this.cabeza;
        while(cursor.getSiguiente()!=null && currentPosition < pos){
            cursor = cursor.getSiguiente();
            currentPosition++;
        }
        return cursor.getDato();
    }

    @Override
    public void adicionar(T x) throws Exception {
        if(this.cabeza == null){ // esta vacia
            this.cabeza = new NodoSE<>(x);
        }else{ // contiene elementos
            NodoSE<T> nodo = new NodoSE<>(x); //un nodo con la info que deseo adicionar
            NodoSE<T> cursor = this.cabeza;   //un cursor para moverme por la lista enlazada
            while(cursor.getSiguiente()!=null){ //mientras no encontremos al ultimo nodo
                cursor = cursor.getSiguiente(); //movemos el cursor al siguiente nodo
            }
            cursor.setSiguiente(nodo);  //adicionamos el nodo con la info al final de la lista enlazada
        }
        
        this.longitud++; //incrementamos la longitud en 1
        
    }

    @Override
    public void insertar(T x, Integer pos) throws Exception {
        if(pos<0 || pos>= this.longitud){
            throw new Exception("Posicion fuera de indice");
        }
        
        NodoSE<T> nodo = new NodoSE<>(x);
        
        if(pos == 0){ //si se va a insertar en la primera posicion
            nodo.setSiguiente(this.cabeza);
            this.cabeza = nodo;
        }else{
            //mover el cursor hasta la posicion anterior a donde queremos guardar el nuevo elemento
            NodoSE<T> cursor = this.cabeza;
            Integer currentPosition = 0;
            while(cursor.getSiguiente()!=null && currentPosition < pos - 1){
                cursor = cursor.getSiguiente();
                currentPosition++;
            }
            if(cursor.getSiguiente() == null){//llego al final
                cursor.setSiguiente(nodo);
            }else{ //esta en la posicion anterior a donde se debe insertar
                nodo.setSiguiente(cursor.getSiguiente());
                cursor.setSiguiente(nodo);
            }
        }
        
        this.longitud++; //incrementamos la longitud en 1
    }

    @Override
    public void eliminar(Integer pos) throws Exception {
        if(pos<0 || pos>= this.longitud){
            throw new Exception("Posicion fuera de indice");
        }
        if(pos==0){ // eliminar de la primera posicion
            this.cabeza = this.cabeza.getSiguiente();
        }else{      //si no es el primero
            //iterar hasta la posicion anterior al que se quiere eliminar deseada
            Integer currentPosition = 0;
            NodoSE<T> cursor = this.cabeza;
            while(cursor.getSiguiente()!=null && currentPosition<pos-1){
                cursor = cursor.getSiguiente();
                currentPosition++;
            }
            //
            cursor.setSiguiente(cursor.getSiguiente().getSiguiente());
        }
        this.longitud--;
    }

}
