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
 * @author jrpalitot
 */
public interface ICliente extends Remote{
    public void msg(String m) throws RemoteException;
    public String getNome() throws RemoteException;
    public void setNome(String nome) throws RemoteException;
    public void bye() throws RemoteException;
}
