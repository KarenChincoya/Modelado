/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulacionImages;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.accessibility.AccessibleContext;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author Karen Velasco
 */
public class PnlOptions extends JPanel{
    
    private JLabel lblInstrucciones = new JLabel("Especificaciones de la imagen.");
    private JLabel lblFunciones = new JLabel("Acciones a realizar con la imagen seleccionada.");
    private JLabel lblEspecificaciones = new JLabel("Escribe el nombre de la imagen sin extension. ");
    
    private JComboBox comboSize;
    private JComboBox comboFormat;
    private JCheckBox checkSize;
    private JCheckBox checkFormat;
    private JCheckBox checkGrises;
    private JCheckBox checkBN;
    private JCheckBox checkSegmentarRGB;
    private JCheckBox checkVecindades;
    private JCheckBox checkObtenerNegativoDeGris;
    private JCheckBox checkObtenerNegativoDeRGB;
    private JCheckBox checkNivelesGrises;
    private JComboBox comboGrayLevels;
    
    private OptionsListener listener;
    
    private PnlGuardar pnlGuardar;
    private PnlChooseFile pnlChooseFile;
    
    public PnlOptions(){
        super.setPreferredSize(new Dimension(300,560));
        super.setLayout(new FlowLayout());

        checkSize = new JCheckBox("Tamaño ");
        String[] sizeOptions = {"160 x 200","200 x 400","600 x 800"};
        comboSize = new JComboBox(sizeOptions);
        comboSize.setPreferredSize(new Dimension(100,60));
        
        checkFormat = new JCheckBox("Formato");
        String[] formatOptions = {"gif","png", "jpg"};
        comboFormat = new JComboBox(formatOptions);
        comboFormat.setPreferredSize(new Dimension(100,60));
        
        checkGrises = new JCheckBox("Escala de grises");
        checkBN = new JCheckBox("Blanco/negro");
        checkSegmentarRGB = new JCheckBox("Segmentar RGB");
        checkVecindades = new JCheckBox("Vecindades");
        checkObtenerNegativoDeGris = new JCheckBox("Negativo de una imagen gris");
        checkObtenerNegativoDeRGB = new JCheckBox("Negativo de una imagen RGB");
        checkNivelesGrises = new JCheckBox("Niveles de grises");
        
        String[] grayLevels = {"4", "8", "16", "32"};
        comboGrayLevels = new JComboBox(grayLevels);
        
        pnlGuardar = new PnlGuardar();
        pnlGuardar.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onBtnClick();
            }
        });
        
        pnlChooseFile = new PnlChooseFile();
        
        add(pnlChooseFile);
        add(lblInstrucciones);
        add(checkSize);
        add(comboSize);
        add(checkFormat);
        add(comboFormat);
        add(lblFunciones);
        add(checkGrises);
        add(checkBN);
        add(checkSegmentarRGB);
        add(checkVecindades);
        add(checkObtenerNegativoDeGris);
        add(checkNivelesGrises);
        add(comboGrayLevels);
        
        add(lblEspecificaciones);
        add(pnlGuardar);
    }

    public void setComboSize(JComboBox comboSize) {
        this.comboSize = comboSize;
    }

    public void setComboFormat(JComboBox comboFormat) {
        this.comboFormat = comboFormat;
    }

    public OptionsListener getListener() {
        return listener;
    }

    public void setListener(OptionsListener listener) {
        this.listener = listener;
    }

    public JLabel getLblInstrucciones() {
        return lblInstrucciones;
    }

    public void setLblInstrucciones(JLabel lblInstrucciones) {
        this.lblInstrucciones = lblInstrucciones;
    }

    public JLabel getLblFunciones() {
        return lblFunciones;
    }

    public void setLblFunciones(JLabel lblFunciones) {
        this.lblFunciones = lblFunciones;
    }

    public JLabel getLblEspecificaciones() {
        return lblEspecificaciones;
    }

    public void setLblEspecificaciones(JLabel lblEspecificaciones) {
        this.lblEspecificaciones = lblEspecificaciones;
    }

    public JCheckBox getCheckSize() {
        return checkSize;
    }

    public void setCheckSize(JCheckBox checkSize) {
        this.checkSize = checkSize;
    }

    public JCheckBox getCheckFormat() {
        return checkFormat;
    }

    public void setCheckFormat(JCheckBox checkFormat) {
        this.checkFormat = checkFormat;
    }

    public JCheckBox getCheckGrises() {
        return checkGrises;
    }

    public void setCheckGrises(JCheckBox checkGrises) {
        this.checkGrises = checkGrises;
    }

    public JCheckBox getCheckBN() {
        return checkBN;
    }

    public void setCheckBN(JCheckBox checkBN) {
        this.checkBN = checkBN;
    }

    public JCheckBox getCheckSegmentarRGB() {
        return checkSegmentarRGB;
    }

    public void setCheckSegmentarRGB(JCheckBox checkSegmentarRGB) {
        this.checkSegmentarRGB = checkSegmentarRGB;
    }

    public JCheckBox getCheckVecindades() {
        return checkVecindades;
    }

    public void setCheckVecindades(JCheckBox checkVecindades) {
        this.checkVecindades = checkVecindades;
    }

    public JCheckBox getCheckObtenerNegativoDeGris() {
        return checkObtenerNegativoDeGris;
    }

    public void setCheckObtenerNegativoDeGris(JCheckBox checkObtenerNegativoDeGris) {
        this.checkObtenerNegativoDeGris = checkObtenerNegativoDeGris;
    }

    public JCheckBox getCheckObtenerNegativoDeRGB() {
        return checkObtenerNegativoDeRGB;
    }

    public void setCheckObtenerNegativoDeRGB(JCheckBox checkObtenerNegativoDeRGB) {
        this.checkObtenerNegativoDeRGB = checkObtenerNegativoDeRGB;
    }

    public JCheckBox getCheckNivelesGrises() {
        return checkNivelesGrises;
    }

    public void setCheckNivelesGrises(JCheckBox checkNivelesGrises) {
        this.checkNivelesGrises = checkNivelesGrises;
    }

    public JComboBox getComboGrayLevels() {
        return comboGrayLevels;
    }

    public void setComboGrayLevels(JComboBox comboGrayLevels) {
        this.comboGrayLevels = comboGrayLevels;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public PnlGuardar getPnlGuardar() {
        return pnlGuardar;
    }

    public void setPnlGuardar(PnlGuardar pnlGuardar) {
        this.pnlGuardar = pnlGuardar;
    }

    public PnlChooseFile getPnlChooseFile() {
        return pnlChooseFile;
    }

    public void setPnlChooseFile(PnlChooseFile pnlChooseFile) {
        this.pnlChooseFile = pnlChooseFile;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public JComboBox getComboSize() {
        return comboSize;
    }

    public JComboBox getComboFormat() {
        return comboFormat;
    }

    
    
}
