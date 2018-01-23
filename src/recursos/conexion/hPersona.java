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
import jdk.nashorn.internal.runtime.Debug;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Electivo;
import pojos.Persona;
import recursos.Soporte.Herramientas;
import static recursos.Soporte.Herramientas.toByte;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author PC
 */
public class hPersona {

    /**
     * Obtiene toda la lista de personas desde la BD.
     *
     * @return
     */
    public static List<Persona> obtenerPersonas() {
        SessionFactory sf = HibernateUtil.abrirConexion();
        List<Persona> l = null;
        Session session = sf.openSession();
        Query hq = session.createQuery("from Persona");
        l = hq.list();
        HibernateUtil.cerrarSesion(sf);
        return l;
    }

    /**
     * Crea una nueva persona y luego la guarda en BD.
     *
     * @param _nombres
     * @param _apellidos
     * @param _genero
     * @param _fechaNacimiento
     * @param _srp01
     * @param _srp02
     * @param _hpv01
     * @param _hpv02
     * @param _influencia
     * @return
     */
    public static boolean nuevaPersona(String _nombres, String _apellidos, String _genero, Date _fechaNacimiento, boolean _srp01, boolean _srp02, boolean _hpv01, boolean _hpv02, boolean _influencia) {
        
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        boolean estado = false;
        Transaction tx = session.beginTransaction();
        try {
            Persona persona = new Persona(_nombres, _apellidos, _genero, _fechaNacimiento);
            persona.setSrp01(toByte(_srp01));
            persona.setSrp02(toByte(_srp02));
            persona.setHpv01(toByte(_hpv01));
            persona.setHpv02(toByte(_hpv02));
            persona.setInfluencia(toByte(_influencia));
            session.save(persona);
            tx.commit();
            estado = true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hPersona.class.getName()).log(Level.SEVERE, null, e);
        }
        HibernateUtil.cerrarSesion();
        return estado;
    }

    /**
     * Guarda en BD, la nueva persona previamente creada.
     *
     * @param _persona
     * @return
     */
    public static boolean nuevaPersona(Persona _persona) {
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        boolean estado = false;
        Transaction tx = session.beginTransaction();
        try {
            session.save(_persona);
            tx.commit();
            estado = true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hPersona.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        HibernateUtil.cerrarSesion();
        return estado;
    }

    /**
     * Retorna la persona segun el ID.
     *
     * @param _id
     * @return
     */
    public static Persona obtenerPersonaPorId(int _id) {
        Persona persona = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        persona = (Persona) session.get(Persona.class, _id);
        HibernateUtil.cerrarSesion(sf);
        return persona;
    }

    public static Persona obtenerPersonaNombreApellidos(String _filtro) {
        Persona persona = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Query hq = session.createQuery("from Persona where concat(nombres,' ',apellidos) = :_filtro");
        hq.setParameter("_filtro", _filtro);
        persona = (Persona) hq.uniqueResult();
        HibernateUtil.cerrarSesion(sf);
        return persona;
    }

    /**
     * Obtienes directamente el ID de la persona segun "Nombre Apellido"
     *
     * @param _filtro
     * @return
     */
    public static int obtenerIDPorFiltron(String _filtro) {
        Persona persona = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Query hq = session.createQuery("from Persona where concat(nombres,' ',apellidos) = :_filtro");
        hq.setParameter("_filtro", _filtro);
        persona = (Persona) hq.uniqueResult();
        HibernateUtil.cerrarSesion(sf);
        return persona != null ? persona.getId() : null;
    }

    /**
     * Edita cada uno de los parametros de la persona con el ID.
     *
     * @param _id
     * @param _nombres
     * @param _apellidos
     * @param _genero
     * @param _fechaNacimiento
     * @param _srp01
     * @param _srp02
     * @param _hpv01
     * @param _hpv02
     * @param _influencia
     * @return
     */
    public static boolean editarPersona(int _id, String _nombres, String _apellidos, String _genero, Date _fechaNacimiento, boolean _srp01, boolean _srp02, boolean _hpv01, boolean _hpv02, boolean _influencia) {
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
