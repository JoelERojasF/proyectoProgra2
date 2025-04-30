/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetosnegocio;

import com.objetosservicio.Fecha;

/**
 *
 * @author Joel Rojas y Rubén Valdez
 */
public class MovimientoGranel extends Movimiento{
    
    private ProductoGranel productoGranel;

   /**
     * constructor por defecto
     */
    public MovimientoGranel() {
    }

    /**
     * constructor en base a parametros
     * @param fecha fecha del movimiento
     * @param procesado estado de prosesado del movimiento
     * @param productoGranel producto del movimiento
     */
    public MovimientoGranel(Fecha fecha, Boolean procesado, ProductoGranel productoGranel) {
        super(fecha,procesado);
        if(productoGranel != null){
            this.productoGranel = productoGranel;
        }else{
            throw new NullPointerException("error producto no existe");
        }
    }
    
    /**
     * constructor solo con la clave del movimiento
     * @param cve clave del movimiento
     */
    public MovimientoGranel(String cve) {
        super(cve);
        this.productoGranel = null;
    }

    /**
     * get del producto del movimiento
     * @return el producto del movimiento
     */
    public ProductoGranel getProductoGranel() {
        return productoGranel;
    }

    /**
     * set del producto del movimiento
     * @param productoGranel el producto del movimiento
     */
    public void setProductoGranel(ProductoGranel productoGranel) {
        this.productoGranel = productoGranel;
    }
    
    /**
     * metodo para obtener el toString con el formato deseado
     * @return el toString con el formato deseado
     */
    @Override
    public String toString() {
        return this.getCveMovimient() + "," + this.getFecha() + "," + this.getProcesado()  + "," + productoGranel.getClave() +"," +productoGranel.getNombre() +"," + productoGranel.getUnidad() +"," + productoGranel.getTipo();
    }

    
}
