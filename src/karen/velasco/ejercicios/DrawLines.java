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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import karen.velasco.Ejercicios1.LinesRectOvals;

/**
 *
 * @author Karen Velasco
 */
public class DrawLines extends JFrame{
    private Integer numLines;

    public Integer getNumLines() {
        return numLines;
    }

    public void setNumLines(Integer numLines) {
        this.numLines = numLines;
    }
    
    public DrawLines(){
        super("Draw lines");
        super.setLayout(new FlowLayout());
        setSize(400, 400);
        
        JTextField txtNumeros = new JTextField();
        txtNumeros.setPreferredSize(new Dimension(100,30));
        JButton btnEjecutar = new JButton("Dibujar");
        btnEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Integer lineas = Integer.valueOf(txtNumeros.getText().trim());
              if(lineas>=1 && lineas<=15){
                DrawLines.this.setNumLines(lineas);
                DrawLines.this.revalidate();
                DrawLines.this.repaint();
              }else{
                  System.out.println("Valores incorrectos.");  
              }

            }
        });
        
        
        super.add(txtNumeros);
        
        super.add(btnEjecutar);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        int x1 = 50;
        int y1 = 100;
        
        int x2 = x1;
        int y2 = y1+100;
    
        g.setColor(Color.BLACK);
        
        for(int i=0; i<numLines; i++){
            g.drawLine(x1, y1, x1, y2);
            x1+=10;
        }
        
        //g.drawRect(5, 40, 90, 55);
        //g.fillRect(100, 40, 90, 55);
        
    }
    
    public static void main(String[] args) {
        DrawLines application = new DrawLines();
        application.setNumLines(1);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
