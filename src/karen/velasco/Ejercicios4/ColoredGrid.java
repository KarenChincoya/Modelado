/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

import java.awt.BasicStroke;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Karen Velasco
 */
public class ColoredGrid extends JFrame{
    private Square[] square;

    private int multiplos = 0;
    
    private int limiteX = 0;
    
    public ColoredGrid(){
        super("Draw squares");
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(1200,950);
        
        JButton btn = new JButton("Dibujar");
        DataReader pnl = new DataReader();
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1. Poner los cuadritos
                Square[] s = new Square[limiteX*limiteX];
                int m = Integer.valueOf(pnl.getTxtMultiplos().getText());
                int l = Integer.valueOf(pnl.getTxtGridSize().getText());
                
                ColoredGrid.this.setS(s);
                ColoredGrid.this.setMultiplos(m);
                ColoredGrid.this.setLimiteX(l);
                
                ColoredGrid.this.setSquare(s);
                ColoredGrid.this.setMultiplos(m);
                ColoredGrid.this.setLimiteX(l);
                
                ColoredGrid.this.revalidate();
                ColoredGrid.this.repaint();
            }
        });

        super.add(pnl);
        super.add(btn);
        super.setVisible(true);
    }

    public void setSquareID(int id, int j, int i){
        this.square[id] = new Square(j, i, id);
    }
    
    public Square[] getSquare() {
        return square;
    }

    public void setSquare(Square[] square) {
        this.square = square;
    }

    public int getMultiplos() {
        return multiplos;
    }

    public void setMultiplos(int multiplos) {
        this.multiplos = multiplos;
    }

    public int getLimiteX() {
        return limiteX;
    }

    public void setLimiteX(int limiteX) {
        this.limiteX = limiteX;
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
        if(n>=0 && n<(limiteX*limiteX)){
            System.out.println(n + " existe");
            return true;
        }
        return false;
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;         
        g2.setStroke(new BasicStroke(1.0f));
        
        if(limiteX!=0){
            
           square = new Square[limiteX*limiteX];
           int id=0;
        for(int i=0; i<limiteX; i++){//filasX
            for(int j=0; j<limiteX; j++){
                square[id] = new Square(j,i,id);
                id++;
            }
        }
        
        //2. Pintar los cuadritos 
        for(int i=0; i<(Math.pow(limiteX, 2)); i++){
            float x1 = square[i].getCoordX() + 20;
            float y1 = square[i].getCoordY() + 20;
            Rectangle2D r = new Rectangle2D.Float(x1, y1, 15.0f, 15.0f);
            g2.draw(r);
            if(i%multiplos == 0){
                g2.fill(r);
            }
        }
        }
            
        System.out.println("Fin dibujar");
    }
    
    public Square[] getS() {
        return square;
    }

    public void setS(Square[] s) {
        this.square = s;
    }
    
    public static void main(String[] args) {
        new ColoredGrid();
    }
    
}
