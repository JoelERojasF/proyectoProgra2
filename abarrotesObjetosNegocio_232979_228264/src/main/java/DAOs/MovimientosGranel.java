/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Excepciones.DatoInvalidoException;
import Excepciones.ElementoDuplicadoException;
import com.objetosnegocio.MovimientoGranel;
import com.objetosservicio.Fecha;
import com.objetosservicio.Periodo;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author le0jx
 */
public class MovimientosGranel {
    public static ArrayList<MovimientoGranel> registroComprasGranel = new ArrayList<>();
    public static ArrayList<MovimientoGranel> registroVentasGranel = new ArrayList<>();
    public static ArrayList<MovimientoGranel> movimientosDelDia = new ArrayList<>();
    
    Fecha hoy = new Fecha();
    Fecha fechaMovimiento;
    
    
    public void comprarGranel(MovimientoGranel movimiento){
        if(!registroComprasGranel.contains(movimiento)){
            if(verificarMovimientoDia(movimiento)){
                if((hoy.getMes() == movimiento.getFecha().getMes()) && hoy.getAnio() == movimiento.getFecha().getAnio() && !movimiento.getFecha().after(hoy) ){
                    registroComprasGranel.add(movimiento);
                    movimientosDelDia.add(movimiento);
                    fechaMovimiento = hoy;
                }
                else{
                    throw new DatoInvalidoException("Error: la fecha del movimiento no es valida.");
                }
            } else{
            throw new ElementoDuplicadoException("Error: el producto ya fue movido hoy.");
            }
            
        }
        else{
        throw new ElementoDuplicadoException("Error: el movimiento ya esta registrado.");
        }
    }
    
    public void venderGranel(MovimientoGranel movimiento){
        if(!registroVentasGranel.contains(movimiento)){
            if(verificarMovimientoDia(movimiento)){
                if((hoy.getMes() == movimiento.getFecha().getMes()) && hoy.getAnio() == movimiento.getFecha().getAnio() && !movimiento.getFecha().after(hoy) ){
                    registroVentasGranel.add(movimiento);
                    movimientosDelDia.add(movimiento);
                    fechaMovimiento = hoy;
                }
                else{
                    throw new DatoInvalidoException("Error: la fecha del movimiento no es valida.");
                }
            } else{
            throw new ElementoDuplicadoException("Error: el producto ya fue movido hoy.");
            }
            
        }
        else{
        throw new ElementoDuplicadoException("Error: el movimiento ya esta registrado.");
        }
        
    }
    
    public void consultarCompras(){
        for (int i = 0; i < registroComprasGranel.size(); i++) {
            System.out.println(registroComprasGranel.get(i).toString());
        }
        
    }
    
    public void consultarCompras(Periodo periodo){
        for (int i = 0; i < registroComprasGranel.size(); i++) {
            if(periodo.contiene(registroComprasGranel.get(i).getFecha())){
                System.out.println(registroComprasGranel.get(i).toString());
            }
        }
    }
    
    public void consultarVentas(){
        for (int i = 0; i < registroVentasGranel.size(); i++) {
            System.out.println(registroVentasGranel.get(i).toString());
        }
    }
    
    public void consultarVentas(Periodo periodo){
        for (int i = 0; i < registroVentasGranel.size(); i++) {
            if(periodo.contiene(registroVentasGranel.get(i).getFecha())){
                System.out.println(registroVentasGranel.get(i).toString());
            }
        }
    }
    
    private boolean verificarMovimientoDia(MovimientoGranel movimiento){
        if(fechaMovimiento != hoy || fechaMovimiento == null){
            movimientosDelDia.clear();
            return true;
        }
        for (int i = 0; i < movimientosDelDia.size(); i++) {
            if(movimientosDelDia.get(i).getProductoGranel() == movimiento.getProductoGranel()){
            return false;
            }
        }
        return true;
    }
    

    
                
    
}
