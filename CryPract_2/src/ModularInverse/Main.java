/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModularInverse;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] input=new int[]{1,2,3,4,5,6,7,8,9,10};
        
        Modular mod = new Modular();
       
        System.out.print("|  x  |");
        
        for(int i=0; i<input.length; i++){
            System.out.print("\t"+(i+1) + "\t|");
        }
        System.out.print("\n▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔");
        System.out.print("\n| -x  |");
        for(int i=0; i<input.length; i++){
            int neg = mod.checkNeg(-input[i]);
            System.out.print("\t"+(neg) + "\t|");
        }
        System.out.print("\n|  x² |");
        for(int i=0; i<input.length; i++){
            int pow = mod.checkPow(input[i],2);
            System.out.print("\t"+(pow) + "\t|");
        }
        System.out.print("\n| xˉ¹ |");
        for(int i=0; i<input.length; i++){
            int pow = mod.checkPow(input[i],-1);
            System.out.print("\t"+(pow) + "\t|");
        }
        System.out.print("\n|  √x |");
        for(int i=0; i<input.length; i++){
            int sqr = mod.checkSqr(input[i]);
            if(sqr==0){
                System.out.print("\t \t|");
            } else System.out.print("\t"+(sqr) + "\t|");
            
            //System.out.println("num= "+sqr);
        }
        
       
        
        //long neg = mod.checkNeg(input);
        //long pow = mod.checkPow(input[1],-1);
        //long sqr = mod.checkSqr(input);
//        System.out.println("add: " + add);
//        System.out.println("mul: " + mul);
//        System.out.println("div: " + div);
        
        //System.out.println(pow);
//          √
//          ¹
    }
    
}
