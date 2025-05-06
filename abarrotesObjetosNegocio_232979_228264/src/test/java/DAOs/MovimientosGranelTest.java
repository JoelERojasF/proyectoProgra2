/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

//imports necesarios para crear los objetos que necesitaremos para la prueba
import com.objetosnegocio.MovimientoGranel;
import com.objetosservicio.Periodo;
import com.objetosnegocio.ProductoGranel;
import com.objetosservicio.Fecha;
import DAOs.MovimientosGranel;
import Excepciones.ElementoDuplicadoException;
import java.util.ArrayList;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joel Rojas y Rubén Valdezas
 */
public class MovimientosGranelTest {
    

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        MovimientosGranel.clear();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of comprarGranel method, of class MovimientosGranel.
     */
    @Test
    public void testComprarGranel() {
        Fecha fecha = new Fecha(03, 05, 2025);
        ProductoGranel producto = new ProductoGranel();
        MovimientoGranel mov =  new MovimientoGranel(fecha, false, producto);
        
        MovimientosGranel.comprarGranel(mov);
        MovimientoGranel movPrueba = MovimientosGranel.registroComprasGranel.getFirst();
        
        assertEquals(mov, movPrueba);
    }
    
    
    
    /**
     * Test of ElementoDuplicadoException en compraGranel 
     */
    @Test
    public void testCompraGranelElementoDuplicado(){
        Fecha fecha = new Fecha(03, 05, 2025);
        ProductoGranel producto = new ProductoGranel();
        
        MovimientoGranel mov =  new MovimientoGranel(fecha, false, producto);
        MovimientoGranel mov2 =  new MovimientoGranel(fecha, false, producto);
        
        MovimientosGranel.comprarGranel(mov);
        Exception exception = assertThrows(ElementoDuplicadoException.class , () ->{
            MovimientosGranel.comprarGranel(mov2);
        });
        assertEquals("Error: el producto ya fue movido hoy.", exception.getMessage());
    }
    
    

    /**
     * Test of venderGranel method, of class MovimientosGranel.
     */
    @Test
    public void testVenderGranel() {
        Fecha fecha = new Fecha(03, 05, 2025);
        ProductoGranel producto = new ProductoGranel();
        MovimientoGranel mov =  new MovimientoGranel(fecha, false, producto);
        
        MovimientosGranel.venderGranel(mov);
        MovimientoGranel movPrueba = MovimientosGranel.registroVentasGranel.getFirst();
        
        assertEquals(mov, movPrueba);
    }

    //Test de excepcion en venderGranel
    /**
     * Test of ElementoDuplicadoException en compraGranel 
     */
    @Test
    public void testVenderGranelElementoDuplicado(){
        Fecha fecha = new Fecha(03, 05, 2025);
        ProductoGranel producto = new ProductoGranel();
        
        MovimientoGranel mov =  new MovimientoGranel(fecha, false, producto);
        MovimientoGranel mov2 =  new MovimientoGranel(fecha, false, producto);
        
        MovimientosGranel.venderGranel(mov);
        Exception exception = assertThrows(ElementoDuplicadoException.class , () ->{
            MovimientosGranel.venderGranel(mov2);
        });
        assertEquals("Error: el producto ya fue movido hoy.", exception.getMessage());
    }
    
    
    /**
     * Test of consultarCompras method, of class MovimientosGranel.
     */
    @Test
    public void testConsultarCompras_0args() {

        ArrayList<MovimientoGranel> prueba = new ArrayList();
        
        Fecha fechaPrueba1 = new Fecha(04, 05, 2025);
        
        
        ProductoGranel prod1 =  new ProductoGranel();
        ProductoGranel prod2 =  new ProductoGranel();
        ProductoGranel prod3 =  new ProductoGranel();
        
        MovimientoGranel mov1 = new MovimientoGranel(fechaPrueba1, false, prod1);
        MovimientoGranel mov2 = new MovimientoGranel(fechaPrueba1, false, prod2);
        MovimientoGranel mov3 = new MovimientoGranel(fechaPrueba1, false, prod3);
        
        prueba.add(mov1);
        prueba.add(mov2);
        prueba.add(mov3);
        
        MovimientosGranel.comprarGranel(mov1);
        MovimientosGranel.comprarGranel(mov2);
        MovimientosGranel.comprarGranel(mov3);
        
        assertEquals(prueba, MovimientosGranel.consultarCompras());
    }

    /**
     * Test of consultarCompras method, of class MovimientosGranel.
     */
    @Test
    public void testConsultarCompras_Periodo() {
        
        Fecha fecha = new Fecha(01, 01, 2001);
        Fecha fecha2 =  new Fecha(03, 03, 2026);
        
        ArrayList<MovimientoGranel> prueba = new ArrayList();
        
        Fecha fechaPrueba1 = new Fecha(04, 05, 2025);
        
        
        ProductoGranel prod1 =  new ProductoGranel();
        ProductoGranel prod2 =  new ProductoGranel();
        ProductoGranel prod3 =  new ProductoGranel();
        
        MovimientoGranel mov1 = new MovimientoGranel(fechaPrueba1, false, prod1);
        MovimientoGranel mov2 = new MovimientoGranel(fechaPrueba1, false, prod2);
        MovimientoGranel mov3 = new MovimientoGranel(fechaPrueba1, false, prod3);
        
        prueba.add(mov1);
        prueba.add(mov2);
        prueba.add(mov3);
        
        MovimientosGranel.comprarGranel(mov1);
        MovimientosGranel.comprarGranel(mov2);
        MovimientosGranel.comprarGranel(mov3);
        
        Periodo periodo = new Periodo(fecha, fecha2);
        
        assertEquals(prueba, MovimientosGranel.consultarCompras(periodo));
    }

    /**
     * Test of consultarVentas method, of class MovimientosGranel.
     */
    @Test
    public void testConsultarVentas_0args() {
        ArrayList<MovimientoGranel> prueba = new ArrayList();
        
        Fecha fechaPrueba1 = new Fecha(04, 05, 2025);
        
        
        ProductoGranel prod1 =  new ProductoGranel();
        ProductoGranel prod2 =  new ProductoGranel();
        ProductoGranel prod3 =  new ProductoGranel();
        
        MovimientoGranel mov1 = new MovimientoGranel(fechaPrueba1, false, prod1);
        MovimientoGranel mov2 = new MovimientoGranel(fechaPrueba1, false, prod2);
        MovimientoGranel mov3 = new MovimientoGranel(fechaPrueba1, false, prod3);
        
        prueba.add(mov1);
        prueba.add(mov2);
        prueba.add(mov3);
        
        MovimientosGranel.venderGranel(mov1);
        MovimientosGranel.venderGranel(mov2);
        MovimientosGranel.venderGranel(mov3);
        
        assertEquals(prueba, MovimientosGranel.consultarVentas());
    }

    /**
     * Test of consultarVentas method, of class MovimientosGranel.
     */
    @Test
    public void testConsultarVentas_Periodo() {
        Fecha fecha = new Fecha(01, 01, 2001);
        Fecha fecha2 =  new Fecha(03, 03, 2026);
        
        ArrayList<MovimientoGranel> prueba = new ArrayList();
        
        Fecha fechaPrueba1 = new Fecha(04, 05, 2025);
        
        
        ProductoGranel prod1 =  new ProductoGranel();
        ProductoGranel prod2 =  new ProductoGranel();
        ProductoGranel prod3 =  new ProductoGranel();
        
        MovimientoGranel mov1 = new MovimientoGranel(fechaPrueba1, false, prod1);
        MovimientoGranel mov2 = new MovimientoGranel(fechaPrueba1, false, prod2);
        MovimientoGranel mov3 = new MovimientoGranel(fechaPrueba1, false, prod3);
        
        prueba.add(mov1);
        prueba.add(mov2);
        prueba.add(mov3);
        
        MovimientosGranel.venderGranel(mov1);
        MovimientosGranel.venderGranel(mov2);
        MovimientosGranel.venderGranel(mov3);
        
        Periodo periodo = new Periodo(fecha, fecha2);
        
        assertEquals(prueba, MovimientosGranel.consultarVentas(periodo));
    }
    
}
