
package recursos.Soporte;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class CambiarIconosEmergentes {
    public CambiarIconosEmergentes(){
         Object error = LookAndFeel.makeIcon(getClass(),"/Iconos/Error.png");
        Object warn = LookAndFeel.makeIcon(getClass(),"/Iconos/Warnin.png");
        Object Quest = LookAndFeel.makeIcon(getClass(),"/Iconos/Question.png");
        Object Info = LookAndFeel.makeIcon(getClass(),"/Iconos/Info.png");
        UIManager.put("OptionPane.errorIcon",error);
        UIManager.put("OptionPane.warningIcon",warn);
        UIManager.put("OptionPane.questionIcon",Quest);
        UIManager.put("OptionPane.informationIcon", Info);
    }
}