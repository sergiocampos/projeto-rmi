/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.cliente;

import chat.rmi.servidor.ICliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jrpalitot
 */
public class Cliente extends UnicastRemoteObject implements ICliente{
    public String nome;
    
    public Cliente (String nome) throws RemoteException{
        this.nome = nome;
    }

    @Override
    public void msg(String m) throws RemoteException{
        System.out.println(m);
    }
    
    @Override
    public String getNome() throws RemoteException{
        return nome;
    }

    @Override
    public void setNome(String nome) throws RemoteException {
        this.nome = nome;
    }

    @Override
    public void bye() throws RemoteException {
        System.exit(0);
    }
    
}
