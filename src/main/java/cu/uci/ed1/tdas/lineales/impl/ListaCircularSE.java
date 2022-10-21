package cu.uci.ed1.tdas.lineales.impl;

import java.util.Iterator;

/**
 *
 * @author angel
 */
public class ListaCircularSE<T> extends ListaSE<T> {

    @Override
    public T obtener(Integer pos) throws Exception {

        if (pos < 0 || pos >= this.longitud) {
            throw new Exception("ERROR: ListaCircularSE.obtener(int pos) -> bad index");
        }

        NodoSE<T> cursor = this.cabeza;
        Integer posicionActual = 0;
        while (posicionActual < pos) {
            cursor = cursor.getSiguiente();
            posicionActual++;
        }
        return cursor.getDato();

    }

    @Override
    public void adicionar(T x) throws Exception {
        NodoSE<T> nodo = new NodoSE<>(x);
        NodoSE<T> cursor = this.cabeza;

        if (cursor == null) {
            this.cabeza = nodo;
            nodo.setSiguiente(nodo);
        } else {
            while (!cursor.getSiguiente().equals(this.cabeza)) {
                cursor = cursor.getSiguiente();
            }
            nodo.setSiguiente(this.cabeza);
            cursor.setSiguiente(nodo);
        }
        this.longitud++;
    }

    @Override
    public void insertar(T x, Integer pos) throws Exception {
        if (pos < 0 || pos >= this.longitud) {
            throw new Exception("ERROR: ListaCircularSE.insertar(x,pos) -> bad index");
        }
        NodoSE<T> nodo = new NodoSE<>(x);
        if (pos == 0) {
            NodoSE<T> cursor = this.cabeza;
            while (!cursor.getSiguiente().equals(this.cabeza)) { //encontrar al ultimo
                cursor = cursor.getSiguiente();
            }
            nodo.setSiguiente(this.cabeza);
            cursor.setSiguiente(nodo);
            this.cabeza = nodo;
        } else {
            Integer posicionActual = 0;
            NodoSE<T> cursor = this.cabeza;
            while (posicionActual < pos - 1) {
                cursor = cursor.getSiguiente();
                posicionActual++;
            }
            nodo.setSiguiente(cursor.getSiguiente());
            cursor.setSiguiente(nodo);
        }
        this.longitud++;
    }

    @Override
    public void eliminar(Integer pos) throws Exception {
        if (pos < 0 || pos >= this.longitud) {
            throw new Exception("ERROR: ListaCircularSE.eliminar(pos) -> bad index");
        }
        if(pos==0){
            NodoSE<T> cursor = this.cabeza;
            while (!cursor.getSiguiente().equals(this.cabeza)) { //encontrar al ultimo
                cursor = cursor.getSiguiente();
            }
            NodoSE<T> sgte = this.cabeza.getSiguiente();//sgte elemento en la lista (2do)
            cursor.setSiguiente(sgte); //el sgte del ultimo es el 2do
            this.cabeza=sgte; //ahora el 1ro sera el 2do
        }else{
            //movernos hasta la posicion anterior a donde queremos eliminar 
            NodoSE<T> cursor = this.cabeza;
            Integer posicionActual = 0;
            while(posicionActual < pos -1 ){
                cursor = cursor.getSiguiente();
                posicionActual++;
            }
            //el sgte de ese nodo es el siguiente de quien queremos eliminar
            cursor.setSiguiente(cursor.getSiguiente().getSiguiente());
        }
        this.longitud--;
    }

    @Override
    public Integer longitud() {
        return this.longitud;
    }

    @Override
    public String toString() {
        String cadena = "[";
        NodoSE<T> cursor = this.cabeza;
        if(cursor!=null){
            cadena += cursor.getDato().toString();
            cursor = cursor.getSiguiente();
        }
        while(cursor!=this.cabeza){
            cadena += ","+cursor.getDato().toString();
            cursor = cursor.getSiguiente();
        }
        cadena += "]";
        return cadena;
    }
    
    

    @Override
    public Iterator<T> iterator() {
        //return new IteradorListaCircularSE<>(this); 
        return new IteradorImpar<>(this);
    }
    
    public class IteradorListaCircularSE<T> implements Iterator<T>{

        private NodoSE<T> cursor;
        private Integer posicion;
        private boolean eliminar;

        public IteradorListaCircularSE(ListaCircularSE<T> lista) {
            cursor = lista.cabeza;
            posicion = 0;
            eliminar = false;
        }
        
        @Override
        public boolean hasNext() {
            return (cursor == cabeza && posicion == 0) || cursor != cabeza;
        }

        @Override
        public T next() {
            if(hasNext()){
                posicion++;
                T dato = cursor.getDato();
                cursor = cursor.getSiguiente();
                eliminar = true;
                return dato;
            }
            return null;
        }

        @Override
        public void remove() {
            if(eliminar){
                try {
                    eliminar(--posicion);
                } catch (Exception ex) {
                    System.out.println("ERROR: IteradorListaCircularSE.remove() bad index");
                }
                eliminar = false;
            }
        }
    }
    
    public class IteradorImpar<T> implements Iterator<T>{

        private NodoSE<T> cursor;
        private Integer posicion;
        private boolean eliminar;

        public IteradorImpar(ListaCircularSE<T> lista) {
            cursor = lista.cabeza;
            posicion = 0;
            eliminar = false;
        }
        
        @Override
        public boolean hasNext() {
            return (cursor == cabeza && posicion == 0) || cursor != cabeza;
        }

        @Override
        public T next() {
            if(hasNext()){
                if(posicion % 2 == 0){
                    cursor = cursor.getSiguiente();
                    posicion++;
                }
                T dato = cursor.getDato();
                cursor = cursor.getSiguiente();
                posicion++;
                return dato;
            } else{
                return null;
            }
        }

        @Override
        public void remove() {
            if(eliminar){
                try {
                    eliminar(--posicion);
                } catch (Exception ex) {
                    System.out.println("ERROR: IteradorListaCircularSE.remove() bad index");
                }
                eliminar = false;
            }
        }
        
    }

}
