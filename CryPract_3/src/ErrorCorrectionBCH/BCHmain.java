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
    public static void main(String[] args){
        // TODO code application logic here
        
        
        Scanner sc = new Scanner(System.in);
        String input = sc.next();             // int < long, but String can start with "0"
        String[] temp = input.split("");
        int d[] = new int[temp.length];
        for(int i=0; i<temp.length; i++) {
                d[i] = Integer.parseInt(temp[i]); 
        }
        
        
        
//        System.out.println(" d[]: " +Arrays.toString(d));
//        System.out.println(" input: " +input);
//        System.out.println(" temp: " +Arrays.toString(temp));
//        BCHgenerator digit = new BCHgenerator(d);
//        int[] new_d = digit.addDigit();
        BCHdecoder dec = new BCHdecoder(d);
        dec.call();
//        int[] pqr = dec.pqr;
//        int P = pqr[0];
//        int Q = pqr[1];
//        int R = pqr[2];
//        
//        Modular m = new Modular();
//        int sqr = m.checkSqr(Q*Q-4*P*R);
//        
//        int i = Math.floorMod(((-Q + (int)sqr) * m.checkPow(2*P,-1)), 11);
//        int j = Math.floorMod(((-Q - (int)sqr) * m.checkPow(2*P,-1)), 11);
//            
//        
//        System.out.println(" sqr: " + sqr);
//        System.out.println(" i: " + i);
//        System.out.println(" j: " + j);
//        String new_d = digit.getNumberic();
        
//        System.out.println("d[]: " + Arrays.toString(new_d));
        
    }
    
}
