package infrastructure.SqlImplementations;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexaoHibernate {
        //private static Connection connection;
    
        //public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        
        // String url = "jdbc:mysql://id_servidor:porta/nome_banco";
        
        // MYSQL       
        /*String url = "jdbc:mysql://127.0.0.1:3306/jeanxfome";
        String user = "root";
        String password = "";
        
        Class.forName("com.mysql.cj.jdbc.Driver");*/
        
        // POSTGRESQL
        // url = "jdbc:postgresql://127.0.0.1:5432/Hotel";
        //String user = "postgres";
        //String password = "postgres";
        
        //Class.forName("org.postgresql.Driver");
        
                
        //connection = DriverManager.getConnection(url, user, password);
        //return connection;
    
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            throw ex;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

