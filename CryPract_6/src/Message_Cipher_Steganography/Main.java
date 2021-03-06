/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message_Cipher_Steganography;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print(">>>Enter msg1 = ");
        String msg1 =  sc.nextLine();
        
        String keyGen = PRG(288,709);
        System.out.println("<Generate Key: "+ keyGen+">"); 
        
        System.out.print(">>>Enter msg2 = ");
        String msg2 =  sc.nextLine();    
        

        System.out.println("-------------------------------");
        String enMsg2 = Encrypt(keyGen, msg2);
        System.out.println("Encrypted Msg2: "+ enMsg2);
        
        String allEncryptMsg = mergeMsg(msg1,enMsg2);
        System.out.println("Merged message: " + allEncryptMsg);
        
//        getKey(allEncryptMsg);
        
        
        System.out.println("-------------------------------");
        String decrypted = Decrypt(keyGen,splitMsg(allEncryptMsg));
        
        System.out.println("Decrypted Msg2 = "+decrypted);
    }
    
    
    public static String[] Symbol(){
        String symbol = "©®¬~`#^*-_=[{}]\\|;:<>/";
        return symbol.split("(?!^)");
    }
    
    public static boolean hasSymbol(String inputStr) {
        for(int i=0; i < Symbol().length; i++){
            if(inputStr.contains(Symbol()[i])){
                return true;
            }
        }
        return false;
    }
    
    public static String splitMsg(String enMsg){
        StringBuilder sb = new StringBuilder();
        String[] enMsgArray = enMsg.split("[ ]");
                
        for(String msg: enMsgArray){
            if(hasSymbol(msg)){
                sb.append(msg.substring(1, 2));
            }
        }
        return sb.toString();
        
    }
    
//    hello, my name is tuan, i am living at 709, Filton Avenue, Bristol, BS34 7JZ
    public static String mergeMsg(String msg1, String enMsg2){
        StringBuilder sb = new StringBuilder();
        String[] msg1Array = msg1.split("[ ]");
        String[] enMsg2Array = enMsg2.split("(?!^)");
        
        if(isMsgLonger(msg1Array, enMsg2Array)){
            int count = 0;
            for(int i=0; i<enMsg2Array.length; i++){
//                System.out.println("arr: " + msg1Array[i]);
//                char sym = symbol.charAt(new Random().nextInt(symbol.length()));

            int rand = new Random().nextInt(Symbol().length);
            String sym = Symbol()[rand];
                
//                System.out.println("test: "+test);
                sb.append(sym).append(enMsg2Array[i]).append(msg1Array[i]).append(" ");
                count++;
            }

            String[] rest = (Arrays.copyOfRange(msg1Array, count, msg1Array.length));
            for(String r: rest){
                sb.append(r).append(" ");  
            }
        } else {
            
            for(String digit: enMsg2Array){
                int rand = new Random().nextInt(Symbol().length);
                String sym = Symbol()[rand];
                sb.append(sym).append(digit).append(" ");
            }
            for(String word: msg1Array){
                sb.append(word).append(" ");
            }
        }
        
        return sb.toString();
    }
    
    public static boolean isMsgLonger(String[] msgArr, String[] encArr){
        return (msgArr.length==encArr.length||msgArr.length>encArr.length);
    }
    
    
    public static String Encrypt(String KEY, String MSG){   //param key, msg 1 input
        String msgHex = StrToHex(MSG);                      //change msg to hex
        String keyHex = DecToHex(KEY);                      //change key to hex
        String xorHex = XOR(msgHex,keyHex);                 //combine key, msg1
        String xorBin = HexToBin(xorHex);                   //that result to binary
        String xorDec = BinToDec(xorBin);                   //change to decimal
        
        
//        System.out.println("MSG ->Str to hex: "+ msgHex);
//        System.out.println("KEY ->Dec to Hex: "+ keyHex);
//        System.out.println("XOR (Hex): " +xorHex);
//        System.out.println("XOR ->Hex to Bin: "+ xorBin);
////        System.out.println("XOR ->Bin to Dec: "+xorDec);
        
        return xorDec;
    }
    
    public static String Decrypt(String KEY, String ENC){   //param key, encrypted ciphertext
        String keyHex = DecToHex(KEY);                      //change key to hex
        String decBin = DecToBin(ENC);                      //change encrypted msg2 to binaray
        String binHex = BinToHex(decBin);                   //bin to hex
        String xorHex = XOR(binHex, keyHex);                //combine hex key and hex msg2
        String msgStr = HexToStr(xorHex);                   // to string
        
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
    
    public static String StrToHex(String str) {
        StringBuilder sb = new StringBuilder();
        //Converting string to character array
        char ch[] = str.toCharArray();
        for(int i = 0; i < ch.length; i++) {
           String hexString = Integer.toHexString(ch[i]);
           sb.append(hexString);
        }
        return sb.toString();
    }
    
    public static String HexToStr(String str){
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
    
    public static String PRG(int a, int b){     //Random key generated, i used a=288, b=709
        long p =(long) Math.pow(2, 32);         //pick large period
        long seed = System.currentTimeMillis(); //starting at milis value because not repeat result
        seed = ((a*seed)+b) % p;                //Linear function
        
        return Long.toString(seed);
    }
}
