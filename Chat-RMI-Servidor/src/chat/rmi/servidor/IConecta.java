/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.servidor;

import chat.rmi.cliente.Cliente;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author sergiocampos
 */
public interface IConecta extends Remote{
    public void conecta(Cliente c) throws RemoteException;
    
}
