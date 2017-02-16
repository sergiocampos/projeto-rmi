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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
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
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
        Scanner enviar_mensagem = new Scanner (System.in);
        String opcao;
        String mensagem;
        String nome;
        
        try {
            IServidor server = (IServidor) Naming.lookup("rmi://localhost/Servidor");
            Cliente cli = new Cliente("");
            
            //menu
            
            do{
                System.out.println("Qual seu nome? ");
                nome = enviar_mensagem.nextLine();
                cli.setNome(nome);
                if (server.conecta(cli)){
                    break;
                }
            }while(true);
            
            System.out.println("--------------------------------");
            System.out.println("OPÇÕES: \n [0 - Sair da conversa] [1 - Enviar Mensagem ao grupo] "
                    + "[2 - Enviar Mensagem reservada] [3 - Visualizar participantes] [4 - Renomear"
                    + "Usuário]");
            System.out.println("--------------------------------");
            
        
            do{
                System.out.println("Opção: ");
                opcao = enviar_mensagem.nextLine();
                switch (opcao) {
                    case "0":
                        {
                            server.bye(cli);

                            break;
                        }
                    case "1":
                        {
                            System.out.println("Mensagem: ");
                            mensagem = enviar_mensagem.nextLine();
                            server.sendAll(cli, mensagem + " " + sdf.format(new Date()));

                            break;
                        }
                        case "2":
                        {
                            System.out.println("Para quem deseja enviar? ");
                            nome = enviar_mensagem.nextLine();
                            System.out.println("Mensagem: ");
                            mensagem = enviar_mensagem.nextLine();
                            server.sendUser(cli, nome, mensagem  + " " + sdf.format(new Date()));

                            break;
                        }
                        case "3":
                        {
                            server.list(cli);

                            break;
                        }
                        case "4":
                        {
                            System.out.println("Renomear para: ");
                            nome = enviar_mensagem.nextLine();
                            server.rename(cli, nome);

                            break;
                        }
                    default:
                        System.out.println("Opção inválida..");
        //                System.exit(0);
                }

            }while(true);
            
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(ChatRMICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
