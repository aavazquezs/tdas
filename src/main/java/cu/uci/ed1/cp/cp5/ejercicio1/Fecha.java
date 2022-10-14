package cu.uci.ed1.cp.cp5.ejercicio1;

/**
 *
 * @author angel
 */
public class Fecha {
    private Integer dia;
    private Integer mes;
    private Integer anno;

    public Fecha() {
        dia = 0;
        mes = 0;
        anno = 0;
    }

    public Fecha(Integer dia, Integer mes, Integer anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    @Override
    public boolean equals(Object obj) {
        
        Fecha fecha2 = (Fecha)obj;
        
        return this.dia.equals(fecha2.dia) && this.mes.equals(fecha2.mes) && this.anno.equals(fecha2.anno);
        
    }
    
    
    
}
