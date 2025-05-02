/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author le0jx
 */
public class ElementoNoEncontradoException  extends RuntimeException{
    public ElementoNoEncontradoException(){
        super("Error: el elemento no se encontro");
    }
    
    public ElementoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
