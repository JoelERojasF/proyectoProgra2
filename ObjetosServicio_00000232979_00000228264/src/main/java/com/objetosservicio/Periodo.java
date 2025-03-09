/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetosservicio;

/**
 *
 * @author le0jx
 */
public class Periodo {
    private Fecha desde;
    private Fecha hasta;

    /**
     * metodo constructor de la clase periodo
     * @param desde la fecha con la que inicia el periodo
     * @param hasta la fecha con la que termina el periodo
     */
    public Periodo(Fecha desde, Fecha hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    /**
     * metodo para obtener la fecha con la empieza el periodo
     * @return regresa la fecha con la que empieza el periodo
     */
    public Fecha getDesde() {
        return desde;
    }

    /**
     * metodo para establecer la fecha con la que empieza el periodo
     * @param desde la fecha con la que empieza el periodo
     */
    public void setDesde(Fecha desde) {
        this.desde = desde;
    }

    /**
     * metodo para obtener la fecha con la que concluye el periodo
     * @return regresa la fecha con la que concluye el periodo
     */
    public Fecha getHasta() {
        return hasta;
    }

    /**
     * metodo para establecer la fecha con la que concluye el periodo
     * @param hasta la fecha con la que concluye el periodo
     */
    public void setHasta(Fecha hasta) {
        this.hasta = hasta;
    }

    /**
     * metodo para conocer si una fecha se encuentra dentro del periodo
     * @param fecha fecha que se desea conocer si se encuentra dentro del periodo
     * @return regresa true si la fecha se encuentra en el periodo y false en caso de que no
     */
    public boolean contiene(Fecha fecha){
        if(fecha.after(desde) && fecha.before(hasta)){
        return true;
        }
        
    return false;
    }
    
    /**
     * metodo toString para obtener el periodo en formato dd/mm/aaaa a dd/mm/aaaa
     * @return el periodo en formato dd/mm/aaaa a dd/mm/aaaa
     */
    @Override
    public String toString() {
        return (desde.toString() + " a " + hasta.toString());
    }
}
