package recursos.Soporte;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
public class FondoEscritorio implements Border{
    public BufferedImage back;
 
    public FondoEscritorio(String dir){
        try {
            URL imagePath = new URL(dir);
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
    }
     public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         //Imagen centrada y maximizada
     // g.drawImage(back, (x + (width - back.getWidth())/2),(y + (height - back.getHeight())/2), null);
     //Imagen expandida
     g.drawImage(back, 0,0,width,height, null);
     
      //g.drawImage(back, 0,0,back.getWidth(),back.getHeight(), null);
   
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0,0);
    }
 
    public boolean isBorderOpaque() {
        return true;
    }
 
}