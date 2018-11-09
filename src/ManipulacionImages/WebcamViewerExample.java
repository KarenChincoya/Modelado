/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulacionImages;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Karen Velasco
 */
public class WebcamViewerExample extends JFrame implements Runnable, WebcamListener, WindowListener, Thread.UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener {

	private static final long serialVersionUID = 1L;

	private Webcam webcam = null;
	private WebcamPanel webcamPanel = null;
	private WebcamPicker picker = null;
        
        private JLabel lblTitulo = new JLabel("Camera application");
        private JButton btnShoot = new JButton("Tomar foto");
        
        private String dir = System.getProperty("user.dir")+"/src/images/";

        private Integer cont;
        
	@Override
	public void run() {

		Webcam.addDiscoveryListener(this);

		setTitle("Java Webcam Capture POC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
                super.setPreferredSize(new Dimension(800,600));
//                this.setSize(600,600);

		addWindowListener(this);

		picker = new WebcamPicker();
		picker.addItemListener(this);

		webcam = picker.getSelectedWebcam();

		if (webcam == null) {
			System.out.println("No webcams found...");
			System.exit(1);
		}

		webcam.setViewSize(WebcamResolution.VGA.getSize());
		webcam.addWebcamListener(WebcamViewerExample.this);

		webcamPanel = new WebcamPanel(webcam, false);
		webcamPanel.setPreferredSize(new Dimension(400,400));
                webcamPanel.setFPSDisplayed(true);

//		add(picker);
                
                Font fuente = new Font("Dialog", Font.BOLD, 18);
		lblTitulo.setFont(fuente);
                
                btnShoot.setPreferredSize(new Dimension(60,40));
                cont = 0;
                btnShoot.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BufferedImage image = webcam.getImage();
            		String outputDir1 = dir.concat("foto"+cont+".png");
        
                        try {
                            if (image != null) {
                                File output_file = new File(outputDir1);
				ImageIO.write(image, "png", output_file);
				System.out.println("Writing complete.");
                            }
                        } catch (IOException error) {
                            // TODO: handle exception
                            System.out.println("No se guardo la foto");
                            System.out.println("Error while writing: " + error);
                        }
                        System.out.println("Imagen impresa");
                        cont++;
                    }
                });
                
                JPanel pnlPrincipal = new JPanel();
                pnlPrincipal.setPreferredSize(new Dimension(450,560));
                pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.Y_AXIS));
                pnlPrincipal.add(lblTitulo, BorderLayout.NORTH);
                pnlPrincipal.add(webcamPanel, BorderLayout.LINE_START);
                pnlPrincipal.add(btnShoot, BorderLayout.LINE_END);
                
                PnlOptions pnlOptions = new PnlOptions();
                
                //para elegir un archivo
                pnlOptions.getPnlGuardar().getBtnGuardar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    System.out.println("Ejecutar los procesos de imagen");
                    
                    String archivoActual = pnlOptions.getPnlChooseFile().getTxtNombre().getText();
                    archivoActual = archivoActual.trim();
                    
                        System.out.println("Imagen actual = "+archivoActual);
                    //get the name and set it 
                    String name = pnlOptions.getPnlGuardar().getTxtNombre().getText();
                    name = name.trim();
                        System.out.println("Nombre del archivo: "+name);
                    
                    if(archivoActual=="" || archivoActual==null){
                        //decir que ingrese un nombre
                    }else {
                        //COMIENZA LA TRANSFORMACION
                        System.out.println("**************** Comienza el tratamiento de la imagen ***************");
                        Imagen image = new Imagen();
                        
                        BufferedImage bImage = image.readImage(archivoActual);
                    
                        System.out.println("Opciones marcadas");
                        
                        if(pnlOptions.getCheckGrises().isSelected()){
                            System.out.println("\tImage to gray scale");
                            bImage = image.toGrayScale(archivoActual);
                        }
                        if(pnlOptions.getCheckBN().isSelected()){
                            System.out.println("\tImage to black and white");
                            bImage = image.toBlackWhite(archivoActual);
                        }
                        if(pnlOptions.getCheckObtenerNegativoDeGris().isSelected()){
                            System.out.println("\tObtener el negativo de una imagen gris");
                            bImage = image.grayToNegative(archivoActual);
                        }
                        //formato
                        System.out.println("Formato elegido");
                        int formato = pnlOptions.getComboFormat().getSelectedIndex();
                        System.out.println(" selected index ");
                        String formatoCadena = null; 
                        String outputDir = dir+name;
                        
                        switch(formato){
                            case 0: outputDir = outputDir.concat(".gif"); image.writeGIFImage(bImage, outputDir); 
                                System.out.println("\tGif");break;
                            case 1: outputDir = outputDir.concat(".png"); image.writePNGImage(bImage, outputDir);
                                System.out.println("\tPNG");break;
                            case 2: outputDir = outputDir.concat(".jpg"); image.writeJPGImage(bImage, outputDir); 
                                System.out.println("\tJPG");break;
                            default: formatoCadena = "jpg";
                        }
                    }
                    
                    //archivoActual = pnlOptions.getPnlChooseFile().getTxtNombre().getText();
                    //archivoActual = archivoActual.trim();
                    }
                });
                
                add(pnlPrincipal);
                add(pnlOptions);
                
		pack();
		setVisible(true);

		Thread t = new Thread() {
			@Override
			public void run() {
				webcamPanel.start();
			}
		};
		t.setName("example-starter");
		t.setDaemon(true);
		t.setUncaughtExceptionHandler(this);
		t.start();
	}

	public static void main(String[] args) {
            System.out.println("Aplicacion de la camara");
            SwingUtilities.invokeLater(new WebcamViewerExample());
	}

    public Integer getCont() {
        return cont;
    }

    public void setCont(Integer cont) {
        this.cont = cont;
    }
        
        

	@Override
	public void webcamOpen(WebcamEvent we) {
		System.out.println("webcam open");
	}

	@Override
	public void webcamClosed(WebcamEvent we) {
		System.out.println("webcam closed");
	}

	@Override
	public void webcamDisposed(WebcamEvent we) {
		System.out.println("webcam disposed");
	}

	@Override
	public void webcamImageObtained(WebcamEvent we) {
		// do nothing
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
		webcam.close();
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("webcam viewer resumed");
		webcamPanel.resume();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("webcam viewer paused");
		webcamPanel.pause();
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.err.println(String.format("Exception in thread %s", t.getName()));
		e.printStackTrace();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
            System.out.println("Item event");
            
		if (e.getItem() != webcam) {
			if (webcam != null) {
                            System.out.println("Webcam!=null");
				webcamPanel.stop();

				remove(webcamPanel);

				webcam.removeWebcamListener(this);
                                System.out.println("Invoca a webcam.close()");
				webcam.close();

                                System.out.println("Re start webcam = (Webcam) e.getItem()");
				webcam = (Webcam) e.getItem();
				webcam.setViewSize(WebcamResolution.VGA.getSize());
				webcam.addWebcamListener(this);

				System.out.println("selected " + webcam.getName());

				webcamPanel = new WebcamPanel(webcam, false);
				webcamPanel.setFPSDisplayed(true);

				add(webcamPanel, BorderLayout.CENTER);
				pack();

				Thread t = new Thread() {

					@Override
					public void run() {
						webcamPanel.start();
					}
				};
				t.setName("example-stoper");
				t.setDaemon(true);
				t.setUncaughtExceptionHandler(this);
				t.start();
			}
		}
	}

	@Override
	public void webcamFound(WebcamDiscoveryEvent event) {
		if (picker != null) {
			picker.addItem(event.getWebcam());
		}
	}

	@Override
	public void webcamGone(WebcamDiscoveryEvent event) {
		if (picker != null) {
			picker.removeItem(event.getWebcam());
		}
	}
}

