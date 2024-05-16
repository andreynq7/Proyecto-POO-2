/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cazadeltesoro;

/**
 *
 * @author andre
 */
public class Barco {
    private int vida;
    private Balas[] BalasAlmacenadas = new Balas[4]; 
    int Oro = 10;
    private Casilla Actual;

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Balas[] getBalasAlmacenadas() {
        return BalasAlmacenadas;
    }

    public void setBalasAlmacenadas(Balas[] BalasAlmacenadas) {
        this.BalasAlmacenadas = BalasAlmacenadas;
    }

    public Casilla getActual() {
        return Actual;
    }

    public void setActual(Casilla Actual) {
        this.Actual = Actual;
    }
    
    
}
