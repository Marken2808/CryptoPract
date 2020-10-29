/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerateExtraInput;

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
        int d[];
        Scanner sc = new Scanner(System.in);
        d = new int[6];
        for(int i=0; i<d.length; i++) d[i]=sc.nextInt();
        
        Digit digit = new Digit(d);
        //digit.getString();
        
        System.out.println(digit.getNumberic());
    }
    
}
