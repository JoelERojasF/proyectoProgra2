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
                throw new ElementoDuplicadoException("Error: el producto ya existe en el inventario");
            }
        }
        
        if(producto.getCantidad() > 0){
                inventarioGranel.add(producto);
            }else{
                throw new DatoInvalidoException("Error: Cantidad menor o igual que 0");
        }
        
    }
    
    /**
     * metodo pata eliminar un producto del inventario
     * @param producto producto a eliminar
     */
    public static void eliminarDelInventario(ProductoGranel producto){
        int indiceEliminar = -1;
        for(int i = 0; i <inventarioGranel.size(); i ++){
            if(inventarioGranel.get(i).equals(producto)){
                indiceEliminar = i;
            }
        }
        if(indiceEliminar != -1){
            inventarioGranel.remove(indiceEliminar);
        } else{
            throw new ElementoNoEncontradoException("Error: el producto no existe en el inventario");
        }
    }
    
    //

    /**
     * matodo para actualizar un producto del inventario
     * @param producto producto a actualizar
     * @param cantidad cantidad actualizada
     */
    public static void actualizarInventario(ProductoGranel producto,float cantidad){

        int indiceActualizar = -1;

        for(int i = 0; i <inventarioGranel.size(); i ++){
            if(inventarioGranel.get(i).equals(producto)){
                indiceActualizar = i;
            }
        }
        if(indiceActualizar != -1){
            if(cantidad > 0){
                producto.setCantidad(cantidad);
                inventarioGranel.set(indiceActualizar, producto);
            }else{
                throw new DatoInvalidoException("Error: Cantidad menor o igual que 0");
            } 
        } else{
            throw new ElementoNoEncontradoException("Error: el producto no existe en el inventario");
        }
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
