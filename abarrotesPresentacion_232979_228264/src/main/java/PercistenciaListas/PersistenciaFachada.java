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
            if(Productos.buscarProductoPorClave(producto.getClave()) == null){
                Productos.agregarProducto(producto);
            }
            ProductosGranel.agregarAlInventatio(producto);
       
    }
    
    public ProductoGranel obtenerProductoGranel(String cve){
            return ProductosGranel.buscarProductoPorClave(cve);
    }
    
    public void actualizarProductoGranel(ProductoGranel producto, float cantidad){
            ProductosGranel.actualizarInventario(producto, cantidad);
    }
    
    public void eliminarProductoGranel(ProductoGranel producto){
            ProductosGranel.eliminarDelInventario(producto);
    }
    
    public ArrayList<ProductoGranel> obtenerInventarioGranel(){
        return ProductosGranel.consultarInventario();
    }
    

    
    @Override
    public void agregarProducto(Producto producto) {
        Productos.agregarProducto(producto);
    }

    @Override
    public Producto obtenerProducto(String clave) {
        return Productos.buscarProductoPorClave(clave);
    }

    @Override
    public void actualizarProducto(Producto producto, String nuevoNombre, String nuevaUnidad, char NuevoTipo) {
        Productos.actualizarProducto(producto, nuevoNombre, nuevaUnidad, NuevoTipo);
    }

    @Override
    public void eliminarProducto(Producto producto) {
        Productos.eliminarProducto(producto.getClave());
    }

    @Override
    public ArrayList<Producto> obtenerCatalogoProductos(String unidad, char tipo) {
            if((!"".equals(unidad)) && (tipo != '\0') ){
                System.out.println("busqueda con unidad y tipo");
                return Productos.catalogoProductos(unidad, tipo);
            }else{
            if(("".equals(unidad)) && (tipo != '\0')){
                System.out.println("busqueda con tipo");
                return Productos.catalogoProductos(tipo);
            }else{
            if((!"".equals(unidad)) && (tipo == '\0')){
                System.out.println("busqueda con unidad");
                return Productos.catalogoProductos(unidad);
            }else{
                System.out.println("busqueda sin parametros");
                return Productos.catalogoProductos();
            }
            }
            }
    }
    
    

    @Override
    public void agregarCompra(MovimientoGranel compra) {
            if(Productos.buscarProductoPorClave(compra.getProductoGranel().getClave()) != null){
                MovimientosGranel.comprarGranel(compra);
            }else{
                throw new ElementoNoEncontradoException("Error: el producto no esta registrado");
            }    
    }

    @Override
    public void agregarVenta(MovimientoGranel venta) {
            if(Productos.buscarProductoPorClave(venta.getProductoGranel().getClave()) != null){
                MovimientosGranel.venderGranel(venta);
            }else{
                throw new ElementoNoEncontradoException();
            }   
    }

    @Override
    public ArrayList<MovimientoGranel> obtenerVentasProducto(String clave) {
            return MovimientosGranel.buscarVentasPorClaveProducto(clave);
    }

    @Override
    public ArrayList<MovimientoGranel> obtenerComprasProducto(String clave) {
            return MovimientosGranel.buscarComprasPorClaveProducto(clave);
    }
    
    @Override
    public MovimientoGranel obtenerMovimiento(String clave){
            return MovimientosGranel.buscarMovimiento(clave);
    }


    @Override
    public ArrayList<MovimientoGranel> mostrarRegistroCompras() {
            return MovimientosGranel.consultarCompras();
    }

    @Override
    public ArrayList<MovimientoGranel> mostrarRegistroComprasPorPeriodo(Periodo periodo) {
            return MovimientosGranel.consultarCompras(periodo);
    }

    @Override
    public ArrayList<MovimientoGranel> mostrarRegistroVentas() {
            return MovimientosGranel.consultarVentas();
    }

    @Override
    public ArrayList<MovimientoGranel> mostrarRegistroVentasPorPeriodo(Periodo periodo) {
            return MovimientosGranel.consultarVentas(periodo);
    }
    
    
        @Override
    public ArrayList<MovimientoGranel> actualizarInventarioVentas() {
       ArrayList<MovimientoGranel> movimientosVerificados = new ArrayList();
        
        for (int i = 0; i < MovimientosGranel.consultarVentas().size(); i++) {
            if(MovimientosGranel.consultarVentas().get(i).getProcesado() == false){
                if(ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarVentas().get(i).getProductoGranel().getClave()) != null){
                    if(ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarVentas().get(i).getProductoGranel().getClave()).getCantidad() >= MovimientosGranel.consultarVentas().get(i).getProductoGranel().getCantidad()){
                        ProductosGranel.actualizarInventario(MovimientosGranel.consultarVentas().get(i).getProductoGranel(), (ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarVentas().get(i).getProductoGranel().getClave()).getCantidad() - MovimientosGranel.consultarVentas().get(i).getProductoGranel().getCantidad()));
                        MovimientosGranel.consultarVentas().get(i).setProcesado(Boolean.TRUE);
                        movimientosVerificados.add(MovimientosGranel.consultarVentas().get(i));
                        if(ProductosGranel.buscarProductoPorClave(MovimientosGranel.consultarVentas().get(i).getProductoGranel().getClave()).getCantidad() == 0){
                        ProductosGranel.eliminarDelInventario(MovimientosGranel.consultarVentas().get(i).getProductoGranel());
                        }
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
    }

    @Override
    public ArrayList<MovimientoGranel> actualizarInventarioCompras() {
       ArrayList<MovimientoGranel> movimientosVerificados = new ArrayList();
        
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
    }
}
