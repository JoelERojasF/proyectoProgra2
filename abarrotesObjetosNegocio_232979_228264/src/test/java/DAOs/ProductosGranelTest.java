/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import com.objetosnegocio.ProductoGranel;
import com.objetosnegocio.Producto;
import java.util.ArrayList;
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
        ProductosGranel.clear();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregarAlInventatio method, of class ProductosGranel.
     */
    @Test
    public void testAgregarAlInventatio() {
        Producto producto = new Producto();
        ProductoGranel productoEsperado= new ProductoGranel(15.0f, producto);
        ProductosGranel.agregarAlInventatio(productoEsperado);
        assertTrue(ProductosGranel.inventarioGranel.contains(productoEsperado));
    }

    /**
     * Test of eliminarDelInventario method, of class ProductosGranel.
     */
    @Test
    public void testEliminarDelInventario() {
        Producto producto = new Producto();
        ProductoGranel productoEsperado= new ProductoGranel(15.0f, producto);
        ProductosGranel.agregarAlInventatio(productoEsperado);
        
        ProductosGranel.eliminarDelInventario(productoEsperado);
        assertFalse(ProductosGranel.inventarioGranel.contains(productoEsperado));
    }

    /**
     * Test of actualizarInventario method, of class ProductosGranel.
     */
    @Test
    public void testActualizarInventario() {
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoEsperado= new ProductoGranel(15.0f, producto);
        ProductosGranel.agregarAlInventatio(productoEsperado);
        
        ProductosGranel.actualizarInventario(productoEsperado, 12.0f);
        
        float cantidadEsperada = 12.0f;
        
        
        assertEquals(cantidadEsperada, ProductosGranel.inventarioGranel.getFirst().getCantidad());
    }

    /**
     * Test of consultarInventario method, of class ProductosGranel.
     */
    @Test
    public void testConsultarInventario() {
        ArrayList<ProductoGranel> listaEsperada = new ArrayList();
        
        Producto producto1 = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoGranel1 = new ProductoGranel(10.0f,producto1);
        listaEsperada.add(productoGranel1);
        ProductosGranel.agregarAlInventatio(productoGranel1);
        
        Producto producto2 = new Producto("Galletas", "KG", 'G');
        ProductoGranel productoGranel2 = new ProductoGranel(10.0f,producto2);
        listaEsperada.add(productoGranel2);
        ProductosGranel.agregarAlInventatio(productoGranel2);
        
        Producto producto3 = new Producto("Agua", "L", 'G');
        ProductoGranel productoGranel3 = new ProductoGranel(10.0f,producto3);
        listaEsperada.add(productoGranel3);
        ProductosGranel.agregarAlInventatio(productoGranel3);
        
        assertEquals(listaEsperada, ProductosGranel.consultarInventario());
        
        
    }
    
}
