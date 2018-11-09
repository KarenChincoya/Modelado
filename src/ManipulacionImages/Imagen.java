/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManipulacionImages;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Karen Velasco
 */
public class Imagen {
    
    private BufferedImage imagen;
    
    public Imagen(){
        
    }
    
    public Imagen(BufferedImage image){
        this.imagen = image;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }
    
    
    public BufferedImage toGrayScale(String inputDir){
        BufferedImage image = this.readImage(inputDir);
        System.out.println("Imagen = "+inputDir);
        //escala de grises
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color colorAux = new Color(image.getRGB(i, j));
                int mediaRGB = (colorAux.getRed() + colorAux.getGreen() + colorAux.getBlue()) / 3;
                int rgb = (mediaRGB << 16) | (mediaRGB << 8) | mediaRGB;
                image.setRGB(i, j, rgb);
            }
        }
        return image;
    }
    public BufferedImage toBlackWhite(String inputDir){
        int umbral = 0;
        BufferedImage image = this.readImage(inputDir);
        String res = JOptionPane.showInputDialog(null, "Umbral:", "Ingresar umbral", JOptionPane.QUESTION_MESSAGE);
        umbral = Integer.parseInt(res);
        
        for (int i = 0; i < image.getWidth(); i++) {
                    for (int j = 0; j < image.getHeight(); j++) {
                        Color colorAux = new Color(image.getRGB(i, j));
                        int promedio = (colorAux.getRed() + colorAux.getGreen() + colorAux.getBlue()) / 3;
                        int pixel = (promedio >= umbral) ? 255 : 0;
                        int rgb = (pixel << 16) | (pixel << 8) | pixel;
                        image.setRGB(i, j, rgb);
                    }
                }
        return image;
    }
    public BufferedImage grayToNegative(String inputDir){
        BufferedImage image = this.readImage(inputDir);
        
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color colorAux = new Color(image.getRGB(i, j));
                int mediaRGB = (colorAux.getRed() + colorAux.getGreen() + colorAux.getBlue()) / 3;
                mediaRGB = 255 - mediaRGB;
                int rgb = (mediaRGB << 16) | (mediaRGB << 8) | mediaRGB;
                image.setRGB(i, j, rgb);
            }
        }
        
        return image;
    }
    
    public BufferedImage recortar(String inputDir, double pX, double pY){
        BufferedImage image = this.readImage(inputDir);
        
        int newWidth = (int) (image.getWidth() * pX / 100);
        int newHeight = (int) (image.getHeight() * pY / 100);
        
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, type);

        for(int x=0; x<newWidth; x++){
            for(int y=0; y<newHeight; y++){
                Color colorAux = new Color(image.getRGB(x, y));
                int alpha = colorAux.getAlpha();
                int rojo = colorAux.getRed();
                int verde = colorAux.getGreen();
                int azul = colorAux.getBlue();
                int rgb =  alpha << 24 | (rojo << 16) |  (verde << 8) | azul;

                newImage.setRGB(x, y, rgb);
            }
        }
        
        return newImage;
    }
    //intervalo
    public BufferedImage dibujarLinea(BufferedImage image, Integer porcentaje, Integer puntoMedio){
         //inicio y fin 
         //enviaras el x medio
         int grosor = (int) (image.getWidth()*porcentaje/100);
         
         int puntoInicio = puntoMedio-(grosor/2);
         int puntoFinal = puntoMedio + (grosor/2);
         
         for(int x=puntoInicio; x<puntoFinal; x++){
            for(int y=0; y<image.getHeight(); y++){
                int pixel = 0;
                int rgb = (pixel << 16) | (pixel << 8) | pixel;
                image.setRGB(x, y, rgb);
            }
         }
         
        return image;
    }
    
    public BufferedImage dibujarX(String inputDir){
        BufferedImage image = this.readImage(inputDir);
        
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){//filas    
                int mediaRGB = 0;
                int rgb = (mediaRGB << 16) | (mediaRGB << 8) | mediaRGB;
                image.setRGB(x, y, rgb);
            }
        }
        
        return image;
    }
    
    public BufferedImage generarMarco(String inputDir){
        BufferedImage image = this.readImage(inputDir);
        
        BufferedImage imageBack = this.readImage(inputDir);
        
        int newWidth = (int) (image.getWidth()*0.05);
        int newHeight = (int) (image.getHeight()*0.05);
        
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){//filas
                //dibujar el color negro
                int mediaRGB = 0;
                int rgb = (mediaRGB << 16) | (mediaRGB << 8) | mediaRGB;
                image.setRGB(x, y, rgb);
            }
        }
        //Pintar la otra
        for(int x=newWidth; x<(image.getWidth()-newWidth); x++){
            for(int y=newHeight; y<(image.getHeight()-newHeight); y++){//filas        
                //dibujar el color negro
                Color colorAux = new Color(imageBack.getRGB(x, y));
                int rojo = colorAux.getRed();
                int verde = colorAux.getGreen();
                int azul = colorAux.getBlue();
                int rgb = (rojo << 16) | (verde << 8) | azul;
                image.setRGB(x, y, rgb);
            }
        }
        
        return image;
    }
    
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir")+"/src/images/";
        
        String inputDir1 = dir.concat("tren.jpg");
        String outDir1 = dir.concat("transpuesta.png");
        String outDir2 = dir.concat("brillo.png");
        String outDir3 = dir.concat("recortadaHorizontal.png");
        String outDir4 = dir.concat("recortadaVertical.png");
        String outDir5 = dir.concat("rotada90.png");
        String outDir6 = dir.concat("rotada180.png");
        String outDir7 = dir.concat("rotada270.png");
        
        Imagen image = new Imagen();

        BufferedImage imagen = image.readImage(inputDir1);
        
        //1. Transpuesta de una imagen: las filas se cambian por las columnas
        BufferedImage transpuesta = image.getTranspuesta(inputDir1);
        image.writePNGImage(transpuesta, outDir1);
        
        //2. Brillo de una imagen
        BufferedImage brillo = image.Brillo(inputDir1, 0.5);
        image.writePNGImage(brillo, outDir2);
        
        //3.1 Recortar una imagen a la mitad horizontal
        BufferedImage recortadaH = image.recortar(inputDir1, 100, 50);
        image.writePNGImage(recortadaH, outDir3);
        
        //3.2 Recortar una imagen a la mitad vertical
        BufferedImage recortadaV = image.recortar(inputDir1, 50, 100);
        image.writePNGImage(recortadaV, outDir4);
        
        //4.1 Rotar la imagen 90
        BufferedImage rotada90 = image.rotar90(inputDir1);
        image.writePNGImage(rotada90, outDir5);
        
        //4.2 Rotar la imagen 180
        BufferedImage rotada180 = image.rotar180(outDir3);
        image.writePNGImage(rotada180, outDir6);
        
        //4.3 Rotar la imagen 270
        BufferedImage rotada270 = image.rotar270(inputDir1);
        image.writePNGImage(rotada270, outDir7);
        
        System.out.println("fin");
    }
    
    public BufferedImage Brillo(String inputDir, double porcentajeBrillo) {
        BufferedImage image = this.readImage(inputDir);
        int brillo = (int) (255*porcentajeBrillo);        
        
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color colorAux = new Color(image.getRGB(i, j));
                int rojo = colorAux.getRed();
                int verde = colorAux.getGreen();
                int azul = colorAux.getBlue();
                int pixel;

                rojo = rojo + brillo;
                verde = verde + brillo;
                azul = azul + brillo;

                if ((rojo > 255) || (verde > 255) || (azul > 255)) {
                    rojo = 255;
                    verde = 255;
                    azul = 255;
                }
                Color nuevo = new Color(rojo, verde, azul);
                pixel = nuevo.getRGB();
                image.setRGB(i, j, pixel);
            }
        }

        return image;
    }
    
    public BufferedImage getTranspuesta(String inputDir){
        BufferedImage imagenOriginal = this.readImage(inputDir);
        
        int type = imagenOriginal.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : imagenOriginal.getType();
        
        int newWidth = imagenOriginal.getHeight();
        int newHeight = imagenOriginal.getWidth();
        
        BufferedImage result = new BufferedImage(newWidth, newHeight, type);
        
        //vas a rellenar la nueva
        for(int c=0; c<newWidth; c++){
            for(int f=0; f<newHeight; f++){
                //obtienes el color
                Color color = new Color(imagenOriginal.getRGB(f,c));
                int rgb = (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
                result.setRGB(c, f, rgb);//asigna por columnas
            }
        }
        
        return result;
    }
    
    public BufferedImage rotar90(String inputDir){
        BufferedImage image = this.readImage(inputDir);
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resultado = new BufferedImage(image.getHeight(), image.getWidth(), type);

        if(resultado!=null){
        //rotarlo 90 grados 
            for(int f=0; f<resultado.getHeight(); f++){
                for(int c=0; c<resultado.getWidth(); c++){
                    int x = image.getWidth()-f-1;
                    int y = c;
                    Color color = new Color(image.getRGB(x, y));
                    int rgb = (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
                
                    resultado.setRGB(c, f, rgb);
                }
            }
        }
        
        
        return resultado;
    }
    
    public BufferedImage rotar270(String inputDir){
        BufferedImage image = this.readImage(inputDir);
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resultado = new BufferedImage(image.getHeight(), image.getWidth(), type);

        if(resultado!=null){
        //rotarlo 90 grados 
            for(int f=0; f<resultado.getHeight(); f++){
                for(int c=0; c<resultado.getWidth(); c++){
                    int x = f;
                    int y = image.getHeight()-c-1;
                    Color color = new Color(image.getRGB(x,y));
                    int rgb = (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
                
                    resultado.setRGB(c, f, rgb);
                }
            }
        }
        
        
        return resultado;
    }
    
    public BufferedImage rotar180(String inputDir){
        BufferedImage image = this.readImage(inputDir);
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resultado = new BufferedImage(image.getWidth(), image.getHeight(), type);

        if(resultado!=null){
        //rotarlo 90 grados 
            for(int f=0; f<resultado.getHeight(); f++){
                for(int c=0; c<resultado.getWidth(); c++){
                    int x = c;
                    int y = f;
                    Color color = new Color(image.getRGB(image.getWidth()-x-1, image.getHeight()-y-1));
                    int rgb = (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
                
                    resultado.setRGB(c, f, rgb);
                }
            }
        }
        
        
        return resultado;
    }
    
    public BufferedImage getInverso255(BufferedImage image, int u1, int u2){
        //imagen gris
        int valor = 255;
        
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){
                Color color = new Color(image.getRGB(x, y));
                int mediaRGB = color.getRed();
                int rgb = (valor << 16) | (valor << 8) | valor;
                
                if(mediaRGB<u1 || mediaRGB>u2){
                    image.setRGB(x, y, rgb);
                }
            }
        }
        return image;        
    }
    
    public BufferedImage getInverso0(BufferedImage image, int u1, int u2){
        //imagen gris
        int valor = 0;
        
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){
                Color color = new Color(image.getRGB(x, y));
                int mediaRGB = color.getRed();
                int rgb = (valor << 16) | (valor << 8) | valor;
                
                if(mediaRGB<u1 || mediaRGB>u2){
                    image.setRGB(x, y, rgb);
                }
            }
        }
        return image;        
    }
    
    public BufferedImage getInversoBinario0(BufferedImage image, int u1, int u2){
        //imagen gris
        int valor1 = 0;
        int valor2 = 255;
        
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){
                Color color = new Color(image.getRGB(x, y));
                
                int mediaRGB = color.getRed();
                int rgb0 = (valor1 << 16) | (valor1 << 8) | valor1;
                int rgb255 = (valor2 << 16) | (valor2 << 8) | valor2;
                
                if(mediaRGB<u1 || mediaRGB>u2){
                    image.setRGB(x, y, rgb0);
                }else{
                    image.setRGB(x, y, rgb255);
                }
            }
        }
        return image;        
    }
    
    public BufferedImage getInversoBinario255(BufferedImage image, int u1, int u2){
        //imagen gris
        int valor1 = 0;
        int valor2 = 255;
        
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){
                Color color = new Color(image.getRGB(x, y));
                
                int mediaRGB = color.getRed();
                int rgb0 = (valor1 << 16) | (valor1 << 8) | valor1;
                int rgb255 = (valor2 << 16) | (valor2 << 8) | valor2;
                
                if(mediaRGB<u1 || mediaRGB>u2){
                    image.setRGB(x, y, rgb255);
                }else{
                    image.setRGB(x, y, rgb0);
                }
            }
        }
        return image;        
    }
    
    public BufferedImage grayImageFunction100(String inputDir){
        BufferedImage image = this.readImage(inputDir);
        
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color colorAux = new Color(image.getRGB(i, j));
                int mediaRGB = colorAux.getRed();

                mediaRGB = (mediaRGB+100)%256;
                int rgb = (mediaRGB << 16) | (mediaRGB << 8) | mediaRGB;

                image.setRGB(i, j, rgb);
            }
        }
        
        return image;
    }
    
    public BufferedImage rgbToNegative(String inputDir){
       BufferedImage image = this.readImage(inputDir);
       
       for (int i = 0; i < image.getWidth(); i++) {
          for (int j = 0; j < image.getHeight(); j++) {
             Color colorAux = new Color(image.getRGB(i, j));
             int rojo = colorAux.getRed();
             int verde = colorAux.getGreen();
             int azul = colorAux.getBlue();
             int pixel;

             rojo = 255 - rojo;
             verde = 255 - verde;
             azul = 255 - azul;
             Color nuevo = new Color(rojo, verde, azul);
             pixel = nuevo.getRGB();
             image.setRGB(i, j, pixel);
          }
       }
       
       return image;
    }
    
    
    public BufferedImage neighborhood(String inputDir) {
        BufferedImage image = this.readImage(inputDir);
        
        int[] equis = {0, 0, 1, 1, 1, 0, -1, -1, -1};
        int[] yes = {0, -1, -1, 0, 1, 1, 1, 0, -1};
        int r = 0;
        int g = 0;
        int b = 0;

        for (int x = 1; x < 30; x = x + 3) {
            for (int y = 1; y < 30; y = y + 3) {
                Color color = getGrayAverage(x, y, image);
                for (int f = 0; f < equis.length; f++) {
                    int pixel = color.getRGB();
                    pixel = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                    System.out.println("[" + pixel + "]");
                    image.setRGB(x + equis[f], y + yes[f], pixel);
                }
            }
        }

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                Color color = new Color(image.getRGB(j, i));
                int pixel = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                System.out.print("[" + pixel + "]");
            }
            System.out.print("\n\n");
        }

        return image;
    }

    private static Color getGrayAverage(int x, int y, BufferedImage img) {
        int[] equis = {0, 0, 1, 1, 1, 0, -1, -1, -1};
        int[] yes = {0, -1, -1, 0, 1, 1, 1, 0, -1};
        int r = 0;
        int g = 0;
        int b = 0;

        for (int f = 0; f < 9; f++) {
            Color color = new Color(img.getRGB(x + equis[f], y + yes[f]));
            r += color.getRed();
            g += color.getGreen();
            b += color.getBlue();
        }

        r /= 9;
        g /= 9;
        b /= 9;

        return new Color(r, g, b);
    }
    
    public BufferedImage readImage(String inputDir){
        BufferedImage image = null;
        //READ IMAGE
	try {
            File input_file = new File(inputDir);
            image = ImageIO.read(input_file);
            System.out.println("Reading complete.");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: "+e);
	}
        return image;
    }
    
    public void writeJPGImage(BufferedImage image, String outputDir){
        try {
            File output_file = new File(outputDir);
            ImageIO.write(image, "jpg", output_file);
            System.out.println("Writing complete");
	} catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: "+e);
	}
    }
    
    public void writePNGImage(BufferedImage image, String outputDir){
        try {
            File output_file = new File(outputDir);
            ImageIO.write(image, "png", output_file);
            System.out.println("Writing complete");
	} catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: "+e);
	}
    }
    
    public void writeGIFImage(BufferedImage image, String outputDir){
        try {
            File output_file = new File(outputDir);
            ImageIO.write(image, "gif", output_file);
            System.out.println("Writing complete");
	} catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: "+e);
	}
    }
    
}
