/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordCracking;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class SHA1 {
    private String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer(); 
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F; 
            int two_halfs = 0; 
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte)); 
                else 
                    buf.append((char) ('a' + (halfbyte - 10))); 
                halfbyte = data[i] & 0x0F; 
            } while(two_halfs++ < 1); 
        } 
        return buf.toString(); 
    } 
  
    public String SHA1(String text)  { 
        MessageDigest md;
        byte[] sha1hash = new byte[40];
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            sha1hash = md.digest(); 
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(SHA1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertToHex(sha1hash);
    } 
    
}
