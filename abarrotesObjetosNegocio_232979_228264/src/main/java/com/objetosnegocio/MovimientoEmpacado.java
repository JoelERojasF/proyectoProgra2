/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetosnegocio;

import Excepciones.ElementoNoEncontradoException;
import com.objetosservicio.Fecha;
/**
 *
 * @author Joel Rojas y Rubén Valdez
 */
public class MovimientoEmpacado extends Movimiento{
    
    private ProductoEmpacado productoEmpacado;

    /**
     * constructor por defecto
     */
    public MovimientoEmpacado() {
    }

    /**
     * constructor en base a parametros
     * @param fecha fecha del movimiento
     * @param procesado estado de prosesado del movimiento
     * @param productoEmpacado producto del movimiento
     */
    public MovimientoEmpacado(Fecha fecha, Boolean procesado, ProductoEmpacado productoEmpacado) {
        super(fecha,procesado);
        if(productoEmpacado != null){
            this.productoEmpacado = productoEmpacado;
        }else{
            throw new ElementoNoEncontradoException("error producto no existe");
        }
    }

    /**
     * constructor solo con la clave del movimiento
     * @param cve clave del movimiento
     */
    public MovimientoEmpacado(String cve) {
        super(cve);
        this.productoEmpacado = null;
    }
    
    /**
     * get del producto del movimiento
     * @return el producto del movimiento
     */
    public ProductoEmpacado getProductoEmpacado() {
        return productoEmpacado;
    }

    /**
     * set del producto del movimiento
     * @param productoEmpacado el producto del movimiento
     */
    public void setProductoEmpacado(ProductoEmpacado productoEmpacado) {
        this.productoEmpacado = productoEmpacado;
    }

    /**
     * metodo para obtener el toString con el formato deseado
     * @return el toString con el formato deseado
     */
    @Override
    public String toString() {
        return cveMovimiento + "," + fecha + "," + procesado + "," + productoEmpacado.getClave() +"," +productoEmpacado.getNombre() +"," + productoEmpacado.getUnidad() +"," + productoEmpacado.getTipo();
    }

    
    
    
    
}
 