/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebas;

import com.objetosservicio.Fecha;
import com.objetosservicio.Periodo;
import java.util.Calendar;


/**
 *
 * @author joser
 */
public class Prueba01 {

    public static void main(String[] args) {
        Fecha hoy = new Fecha();
        Fecha ayer = new Fecha(15,8,2030);
        Fecha maniana =  new Fecha(hoy); 
        
        maniana.setAnio(hoy.getAnio() + 1);
        
        System.out.println("Hoy: " + hoy.toString());
        System.out.println("Ayer: " + ayer.toString());
        System.out.println("Manhanaa: " +maniana.toString());
        
        System.out.println("Mes de hoy: " + mesEnteroAString(hoy.getMes()));
        
        ayer.setFecha(12, 06, 2018);
        
        System.out.println(ayer.toString());
        System.out.println("Entre " + hoy.toString() + " y " + maniana.toString() + " hay " + maniana.lapso(hoy) + " dias");
        
        System.out.println("La fecha " + hoy.toString() +  "es diferente de " + hoy.toString() +"? " + hoy.equals(hoy));
        
        if(ayer.after(maniana)){
            System.out.println("La fecha de " + ayer.toString() + " es despues a " + maniana.toString());
        }else{
            if(ayer.equals(maniana)){
                System.out.println("La fecha de " + ayer.toString() + " es igual a " + maniana.toString());
            }else{
                System.out.println("La fecha de " + ayer.toString() + " no es despues ni igual a " + maniana.toString());
            }
        } 
        
        System.out.println("La fecha de " + hoy.toString() + " es antes" + maniana.toString() +  "? :" +
                hoy.before(maniana));
        
        Periodo periodo = new Periodo(new Fecha(05, 02, 2015), hoy);
        System.out.println(periodo.toString());
        
        System.out.println("La fecha de " + ayer.toString() + " se encuentra en el periodo "
                + periodo.toString() + "? : " + periodo.contiene(ayer) );
        
        
        
        
        
       
    }
    
    public static String mesEnteroAString(int mes){
        switch(mes){
            case 1:
                return "Enero";

            case 2:
                return "Febrero";
             
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
                
            case 5:
                return "Mayo";
                
            case 6:
                return "Junio";
                
            case 7:
                return "Julio";
            
            case 8:
                return "Agosto";
              
            case 9:
                return "Septiembre";
                
            case 10:
                return "Octubre";
                
            case 11:
                return "Novimebre";
                
                
            case 12:
                return "Diciembre";
             
            default:
                return "Int no valido";
                       
        }
    }
}
