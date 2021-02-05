/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrorCorrectionBCH;

import java.util.Arrays;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class BCH1612Gen {
    private int d[] = new int[16];
    public BCH1612Gen(int[] digits) {

        for(int i=0; i<digits.length; i++){
            d[i] = digits[i];
        }
        
        
    }

    public int[] addDigit() {
        
        d[12] = (4*d[0]+10*d[1]+3*d[2]+1*d[3]+5*d[4]+16*d[5]+1*d[6]+12*d[7]+16*d[8]+14*d[9]+7*d[10]+13*d[11])%17;
        d[13] = (2*d[0]+15*d[1]+15*d[2]+16*d[3]+15*d[4]+9*d[5]+12*d[6]+4*d[7]+16*d[8]+11*d[9]+3*d[10]+6*d[11])%17;      
        d[14] = (3*d[0]+11*d[1]+16*d[2]+4*d[3]+12*d[4]+9*d[5]+15*d[6]+16*d[7]+15*d[8]+15*d[9]+2*d[10]+13*d[11])%17;
        d[15] = (7*d[0]+14*d[1]+16*d[2]+12*d[3]+d[4]+16*d[5]+5*d[6]+1*d[7]+3*d[8]+10*d[9]+4*d[10]+1*d[11])%17;
        
        return d;
    }
    
    public String getNumberic() {
        int[] str_d = addDigit();
        System.out.println("d[]: " + Arrays.toString(str_d));
        int count = 0;
        for(int i=0; i<str_d.length; i++){
            if(str_d[i]<16) {   
                count+=0;
            }
            else {
                count++;
            }
//            System.out.println("count "+count);
        }
        
        if(count==0){
            return Arrays.toString(str_d);
        } else {
            return "unusable number";
        }
    }
}
