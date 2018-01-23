package recursos.Soporte;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conector {

    public static Connection cnx = null;

    public static Connection obtener() {
       
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/uecr", "root", "root");
            } catch (ClassNotFoundException ex) {
                Herramientas.MensajeErr("Error mysql: " + ex.getMessage(), "Error de conexión mysql");
                Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Herramientas.MensajeErr("Error mysql: " + ex.getMessage(), "Error de conexión mysql");
                Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        return cnx;
    }
  
    public static void cerrar() {
        if (cnx != null) {
            try {
                cnx.close();
            } catch (SQLException ex) {
                Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void cerrar(ResultSet _rs){
        if(_rs!=null){
            try {
                if(!_rs.isClosed())
                    _rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    public static void rollBack(){
        try {
            cnx.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean estadoConexion() {
        try {
            cnx.ping();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
