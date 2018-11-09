/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios1;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Karen Velasco
 */
public class Metrics extends JFrame{
    
    public Metrics(){
        super("Metrics");
        
        setSize(420, 125);
        setVisible(true);
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        
        Font font = new Font("Serif", Font.ITALIC, 14);
        FontMetrics metrics = g.getFontMetrics(font);
        
        g.drawString("Ascent: "+  metrics.getAscent(), 10, 55);
        g.drawString("Descent: " + metrics.getDescent(), 10, 70);
        g.drawString("Height: " + metrics.getHeight(), 10, 85);
        g.drawString("Leading: " + metrics.getLeading(), 10, 100);
        //pagina 26
    }

    public static void main(String[] args) {
        Metrics application = new Metrics();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
