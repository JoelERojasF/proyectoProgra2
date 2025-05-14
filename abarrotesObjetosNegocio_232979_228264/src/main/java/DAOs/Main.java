/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAOs;

import com.objetosnegocio.MovimientoGranel;
import com.objetosnegocio.Producto;
import com.objetosnegocio.ProductoGranel;
import com.objetosservicio.Fecha;

/**
 *
 * @author le0jx
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Fecha fecha = new Fecha();
      MovimientosGranel movimientosG = new MovimientosGranel();
      Productos productos = new Productos();
      ProductosGranel productosG = new ProductosGranel();
      
        
        System.out.println("pruebas");
        
        
        
        System.out.println("enlistar ventas vacias");
        
        try{
            MovimientosGranel.consultarVentas();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("crear productos uno bien y otro mal");
        
        try{
            Producto productoB = new Producto("Papas Kiwi", "g", 'G');
            productos.agregarProducto(productoB);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        try{
            Producto productoM = new Producto("AM","Agua Mineral", "L", 'A');
            productos.agregarProducto(productoM);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        //imprimir catalogo productos
        try{
            System.out.println(ProductosGranel.catalogoProductos());
            
        }catch(Exception e){
        e.getMessage();
        }
        
        //eliminar producto inexistente
        try{
            ProductosGranel.eliminarProducto("AM002");
            System.out.println(ProductosGranel.catalogoProductos());
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
        
        //cambiar tipo a A
        try{
           Producto ProductoB = Productos.buscarProductoPorClave("xx001");
        Productos.actualizarProducto(ProductoB, ProductoB.getNombre(), ProductoB.getUnidad(), 'A');
        System.out.println(ProductosGranel.catalogoProductos());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        //primera venta
        try{
        Producto ProductoB = Productos.buscarProductoPorClave("xx001");
        
        ProductoGranel po = new ProductoGranel(1.5f, ProductoB);
        MovimientoGranel mo = new MovimientoGranel(fecha, false, po);
        
        MovimientosGranel.venderGranel(mo);
        System.out.println(MovimientosGranel.consultarVentas());
        

        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        //segunda venta
        try{
        Producto ProductoB = Productos.buscarProductoPorClave("xx001");
        ProductoGranel po = new ProductoGranel(1.5f, ProductoB);
        MovimientoGranel mo = new MovimientoGranel(fecha, false, po);
        
        MovimientosGranel.venderGranel(mo);
        System.out.println(MovimientosGranel.consultarVentas());
        

        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
