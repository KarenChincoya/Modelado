/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawRectangle2D extends JFrame{
    
    public DrawRectangle2D(){
        super("Rectangle 2D");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        //creacion del rectangulo - equina sup izquierda, ancho y largo
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(3.0f));
        Rectangle2D r = new Rectangle2D.Float(100.0f, 75.0f, 50.0f, 100.0f);
//        Rectangle2D r = new Rectangle2D(100.0f, 75.0f, 50.0f, 100.0f);
        g2.draw(r);
    }
    
    public static void main(String[] args) {
        DrawRectangle2D application = new DrawRectangle2D();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
