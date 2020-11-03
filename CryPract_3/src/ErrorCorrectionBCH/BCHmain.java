/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrorCorrectionBCH;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class BCHmain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int d[];
        Scanner sc = new Scanner(System.in);
//        d = new int[6]; // for BCHgenerator
        d = new int[10];
        for(int i=0; i<d.length; i++) d[i]=sc.nextInt();
        
//        BCHgenerator digit = new BCHgenerator(d);
//        int[] new_d = digit.addDigit();
        BCHdecoder dec = new BCHdecoder(d);
        dec.call();
//        String new_d = digit.getNumberic();
        
//        System.out.println("d[]: " + Arrays.toString(new_d));
        
    }
    
}
