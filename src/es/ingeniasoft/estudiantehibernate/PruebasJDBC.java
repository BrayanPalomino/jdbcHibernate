package es.ingeniasoft.estudiantehibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {
    public static void main(String[] args){
        String jdbcUrl="jdbc:mysql://localhost:3306/estudiantehibernate?useSSL=false";
        String user="root";
        String password="";

        try{
            System.out.println("Intentando conectar con la BBDD "+ jdbcUrl);
            Connection miConexion= DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("conexión exitosa!!");

        }catch(Exception e){
            e.printStackTrace();

        }
    }


}
