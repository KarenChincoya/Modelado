/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velasco.karen.Ejercicios3;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Karen Velasco
 */
public class DrawRendering extends JFrame{
    
    public DrawRendering(){
        
        super("Rendering images");
        super.setLayout(new FlowLayout());
                
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        RenderingHints rh = new RenderingHints(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_OFF);
        
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(rh);
        
    }
    
    public static void main(String[] args) {
        new DrawRendering();
    }
}
