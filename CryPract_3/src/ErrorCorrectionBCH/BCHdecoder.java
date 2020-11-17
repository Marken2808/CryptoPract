/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrorCorrectionBCH;

import java.util.Arrays;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class BCHdecoder {

    private final int[] s = new int[4];
    private final int[] d;
    final int[] pqr = new int[3];
    int[][] temp;
    public BCHdecoder(int[] d) {
        this.d = d;
        this.s[0] = (d[0]+  d[1]+  d[2]+  d[3]+  d[4]+  d[5]+  d[6]+  d[7]+  d[8]+   d[9]) %11;
        this.s[1] = (d[0]+2*d[1]+3*d[2]+4*d[3]+5*d[4]+6*d[5]+7*d[6]+8*d[7]+9*d[8]+10*d[9]) %11;
        this.s[2] = (d[0]+4*d[1]+9*d[2]+5*d[3]+3*d[4]+3*d[5]+5*d[6]+9*d[7]+4*d[8]+   d[9]) %11;
        this.s[3] = (d[0]+8*d[1]+5*d[2]+9*d[3]+4*d[4]+7*d[5]+2*d[6]+6*d[7]+3*d[8]+10*d[9]) %11;
//        System.out.println(Arrays.toString(s));
    } 
    
    public int[] calcPQR(){
        this.pqr[0] = Math.floorMod(s[1]*s[1] - s[0]*s[2] ,11);
        this.pqr[1] = Math.floorMod(s[0]*s[3] - s[1]*s[2] ,11);
        this.pqr[2] = Math.floorMod(s[2]*s[2] - s[1]*s[3] ,11);
        return this.pqr ;
    }
    
    public int[] calcPos(){
        int[] pos = new int[2];
        
        if(pqr[0] == 0){
            return null;
        } else {
            
            pos[0] = checkNeg((-pqr[1] + checkSqr(pqr[1]*pqr[1]-4*pqr[0]*pqr[2])) * checkPow(2*pqr[0],-1));
            pos[1] = checkNeg((-pqr[1] - checkSqr(pqr[1]*pqr[1]-4*pqr[0]*pqr[2])) * checkPow(2*pqr[0],-1));
            
            if(pos[0]-pos[1] == 0 || pos[0]==0 || pos[1] ==0){
                return null;
            } else {
                return pos;
            }
        }
    }
    
    public String check(){
        
        int cS = 0, cP = 0;
        for(int i=0; i<pqr.length; i++){
//            this.calcPQR();
            if(pqr[i] == 0){
//                System.out.println("pqr: "+pqr[i]);
                cP++;
            }
        }
        for (int i=0; i<s.length; i++){
            if(s[i] == 0){
//                System.out.println("s: "+s[i]);
                cS++;
            }
        }

        
        if(cS==s.length){
            return "No error";
            
        } else if(cP==pqr.length){
            temp = checkError(1);
            if(temp[0][0]==0){
                return "More than 2 errors";
            } else{
                System.out.println(output(temp));
                return "1 error at (i = "+temp[0][0]+" -> a = "+temp[0][1]+")";
            }
        } else if(calcPos()==null){
            return "More than 2 errors";
            
            
        } else {
            temp = checkError(2);
            System.out.println(output(temp));
            return "Only 2 errors at (i = "+temp[0][0]+ " -> a = " + temp[0][1] +") & (j = " +temp[1][0]+" -> b = " +temp[1][1]+")"; 

        }
    }
    
    public boolean checkDigit(){
        int count=0;
        for(int i:d){ 
            if(i<10){count++;} 
//            System.out.println("d: "+ i);
        }
        if(count==10){ return true; }
        return false;
    }
    
//    public boolean checkDiff(int[][] arr){
//        
//        int i=arr[0][0];
//        int j=arr[1][0];
//        
//        if(i-j!=0) return true;
//        return false;
//    }
    
    public String output(int[][] arr){
        
//        System.out.println("test: " + Arrays.deepToString(arr));
        for(int i=0; i<arr.length; i++){
            
//            System.out.println("arr: " + arr[0][0]);
//            System.out.println("arr: " + arr[0][1]);
//            System.out.println("ddd: " + d[arr[i][0]-1]);
            
            
//            d[arr[i][0]-1] = checkNeg((d[arr[i][0]]-1) - (arr[i][1]));
            d[arr[i][0]-1] = checkNeg((d[arr[i][0]-1]) - (arr[i][1]));
            
        }
        StringBuilder builder = new StringBuilder();
        for(int s : d) {
            if(checkDigit()){
                builder.append(s);
            } else {
                return "More than 2 errors. Digit include 10";
            }
        }
        return "Output:\t" + builder.toString();
    }
    
    public int[][] checkError(int error){
        
        
        switch(error){
            case 0:
                break;
            case 1:
                this.temp=new int[1][2];
                temp[0][0]= (s[1]/s[0]);
                temp[0][1]= (s[0]);
                break;
            case 2:
                int[] pos = calcPos();
                this.temp = new int[2][2];
                temp[1][0] = pos[1];
                temp[1][1] = checkNeg(checkNeg(pos[0]*s[0]-s[1]) * checkPow(pos[0]-pos[1], -1));
                temp[0][0] = pos[0];
                temp[0][1] = checkNeg(s[0]-temp[1][1]);
                
                break;
        }
        return temp;
    }
    
    
    
    public int checkNeg(int num){
        return num = Math.floorMod(num, 11);
    }
    
    public int checkPow(int num, int pow){ 
        if(pow<0){
            for(int i=0; i<i+1; i++){
                if((11*i-pow)%num==0){
                    num = (11*i-pow)/num; 
                    return checkNeg(num);
                }
            }
        } else {
            return ((num*num)%11);
        }
        return 0;
    }
    
    public int checkSqr(int num){
        for(int i=0; i<i+1; i++){
            if((int)(Math.pow(i,2))%11==checkNeg(num)){
                //System.out.println("i= " +i);
                return i;
            }
        }
        return 0;
    }
    
    public void call(){
        System.out.println("->Syn[]: " +Arrays.toString(s));
        System.out.println("->PQR[]: " +Arrays.toString(calcPQR()));
        System.out.println("check: " +check());
//        System.out.println("temp: " + Arrays.deepToString(temp));
//        test();
    }
    
    
}
