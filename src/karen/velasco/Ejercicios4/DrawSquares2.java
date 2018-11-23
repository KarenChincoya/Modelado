/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Karen Velasco
 */
public class DrawSquares2 extends JFrame{
    private int width = 1;
    private int height = 1;
    private int beginning = 0;
    private RectangleK rectangulo;
    private Square2[] square;
    private JPanel pnlAux;
    private PnlReadData2 pnlData;
    private PnlBotones2 pnlBotones;
    
    public void reset(){
        this.width = 1;
        this.height = 1;
        this.beginning = 0;
        
        this.pnlData.reset();
        this.pnlData.getBtnIniciar().setEnabled(true);
        this.pnlBotones.disableEverything();
        
        this.revalidate();
        this.repaint();
    }
    
    public DrawSquares2(){
        super("Draw squares");
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(1200,950);
    
        pnlAux = new JPanel();
        pnlAux.setLayout(new BorderLayout());
        
        pnlData  = new PnlReadData2();
        pnlBotones = new PnlBotones2();
        
        pnlAux.add(pnlData, BorderLayout.CENTER);
        pnlAux.add(pnlBotones, BorderLayout.EAST);
        
        rectangulo = new RectangleK(0, 1, 1);
        pnlBotones.disableEverything();
        //1. Definir los cuadritos
        pnlData.setListener(new PnlReadData2Listener() {
            @Override
            public void onBtnClick(int width, int height, int beginning) {
            
                if(width>=1 && width<=50 && height>=1 && height<=35 && beginning<(width*height)){
                    /*Once you have the number set the values to the object*/
                DrawSquares2.this.width = width;
                DrawSquares2.this.height = height;
                DrawSquares2.this.beginning = beginning;
                //Definir los cuadritos
                square = new Square2[width*height];
                int id = 0;
                for(int i=0; i<height; i++){//filas
                    for(int j=0; j<width; j++){
                        square[id] = new Square2(j,i,id);
                        id++;
                    }
                }
                //Coloca el primer rectangulo
                DrawSquares2.this.rectangulo = new RectangleK(beginning, 1, 1);
                pnlData.getBtnIniciar().setEnabled(false);
                pnlBotones.enableEverything();
                DrawSquares2.this.revalidate();
                DrawSquares2.this.repaint();
                }else{
                    JOptionPane.showMessageDialog(null, "Los valores deben estar en [1,50] y el inicio debe estar en [0, width*height]");
                }
            }
        });
        
        pnlBotones.setListener(new ExpandListener() {
            @Override
            public void onBtnClick(int movement) {
                int w;
                int h;
                RectangleK nuevo;
                switch(movement){
                    case 1://up 
                        System.out.println("Expand up");
                        w = DrawSquares2.this.rectangulo.getWidth();
                        h = DrawSquares2.this.rectangulo.getHeight()*2;
                        nuevo = DrawSquares2.this.getExpandUp(w, h);
                        if(nuevo.getInvalidos()==0){
                            System.out.println("Aprobado -------------------------------");
                            DrawSquares2.this.rectangulo = nuevo;
                            System.out.println(DrawSquares2.this.rectangulo.getInicio());
                            DrawSquares2.this.revalidate();
                            DrawSquares2.this.repaint();
                        }
                        break;
                    case 2://left
                        System.out.println("Expand left");
                        w = DrawSquares2.this.rectangulo.getWidth() * 2;
                        h = DrawSquares2.this.rectangulo.getHeight();
                        nuevo = DrawSquares2.this.getExpandLeft(w, h);
                        if(nuevo.getInvalidos()==0){
                            System.out.println("Aprobado -------------------------------");
                            DrawSquares2.this.rectangulo = nuevo;
                            System.out.println(DrawSquares2.this.rectangulo.getInicio());
                            DrawSquares2.this.revalidate();
                            DrawSquares2.this.repaint();
                        }
                        break;
                    case 3://right
                        System.out.println("Expand right");
                        w = DrawSquares2.this.rectangulo.getWidth() * 2;
                        h = DrawSquares2.this.rectangulo.getHeight();
                        nuevo = DrawSquares2.this.getExpandRight(w, h);
                        if(nuevo.getInvalidos()==0){
                            DrawSquares2.this.rectangulo = nuevo;
                            DrawSquares2.this.revalidate();
                            DrawSquares2.this.repaint();
                        }
                        break;
                    case 4:
                        System.out.println("Expand down");
                        w = DrawSquares2.this.rectangulo.getWidth();
                        h = DrawSquares2.this.rectangulo.getHeight()*2;
                        nuevo = DrawSquares2.this.getExpandDown(w, h);
                        if(nuevo.getInvalidos()==0){
                            System.out.println("Aprobado -------------------------------");
                            DrawSquares2.this.rectangulo = nuevo;
                            System.out.println(DrawSquares2.this.rectangulo.getInicio());
                            DrawSquares2.this.revalidate();
                            DrawSquares2.this.repaint();
                        }
                        break;
                }
            }
        });
        
        JButton btnReset = new JButton("RESET");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrawSquares2.this.reset();
            }
        });
        btnReset.setPreferredSize(new Dimension(60,60));
        
        super.add(btnReset, BorderLayout.SOUTH);
        super.add(pnlAux, BorderLayout.NORTH);
        super.setVisible(true);
    }
    
    public RectangleK getExpandRight(int w, int h){
        
        RectangleK newRectangle = new RectangleK(this.rectangulo.getInicio(), w, h);
        //1. if the last square is in the same row, pass, else, false
        int alcance = (rectangulo.getInicio()%this.width)+(w);
        if(!(alcance<width)){
            newRectangle.insertInvalido();
        }     
        return newRectangle;
    }
    
    public RectangleK getExpandLeft(int w, int h){
        RectangleK newRectangle = null;
        //1. if the last square is in the same row, pass, else, false
        int alcance = (rectangulo.getInicio()%this.width)-(w/2);
        int resi = rectangulo.getInicio()%this.width;
        
        if(alcance>=0){
            int inicio = rectangulo.getInicio()-(w/2);
            newRectangle = new RectangleK(inicio, w, h);
        }else{
            newRectangle.insertInvalido();
        }     
        return newRectangle;
    }
    
    public RectangleK getExpandDown(int w, int h){
        RectangleK newRectangle = new RectangleK(this.rectangulo.getInicio(), w, h);
        //1. if the last square is in the same row, pass, else, false
        int alcance = ((rectangulo.getInicio()-(rectangulo.getInicio()%this.width))/(this.width))+1;
        alcance = alcance+h;
        if(!(alcance<this.height)){
            newRectangle.insertInvalido();
        }     
        return newRectangle;
    }
    
    public RectangleK getExpandUp(int w, int h){
        RectangleK newRectangle = new RectangleK(this.rectangulo.getInicio()-((h/2)*this.width), w, h);
        //1. if the last square is in the same row, pass, else, false
        int alcance = ((rectangulo.getInicio()-(rectangulo.getInicio()%this.width))/(this.width))+1;
        alcance = alcance-(h/2);
        if(!(alcance>=0)){
            newRectangle.insertInvalido();
        }     
        return newRectangle;
    }
    
    public boolean exists(int n){
        if(n>=0 && n<(this.width*this.height)){
            System.out.println(n + " existe");
            return true;
        }
        return false;
    }
    
    /*Declara el rectangulo y luego repinta*/
    
    public void paint(Graphics g){
        super.paint(g);
        
        if(square==null){
            System.out.println("Square es null");
            square = new Square2[1];
            square[0] = new Square2(0, 0, 0);
            rectangulo = new RectangleK(0, 1, 1);
        }
        Graphics2D g2 = (Graphics2D)g;         
        g2.setStroke(new BasicStroke(1.0f));
                
        g.setFont(new Font("Serif", Font.BOLD, 12));

        //int r = this.beginning;
        int r = this.rectangulo.getInicio();
        
        //2. Dibujar todos los cuadritos dentro del rectangulo 
        for(int i=0; i<this.rectangulo.getHeight(); i++){
            for(int j=0; j<this.rectangulo.getWidth(); j++){
                float x1 = square[r].getCoordX() + 20;
                float y1 = square[r].getCoordY() + 20;
                Rectangle2D cuadrito = new Rectangle2D.Float(x1, y1, 15.0f, 15.0f);
                g2.draw(cuadrito);
                System.out.println("Cuadrito dibujado = "+r);
                r++;
            }
            r-=this.rectangulo.getWidth();
            
            r+=this.width;
        }
        
        System.out.println("Fin dibujar");
    }

    public static void main(String[] args) {
        new DrawSquares2();
    }
}
