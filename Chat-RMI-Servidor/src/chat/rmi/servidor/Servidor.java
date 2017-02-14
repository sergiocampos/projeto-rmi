/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author sergiocampos
 */
public class Servidor extends UnicastRemoteObject implements IServidor{
    private HashMap<String,ICliente> lista_clientes = new HashMap<>();
    private int i=0;
    
    public Servidor() throws RemoteException{}

    @Override
    public void bye() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendAll() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendUser() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void list() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rename() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param c
     * @throws RemoteException
     */
    @Override
    public void conecta(ICliente c) throws RemoteException {
        lista_clientes.put( Integer.toString(i) , c);
        i++;
        System.out.println("conectou: "+ c.getNome());
    }



}
