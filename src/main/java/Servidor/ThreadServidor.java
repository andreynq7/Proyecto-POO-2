/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Modelos.Mensaje;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class ThreadServidor extends Thread{
    public Socket socket;
    private Servidor server;
    private ObjectInputStream entrada;
    private DataInputStream entradaDatos;
    ObjectOutputStream salida;
    String nombre;
    private boolean isRunning = true;

    public ThreadServidor(Socket socket, Servidor server) {
        this.socket = socket;
        this.server = server;
        try {
            entrada = new ObjectInputStream(socket.getInputStream());
            salida = new ObjectOutputStream(socket.getOutputStream());
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            
        }
    }
    
    @Override
    public void run() {
        Mensaje mensaje;
        
        try {
            this.nombre = entradaDatos.readUTF();
            server.pantalla.write("Recibido el nombre: " + nombre);
        } catch (IOException ex) {
            
        }
        
        while(isRunning){                
            try {
                mensaje = (Mensaje) entrada.readObject();
                if (mensaje.getTipo().equals("PUBLICO")){
                    server.pantalla.write("Recibido:" + mensaje);
                    server.broadcast(mensaje);
                }else if (mensaje.getTipo().equals("PRIVADO")){
                    server.pantalla.write("Recibido:" + mensaje);
                    server.sendPrivateMessage(mensaje);
                }else if (mensaje.getTipo().equals("COORDENADA")){
                    server.pantalla.write("Recibido:" + mensaje);
                    server.sendPrivateMessage(mensaje);
                }  
                

               //TODO
               // si es privado enviarlo solo al thread servidor de esa persons
               // si es publico

            } catch (IOException ex) {
                //Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
                
       
        }
    }
}
