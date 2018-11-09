/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;


/**
 *
 * @author Karen Velasco
 */
public class Ventana extends JFrame{
    
    public Ventana(){
        super("Prueba ventana");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        this.setSize(250, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
        //super.paint(g);
        Rectangle2D r2 = new Rectangle2D.Float(75, 50, 100, 25);
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(r2);
    }
    
    public static void main(String[] args) {
        new Ventana();
    }
}

