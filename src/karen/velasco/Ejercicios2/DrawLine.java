/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import karen.velasco.ejercicios.DrawFunction;

/**
 *
 * @author Karen Velasco
 */
public class DrawLine extends JFrame{
    public DrawLine(){
        super("Drawing Lines");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        //dibujo de la linea
        g2.setColor(Color.pink);
        g2.setStroke(new BasicStroke(3.0f));
        Line2D l = new Line2D.Float(50.0f, 50.0f, 200.0f, 200.0f);
        g2.draw(l);
    }
    
    public static void main(String[] args) {
        DrawLine application = new DrawLine();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
