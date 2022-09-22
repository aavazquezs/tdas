package cu.uci.ed1.tdas.lineales.impl;

import cu.uci.ed1.tdas.lineales.Lista;
import java.util.Arrays;

/**
 *
 * @author angel
 */
public class ListaArreglo<T> implements Lista<T>{
    
    private Integer longitud;
    private T[] elementos;

    @Override
    public Integer longitud() {
        return this.longitud;
    }

    @Override
    public T obtener(Integer pos) throws Exception {
        if(pos<0 || pos>=this.longitud){
            throw new Exception("Parametro fuera de rango");
        }
        return this.elementos[pos];
    }

    @Override
    public void adicionar(T x) throws Exception {
       if(this.longitud >= this.elementos.length){ //doblar la capacidad
            T[] nuevo = Arrays.copyOf(elementos, this.longitud);
            this.elementos = (T[])new Object[nuevo.length*2];
            this.elementos = Arrays.copyOf(nuevo, this.longitud);
        }
        
        this.elementos[longitud] = x;
        this.longitud++;
    }

    @Override
    public void insertar(T x, Integer pos) throws Exception {
        if(this.longitud >= this.elementos.length){
            T[] nuevo = Arrays.copyOf(elementos, this.longitud);
            this.elementos = (T[])new Object[nuevo.length*2];
            this.elementos = Arrays.copyOf(nuevo, this.longitud);
        }
        if(pos<0 || pos>=this.longitud){
            throw new Exception("Parametro fuera de rango");
        }
        for(int i=this.longitud-1; i>pos; i--){
            this.elementos[i] = this.elementos[i-1];
        }
        this.elementos[pos] = x;
        this.longitud++;
    }

    @Override
    public void eliminar(Integer pos) throws Exception {
        if(pos <0 || pos>=this.longitud){
            throw new Exception("Parametro fuera de rango");
        }
        for(int i = pos; i < this.longitud-1; i++){
            this.elementos[i] = this.elementos[i+1];
        }
        this.elementos[this.longitud-1] = null;
        this.longitud--;
    }
    
    

}
