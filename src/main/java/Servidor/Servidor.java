/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Modelos.Mensaje;
import cazadeltesoro.Casilla;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Servidor {
    private final int PORT = 8084;
    ServerSocket serverSocket;
    PantallaServidor pantalla;
    ArrayList<ThreadServidor> clientesConectados;
    ServerConnectionsThread conexionsThread;

    public Servidor(PantallaServidor pantalla) {
        this.pantalla = pantalla;
        this.connect();
        //news
        clientesConectados =  new ArrayList<ThreadServidor>();
        conexionsThread = new ServerConnectionsThread(this);
        conexionsThread.start();
    }
    
    private void connect(){
        
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //enviarMensajeATodos
    public void broadcast(Mensaje mensaje){
        for (ThreadServidor tsDelCliente : clientesConectados) {
            try {
                tsDelCliente.salida.writeObject(mensaje);
            } catch (IOException ex) {
                //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //enviarMensajePrivado
    public void sendPrivateMessage(Mensaje mensaje){
        for (ThreadServidor tsDelCliente : clientesConectados) {
            try {
                if (tsDelCliente.nombre.equals(mensaje.getReceptor())){
                     tsDelCliente.salida.writeObject(mensaje);
                }
            } catch (IOException ex) {
                //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //enviarCasilla
    public void SendCasilla(Casilla casilla){
        for(ThreadServidor tsDelCliente : clientesConectados){
            try{
                if(!casilla.isTieneAmenaza()){
                    tsDelCliente.salida.writeObject(PORT);
                }
            }catch(IOException ex){
                //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
}
