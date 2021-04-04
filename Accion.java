
public abstract class Accion{
    private static int acciones=1;
    
    private int id;
    protected String nombre;
    
    /**
     * Constructor de la clase abstracta Accion
     */
    public Accion(String nombre){
        this.id=acciones;
        this.nombre=nombre;
        acciones++;
    }
    
    /**
     * Método encargado de calcular el total de días de una acción
     * @return El total de días que tomará realizar una acción
     * @throws AccionExcepcion si se encuentra alguna inconsistencia en los datos de la acción
     */
    public abstract int dias() throws AccionExcepcion;
    
    /**Calcular el numero de dias estimados de una accion
     * Si hay problemas para calcular el numero de dias de una accion, se asume el maximo numero de dias de
     * sus subacciones, si es posible, o una semana (5 dias), en caso contrario.
     * @return El total de días estimados para una acción
     * */
    public abstract int diasEstimados();
    

    public abstract int dias(String nombre) throws AccionExcepcion;
    
    public String getNombre(){
        return this.nombre;
    }
        

    
}
