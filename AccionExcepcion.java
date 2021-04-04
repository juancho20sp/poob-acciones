
public class AccionExcepcion extends Exception{
    public static final String COMPUESTA_VACIA="Accion compuesta vacia";
    public static final String SIMPLE_SIN_DIAS="Actividad simple sin dias";
    public static final String NO_EXISTE_NOMBRE="No existe una acción con ese nombre";
    public static final String NOMBRE_YA_EXISTE="Ya existe una acción con ese nombre";
    
    /**
     * Constructor de la clase AccionExcepcion
     */
    public AccionExcepcion(String mensaje){
        super(mensaje);
    }
}
