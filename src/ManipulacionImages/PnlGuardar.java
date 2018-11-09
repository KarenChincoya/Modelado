/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulacionImages;

import java.awt.Dimension;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Karen Velasco
 */
public class PnlGuardar extends JPanel{
    private JTextField txtNombre;
    private JButton btnGuardar;

    public PnlGuardar(){
        txtNombre = new JTextField("Nombre sin formato");
        txtNombre.setPreferredSize(new Dimension(150,40));
        
        btnGuardar = new JButton("Ejecutar");
        
        add(txtNombre);
        add(btnGuardar);
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public static float getTOP_ALIGNMENT() {
        return TOP_ALIGNMENT;
    }

    public static float getCENTER_ALIGNMENT() {
        return CENTER_ALIGNMENT;
    }

    public static float getBOTTOM_ALIGNMENT() {
        return BOTTOM_ALIGNMENT;
    }

    public static float getLEFT_ALIGNMENT() {
        return LEFT_ALIGNMENT;
    }

    public static float getRIGHT_ALIGNMENT() {
        return RIGHT_ALIGNMENT;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }
    
    
    
}
