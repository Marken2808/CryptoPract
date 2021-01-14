/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThisBox;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class PRNG {
    private int seed;
    
    public PRNG () {
        this.seed = (int) (System.currentTimeMillis() % 1000);
    }
    
    public PRNG (int seed) {
        if (seed == 0 || Math.abs(seed) == 1) {
            this.seed = (int) (System.currentTimeMillis() % 1000);
        } else {
            this.seed = seed;
        }
    }
    
    public int getNextInt() {
        
        seed = getMiddleDigits(seed*seed, seed);
        
        return seed;
    }
    
    public int getMiddleDigits(int newSeed, int oldSeed) {
        String seedStr = newSeed + "";
        int seedLen = ("" + oldSeed).length();
        
        if ((seedLen % 2 == 0 && seedStr.length() % 2 != 0) || (seedLen % 2 != 0 && seedStr.length() % 2 == 0)) {
            seedStr = "0" + seedStr;    
        }
        
        while (seedStr.length() != seedLen) {
            seedStr = seedStr.substring(1, seedStr.length() - 1);
        }
        
        return Integer.parseInt(seedStr);
    }
    
    public int getSeed() {
        return seed;
    }
    
    public void setSeed(int seed) {
        this.seed = seed;
    }
}