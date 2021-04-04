import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class AccionTest{   
    private AccionCompuesta plan;
    private AccionCompuesta ai;
    private AccionCompuesta ae;
    private AccionCompuesta ac;
    private AccionSimple at;
    
    /**
     * Constructor de la clase AccionTest
     */    
    public AccionTest(){
    }

    /**
     * Instrucciones que se ejecutarán antes de cada prueba unitaria
     */
    @Before
    public void setUp(){
        plan=new AccionCompuesta("Proyecto");
        ai=new AccionCompuesta("Inicio");
        ae=new AccionCompuesta("Elaboracion");
        ac=new AccionCompuesta("Construccion");
        at=new AccionSimple("Transicion",10);
        try{
            ai.adAccion(new AccionSimple("Modelado de Negocio",5));
            ai.adAccion(new AccionSimple("Requerimientos",8));
            ae.adAccion(new AccionSimple("Diseño",10));
            ae.adAccion(new AccionSimple("Implementacion",10));        
            ac.adAccion(new AccionSimple("Implementacion",15));
            ac.adAccion(new AccionSimple("Pruebas",15));
            
            plan.adAccion(ai);
            plan.adAccion(ae);
            plan.adAccion(ac);
            plan.adAccion(at);
        } catch(AccionExcepcion e) {}
        
    }

    /**
     * Instrucciones que se ejecutan después de cada prueba unitaria
     */
    @After
    public void tearDown(){
    }
    
    /**
     * Deberia calcular el total de días que tomará completar una acción
     * @result Se contarán los días necesarios para completar una acción
     */
    @Test
    public void deberiaCalcularElNumeroDeDiasDeUnaAccion(){
        try {
           assertEquals(73,plan.dias());
        } catch (AccionExcepcion e){
            fail("Lanzó excepcion : "+ e.getMessage());
        }    
    }    
    
    /**
     * Deberia lanzar una excepción si una acción compuesta no tiene acciones simples.
     * @result Se lanzará una excepción en caso de tener una acción compuesta sin acciones simples
     */    
    @Test
    public void deberiaLanzarExcepcionSiUnaAccionCompuestaNoTieneAccionesSimples(){
        try
        {
            ae.adAccion(new AccionCompuesta("Ajustes"));
        }
        catch (AccionExcepcion e){}
        
        try { 
           assertEquals(73,plan.dias());
           fail("No lanzó excepcion");
        } catch (AccionExcepcion e) {
            assertEquals(AccionExcepcion.COMPUESTA_VACIA, e.getMessage());
        }    
    }    
    
    /**
     * Deberia lanzar una excepción si una acción simple no tiene días asociados.
     * @result No se tendrán acciones simples sin días asociados.
     */
   @Test
    public void deberiaLanzarExcepcionSiNoSeConocenLosDiasDeUnaAccionSimple(){
        try
        {
            ae.adAccion(new AccionSimple("Cierre",null));
        }
        catch (AccionExcepcion ae1)
        {
            
        }
        
        try { 
           assertEquals(73,plan.dias());
           fail("No lanza la excepcion");
        } catch (AccionExcepcion e) {
            assertEquals(AccionExcepcion.SIMPLE_SIN_DIAS,e.getMessage());
        }    
    }
    
   /**
    * Deberia contar los días estimados
    * @result El total de días estimados de una tarea compuesta
    */
   @Test
   public void deberiaContarLosDiasEstimados(){
        AccionCompuesta plan2=new AccionCompuesta("Proyecto");
        ai=new AccionCompuesta("Inicio");
        ae=new AccionCompuesta("Elaboracion");
        ac=new AccionCompuesta("Construccion");
        at=new AccionSimple("Transicion", null);
        
        try {
            ai.adAccion(new AccionSimple("Modelado de Negocio",null));
            ai.adAccion(new AccionSimple("Requerimientos",null));
            ae.adAccion(new AccionSimple("Diseño",null));
            ae.adAccion(new AccionSimple("Implementacion",null));        
            ac.adAccion(new AccionSimple("Implementacion",null));
            ac.adAccion(new AccionSimple("Pruebas",null));
            plan2.adAccion(ai);
            plan2.adAccion(ae);
            plan2.adAccion(ac);
            plan2.adAccion(at);
        } catch(AccionExcepcion e) {}
        
        
        assertEquals(35,plan2.diasEstimados());
        
    }
    
   /**
    * Debería retornar los días que tomará realizar una tarea con un nombre específico
    * @result El total de días necesarios para completar una tarea en especifico 
   */
  @Test
  public void deberiaContarLosDiasDeUnaTareaDada(){
      AccionCompuesta plan3=new AccionCompuesta("Proyecto");
        ai=new AccionCompuesta("Inicio");
        ae=new AccionCompuesta("Elaboracion");
        ac=new AccionCompuesta("Construccion");
        at=new AccionSimple("Transicion", 5);
        
        try {
            ai.adAccion(new AccionSimple("Modelado de Negocio",8));
            ai.adAccion(new AccionSimple("Requerimientos",3));
            ae.adAccion(new AccionSimple("Diseño",6));
            ae.adAccion(new AccionSimple("Implementacion",15));        
            ac.adAccion(new AccionSimple("Implementacion",14));
            ac.adAccion(new AccionSimple("Pruebas",10));
            plan3.adAccion(ai);
            plan3.adAccion(ae);
            plan3.adAccion(ac);
            plan3.adAccion(at);  
        } catch (AccionExcepcion e) {}
        
        
        
        try { 
           assertEquals(5, plan3.dias("Transicion"));
           fail("No lanza la excepcion");
        } catch (AccionExcepcion e) {
            assertEquals(AccionExcepcion.SIMPLE_SIN_DIAS, e.getMessage());
        } 
        
        
    }
    
    
}
