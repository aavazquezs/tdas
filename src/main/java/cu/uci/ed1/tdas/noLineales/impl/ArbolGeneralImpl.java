package cu.uci.ed1.tdas.noLineales.impl;

import cu.uci.ed1.tdas.lineales.Cola;
import cu.uci.ed1.tdas.lineales.Lista;
import cu.uci.ed1.tdas.lineales.impl.ColaSE;
import cu.uci.ed1.tdas.lineales.impl.ListaSE;
import cu.uci.ed1.tdas.noLineales.ArbolGeneral;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class ArbolGeneralImpl<T> implements ArbolGeneral<T> {

    protected T raiz;
    protected Lista<ArbolGeneralImpl<T>> hijos;

    public ArbolGeneralImpl(T raiz) {
        this.raiz = raiz;
        hijos = new ListaSE<>();
    }   
    
    @Override
    public T raiz() {
        return this.raiz;
    }

    @Override
    public boolean esHoja() {
        return this.hijos.longitud()==0;
    }

    @Override
    public Integer grado() {
        return this.hijos.longitud();
    }

    @Override
    public Integer altura() {
        Integer altura = 0;
        for (ArbolGeneral<T> hijo : hijos) {
            Integer alturaHijo = hijo.altura();
            if(alturaHijo > altura){
                altura = alturaHijo;
            }
        }
        return altura + 1;
    }

    @Override
    public ArbolGeneral<T> subArbol(Integer posicion) {
        try {
            return this.hijos.obtener(posicion);
        } catch (Exception ex) {
            System.out.println("Posicion no valida");
            return null;
        }
    }

    @Override
    public void copaEn(ArbolGeneral<T> nuevoArbol) {
        ((ArbolGeneralImpl)nuevoArbol).raiz = this.raiz;
        ((ArbolGeneralImpl)nuevoArbol).hijos = this.hijos;
    }

    @Override
    public void adicionarSubArbol(ArbolGeneral<T> subArbol) {
        try {
            this.hijos.adicionar((ArbolGeneralImpl)subArbol);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArbolGeneral<T> podarSubArbol(Integer posicion) {
        ArbolGeneral<T> subArbol = null;
        try {
            subArbol = this.hijos.obtener(posicion);
            this.hijos.eliminar(posicion);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return subArbol;
    }

    @Override
    public Lista<T> preOrden() {
        Lista<T> preOrden = new ListaSE<>();
        this.visitarPreOrden(preOrden);
        return preOrden;
    }
    
    private void visitarPreOrden(Lista<T> lista) {
        //visita el nodo raiz
        try {
            lista.adicionar(this.raiz);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        //visita a los hijos en pre-orden
        for (ArbolGeneralImpl<T> hijo : this.hijos) {
            hijo.visitarPreOrden(lista);
        }
    }

    @Override
    public Lista<T> postOrden() {
        Lista<T> postOrden = new ListaSE<>();
        this.visitarPostOrden(postOrden);
        return postOrden;
    }
    
    private void visitarPostOrden(Lista<T> lista){
        //visita a los hijos es postorden
        for (ArbolGeneralImpl<T> hijo : this.hijos) {
            hijo.visitarPostOrden(lista);
        }
        //visita la raiz
        try {
            lista.adicionar(this.raiz);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Lista<T> entreOrden() {
        Lista<T> entreOrden = new ListaSE<>();
        try {
            this.visitarEntreOrden(entreOrden);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return entreOrden;
    }

    private void visitarEntreOrden(Lista<T> lista) throws Exception{
        //visita al primer hijo en entre-orden
        if(this.hijos.longitud()!=0){
            hijos.obtener(0).visitarEntreOrden(lista);
        }
        //visita a la raiz
        lista.adicionar(raiz);
        
        //visita al resto de hijos en entre-orden
        for (int i = 1; i < this.hijos.longitud(); i++) {
            hijos.obtener(i).visitarEntreOrden(lista);
        }
    }
    
    
    @Override
    public Lista<T> aLoAncho() {
        Cola<ArbolGeneralImpl> cola = new ColaSE<>();
        Lista<T> result = new ListaSE<>();
        
        cola.adicionar(this);
        
        while(!cola.esVacio()){
            ArbolGeneralImpl<T> arbolActual = cola.extraer();
            try {
                result.adicionar(arbolActual.raiz());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            for(int i=0; i<arbolActual.grado(); i++){
                cola.adicionar((ArbolGeneralImpl)arbolActual.subArbol(i));
            }
        }
        return result;
    }

}
