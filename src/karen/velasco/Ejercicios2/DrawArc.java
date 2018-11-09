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
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class DrawArc extends JFrame{
    
    public DrawArc(){
        super("Draw arc 2D");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        /* Creación del arco:
            1. Definir el rectangulo
            2. anguos de inicio y fin
            3. Tipos de cierre: open, chord, pie (al centro)
        */
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(1.0f));
        Rectangle2D r = new Rectangle2D.Float(100.0f, 75.0f, 50.0f, 100.0f);
        g2.draw(r);
        //dibujar el arco
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(3.0f));
        Arc2D a = new Arc2D.Float(100.0f, 75.0f, 50.0f, 100.0f, 0.0f, 135.0f, Arc2D.PIE);
        g2.draw(a);
    }
    
    public static void main(String[] args) {
        DrawArc application = new DrawArc();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
