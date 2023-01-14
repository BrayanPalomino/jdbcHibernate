package es.ingeniasoft.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEstudiante {
    public static void main(String[] args){

        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();
        Session miSession = miFactory.openSession();

        try{
            int estuidanteId=2;
            miSession.beginTransaction();
           // Estudiante estudiante = miSession.get(Estudiante.class, estuidanteId);
            //estudiante.setNombre("SALOME");
            //miSession.createQuery("update Estudiante set Apellido='MARIN' where Apellido like 'M%'").executeUpdate();
            miSession.createQuery("delete Estudiante where Nombre like 'J%'").executeUpdate();

            miSession.getTransaction().commit();
            System.out.println("registro actualizado en BBDD");
            miSession.close();

        }finally{
            miFactory.close();
        }
    }

}
