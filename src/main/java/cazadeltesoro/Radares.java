/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cazadeltesoro;

/**
 *
 * @author andre
 */
public enum Radares {
    SHORT(3),
    LONG(8),
    SPOTS(3);
    
    private final int radio;
    
    Radares(int radio){
        this.radio = radio;
    }
}
