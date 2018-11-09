/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulacionImages;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Karen Velasco
 */
public class FileChooser {

public static String getFilePath(){
        // TODO code application logic here
        String path = null;
        try{
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

	    if (returnValue == JFileChooser.APPROVE_OPTION) {
		File selectedFile = jfc.getSelectedFile();
                path = selectedFile.getAbsolutePath();
	    }
        
            System.out.println(path);
            return path;
        }catch(Exception e){
            System.out.println("Hubo un error en la lectura del archivo.");
        }
        return null;
    }    
}
