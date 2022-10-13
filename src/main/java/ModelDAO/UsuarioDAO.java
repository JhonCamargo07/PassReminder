package ModelDAO;

import ModelVO.UserVO;
import static ModelDAO.Conexion.*;
import java.sql.*;

/**
 *
 * @author Camargo
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM usuario WHERE BINARY email_user = ? AND BINARY password_U = ?";
    private static final String SQL_INSERT = "INSERT INTO usuario VALUES (NULL, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET email_user = ?, password_U = ? where id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    private static final String SQL_SELECT_USER = "SELECT email_user FROM usuario WHERE BINARY email_user = ?";

    public UsuarioDAO(){
        
    }
    
    public UsuarioDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    @Override
    public boolean seleccionar(UserVO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        UserVO usuario = null;
//        List<UsuarioDTO> usuarios = new ArrayList();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            rs = stmt.executeQuery();
            
            if(rs.next()){
                UserVO.setIdSesion(rs.getInt("id_Usuario"));
                return true;
            }else{
                return false;
            }
            
//            while (rs.next()){
//                int idUsuario = rs.getInt("id_Usuario");
//                String email = rs.getString("emailUser");
//                String pass = rs.getString("passwordU");
//                
//                usuario = new UserVO(idUsuario, email, pass);
//                
//                usuarios.add(usuario);
//            }
            
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
        return false;
    }
    
    @Override
    public boolean seleccionarUsuario(UserVO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_USER);
            stmt.setString(1, usuario.getUsuario());
            rs = stmt.executeQuery();
            
            return rs.next();
            
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
        return false;
    }

    @Override
    public int insertar(UserVO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
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
    public int actualizar(UserVO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional == null ? getConnection() : this.conexionTransaccional;
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdUsuario());
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
    public int eliminar(UserVO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
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
