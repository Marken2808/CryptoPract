/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModularInverse;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class Modular {

    
    public Modular (){}

    public long checkNeg(long num){
        if (num <0){
            return num = Math.floorMod(num, 11);
        } else
            return num;
    }
    
    public long checkPow(long num, int pow){ 
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
    
    public long checkSqr(long num){
        for(int i=0; i<i+1; i++){
            if((i*i)%11==num){
                //System.out.println("i= " +i);
                return i;
            }
        }
        return 0;
    }
    
//   if(n1<n2){
//                    for(int i=0; i<i+1; i++){
//                        if((11*i+1)%n2==0){
//                            remain = (11*i+1)/n2;
//                            System.out.println("i= "+i);
//                            break;
//                        }
//                    }
//                } else remain = (n1/n2)%11; break;
    
}
