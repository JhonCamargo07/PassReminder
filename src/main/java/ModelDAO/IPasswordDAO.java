package ModelDAO;

import ModelVO.PasswordVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Camargo
 */
public interface IPasswordDAO {

    public List<PasswordVO> seleccionar() throws SQLException;

    public List<PasswordVO> seleccionarPassword(String parametro) throws SQLException;

    public int insertar(PasswordVO usuario) throws SQLException;

    public int actualizar(PasswordVO usuario) throws SQLException;

    public int eliminar(PasswordVO usuario) throws SQLException;
    
}
