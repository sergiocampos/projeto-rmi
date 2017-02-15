/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.servidor;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergiocampos
 */
public class ChatRMIServidor {

    final static String host = "Servidor";
    
    public static void main(String[] args) throws AlreadyBoundException, MalformedURLException {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Servidor server = new Servidor();
            Naming.bind(host, server);
            
            //server.conecta(c);
            
        } catch (RemoteException ex) {
            Logger.getLogger(ChatRMIServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
