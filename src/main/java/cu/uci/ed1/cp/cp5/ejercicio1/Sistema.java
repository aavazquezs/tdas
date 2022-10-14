package cu.uci.ed1.cp.cp5.ejercicio1;

import cu.uci.ed1.tdas.lineales.impl.ListaSE;

/**
 *
 * @author angel
 */
public class Sistema {
    private ListaSE<Persona> solicitudes;
    private ListaSE<Persona> solapines;
    private ListaSE<Persona> personalAtendido;

    public Sistema(ListaSE<Persona> solicitudes, ListaSE<Persona> solapines, ListaSE<Persona> personalAtendido) {
        this.solicitudes = solicitudes;
        this.solapines = solapines;
        this.personalAtendido = personalAtendido;
    }

    public Sistema() {
        this.solicitudes = new ListaSE<>();
        this.solapines = new ListaSE<>();
        this.personalAtendido = new ListaSE<>();
    }
    
    public void entregarSolapin(Persona p) throws Exception{
        
        //se verifica que a dicha persona no se le haya entregado una credencial con anterioridad
        boolean entregadoYa = false;
        
        for (int i = 0; i < personalAtendido.longitud() && !entregadoYa; i++) {
            
            Persona actual = personalAtendido.obtener(i);
            
            if(actual.equals(p)){
                
                entregadoYa = true;
                
            }
            
        }
        
        if(entregadoYa){
            //Si la persona ya tiene credencial se elimina del listado del 
            //personal que solicita la credencial
            this.buscarYEliminarEnSolicitudes(p);
            
        }else{
            //si no posee credencial se busca en el grupo de credenciales, y si 
            //esta existe se agrega a la persona a la lista de atendidos, y se 
            //le entrega la credencial
            Persona solapin = this.buscarEnCredencialesYEliminarSiEsta(p);
            
            if(solapin == null){
                //En caso de no existir la credencial dicha persona pasa al 
                //final de la lista del personal que solicita la credencial.
                solicitudes.adicionar(p);
                
            }
        
        }
        
    }
    
    private void buscarYEliminarEnSolicitudes(Persona p) throws Exception{
        
        int posEliminar = -1;
        
        boolean encontrado = false;
        
        for (int i = 0; i < solicitudes.longitud() && !encontrado; i++) {
            
            Persona solicitud = solicitudes.obtener(i);
            
            if(solicitud.equals(p)){
                
                encontrado = true;
                
                posEliminar = i;
                
            }
            
        }
        
        if(encontrado){
            
            solicitudes.eliminar(posEliminar);
            
        }
    }
    
    private Persona buscarEnCredencialesYEliminarSiEsta(Persona p) throws Exception{
        
        int posCredencial = -1;
        
        for (int i = 0; i < this.solapines.longitud() && posCredencial != -1; i++) {
            
            Persona actual = solapines.obtener(i);
            
            if(actual.equals(p)){
                
                posCredencial = i;
                
            }
            
        }
        
        Persona persona = null;
        
        if(posCredencial != -1){
            
            persona = solapines.obtener(posCredencial);
            
            solapines.eliminar(posCredencial);
            
            this.personalAtendido.adicionar(p);
            
        }
        
        return persona;
        
    }
    
    public ListaSE<Persona> personasCumplenAnno(Fecha fecha) throws Exception{
        
        ListaSE<Persona> personas = null;
        
        for (int i = 0; i < solicitudes.longitud(); i++) {
            
            Persona solicitudActual = solicitudes.obtener(i);
            
            if(solicitudActual.equals(fecha)){
                personas.adicionar(solicitudActual);
            }
        }
        
        return personas;
    }
    
    
}
