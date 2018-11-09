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
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class DrawSquare extends JFrame{

    private Integer longitud;

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }
    
    public DrawSquare(){
        super("Draw squares");
        super.setLayout(new FlowLayout());
        setSize(600, 650);
        
        JTextField txtNumeros = new JTextField();
        txtNumeros.setPreferredSize(new Dimension(100,30));
        JButton btnEjecutar = new JButton("Dibujar");
        btnEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Integer longitud = Integer.valueOf(txtNumeros.getText().trim());
              if(longitud>=1 && longitud<=500){
                DrawSquare.this.setLongitud(longitud); ;
                DrawSquare.this.revalidate();
                DrawSquare.this.repaint();
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
        
        int[] x = {50, 50+longitud, 50+longitud, 50};
        int[] y = {100, 100, 100+longitud, 100+longitud};
        
        g.setColor(Color.BLACK);
        
        g.drawLine(x[0], y[0], x[1], y[1]);
        g.drawLine(x[1], y[1], x[2], y[2]);
        g.drawLine(x[2], y[2], x[3], y[3]);
        g.drawLine(x[3], y[3], x[0], y[0]);
        
        //g.drawRect(5, 40, 90, 55);
        //g.fillRect(100, 40, 90, 55);
        
    }
    
    public static void main(String[] args) {
        DrawSquare application = new DrawSquare();
        application.setLongitud(1);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
