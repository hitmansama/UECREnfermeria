
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import pojos.Alumno;
import pojos.Electivo;
import pojos.Persona;
import pojos.Representante;
import recursos.conexion.HibernateUtil;
import recursos.conexion.hAlumno;
import recursos.conexion.hElectivo;
import recursos.conexion.hPersona;
import recursos.conexion.hRepresentante;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
// * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      SessionFactory sf = HibernateUtil.abrirConexion();
      Persona persona = hPersona.obtenerPersonaNombreApellidos("Stalin Palacios");
      Electivo electivo = hElectivo.obtenerElectivo("2018-2019");
      hAlumno.obtenerAlumnoPorPersonaElectivo(persona, electivo);
      
    }
}
