/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.conexion;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Alumno;
import pojos.Electivo;
import pojos.Persona;
import pojos.Representante;
import static recursos.Soporte.Herramientas.toByte;

/**
 *
 * @author Josselyn
 */
public class hAlumno {
    /**
     * Obtiene una lista con todos los alumnos de laBD
     * @return 
     */
     public static List<Alumno> obtenerAlumnos() {
        SessionFactory sf = HibernateUtil.abrirConexion();
        List<Alumno> l = null;
        Session session = sf.openSession();
        Query hq = session.createQuery("from Alumno");
        l = hq.list();
        HibernateUtil.cerrarSesion(sf);
        return l;
    }

   /**
    * Crea un nuevo alumno y lo guarda en BD
    * @param _electivo
    * @param _persona
    * @param _representante
    * @param _curso
    * @param _paralelo
    * @param _estaturaInicial
    * @param _pesoInicial
    * @param _estaturaFinal
    * @param _pesoFinal
    * @param _seEnvioFormulario
    * @param _seRecibioFormulario
    * @param _alergia
    * @return 
    */
    public static boolean nuevoAlumno(Electivo _electivo, Persona _persona, Representante _representante, String _curso, String _paralelo, float _estaturaInicial, float _pesoInicial, Float _estaturaFinal, Float _pesoFinal, boolean _seEnvioFormulario, boolean _seRecibioFormulario, String _alergia) {
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        boolean estado = false;
        Transaction tx = session.beginTransaction();
        try {
            Alumno alumno = new Alumno();
            alumno.setElectivo(_electivo);
            alumno.setRepresentante(_representante);
            alumno.setPersona(_persona);
            alumno.setCurso(_curso);
            alumno.setParalelo(_paralelo);
            alumno.setAlergia(_alergia);
            alumno.setEstaturaFinal(_estaturaFinal);
            alumno.setEstaturaInicial(_estaturaInicial);
            alumno.setPesoFinal(_pesoFinal);
            alumno.setPesoInicial(_pesoInicial);
            alumno.setSeEnvioFormulario(toByte(_seEnvioFormulario));
            alumno.setSeRecibioFormulario(toByte(_seRecibioFormulario));
            session.save(alumno);
            tx.commit();
            HibernateUtil.cerrarSesion();
            estado = true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hAlumno.class.getName()).log(Level.SEVERE, null, e);
        }
        HibernateUtil.cerrarSesion();
        return estado;
    }

  /**
   * Guarda un alumno previamente creado
   * @param _alumno
   * @return 
   */
    public static boolean nuevoAlumno(Alumno _alumno) {
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        boolean estado = false;
        Transaction tx = session.beginTransaction();
        try {
            session.save(_alumno);
            tx.commit();
            estado = true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hAlumno.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        HibernateUtil.cerrarSesion();
        return estado;
    }

    /**
     * Retorta el Alumno segund el ID
     * @param _id
     * @return 
     */
    public static Alumno obtenerAlumnoPorId(int _id) {
        Alumno alumno = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        alumno = (Alumno) session.get(Alumno.class, _id);
        HibernateUtil.cerrarSesion(sf);
        return alumno;
    }
/**
 * Obtiene el alumno segun el anio Electivo y segun la Persona
 * @param _persona
 * @param _electivo
 * @return 
 */
    public static Alumno obtenerAlumnoPorPersonaElectivo(Persona _persona,Electivo _electivo) {
        Alumno alumno = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Query hq = session.createQuery("from Alumno where electivo =:_electivo and persona =:_persona");
        hq.setParameter("_electivo",_electivo);
        hq.setParameter("_persona",_persona);
        alumno = (Alumno) hq.uniqueResult();
        HibernateUtil.cerrarSesion(sf);
        return alumno;
    }

    public static boolean editarAlumno(int _id, String _nombres, String _apellidos, String _genero, Date _fechaNacimiento, boolean _srp01, boolean _srp02, boolean _hpv01, boolean _hpv02, boolean _influencia) {
        Persona persona = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        persona = (Persona) session.get(Persona.class, _id);
        persona.setNombres(_nombres);
        persona.setApellidos(_apellidos);
        persona.setGenero(_genero);
        persona.setFechaNacimiento(_fechaNacimiento);
        persona.setSrp01(toByte(_srp01));
        persona.setHpv01(toByte(_hpv01));
        persona.setSrp02(toByte(_srp02));
        persona.setHpv02(toByte(_hpv02));
        persona.setInfluencia(toByte(_influencia));
        try {
            session.merge(persona);
            tx.commit();
            HibernateUtil.cerrarSesion();
            return true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hPersona.class.getName()).log(Level.SEVERE, null, e);
        }
        HibernateUtil.cerrarSesion(sf);
        return false;
    }
}
