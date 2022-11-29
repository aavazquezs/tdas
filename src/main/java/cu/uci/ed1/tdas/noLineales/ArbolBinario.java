package cu.uci.ed1.tdas.noLineales;

import cu.uci.ed1.tdas.lineales.Lista;

/**
 *
 * @author angel
 */
public interface ArbolBinario<T> {
    public ArbolBinario<T> crearVacio();
    public T raiz();
    public boolean esVacio();
    public Integer peso();
    public boolean esHoja();
    public void copiaEn(ArbolBinario<T> nuevoArbol);
    public ArbolBinario<T> devolverIzquierdo();
    public ArbolBinario<T> devolverDerecho();
    public Lista<T> preOrden();
    public Lista<T> entreOrden();
    public Lista<T> postOrden();
    public Lista<T> aLoAncho();
}
