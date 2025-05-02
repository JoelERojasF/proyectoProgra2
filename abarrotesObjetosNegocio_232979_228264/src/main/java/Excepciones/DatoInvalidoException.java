/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author le0jx
 */
public class DatoInvalidoException extends RuntimeException{
    public DatoInvalidoException(){
        super("Error: el dato es invalido");
    }
    
    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
