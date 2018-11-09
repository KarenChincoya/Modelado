/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.ejercicios;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 *
 * @author Karen Velasco
 */
public class DrawFunction extends JFrame{
 
    public DrawFunction(){
        super("Drawing Arcs");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        JLabel lblX = new JLabel("Valor x: ");
        JLabel lblY = new JLabel("Valor y: ");
        
        JTextField txtX = new JTextField();
        JTextField txtY = new JTextField();
        
        txtX.setPreferredSize(new Dimension(100,30));
        txtY.setPreferredSize(new Dimension(100,30));
       
        JButton btnEjecutar = new JButton("Dibujar");
        btnEjecutar.setPreferredSize(new Dimension(100,30));
        btnEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Integer x = Integer.valueOf(txtX.getText().trim());
              Integer y = Integer.valueOf(txtY.getText().trim());
              
              if(x>=-10 && x<=10 && y>=-10 && y<=10){
                  //si es asi
                  
              }else{
                  System.out.println("Valores incorrectos.");  
              }

            }
        });
        
        
        super.add(lblX);
        super.add(txtX);
        super.add(lblY);
        super.add(txtY);
        super.add(btnEjecutar);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(Color.BLACK);
        g.drawLine(350, 80, 350, 700);
        g.drawLine(0,350,700,350);
    }
    
    public static void main(String[] args) {
        DrawFunction application = new DrawFunction();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
