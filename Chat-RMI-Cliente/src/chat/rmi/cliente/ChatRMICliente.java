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
        SimpleDateFormat sdf;
        Scanner enviar_mensagem = new Scanner (System.in);
        String opcao;
        String mensagem;
        String nome;
        //DataOutputStream dataOutputStream;
        Calendar data_atual;
        
        try {
            Cliente cli = new Cliente("Jr");
            IServidor server = (IServidor) Naming.lookup("rmi://localhost/Servidor");
            server.conecta(cli);
            server.sendUser(cli, "Jr", "Mensagem para um usuário");
            server.sendAll(cli, "Mensagem para todos usuários");
            server.list(cli);
            
            //menu
            
            System.out.println("Qual seu nome? ");
            nome = enviar_mensagem.nextLine();
            //globals.lista.add(globals.nome);
            System.out.println("--------------------------------");
            System.out.println("Você deseja: \n 0 - Sair da conversa \n 1 - Enviar Mensagem ao grupo "
                    + "\n 2 - Enviar Mensagem reservada \n 3 - Visualizar participantes \n 4 - Renomear"
                    + "Usuário");
            //System.out.println("Você deseja: \n 3 - Entrar numa sala existente \n 4 - Criar uma sala ");
            opcao = enviar_mensagem.nextLine();
            System.out.println("--------------------------------");
            
            //DataOutputStream dataOutputStream;
        
        
        switch (opcao) {
            case "0":
                {
                    //System.out.println("Qual IP da sala que deseja conectar?");
                    //mensagem = enviar_mensagem.nextLine();
                    //Socket socket = new Socket(InetAddress.getByName(mensagem), 6500);
                    //ThreadLe tLe = new ThreadLe(socket.getInputStream());
                    //tLe.start();
                    //dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    //dataOutputStream.writeUTF(globals.nome + " entrou na conversa");
                    server.bye(cli);
                    
//                   do{
//                        DataOutputStream dataOutputStream; 
//                        data_atual = Calendar.getInstance();
//                        mensagem = enviar_mensagem.nextLine();
//                        sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
//                        if (mensagem.startsWith("send -user ")){
//                            dataOutputStream.writeUTF("//~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }else if (mensagem.startsWith("bye")){
//                            dataOutputStream.writeUTF(globals.nome+" saiu da conversa.");
//                            socket.close();
//                            System.exit(0);
//                        }else if (mensagem.startsWith("list")){
//                            System.out.println(globals.lista.toString());
//                        }else if (mensagem.startsWith("rename")){
//                            dataOutputStream.writeUTF(globals.nome+" alterado para " + mensagem.split(" ")[1]);
//                            globals.lista.remove(globals.nome);
//                            globals.nome = mensagem.split(" ")[1];
//                            globals.lista.add(globals.nome);
//                        }else{
//                            dataOutputStream.writeUTF("/~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }
//                    } while(true);
                    
//                    break;
                }
            case "1":
                {
                    System.out.println("Mensagem: ");
                    mensagem = enviar_mensagem.nextLine();
                    
                    server.sendAll(cli, mensagem);
////                    System.out.println("Sala criada! \n----------------------- \n");
////                    ServerSocket serverSocket = new ServerSocket(6500);
////                    Socket socket = serverSocket.accept();
////                    ThreadLe tLe = new ThreadLe(socket.getInputStream());
////                    tLe.start();
////                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
////                    dataOutputStream.writeUTF(globals.nome + " entrou na conversa");
//                    
//                    do{
//                        data_atual = Calendar.getInstance();
//                        mensagem = enviar_mensagem.nextLine();
//                        sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
//                        if (mensagem.startsWith("send -user ")){
//                            dataOutputStream.writeUTF("//~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }else if (mensagem.startsWith("bye")){
//                            dataOutputStream.writeUTF(globals.nome+" saiu da conversa.");
//                            socket.close();
//                            System.exit(0);
//                        }else if (mensagem.startsWith("list")){
//                            System.out.println(globals.lista.toString());
//                        }else if (mensagem.startsWith("rename")){
//                            dataOutputStream.writeUTF(globals.nome+" alterado para " + mensagem.split(" ")[1]);
//                            globals.lista.remove(globals.nome);
//                            globals.nome = mensagem.split(" ")[1];
//                            globals.lista.add(globals.nome);
//                        }else{
//                            dataOutputStream.writeUTF("/~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }
//                    } while(true);
                    
//                    break;
                }
                case "2":
                {
                    System.out.println("Mensagem: ");
                    mensagem = enviar_mensagem.nextLine();
                    server.sendUser(cli, nome, nome);
                    
//                    System.out.println("Sala criada! \n----------------------- \n");
//                    ServerSocket serverSocket = new ServerSocket(6500);
//                    Socket socket = serverSocket.accept();
//                    ThreadLe tLe = new ThreadLe(socket.getInputStream());
//                    tLe.start();
//                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
//                    dataOutputStream.writeUTF(globals.nome + " entrou na conversa");
//                    
//                    do{
//                        data_atual = Calendar.getInstance();
//                        mensagem = enviar_mensagem.nextLine();
//                        sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
//                        if (mensagem.startsWith("send -user ")){
//                            dataOutputStream.writeUTF("//~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }else if (mensagem.startsWith("bye")){
//                            dataOutputStream.writeUTF(globals.nome+" saiu da conversa.");
//                            socket.close();
//                            System.exit(0);
//                        }else if (mensagem.startsWith("list")){
//                            System.out.println(globals.lista.toString());
//                        }else if (mensagem.startsWith("rename")){
//                            dataOutputStream.writeUTF(globals.nome+" alterado para " + mensagem.split(" ")[1]);
//                            globals.lista.remove(globals.nome);
//                            globals.nome = mensagem.split(" ")[1];
//                            globals.lista.add(globals.nome);
//                        }else{
//                            dataOutputStream.writeUTF("/~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }
//                    } while(true);
                    
//                    break;
                }
                case "3":
                {
                    server.list(cli);
                    
//                    System.out.println("Sala criada! \n----------------------- \n");
//                    ServerSocket serverSocket = new ServerSocket(6500);
//                    Socket socket = serverSocket.accept();
//                    ThreadLe tLe = new ThreadLe(socket.getInputStream());
//                    tLe.start();
//                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
//                    dataOutputStream.writeUTF(globals.nome + " entrou na conversa");
//                    
//                    do{
//                        data_atual = Calendar.getInstance();
//                        mensagem = enviar_mensagem.nextLine();
//                        sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
//                        if (mensagem.startsWith("send -user ")){
//                            dataOutputStream.writeUTF("//~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }else if (mensagem.startsWith("bye")){
//                            dataOutputStream.writeUTF(globals.nome+" saiu da conversa.");
//                            socket.close();
//                            System.exit(0);
//                        }else if (mensagem.startsWith("list")){
//                            System.out.println(globals.lista.toString());
//                        }else if (mensagem.startsWith("rename")){
//                            dataOutputStream.writeUTF(globals.nome+" alterado para " + mensagem.split(" ")[1]);
//                            globals.lista.remove(globals.nome);
//                            globals.nome = mensagem.split(" ")[1];
//                            globals.lista.add(globals.nome);
//                        }else{
//                            dataOutputStream.writeUTF("/~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }
//                    } while(true);
                    
//                    break;
                }
                case "4":
                {
                    server.rename(cli, nome);
                    
//                    System.out.println("Sala criada! \n----------------------- \n");
//                    ServerSocket serverSocket = new ServerSocket(6500);
//                    Socket socket = serverSocket.accept();
//                    ThreadLe tLe = new ThreadLe(socket.getInputStream());
//                    tLe.start();
//                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
//                    dataOutputStream.writeUTF(globals.nome + " entrou na conversa");
//                    
//                    do{
//                        data_atual = Calendar.getInstance();
//                        mensagem = enviar_mensagem.nextLine();
//                        sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
//                        if (mensagem.startsWith("send -user ")){
//                            dataOutputStream.writeUTF("//~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }else if (mensagem.startsWith("bye")){
//                            dataOutputStream.writeUTF(globals.nome+" saiu da conversa.");
//                            socket.close();
//                            System.exit(0);
//                        }else if (mensagem.startsWith("list")){
//                            System.out.println(globals.lista.toString());
//                        }else if (mensagem.startsWith("rename")){
//                            dataOutputStream.writeUTF(globals.nome+" alterado para " + mensagem.split(" ")[1]);
//                            globals.lista.remove(globals.nome);
//                            globals.nome = mensagem.split(" ")[1];
//                            globals.lista.add(globals.nome);
//                        }else{
//                            dataOutputStream.writeUTF("/~"+globals.nome+": " + mensagem + " - "+sdf.format(data_atual.getTime()));
//                        }
//                    } while(true);
                    
//                    break;
                }
            default:
                System.out.println("Opção inválida..");
                System.exit(0);
        }
            
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(ChatRMICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
