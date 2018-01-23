package recursos.conexion;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jpa.HibernateQuery;
import pojos.Electivo;

public class hElectivo {
/**
 * Obtiene la lista de todos los años electivos de la BD
 * @return 
 */
    public static List<Electivo> obtenerElectivos() {
        SessionFactory sf = HibernateUtil.abrirConexion();
        List<Electivo> l = null;
        Session session = sf.openSession();
        Query hq = session.createQuery("from Electivo");
        l = hq.list();
        HibernateUtil.cerrarSesion(sf);
        return l;
    }
/**
 * Guarda un nuevo año electivo en BD
 * @param _desde
 * @param _hasta
 * @return 
 */
    public static boolean nuevoElectivo(String _desde, String _hasta) {
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        boolean estado = false;
        Electivo electivo = new Electivo(_desde, _hasta);
        Transaction tx = session.beginTransaction();
        try {
            session.save(electivo);
            tx.commit();
            estado = true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hElectivo.class.getName()).log(Level.SEVERE,null,e.getMessage());
        }
       HibernateUtil.cerrarSesion();
        return estado;
    }
    /**
     * Obtiene el año electivo segun filtro desde, hasta(String, String)
     * @param _filtro
     * @return 
     */
    public static Electivo obtenerElectivo(String _filtro){
        Electivo electivo = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Query hq = session.createQuery("from Electivo where concat(desde,'-',hasta) = :_filtro");
        hq.setParameter("_filtro",_filtro);
        electivo = (Electivo) hq.uniqueResult();
        HibernateUtil.cerrarSesion(sf);
        return electivo;
    }
}
