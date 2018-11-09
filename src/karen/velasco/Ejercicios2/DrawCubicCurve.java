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
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawCubicCurve extends JFrame{
    public DrawCubicCurve(){
        super("Draw cubic curve");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(3.0f));
        
        CubicCurve2D c = new CubicCurve2D.Float(40.0f, 60.0f, 60.0f, 120.0f, 140.0f, 130.0f, 150.0f, 210.0f);
        g2.draw(c);
        
        g2.setColor(Color.red);
        g2.draw(new Rectangle2D.Float(40.0f, 60.0f, 1.0f, 1.0f));
        g2.draw(new Rectangle2D.Float(60.0f, 120.0f, 1.0f, 1.0f));
        g2.draw(new Rectangle2D.Float(140.0f, 130.0f, 1.0f, 1.0f));
        g2.draw(new Rectangle2D.Float(150.0f, 210.0f, 1.0f, 1.0f));
    }
    
    public static void main(String[] args) {
        DrawCubicCurve application = new DrawCubicCurve();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
