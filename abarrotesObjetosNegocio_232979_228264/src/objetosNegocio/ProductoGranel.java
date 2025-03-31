/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

/**
 *
 * @author le0jx
 */
public class ProductoGranel extends Producto{
    private float cantidad;
    
    /**
     * Constructor por omision
     */
    public ProductoGranel() {
    }
    
    /**
     *  Constructor que recibe como parámetro otro objeto, creandolo con los parametros de el objeto indicado y la cantidad indicada.
     * @param cantidad
     * @param producto 
     */
    public ProductoGranel(float cantidad, Producto producto) {
        super(producto);
        this.cantidad = cantidad;
    }

    /**
     *  Constructor que establece los atributos a los del objeto recibido, inicializando la cantidad por defecto en 0.0f.
     * @param producto 
     */
    public ProductoGranel(Producto producto) {
        super(producto);
        this.cantidad = 0.0f;
    }
    
    
    
}
