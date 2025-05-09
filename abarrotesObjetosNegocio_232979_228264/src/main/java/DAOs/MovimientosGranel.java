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
 * @author Joel Rojas y Rubén Valdez
 */
public class MovimientosGranel {
    public static ArrayList<MovimientoGranel> registroComprasGranel = new ArrayList<>();
    public static ArrayList<MovimientoGranel> registroVentasGranel = new ArrayList<>();
    public static ArrayList<MovimientoGranel> movimientosDelDia = new ArrayList<>();
    
    static Fecha hoy = new Fecha();
    static Fecha fechaMovimiento;
    
    /**
     * metodo para añadir un movimiento al registro de compras
     * @param movimiento movimiento a añadir
     */
    public static void comprarGranel(MovimientoGranel movimiento){
        if(!registroComprasGranel.contains(movimiento)){
            if(movimiento.getProcesado() == true){
                throw new DatoInvalidoException("Error: el estado del movimiento no es valido.");
            }
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
    
    /**
     * metodo para añadir un movimiento al registro de ventas
     * @param movimiento movimiento a añadir
     */
    public static void venderGranel(MovimientoGranel movimiento){
        if(!registroVentasGranel.contains(movimiento)){
            if(movimiento.getProcesado() == true){
                throw new DatoInvalidoException("Error: el estado del movimiento no es valido.");
            }
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
    
    /**
     * metodo para consultar el registro de compras
     * @return regresa todo el registro de compras
     */
    public static ArrayList<MovimientoGranel> consultarCompras(){
        if(registroComprasGranel.size() == 0){
            throw new DatoInvalidoException("Error: No hay ningun elemento en compras");
        }
        return registroComprasGranel;
        
    }
    
    /**
     * metodo para consultar el registro de compras dentro de un periodo de tiempo
     * @param periodo periodo de tiempo que en que se va a buscar
     * @return regresa una lista con las compras en el periodo de tiempo establecido
     */
    public static ArrayList<MovimientoGranel> consultarCompras(Periodo periodo){
        if(registroComprasGranel.size() == 0){
            throw new DatoInvalidoException("Error: No hay ningun elemento en compras");
        }
        ArrayList<MovimientoGranel> comprasDentroPeriodo = new ArrayList();
        for (int i = 0; i < registroComprasGranel.size(); i++) {
            if(periodo.contiene(registroComprasGranel.get(i).getFecha())){
                comprasDentroPeriodo.add(registroComprasGranel.get(i));
            }
        }
        return comprasDentroPeriodo;
    }
    
    /**
     * metodo para consultar el registro de ventas
     * @return regresa todo el registro de ventas
     */
    public static ArrayList<MovimientoGranel> consultarVentas(){
        if(registroVentasGranel.size() == 0){
            throw new DatoInvalidoException("Error: No hay ningun elemento en ventas");
        }
        return registroVentasGranel;
    }
    
    /**
     * metodo para consultar el registro de compras dentro de un periodo de tiempo
     * @param periodo periodo de tiempo que en que se va a buscar
     * @return regresa una lista con las compras en el periodo de tiempo establecido
     */
    public static ArrayList<MovimientoGranel> consultarVentas(Periodo periodo){
        if(registroVentasGranel.size() == 0){
            throw new DatoInvalidoException("Error: No hay ningun elemento en ventas");
        }
        ArrayList<MovimientoGranel> ventasDentroPeriodo = new ArrayList();
        for (int i = 0; i < registroVentasGranel.size(); i++) {
            if(periodo.contiene(registroVentasGranel.get(i).getFecha())){
                ventasDentroPeriodo.add(registroVentasGranel.get(i));
            }
        }
        return ventasDentroPeriodo;
    }
    
    /**
     * metodo para verificar que el producto no se haya movido en el mismo dia
     * @param movimiento movimiento a verificar
     * @return true en caso de que no se haya movido y false si ya se movio
     */
    private static boolean verificarMovimientoDia(MovimientoGranel movimiento){
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
    
    /**
     * Metodo de depuración, limplia todas la lista, NO USAR!
     */
    public static void clear(){
        registroComprasGranel.clear();
        registroVentasGranel.clear();
        movimientosDelDia.clear();
    }
    
}
