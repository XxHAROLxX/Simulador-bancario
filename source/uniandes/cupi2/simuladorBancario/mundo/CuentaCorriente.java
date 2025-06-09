/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.simuladorBancario.mundo;

import java.util.ArrayList;


/**
 * Clase que representa la cuenta corriente de un cliente.
 */
public class CuentaCorriente
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Saldo actual de la cuenta corriente.
     */
    private double saldo;
    
    
    private ArrayList<String> transaccionesMensuales = new ArrayList<>(); // objeto que alamcena las transacciones mensuales.



    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa la cuenta corriente. <br>
     * <b>post: </b> Se inicializó el saldo en 0.
     */
    public CuentaCorriente( )
    {
        saldo = 0;
    }

    /**
     * Retorna el saldo de la cuenta del cliente. <br>
     * @return Saldo de la cuenta corriente.
     */
    public double darSaldo( )
    {
        return saldo;
    }

    /**
     * Consigna un monto de dinero en la cuenta del cliente. <br>
     * <b>post: </b> El saldo se incrementó en el monto de dinero dado. <br>
     * @param pMonto Monto de dinero a consignar en la cuenta. pMonto > 0.
     */
    public void consignarMonto( double pMonto )
    {
        saldo = saldo + pMonto;
        transaccionesMensuales.add("Consignación: $" + String.format("%.2f", pMonto));
       
    }
    
    public String resumenTransacciones()
    {
        if (transaccionesMensuales.isEmpty()) {
            return "No se han realizado transacciones este mes.";
        }

        StringBuilder resumen = new StringBuilder();
        for (String transaccion : transaccionesMensuales) {
            resumen.append(transaccion).append("\n");
        }
        return resumen.toString();
    }


    /**
     * Retira un monto de dinero de la cuenta del cliente. <br>
     * <b>post: </b> El saldo se redujo en el monto de dinero dado.
     * @param pMonto Monto de dinero a retirar en la cuenta. pMonto > 0.
     */
    public void retirarMonto( double pMonto )
    {
        saldo = saldo - pMonto;
        transaccionesMensuales.add("Retiro: $" + String.format("%.2f", pMonto));
        
    }
    
    /**
     * Limpia la lista de transacciones del mes actual.
     */
    public void limpiarTransacciones()
    {
        transaccionesMensuales.clear(); // para eliminar todos elementos de la transacción actual antes de que pase al siguiente mes

    }


}