package recursos.Soporte;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class PlayAudio {
    private void Reproducir(int ID){
        try {
            InputStream in = null;
            if (ID ==1)
                in = getClass().getResourceAsStream("/Sonidos/Error.wav");
            if(ID == 2 || ID == 3)
                in = getClass().getResourceAsStream("/Sonidos/Informacion.wav");
            if(ID==4)
                in = getClass().getResourceAsStream("/Sonidos/Advertencia.wav");
            if(ID==5)
                in = getClass().getResourceAsStream("/Sonidos/Guardar.wav");
            if(ID == 6)
                in =getClass().getResourceAsStream("/Sonidos/Borrar.wav");
          
            AudioStream audio  =  new AudioStream(in);
            AudioPlayer.player.start(audio);
        } catch (FileNotFoundException ex) {
            Herramientas.MensajeErr(ex.getMessage());
        } catch (IOException ex) {
            Herramientas.MensajeErr(ex.getMessage());
        }                 
    }
    public void Error(){
        Reproducir(1);
    }
    public void Pregunta(){
        Reproducir(2);
    }
    public void Informacion(){
        Reproducir(3);
    }
    public void Advertencia(){
        Reproducir(4);
    }
    public void Guardar(){
        Reproducir(5);
    }
    public void Borrar(){
        Reproducir(6);
    }
    
}
