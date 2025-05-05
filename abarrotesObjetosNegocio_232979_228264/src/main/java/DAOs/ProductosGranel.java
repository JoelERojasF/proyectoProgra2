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
    
    public void agregarAlInventatio(ProductoGranel producto){
        if(!inventarioGranel.contains(producto)){
            if(producto.getCantidad() > 0){
                inventarioGranel.add(producto);
            }else{
                throw new DatoInvalidoException("Error: Cantidad menor que 0");
            }
        }else{
            throw new ElementoDuplicadoException("Error: el producto ya existe");
        }
    }
    
    public void eliminarDelInventario(ProductoGranel producto){
        if(inventarioGranel.contains(producto)){
            inventarioGranel.remove(producto);
        }else{
            throw new ElementoNoEncontradoException("Error: el producto no existe");
        }
    }
    
    public void actualizarInventario(ProductoGranel producto,float cantidad){
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
    }
    
    public void consultarInventario(){
        for (int i = 0; i < inventarioGranel.size(); i++) {
            System.out.println(inventarioGranel.get(i).toString());
        } 
    }
    
}
