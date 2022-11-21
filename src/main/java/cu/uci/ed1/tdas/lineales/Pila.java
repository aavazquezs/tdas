package cu.uci.ed1.tdas.lineales;

/**
 *
 * @author angel
 * @param <T>
 */
public interface Pila<T> {
    T cima();
    T extraer();
    void adicionar(T elemento);
    boolean esVacia();
}
