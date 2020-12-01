/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageBox;

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
        Scanner sc = new Scanner(System.in);
        System.out.print(">>>Enter Text = ");
        String shortMessage =  sc.next();
        
        RSA testRSA = new RSA();
        testRSA.letCheckRSA(shortMessage);
        AES testAES = new AES();
        testAES.letCheckAES(shortMessage);
        
    }
    
}
