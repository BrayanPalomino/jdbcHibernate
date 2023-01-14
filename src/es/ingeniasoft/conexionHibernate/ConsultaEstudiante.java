package es.ingeniasoft.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ConsultaEstudiante {

        public static void main(String[] args) {

            SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();
            Session miSession = miFactory.openSession();
            try {
                miSession.beginTransaction();

                //consulta estudiantes
                List<Estudiante>estudiantes=miSession.createQuery("from Estudiante").getResultList();

                //mostrar estudiantes

                listar(estudiantes);

                //consulta: por apellido
                estudiantes=miSession.createQuery("from Estudiante es where es.apellido='Palomino'").getResultList();

                //mostrar resultado
                listar(estudiantes);


                //consulta: por apellido y direccion
                estudiantes=miSession.createQuery("from Estudiante es where es.apellido='Palomino' and es.direccion='San Pedro'").getResultList();

                //mostrar resultado
                listar(estudiantes);


                miSession.getTransaction().commit();




            }finally {
                miFactory.close();

            }
        }

    private static void listar(List<Estudiante> estudiantes) {
        for(Estudiante unEstudiante: estudiantes){
            System.out.println(unEstudiante);
        }
    }
}

