/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Excepciones.DatoInvalidoException;
import Excepciones.ElementoDuplicadoException;
import Excepciones.ElementoNoEncontradoException;
import com.objetosnegocio.ProductoGranel;
import java.util.ArrayList;

/**
 *
 * @author le0jx
 */
public class ProductosGranel extends Productos {
    public static ArrayList<ProductoGranel> inventarioGranel = new ArrayList<>();
    
    /**
     * metodo para agregar un producto al inventario
     * @param producto producto a agregar
     */
    public static void agregarAlInventatio(ProductoGranel producto){
        
        for(ProductoGranel prod : inventarioGranel ){
            if(prod.equals(producto)){
                throw new ElementoDuplicadoException("Error: ");
            }
        }
        
        if(producto.getCantidad() > 0){
                inventarioGranel.add(producto);
            }else{
                throw new DatoInvalidoException("Error: Cantidad menor que 0");
        }
        
        /*
        if(!inventarioGranel.contains(producto)){
            if(producto.getCantidad() > 0){
                inventarioGranel.add(producto);
            }else{
                throw new DatoInvalidoException("Error: Cantidad menor que 0");
            }
        }else{
            throw new ElementoDuplicadoException("Error: el producto ya existe");
        }
        */
    }
    
    /**
     * metodo pata eliminar un producto del inventario
     * @param producto producto a eliminar
     */
    public static void eliminarDelInventario(ProductoGranel producto){
        if(!inventarioGranel.contains(producto)){
            throw new ElementoNoEncontradoException("Error:");
        }
        
        int indiceEliminar = -1;
        for(int i = 0; i <inventarioGranel.size(); i ++){
            if(inventarioGranel.get(i).equals(producto)){
                indiceEliminar = i;
            }
        }
        if(indiceEliminar != -1){
            inventarioGranel.remove(indiceEliminar);
        }
        
        
        
        
    }
    
<<<<<<< HEAD
    //
=======
    /**
     * matodo para actualizar un producto del inventario
     * @param producto producto a actualizar
     * @param cantidad cantidad actualizada
     */
>>>>>>> e7c906ca025dbe3092b0b4caf02483f97ed3b790
    public static void actualizarInventario(ProductoGranel producto,float cantidad){
        if(!inventarioGranel.contains(producto)){
            throw new ElementoNoEncontradoException("Error:");
        }
        
        for(ProductoGranel prod : inventarioGranel){
            if(prod.equals(producto)){
                producto.setCantidad(cantidad);
            }
        }
        
        
        /*
        if(inventarioGranel.contains(producto)){
            if(cantidad > 0){
                for (int i = 0; i < inventarioGranel.size(); i++) {
                    if(inventarioGranel.get(i).getClave().equalsIgnoreCase(producto.getClave())){
                        producto.setCantidad(cantidad);
                        inventarioGranel.set(i, producto);
                    }
                }
            }else{
                throw new DatoInvalidoException("Error: Cantidad menor que 0");
            }
        
        }else{
            throw new ElementoNoEncontradoException("Error: el producto no existe");
        }
        */
    }
    
    /**
     * metodo para obtener el inventario
     * @return una lista con el inventario
     */
    public static ArrayList<ProductoGranel> consultarInventario(){
        if(inventarioGranel.isEmpty()){
            throw new DatoInvalidoException("Error: el inventario se encuentra vacio.");
        }
        return inventarioGranel;
    }
    
    /**
     * Metodo de depuración, limplia toda la lista, NO USAR!
     */
    public static void clear(){
        inventarioGranel.clear();
    }
    
}
