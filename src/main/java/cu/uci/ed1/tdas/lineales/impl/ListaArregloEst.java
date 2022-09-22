package cu.uci.ed1.tdas.lineales.impl;

import cu.uci.ed1.tdas.lineales.Lista;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author angel
 */
public class ListaArregloEst<T extends Object> implements Lista<T> {

    private Integer MAXELEMENTOS;
    private Integer longitud;
    private T[] elementos;

    public ListaArregloEst(Integer MAXELEMENTOS) {
        this.MAXELEMENTOS = MAXELEMENTOS;
        this.longitud = 0;
        this.elementos = (T[]) new Object[MAXELEMENTOS];
    }

    
    
    public ListaArregloEst() {
        this.MAXELEMENTOS = 100;
        this.longitud = 0;
        this.elementos = (T[]) new Object[MAXELEMENTOS];
        
    }

    @Override
    public Integer longitud() {
        return this.longitud;
    }

    @Override
    public T obtener(Integer pos) throws Exception{
        if(pos<0 || pos>=this.longitud){
            throw new Exception("Parametro fuera de rango");
        }
        return this.elementos[pos];
    }

    @Override
    public void adicionar(T x) throws Exception{
        
        if(this.longitud >= this.MAXELEMENTOS){
            throw new Exception("No existe capacidad en la lista");
        }
        
        this.elementos[longitud] = x;
        this.longitud++;
    }

    @Override
    public void insertar(T x, Integer pos) throws Exception{
        if(this.longitud >= this.MAXELEMENTOS){
            throw new Exception("No existe capacidad en la lista");
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
    public void eliminar(Integer pos) throws Exception{
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
