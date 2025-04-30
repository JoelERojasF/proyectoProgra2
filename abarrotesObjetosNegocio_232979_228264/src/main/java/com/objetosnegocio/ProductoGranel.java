/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetosnegocio;

/**
 *
 * @author Joel Rojas y Ruben Gaxiola
 */
public class ProductoGranel extends Producto{
    private float cantidad;
    
    /**
     * Constructor por omision
     */
    public ProductoGranel() {
        this.tipo = 'G';
        this.clave = "GR" + clave.substring(2);
    }
    
    /**
     *  Constructor que recibe como parámetro otro objeto, creandolo con los parametros de el objeto indicado y la cantidad indicada.
     * @param cantidad
     * @param producto 
     */
    public ProductoGranel(float cantidad, Producto producto) {
        super(producto);
        this.cantidad = cantidad;
        this.tipo = 'G';
        this.clave = "GR" + clave.substring(2);
    }

    /**
     *  Constructor que establece los atributos a los del objeto recibido, inicializando la cantidad por defecto en 0.0f.
     * @param producto 
     */
    public ProductoGranel(Producto producto) {
        super(producto);
        this.cantidad = 0.0f;
        this.tipo = 'G';
        this.clave = "GR" + clave.substring(2);
    }

    /**
     * get de la cantidad de producto
     * @return cantidad de producto
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * set de la cantidad de producto
     * @param cantidad 
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * metodo para obtener el toString con el formato deseado
     * @return el toString con el formato deseado
     */
    @Override
    public String toString() {
        return clave + "," + nombre + "," + unidad + "," + tipo + "," + cantidad;
    }
    
    
}
