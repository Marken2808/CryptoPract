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
    int countNum = 0;
    
    String numberType = "0123456789";
    String letterType = "abcdefghijklmnopqrstuvwxyz";
    
    public String BruteForce(String enTxt) throws NoSuchAlgorithmException, UnsupportedEncodingException{

        if(!enTxt.trim().isEmpty()){
            fin = false;
            
            for (int i = 1; i < 7; i++) {
                if (!fin) {
                    try {
                        char index[] = new char[i];
                        passTest = replay(index, 0, numberType, enTxt);
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

//            if(str.equals(numberType) && countNum==6){
//                    System.out.println("str"+ str.equals(numberType) +" "+ (countNum));
//                        System.out.println("6 here: "+passTest);
//                        return passTest;
//                    }

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
