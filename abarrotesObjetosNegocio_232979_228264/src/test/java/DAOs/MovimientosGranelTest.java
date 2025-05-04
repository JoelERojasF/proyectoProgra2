/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import com.objetosnegocio.MovimientoGranel;
import com.objetosservicio.Periodo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author le0jx
 */
public class MovimientosGranelTest {
    
    public MovimientosGranelTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of comprarGranel method, of class MovimientosGranel.
     */
    @Test
    public void testComprarGranel() {
        System.out.println("comprarGranel");
        MovimientoGranel movimiento = null;
        MovimientosGranel instance = new MovimientosGranel();
        instance.comprarGranel(movimiento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of venderGranel method, of class MovimientosGranel.
     */
    @Test
    public void testVenderGranel() {
        System.out.println("venderGranel");
        MovimientoGranel movimiento = null;
        MovimientosGranel instance = new MovimientosGranel();
        instance.venderGranel(movimiento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarCompras method, of class MovimientosGranel.
     */
    @Test
    public void testConsultarCompras_0args() {
        System.out.println("consultarCompras");
        MovimientosGranel instance = new MovimientosGranel();
        instance.consultarCompras();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarCompras method, of class MovimientosGranel.
     */
    @Test
    public void testConsultarCompras_Periodo() {
        System.out.println("consultarCompras");
        Periodo periodo = null;
        MovimientosGranel instance = new MovimientosGranel();
        instance.consultarCompras(periodo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarVentas method, of class MovimientosGranel.
     */
    @Test
    public void testConsultarVentas_0args() {
        System.out.println("consultarVentas");
        MovimientosGranel instance = new MovimientosGranel();
        instance.consultarVentas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarVentas method, of class MovimientosGranel.
     */
    @Test
    public void testConsultarVentas_Periodo() {
        System.out.println("consultarVentas");
        Periodo periodo = null;
        MovimientosGranel instance = new MovimientosGranel();
        instance.consultarVentas(periodo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
