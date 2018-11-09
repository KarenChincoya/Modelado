
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.Thread.UncaughtExceptionHandler;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Proof of concept of how to handle webcam video stream from Java
 *
 * @author Bartosz Firyn (SarXos)
 */
public class WebcamViewerExample extends JFrame implements ActionListener, Runnable, WebcamListener, WindowListener, UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener {

    private static final long serialVersionUID = 1L;

    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private WebcamPicker picker = null;
    
    private JButton boton = new JButton("Tomar Foto");
    
    private JRadioButton rbtn1 = new JRadioButton("PNG", true);
    private JRadioButton rbtn2 = new JRadioButton("JPG", false);
    private JRadioButton rbtn3 = new JRadioButton("GIF", false);
    private JPanel panelito;
    
    private static int ancho = 0;
    private static int alto = 0;
    private static int umbral = 0;

    @Override
    public void run() {

        Webcam.addDiscoveryListener(this);

        setTitle("Hola mundo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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

        panel = new WebcamPanel(webcam, false);
        panel.setFPSDisplayed(true);

        add(picker, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        panelito = new JPanel();
        panelito.add(boton, BorderLayout.CENTER);
        add(panelito, BorderLayout.SOUTH);

        boton.addActionListener(this);

        pack();
        setVisible(true);

        Thread t = new Thread() {

            @Override
            public void run() {
                panel.start();
            }
        };
        t.setName("example-starter");
        t.setDaemon(true);
        t.setUncaughtExceptionHandler(this);
        t.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new WebcamViewerExample());
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
        panel.resume();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("webcam viewer paused");
        panel.pause();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println(String.format("Exception in thread %s", t.getName()));
        e.printStackTrace();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() != webcam) {
            if (webcam != null) {

                panel.stop();

                remove(panel);

                webcam.removeWebcamListener(this);
                webcam.close();

                webcam = (Webcam) e.getItem();
                webcam.setViewSize(WebcamResolution.VGA.getSize());
                webcam.addWebcamListener(this);

                System.out.println("selected " + webcam.getName());

                panel = new WebcamPanel(webcam, false);
                panel.setFPSDisplayed(true);

                add(panel, BorderLayout.CENTER);
                pack();

                Thread t = new Thread() {

                    @Override
                    public void run() {
                        panel.start();
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        int a = 0;

        if (ae.getSource() == boton) {
            
// get image
            BufferedImage image = webcam.getImage();
            
            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();

            JRadioButton button1 = new JRadioButton("PNG");
            JRadioButton button2 = new JRadioButton("JPG");
            JRadioButton button3 = new JRadioButton("GIF");
            ButtonGroup grupo = new ButtonGroup();
            grupo.add(button1);
            grupo.add(button2);
            grupo.add(button3);
            panel.add(button1);
            panel.add(button2);
            panel.add(button3);
            JOptionPane.showMessageDialog(null, panel);

            JRadioButton but1 = new JRadioButton("160 x 200");
            JRadioButton but2 = new JRadioButton("200 x 400");
            JRadioButton but3 = new JRadioButton("600 x 800");
            JRadioButton but4 = new JRadioButton("30 x 30");
            ButtonGroup group = new ButtonGroup();
            group.add(but1);
            group.add(but2);
            group.add(but3);
            group.add(but4);
            panel2.add(but1);
            panel2.add(but2);
            panel2.add(but3);
            panel2.add(but4);
            JOptionPane.showMessageDialog(null, panel2);

            JRadioButton btn1 = new JRadioButton("RGB");
            JRadioButton btn2 = new JRadioButton("Escala de grises");
            JRadioButton btn3 = new JRadioButton("B/N");
            JRadioButton btn4 = new JRadioButton("EG a negativo");
            JRadioButton btn5 = new JRadioButton("RGB a negativo");
            JRadioButton btn6 = new JRadioButton("Niveles de grises");
            JRadioButton btn7 = new JRadioButton("Histograma");
            
            ButtonGroup grp3 = new ButtonGroup();
            grp3.add(btn1);
            grp3.add(btn2);
            grp3.add(btn3);
            grp3.add(btn4);
            grp3.add(btn5);
            grp3.add(btn6);
            grp3.add((btn7));
            
            panel3.add(btn1);
            panel3.add(btn2);
            panel3.add(btn3);
            panel3.add(btn4);
            panel3.add(btn5);
            panel3.add(btn6);
            panel3.add(btn7);
            
            JOptionPane.showMessageDialog(null, panel3);

            if (btn3.isSelected()) {
                String res = JOptionPane.showInputDialog(null, "Umbral:", "Ingresar umbral", JOptionPane.QUESTION_MESSAGE);
                umbral = Integer.parseInt(res);
            }

            if (button1.isSelected() && but1.isSelected()) {
                ancho = 160;
                alto = 200;
                try {
                    ImageIO.write(image, "PNG", new File("test.png"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.png"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.png"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (button1.isSelected() && but2.isSelected()) {
                ancho = 200;
                alto = 400;
                try {
                    ImageIO.write(image, "PNG", new File("test.png"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.png"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.png"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (button1.isSelected() && but3.isSelected()) {
                ancho = 600;
                alto = 800;
                try {
                    ImageIO.write(image, "PNG", new File("test.png"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.png"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.png"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (button2.isSelected() && but1.isSelected()) {
                ancho = 160;
                alto = 200;
                try {
                    ImageIO.write(image, "JPG", new File("test.jpg"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.jpg"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (button2.isSelected() && but2.isSelected()) {
                ancho = 200;
                alto = 400;
                try {
                    ImageIO.write(image, "JPG", new File("test.jpg"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.jpg"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (button2.isSelected() && but3.isSelected()) {
                ancho = 600;
                alto = 800;
                try {
                    ImageIO.write(image, "JPG", new File("test.jpg"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.jpg"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (button3.isSelected() && but1.isSelected()) {
                ancho = 160;
                alto = 200;
                try {
                    ImageIO.write(image, "GIF", new File("test.gif"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.gif"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.gif"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (button3.isSelected() && but2.isSelected()) {
                ancho = 200;
                alto = 400;
                try {
                    ImageIO.write(image, "GIF", new File("test.gif"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.gif"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.gif"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (button3.isSelected() && but3.isSelected()) {
                ancho = 600;
                alto = 800;
                try {
                    ImageIO.write(image, "GIF", new File("test.gif"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.gif"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = null;
                    if (btn2.isSelected()) {
                        editedImage = conversion(originalImage, 2);
                    } else if (btn3.isSelected()) {
                        editedImage = conversion(originalImage, 3);
                    } else if (btn4.isSelected()) {
                        editedImage = conversion(originalImage, 4);
                    } else if (btn5.isSelected()) {
                        editedImage = conversion(originalImage, 5);
                    } else if (btn6.isSelected()) {
                        editedImage = conversion(originalImage, 6);
                    } else {
                        editedImage = conversion(originalImage, 1);
                    }

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "GIF", new File("test.gif"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (but4.isSelected()) {
                ancho = 30;
                alto = 30;
                try {
                    ImageIO.write(image, "PNG", new File("test.png"));
                    System.out.println("Listo");
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }

                BufferedImage originalImage = null;
                try {
                    originalImage = ImageIO.read(new File("test.png"));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage editedImage = conversion(originalImage, 2);
                    editedImage = laDelChavo(editedImage);

                    BufferedImage resizeImageJpg = resizeImage(editedImage, type);
                    ImageIO.write(resizeImageJpg, "PNG", new File("test.png"));
                } catch (IOException ex) {
                    Logger.getLogger(WebcamViewerExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    private static BufferedImage conversion(BufferedImage imagen, int opc) {

        switch (opc) {
            case 2:
                //escala de grises
                for (int i = 0; i < imagen.getWidth(); i++) {
                    for (int j = 0; j < imagen.getHeight(); j++) {
                        Color colorAux = new Color(imagen.getRGB(i, j));
                        int mediaRGB = (colorAux.getRed() + colorAux.getGreen() + colorAux.getBlue()) / 3;
                        int rgb = (mediaRGB << 16) | (mediaRGB << 8) | mediaRGB;
                        imagen.setRGB(i, j, rgb);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < imagen.getWidth(); i++) {
                    for (int j = 0; j < imagen.getHeight(); j++) {
                        Color colorAux = new Color(imagen.getRGB(i, j));
                        int promedio = (colorAux.getRed() + colorAux.getGreen() + colorAux.getBlue()) / 3;
                        int pixel = (promedio >= umbral) ? 255 : 0;
                        int rgb = (pixel << 16) | (pixel << 8) | pixel;
                        imagen.setRGB(i, j, rgb);
                    }
                }
                break;
            case 1:
                for (int i = 0; i < imagen.getWidth(); i++) {
                    for (int j = 0; j < imagen.getHeight(); j++) {
                        Color colorAux = new Color(imagen.getRGB(i, j));
                        int rojo = colorAux.getRed();
                        int verde = colorAux.getGreen();
                        int azul = colorAux.getBlue();
                        int pixel;
                        if (rojo > verde && rojo > azul) {
                            rojo = 255;
                            verde = 0;
                            azul = 0;
                        }
                        if (verde > azul && verde > rojo) {
                            rojo = 0;
                            verde = 255;
                            azul = 0;
                        }
                        if (azul > verde && azul > rojo) {
                            rojo = 0;
                            verde = 0;
                            azul = 255;
                        }
                        Color nuevo = new Color(rojo, verde, azul);
                        pixel = nuevo.getRGB();
                        //int rgb=(pixel<<16) | (pixel<<8) | pixel;
                        imagen.setRGB(i, j, pixel);
                    }
                }
            case 4:
                for (int i = 0; i < imagen.getWidth(); i++) {
                    for (int j = 0; j < imagen.getHeight(); j++) {
                        Color colorAux = new Color(imagen.getRGB(i, j));
                        int mediaRGB = (colorAux.getRed() + colorAux.getGreen() + colorAux.getBlue()) / 3;
                        mediaRGB = 255 - mediaRGB;
                        int rgb = (mediaRGB << 16) | (mediaRGB << 8) | mediaRGB;
                        imagen.setRGB(i, j, rgb);
                    }
                }
                break;

            case 5:
                //de rgb a negativo
                for (int i = 0; i < imagen.getWidth(); i++) {
                    for (int j = 0; j < imagen.getHeight(); j++) {
                        Color colorAux = new Color(imagen.getRGB(i, j));
                        int rojo = colorAux.getRed();
                        int verde = colorAux.getGreen();
                        int azul = colorAux.getBlue();
                        int pixel;

                        rojo = 255 - rojo;
                        verde = 255 - verde;
                        azul = 255 - azul;
                        Color nuevo = new Color(rojo, verde, azul);
                        pixel = nuevo.getRGB();
                        imagen.setRGB(i, j, pixel);
                    }
                }
                break;

            case 6:
                String escala = JOptionPane.showInputDialog(null, "Ingresa nivel de gris (4, 8, 16, 32)", "Escalar gris", JOptionPane.QUESTION_MESSAGE);
                int escalaNum = Integer.valueOf(escala);
                int f=255/escalaNum;
                
                for (int i = 0; i < imagen.getWidth(); i++) {
                    for (int j = 0; j < imagen.getHeight(); j++) {
                        
                        Color colorAux = new Color(imagen.getRGB(i, j));
                        int mediaRGB = (colorAux.getRed() + colorAux.getGreen() + colorAux.getBlue()) / 3;
                        
                        mediaRGB = (mediaRGB / f) * f;
                        System.out.println(mediaRGB);
                        
                        int rgb = (mediaRGB << 16) | (mediaRGB << 8) | mediaRGB;
                        imagen.setRGB(i, j, rgb);
                    }
                }
                break;
                
            case 7://histograma
                break;
            case 8:
                
                break;
            default://rgb se queda igual

                break;
        }
        return imagen;
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(ancho, alto, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, ancho, alto, null);
        g.dispose();

        return resizedImage;
    }

    private static BufferedImage laDelChavo(BufferedImage imgGris) {
        int[] equis = {0, 0, 1, 1, 1, 0, -1, -1, -1};
        int[] yes = {0, -1, -1, 0, 1, 1, 1, 0, -1};
        int r = 0;
        int g = 0;
        int b = 0;

        for (int y = 1; y < 30; y = y + 3) {
            for (int x = 1; x < 30; x = x + 3) {
                Color chusma = promedioGris(x, y, imgGris);
                for (int f = 0; f < equis.length; f++) {
                    int pixel = chusma.getRGB();
                    pixel = (chusma.getRed() + chusma.getGreen() + chusma.getBlue()) / 3;
                    System.out.println("[" + pixel + "]");
                    imgGris.setRGB(x + equis[f], y + yes[f], pixel);
                }
            }
        }

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                Color coca = new Color(imgGris.getRGB(j, i));
                int pixel = (coca.getRed() + coca.getGreen() + coca.getBlue()) / 3;
                System.out.print("[" + pixel + "]");
            }
            System.out.print("\n\n");
        }

        return imgGris;
    }

    private static Color promedioGris(int x, int y, BufferedImage img) {
        int[] equis = {0, 0, 1, 1, 1, 0, -1, -1, -1};
        int[] yes = {0, -1, -1, 0, 1, 1, 1, 0, -1};
        int r = 0;
        int g = 0;
        int b = 0;

        for (int f = 0; f < 9; f++) {
            Color kiko = new Color(img.getRGB(x + equis[f], y + yes[f]));
            r += kiko.getRed();
            g += kiko.getGreen();
            b += kiko.getBlue();
        }

        r /= 9;
        g /= 9;
        b /= 9;

        return new Color(r, g, b);
    }

}
