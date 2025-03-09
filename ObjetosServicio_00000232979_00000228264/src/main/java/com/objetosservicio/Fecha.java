/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.objetosservicio;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author le0jx
 */
public class Fecha extends GregorianCalendar{
    
    /**
     * constructor vacio de la clase fecha que la inicializa con la fecha del sistema y se encaraga que horas, minutos y milisegundos sean 0
     */
    public Fecha() {
        Calendar fecha = new GregorianCalendar();
        
        fecha.set(HOUR, 0);
        fecha.set(MINUTE, 0);
        fecha.set(SECOND, 0);
        fecha.set(MILLISECOND, 0);
    }
    
    /**
     * constructor con dia, mes y año de la clase fecha y se encaraga que horas, minutos y milisegundos sean 0
     * @param dia dia en que quieres que se inicialize
     * @param mes mes en que quieres que se inicialize
     * @param anio año en que quieres que se inicialize
     */
    public Fecha(int dia, int mes, int anio) {
        super(anio, (mes-1), dia);
        this.set(HOUR, 0);
        this.set(MINUTE, 0);
        this.set(SECOND, 0);
        this.set(MILLISECOND, 0);
    }
    
    /**
     * constructor con otra fecha para copiarla
     * @param fecha fecha con la que se inicializara
     */
    public Fecha(Fecha fecha) {
        this.set(DAY_OF_MONTH, fecha.getDia());
        this.set(MONTH, fecha.getMes()-1);
        this.set(YEAR, fecha.getAnio());
        this.set(HOUR, 0);
        this.set(MINUTE, 0);
        this.set(SECOND, 0);
        this.set(MILLISECOND, 0);
        
    }
    
    /**
     * constructor a base de un string en los formatos “dd/mm/aaaa”,“d/mm/aaaa” ,“dd/m/aaaa”o “d/m/aaaa”
     * @param fecha fecha en formatos “dd/mm/aaaa”,“d/mm/aaaa” ,“dd/m/aaaa”o “d/m/aaaa”
     */
    public Fecha(String fecha) {
        String[] partes = fecha.split("/");
        
        this.set(DAY_OF_MONTH, Integer.parseInt(partes[0]));
        this.set(MONTH, Integer.parseInt(partes[1])-1);
        this.set(YEAR, Integer.parseInt(partes[2]));
        this.set(HOUR, 0);
        this.set(MINUTE, 0);
        this.set(SECOND, 0);
        this.set(MILLISECOND, 0);
    }
    
    /**
     * metodo para obtener el dia de una fecha
     * @return int con el dia de la fecha
     */
    public int getDia(){
    return this.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * metodo para obtener el mes de una fecha
     * @return int con el mes de una fecha +1
     */
    public int getMes(){
    return this.get(Calendar.MONTH)+1;
    }
    
    /**
     * metodo para obtener el año de una fecha
     * @return int con el año de la fecha
     */
    public int getAnio(){
    return this.get(Calendar.YEAR);
    }
    
    /**
     * metodo para establecer un dia a auna fecha
     * @param dia dia a establecer
     */
    public void setDia(int dia){
    this.set(Calendar.DAY_OF_MONTH, dia);
    }
    
    /**
     * metodo para establecer un mes a una fecha
     * @param mes mes a establecer
     */
    public void setMes(int mes){
    this.set(Calendar.MONTH, (mes-1));
    }
    
    /**
     * metodo para establecer un año a una fecha
     * @param anio año a establecer
     */
    public void setAnio(int anio){
    this.set(Calendar.YEAR, anio);
    }
    
    /**
     * metodo para establecer todos los valores de una fecha
     * @param dia dia a establecer
     * @param mes mes a establecer
     * @param anio año a establecer
     */
    public void setFecha(int dia, int mes, int anio){
    this.set(Calendar.DAY_OF_MONTH, dia);
    this.set(Calendar.MONTH, (mes-1));
    this.set(Calendar.YEAR, anio);
    }
    
    /**
     * metodo para calcular una nueva fecha a partir de la actual, sumandole los datos establecidos
     * @param numDias numero de dias a desplazar
     * @param numMeses nuemro de meses a desplazar
     * @param numAnios numero de años a desplazar
     * @return la fecha con los dias, meses y años desplazados
     */
    public Fecha vencimiento(int numDias, int numMeses, int numAnios){ 
        Fecha fechaVencimiento = new Fecha(this);
        fechaVencimiento.setDia(this.getDia() + numDias);
        fechaVencimiento.setMes(this.getMes()+ numMeses);
        fechaVencimiento.setAnio(this.getAnio()+ numAnios);
    return fechaVencimiento;
    }
    
    /**
     * metodo para calcular una nueva fecha a partir de la actual, sumandole los datos establecidos 
     * @param numDias numero de dias a desplazar
     * @param numMeses nuemro de meses a desplazar
     * @return la fecha con los dias y meses desplazados
     */
    public Fecha vencimiento(int numDias, int numMeses){
        Fecha fechaVencimiento = new Fecha(this);
        fechaVencimiento.setDia(this.getDia() + numDias);
        fechaVencimiento.setMes(this.getMes()+ numMeses);
    return fechaVencimiento;    
    }
    
    /**
     * metodo para calcular una nueva fecha a partir de la actual, sumandole los datos establecidos 
     * @param numDias numero de dias a desplazar
     * @return la fecha con los dias desplazados
     */
    public Fecha vencimiento(int numDias){
        Fecha fechaVencimiento = new Fecha(this);
        fechaVencimiento.setDia(this.getDia() + numDias);
    return fechaVencimiento;
    }
    
    /**
     * metodo para calcular la cantidad de dias transcurridos desde una fecha dada hasta la fecha desde la que se convoca
     * @param desde fecha desde que comienza el periodo a contar
     * @return int con el numero de dias transcurridos
     */
    public int lapso(Fecha desde){
        long diasTranscurridos = this.getTimeInMillis() - desde.getTimeInMillis();
        diasTranscurridos = diasTranscurridos / 86400000;  
    return (int) diasTranscurridos;
    }

    /**
     * metodo toString para obtener todos los valores de una fecha en formato dd/mm/aaaa
     * @return un string con todos los valores de una fecha
     */
    @Override
    public String toString() {
         return String.format("%02d/%02d/%04d", this.getDia(), this.getMes(), this.getAnio());
    }
    
    
}
