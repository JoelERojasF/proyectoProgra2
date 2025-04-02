/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import objetosServicio.Fecha;

/**
 *
 * @author Joel Rojas y Ruben Gaxiola
 */
public class MovimientoGranel extends Movimiento{
    
    private ProductoGranel productoGranel;

    public MovimientoGranel() {
    }

    public MovimientoGranel(ProductoGranel productoGranel) {
        if(productoGranel != null){
        this.productoGranel = productoGranel;
        }else{
            System.out.println("error producto nulo");
        }
    }
    
    public MovimientoGranel(String cve) {
        Movimiento m = new Movimiento(cve);
        this.productoGranel = null;
    }

    public ProductoGranel getProductoGranel() {
        return productoGranel;
    }

    public void setProductoGranel(ProductoGranel productoGranel) {
        this.productoGranel = productoGranel;
    }
    
    @Override
    public String toString() {
        return this.getCveMovimient() + "," + this.getFecha() + "," + this.getProcesado()  + "," + productoGranel.getClave() +"," +productoGranel.getNombre() +"," + productoGranel.getUnidad() +"," + productoGranel.getTipo();
    }

    
}
