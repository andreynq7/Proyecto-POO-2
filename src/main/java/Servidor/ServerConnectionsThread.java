/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class ServerConnectionsThread extends Thread{
    private boolean isRunning = true;
    Servidor server;
    
    public ServerConnectionsThread(Servidor server) {
        this.server = server;
    }
    
    public void run(){
        while (isRunning) {  
            try {
                server.pantalla.write("Esperando nuevo cliente...");
                Socket nuevoSocket = server.serverSocket.accept();
                ThreadServidor ts = new ThreadServidor(nuevoSocket, server);
                ts.start();
                server.clientesConectados.add(ts);
                server.pantalla.write("Cliente " + server.clientesConectados.size() + " aceptado");
            } catch (IOException ex) {
                //Logger.getLogger(ServerConnectionsThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
}
