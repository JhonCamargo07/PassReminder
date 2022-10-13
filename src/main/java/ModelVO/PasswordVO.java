/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelVO;

/**
 *
 * @author Camargo
 */
public class PasswordVO {

    private int idPassword;
    private String pagina;
    private String user;
    private String pass;

    public PasswordVO() {
    }

    public PasswordVO(int idPassword) {
        this.idPassword = idPassword;
    }

    public PasswordVO(String pagina, String user, String pass) {
        this.pagina = pagina;
        this.user = user;
        this.pass = pass;
    }

    public PasswordVO(int idPassword, String pagina, String user, String pass) {
        this.idPassword = idPassword;
        this.pagina = pagina;
        this.user = user;
        this.pass = pass;
    }

    public int getIdPassword() {
        return this.idPassword;
    }

    public void setIdPassword(int idPassword) {
        this.idPassword = idPassword;
    }

    public String getPagina() {
        return this.pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "PasswordDTO{" + "idPassword=" + idPassword + ", pagina=" + pagina + ", user=" + user + ", pass=" + pass + '}';
    }

}
