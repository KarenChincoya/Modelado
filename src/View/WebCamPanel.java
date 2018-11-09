/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import javax.swing.JPanel;

/**
 *
 * @author Karen Velasco
 */
public class WebCamPanel extends JPanel{
    private Webcam webcam = null;
    private WebcamPanel webcamPanel = null;
    private WebcamPicker picker = null;
    
    public WebCamPanel(){
        webcamPanel = new WebcamPanel(webcam, false);
            
        picker = new WebcamPicker();
        webcam = picker.getSelectedWebcam();
        
        if (webcam == null) {
            System.out.println("No webcams found...");
            System.exit(1);
        }
        
    }
    
}
