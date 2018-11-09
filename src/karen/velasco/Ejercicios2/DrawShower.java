/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios2;

import java.awt.BasicStroke;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawShower extends JFrame{
    
    public DrawShower(){
        super("Draw a shower");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        Rectangle2D r = new Rectangle2D.Float(50.0f, 50.0f, 110.0f, 200.0f);
        RoundRectangle2D rr = new RoundRectangle2D.Float(60.0f, 60.0f, 90.0f, 180.0f, 25.0f, 25.0f);
        Ellipse2D e = new Ellipse2D.Float(100.0f, 80.0f, 10.0f, 10.0f);
        
        g2.draw(r);
        g2.draw(rr);
        g2.draw(e);
    }
    
    public static void main(String[] args) {
        DrawShower application = new DrawShower();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
