/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

/**
 *
 * @author Joel Rojas y Ruben Gaxiola
 */
public class MovimientoEmpacado extends Movimiento{
    
    private ProductoEmpacado productoEmpacado;

    public MovimientoEmpacado() {
    }

    public MovimientoEmpacado(ProductoEmpacado productoEmpacado) {
        if(productoEmpacado != null){
        this.productoEmpacado = productoEmpacado;
        }else{
            System.out.println("error producto nulo");
        }
    }

    public MovimientoEmpacado(String cve) {
        Movimiento m = new Movimiento(cve);
        this.productoEmpacado = null;
    }
    
    public ProductoEmpacado getProductoEmpacado() {
        return productoEmpacado;
    }

    public void setProductoEmpacado(ProductoEmpacado productoEmpacado) {
        this.productoEmpacado = productoEmpacado;
    }

    @Override
    public String toString() {
        return this.getCveMovimient() + "," + this.getFecha() + "," + this.getProcesado()  + "," + productoEmpacado.getClave() +"," +productoEmpacado.getNombre() +"," + productoEmpacado.getUnidad() +"," + productoEmpacado.getTipo();
    }

    
    
    
    
}
 