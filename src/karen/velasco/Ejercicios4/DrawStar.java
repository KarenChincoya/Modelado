/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class DrawStar extends JFrame{
    
    private Integer lineas = 0;

    public Integer getLineas() {
        return lineas;
    }

    public void setLineas(Integer lineas) {
        this.lineas = lineas;
    }
    
    
    public DrawStar(){
        super("Drawing a star");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout());
        setSize(900, 900);
        
        //agregar
        JLabel lblInstrucciones = new JLabel("Ingrese la cantidad de lineas: ");
        JTextField txtLineas = new JTextField();
        txtLineas.setPreferredSize(new Dimension(60,30));
        JButton btnEjecutar = new JButton("Dibujar");
        btnEjecutar.setPreferredSize(new Dimension(80,30));
        
        btnEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1. Leer la cantidad de lineas
                Integer lineas = Integer.valueOf(txtLineas.getText().trim());
                if(lineas>=0 && lineas<=35){
                    //2. Resetear valoress
                    DrawStar.this.setLineas(lineas);
                    DrawStar.this.revalidate();
                    DrawStar.this.repaint();
                }else{
                    System.out.println("Ingresaste valores incorrectos");
                }
            }
        });
        
        super.add(lblInstrucciones);
        super.add(txtLineas);
        super.add(btnEjecutar);
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);

        g.drawLine(100, 450, 800, 450);
        g.drawLine(450,100, 450, 800);
        
        //1. dibujar el cuadrante 1
        int x1 = 450;
        int y1 = 100+(10*(35-lineas));
        int x2 = 450+10;
        int y2 = 450;
        for(int i=0; i<lineas; i++){
            g.drawLine(x1, y1, x2, y2);
            x2 += 10;
            y1 += 10;
        }
        
        //2. dibujar el cuadrante 2
        x1 = 450;
        y1 = 100+(10*(35-lineas));
        x2 = 450-10;
        y2 = 450;
        for(int i=0; i<lineas; i++){
            g.drawLine(x1, y1, x2, y2);
            x2 -= 10;
            y1 += 10;
        }
        //3. dibujar el cuadrante 3
        x1 = 450;
        y1 = 800-(10*(35-lineas));
        x2 = 450-10;
        y2 = 450;
        for(int i=0; i<lineas; i++){
            g.drawLine(x1, y1, x2, y2);
            x2 -= 10;
            y1 -= 10;
        }
        //4. Dibujar el cuadrante 4
        x1 = 450;
        y1 = 800-(10*(35-lineas));
        x2 = 450+10;
        y2 = 450;
        for(int i=0; i<lineas; i++){
            g.drawLine(x1, y1, x2, y2);
            x2 += 10;
            y1 -= 10;
        }
    }
    
    public static void main(String[] args) {
        new DrawStar();   
    }
}
