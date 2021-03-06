/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordCracking;

import java.util.Arrays;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class BCHgenerator {
    private int d[] = new int[10];
    public BCHgenerator(char[] digits) {

        for(int i=0; i<digits.length; i++){
            d[i] = Character.getNumericValue(digits[i]);
        }
        
        
    }

    public int[] addDigit() {
        d[6] = ((4*d[0]+10*d[1]+9*d[2]+ 2*d[3]+  d[4]+7*d[5])%11);
        d[7] = ((7*d[0]+ 8*d[1]+7*d[2]+   d[3]+9*d[4]+6*d[5])%11);
        d[8] = ((9*d[0]+   d[1]+7*d[2]+ 8*d[3]+7*d[4]+7*d[5])%11);
        d[9] = ((  d[0]+ 2*d[1]+9*d[2]+10*d[3]+4*d[4]+  d[5])%11);
        
        return d;
    }
    
    public String getNumberic() {
        StringBuilder builder = new StringBuilder();
        int[] str_d = addDigit();
        //System.out.println("d[]: " + Arrays.toString(str_d));
        int count = 0;
        for(int i=0; i<str_d.length; i++){
            if(str_d[i]<10) {   
                count+=0;
            }
            else {
                count++;
            }
//            System.out.println("count "+count);
        }
        
        
        if(count==0){
            for(int s : str_d) {
                builder.append(s);
            }
            return builder.toString();
        }
        return "";
        
    }
}
