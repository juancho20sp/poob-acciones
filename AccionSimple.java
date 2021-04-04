

public class AccionSimple extends Accion{
    private Integer dias;
    
    /**
     * Constructor de la clase AccionSimple
     */
    public AccionSimple(String nombre, Integer dias){
        super(nombre);
        this.dias=dias;
    }
    
    /**
     * Retorna el total de días estimados para esta tarea
     * @return Total de días estimados para la tarea
     * @throws AccionExcepcion si la acción no tiene días asociados
     */    
    @Override
    public int dias() throws AccionExcepcion{
        if(this.dias == null){
            throw new AccionExcepcion(AccionExcepcion.SIMPLE_SIN_DIAS);
        }
        
        return this.dias;
    }

    /**
     * Retorna el total de días estimados de una tarea
     * @return Si el total de días no es nulo, lo retorna. En caso de ser nulo retorna 5.
     */
    @Override
    public int diasEstimados(){        
        if (this.dias != null){
            return this.dias;
        }        
        return 5;
    }
    
    @Override
    public int dias(String nombre) throws AccionExcepcion {
        if (super.getNombre().equals(nombre)){
            return this.dias;
        }
        
        throw new AccionExcepcion(AccionExcepcion.NO_EXISTE_NOMBRE);
    }
        
    
    
}
