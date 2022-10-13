package ModelDAO;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Camargo
 */
public class Conexion {

    private static final String NAME_DB = "bggb5kg8axejusuzyrwl";
    private static final String JDBC_URL = "jdbc:mysql://bggb5kg8axejusuzyrwl-mysql.services.clever-cloud.com:3306/" + NAME_DB + "?useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "ukedkwhys0y9fp72";
    private static final String JDBC_PASS = "rOaqGmt4QYH3UcFFvV7h";

    private static BasicDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASS);
            dataSource.setInitialSize(1);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
