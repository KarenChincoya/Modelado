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
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class PnlReadData2 extends JPanel{
    private JLabel lblWidth;
    private JTextField txtWidth;
    private JLabel lblHeight;
    private JTextField txtHeight;
    private JLabel lblBeginning;
    private JTextField txtBeginning;
    private JButton btnIniciar;
    
    private PnlReadData2Listener listener;
    
    public void reset(){
        this.txtWidth.setText("");
        this.txtHeight.setText("");
        this.txtBeginning.setText("");
    }
    
    public PnlReadData2(){
        super.setLayout(new FlowLayout());
        
        lblWidth = new JLabel("Width ");
        txtWidth = new JTextField();
        lblHeight = new JLabel("Height ");
        txtHeight = new JTextField();
        lblBeginning = new JLabel("Cuadrito inicial ");
        txtBeginning = new JTextField();
        btnIniciar = new JButton("Iniciar");
        
        txtWidth.setPreferredSize(new Dimension(60,30));
        txtHeight.setPreferredSize(new Dimension(60,30));
        txtBeginning.setPreferredSize(new Dimension(60,30));
        
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int w = Integer.valueOf(txtWidth.getText().trim()); 
                int h = Integer.valueOf(txtHeight.getText().trim());
                int b = Integer.valueOf(txtBeginning.getText().trim());
                
                listener.onBtnClick(w, h, b);
            }
        });
        
        super.add(lblWidth);
        super.add(txtWidth);
        super.add(lblHeight);
        super.add(txtHeight);
        super.add(lblBeginning);
        super.add(txtBeginning);
        super.add(btnIniciar);
    }

    public JLabel getLblWidth() {
        return lblWidth;
    }

    public void setLblWidth(JLabel lblWidth) {
        this.lblWidth = lblWidth;
    }

    public JTextField getTxtWidth() {
        return txtWidth;
    }

    public void setTxtWidth(JTextField txtWidth) {
        this.txtWidth = txtWidth;
    }

    public JLabel getLblHeight() {
        return lblHeight;
    }

    public void setLblHeight(JLabel lblHeight) {
        this.lblHeight = lblHeight;
    }

    public JTextField getTxtHeight() {
        return txtHeight;
    }

    public void setTxtHeight(JTextField txtHeight) {
        this.txtHeight = txtHeight;
    }

    public JLabel getLblBeginning() {
        return lblBeginning;
    }

    public void setLblBeginning(JLabel lblBeginning) {
        this.lblBeginning = lblBeginning;
    }

    public JTextField getTxtBeginning() {
        return txtBeginning;
    }

    public void setTxtBeginning(JTextField txtBeginning) {
        this.txtBeginning = txtBeginning;
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }

    public void setBtnIniciar(JButton btnIniciar) {
        this.btnIniciar = btnIniciar;
    }

    public PnlReadData2Listener getListener() {
        return listener;
    }

    public void setListener(PnlReadData2Listener listener) {
        this.listener = listener;
    }
    
    
}
