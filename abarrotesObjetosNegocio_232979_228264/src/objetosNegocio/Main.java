/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package objetosNegocio;

import objetosServicio.Fecha;

/**
 *
 * @author le0jx
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto producto1 = new Producto();
        ProductoEmpacado prodEmp1 = new ProductoEmpacado();
        ProductoGranel prodGra1 = new ProductoGranel();
        
        System.out.println(producto1.toString());
        System.out.println(prodEmp1.toString());
        System.out.println(prodGra1.toString());
    }
    
}
