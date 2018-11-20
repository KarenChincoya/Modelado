/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawSquares extends JFrame{
    
    private int habilitar = 53;
    private Square[] square;
    private int lastId = habilitar;
    private int contador = 1;

    private int limiteX;
    private int limiteY;
    
    public Square[] getSquare() {
        return square;
    }

    public void setSquare(Square[] square) {
        this.square = square;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }
    
    public DrawSquares(){
        super("Draw squares");
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(1200,950);
        
        limiteX = 40;
        limiteY = 30;
        
        int diferenciaFilas = limiteX;
        //1. generar los cuadritos  80 y 120
        square = new Square[limiteX*limiteY];
        int id = 0;
        for(int i=0; i<limiteY; i++){//filas
            for(int j=0; j<limiteX; j++){
                square[id] = new Square(j,i,id);
                id++;
            }
        }
        /*Cuando le das set enable*/
        int subindice = DrawSquares.this.getHabilitar();
        square[subindice].setEnabled(true);
        square[subindice].setContador(1);
        
        PnlBotones botones = new PnlBotones();
        
        botones.setListener(new ExpandListener() {
            @Override
            public void onBtnClick(int movement) {
                //agregar contador, comprobar la existencia
                int sumando = 0;
                switch(movement){
                    case 1://arriba
                        System.out.println("--------------------------------arriba");
                        sumando = -diferenciaFilas;
                        break;
                    case 2://izquierda
                        System.out.println("---------------------- izquierda");
                        sumando = -1;
                        break;
                    case 3://derecha
                        System.out.println("------------------------------derecha");
                        sumando = 1;
                        break;
                    case 4://
                        System.out.println("---------------------------- sur");
                        sumando = diferenciaFilas;
                        break;
                    default:
                        System.out.println("Error.");
                }
                int aux = DrawSquares.this.getLastId()+sumando;
                if(DrawSquares.this.exists(aux) && DrawSquares.this.getPermission(aux, movement)==true){
                    //Incrementa e contador
                    DrawSquares.this.setContador(DrawSquares.this.getContador()+1);
                    
                    DrawSquares.this.setLastId(DrawSquares.this.getLastId()+sumando); 
                    DrawSquares.this.setEnabled(DrawSquares.this.getLastId());
                    
                    DrawSquares.this.revalidate();
                    DrawSquares.this.repaint();
                }
            }
        });
        
        super.add(botones);
        super.setVisible(true);
    }
    
    public boolean getPermission(int n, int movement){
        System.out.println("--------------- coord x = "+square[n].getxReal());        
        //Tienes el id del cuadrito
        /*2. East - der */
        if(movement==3 && square[n].getxReal() == 0){
            return false;
        }
        /*4. West - izq */
        if(movement==2 && square[n].getxReal() == (limiteX-1)){
            return false;
        }
        return true;
    }
    
    public boolean exists(int n){
        if(n>=0 && n<(limiteX*limiteY)){
            System.out.println(n + " existe");
            return true;
        }
        return false;
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;         
        g2.setStroke(new BasicStroke(1.0f));
        
        g.setFont(new Font("Serif", Font.BOLD, 12));
        
        //2. Pintar los cuadritos 
        for(int i=0; i<(limiteX*limiteY); i++){
            if(square[i].isEnabled()==true){
                //Si esta habilitado, dibujar
                float x1 = square[i].getCoordX() + 20;
                float y1 = square[i].getCoordY() + 20;
                Rectangle2D r = new Rectangle2D.Float(x1, y1, 15.0f, 15.0f);
                g2.draw(r);
                //Dibujar el numero
                String c = ""+square[i].getContador()+"";
                g.drawString(c, (int) x1 +1 , (int) y1 + 12);
                
                System.out.println("Habilitado = "+square[i].getId());
            }
        }    
        System.out.println("Fin dibujar");
    }

    public int getHabilitar() {
        return habilitar;
    }

    public void setHabilitar(int habilitar) {
        this.habilitar = habilitar;
    }

    public Square[] getS() {
        return square;
    }

    public void setS(Square[] s) {
        this.square = s;
    }
    
    public void setEnabled(int numero){
        int subindice = numero;
        square[subindice].setEnabled(true);
        square[subindice].setContador(contador);
    }
    public static void main(String[] args) {
        new DrawSquares();
    }
    
}
