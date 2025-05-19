/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PercistenciaListas;

import DAOs.MovimientosGranel;
import DAOs.Productos;
import DAOs.ProductosGranel;
import Excepciones.ElementoNoEncontradoException;
import com.objetosnegocio.MovimientoGranel;
import com.objetosnegocio.Producto;
import com.objetosnegocio.ProductoGranel;
import com.objetosservicio.Periodo;
import java.util.ArrayList;

/**
 *
 * @author le0jx
 */
public class PersistenciaFachada implements IPersistenciaFachada {
    

    public void agregarProductoGranel(ProductoGranel producto){
        try{
            if(Productos.buscarProductoPorClave(producto.getClave()) == null){
                Productos.agregarProducto(producto);
            }
            ProductosGranel.agregarAlInventatio(producto);
        }catch(Exception e){
        e.getMessage();
        }
    }
    
    public ProductoGranel obtenerProductoGranel(String cve){
        try{
            return ProductosGranel.buscarProductoPorClave(cve);
        }catch(Exception e){
        e.getMessage();
        return null;
        }  
    }
    
    public void actualizarProductoGranel(ProductoGranel producto, float cantidad){
        try{
            ProductosGranel.actualizarInventario(producto, cantidad);
        }catch(Exception e){
        e.getMessage();
        }
    }
    
    public void eliminarProductoGranel(ProductoGranel producto){
        try{
            ProductosGranel.eliminarDelInventario(producto);
        }catch(Exception e){
        e.getMessage();
        }
    }

    
    @Override
    public void agregarProducto(Producto producto) {
        try{
        Productos.agregarProducto(producto);
        }catch(Exception e){
        e.getMessage();
        }
    }

    @Override
    public Producto obtenerProducto(String clave) {
        try{
        return Productos.buscarProductoPorClave(clave);
        }catch(Exception e){
        e.getMessage();
        return null;
        }
    }

    @Override
    public void actualizar(Producto producto, String nuevoNombre, String nuevaUnidad, char NuevoTipo) {
        try{
        Productos.actualizarProducto(producto, nuevoNombre, nuevaUnidad, NuevoTipo);
        }catch(Exception e){
        e.getMessage();
        }
    }

    @Override
    public void eliminar(Producto producto) {
        try{
        Productos.eliminarProducto(producto.getClave());
        }catch(Exception e){
        e.getMessage();
        }
    }

    @Override
    public ArrayList<Producto> obtenerCatalogoProductos(String unidad, char tipo) {
        try{
            if((unidad != null || !"".equals(unidad)) && (tipo != '\0') ){
                return Productos.catalogoProductos(unidad, tipo);
            }else{
            if((unidad == null || "".equals(unidad)) && (tipo != '\0')){
                return Productos.catalogoProductos(tipo);
            }else{
            if((unidad != null || !"".equals(unidad)) && (tipo == '\0')){
                return Productos.catalogoProductos(unidad);
            }else{
                return Productos.catalogoProductos();
            }
            }
            }
        }catch(Exception e){
        e.getMessage();
        return null;
        }
    }
    
    

    @Override
    public void agregarCompra(MovimientoGranel compra) {
        try{
            if(Productos.buscarProductoPorClave(compra.getProductoGranel().getClave()) != null){
                MovimientosGranel.comprarGranel(compra);
            }else{
                throw new ElementoNoEncontradoException();
            }    
        }catch(Exception e){
        e.getMessage();
        }
    }

    @Override
    public void agregarVenta(MovimientoGranel venta) {
        try{
            if(Productos.buscarProductoPorClave(venta.getProductoGranel().getClave()) != null){
                MovimientosGranel.venderGranel(venta);
            }else{
                throw new ElementoNoEncontradoException();
            }   
        }catch(Exception e){
        e.getMessage();
        }
    }

    @Override
    public MovimientoGranel obtenerVenta(String clave) {
        try{
            return MovimientosGranel.buscarVentaPorClave(clave);
        }catch(Exception e){
        e.getMessage();
        return null;
        }
    }

    @Override
    public MovimientoGranel obtenerCompra(String clave) {
        try{
            return MovimientosGranel.buscarCompraPorClave(clave);
        }catch(Exception e){
        e.getMessage();
        return null;
        }
    }

    @Override
    public ArrayList<MovimientoGranel> mostrarRegistroCompras() {
        try{
            return MovimientosGranel.consultarCompras();
        }catch(Exception e){
        e.getMessage();
        return null;
        }
    }

    @Override
    public ArrayList<MovimientoGranel> mostrarRegistroComprasPorPeriodo(Periodo periodo) {
        try{
            return MovimientosGranel.consultarCompras(periodo);
        }catch(Exception e){
        e.getMessage();
        return null;
        }
    }

    @Override
    public ArrayList<MovimientoGranel> mostrarRegistroVentas() {
        try{
            return MovimientosGranel.consultarVentas();
        }catch(Exception e){
        e.getMessage();
        return null;
        }
    }

    @Override
    public ArrayList<MovimientoGranel> mostrarRegistroVentasPorPeriodo(Periodo periodo) {
        try{
            return MovimientosGranel.consultarVentas(periodo);
        }catch(Exception e){
        e.getMessage();
        return null;
        }
    }
    
    
        @Override
    public ArrayList<MovimientoGranel> actualizarInventarioVentas() {
       ArrayList<MovimientoGranel> movimientosVerificados = new ArrayList();
        try{
        
        for (int i = 0; i < MovimientosGranel.consultarVentas().size(); i++) {
            if(MovimientosGranel.consultarVentas().get(i).getProcesado() == false){
                if(ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarVentas().get(i).getProductoGranel().getClave()) != null){
                    if(ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarVentas().get(i).getProductoGranel().getClave()).getCantidad() >= MovimientosGranel.consultarVentas().get(i).getProductoGranel().getCantidad()){
                        ProductosGranel.actualizarInventario(MovimientosGranel.consultarVentas().get(i).getProductoGranel(), (ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarVentas().get(i).getProductoGranel().getClave()).getCantidad() - MovimientosGranel.consultarVentas().get(i).getProductoGranel().getCantidad()));
                        MovimientosGranel.consultarVentas().get(i).setProcesado(Boolean.TRUE);
                        movimientosVerificados.add(MovimientosGranel.consultarVentas().get(i));
                    }else{
                    //cantidad del movimiento mayor a la del inventario
                    }
                }else{
                //producto no existe en el inventario
                }
            }
        }
        if(!movimientosVerificados.isEmpty()){
        return movimientosVerificados;
        }else{
        return null;
        }
        
        }catch(Exception e){
            e.getMessage();
            if(!movimientosVerificados.isEmpty()){
            return movimientosVerificados;
            }else{
            return null;
            }
        }
    }

    @Override
    public ArrayList<MovimientoGranel> actualizarInventarioCompras() {
       ArrayList<MovimientoGranel> movimientosVerificados = new ArrayList();
        try{
        
        for (int i = 0; i < MovimientosGranel.consultarCompras().size(); i++) {
            if(MovimientosGranel.consultarCompras().get(i).getProcesado() == false){
                if(ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarCompras().get(i).getProductoGranel().getClave()) != null){
                    if(((MovimientosGranel.consultarCompras().get(i).getProductoGranel().getUnidad().equalsIgnoreCase("KG") || MovimientosGranel.consultarCompras().get(i).getProductoGranel().getUnidad().equalsIgnoreCase("G")) && (MovimientosGranel.consultarCompras().get(i).getProductoGranel().getCantidad() + ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarCompras().get(i).getProductoGranel().getClave()).getCantidad()) <= 1500.00f) || (MovimientosGranel.consultarCompras().get(i).getProductoGranel().getUnidad().equalsIgnoreCase("L") && (MovimientosGranel.consultarCompras().get(i).getProductoGranel().getCantidad() + ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarCompras().get(i).getProductoGranel().getClave()).getCantidad()) <= 3000.00f) ){
                        ProductosGranel.actualizarInventario(MovimientosGranel.consultarCompras().get(i).getProductoGranel(), (ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarCompras().get(i).getProductoGranel().getClave()).getCantidad() + MovimientosGranel.consultarCompras().get(i).getProductoGranel().getCantidad()));
                        MovimientosGranel.consultarCompras().get(i).setProcesado(Boolean.TRUE);
                        movimientosVerificados.add(MovimientosGranel.consultarCompras().get(i));
                    }else{
                    //cantidad del movimiento mayor a la del inventario
                    }
                }else{
                //producto no existe en el inventario
                }
            }
        }
        if(!movimientosVerificados.isEmpty()){
        return movimientosVerificados;
        }else{
        return null;
        }
        
        }catch(Exception e){
            e.getMessage();
            if(!movimientosVerificados.isEmpty()){
            return movimientosVerificados;
            }else{
            return null;
            }
        }
    }
}
