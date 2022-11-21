package cu.uci.ed1.tdas.noLineales;

import cu.uci.ed1.tdas.lineales.Lista;

/**
 *
 * @author angel
 * @param <T>
 */
public interface ArbolGeneral<T> {
    T raiz();
    boolean esHoja();
    Integer grado();
    Integer altura();
    ArbolGeneral<T> subArbol(Integer posicion);
    void copaEn(ArbolGeneral<T> nuevoArbol);
    void adicionarSubArbol(ArbolGeneral<T> subArbol);
    ArbolGeneral<T> podarSubArbol(Integer posicion);
    Lista<T> preOrden();
    Lista<T> postOrden();
    Lista<T> entreOrden();
    Lista<T> aLoAncho();
}
