/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

/**
 *
 * @author Karen Velasco
 */
public class Square2 {

    private int id;
    private int xCoord;
    private int yCoord;
    private int xReal;
    private int yReal;
    private boolean enabled;
    private int contador;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public Square2(int i, int j, int id){
        this.xCoord = 20*i;
        this.yCoord = 100+20*j;
        this.id = id;
        this.enabled = false;
        this.xReal = i;
        this.yReal = j;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoordX() {
        return xCoord;
    }

    public void setCoordX(int x) {
        this.xCoord = x;
    }

    public int getCoordY() {
        return yCoord;
    }

    public void setCoordY(int y) {
        this.yCoord = y;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getxReal() {
        return xReal;
    }

    public void setxReal(int xReal) {
        this.xReal = xReal;
    }

    public int getyReal() {
        return yReal;
    }

    public void setyReal(int yReal) {
        this.yReal = yReal;
    }
    
    
    
}
