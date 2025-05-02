/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetosnegocio;

import Excepciones.DatoInvalidoException;
import com.objetosservicio.Fecha;
import java.util.Objects;

/**
 *
 * @author Joel Rojas y Rubén Valdez
 */
public class Movimiento {
    String cveMovimiento;
    Fecha fecha;
    Boolean procesado;
    
    
    private static  int contador = 1;

    /**
     * constructor vacio, al llamarlo igualmente le asigna un valor de clave al ser creado.
     */
    public Movimiento() {
        this.cveMovimiento = String.format("mv%03d", contador);
        contador++;
    }

    /**
     * constructor con parametros
     * @param fecha fecha del movimiento
     * @param procesado estado del movimiento
     */
    public Movimiento(Fecha fecha, Boolean procesado) {
        Fecha fechaActual = new Fecha();
        if(fechaActual.after(fecha)){
        this.cveMovimiento = String.format("mv%03d", contador);
        this.fecha = fecha;
        this.procesado = procesado;
        contador++;
        }else{
            throw new DatoInvalidoException("Error: fecha futura, imposible de registrar.");
        }       
    }

    /**
     * constructor a partir de la clave del movimiento, inicializando el resto de parametros a null
     * @param cveMovimiento clave del movimiento
     */
    public Movimiento(String cveMovimiento) {
        if(cveMovimiento.length() ==2 && Character.isLetter(cveMovimiento.charAt(0)) && Character.isLetter(cveMovimiento.charAt(1))){
            cveMovimiento = String.format(cveMovimiento + "%03d", contador);
            contador++;
        }else{
            throw new DatoInvalidoException("Error: la clave ingresada no es válida.");
        }
 
        if(validarCve(cveMovimiento)){
        this.cveMovimiento = cveMovimiento;
        this.fecha = null;
        this.procesado = false;
        }else{
            throw new DatoInvalidoException("Error: la clave ingresada no es válida.");
        }  
        
    }

    /**
     * get de la clave de movimienot
     * @return un String con la clave de movimiento
     */
    public String getCveMovimient() {
        return cveMovimiento;
    }

    /**
     * set de la clave de movimiento
     * @param cveMovimiento nueva clave del movimiento
     */
    public void setCveMovimient(String cveMovimiento) {
        if(validarCve(cveMovimiento)){
            if(cveMovimiento.substring(2) != this.cveMovimiento.substring(2)){
                throw new DatoInvalidoException("Error: la clave ingresada no es válida.");
            }
            this.cveMovimiento = cveMovimiento;
        }else{
            throw new DatoInvalidoException("Error: no puedes cambiar el valor numérico de una clave.");
        } 
    }

    /**
     * get de la fecha del movimiento
     * @return un objeto de tipo fecha con la fecha del movimento
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * set de la fecha del movimiento
     * @param fecha 
     */
    public void setFecha(Fecha fecha) {
    Fecha fechaActual = new Fecha();
        
        if(fechaActual.after(fecha)){
            this.fecha = fecha;
        }else{
            throw new DatoInvalidoException("Error: fecha futura, imposible de registrar.");
        }   
    }

    /**
     * get del estado del proceso del movimiento
     * @return un boolean que devuelve true en caso de que si este porcesado y un false de lo contrario
     */
    public Boolean getProcesado() {
        return procesado;
    }

    /**
     * set del estado del proceso del movimiento
     * @param procesado estado del proceso del movimiento
     */
    public void setProcesado(Boolean procesado) {
        this.procesado = procesado;
    }
    
    /**
     * metodo para validar que una clave cumpla con el formato
     * @param clave clave que se validara
     * @return regresa true si cumple con el formato o false en caso de lo contrario
     */
    public boolean validarCve(String clave){
        if(clave.length() != 5){
        return false;
        }
        if(Character.isLetter(clave.charAt(0)) && Character.isLetter(clave.charAt(1)) && Character.isDigit(clave.charAt(2)) && Character.isDigit(clave.charAt(3)) && Character.isDigit(clave.charAt(4)) ){
        return true;
        }
        return false;
    }
    
    /**
     * metodo que verifica si un objeto pertenece a la clase movimiento y si tienen la misma clave
     * @param obj objeto a verificar
     * @return true en caso de que sean de la clase movimiento y tengan la misma clave o false de lo contrario
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Movimiento){
            if(((Movimiento) obj).getCveMovimient().equalsIgnoreCase(this.getCveMovimient())){
                return true;
            }
        } 
        return false;
    }

    /**
     * metodo para obtener el hashcode
     * @return el hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cveMovimiento);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.procesado);
        return hash;
    }

    /**
     * metodo para obtener el toString con el formato deseado
     * @return el toString con el formato deseado
     */
    @Override
    public String toString() {
        return cveMovimiento + "," + fecha + "," + procesado;
    }
    

}

