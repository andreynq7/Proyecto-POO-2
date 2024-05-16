/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;

/**
 *
 * @author diego
 */
public class Mensaje implements Serializable{
    private String enviador;
    private String mensaje;
    private String tipo;
    private String receptor;
    int y;
    int x;

    public Mensaje(String enviador, String mensaje, String receptor) {
        this.enviador = enviador;
        this.mensaje = mensaje;
        this.receptor = receptor;
        this.tipo = "PRIVADO";
    }
    
    public Mensaje(String enviador, String mensaje) {
        this.enviador = enviador;
        this.mensaje = mensaje;
        this.tipo = "PUBLICO";        
    }
    
    public Mensaje(String enviador, int x, int y, String receptor) {
        this.enviador = enviador;
        this.receptor = receptor;
        this.tipo = "COORDENADA";
        this.x = x; 
        this.y = y;
    }

    @Override
    public String toString() {
        return "Mensaje "+ tipo + " de " + enviador + ": \"" + mensaje;
    }

    public String getEnviador() {
        return enviador;
    }

    public void setEnviador(String enviador) {
        this.enviador = enviador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    
    
    
    
    
    
    
    
}
