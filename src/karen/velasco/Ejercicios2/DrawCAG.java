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
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawCAG extends JFrame{
    
    public DrawCAG(){
        super("Constructive Area Geometry");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        GradientPaint gp = new GradientPaint(50.0f, 50.0f, Color.blue, 200.0f, 50.0f, Color.red);
        g2.setPaint(gp);
        
        Ellipse2D e1 = new Ellipse2D.Double(50.0, 50.0, 80.0, 80.0);
        Ellipse2D e2 = new Ellipse2D.Double(100.0f, 50.0f, 80.0f, 80.0f);
        //shapes -> areas
        Area a1 = new Area(e1);
        Area a2 = new Area(e2);
        
        //a1.add(a2)
        //a1.intersect(a2)
        //a1.subtract(a2)
        a1.exclusiveOr(a2);
        g2.fill(a1);
        
    }
    
    public static void main(String[] args) {
        DrawCAG application = new DrawCAG();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
