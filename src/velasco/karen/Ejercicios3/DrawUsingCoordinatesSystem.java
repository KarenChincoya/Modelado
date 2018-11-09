/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.Ejercicios3;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Karen Velasco
 */
public class DrawUsingCoordinatesSystem extends JFrame{
    
    public DrawUsingCoordinatesSystem(){
        super("Use of the coordinates system");
        super.setLayout(new FlowLayout());
                
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        
        Rectangle2D r1 = new Rectangle2D.Float(250.0f, 50.0f, 100.0f, 100.0f);
        g2.fill(r1);
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        g2.setColor(Color.green);
        g2.setComposite(ac);
        
        Rectangle2D r2 = new Rectangle2D.Float(200.0f, 100.0f, 100.0f, 100.0f);
        g2.fill(r2);
        ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        g2.setColor(Color.magenta);
        g2.setComposite(ac);
        
        Rectangle2D r3 = new Rectangle2D.Float(150.0f, 150.0f, 100.0f, 100.0f);
        g2.fill(r3);
        ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        g2.setColor(Color.yellow);
        g2.setComposite(ac);
        
        Rectangle2D r4 = new Rectangle2D.Float(100.0f, 200.0f, 100.0f, 100.0f);
        g2.fill(r4);
       
    }
    
    public static void main(String[] args) {
        new DrawUsingCoordinatesSystem();
    }
}
