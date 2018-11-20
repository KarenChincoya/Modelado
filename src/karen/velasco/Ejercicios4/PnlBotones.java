/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Karen Velasco
 */
public class PnlBotones extends JPanel{
    
    private JButton btn1 = new JButton();
    private JButton btnUp = new JButton("↑");
    private JButton btn3 = new JButton();
    private JButton btnLeft = new JButton("←");
    private JButton btn5 = new JButton();
    private JButton btnRight = new JButton("→");
    private JButton btn7 = new JButton();
    private JButton btnDown = new JButton("↓");
    private JButton btn9 = new JButton();
    
    private ExpandListener listener;
    
    public PnlBotones(){
        super.setLayout(new GridLayout(3,3));
        super.setPreferredSize(new Dimension(140,140));
        
        btn1 = new JButton();
        btnUp = new JButton("↑");
        btn3 = new JButton();
        btnLeft = new JButton("←");
        btn5 = new JButton();
        btnRight = new JButton("→");
        btn7 = new JButton();
        btnDown = new JButton("↓");
        btn9 = new JButton();
        
        btn1.setPreferredSize(new Dimension(30,30));
        btn3.setPreferredSize(new Dimension(30,30));
        btn5.setPreferredSize(new Dimension(30,30));
        btn7.setPreferredSize(new Dimension(30,30));
        btn9.setPreferredSize(new Dimension(30,30));
        btnUp.setPreferredSize(new Dimension(35,35));
        btnLeft.setPreferredSize(new Dimension(35,35));
        btnRight.setPreferredSize(new Dimension(35,35));
        btnDown.setPreferredSize(new Dimension(35,35));
        
        btn1.setEnabled(false);
        btn3.setEnabled(false);
        btn5.setEnabled(false);
        btn7.setEnabled(false);
        btn9.setEnabled(false);
        
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick(1);
            }
        });
        
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick(2);
            }
        });
        
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick(3);
            }
        });
        
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick(4);
            }
        });
        
        super.add(btn1);
        super.add(btnUp);
        super.add(btn3);
        super.add(btnLeft);
        super.add(btn5);
        super.add(btnRight);
        super.add(btn7);
        super.add(btnDown);
        super.add(btn9);
        
    }
    
    public ExpandListener getListener() {
        return listener;
    }

    public void setListener(ExpandListener listener) {
        this.listener = listener;
    }

    public JButton getBtn1() {
        return btn1;
    }

    public void setBtn1(JButton btn1) {
        this.btn1 = btn1;
    }

    public JButton getBtnUp() {
        return btnUp;
    }

    public void setBtnUp(JButton btnUp) {
        this.btnUp = btnUp;
    }

    public JButton getBtn3() {
        return btn3;
    }

    public void setBtn3(JButton btn3) {
        this.btn3 = btn3;
    }

    public JButton getBtnLeft() {
        return btnLeft;
    }

    public void setBtnLeft(JButton btnLeft) {
        this.btnLeft = btnLeft;
    }

    public JButton getBtn5() {
        return btn5;
    }

    public void setBtn5(JButton btn5) {
        this.btn5 = btn5;
    }

    public JButton getBtnRight() {
        return btnRight;
    }

    public void setBtnRight(JButton btnRight) {
        this.btnRight = btnRight;
    }

    public JButton getBtn7() {
        return btn7;
    }

    public void setBtn7(JButton btn7) {
        this.btn7 = btn7;
    }

    public JButton getBtnDown() {
        return btnDown;
    }

    public void setBtnDown(JButton btnDown) {
        this.btnDown = btnDown;
    }

    public JButton getBtn9() {
        return btn9;
    }

    public void setBtn9(JButton btn9) {
        this.btn9 = btn9;
    }
    
    
}
