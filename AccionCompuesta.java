import java.util.ArrayList;

public class AccionCompuesta extends Accion{
    private ArrayList<Accion> acciones;
    
    /**
     * Constructor de la clase AccionCompuesta
     */
    public AccionCompuesta(String nombre){
        super(nombre);
        acciones= new ArrayList<Accion>();
    }
    
    /**
     * Método encargado de agregar una nueva acción a la acción actual
     * @param La acción a agregar
     */
    public void adAccion(Accion a) throws AccionExcepcion{
        for(Accion acc : this.acciones){
            if (acc.getNombre().equals(a.getNombre())){
                throw new AccionExcepcion(AccionExcepcion.NOMBRE_YA_EXISTE);
            }
        }
        
        acciones.add(a);
    }
    
    /**
     * Este método se encarga de calcular el total de días que tomará finalizar una tarea
     * @return El total de días de la tarea.
     * @throws AccionExcepcion si la acción está vacía
     */
    @Override
    public int dias() throws AccionExcepcion{
        int suma = 0;
        
        if(this.acciones.size() == 0){
            throw new AccionExcepcion(AccionExcepcion.COMPUESTA_VACIA);
        }
        
        for(Accion a: this.acciones){
            suma += a.dias();    
        }
        
        return suma;
    }
    
    /**
     * Método encargado de calcular los dias estimados de una acción
     * @return El total de días estimados para una acción
     */
    @Override
    public int diasEstimados(){ 
        int suma = 0;
        
        for (Accion a : this.acciones){
            suma += a.diasEstimados();
        }
        
        return suma;
    }
    
    /**
     * Método encargado de calcular los días de estimados de una acción con nombre dado
     * @return El total de días estimaos para una acción con un nombre dado
     */
    @Override
    public int dias(String nombre) throws AccionExcepcion {
        int dias = 0;
        boolean nameExists = false;
        
        for(Accion a : this.acciones){
            System.out.println(a.getNombre());
            
            if (a instanceof AccionCompuesta){
                a.dias(nombre);
            } else {            
                if (nombre.equals(a.getNombre())){
                    dias += a.dias(nombre);
                    nameExists = true;
                }  
            }
        }
        
        if (!nameExists){
            throw new AccionExcepcion(AccionExcepcion.NO_EXISTE_NOMBRE);
        }
        
        return dias;
    }    
}
