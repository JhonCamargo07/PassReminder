package ModelDAO;

import ModelVO.UserVO;
import java.sql.SQLException;

/**
 *
 * @author Camargo
 */
public interface IUsuarioDAO {
    
//    public List<UsuarioDTO> seleccionar() throws SQLException;
    public boolean seleccionar(UserVO usuario) throws SQLException;
    
    public boolean seleccionarUsuario(UserVO usuario) throws SQLException;
    
    public int insertar(UserVO usuario) throws SQLException;
    
    public int actualizar(UserVO usuario) throws SQLException;
    
    public int eliminar(UserVO usuario) throws SQLException;
    
}
