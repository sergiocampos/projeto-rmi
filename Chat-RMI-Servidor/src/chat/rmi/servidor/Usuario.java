/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.servidor;

/**
 *
 * @author jrpalitot
 */
public class Usuario {
    private ICliente cliente;

    public Usuario(ICliente c) {
        this.cliente = c;
    }

    public ICliente getCliente() {
        return cliente;
    }
}
