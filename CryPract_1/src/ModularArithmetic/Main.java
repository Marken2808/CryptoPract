/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModularArithmetic;

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
        int[] input = new int[2];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<input.length; i++) input[i]=sc.nextInt();
        
        Operation op = new Operation();
        long add = op.getOperation(input[0],"+",input[1]);
        long mul = op.getOperation(input[0],"x",input[1]);
        long div = op.getOperation(input[0],"/",input[1]);
        
        
        System.out.println("add: " + add);
        System.out.println("mul: " + mul);
        System.out.println("div: " + div);
        
        //System.out.println(Math.pow(2, -1));
        
    }
    
}
