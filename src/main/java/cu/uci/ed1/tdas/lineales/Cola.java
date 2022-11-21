package cu.uci.ed1.tdas.lineales;

/**
 *
 * @author angel
 * @param <T>
 */
public interface Cola<T> {
    T frente();
    T fondo();
    T extraer();
    void adicionar(T elemento);
    boolean esVacio();
}
