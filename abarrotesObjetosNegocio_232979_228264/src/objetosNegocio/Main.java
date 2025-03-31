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
        // TODO code application logic here
        Fecha f1 = new Fecha();
        Fecha f2 = new Fecha(1,4,2025);
        Fecha f3 = new Fecha(30,3,2025);
        String s1 = "12345";
        String s2 = "1234";
        String s3 = "abc45";
        String s4 = "ab345";
        
//        System.out.println(f2.after(f1));
//        

       
        Movimiento m1 = new Movimiento(s1);
        System.out.println(m1.toString());
        Movimiento m2 = new Movimiento(s2);
        System.out.println(m2.toString());
        Movimiento m3 = new Movimiento(s3);
        System.out.println(m3.toString());
        Movimiento m4 = new Movimiento(s4);
        System.out.println(m4.toString());
        
        System.out.println("Prueba");
        
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        
        Producto producto4 = new Producto("nombre", "unidad", 'C');
        Producto producto5 = new Producto("nombre", "unidad", 'C');
        
        Producto producto6 = new Producto(producto1);
        
        ProductoGranel productoGranel1 = new ProductoGranel();
        ProductoGranel productoGranel2 = new ProductoGranel();
        
        System.out.println(producto1.getClave());
        System.out.println(producto2.getClave());
        System.out.println(producto3.getClave());
        System.out.println(producto4.getClave());
        System.out.println(producto5.getClave());
        System.out.println(producto6.getClave());
        System.out.println(productoGranel1.getClave());
        System.out.println(productoGranel2.getClave());
        
        
        
        System.out.println("Prueba");
        
    }
    
}
