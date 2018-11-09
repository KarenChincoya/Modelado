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
public class DrawArcs extends JFrame{
    public DrawArcs(){
        super("Drawing Arcs");
        
        setSize(400, 270);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        //start at 0 adn sweep 360 degrees
        g.setColor(Color.YELLOW);
        g.drawRect(15, 35, 80, 80);
        
        g.setColor(Color.BLACK);
        g.drawArc(20, 40, 80, 80, 0, 360);
        
        //start at 0 and sweep 110 degrees 
        g.setColor(Color.YELLOW);
        g.drawRect(100, 35, 80, 80);
        g.setColor(Color.BLACK);
        g.drawArc(100, 35, 80, 80, 0, 110);
        
        //start at 0 and sweep -270 degrees 
        g.setColor(Color.YELLOW);
        g.drawRect(185, 35, 80, 80);
        g.setColor(Color.BLACK);
        g.drawArc(185, 35, 80, 80, 0, -270);
        
        //start at 0 and seep 360 degrees
        g.fillArc(15, 120, 80, 40, 0, 360);
        
        //start at 270 and seep -90 degrees 
        g.fillArc(100, 120, 80, 40, 270, -90);
        
        //start at 0 and sweep -270 degrees 
        g.fillArc(185, 120, 80, 40, 0, -270);
    }
    
    public static void main(String[] args) {
        DrawArcs application = new DrawArcs();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
