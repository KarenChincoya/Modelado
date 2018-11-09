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
import java.awt.geom.Arc2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawCuadraticCurve extends JFrame{
    
    public DrawCuadraticCurve(){
        super("Draw bezier curves");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(3.0f));
        
        QuadCurve2D q = new QuadCurve2D.Float(40.0f, 700f, 40.0f, 170.0f, 190.0f, 220.0f);
        g2.draw(q);
        
        g2.setColor(Color.RED);
        g2.draw(new Rectangle2D.Float(40.0f, 70.0f, 1.0f, 1.0f));
        g2.draw(new Rectangle2D.Float(10.0f, 170.0f, 1.0f, 1.0f));
        g2.draw(new Rectangle2D.Float(190.0f, 220.0f, 1.0f, 1.0f));
    }
    
    public static void main(String[] args) {
        DrawCuadraticCurve application = new DrawCuadraticCurve();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
