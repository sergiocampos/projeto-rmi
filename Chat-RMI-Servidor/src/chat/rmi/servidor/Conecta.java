/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.servidor;

import chat.rmi.cliente.Cliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author sergiocampos
 */
public class Conecta extends UnicastRemoteObject implements IConecta{
    private HashMap<String,Cliente> lista_clientes = new HashMap<>();
    private int i=0;
    public Conecta() throws RemoteException{}

    @Override
    public void conecta(Cliente c) throws RemoteException {
        lista_clientes.put( Integer.toString(i) , c);
        i++;
    }
    
    
}
