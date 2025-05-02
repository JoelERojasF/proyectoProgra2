/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Excepciones.DatoInvalidoException;
import Excepciones.ElementoDuplicadoException;
import Excepciones.ElementoNoEncontradoException;
import com.objetosnegocio.Producto;
import java.util.ArrayList;

/**
 *
 * @author Joel Rojas y Rubén Valdez
 */
public class Productos {
    public static ArrayList<Producto> catalogoProductos = new ArrayList<>();
    
    public void agregarProducto(Producto producto){
        if(!catalogoProductos.contains(producto)){
            for (int i = 0; i < catalogoProductos.size(); i++) {
                if(catalogoProductos.get(i).getClave().equalsIgnoreCase(producto.getClave())){
                    throw new ElementoDuplicadoException("Error: la clave del producto ya esta registrada.");
                }
            }
            if(!"".equals(producto.getNombre()) || producto.getNombre() != null){
                if("KG".equalsIgnoreCase(producto.getUnidad()) || "g".equalsIgnoreCase(producto.getUnidad()) || "L".equalsIgnoreCase(producto.getUnidad()) || "PZ".equalsIgnoreCase(producto.getUnidad())){
                    if(producto.getTipo() == 'E' || producto.getTipo() == 'G'){
                        catalogoProductos.add(producto);
                    } else{
                        throw new DatoInvalidoException("Error: el tipo ingresado no es válido.");
                    }
                    
                } else{
                    throw new DatoInvalidoException("Error: la unidad ingresado no es válido.");
                }
                
            } else{
                throw new DatoInvalidoException("Error: el nombre ingresado no es válido.");
            }
            
        } else{
        throw new ElementoDuplicadoException("Error: el producto ya esta en la lista.");
        }
        
    }
    
    public Producto buscarProductoPorClave(String cve){
        for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getClave().equalsIgnoreCase(cve)){
            return catalogoProductos.get(i);
            }
        }
        return null;
    }
    
    public void eliminarProducto(String cve){
        boolean eliminado = false;
         for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getClave().equalsIgnoreCase(cve)){
                catalogoProductos.remove(catalogoProductos.get(i));
                eliminado = true;
            }
        }
        if(eliminado == false){
            throw new ElementoNoEncontradoException("Error: el producto no existe");
        }
    }
    
    public void actualizarProducto(Producto producto, String nuevoNombre, String nuevaUnidad, char NuevoTipo){
        if(catalogoProductos.contains(producto)){
            if(!"".equals(nuevoNombre) || nuevoNombre != null){
                if("KG".equalsIgnoreCase(nuevaUnidad) || "g".equalsIgnoreCase(nuevaUnidad) || "L".equalsIgnoreCase(nuevaUnidad) || "PZ".equalsIgnoreCase(nuevaUnidad)){
                    if(NuevoTipo == 'E' || NuevoTipo == 'G'){
                        producto.setNombre(nuevoNombre);
                        producto.setUnidad(nuevaUnidad);
                        producto.setTipo(NuevoTipo);
                        for (int i = 0; i < catalogoProductos.size(); i++) {
                            System.out.println(catalogoProductos.get(i));
                            if(catalogoProductos.get(i) == producto){
                                catalogoProductos.set(i, producto);
                            }
                        }
                    } else{
                        throw new DatoInvalidoException("Error: el tipo ingresado no es válido.");
                    }
                    
                } else{
                    throw new DatoInvalidoException("Error: la unidad ingresado no es válido.");
                }
               
            } else{
                throw new DatoInvalidoException("Error: el nombre ingresado no es válido.");
            }
            
        } else{
            throw new ElementoNoEncontradoException("Error: el producto no existe");
        }
    }
    

    
    public void catalogoProductos(){
        for (int i = 0; i < catalogoProductos.size(); i++) {
            System.out.println(catalogoProductos.get(i).toString());
        }
    }
    
    public void catalogoProductos(char tipo){
        for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getTipo() == tipo){
                System.out.println(catalogoProductos.get(i).toString());
            }
        }
    }
    
    public void catalogoProductos(String unidad){
        for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getUnidad().equalsIgnoreCase(unidad)){
                System.out.println(catalogoProductos.get(i).toString());
            }
        }
    }
    
    public void catalogoProductos(String unidad, char tipo){
        for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getTipo() == tipo && catalogoProductos.get(i).getUnidad().equalsIgnoreCase(unidad)){
                System.out.println(catalogoProductos.get(i).toString());
            }
        }
    }
}
