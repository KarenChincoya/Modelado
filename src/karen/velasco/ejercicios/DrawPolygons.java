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
import karen.velasco.Ejercicios1.DrawArcs;


/**
 *
 * @author Karen Velasco
 */
public class DrawPolygons extends JFrame{
    
    private int x=80;
    private int y = 1;    
    private int option=4;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
    
    
    
    public DrawPolygons(){
        super("Drawing Arcs");
        super.setLayout(new FlowLayout());
        setSize(600, 600);
        
        JLabel lblX = new JLabel("Valor x: ");
        JLabel lblY = new JLabel("Valor y: ");
        
        JTextField txtX = new JTextField();
        JTextField txtY = new JTextField();
        
        txtX.setPreferredSize(new Dimension(100,30));
        txtY.setPreferredSize(new Dimension(100,30));
        
        JRadioButton opc1 = new JRadioButton("Linea");
        JRadioButton opc2 = new JRadioButton("Cuadrado");
        JRadioButton opc3 = new JRadioButton("Rectangulo");
        JRadioButton opc4 = new JRadioButton("Circulo");
        
        ButtonGroup group = new ButtonGroup();
        
        JButton btnEjecutar = new JButton("Dibujar");
        btnEjecutar.setPreferredSize(new Dimension(100,30));
        btnEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Integer x = Integer.valueOf(txtX.getText().trim());
              Integer y = Integer.valueOf(txtY.getText().trim());
              
              Integer opcion = 4;
              if(opc1.isSelected()) opcion = 0;
              if(opc2.isSelected()) opcion = 1;
              if(opc3.isSelected()) opcion = 2;
              if(opc4.isSelected()) opcion = 3;

              System.out.println("Opcion " + opcion);
                System.out.println("y = "+y);
              if(x>=1 && x<=300 && y>=1 && y<=300){
                  //si es asi
                  DrawPolygons.this.setX(x);
                  DrawPolygons.this.setY(y);
                  DrawPolygons.this.setOption(opcion);
                  DrawPolygons.this.revalidate();
                  DrawPolygons.this.repaint();
              }else{
                  System.out.println("Valores incorrectos.");  
              }

            }
        });
        
        
        super.add(lblX);
        super.add(txtX);
        super.add(lblY);
        super.add(txtY);
        super.add(opc1);
        super.add(opc2);
        super.add(opc3);
        super.add(opc4);
        super.add(btnEjecutar);
        
        setVisible(true);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(Color.BLACK);
        int x1 = 120;
        int y1 = 120;
        
        switch(option){
            case 0://linea
                System.out.println("caso 0");
               g.drawLine(x1, y1, x1+x, y1);
                break;
            case 1://cuadrado
                g.drawRect(x1, y1, x, x);                
                break;
            case 2://rectangulo
                g.drawRect(x1, y1, x, y);
                break;
            case 3://circulo
                g.drawArc(x1, y1, x, x, 0, 360);
                break;
            case 4:
                System.out.println("Ninguna opcion");
            default:
                System.out.println("Ninguna opcion");
        }
        
    }
    
    public static void main(String[] args) {
        DrawPolygons application = new DrawPolygons();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
