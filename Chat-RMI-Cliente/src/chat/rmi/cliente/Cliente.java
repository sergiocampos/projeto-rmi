/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.cliente;

/**
 *
 * @author jrpalitot
 */
public class Cliente implements ICliente{

    @Override
    public void msg(String m) {
        System.out.println(m);
    }
    
}