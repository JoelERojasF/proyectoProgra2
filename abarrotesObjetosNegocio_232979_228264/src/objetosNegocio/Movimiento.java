/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import java.util.Objects;
import objetosServicio.Fecha;

/**
 *
 * @author Joel Rojas y Ruben Gaxiola
 */
public class Movimiento {
    private String cveMovimiento;
    private Fecha fecha;
    private Boolean procesado;
    
    
    private static  int n = 1;

    public Movimiento() {
    }

    public Movimiento(Fecha fecha, Boolean procesado) {
        Fecha fechaActual = new Fecha();
        if(fechaActual.after(fecha)){
        this.cveMovimiento = String.format("mv%03d", n);
        this.fecha = fecha;
        this.procesado = procesado;
        n++;
        }else{
            throw new IndexOutOfBoundsException("Error: fecha futura, imposible de registrar.");
        }       
    }

    public Movimiento(String cveMovimient) {
        if(validarCve(cveMovimient)){
        this.cveMovimiento = cveMovimient;
        this.fecha = null;
        this.procesado = false;
        }else{
            throw new IllegalArgumentException("Error: la clave ingresada no es válida.");
        }  
        
    }

    public String getCveMovimient() {
        return cveMovimiento;
    }

    public void setCveMovimient(String cveMovimiento) {
        if(validarCve(cveMovimiento)){
            if(cveMovimiento.substring(2) != this.cveMovimiento.substring(2)){
                throw new IllegalArgumentException("Error: la clave ingresada no es válida.");
            }
            this.cveMovimiento = cveMovimiento;
        }else{
            throw new IllegalArgumentException("Error: no puedes cambiar el valor numérico de una clave.");
        } 
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
    Fecha fechaActual = new Fecha();
        
        if(fechaActual.after(fecha)){
            this.fecha = fecha;
        }else{
            throw new IndexOutOfBoundsException("Error: fecha futura, imposible de registrar.");
        }   
    }

    public Boolean getProcesado() {
        return procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }
    
    public boolean validarCve(String clave){
        if(clave.length() != 5){
        return false;
        }
        if(Character.isLetter(clave.charAt(0)) && Character.isLetter(clave.charAt(1)) && Character.isDigit(clave.charAt(2)) && Character.isDigit(clave.charAt(3)) && Character.isDigit(clave.charAt(4)) ){
        return true;
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Movimiento && ((Movimiento) obj).getCveMovimient() == this.getCveMovimient()) {
            return true;
        } 
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cveMovimiento);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.procesado);
        return hash;
    }

    @Override
    public String toString() {
        return cveMovimiento + "," + fecha + "," + procesado;
    }
    

}
