/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Scanner;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int in1 = sc.nextInt();
        System.out.println("in1: "+in1);
        int in2 = sc.nextInt();
        System.out.println("in2: "+in2);
        
        for(int i=0; i < 500;){
            for(int j=0;j<65;j++){
                if((in1*i - in2*j == 1)){
                    
                System.out.println("At i = " +i);
                }
            }
        }
    }
    
}
