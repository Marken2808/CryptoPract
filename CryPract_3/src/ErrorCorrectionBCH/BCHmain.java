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
        
//        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();             // int < long, but String can start with "0"
        String[] temp = input.trim().split(", ");
//        
//        System.out.println(Arrays.toString(temp));
        int d[] = new int[temp.length];
        for(int i=0; i<temp.length; i++) {
                d[i] = Integer.parseInt(temp[i]); 
        }
//        
//        BCH1612Gen digit = new BCH1612Gen(d);
//        int[] new_d = digit.addDigit();
//        System.out.println("gen: "+digit.getNumberic());


        BCH1612 bch16 = new BCH1612(d);
        System.out.println("input:\t"+input);
        bch16.call();
        
//        int[] num = new int[12];
//        for(int i=0; i<num.length; i++){
//            System.out.println("enter: ");
//            num[i] = Math.floorMod(-sc.nextInt(), 17);
//        }
//        
//        System.out.println("ar: "+Arrays.toString(num));
        
    }
    
}
