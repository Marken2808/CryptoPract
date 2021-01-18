/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordCracking;

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
    
    public String BruteForce(String enTxt){

        if(!enTxt.trim().isEmpty()){
            fin = false;
            
            for (int i = 1; i < enTxt.length(); i++) {
                if (!fin) {
                    try {
                        char index[] = new char[i];
                        passTest = replay(index, 0, numberType, enTxt);
                    } catch (Exception e) {
//                        System.out.println(passTest);
                    }
                }
            }
        }
        return passTest;
    }
    
    private String replay(char[] index, int pos, String str, String input){
        
        SHA1 sha1 = new SHA1();
        String passTestHash;
        String BCHTestHash;
        
        if(pos == index.length && !fin){
            
            passTest = new String(index);
//            System.out.println("passtest: "+ passTest);
            passTestHash = sha1.SHA1(passTest);
            System.out.println("passTestHash: "+ passTestHash);

            if(index.length==6){    // number type only
                BCHgenerator test = new BCHgenerator(index);
                test.addDigit();
                BCHTestHash = sha1.SHA1(test.getNumberic());
//                System.out.println("gen: "+test.getNumberic());
                if(BCHTestHash.equals(input)){
                    fin = true;
                    return passTest = test.getNumberic();
                }
            }
            
//            if(passTestHash.equals(input)){   // letter type only
//                
//                fin = true;
//                return passTest;
//            }
            
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
