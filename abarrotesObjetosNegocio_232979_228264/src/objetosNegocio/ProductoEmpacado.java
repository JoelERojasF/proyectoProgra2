/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

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
    }
    
    /**
     *  Constructor que establece los atributos a los del objeto recibido, inicializando la cantidad por defecto en 0.
     * @param producto 
     */
    public ProductoEmpacado(Producto producto) {
        super(producto);
        this.cantidad = 0;
        this.tipo = 'E';
    }
    
}
