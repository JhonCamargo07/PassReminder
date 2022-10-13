package validations;

import ModelVO.UserVO;
import static java.awt.image.ImageObserver.HEIGHT;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import views.Index;

/**
 *
 * @author Camargo
 */
public class Validacion {

    public Validacion() {
    }
    
    public static boolean isSessionActive(){
        if(UserVO.getIdSesion() <= 0){
            Index index = new Index();
            index.setVisible(true);
            return false;
        }
        return true;
    }

    public boolean esDatoValido(String nombreCampo, String campo, int caracteresMinimos, int caracteresMaximos) {
        if (campo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe proporcionar " + nombreCampo, "Error en los datos", HEIGHT);
            return false;
        } else if (campo.length() < caracteresMinimos) {
            JOptionPane.showMessageDialog(null, "La cantidad de caracteres minimos para " + nombreCampo + " es " + caracteresMinimos, "Error en los datos", HEIGHT);
            return false;
        } else if (campo.length() > caracteresMaximos) {
            JOptionPane.showMessageDialog(null, "La cantidad de caracteres máximos para " + nombreCampo + " es " + caracteresMaximos, "Error en los datos", HEIGHT);
            return false;
        }
        return true;
    }
    
    public boolean isEmail(String email){
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
           return true;
        } else {
           JOptionPane.showMessageDialog(null, "El correo que ingresó no es valido, ingrese un correo valido", "Error en el correo", HEIGHT);
           return false;
        }
    }

}
