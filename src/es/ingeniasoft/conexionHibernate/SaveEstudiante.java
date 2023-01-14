package es.ingeniasoft.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveEstudiante {
    public static void main(String[] args){

        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();
        Session miSession = miFactory.openSession();

        try{
            Estudiante estudiantes = new Estudiante("Jenny", "Marin", "San Pedro");
            miSession.beginTransaction();
            miSession.save(estudiantes);
            miSession.getTransaction().commit();
            System.out.println("registro insertado en BBDD");

            //lectura
           // Estudiante estudiantes = new Estudiante();
            miSession.beginTransaction();
            System.out.println("lectura con registro con Id: "+ estudiantes.getId());
            Estudiante estudianteInsertado=miSession.get(Estudiante.class, 1);
            System.out.println("Registro: "+estudianteInsertado);
            miSession.getTransaction().commit();
            miSession.close();

        }finally{
            miFactory.close();
        }
    }

}
