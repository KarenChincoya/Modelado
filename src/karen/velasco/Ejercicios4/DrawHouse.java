/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawHouse extends JFrame{
    
    public DrawHouse(){
        super("Drawing a house");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        setSize(900, 900);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.blue);
        Rectangle2D r1 = new Rectangle2D.Float(100.0f, 100.0f, 100.0f, 100.0f);
        g2.fill(r1);
        g2.setColor(Color.black);
        g2.draw(r1);

        //brown square
        Color cafe1 = new Color(239, 235, 191);
        g2.setColor(cafe1);
        Rectangle2D r2 = new Rectangle2D.Float(100.0f, 200.0f, 500.0f, 500.0f);
        g2.fill(r2);
        g2.setColor(Color.black);
        g2.draw(r2);
        
        //door
        Color cafe2 = new Color(119, 82, 39);
        g2.setColor(cafe2);
        Rectangle2D r4 = new Rectangle2D.Float(360.0f, 300.0f, 200.0f, 400.0f);
        g2.fill(r4);
        //handle
        Color amarillo1 = new Color(249, 242, 104);
        Rectangle2D r5 = new Rectangle2D.Float(410.0f, 400.0f, 30.0f, 30.0f);
        g2.fill(r5);
        
        //window
        g2.setColor(cafe2);
        Rectangle2D r6 = new Rectangle2D.Float(120.0f, 250.0f, 200.0f, 150.0f);
        g2.fill(r6);
        
        GradientPaint gp1 = new GradientPaint(10.0f, 500.0f, Color.green, 250.0f, 125.0f, Color.black);
        g2.setPaint(gp1);
        Rectangle2D r3 = new Rectangle2D.Float(50.0f, 680.0f, 620.0f, 30.0f);
        g2.fill(r3);
        
        //
        Color orange1 = new Color(255, 189, 10);
        g2.setColor(orange1);
        
        Rectangle2D r7 = new Rectangle2D.Float(160.0f, 560.0f, 80.0f, 40.0f);
        g2.fill(r7);
        
        Rectangle2D r8 = new Rectangle2D.Float(120.0f, 610.0f, 80.0f, 40.0f);
        g2.fill(r8);
        
        Rectangle2D r9 = new Rectangle2D.Float(210.0f, 610.0f, 80.0f, 40.0f);
        g2.fill(r9);
    }
    
    public static void main(String[] args) {
        new DrawHouse();   
    }
}
