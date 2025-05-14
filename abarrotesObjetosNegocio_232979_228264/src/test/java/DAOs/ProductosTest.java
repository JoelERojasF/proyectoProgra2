/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import java.util.ArrayList;
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

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        Productos.clear();
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of agregarProducto method, of class Productos.
     */
    @Test
    public void testAgregarProducto() {
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        Productos.agregarProducto(producto);
        assertEquals(producto, Productos.catalogoProductos.getFirst());
        
    }

    /**
     * Test of buscarProductoPorClave method, of class Productos.
     */
    @Test
    public void testBuscarProductoPorClave() {
        Producto producto1 = new Producto("Papas Kiwi", "g", 'E');
        Productos.agregarProducto(producto1);
        Producto producto2 = new Producto("Galletas", "KG", 'E');
        Productos.agregarProducto(producto2);
        Producto producto3 = new Producto("Agua", "L", 'E');
        Productos.agregarProducto(producto3);
        String clave = producto2.getClave();
        
        assertEquals(producto2, Productos.buscarProductoPorClave(clave));
              
        
    }

    /**
     * Test of eliminarProducto method, of class Productos.
     */
    @Test
    public void testEliminarProducto() {
        Producto producto1 = new Producto("Papas Kiwi", "g", 'E');
        Productos.agregarProducto(producto1);
        Producto producto2 = new Producto("Galletas", "KG", 'E');
        Productos.agregarProducto(producto2);
        Producto producto3 = new Producto("Agua", "L", 'E');
        Productos.agregarProducto(producto3);

        
        //eliminamos el producto 2 del catalogo
        Productos.eliminarProducto(producto2.getClave());
        
        //revisamos si el producto 2 se encuentra en nuestro catalogo
        assertEquals(false, Productos.catalogoProductos.contains(producto2));
        
    }

    /**
     * Test of actualizarProducto method, of class Productos.
     */
    @Test
    public void testActualizarProducto() {
        Producto producto = new Producto("pk","Papas Kiwi", "g", 'E');
        String nombreEsperado = "Agua";
        String unidadEsperada = "L";
        char charEsperado = 'E';
        
        Productos.agregarProducto(producto);
        Productos.actualizarProducto(producto, "Agua", "L", 'E');
        
        assertEquals(nombreEsperado, Productos.catalogoProductos.getFirst().getNombre());
        assertEquals(unidadEsperada, Productos.catalogoProductos.getFirst().getUnidad());
        assertEquals(charEsperado, Productos.catalogoProductos.getFirst().getTipo());
    }

    /**
     * Test of catalogoProductos method, of class Productos.
     */
    @Test
    public void testCatalogoProductos_0args() {
        Producto producto1 = new Producto("Papas Kiwi", "g", 'E');
        Productos.agregarProducto(producto1);
        Producto producto2 = new Producto("Galletas", "KG", 'E');
        Productos.agregarProducto(producto2);
        Producto producto3 = new Producto("Agua", "L", 'E');
        Productos.agregarProducto(producto3);
        
        ArrayList<Producto> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(producto1);
        resultadoEsperado.add(producto2);
        resultadoEsperado.add(producto3);
        
        assertEquals(resultadoEsperado, Productos.catalogoProductos());
        
    }

    /**
     * Test of catalogoProductos method, of class Productos.
     */
    @Test
    public void testCatalogoProductos_char() {
        Producto producto1 = new Producto("Papas Kiwi", "g", 'E');
        Productos.agregarProducto(producto1);
        Producto producto2 = new Producto("Galletas", "KG", 'G');
        Productos.agregarProducto(producto2);
        Producto producto3 = new Producto("Agua", "L", 'E');
        Productos.agregarProducto(producto3);
        
        ArrayList<Producto> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(producto1);
        resultadoEsperado.add(producto3);
        
        assertEquals(resultadoEsperado, Productos.catalogoProductos('E'));
    }

    /**
     * Test of catalogoProductos method, of class Productos.
     */
    @Test
    public void testCatalogoProductos_String() {
        Producto producto1 = new Producto("Papas Kiwi", "g", 'E');
        Productos.agregarProducto(producto1);
        Producto producto2 = new Producto("Galletas", "KG", 'G');
        Productos.agregarProducto(producto2);
        Producto producto3 = new Producto("Agua", "KG", 'E');
        Productos.agregarProducto(producto3);
        
        ArrayList<Producto> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(producto2);
        resultadoEsperado.add(producto3);
        
        assertEquals(resultadoEsperado, Productos.catalogoProductos("KG"));
    }

    /**
     * Test of catalogoProductos method, of class Productos.
     */
    @Test
    public void testCatalogoProductos_String_char() {
        Producto producto1 = new Producto("Papas Kiwi", "KG", 'E');
        Productos.agregarProducto(producto1);
        Producto producto2 = new Producto("Galletas", "KG", 'E');
        Productos.agregarProducto(producto2);
        Producto producto3 = new Producto("Agua", "KG", 'E');
        Productos.agregarProducto(producto3);
        
        ArrayList<Producto> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(producto1);
        resultadoEsperado.add(producto2);
        resultadoEsperado.add(producto3);
        
        assertEquals(resultadoEsperado, Productos.catalogoProductos("KG", 'E'));
        
    }
    
}
