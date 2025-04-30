/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetosnegocio;

import java.util.Objects;

/**
 *
 * @author Joel Rojas y Ruben Gaxiola
 */
public class Producto {
    protected String clave, nombre, unidad;
    protected char tipo;
    static int contador =1;

    //Cada clave se establece de forma XX000 donde XX es el tipo de producot y 000 un numero
    
    /**
     * Constructor que crea un objeto con todos los atributos inicializados pero sin conteido, solo recive clave
     * @param clave 
     */
    public Producto(String clave) {
        
        this.clave = clave;
        this.nombre = "";
        this.unidad = "";
        this.tipo = 'X';
    }
    
    /**
     * Constructor por omision, al llamarlo igualmente le asigna un valor de clave al ser creado.
     */
    public Producto(){
        this.clave = String.format("XX%03d",contador++);
        this.tipo = 'X';
    }
    
    /**
     *  Constructor con todos los atributos de clase
     * @param nombre Nombre de producto
     * @param unidad unidad de medida del producto
     * @param tipo Char de el tipo de producto puedase ser "G" o "E"
     */
    public Producto(String nombre, String unidad, char tipo) {
        if(nombre != "" || nombre != null){
            if(unidad == "KG" || unidad == "g" || unidad == "L" || unidad == "PZ"){
                if(tipo == 'E' || tipo == 'G'){
                    this.clave = String.format("XX%03d",contador++);
                    this.nombre = nombre;
                    this.unidad = unidad;
                    this.tipo = tipo;
                }else{
                    throw new IllegalArgumentException("Error: el nombre ingresado no es válido.");
                }
                }else{
                    throw new IllegalArgumentException("Error: el tipo de unidad ingresado no es válido.");
            }
        }else{
            throw new IllegalArgumentException("Error: el nombre ingresado no es válido.");
        }
        
    }
    
    /**
     *  Constructor con todos los atributos de clase
     * @param clave los primeros dos digitos de la clave a añadir
     * @param nombre Nombre de producto
     * @param unidad unidad de medida del producto
     * @param tipo Char de el tipo de producto puedase ser "G" o "E"
     */
    public Producto(String clave, String nombre, String unidad, char tipo) {
        if(nombre != "" || nombre != null){
            if(unidad == "KG" || unidad == "g" || unidad == "L" || unidad == "PZ"){
                if(tipo == 'E' || tipo == 'G'){
                    clave = clave + String.format("%03d",contador++);
                    if(clave.length() != 5){
                        throw new IllegalArgumentException("Error: la clave ingresada no es válida.");
                    }
                    if(Character.isLetter(clave.charAt(0)) && Character.isLetter(clave.charAt(1)) && Character.isDigit(clave.charAt(2)) && Character.isDigit(clave.charAt(3)) && Character.isDigit(clave.charAt(4)) ){
                    this.clave = clave;
                    this.nombre = nombre;
                    this.unidad = unidad;
                    this.tipo = tipo;
                     }else{
                    throw new IllegalArgumentException("Error: la clave ingresada no es válida.");
                    }
                    
                }else{
                    throw new IllegalArgumentException("Error: el nombre ingresado no es válido.");
                }
                }else{
                    throw new IllegalArgumentException("Error: el tipo de unidad ingresado no es válido.");
            }
        }else{
            throw new IllegalArgumentException("Error: el nombre ingresado no es válido.");
        }
        
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

    /**
     * get de la clave del producto
     * @return la clave del producto
     */
    public String getClave() {
        return clave;
    }

    /**
     * set de la clave del producto
     * @param clave la clave del producto
     */
    //Añadir validación de clave existente
    public void setClave(String clave) {
        if(clave.length() != 5){
            throw new IllegalArgumentException("Error: la clave ingresada no es válida.");
        }
        
        //Valida si la clave sigue el formato
        if(Character.isLetter(clave.charAt(0)) && Character.isLetter(clave.charAt(1)) && Character.isDigit(clave.charAt(2)) && Character.isDigit(clave.charAt(3)) && Character.isDigit(clave.charAt(4)) ){
           
            //validamos si la clave no cambió, refiriendose a la parte numérica, solo puede modificarse los primeros 2 digitos de la clave.
            if(!clave.substring(2).equals(this.clave.substring(2))){
                throw new IllegalArgumentException("Error: no puedes cambiar el valor numérico de una clave.");
            }
            
            this.clave = clave;
        } 
    }

    /**
     * get del nombre del producto
     * @return el nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * set del nombre del producto
     * @param nombre el nombre del producto
     */
    public void setNombre(String nombre) {
        if(nombre != "" || nombre != null){
        this.nombre = nombre;
        }else{
            throw new IllegalArgumentException("Error: el nombre ingresado no es válido.");
        }
        
    }

    /**
     * get del tipo de unidad del producto
     * @return el tipo de unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * set del tipo de unidad del producto
     * @param unidad el tipo de unidad
     */
    public void setUnidad(String unidad) {
        if(unidad == "KG" || unidad == "g" || unidad == "L" || unidad == "PZ"){
        this.unidad = unidad;
        }else{
            throw new IllegalArgumentException("Error: el tipo de unidad ingresado no es válido.");
        }
        
    }
    
    /**
     * get del tipo del producto
     * @return el tipo del producto
     */
    public char getTipo() {
        return tipo;
    }
    
    /**
     * set del tipo del producto
     * @param tipo el tipo del producto
     */
    public void setTipo(char tipo) {
        if(tipo == 'E' || tipo == 'G'){
        this.tipo = tipo;
        }else{
            throw new IllegalArgumentException("Error: el tipo de producto ingresado no es válido.");
        }
        
    }

    /**
     * metodo para obtener el hashcode
     * @return el hashcode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.clave);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.unidad);
        hash = 89 * hash + this.tipo;
        return hash;
    }

    /**
     * metodo  que compara este producto con el objeto del parámetro
     * @param obj objeto a comparar
     * @return  regresa true si el objeto del parámetro es de la clase Producto y ambos tienen la misma clave, false en caso contrario
     */
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

    /**
     * metodo para obtener el toString con el formato deseado
     * @return el toString con el formato deseado
     */
    @Override
    public String toString() {
        return  clave + "," + nombre + "," + unidad + "," + tipo;
    }
    
    
}
