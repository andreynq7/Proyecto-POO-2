/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cazadeltesoro;

/**
 *
 * @author Andrey
 */
public enum Balas {
    HEAVY(3,20),
    LONG(8,10),
    MINE(1, 50);
    
    private final int MaxCeldas;
    private final int PorcentajeDaño;
    
    
    Balas(int Max, int Porcentaje){
        this.MaxCeldas = Max;
        this.PorcentajeDaño = Porcentaje;
    }

    public static Balas getHEAVY() {
        return HEAVY;
    }

    public static Balas getLONG() {
        return LONG;
    }

    public static Balas getMINE() {
        return MINE;
    }

    public int getMaxCeldas() {
        return MaxCeldas;
    }

    public int getPorcentajeDaño() {
        return PorcentajeDaño;
    }
    
    
    
    
    
}
