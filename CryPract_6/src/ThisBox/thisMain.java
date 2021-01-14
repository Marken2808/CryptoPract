/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThisBox;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class thisMain {

    /**
     * @param args the command line arguments
     * @throws java.security.NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
//        System.out.print(">>>Enter msg1 = ");
//        String msg1 =  sc.nextLine();
        System.out.print(">>>Enter msg2 = ");
        String msg2 =  sc.nextLine();

        long keyGen = PRG(2808,709);
        String msgHex = StringToHex(msg2);
        String keyHex = LongToHex(keyGen);
        String xorHex = XOR(msgHex,keyHex);
        String xorBin = HexToBin(xorHex);
        int    xorInt = BinToInt(xorBin);
        System.out.println("Message -> String to hex : "+ msgHex);

        System.out.println("ori Key: "+ keyGen);
        System.out.println("KEY ->Long to hex: "+ keyHex);
        System.out.println("test Key: "+ HexToLong(keyHex));
        System.out.println("XOR: " +xorHex);
        System.out.println("Hex to Bin: "+ xorBin);
        System.out.println("Bin to Int: "+xorInt);
        
    }
    
    public static int BinToInt(String bin){
        Long decimal = Long.parseLong(bin, 2);
//        System.out.println("INPUT=" + bin + " decimal=" + ) ;
        return decimal.intValue();
    }
    
    public static String HexToBin(String s) {
        return new BigInteger(s, 16).toString(2);
    }
    
    public static String XOR(String a, String b){
        BigInteger i1 = new BigInteger(a, 16);
        BigInteger i2 = new BigInteger(b, 16);
        BigInteger res = i1.xor(i2);
        return res.toString(16);
    }
    
    public static Long PRG(int a, int b){
        long p =(long) Math.pow(2, 32);
        long seed = System.currentTimeMillis();
        seed = ((a*seed)+b) % p;
        
        return seed;
    }
    
    public static String LongToHex(long val){
        return Long.toHexString(val);
    }
    
    public static long HexToLong(String str){
        return Long.valueOf(str, 16).longValue();
    }
    
    public static String StringToHex(String str) {
        StringBuilder sb = new StringBuilder();
        //Converting string to character array
        char ch[] = str.toCharArray();
        for(int i = 0; i < ch.length; i++) {
           String hexString = Integer.toHexString(ch[i]);
           sb.append(hexString);
        }
        return sb.toString();
    }
    
    public static String HexToString(String str){
        String result = new String();
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i=i+2) {
           String st = ""+charArray[i]+""+charArray[i+1];
           char ch = (char)Integer.parseInt(st, 16);
           result = result + ch;
        }
        return result;
    }
    private static boolean isHex(String s) { // check if s is a hex string
        char b;
        int n = s.length();
        for(int i=0; i<n; i++) {
            b = s.charAt(i);
            if(b >= '0' && b <='9') continue;
            if(b >= 'a' && b <='f') continue;
            return false;
        }
	return true; 	
    }
   
}
