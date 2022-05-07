/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Camargo
 */
public class PasswordDTO {

    private int idPassword;
    private String pagina;
    private String user;
    private String pass;

    public PasswordDTO() {
    }

    public PasswordDTO(int idPassword) {
        this.idPassword = idPassword;
    }

    public PasswordDTO(String pagina, String user, String pass) {
        this.pagina = pagina;
        this.user = user;
        this.pass = pass;
    }

    public PasswordDTO(int idPassword, String pagina, String user, String pass) {
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
