/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordCracking;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class BruteForce {
    
    private boolean fin;
    private String passTest;
    
    public String BruteForce(String enTxt) throws NoSuchAlgorithmException, UnsupportedEncodingException{
//        String input = enTxt.trim();
//        System.out.println("input: "+enTxt.trim());
        if(!enTxt.trim().isEmpty()){
            fin = false;
            
            for (int i = 1; i < enTxt.length(); i++) {
                if (!fin) {
                    try {
                        char index[] = new char[i];
//                        abcdefghijklmnopqrstuvwxyz
                        passTest = replay(index, 0, "0123456789", enTxt);
                    } catch (Exception e) {
                        //System.out.println(e);
                    }
                }
            }
        }
        return passTest;
    }
    
    private String replay(char[] index, int pos, String str, String input) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
        SHA1 sha1 = new SHA1();
        String passTestHash;
        
        
        if(pos == index.length && !fin){
            
            passTest = new String(index);
//            System.out.println("passtest: "+ passTest);
            passTestHash = sha1.SHA1(passTest);
//            System.out.println("passTestHash: "+ passTestHash);

            if(passTestHash.equals(input)){
                fin = true;
                return passTest;
            }

        } else {
            for(int i = 0; i < str.length(); i++){
//                System.out.println("index: "+index[pos]);
//                System.out.println("chartAt: "+str.charAt(i));
                index[pos] = str.charAt(i);
                replay(index, pos+1, str, input);
            }
        }
        return null;
    }
    
}
