/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cazadeltesoro;

/**
 *
 * @author Andrey
 */
public class Casilla {
    private boolean tieneTesoro;
    private boolean tieneAmenaza;
    private boolean tieneMercado;
;
    

    public Casilla() {
        this.tieneTesoro = false;
        this.tieneAmenaza = false;
        this.tieneMercado = false;
    }

    public boolean isTieneTesoro() {
        return tieneTesoro;
    }

    public void setTieneTesoro(boolean tieneTesoro) {
        this.tieneTesoro = tieneTesoro;
        this.tieneAmenaza = false;
        this.tieneMercado = false;
    }

    public boolean isTieneAmenaza() {
        return tieneAmenaza;
    }

    public void setTieneAmenaza(boolean tieneAmenaza) {
        this.tieneAmenaza = tieneAmenaza;
        this.tieneTesoro = false;
        this.tieneMercado = false;
    }

    public boolean isTieneMercado() {
        return tieneMercado;
    }

    public void setTieneMercado(boolean tieneMercado) {
        this.tieneMercado = tieneMercado;
        this.tieneTesoro = false;
        this.tieneAmenaza = false;
    }
    
    
   
    
    
    
    
    
}
