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
import karen.velasco.Ejercicios1.DrawArcs;
import karen.velasco.Ejercicios2.DrawSherezade;

/**
 *
 * @author Karen Velasco
 */
public class DrawCar extends JFrame{
 
    public DrawCar(){
        super("Drawing a car");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        setSize(900, 900);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.red);
        g2.fillArc(200, 100, 400, 300, 0, 180);
       
        g2.setColor(Color.BLACK);
        g2.drawArc(200, 100, 400, 300, 0, 180);
        
        g2.setColor(Color.BLACK);
        Line2D l = new Line2D.Float(200.0f, 250.0f, 600.0f, 600.0f);
        //g2.draw(l);
       
        g2.setStroke(new BasicStroke(1.0f));
        RoundRectangle2D q = new RoundRectangle2D.Float(150.0f, 250.0f, 500.0f, 200.0f, 60.0f, 60.0f);
        g2.draw(q);
        g2.setColor(Color.red);
        g2.fill(q);
        
        
        Color azulCielo = new Color(203, 242, 233);
        g2.setColor(azulCielo);
        g2.fillArc(220, 120, 350, 260, 90, 90);
        g2.fillArc(230, 120, 350, 260, 0, 90);

        //picaporte
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3.0f));
        //Rectangle2D r = new Rectangle2D.Float(340.0f, 200.0f, 50.0f, 20.0f);
        RoundRectangle2D r = new RoundRectangle2D.Float(340.0f, 260.0f, 50.0f, 15.0f, 10.0f, 10.0f);
        g2.fill(r);
        
        //Frente
        Color orange1 = new Color(242, 228, 128);
        g2.setColor(orange1);
        RoundRectangle2D r1 = new RoundRectangle2D.Float(140.0f, 300.0f, 40.0f, 60.0f, 10.0f, 10.0f);
        g2.fill(r1);
        
        Color gray1 = new Color(168, 166, 159);
        //exhaust pipe
        g2.setColor(gray1);
        RoundRectangle2D r2 = new RoundRectangle2D.Float(630.0f, 300.0f, 30.0f, 50.0f, 10.0f, 10.0f);
        g2.fill(r2);
        
        g2.setColor(Color.black);
        Ellipse2D e3 = new Ellipse2D.Double(200.0, 370.0, 150.0, 150.0);
        g2.fill(e3);
        
        g2.setColor(gray1);
        Ellipse2D e5 = new Ellipse2D.Double(230.0, 400.0, 90.0, 90.0);
        g2.fill(e5);
        
        g2.setColor(Color.black);
        Ellipse2D e4 = new Ellipse2D.Double(450.0, 370.0, 150.0, 150.0);
        g2.fill(e4);
        
        g2.setColor(gray1);
        Ellipse2D e7 = new Ellipse2D.Double(480.0, 400.0, 90.0, 90.0);
        g2.fill(e7);
        
       
    }
    
    public static void main(String[] args) {
        new DrawCar();   
    }
}
