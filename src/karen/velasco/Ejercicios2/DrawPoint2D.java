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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawPoint2D extends JFrame{
    
    public DrawPoint2D(){
        super("Draw points");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3.0f));
        
        Point2D p1 = new Point2D.Float(23.5f, 48.9f);
        Point2D p2 = new Point2D.Float(158.0f, 173.0f);
        
        Line2D l = new Line2D.Float(p1, p2);
        //Line2D l = new Line2D(p1, p2);
        g2.draw(l);
    }
    
    public static void main(String[] args) {
        DrawPoint2D application = new DrawPoint2D();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
