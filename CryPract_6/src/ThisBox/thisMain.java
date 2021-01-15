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
import java.util.Arrays;
import java.util.Random;
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
        System.out.print(">>>Enter msg1 = ");
        String msg1 =  sc.nextLine();
        String[] msgArray = msg1.split("[// ]");
        System.out.print(">>>Enter msg2 = ");
        String msg2 =  sc.nextLine();    
        
        String keyGen = PRG(288,709);
        System.out.println("[Generate Key: "+ keyGen+"]");        

        System.out.println("-------------------------------");
        String encrypted = Encrypt(keyGen, msg2);
        System.out.println("Encrypted: "+ encrypted);
        
        insert(msg1,encrypted);
//        
//        System.out.println("-------------------------------");
//        String decrypted = Decrypt(keyGen, encrypted);
//        
//        System.out.println("<<<Return msg2 = "+decrypted);
    }
//    hello, my name is tuan, i am living at 709, Filton Avenue, Bristol, BS34 7JZ
    public static void insert(String msg1, String msg2){
        StringBuilder sb = new StringBuilder();
        String[] msg1Array = msg1.split("[ ]");
        String[] msg2Array = msg2.split("(?!^)");
        String symbol = "¬~`!@£#$%^&*-_=+[{()}]\\|/;:'\",<.>/?";
        
        if(isLongMsg(msg1Array, msg2Array)){
            int count = 0;
            for(int i=0; i<msg2Array.length; i++){
//                System.out.println("arr: " + msg1Array[i]);
                char sym = symbol.charAt(new Random().nextInt(symbol.length()));
                
                String test = sym+msg2Array[i]+msg1Array[i];
//                System.out.println("test: "+test);
                sb.append(test).append(" ");
                count++;
            }

            String[] rest = (Arrays.copyOfRange(msg1Array, count, msg1Array.length));
            for(String r: rest){
                sb.append(r).append(" ");  
            }
            System.out.println("new string: "+sb.toString());
        } else {
            System.out.println("<lessthan");
        }
        
        
    }
    
    public static boolean isLongMsg(String[] msg1, String[] msg2){
        if(msg1.length==msg2.length||msg1.length>msg2.length){
            return true;
        } else {
            return false;
        }
    }
    
    
    public static String Encrypt(String KEY, String MSG){
        String msgHex = StringToHex(MSG);
        String keyHex = DecToHex(KEY);
        String xorHex = XOR(msgHex,keyHex);
        String xorBin = HexToBin(xorHex);
        String xorDec = BinToDec(xorBin);
        
        
//        System.out.println("MSG ->Str to hex: "+ msgHex);
//        System.out.println("KEY ->Dec to Hex: "+ keyHex);
//        System.out.println("XOR (Hex): " +xorHex);
//        System.out.println("XOR ->Hex to Bin: "+ xorBin);
////        System.out.println("XOR ->Bin to Dec: "+xorDec);
        
        return xorDec;
    }
    
    public static String Decrypt(String KEY, String ENC){
        String keyHex = DecToHex(KEY);
        String decBin = DecToBin(ENC);
        String binHex = BinToHex(decBin);
        String xorHex = XOR(binHex, keyHex);
        String msgStr = HexToString(xorHex);
        
//        System.out.println("XOR ->Dec to Bin: "+ decBin);
//        System.out.println("XOR ->Bin to Hex: "+ binHex);
//        System.out.println("XOR BACK: "+ xorHex);
////        System.out.println("MSG BACK: "+ msgStr);
        
        return msgStr;
    }
    
    
    
    public static String BinToDec(String bin){
        return new BigInteger(bin, 2).toString(10);
    }
    
    public static String DecToBin(String dec){
        return new BigInteger(dec, 10).toString(2);
    }
    
    public static String HexToBin(String hex) {
        return new BigInteger(hex, 16).toString(2);
    }
    
    public static String BinToHex(String bin){
        return new BigInteger(bin, 2).toString(16); 
    }
    
    public static String DecToHex(String dec){
        return new BigInteger(dec, 10).toString(16); 
//        return Long.toHexString(val);
    }
    
    public static String HexToDec(String hex){
        return new BigInteger(hex, 16).toString(10); 
//        return Long.valueOf(str, 16);
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
   
    public static String XOR(String a, String b){
        BigInteger i1 = new BigInteger(a, 16);
        BigInteger i2 = new BigInteger(b, 16);
        BigInteger res = i1.xor(i2);
        return res.toString(16);
    }
    
    public static String PRG(int a, int b){
        long p =(long) Math.pow(2, 32);
        long seed = System.currentTimeMillis();
        seed = ((a*seed)+b) % p;
        
        return Long.toString(seed);
    }
}
