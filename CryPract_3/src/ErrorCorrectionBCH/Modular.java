/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrorCorrectionBCH;

/**
 *
 * @author Marken Tuan Nguyen
 */
public class Modular {

    
    public Modular (){}

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
            if((i*i)%11==checkNeg(num)){
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
