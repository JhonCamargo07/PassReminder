package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Camargo
 */
public class Conexion {
//    private static final String JDBC_URL = "jdbc:mysql://localhost/id17955299_passreminder?useSSL=false&useTimezone=true&serverTimezona=UTC&allowPublicKeyRetrieval=true";
//    private static final String JDBC_URL = "jdbc:mysql://145.14.145.92/id17955299_passreminder";
//    private static final String JDBC_URL = "jdbc:mysql://145.14.145.145:3306/id17955299_passreminder?useSSL=false&useTimezone=true&serverTimezona=UTC&allowPublicKeyRetrieval=true";
//    private static final String JDBC_USER = "id17955299_jhoncamargo21";
//    private static final String JDBC_PASSWORD = "Egl%AL@*6WdL1c6S";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/passreminder?useSSL=false&useTimezone=true&serverTimezona=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        //Definir el tamaño inicial del pool de conexiones
        ds.setInitialSize(1);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
