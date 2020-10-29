/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModularArithmetic;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class Operation {

    public long getOperation(int n1, String op, int n2){
        long remain = 0;
        switch(op){
            case "+":
                remain = (n1+n2)%11;
                break;
            case "x":
            case "*":
                remain = (n1*n2)%11;
                break;
            case "/":
            case ":":
                if(n1<n2){
                    for(int i=0; i<i+1; i++){
                        if((11*i+1)%n2==0){
                            remain = (11*i+1)/n2;
                            System.out.println("i= "+i);
                            break;
                        }
                    }
                } else remain = (n1/n2)%11; break;
        }
        return checkNeg(remain);
    }
    
    public long checkNeg(long remain){
        double temp; 
        if (remain <0){
            return remain = Math.floorMod(remain, 11);
        } else
            return remain;
    }
   
    
}
