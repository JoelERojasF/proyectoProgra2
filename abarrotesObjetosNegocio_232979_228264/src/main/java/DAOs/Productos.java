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
    
    /**
     * metodo para agregar un producto al catalogo de productos
     * @param producto producto a gregar
     */
    public static void agregarProducto(Producto producto){
        if(!catalogoProductos.contains(producto)){
            for (int i = 0; i < catalogoProductos.size(); i++) {
                if(catalogoProductos.get(i).getClave().equalsIgnoreCase(producto.getClave())){
                    throw new ElementoDuplicadoException("Error: la clave del producto ya esta registrada.");
                }
            }
            if("".equals(producto.getNombre()) || producto.getNombre() == null){
                throw new DatoInvalidoException("Error: el nombre ingresado no es válido.");
            }
            
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
        throw new ElementoDuplicadoException("Error: el producto ya esta registrado");
        }
        
    }
    
    /**
     * metodo para buscar un producto del catalogo mediante el cve
     * @param cve cve del producto a buscar
     * @return el producto encontrado o null si no lo encuentra
     */
    public static Producto buscarProductoPorClave(String cve){
        for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getClave().equalsIgnoreCase(cve)){
            return catalogoProductos.get(i);
            }
        }
        return null;
    }
    
    /**
     * metodo para eliminar una producto
     * @param cve cve del producto a eliminar
     */
    public static void eliminarProducto(String cve){
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
    
    /**
     * metodo para actualizar un producto
     * @param producto producto a actualizar
     * @param nuevoNombre nuevo nombre
     * @param nuevaUnidad nueva unidad
     * @param NuevoTipo nuevo tipo
     */
    public static void actualizarProducto(Producto producto, String nuevoNombre, String nuevaUnidad, char NuevoTipo){
        if(catalogoProductos.contains(producto)){
            if("".equals(nuevoNombre) || nuevoNombre == null){
                throw new DatoInvalidoException("Error: el nombre ingresado no es válido.");
            }
                
                if("KG".equalsIgnoreCase(nuevaUnidad) || "g".equalsIgnoreCase(nuevaUnidad) || "L".equalsIgnoreCase(nuevaUnidad) || "PZ".equalsIgnoreCase(nuevaUnidad)){
                    if(NuevoTipo == 'E' || NuevoTipo == 'G'){
                        producto.setNombre(nuevoNombre);
                        producto.setUnidad(nuevaUnidad);
                        producto.setTipo(NuevoTipo);
                        for (int i = 0; i < catalogoProductos.size(); i++) {
                            if(catalogoProductos.get(i).getClave().equals(producto.getClave())){
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
            throw new ElementoNoEncontradoException("Error: el producto no existe");
        }
    }
    
    /**
     * metodo para obtener el catalogo completo de productos
     * @return el catalogo completo de productos
     */
    public static ArrayList<Producto> catalogoProductos(){
        if(catalogoProductos.isEmpty()){
            throw new DatoInvalidoException("Error: el catálogo no contiene ningun producto.");
        }
        return catalogoProductos;
    }
    
    /**
     * metodo para obtener el catalogo de productos que cumpla con el tipo solicitado
     * @param tipo tipo que buscara
     * @return catalogo que cumpla con el tipo
     */
    //Producto por tipo del mismo char
    public static ArrayList<Producto> catalogoProductos(char tipo){
        ArrayList<Producto> resultado = new ArrayList();
        if(catalogoProductos.isEmpty()){
            throw new DatoInvalidoException("Error: el catálogo no contiene ningun producto.");
        }
        for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getTipo() == tipo){
                resultado.add(catalogoProductos.get(i));
            }
        }
        if(resultado.isEmpty()){
            throw new DatoInvalidoException("Error: el catálogo no contiene ningun producto de este tipo.");
        }
        return resultado;
    }
    
    /**
     * metodo para obtener el catalogo de productos que cumpla con la unidad solicitado
     * @param unidad unidad que buscara
     * @return catalogo que cumpla con la unidad
     */
    //Por mismo tipo de unidad
    public static ArrayList<Producto> catalogoProductos(String unidad){
        
        ArrayList<Producto> resultado = new ArrayList();
        if(catalogoProductos.isEmpty()){
            throw new DatoInvalidoException("Error: el catálogo no contiene ningun producto.");
        }
        for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getUnidad().equalsIgnoreCase(unidad)){
                resultado.add(catalogoProductos.get(i));
            }
        }
        if(resultado.isEmpty()){
            throw new DatoInvalidoException("Error: el catálogo no contiene ningun producto de este tipo.");
        }
        return resultado;
        
        
    }
    
    /**
     * metodo para obtener el catalogo de productos que cumpla con el tipo y la unidad solicitados
     * @param unidad unidad que buscara
     * @param tipo tipo que buscara
     * @return catalogo que cumpla con la unidad y tipo
     */
    //Productos del mismo char y unidad
    public static ArrayList<Producto> catalogoProductos(String unidad, char tipo){
        
        ArrayList<Producto> resultado = new ArrayList();
        if(catalogoProductos.isEmpty()){
            throw new DatoInvalidoException("Error: el catálogo no contiene ningun producto.");
        }
        for (int i = 0; i < catalogoProductos.size(); i++) {
            if(catalogoProductos.get(i).getTipo() == tipo && catalogoProductos.get(i).getUnidad().equalsIgnoreCase(unidad)){
                resultado.add(catalogoProductos.get(i));
            }
        }
        if(resultado.isEmpty()){
            throw new DatoInvalidoException("Error: el catálogo no contiene ningun producto de este tipo.");
        }
        return resultado;
        
    }
    
    /**
     * Metodo de depuración, limplia toda la lista, NO USAR!
     */
    public static void clear(){
        catalogoProductos.clear();
    }
}
