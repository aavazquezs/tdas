package cu.uci.ed1.cp.cp5.ejercicio1;

/**
 *
 * @author angel
 */
public class Persona {
    private String nombre;
    private String carnetIdentidad;
    private Fecha fecha;

    public Persona(String nombre, String carnetIdentidad, Fecha fecha) {
        this.nombre = nombre;
        this.carnetIdentidad = carnetIdentidad;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarnetIdentidad() {
        return carnetIdentidad;
    }

    public Fecha getFecha() {
        return fecha;
    }

    @Override
    public boolean equals(Object obj) {
        Persona pers = (Persona)obj;
        return this.carnetIdentidad.equalsIgnoreCase(pers.getCarnetIdentidad());
    }
    
    
    
}
