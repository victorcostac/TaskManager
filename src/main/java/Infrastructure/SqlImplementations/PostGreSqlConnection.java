package Infrastructure.SqlImplementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostGreSqlConnection {
        private static Connection connection;
    
        public static Connection obterConexao() throws ClassNotFoundException, SQLException {
        
        // String url = "jdbc:mysql://id_servidor:porta/nome_banco";
        
        // MYSQL       
        /*String url = "jdbc:mysql://127.0.0.1:3306/jeanxfome";
        String user = "root";
        String password = "";
        
        Class.forName("com.mysql.cj.jdbc.Driver");*/
        
        // POSTGRESQL
        String url = "jdbc:postgresql://127.0.0.1:5432/Hotel";
        String user = "postgres";
        String password = "postgres";
        
        Class.forName("org.postgresql.Driver");
        
                
        connection = DriverManager.getConnection(url, user, password);
        return connection;
        
        
    }  
}
