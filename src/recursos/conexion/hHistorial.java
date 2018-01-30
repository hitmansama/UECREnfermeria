package recursos.conexion;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Alumno;
import pojos.Historialclinico;
import recursos.Soporte.Herramientas;

public class hHistorial {

    public static List<Historialclinico> obtenerHistorialPorAlumno(Alumno _alumno) {
        List<Historialclinico> historial = null;
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Query q = session.createQuery("from Historialclinico where alumno =:_alumno");
        q.setParameter("_alumno", _alumno);
        historial = q.list();
        HibernateUtil.cerrarSesion();
        return historial;
    }

    public static boolean guardarHistorial(Alumno _alumno, String _enfermedad, String _detalle, boolean _Seguimiento) {
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        boolean estado = false;
        Transaction tx = session.beginTransaction();
        try {
            Historialclinico hs = new Historialclinico(_alumno, _enfermedad, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), Herramientas.toByte(_Seguimiento), _detalle);
            session.save(hs);
            estado = true;
            tx.commit();
            HibernateUtil.cerrarSesion();
        } catch (Exception e) {
            Logger.getLogger(hHistorial.class.getName()).log(Level.SEVERE,null,e.getMessage());
            tx.rollback();
        }
        return estado;
    }
}
