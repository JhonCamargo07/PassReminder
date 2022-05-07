/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Camargo
 */
public class ManejoPasswords {

    
    public ManejoPasswords() {
    }

    private static String encript(String password) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
    }
    
    private static String decript(String password) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(password.getBytes());
        return new String(decode, "utf-8");
    }
    
    public static String encriptPassword(String cadena) throws Exception{
        return ManejoPasswords.encript(cadena);
    }
    
    public static String decriptPassword(String cadena) throws Exception{
        return ManejoPasswords.decript(cadena);
    }

}
