/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.cliente;

import chat.rmi.servidor.IServidor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jrpalitot
 */
public class ChatRMICliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String host_url = "rmi://192.168.10.120";

            Cliente c = new Cliente ("Jr");
            IServidor server;
            server = (IServidor) Naming.lookup(host_url);
            server.conecta(c);
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(ChatRMICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
