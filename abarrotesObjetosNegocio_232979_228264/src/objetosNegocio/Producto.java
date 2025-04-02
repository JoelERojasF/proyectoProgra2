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
    static int contador;

    //Cada clave se establece de forma XX000 donde XX es el tipo de producot y 000 un numero
    
    /**
     * Constructor que crea un objeto con todos los atributos inicializados pero sin conteido, solo recive clave
     * @param clave 
     */
    public Producto(String clave) {
        //Validación si la clave ya está creada
        this.clave = clave;
        this.nombre = "";
        this.unidad = "";
        this.tipo = 'X';
    }
    
    /**
     * Constructor por omision, al llamarlo igualmente le asigna un valor de clave al ser creado.
     */
    public Producto(){
        this.clave = "XX" + String.format("%03d",contador++);
        this.tipo = 'X';
    }
    
    /**
     *  Constructor con todos los atributos de clase
     * @param nombre Nombre de producto
     * @param unidad unidad de medida del producto
     * @param tipo Char de el tipo de producto puedase ser "G" o "E"
     */
    public Producto(String nombre, String unidad, char tipo) {
        this.clave = "XX" + String.format("%03d",contador++);
        this.nombre = nombre;
        this.unidad = unidad;
        this.tipo = tipo;
    }
    
    /**
     * Constructor copia que crea un nuevo objeto producto con los mismos parametros que el atributo que recibe
     * @param producto 
     */
    public Producto(Producto producto) {
        this.clave = "XX" + String.format("%03d",contador++);
        this.nombre = producto.nombre;
        this.unidad = producto.unidad;
        this.tipo = producto.tipo;
    }

    public String getClave() {
        return clave;
    }

    //Añadir validación de clave existente y de formato de clave.
    public void setClave(String clave) {
        if(clave.length() != 5){
            throw new IllegalArgumentException("Error: la clave ingresada no es válida.");
        }
        
        //Valida si la clave sigue el formato
        if(Character.isLetter(clave.charAt(0)) && Character.isLetter(clave.charAt(1)) && Character.isDigit(clave.charAt(2)) && Character.isDigit(clave.charAt(3)) && Character.isDigit(clave.charAt(4)) ){
           
            //validamos si la clave no cambió, refiriendose a la parte numérica, solo puede modificarse los primeros 2 digitos de la clave.
            if(clave.substring(2) != this.clave.substring(2)){
                throw new IllegalArgumentException("Error: no puedes cambiar el valor numérico de una clave.");
            }
            
            this.clave = clave;
        }
        
        
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
