/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author sergiocampos
 */
public interface IServidor extends Remote{
    public void conecta(ICliente c) throws RemoteException;
    public void bye(ICliente c) throws RemoteException;
    public void sendAll(ICliente c, String msg) throws RemoteException;
    public void sendUser(ICliente c, String nome, String msg) throws RemoteException;
    public void list(ICliente c) throws RemoteException;
    public void rename(ICliente c, String nome) throws RemoteException;
}
