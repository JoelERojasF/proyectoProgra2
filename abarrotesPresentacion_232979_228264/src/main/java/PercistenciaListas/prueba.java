/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PercistenciaListas;

import DAOs.MovimientosGranel;
import DAOs.Productos;
import DAOs.ProductosGranel;
import com.objetosnegocio.Producto;
import com.objetosservicio.Fecha;

/**
 *
 * @author joser
 */
public class prueba {
    //clase de prueba solamente
    
    public static void main(String[] args) {
        
        Fecha fecha = new Fecha();
        MovimientosGranel movimientosG = new MovimientosGranel();
        Productos productos = new Productos();
        ProductosGranel productosG = new ProductosGranel();
        
        
        Producto productoB = new Producto("Papas Kiwi", "g", 'G');
        PersistenciaFachada. agregarProducto(productoB);
        
    }
}
