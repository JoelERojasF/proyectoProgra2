/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import com.objetosnegocio.Producto;
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
public class ProductosTest {
    
    public ProductosTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of agregarProducto method, of class Productos.
     */
    @org.junit.jupiter.api.Test
    public void testAgregarProducto() {
        System.out.println("agregarProducto");
        Producto producto = null;
        Productos instance = new Productos();
        instance.agregarProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProductoPorClave method, of class Productos.
     */
    @org.junit.jupiter.api.Test
    public void testBuscarProductoPorClave() {
        System.out.println("buscarProductoPorClave");
        String cve = "";
        Productos instance = new Productos();
        Producto expResult = null;
        Producto result = instance.buscarProductoPorClave(cve);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarProducto method, of class Productos.
     */
    @org.junit.jupiter.api.Test
    public void testEliminarProducto() {
        System.out.println("eliminarProducto");
        String cve = "";
        Productos instance = new Productos();
        instance.eliminarProducto(cve);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarProducto method, of class Productos.
     */
    @org.junit.jupiter.api.Test
    public void testActualizarProducto() {
        System.out.println("actualizarProducto");
        Producto producto = null;
        String nuevoNombre = "";
        String nuevaUnidad = "";
        char NuevoTipo = ' ';
        Productos instance = new Productos();
        instance.actualizarProducto(producto, nuevoNombre, nuevaUnidad, NuevoTipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of catalogoProductos method, of class Productos.
     */
    @org.junit.jupiter.api.Test
    public void testCatalogoProductos_0args() {
        System.out.println("catalogoProductos");
        Productos instance = new Productos();
        instance.catalogoProductos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of catalogoProductos method, of class Productos.
     */
    @org.junit.jupiter.api.Test
    public void testCatalogoProductos_char() {
        System.out.println("catalogoProductos");
        char tipo = ' ';
        Productos instance = new Productos();
        instance.catalogoProductos(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of catalogoProductos method, of class Productos.
     */
    @org.junit.jupiter.api.Test
    public void testCatalogoProductos_String() {
        System.out.println("catalogoProductos");
        String unidad = "";
        Productos instance = new Productos();
        instance.catalogoProductos(unidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of catalogoProductos method, of class Productos.
     */
    @org.junit.jupiter.api.Test
    public void testCatalogoProductos_String_char() {
        System.out.println("catalogoProductos");
        String unidad = "";
        char tipo = ' ';
        Productos instance = new Productos();
        instance.catalogoProductos(unidad, tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
