

package PasswordCracking;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.security.NoSuchAlgorithmException; 
 
 
public class Main { 
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException { 
		BufferedReader userInput = new BufferedReader (new InputStreamReader(System.in)); 
        SHA1 sha1 = new SHA1();
        BruteForce bf = new BruteForce();
        System.out.println("Enter string:"); 
        String rawString = userInput.readLine(); 
        String enString = sha1.SHA1(rawString);
        System.out.println("SHA1 hash of string: " + enString); 

        System.out.println("Enter hash string:"); 
        String hashString = userInput.readLine(); 
        String deString = bf.BruteForce(hashString);
        System.out.println("Original string: " + deString); 

    } 
} 
