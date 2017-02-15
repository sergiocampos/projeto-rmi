/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.rmi.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sergiocampos
 */
public class Servidor extends UnicastRemoteObject implements IServidor{
    private HashMap<String,Usuario> lista_clientes = new HashMap<>();
    
    public Servidor() throws RemoteException{}

    @Override
    public void bye(ICliente c) throws RemoteException {
        this.sendAll(c, "Deixou a sala");
        //TO DO : Criar chamada no cliente para finalizar aplicação...
        lista_clientes.remove(c.getNome());
    }

    @Override
    public void sendAll(ICliente c, String msg) throws RemoteException {
        for(Map.Entry<String, Usuario> entry: lista_clientes.entrySet()){
            Usuario usr = entry.getValue();
            usr.getCliente().msg(c.getNome() + ": "+ msg);
        }
    }

    @Override
    public void sendUser(ICliente c, String nome, String msg) throws RemoteException {
        if (lista_clientes.get(nome) == null){
            lista_clientes.get(c.getNome()).getCliente().msg("Nenhum usuário com esse nome");
        }else{
            lista_clientes.get(nome).getCliente().msg(nome + ": "+ msg);
        }
    }

    @Override
    public void list(ICliente c) throws RemoteException {
        for(Map.Entry<String, Usuario> entry: lista_clientes.entrySet()){
            Usuario usr = entry.getValue();
            usr.getCliente().msg(lista_clientes.toString());
            // TO DO: Melhorar exibição
        }
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
        if (lista_clientes.get(c.getNome()) != null){
            c.msg("Já existe um usuário com este nome");
        }else{
            lista_clientes.put(c.getNome() , new Usuario(c));
            this.sendAll(c, "Está Online");
            lista_clientes.get(c.getNome()).getCliente().msg("Seja bem vindo, " + c.getNome());
        }
    }



}
