/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulacionImages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class PnlChooseFile extends JPanel{
    private JTextField txtArchivo;
    private JButton btnGuardar;
    private String path;
    
    public PnlChooseFile(){
        txtArchivo = new JTextField("");
        txtArchivo.setPreferredSize(new Dimension(150,40));
        
        btnGuardar = new JButton("Elegir imagen");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                path = FileChooser.getFilePath();
                txtArchivo.setText(path);
            }
        });
        
        add(txtArchivo);
        add(btnGuardar);
    }

    public JTextField getTxtNombre() {
        return txtArchivo;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtArchivo = txtNombre;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
