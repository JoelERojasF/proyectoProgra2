/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import java.util.Objects;
import objetosServicio.Fecha;

/**
 *
 * @author le0jx
 */
public class Movimiento {
    private String cveMovimient;
    private Fecha fecha;
    private Boolean procesado;
    
    
    private static  int n = 1;

    public Movimiento() {
    }

    public Movimiento(Fecha fecha, Boolean procesado) {
        Fecha fechaActual = new Fecha();
        if(fechaActual.after(fecha)){
        this.cveMovimient = String.format("mv%03d", n);
        this.fecha = fecha;
        this.procesado = procesado;
        n++;
        }else{
            System.out.println("error: fecha futura, imposible de registrar");
        }       
    }

    public Movimiento(String cveMovimient) {
        if(validarCve(cveMovimient)){
        this.cveMovimient = cveMovimient;
        this.fecha = null;
        this.procesado = false;
        }else{
            System.out.println("la clave no cumple con el formato");
        }  
        
    }

    public String getCveMovimient() {
        return cveMovimient;
    }

    public void setCveMovimient(String cveMovimient) {
        if(validarCve(cveMovimient)){
            this.cveMovimient = cveMovimient;
        }else{
            System.out.println("la clave no cumple con el formato");
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
            throw new IndexOutOfBoundsException("error: fecha futura, imposible de registrar");
        }   
    }

    public Boolean getProcesado() {
        return procesado;
    }

    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }
    
    public boolean validarCve(String cve){
        if(cve.length() != 5){
        return false;
        }
        if(Character.isLetter(cve.charAt(0)) && Character.isLetter(cve.charAt(1)) && Character.isDigit(cve.charAt(2)) && Character.isDigit(cve.charAt(3)) && Character.isDigit(cve.charAt(4)) ){
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
        hash = 37 * hash + Objects.hashCode(this.cveMovimient);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.procesado);
        return hash;
    }

    @Override
    public String toString() {
        return cveMovimient + "," + fecha + "," + procesado;
    }
    

}
