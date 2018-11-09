/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawSherezade extends JFrame{
    
    public DrawSherezade(){
        super("Sherezade en el crepúsculo");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        //dibujo en el cielo: es el fonto ... Fradiente que va desde el azul a negro
        GradientPaint gp1 = new GradientPaint(10.0f, 125.0f, Color.blue, 250.0f, 125.0f, Color.black);
        Rectangle2D r = new Rectangle2D.Double(0.0, 0.0, 250.0, 250.0);
        g2.setPaint(gp1);
        g2.fill(r);
        
        //dibujo de la luna sobre el fondo
        GradientPaint gp2 = new GradientPaint(50.0f, 50.0f, Color.yellow, 300.0f, 50.0f, Color.DARK_GRAY);
        g2.setPaint(gp2);
        Ellipse2D e1 = new Ellipse2D.Double(70.0, 100.0, 80.0, 80.0);
        Ellipse2D e2 = new Ellipse2D.Double(100.0, 100.0, 80.0, 80.0);
        
        Area a1 = new Area(e1);
        Area a2 = new Area(e2);
        
        a1.subtract(a2);
        g2.fill(a1);
    }
    
    public static void main(String[] args) {
        DrawSherezade application = new DrawSherezade();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
