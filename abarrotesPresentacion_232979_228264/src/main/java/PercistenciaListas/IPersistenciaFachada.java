/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package PercistenciaListas;

import com.objetosnegocio.MovimientoGranel;
import com.objetosnegocio.Producto;
import com.objetosservicio.Periodo;
import java.util.ArrayList;

/**
 *
 * @author le0jx
 */
public interface IPersistenciaFachada {
    
    public void agregarProducto(Producto producto);
    
    public Producto obtenerProducto(String clave);
    
    public void actualizar(Producto producto, String nuevoNombre, String nuevaUnidad, char NuevoTipo);

    public void eliminar(Producto producto);

    public ArrayList<Producto> obtenerCatalogoProductos(String unidad, char tipo);
    
    
        
    
    public void agregarCompra(MovimientoGranel compra);
    
    public void agregarVenta(MovimientoGranel venta);
    
    public MovimientoGranel obtenerVenta(String clave);

    public MovimientoGranel obtenerCompra(String clave);
        
    public ArrayList<MovimientoGranel> actualizarInventarioVentas();
    
    public ArrayList<MovimientoGranel> actualizarInventarioCompras();
    
    public ArrayList<MovimientoGranel>  mostrarRegistroCompras();
    
    public ArrayList<MovimientoGranel>  mostrarRegistroComprasPorPeriodo(Periodo periodo);
    
    public ArrayList<MovimientoGranel>  mostrarRegistroVentas();
    
    public ArrayList<MovimientoGranel>  mostrarRegistroVentasPorPeriodo(Periodo periodo);
    
    
    
//    
//    
//    public void actualizarVenta(MovimientoGranel venta);
//    
//    public void actualizarCompta(MovimientoGranel compra);
//     
//    public void eliminarVenta(MovimientoGranel venta);
//    
//    public void eliminarCompra(MovimientoGranel compra);
//    
//    

}
