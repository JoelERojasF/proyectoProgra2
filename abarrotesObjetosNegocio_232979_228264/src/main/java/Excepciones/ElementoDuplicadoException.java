/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author le0jx
 */
public class ElementoDuplicadoException  extends RuntimeException{
    
    public ElementoDuplicadoException(){
        super("Error: el elemento ya esta registrada.");
    }
    
    public ElementoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
