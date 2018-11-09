/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.Ejercicios3;

import com.sun.prism.BasicStroke;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Karen Velasco
 */
public class DrawBasicStroke extends JFrame{
    
    public DrawBasicStroke(){
        
        super("Basic stroke");
        super.setLayout(new FlowLayout());
                
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D r2 = new Rectangle2D.Float(75, 125, 100, 25);
        
        Stroke pincel = new java.awt.BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
        g2.setStroke(pincel);
        g2.draw(r2);
    }
    
    public static void main(String[] args) {
        new DrawBasicStroke();
    }
}
