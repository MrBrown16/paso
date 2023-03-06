import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {

    public Crypto() {
    }
    
    public Key generateKey(String key) {
        Key aeskey = new SecretKeySpec(key.getBytes(), "AES");
        return aeskey;
    }


    public String encrypt(String plainText, String key) {
        String result = "";
        //TODO: Külön kell kezelni a kivételeket
        try {
            result = tryEncrypt(plainText, key);
        } catch (Exception e) {
            System.err.println("Hiba! A titkosítás sikertelen");
        }
        return result;
    }
    private String tryEncrypt(String plainText, String key) 
        throws 
            NoSuchAlgorithmException, 
            NoSuchPaddingException, 
            InvalidKeyException, 
            IllegalBlockSizeException, 
            BadPaddingException {

        Cipher ciper = Cipher.getInstance("AES");
        ciper.init(Cipher.ENCRYPT_MODE, this.generateKey(key));
        byte[] plainTextByteArray = plainText.getBytes();
        byte[] cryptTextByteArray = ciper.doFinal(plainTextByteArray);
        
        byte[] base64CryptText = Base64.getEncoder().encode(cryptTextByteArray);
        String cryptText = new String(base64CryptText);
        return cryptText;
    }

    public String decrypt(String plainText, String key) {
        String result = "";
        //TODO: Külön kell kezelni a kivételeket
        try {
            result = tryDecrypt(plainText, key);
        } catch (Exception e) {
            System.err.println("Hiba! A visszakódolás sikertelen");
        }
        return result;
    }    
    private String tryDecrypt(String cryptText, String key) 
        throws 
            NoSuchAlgorithmException, 
            NoSuchPaddingException, 
            InvalidKeyException, 
            IllegalBlockSizeException, 
            BadPaddingException {
        Cipher ciper = Cipher.getInstance("AES");
        ciper.init(Cipher.DECRYPT_MODE, this.generateKey(key));
        byte[] cryptTextByteArray = Base64.getDecoder().decode(cryptText);
        byte[] plainTextByteArray = ciper.doFinal(cryptTextByteArray);
        String plainText = new String(plainTextByteArray);

        return plainText;
    }
}
