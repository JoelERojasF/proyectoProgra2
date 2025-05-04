/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import com.objetosnegocio.ProductoGranel;
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
public class ProductosGranelTest {
    
    public ProductosGranelTest() {
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
     * Test of agregarAlInventatio method, of class ProductosGranel.
     */
    @Test
    public void testAgregarAlInventatio() {
        System.out.println("agregarAlInventatio");
        ProductoGranel producto = null;
        ProductosGranel instance = new ProductosGranel();
        instance.agregarAlInventatio(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarDelInventario method, of class ProductosGranel.
     */
    @Test
    public void testEliminarDelInventario() {
        System.out.println("eliminarDelInventario");
        ProductoGranel producto = null;
        ProductosGranel instance = new ProductosGranel();
        instance.eliminarDelInventario(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarInventario method, of class ProductosGranel.
     */
    @Test
    public void testActualizarInventario() {
        System.out.println("actualizarInventario");
        ProductoGranel producto = null;
        float cantidad = 0.0F;
        ProductosGranel instance = new ProductosGranel();
        instance.actualizarInventario(producto, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarInventario method, of class ProductosGranel.
     */
    @Test
    public void testConsultarInventario() {
        System.out.println("consultarInventario");
        ProductosGranel instance = new ProductosGranel();
        instance.consultarInventario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
