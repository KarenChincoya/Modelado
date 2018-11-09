/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Karen Velasco
 */
public class ShowColors2 extends JFrame{
    
    private JButton changeColorButton;
    private Color color = Color.LIGHT_GRAY;
    private Container container;
    
    public ShowColors2(){
        super("Using JColorChooser");
        
        container = getContentPane();
        container.setLayout(new FlowLayout());
        
        changeColorButton = new JButton("Change Color");
        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(ShowColors2.this, "Choose a color", color);
                
                if(color==null) color = Color.LIGHT_GRAY;
                
                container.setBackground(color);
            }
        });
        
        container.add(changeColorButton);
        
        setSize(400, 130);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        ShowColors2 application = new ShowColors2();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
