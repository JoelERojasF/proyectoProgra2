/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetosnegocio;

/**
 *
 * @author Joel Rojas y Ruben Gaxiola
 */
public class ProductoEmpacado extends Producto {
    private int cantidad;

    /**
     * Constructor por omision
     */
    public ProductoEmpacado(){
        this.tipo = 'E';
        this.clave = "EM" + clave.substring(2);
    }
    
    /**
     *  Constructor que recibe como parámetro otro objeto, creandolo con los parametros de el objeto indicado y la cantidad indicada.
     * @param cantidad
     * @param producto 
     */
    public ProductoEmpacado(int cantidad, Producto producto) {
        super(producto);
        this.cantidad = cantidad;
        this.tipo = 'E';
        this.clave = "EM" + clave.substring(2);
    }
    
    /**
     *  Constructor que establece los atributos a los del objeto recibido, inicializando la cantidad por defecto en 0.
     * @param producto 
     */
    public ProductoEmpacado(Producto producto) {
        super(producto);
        this.cantidad = 0;
        this.tipo = 'E';
        this.clave = "EM" + clave.substring(2);
    }

    /**
     * get de la cantidad de producto
     * @return cantidad de producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * set de la cantidad de producto
     * @param cantidad 
     */
    public void setCantidad(int cantidad) {
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
