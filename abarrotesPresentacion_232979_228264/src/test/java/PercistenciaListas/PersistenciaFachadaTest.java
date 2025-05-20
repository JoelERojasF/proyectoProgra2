/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package PercistenciaListas;

import com.objetosnegocio.MovimientoGranel;
import com.objetosnegocio.Producto;
import com.objetosnegocio.ProductoGranel;
import com.objetosservicio.Fecha;
import com.objetosservicio.Periodo;
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
public class PersistenciaFachadaTest {
    
    public PersistenciaFachadaTest() {
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
     * Test of agregarProductoGranel method, of class PersistenciaFachada.
     */
    @Test
    public void testAgregarProductoGranel() {
       System.out.println("agregarProductoGranel");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        PersistenciaFachada instance = new PersistenciaFachada();
        
        try{
        
        instance.agregarProductoGranel(productoG);
        System.out.println(instance.obtenerProducto(productoG.getClave()).toString());
        System.out.println(instance.obtenerProductoGranel(productoG.getClave()).toString());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(productoG, instance.obtenerProductoGranel(productoG.getClave()));
       
    }

    /**
     * Test of obtenerProductoGranel method, of class PersistenciaFachada.
     */
    @Test
    public void testObtenerProductoGranel() {
        System.out.println("obtenerProductoGranel");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        PersistenciaFachada instance = new PersistenciaFachada();
        ProductoGranel pruebaG = new ProductoGranel();
        
        try{
        
        instance.agregarProductoGranel(productoG);
        pruebaG= instance.obtenerProductoGranel(productoG.getClave());
        System.out.println(pruebaG.toString());

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(productoG, pruebaG);
    }

    /**
     * Test of actualizarProductoGranel method, of class PersistenciaFachada.
     */
    @Test
    public void testActualizarProductoGranel() {
        System.out.println("actualizarProductoGranel");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        ProductoGranel productoEsperadoG = new ProductoGranel(2f, producto);
        PersistenciaFachada instance = new PersistenciaFachada();
        
        try{
        
        instance.agregarProductoGranel(productoG);
        instance.actualizarProductoGranel(productoG, 2f);
        System.out.println(instance.obtenerProducto(productoG.getClave()).toString());
        System.out.println(instance.obtenerProductoGranel(productoG.getClave()).toString());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(productoEsperadoG, instance.obtenerProductoGranel(productoG.getClave()));
    }

    /**
     * Test of eliminarProductoGranel method, of class PersistenciaFachada.
     */
    @Test
    public void testEliminarProductoGranel() {
        System.out.println("eliminarProductoGranel");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        PersistenciaFachada instance = new PersistenciaFachada();
        
        try{
        
        instance.agregarProductoGranel(productoG);
        instance.eliminarProductoGranel(productoG);
        
        System.out.println(instance.obtenerProducto(productoG.getClave()).toString());
        System.out.println(instance.obtenerProductoGranel(productoG.getClave()).toString());
        
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        assertEquals(null, instance.obtenerProductoGranel(productoG.getClave()));
    }

    /**
     * Test of obtenerInventarioGranel method, of class PersistenciaFachada.
     */
    @Test
    public void testObtenerInventarioGranel() {
        System.out.println("obtenerInventarioGranel");
        Producto producto1 = new Producto("Papas Kiwi", "g", 'G');
        Producto producto2 = new Producto("Agua Mineral", "L", 'G');
        ProductoGranel productoG1 = new ProductoGranel(1f, producto1);
        ProductoGranel productoG2 = new ProductoGranel(1f, producto2);
        PersistenciaFachada instance = new PersistenciaFachada();
        ArrayList<ProductoGranel> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(productoG1);
        resultadoEsperado.add(productoG2);
        
        try{
        
        instance.agregarProductoGranel(productoG1);
        instance.agregarProductoGranel(productoG2);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        assertEquals(instance.obtenerInventarioGranel(), resultadoEsperado);
    }

    /**
     * Test of agregarProducto method, of class PersistenciaFachada.
     */
    @Test
    public void testAgregarProducto() {
       System.out.println("agregarProducto");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        PersistenciaFachada instance = new PersistenciaFachada();
        
        try{
        
        instance.agregarProducto(producto);
         System.out.println(instance.obtenerProducto(producto.getClave()).toString());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        assertEquals(producto, instance.obtenerProducto(producto.getClave()));
    }

    /**
     * Test of obtenerProducto method, of class PersistenciaFachada.
     */
    @Test
    public void testObtenerProducto() {
         System.out.println("obtenerProducto");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        PersistenciaFachada instance = new PersistenciaFachada();
        
        try{
        
        instance.agregarProducto(producto);
         System.out.println(instance.obtenerProducto(producto.getClave()).toString());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        assertEquals(producto, instance.obtenerProducto(producto.getClave()));
    }

    /**
     * Test of actualizarProducto method, of class PersistenciaFachada.
     */
    @Test
    public void testActualizarProducto() {
        System.out.println("actualizarProducto");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        PersistenciaFachada instance = new PersistenciaFachada();
        
        try{
        
        instance.agregarProducto(producto);
        instance.actualizarProducto(producto, "Agua Mineral", "L", 'G');
        
        System.out.println(producto.toString());
        System.out.println(instance.obtenerProducto(producto.getClave()).toString());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        assertEquals(producto, instance.obtenerProducto(producto.getClave()));
    }

    /**
     * Test of eliminarProducto method, of class PersistenciaFachada.
     */
    @Test
    public void testEliminarProducto() {
         System.out.println("eliminarProducto");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        PersistenciaFachada instance = new PersistenciaFachada();
        
        try{
        
        instance.agregarProducto(producto);
        instance.eliminarProducto(producto);
        
         System.out.println(instance.obtenerProducto(producto.getClave()).toString());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        assertEquals(null, instance.obtenerProducto(producto.getClave()));
    }

    /**
     * Test of obtenerCatalogoProductos method, of class PersistenciaFachada.
     */
    @Test
    public void testObtenerCatalogoProductos() {
        System.out.println("obtenerCatalogoProductos");
        Producto producto1 = new Producto("Papas Kiwi", "g", 'G');
        Producto producto2 = new Producto("Agua Mineral", "L", 'G');
        PersistenciaFachada instance = new PersistenciaFachada();
        ArrayList<Producto> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(producto1);
        resultadoEsperado.add(producto2);
        try{
        
        instance.agregarProducto(producto1);
        instance.agregarProducto(producto2);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       
        assertEquals(resultadoEsperado, instance.obtenerCatalogoProductos("", '\0'));
    }

    /**
     * Test of agregarCompra method, of class PersistenciaFachada.
     */
    @Test
    public void testAgregarCompra() {
        System.out.println("agregarCompra");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        MovimientoGranel compra = new MovimientoGranel(fecha, false, productoG);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);
        
        try{
        
        instance.agregarCompra(compra);
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(compra, instance.obtenerMovimiento(compra.getCveMovimient()));
    }

    /**
     * Test of agregarVenta method, of class PersistenciaFachada.
     */
    @Test
    public void testAgregarVenta() {
       System.out.println("agregarVenta");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        MovimientoGranel venta = new MovimientoGranel(fecha, false, productoG);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);
        
        try{
        
        instance.agregarVenta(venta);
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(venta, instance.obtenerMovimiento(venta.getCveMovimient()));
    }

    /**
     * Test of obtenerVentasProducto method, of class PersistenciaFachada.
     */
    @Test
    public void testObtenerVentasProducto() {
        System.out.println("obtenerVentasProducto");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        MovimientoGranel venta = new MovimientoGranel(fecha, false, productoG);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);
        
        ArrayList<MovimientoGranel> resultadoEsperado = new ArrayList();
        
        try{
        
        instance.agregarVenta(venta);
        resultadoEsperado = instance.obtenerVentasProducto(venta.getProductoGranel().getClave());
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(instance.mostrarRegistroVentas(), resultadoEsperado);
    }

    /**
     * Test of obtenerComprasProducto method, of class PersistenciaFachada.
     */
    @Test
    public void testObtenerComprasProducto() {
        System.out.println("obtenerComprasProducto");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        MovimientoGranel compra = new MovimientoGranel(fecha, false, productoG);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);
        
        ArrayList<MovimientoGranel> resultadoEsperado = new ArrayList();
        
        try{
        
        instance.agregarCompra(compra);
        resultadoEsperado = instance.obtenerComprasProducto(compra.getProductoGranel().getClave());
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(instance.mostrarRegistroCompras(), resultadoEsperado);
    }

    /**
     * Test of obtenerMovimiento method, of class PersistenciaFachada.
     */
    @Test
    public void testObtenerMovimiento() {
        System.out.println("obrenerMovimiento");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        MovimientoGranel compra = new MovimientoGranel(fecha, false, productoG);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);
        
        try{
        
        instance.agregarCompra(compra);
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(compra, instance.obtenerMovimiento(compra.getCveMovimient()));
    }

    /**
     * Test of mostrarRegistroCompras method, of class PersistenciaFachada.
     */
    @Test
    public void testMostrarRegistroCompras() {
       System.out.println("mostrarRegistroCompras");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        MovimientoGranel compra = new MovimientoGranel(fecha, false, productoG);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);
        
        ArrayList<MovimientoGranel> resultadoEsperado = new ArrayList();
        
        try{
        
        instance.agregarCompra(compra);
        resultadoEsperado.add(compra);
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(instance.mostrarRegistroCompras(), resultadoEsperado);
    }

    /**
     * Test of mostrarRegistroComprasPorPeriodo method, of class PersistenciaFachada.
     */
    @Test
    public void testMostrarRegistroComprasPorPeriodo() {
        System.out.println("mostrarRegistroComprasPorPeriodo");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        Producto producto2 = new Producto("Agua Mineral", "L", 'G');
        ProductoGranel productoG2 = new ProductoGranel(1f, producto2);
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        Fecha fecha0 = new Fecha(17,05,2025);
        Fecha fecha1 = new Fecha(18,05,2025);
        Fecha fecha2= new Fecha(20,05,2025);
        
        Periodo periodo = new Periodo(fecha1, fecha2);
        
        MovimientoGranel compra = new MovimientoGranel(fecha, false, productoG);
        MovimientoGranel compra2 = new MovimientoGranel(fecha0, false, productoG2);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);
        instance.agregarProductoGranel(productoG2);
        
        ArrayList<MovimientoGranel> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(compra);
        
        try{
        
        instance.agregarCompra(compra);
        instance.agregarCompra(compra2);
        
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(instance.mostrarRegistroComprasPorPeriodo(periodo), resultadoEsperado);
    }

    /**
     * Test of mostrarRegistroVentas method, of class PersistenciaFachada.
     */
    @Test
    public void testMostrarRegistroVentas() {
        System.out.println("mostrarRegistroVentas");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        MovimientoGranel venta = new MovimientoGranel(fecha, false, productoG);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);
        
        ArrayList<MovimientoGranel> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(venta);
        
        try{
        
        instance.agregarVenta(venta);
        
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(instance.mostrarRegistroVentas(), resultadoEsperado);
    }

    /**
     * Test of mostrarRegistroVentasPorPeriodo method, of class PersistenciaFachada.
     */
    @Test
    public void testMostrarRegistroVentasPorPeriodo() {
         System.out.println("mostrarRegistroVentasPorPeriodo");
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        Producto producto2 = new Producto("Agua Mineral", "L", 'G');
        ProductoGranel productoG2 = new ProductoGranel(1f, producto2);
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        Fecha fecha = new Fecha();
        Fecha fecha0 = new Fecha(17,05,2025);
        Fecha fecha1 = new Fecha(18,05,2025);
        Fecha fecha2= new Fecha(20,05,2025);
        
        Periodo periodo = new Periodo(fecha1, fecha2);
        
        MovimientoGranel venta = new MovimientoGranel(fecha, false, productoG);
        MovimientoGranel venta2 = new MovimientoGranel(fecha0, false, productoG2);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoG);    
        instance.agregarProductoGranel(productoG2);
        
        ArrayList<MovimientoGranel> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(venta);
        

        
        try{
        
        instance.agregarVenta(venta);
        instance.agregarVenta(venta2);
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(instance.mostrarRegistroVentasPorPeriodo(periodo), resultadoEsperado);
    }

    /**
     * Test of actualizarInventarioVentas method, of class PersistenciaFachada.
     */
    @Test
    public void testActualizarInventarioVentas() {
        System.out.println("ActualizarInventarioVentas");
        
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        Producto producto2 = new Producto("Agua Mineral", "L", 'G');
        
        ProductoGranel productoG2 = new ProductoGranel(1f, producto2);
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        ProductoGranel productoGI2 = new ProductoGranel(10f, producto2);
        ProductoGranel productoGI = new ProductoGranel(10f, producto);
        
        
        Fecha fecha = new Fecha();
        Fecha fecha0 = new Fecha(17,05,2025);
        
        MovimientoGranel venta = new MovimientoGranel(fecha, false, productoG);
        MovimientoGranel venta2 = new MovimientoGranel(fecha0, false, productoG2);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoGI);    
        instance.agregarProductoGranel(productoGI2);
        
        ArrayList<MovimientoGranel> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(venta);
        resultadoEsperado.add(venta2);
        ArrayList<MovimientoGranel> resultado = new ArrayList();
        try{
        
        instance.agregarVenta(venta);
        instance.agregarVenta(venta2);
        resultado = instance.actualizarInventarioVentas();
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(resultadoEsperado, resultado);
    }

    /**
     * Test of actualizarInventarioCompras method, of class PersistenciaFachada.
     */
    @Test
    public void testActualizarInventarioCompras() {
        System.out.println("ActualizarInventarioCompras");
        
        Producto producto = new Producto("Papas Kiwi", "g", 'G');
        Producto producto2 = new Producto("Agua Mineral", "L", 'G');
        
        ProductoGranel productoG2 = new ProductoGranel(1f, producto2);
        ProductoGranel productoG = new ProductoGranel(1f, producto);
        ProductoGranel productoGI2 = new ProductoGranel(10f, producto2);
        ProductoGranel productoGI = new ProductoGranel(10f, producto);
        
        
        Fecha fecha = new Fecha();
        Fecha fecha0 = new Fecha(17,05,2025);
        
        MovimientoGranel compra = new MovimientoGranel(fecha, false, productoG);
        MovimientoGranel compra2 = new MovimientoGranel(fecha0, false, productoG2);
        
        PersistenciaFachada instance = new PersistenciaFachada();
        instance.agregarProductoGranel(productoGI);    
        instance.agregarProductoGranel(productoGI2);
        
        ArrayList<MovimientoGranel> resultadoEsperado = new ArrayList();
        resultadoEsperado.add(compra);
        resultadoEsperado.add(compra2);
        ArrayList<MovimientoGranel> resultado = new ArrayList();
        try{
        
        instance.agregarCompra(compra);
        instance.agregarCompra(compra2);
        resultado = instance.actualizarInventarioCompras();
       
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(resultadoEsperado, resultado);
    }
    
}
