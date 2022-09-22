package cu.uci.ed1.tdas.lineales;

/**
 *
 * @author angel
 */
public interface Lista<T> {
    /**
     * Devuelve la longitud de la lista
     * @return 
     */
    Integer longitud();
    
    /**
     * Obtiene el elemento que se encuentra en la posicion pos. Lanza una 
     * excepcion si el parametro se encuentra fuera de rango.
     * @param pos
     * @return
     * @throws Exception 
     */
    T obtener(Integer pos) throws Exception;
    
    /**
     * Adiciona el elemento X al final de la lista.
     * @param x 
     */
    void adicionar(T x) throws Exception;
    
    /**
     * Inserta un elemento en la posicion pos. Lanza una excepcion si el 
     * parametro pos esta fuera de rango.
     * @param x
     * @param pos 
     */
    void insertar(T x, Integer pos) throws Exception;
    
    /**
     * Elimina de la lista el elemento en la posicion pos. Lanza una excepcion 
     * si el parametro se encuentra fuera de rango.
     * @param pos
     * @throws Exception 
     */
    void eliminar(Integer pos) throws Exception;
}
