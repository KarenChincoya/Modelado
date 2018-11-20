/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

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
    private int a;
    private int b;
    private int c;
    private int x0;
    private int xf;
    private int n;
    private int[] X;
    private int[] Y;
    
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(int xf) {
        this.xf = xf;
    }

    
    
    public DrawFunction(){
        super("Drawing Arcs");
        super.setLayout(new FlowLayout());
        setSize(700, 700);
        
        JTextField txt1 = new JTextField();
        JTextField txt2 = new JTextField();
        JTextField txt3 = new JTextField();
        
        JLabel lbl1 = new JLabel("x^2 + ");
        JLabel lbl2 = new JLabel("x + ");
        
        JLabel lbl3 = new JLabel("Intervalo: [");
        JTextField txt4 = new JTextField("");
        JLabel lbl4 = new JLabel(" , ");
        JTextField txt5 = new JTextField("");
        JLabel lbl5 = new JLabel("]");
        
        txt1.setPreferredSize(new Dimension(60,30));
        txt2.setPreferredSize(new Dimension(60,30));
        txt3.setPreferredSize(new Dimension(60,30));
        txt4.setPreferredSize(new Dimension(60,30));
        txt5.setPreferredSize(new Dimension(60,30));
       
        JButton btnEjecutar = new JButton("Dibujar");
        btnEjecutar.setPreferredSize(new Dimension(100,30));
        btnEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int a = Integer.valueOf(txt1.getText().trim());
              int b = Integer.valueOf(txt2.getText().trim());
              int c = Integer.valueOf(txt3.getText().trim());
              int x0 = Integer.valueOf(txt4.getText().trim());
              int xf = Integer.valueOf(txt5.getText().trim());
              
              if(x0<xf && x0>=-15 && xf<=15 && x0<=15 && xf>=-15){
                  //set values and repaint
                  DrawFunction.this.setA(a);
                  DrawFunction.this.setB(b);
                  DrawFunction.this.setC(c);
                  DrawFunction.this.setX0(x0);
                  DrawFunction.this.setXf(xf);
                  
                  DrawFunction.this.asignarValores();
                  
                  DrawFunction.this.revalidate();
                  DrawFunction.this.repaint();
              }else{
                  System.out.println("Valores incorrectos.");  
              }

            }
        });
        
        
        super.add(txt1);
        super.add(lbl1);
        super.add(txt2);
        super.add(lbl2);
        super.add(txt3);
        super.add(lbl3);
        super.add(txt4);
        super.add(lbl4);
        super.add(txt5);
        super.add(lbl5);
        
        super.add(btnEjecutar);
        
        setVisible(true);
    }
    
    public void asignarValores(){
        System.out.println("----- FUNCION ASIGNACION DE VALORES --------------");
        n = (xf-x0)+1;
        System.out.println("n = "+n);
        this.X= new int[n];
        this.Y= new int[n];
        int k = 0;
        System.out.println("Valores originales: ");
        for(int i=x0; i<=xf; i++){
            this.X[k] = i;
            this.Y[k] = (int) (a*Math.pow(X[k],2)+b*X[k]+c);
            System.out.println("("+X[k]+","+Y[k]+")");
            k++;
        }
        System.out.println("Fin asignar valores.");
    }
    
    public void paint(Graphics g){
        super.paint(g);
        //1. calcular los puntos de los intervalos
        g.setColor(Color.BLACK);
        g.drawLine(350, 80, 350, 700);
        g.drawLine(0,350,700,350);
        //si son n 
        System.out.println("\n\n----------- COORDENADAS DIBUJO ------------\n");
        for(int i=0; i<(n-1); i++){
            //el actual y el siguiente
            System.out.println("\tElemento "+i);
            int x1 = 350 + 5*this.X[i];
            int y1 = 350 - 5*this.Y[i];
            int x2 = 350 + 5*this.X[i+1];
            int y2 = 350 - 5*this.Y[i+1];
            System.out.println("drawLine("+x1+","+y1+","+x2+" , "+y2+")");
            g.drawLine(x1,y1,x2,y2);
        }
        System.out.println("\n-------------FIN DIBUJO-----------------");
    }
    
    public static void main(String[] args) {
        DrawFunction application = new DrawFunction();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
