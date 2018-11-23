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
public class RectangleK {
    private int inicio;
    private int width;
    private int height;
    private int invalidos = 0;
    
    public RectangleK(int squareInicio, int width, int height){
        this.inicio = squareInicio;
        this.width = width;
        this.height = height;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getInvalidos() {
        return invalidos;
    }

    public void setInvalidos(int invalidos) {
        this.invalidos = invalidos;
    }

    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void insertInvalido(){
        this.invalidos+=1;
    }
}
