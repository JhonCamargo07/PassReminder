package ModelVO;

/**
 *
 * @author Camargo
 */
public class UserVO {
    private static int idSesion;
    private String usuario;
    private String password;
    private int idUsuario;

    public UserVO() {
    }

    public UserVO(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public UserVO(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public UserVO(int idUsuario, String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.idUsuario = idUsuario;
    }
    
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static int getIdSesion() {
        return UserVO.idSesion;
    }

    public static void setIdSesion(int idSesion) {
        UserVO.idSesion = idSesion;
    }
    
    @Override
    public String toString() {
        return "usuario{" + "usuario=" + usuario + ", password=" + password + '}';
    }
}
