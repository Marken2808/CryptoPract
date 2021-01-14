/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageBox;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class RSA {

    /**
     * @param args the command line arguments
     */
    
    private final int RSA_KEY_LENGTH = 4096;
    private final String ALGORITHM_NAME = "RSA" ;
//    private final String PADDING_SCHEME = "OAEPWITHSHA-512ANDMGF1PADDING" ;
//    private final String MODE_OF_OPERATION = "ECB" ; // This essentially means none behind the scene

    public void letCheckRSA(String shortMessage) {
//
        try {

            // Generate Key Pairs
            KeyPairGenerator rsaKeyGen = KeyPairGenerator.getInstance(ALGORITHM_NAME) ;
            rsaKeyGen.initialize(RSA_KEY_LENGTH) ;
            KeyPair rsaKeyPair = rsaKeyGen.generateKeyPair() ;

            String encryptedText = rsaEncrypt(shortMessage, rsaKeyPair.getPublic());
            String decryptedText = rsaDecrypt(Base64.getDecoder().decode(encryptedText), rsaKeyPair.getPrivate()) ;
//            String decryptedText = rsaDecrypt(Base64.getDecoder().decode(shortMessage), rsaKeyPair.getPrivate()) ;

            System.out.println("Encrypted RSA = " + encryptedText) ;
            System.out.println("Decrypted RSA = " + decryptedText) ;

        } catch(Exception e) {System.out.println("Exception while encryption/decryption") ;} 

    }

    private String rsaEncrypt(String message, Key publicKey) throws Exception {

//        Cipher c = Cipher.getInstance(ALGORITHM_NAME + "/" + MODE_OF_OPERATION + "/" + PADDING_SCHEME) ;
        Cipher c = Cipher.getInstance(ALGORITHM_NAME);
        c.init(Cipher.ENCRYPT_MODE, publicKey) ;

        byte[] cipherTextArray = c.doFinal(message.getBytes()) ;

        return Base64.getEncoder().encodeToString(cipherTextArray) ;

    }


    private String rsaDecrypt(byte[] encryptedMessage, Key privateKey) throws Exception {
        
//        Cipher c = Cipher.getInstance(ALGORITHM_NAME + "/" + MODE_OF_OPERATION + "/" + PADDING_SCHEME) ;
        Cipher c = Cipher.getInstance(ALGORITHM_NAME) ;
        c.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainText = c.doFinal(encryptedMessage);

        return new String(plainText) ;

    }


}
