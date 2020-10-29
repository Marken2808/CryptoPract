/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerateSyndromes;

import java.util.Arrays;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class Syndromes {
    
    private int[] s = new int[4];
    public Syndromes(int[] d) {
        s[0] = (d[0]+  d[1]+  d[2]+  d[3]+  d[4]+  d[5]+  d[6]+  d[7]+  d[8]+   d[9])%11;
        s[1] = (d[0]+2*d[1]+3*d[2]+4*d[3]+5*d[4]+6*d[5]+7*d[6]+8*d[7]+9*d[8]+10*d[9])%11;
        s[2] = (d[0]+4*d[1]+9*d[2]+5*d[3]+3*d[4]+3*d[5]+5*d[6]+9*d[7]+4*d[8]+   d[9])%11;
        s[3] = (d[0]+8*d[1]+5*d[2]+9*d[3]+4*d[4]+7*d[5]+2*d[6]+6*d[7]+3*d[8]+10*d[9])%11;
        System.out.println(Arrays.toString(s));
    } 
    
    public int[] getSyndromes() {
        
        return s;
    }
    

}
