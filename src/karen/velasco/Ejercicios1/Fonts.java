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
public class Fonts extends JFrame{
    
    public Fonts(){
        super("Using fonts");
        
        setSize(420, 125);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        g.setFont(new Font("Serif", Font.BOLD, 12));
        g.drawString("Serif 12 point bold.", 20, 50);
        
        g.setFont(new Font("Monospaced", Font.ITALIC, 24));
        g.drawString("Monospaced 24 point italic.", 20, 70);
        
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("SansSerif 14 point plain.", 20, 90);

        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));
        g.drawString(g.getFont().getName() + "" + g.getFont().getSize() + " point bold italic.", 20, 110);
    }
    
    public static void main(String[] args) {
        Fonts application = new Fonts();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
