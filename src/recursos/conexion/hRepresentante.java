/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.conexion;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Electivo;
import pojos.Representante;

/**
 *
 * @author PC
 */
public class hRepresentante {
    /**
     * Obtiene una lista con todos los representantes de la BD
     * @return 
     */
     public static List<Representante> obtenerRepresentantes() {
        SessionFactory sf = HibernateUtil.abrirConexion();
        List<Representante> l = null;
        Session session = sf.openSession();
        Query hq = session.createQuery("from Representante");
        l = hq.list();
        HibernateUtil.cerrarSesion(sf);
        return l;
    }
/**
 * Crea un nuevo representante y lo guarda en BD.
 * @param _nombres
 * @param _apellidos
 * @param _contacto
 * @return 
 */
    public static boolean nuevoRepresentante(String _nombres, String _apellidos,String _contacto) {
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        boolean estado = false;
      Representante rep = new Representante(_nombres, _apellidos, _contacto);
        Transaction tx = session.beginTransaction();
        try {
            session.save(rep);
            tx.commit();
            estado = true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hRepresentante.class.getName()).log(Level.SEVERE,null,e.getMessage());
        }
       HibernateUtil.cerrarSesion();
        return estado;
    }
    /**
     * Guarda el representante en BD
     * @param _representante
     * @return 
     */
public static boolean nuevoRepresentante(Representante _representante) {
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        boolean estado = false;
        Transaction tx = session.beginTransaction();
        try {
            session.save(_representante);
            tx.commit();
            estado = true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hRepresentante.class.getName()).log(Level.SEVERE,null,e.getMessage());
        }
       HibernateUtil.cerrarSesion();
        return estado;
    }
    public static Representante obtenerRepresentante(String _filtro){
        Representante representante = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Query hq = session.createQuery("from Representante where concat(nombres,' ',apellidos) = :_filtro");
        hq.setParameter("_filtro",_filtro);
        representante = (Representante) hq.uniqueResult();
        HibernateUtil.cerrarSesion(sf);
        return representante;
    }
    /**
     * Edita el representante segun el id.
     * @param _id
     * @param _nombres
     * @param _apellidos
     * @param _contacto
     * @return 
     */
    public static boolean editarRepresentante (int _id,String  _nombres, String _apellidos, String _contacto){
        SessionFactory sx = HibernateUtil.abrirConexion();
        Session session = sx.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Representante representante = (Representante) session.get(Representante.class,_id);
            representante.setNombres(_nombres);
            representante.setApellidos(_apellidos);
            representante.setContacto(_contacto);
            session.update(representante);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            tx.rollback();
            Logger.getLogger(Representante.class.getName()).log(Level.SEVERE,null,e.getMessage());
        }
        return false;
    }
}
