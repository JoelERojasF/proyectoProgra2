/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.pruebas_232979_228264;

import com.objetosnegocio.MovimientoEmpacado;
import com.objetosnegocio.MovimientoGranel;
import com.objetosnegocio.Producto;
import com.objetosnegocio.ProductoEmpacado;
import com.objetosnegocio.ProductoGranel;
import com.objetosservicio.Fecha;

/**
 *
 * @author le0jx
 */
public class Pruebas02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        Producto producto1 = new Producto("EM","Atun en Aceite","PZ",'E');
        Producto producto2 = new Producto("EM","Elotitos Amarillos","PZ",'E');
        Producto producto3 = new Producto("EM","Chiles Jalapenos","PZ",'E');
        Producto producto4 = new Producto("GR","Frijol azufrado","KG",'G');
        Producto producto5 = new Producto("GR","Arroz Grano Largo","KG",'G');
        Producto producto6 = new Producto("GR","Azucar Refinada","KG",'G');
        
        System.out.println(producto1.toString());
        System.out.println(producto2.toString());
        System.out.println(producto3.toString());
        System.out.println(producto4.toString());
        System.out.println(producto5.toString());
        System.out.println(producto6.toString());
        
        System.out.println(producto1.getNombre());
        
        System.out.println(producto5.toString());
        
        System.out.println("el producto 1 es igual del producto 1?");
        System.out.println(producto1.equals(producto1));
        
        System.out.println("el producto 4 es igual del producto 6?");
        System.out.println(producto4.equals(producto6));
        
        ProductoEmpacado productoEmpacado1 = new ProductoEmpacado(10,producto1);
        ProductoEmpacado productoEmpacado2 = new ProductoEmpacado(20,producto2);
        
        System.out.println(productoEmpacado1.toString());
        System.out.println(productoEmpacado2.toString());
        
        System.out.println(productoEmpacado2.getCantidad());
        
        System.out.println("el producto empacado 1 es igual del producto empacado 2?");
        System.out.println(productoEmpacado1.equals(productoEmpacado2));
        
        ProductoGranel proudctoGranel1 = new ProductoGranel(25.0f,producto4);
        ProductoGranel proudctoGranel2 = new ProductoGranel(12.5f,producto5);
        
        System.out.println(proudctoGranel1.toString());
        System.out.println(proudctoGranel2.toString());
        
        System.out.println(proudctoGranel1.getUnidad());
        
        System.out.println("el producto granel 1 es igual del producto granel 2?");
        System.out.println(proudctoGranel1.equals(proudctoGranel2));
        
        Fecha fechaHoy = new Fecha(2,4,2025);
        Fecha fechaAyer = new Fecha(1,4,2025);
        
        MovimientoEmpacado movimientoEmpacado1 = new MovimientoEmpacado(fechaHoy, false, productoEmpacado1);
        MovimientoEmpacado movimientoEmpacado2 = new MovimientoEmpacado(fechaAyer, false, productoEmpacado2);
        System.out.println(movimientoEmpacado1.toString());
        System.out.println(movimientoEmpacado2.toString());
        
        System.out.println(movimientoEmpacado1.getProductoEmpacado().getCantidad());
        
        System.out.println("");
        
        System.out.println("el movimiento empacado 1 es igual del movimiento empacado 2?");
        System.out.println(movimientoEmpacado1.equals(movimientoEmpacado2));
        
        MovimientoGranel movimientoGranel1 = new MovimientoGranel(fechaHoy, false, proudctoGranel1);
        MovimientoGranel movimientoGranel2 = new MovimientoGranel(fechaAyer, false, proudctoGranel2);
        
        System.out.println(movimientoGranel1.toString());
        System.out.println(movimientoGranel2.toString());
        
        System.out.println(movimientoGranel2.getFecha());
        
        
        System.out.println("el movimiento granel 1 es igual del movimiento granel 2?");
        System.out.println(movimientoGranel1.equals(movimientoGranel2));
        
    }
    
}
