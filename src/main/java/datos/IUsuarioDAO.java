package datos;

import domain.UsuarioDTO;
import java.sql.SQLException;

/**
 *
 * @author Camargo
 */
public interface IUsuarioDAO {
    
//    public List<UsuarioDTO> seleccionar() throws SQLException;
    public boolean seleccionar(UsuarioDTO usuario) throws SQLException;
    
    public boolean seleccionarUsuario(UsuarioDTO usuario) throws SQLException;
    
    public int insertar(UsuarioDTO usuario) throws SQLException;
    
    public int actualizar(UsuarioDTO usuario) throws SQLException;
    
    public int eliminar(UsuarioDTO usuario) throws SQLException;
    
}
