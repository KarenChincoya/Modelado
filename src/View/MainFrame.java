/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Karen Velasco
 */
public class MainFrame extends JFrame{
    
    public MainFrame(){
        super("Camera program");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        super.setSize(400,400);
        
        
        super.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MainFrame();
    }
}
