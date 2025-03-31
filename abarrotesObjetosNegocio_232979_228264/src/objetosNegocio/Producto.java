/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import java.util.Objects;

/**
 *
 * @author le0jx
 */
public class Producto {
    protected String clave, nombre, unidad;
    protected char tipo;

    /**
     * Constructor por omisión
     */
    public Producto() {
    }

    /**
     *  Constructor con todos los atributos de clase
     * @param clave Clave de producto tipo string
     * @param nombre Nombre de producto
     * @param unidad Cantidad de unidades del producto
     * @param tipo Char de el tipo de producto puedase ser "G" o "E"
     */
    public Producto(String clave, String nombre, String unidad, char tipo) {
        this.clave = clave;
        this.nombre = nombre;
        this.unidad = unidad;
        this.tipo = tipo;
    }
    
    /**
     * Constructor copia que crea un nuevo objeto producto con los mismos parametros que el atributo que recibe
     * @param producto 
     */
    public Producto(Producto producto) {
        this.clave = producto.clave;
        this.nombre = producto.nombre;
        this.unidad = producto.unidad;
        this.tipo = producto.tipo;
    }

    public String getClave() {
        return clave;
    }

    //Añadir validación 
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    //Añadir validación 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    //Añadir validación 
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    public char getTipo() {
        return tipo;
    }
    
    //Añadir validación 
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.clave);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.unidad);
        hash = 89 * hash + this.tipo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.clave, other.clave);
    }
    
    
    
}
