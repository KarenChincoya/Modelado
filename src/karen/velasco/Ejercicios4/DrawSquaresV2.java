/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercisesClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JAVIER1
 */
public class DrawSquaresV2 extends JFrame {
    private JPanel pnlControles;
    private JPanel pnlCuadros;
    private JButton btnIzq;
    private JButton btnDer;
    private JButton btnArriba;
    private JButton btnAbajo;
    private Cuadrin cuadro;
    
    public Cuadritos(){
        super("Cuadritos");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(1200, 700);
        super.setLayout(new BorderLayout());
        
        pnlControles = new JPanel();
        pnlControles.setLayout(new BorderLayout());
        pnlControles.setSize(350, 700);
        
        cuadro = new Cuadrin(425,350);
        
        pnlCuadros = new JPanel();
        pnlCuadros.setBackground(Color.BLACK);
        
        btnIzq = new JButton();
        cargarIcono("/imgs/007-left-arrow.png", btnIzq);
        btnIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xnew = cuadro.getX()-60;
                int ynew = cuadro.getY();
                Cuadrin aux = new Cuadrin(xnew, ynew);
                Graphics g = pnlCuadros.getGraphics();
                g.setColor(aux.getColor());
                g.fillRect(xnew, ynew, aux.getSize(), aux.getSize());
                cuadro = aux;
            }
        });
        
        btnDer = new JButton();
        cargarIcono("/imgs/005-right-arrow-1.png", btnDer);
        btnDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xnew = cuadro.getX()+60;
                int ynew = cuadro.getY();
                Cuadrin aux = new Cuadrin(xnew, ynew);
                Graphics g = pnlCuadros.getGraphics();
                g.setColor(aux.getColor());
                g.fillRect(xnew, ynew, aux.getSize(), aux.getSize());
                cuadro = aux;
            }
        });
        
        btnArriba = new JButton();
        cargarIcono("/imgs/002-up-arrow-1.png", btnArriba);
        btnArriba.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xnew = cuadro.getX();
                int ynew = cuadro.getY()-60;
                Cuadrin aux = new Cuadrin(xnew, ynew);
                Graphics g = pnlCuadros.getGraphics();
                g.setColor(aux.getColor());
                g.fillRect(xnew, ynew, aux.getSize(), aux.getSize());
                cuadro = aux;
            }
        });
        
        btnAbajo = new JButton();
        cargarIcono("/imgs/003-down-arrow.png", btnAbajo);
        btnAbajo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xnew = cuadro.getX();
                int ynew = cuadro.getY()+60;
                Cuadrin aux = new Cuadrin(xnew, ynew);
                Graphics g = pnlCuadros.getGraphics();
                g.setColor(aux.getColor());
                g.fillRect(xnew, ynew, aux.getSize(), aux.getSize());
                cuadro = aux;
            }
        });
        
        
        pnlControles.add(btnIzq, BorderLayout.WEST);
        pnlControles.add(btnDer, BorderLayout.EAST);
        pnlControles.add(btnArriba, BorderLayout.NORTH);
        pnlControles.add(btnAbajo, BorderLayout.SOUTH);
        
        
        
        super.add(pnlControles, BorderLayout.EAST);
        super.add(pnlCuadros, BorderLayout.CENTER);
        super.setVisible(true);
    }
    
    
    private void cargarIcono(String path, JButton btn){
        URL url=System.class.getResource(path);
        ImageIcon im= new ImageIcon(url);
        btn.setIcon(im);
    }
    
    public static void main(String[] args) {
        Cuadritos cuadritos = new Cuadritos();
    }
}

class Cuadrin{
    private int x;
    private int y;
    private final int size = 50;
    private Color color;
    
    public Cuadrin(int x, int y){
        this.x = x;
        this.y = y;
        setColor();
    }
    
    private void setColor(){
        Random random= new Random();
        Integer r=random.nextInt(255)+1;
        Integer g=random.nextInt(255)+1;
        Integer b=random.nextInt(255)+1;
         color=new Color(r,g,b);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }
    
    
}
