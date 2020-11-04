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
    public BCHdecoder(int[] d) {
        this.d = d;
        this.s[0] = (d[0]+  d[1]+  d[2]+  d[3]+  d[4]+  d[5]+  d[6]+  d[7]+  d[8]+   d[9]) %11;
        this.s[1] = (d[0]+2*d[1]+3*d[2]+4*d[3]+5*d[4]+6*d[5]+7*d[6]+8*d[7]+9*d[8]+10*d[9]) %11;
        this.s[2] = (d[0]+4*d[1]+9*d[2]+5*d[3]+3*d[4]+3*d[5]+5*d[6]+9*d[7]+4*d[8]+   d[9]) %11;
        this.s[3] = (d[0]+8*d[1]+5*d[2]+9*d[3]+4*d[4]+7*d[5]+2*d[6]+6*d[7]+3*d[8]+10*d[9]) %11;
//        System.out.println(Arrays.toString(s));
    } 

    BCHdecoder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int[] calcPQR(){
        this.pqr[0] = Math.floorMod(s[1]*s[1] - s[0]*s[2] ,11);
        this.pqr[1] = Math.floorMod(s[0]*s[3] - s[1]*s[2] ,11);
        this.pqr[2] = Math.floorMod(s[2]*s[2] - s[1]*s[3] ,11);

        return this.pqr ;
    }
    
    public String check(){
        
        int cS = 0, cP = 0;
        for(int i=0; i<pqr.length; i++){
            if(pqr[i] == 0){
//                System.out.println("pqr: "+i);
                cP++;
            }
        }
        for (int i=0; i<s.length; i++){
            if(s[i] == 0){
//                System.out.println("s: "+i);
                cS++;
            }
        }
        
        
        
        if(cS==s.length){
            return "no error";
        }
        else if(cP==pqr.length ){
            return "1 error at pos = "+(s[1]/s[0])+" & mag = "+(s[0]);
        } else {
            int i = Math.floorMod(((-pqr[1] + (int)Math.sqrt(pqr[1]*pqr[1]-4*pqr[0]*pqr[2])) / (2*pqr[0])) ,11);
            int j = Math.floorMod((-pqr[1] - (int)Math.sqrt(pqr[1]*pqr[1]-4*pqr[0]*pqr[2])) / (2*pqr[0]) ,11);
            return "2 errors at i = "+i+" & j = " +j;
        }
    }
    
    public void call(){
        System.out.println(" d[]: " +Arrays.toString(d));
        System.out.println(" S[]: " +Arrays.toString(s));
        System.out.println("pqr[]: " + Arrays.toString(calcPQR()));
        System.out.println("check: " +check());
    }
    
    
}
