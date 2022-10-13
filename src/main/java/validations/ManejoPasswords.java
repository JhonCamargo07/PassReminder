/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validations;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Camargo
 */
public class ManejoPasswords {

    private static String password = "";
    private static int contador = 0;
    private static int cantidadBucles = 1;

    public ManejoPasswords() {
    }

    private static String encript(String password) throws UnsupportedEncodingException {
        ManejoPasswords.contador++;
        if (ManejoPasswords.contador <= ManejoPasswords.cantidadBucles) {
            ManejoPasswords.password = Base64.getEncoder().encodeToString(password.getBytes("utf-8"));
            encript(ManejoPasswords.password);
        } else {
            return ManejoPasswords.password;
        }
        return ManejoPasswords.password;
    }

    private static String decript(String password) throws UnsupportedEncodingException {
        ManejoPasswords.contador++;
        if (ManejoPasswords.contador <= ManejoPasswords.cantidadBucles) {
            byte[] decode = Base64.getDecoder().decode(password.getBytes());
            ManejoPasswords.password = new String(decode, "utf-8");
            decript(ManejoPasswords.password);
        } else {
            return ManejoPasswords.password;
        }
        return ManejoPasswords.password;
    }

    public static String encriptPassword(String cadena) throws Exception {
        ManejoPasswords.contador = 0;
        cadena = ManejoPasswords.encript(cadena);
        String pass = new String(cifra(cadena), "utf-8");
        return pass;
    }

    public static String decriptPassword(String cadena) throws Exception {
        byte[] pass = cadena.getBytes(Charset.defaultCharset());
        cadena = descifra(pass);
        ManejoPasswords.contador = 0;
        return ManejoPasswords.decript(cadena);
//        return descifra(pass);
    }

    public static byte[] cifra(String sinCifrar) throws Exception {
        final byte[] bytes = sinCifrar.getBytes("UTF-8");
        final Cipher aes = obtieneCipher(true);
        final byte[] cifrado = aes.doFinal(bytes);
        return cifrado;
    }

    public static String descifra(byte[] cifrado) throws Exception {
        final Cipher aes = obtieneCipher(false);
        final byte[] bytes = aes.doFinal(cifrado);
        final String sinCifrar = new String(bytes, "UTF-8");
        return sinCifrar;
    }

    private static Cipher obtieneCipher(boolean paraCifrar) throws Exception {
        final String frase = "ESTA_áÁéÉíÍóSeUtilizaUnaFraseLargaYPocoEntendibleÓúÚüFRASEÜñÑ123456789NO0!#%SE$&()=%!_USA";
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(frase.getBytes("UTF-8"));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (paraCifrar) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

        return aes;
    }

}
