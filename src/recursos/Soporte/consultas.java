package recursos.Soporte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class consultas {

    /**
     * Cerrar conector despues de usar la consulta.
     *
     * @return
     */
    public static ResultSet obtenerAniosElectivos() {
        Statement stm = null;
        ResultSet rs = null;
        conector.obtener();
        try {
            stm = conector.cnx.createStatement();
            rs = stm.executeQuery("Select desde, hasta from electivo order by 1");
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al cargar años electivos.!\n" + ex.getMessage(), "Error mysql");
        }
        return rs;
    }
    
    public static boolean existeElectivo(int _desde) {
        PreparedStatement stm = null;
        boolean estado = false;
        ResultSet rs = null;
        conector.obtener();
        try {
            stm = conector.cnx.prepareStatement("SELECT desde from electivo where desde = ?");
            stm.setInt(1, _desde);
            rs = stm.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conector.cerrar();
        return false;
    }

    public static int guardarDatosEstudiante(String _nombres, String _Apellidos, String _genero, Date _fecha, String _alergia, boolean _srp01, boolean _srp02, boolean _hpv01, boolean _hpv02) {
        int id = 0;
        PreparedStatement pstm = null;
        String sSQL = "INSERT INTO persona (nombres, apellidos, genero, fechaNacimiento, alergia, SRP01, SRP02, HPV01, HPV02) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conector.obtener();
        try {
            pstm = conector.cnx.prepareStatement(sSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, _nombres);
            pstm.setString(2, _Apellidos);
            pstm.setString(3, _genero);
            pstm.setDate(4, new java.sql.Date(_fecha.getTime()));
            pstm.setString(5, _alergia);
            pstm.setBoolean(6, _srp01);
            pstm.setBoolean(7, _srp02);
            pstm.setBoolean(8, _hpv01);
            pstm.setBoolean(9, _hpv02);
            if (pstm.executeUpdate() > 0) {
                ResultSet rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Herramientas.MensajeErr("Error al guardar datos personales\n." + ex.getMessage(), "Error mysql");
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conector.cerrar();
        return id;

    }
 public static boolean actualizarDatosEstudiante(int _id, String _nombres, String _Apellidos, String _genero, Date _fecha, String _alergia, boolean _srp01, boolean _srp02, boolean _hpv01, boolean _hpv02) {
        int id = 0;
        PreparedStatement pstm = null;
        //UPDATE `uecr`.`persona` SET `apellidos`='Molina asdSantana' WHERE `id`='2';
        String sSQL = "UPDATE persona set nombres = ?, apellidos = ?, genero = ?, fechaNacimiento = ?, alergia = ?, SRP01 = ?, SRP02 = ?, HPV01 = ?, HPV02 = ? where id = ?";
        conector.obtener();
        try {
            pstm = conector.cnx.prepareStatement(sSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, _nombres);
            pstm.setString(2, _Apellidos);
            pstm.setString(3, _genero);
            pstm.setDate(4, new java.sql.Date(_fecha.getTime()));
            pstm.setString(5, _alergia);
            pstm.setBoolean(6, _srp01);
            pstm.setBoolean(7, _srp02);
            pstm.setBoolean(8, _hpv01);
            pstm.setBoolean(9, _hpv02);
            pstm.setInt(10, _id);
           return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            Herramientas.MensajeErr("Error al actualizar datos personales\n." + ex.getMessage(), "Error mysql");
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conector.cerrar();
        return false;

    }
    public static boolean insertaElectivo(int _desde, int _hasta) {
        boolean estado = true;
        PreparedStatement stm;
        conector.obtener();
        try {
            stm = conector.cnx.prepareStatement("INSERT INTO electivo(desde, hasta) values(?, ?)");
            stm.setInt(1, _desde);
            stm.setInt(2, _hasta);
            if (stm.executeUpdate() <= 0) {
                conector.cnx.rollback();
                estado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al guardar año electivo\n." + ex.getMessage(), "Error Mysql");
            estado = false;
        }
        conector.cerrar();
        return estado;
    }
    public static ResultSet obtenerRepresentante(int _idRepresentante){
        ResultSet rs = null;
        String sSQL = "Select nombres, apellidos, contacto from representante where id = ?";
        PreparedStatement pstm = null;
        conector.obtener();
        try {
            pstm = conector.cnx.prepareStatement(sSQL);
            pstm.setInt(1, _idRepresentante);
            return pstm.executeQuery();
        } catch (SQLException ex) {
            Herramientas.MensajeErr("Error al cargar representante\n"+ex.getMessage(),"Error Mysql");
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static int guardarRepresentante(String _nombres, String _apellidos, String _contactos) {
        int id = -1;
        PreparedStatement pstm = null;
        String sSQL = "Insert into representante(nombres, apellidos, contacto) values (?, ?, ?)";
        conector.obtener();
        try {
            pstm = conector.cnx.prepareStatement(sSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, _nombres);
            pstm.setString(2, _apellidos);
            pstm.setString(3, _contactos);
            if (pstm.executeUpdate() > 0) {
                ResultSet rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al guardar el representante.\n" + ex.getMessage(), "Error Mysql");
        }
        conector.cerrar();
        return id;
    }
   
public static boolean editarRepresentante(String _contacto,int _idRepresentante) {
      
        PreparedStatement pstm = null;
        String sSQL = "update representante set contacto = ? where id = ?";
        conector.obtener();
        try {
            pstm = conector.cnx.prepareStatement(sSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, _contacto);
            pstm.setInt(2,_idRepresentante);
            if(pstm.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al actualiar representante.\n" + ex.getMessage(), "Error Mysql");
        }
        conector.cerrar();
        return   false;
    }
    /**
     * Se debe cargar cerrar la conexion
     *
     * @return
     */
    public static ResultSet listaEstudiantes() {
        ResultSet rs = null;
        conector.obtener();
        String sSQL = "Select nombres, apellidos from persona";
        try {
            Statement stm = conector.cnx.createStatement();
            rs = stm.executeQuery(sSQL);
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al cargar lista estudiantes\n" + ex.getMessage(), "Error Mysql");
        }
        return rs;
    }

    public static ResultSet listaEstudiantesPoridElectivo(int _idElectivo) {
        ResultSet rs = null;
        conector.obtener();
        String sSQL = "Select persona.nombres, persona.apellidos from alumno inner join persona  on alumno.persona_id = persona.id where alumno.electivo_id = ?";
        try {
            PreparedStatement stm = conector.cnx.prepareStatement(sSQL);
            stm.setInt(1, _idElectivo);
            rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al cargar lista estudiantes\n" + ex.getMessage(), "Error Mysql");
        }
        return rs;
    }

    public static ResultSet listaRepresentante() {
        ResultSet rs = null;
        conector.obtener();
        String sSQL = "Select nombres, apellidos from representante";
        try {
            Statement stm = conector.cnx.createStatement();
            rs = stm.executeQuery(sSQL);
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al cargar lista estudiantes\n" + ex.getMessage(), "Error Mysql");
        }
        return rs;
    }

    public static int obtenerIdEstudiantePorNombreApellido(String _consulta) {
        ResultSet rs = null;
        int id = -1;
        String sSQL = "Select id from persona where concat(nombres,' ',apellidos) = '" + _consulta + "'";
        conector.obtener();
        try {
            Statement stm = conector.cnx.createStatement();
            rs = stm.executeQuery(sSQL);
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al consulta estudiante\n" + ex.getMessage(), "Error mysql");
        }
        conector.cerrar();
        return id;
    }
    public static ResultSet obtenerDatosPersonales(int _id){
        String sSQL ="select nombres, apellidos, genero, fechaNacimiento, alergia, SRP01,HPV01, SRP02,HPV02 from persona where id = ?";
        conector.obtener();
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            pstm = conector.cnx.prepareStatement(sSQL);
            pstm.setInt(1, _id);
            rs = pstm.executeQuery();
        } catch (SQLException ex) {
            Herramientas.MensajeErr("Error al actualizar datos personales\n"+ex.getMessage(),"Error Mysql");
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public static int obtenerIdAlumnoPorNombresApellidosIDElectivo(String _nombreApellidos, int _idElectivo) {
        ResultSet rs = null;
        int id = -1;
        String sSQL = "Select id from alumno where persona_id = (select id from persona where concat(nombres,' ',apellidos) = ?) and electivo_id = ?";
        conector.obtener();
        try {
            PreparedStatement stm = conector.cnx.prepareStatement(sSQL);
            stm.setString(1, _nombreApellidos);
            stm.setInt(2, _idElectivo);
            rs = stm.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al consulta estudiante\n" + ex.getMessage(), "Error mysql");
        }
        conector.cerrar();
        return id;
    }

    public static int obtenerIdRepresentantePorNombreApellido(String _consulta) {
        ResultSet rs = null;
        int id = -1;
        String sSQL = "Select id from representante where concat(nombres,' ',apellidos) = '" + _consulta + "'";
        conector.obtener();
        try {
            Statement stm = conector.cnx.createStatement();
            rs = stm.executeQuery(sSQL);
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al consulta representante\n" + ex.getMessage(), "Error mysql");
        }
        conector.cerrar();
        return id;
    }

    public static int obtenerIdElectivo(String _consulta) {
        ResultSet rs = null;
        int id = -1;
        String sSQL = "Select id from electivo where concat(desde,'-',hasta) = '" + _consulta + "'";
        conector.obtener();
        try {
            Statement stm = conector.cnx.createStatement();
            rs = stm.executeQuery(sSQL);
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al consulta electivo\n" + ex.getMessage(), "Error mysql");
        }
        conector.cerrar();
        return id;
    }

    public static boolean guardarAlumno(int _idEstudiante, int _idRepresentante, int _idElectivo, String _curso, String _Paralelo, float _estaturaIncial, float _pesoInicial) {
        PreparedStatement pstm = null;
        boolean guardado = false;
        conector.obtener();
        String sSQL = "Insert into alumno ( curso, paralelo, estaturaInicial, pesoInicial, persona_id, representante_id, electivo_id) values ( ?, ?, ?, ?, ? ,? , ?)";
        try {
            pstm = conector.cnx.prepareStatement(sSQL);
            pstm.setString(1, _curso);
            pstm.setString(2, _Paralelo);
            pstm.setFloat(3, _estaturaIncial);
            pstm.setFloat(4, _pesoInicial);
            pstm.setInt(5, _idEstudiante);
            pstm.setInt(6, _idRepresentante);
            pstm.setInt(7, _idElectivo);
            guardado = pstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al guardar alumno\n" + ex.getMessage(), "Error mysql");
        }
        conector.cerrar();
        return guardado;
    }
    
    public static ResultSet historialClinicoAlumno (int _idAlumno){
        ResultSet rs = null;
        String sSQL = "select historialClinico.fecha, historialClinico.hora, historialClinico.enfermedad from historialClinico inner join alumno on historialclinico.alumno_id = alumno.id where historialclinico.alumno_id = ?";     
        try {
            PreparedStatement pstm = conector.obtener().prepareStatement(sSQL);
            pstm.setInt(1, _idAlumno);
            rs = pstm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al cargar historial clinico\n"+ex.getMessage(),"Error Mysql");
        }
        return rs;
    }
    public static boolean guardarHistorialClinicoAlumno(int _idAlumno,String _enfermedad, Date _fecha, String _detalle){
        String sSQL = "Insert into historialClinico(enfermedad, fecha, hora, detalle, alumno_id) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = conector.obtener().prepareStatement(sSQL);
            pstm.setString(1,_enfermedad);
            pstm.setDate(2,new java.sql.Date(_fecha.getTime()));
            pstm.setTime(3,new java.sql.Time(_fecha.getTime()));
            pstm.setString(4,_detalle.trim().isEmpty()?"":_detalle);
            pstm.setInt(5, _idAlumno);
            if(pstm.executeUpdate()>0){
                conector.cerrar();
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            Herramientas.MensajeErr("Error al ingresar historial clinico\n"+ex.getMessage(),"Errir MySql");
        }
        conector.cerrar();
        return false;
    }
    
    
}
