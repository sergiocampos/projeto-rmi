/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.servidor;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergiocampos
 */
public class ChatRMIServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Servidor server = new Servidor();
            IServidor i = (IServidor)
            server.conecta(c);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatRMIServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
