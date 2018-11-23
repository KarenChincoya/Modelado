/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karen.velasco.Ejercicios4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class DataReader extends JPanel{
    
    private JLabel lbl1;
    private JTextField txtGridSize;
    private JLabel lbl2;
    private JTextField txtMultiplos;
    private JButton btn;
    
    private GridListener listener;
    
    public DataReader(){
        super.setLayout(new FlowLayout());
        
        lbl1 = new JLabel("Tamaño del tablero: ");
        txtGridSize = new JTextField();
        lbl2 = new JLabel("Múltiplos de: ");
        txtMultiplos = new JTextField();
        
        txtGridSize.setPreferredSize(new Dimension(60,30));
        txtMultiplos.setPreferredSize(new Dimension(60,30));
        
        super.add(lbl1);
        super.add(txtGridSize);
        super.add(lbl2);
        super.add(txtMultiplos);
    }

    public JLabel getLbl1() {
        return lbl1;
    }

    public void setLbl1(JLabel lbl1) {
        this.lbl1 = lbl1;
    }

    public JTextField getTxtGridSize() {
        return txtGridSize;
    }

    public void setTxtGridSize(JTextField txtGridSize) {
        this.txtGridSize = txtGridSize;
    }

    public JLabel getLbl2() {
        return lbl2;
    }

    public void setLbl2(JLabel lbl2) {
        this.lbl2 = lbl2;
    }

    public JTextField getTxtMultiplos() {
        return txtMultiplos;
    }

    public void setTxtMultiplos(JTextField txtMultiplos) {
        this.txtMultiplos = txtMultiplos;
    }

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }

    public GridListener getListener() {
        return listener;
    }

    public void setListener(GridListener listener) {
        this.listener = listener;
    }
    
    
}
