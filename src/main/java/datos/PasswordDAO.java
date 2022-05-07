package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.PasswordDTO;
import domain.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camargo
 */
public class PasswordDAO implements IPasswordDAO{
    
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM pass WHERE id_usuario_fk = ?";
    private static final String SQL_INSERT = "INSERT INTO pass (pagina_pass, nombre_pass, pass, id_usuario_FK) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pass SET pagina_pass = ?, nombre_pass = ?, pass = ? where id_pass = ?";
    private static final String SQL_DELETE = "DELETE FROM pass WHERE id_pass = ?";
    private static final String SQL_SELECT_PASS = "SELECT * FROM pass WHERE pagina_pass like ? OR nombre_pass like ?";

@Override
    public List<PasswordDTO> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PasswordDTO password = null;
        List<PasswordDTO> passwords = new ArrayList();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, UsuarioDTO.getIdSesion());
            rs = stmt.executeQuery();
            while (rs.next()){
                int idPassword = rs.getInt("id_Pass");
                String pagina = rs.getString("pagina_Pass");
                String usuario = rs.getString("nombre_Pass");
                String pass = rs.getString("pass");
                
                password = new PasswordDTO(idPassword, pagina, usuario, pass);
                
                passwords.add(password);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                if(this.conexionTransaccional == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return passwords;
    }
    
    @Override
    public List<PasswordDTO> seleccionarPassword(String parametro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PasswordDTO password = null;
        List<PasswordDTO> passwords = new ArrayList();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PASS);
            stmt.setString(1, parametro);
            stmt.setString(2, parametro);
//            stmt.setString(3, parametro);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idPassword = rs.getInt("id_Pass");
                String pagina = rs.getString("pagina_Pass");
                String usuario = rs.getString("nombre_Pass");
                String pass = rs.getString("pass");
                
                password = new PasswordDTO(idPassword, pagina, usuario, pass);
                
                passwords.add(password);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                if(this.conexionTransaccional == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return passwords;
    }

    @Override
    public int insertar(PasswordDTO password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, password.getPagina());
            stmt.setString(2, password.getUser());
            stmt.setString(3, password.getPass());
            stmt.setInt(4, password.getIdPassword());
            registros = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if(this.conexionTransaccional == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    @Override
    public int actualizar(PasswordDTO password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional == null ? getConnection() : this.conexionTransaccional;
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, password.getPagina());
            stmt.setString(2, password.getUser());
            stmt.setString(3, password.getPass());
            stmt.setInt(4, password.getIdPassword());
            registros = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if(this.conexionTransaccional == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    @Override
    public int eliminar(PasswordDTO password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, password.getIdPassword());
            registros = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if(this.conexionTransaccional == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return registros;
    }
    
}
