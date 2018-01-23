/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.conexion;

import javax.imageio.spi.ServiceRegistry;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author PC
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    /*Configuration configuration = new Configuration();
       configuration.configure();
ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
configuration.getProperties()).build();

sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);*/
    static {
        try {
            sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void cerrarSesion() {
        sessionFactory.close();
    }

    public static void cerrarSesion(SessionFactory _sesion) {
        _sesion.close();
    }

    public static boolean estadoConexion() {
        return !sessionFactory.isClosed();
    }

    public static boolean estadoConexion(SessionFactory _sesion) {
        return !_sesion.isClosed();
    }

    public static SessionFactory abrirConexion() {
        if (sessionFactory.isClosed()) {
            try {
                SessionFactory sf = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
                return sf;
            } catch (Throwable ex) {
                // Log the exception. 
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

}
