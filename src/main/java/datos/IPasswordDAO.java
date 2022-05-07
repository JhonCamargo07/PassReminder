package datos;

import domain.PasswordDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Camargo
 */
public interface IPasswordDAO {

    public List<PasswordDTO> seleccionar() throws SQLException;

    public List<PasswordDTO> seleccionarPassword(String parametro) throws SQLException;

    public int insertar(PasswordDTO usuario) throws SQLException;

    public int actualizar(PasswordDTO usuario) throws SQLException;

    public int eliminar(PasswordDTO usuario) throws SQLException;
    
}
