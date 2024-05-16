/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Cliente {
    private final String IP = "localhost";
    private final int PORT = 8084;
    private Socket socket;
    ObjectOutputStream salida;
    private DataOutputStream salidaDatos;
    Pantalla pantalla;
    String nombre ;
     
     ThreadCliente threadCliente;
     
     
  
    public Cliente(Pantalla pantalla) {
        this.pantalla = pantalla;
        conectar();
    }
    
       public void conectar(){
        try {
            socket =  new Socket(IP, PORT);
            salida =  new ObjectOutputStream(socket.getOutputStream());
            salidaDatos =  new DataOutputStream(socket.getOutputStream());
            threadCliente = new ThreadCliente(socket, this);
            threadCliente.start();
            
            //pedir el nombre
            this.nombre = JOptionPane.showInputDialog("Nombre:");
            salidaDatos.writeUTF(this.nombre);
            
        } catch (IOException ex) {
            
        }
     }
}
