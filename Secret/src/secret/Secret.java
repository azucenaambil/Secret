/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secret;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cena
 */
public class Secret {
    private int N;
    private List<Integer> primeNum;
    
     /**
     * Constructor
     */
    public Secret(int N) {
        this.N = N;
        generatePrimeNums();
    }

    /**
     * Setter for property N
     */
    public void setN(int N) {
        this.N = N;
        generatePrimeNums();
    }
    
    /**
     * Dummy Function for sectret
     * @param num
     * @return int 
     */
    private int secretFunc(int num){
        return num;
    }
    
    /**
     * Evaulates if the secret function is an additive function
     * @return boolean 
     */
    public boolean isSecretAdditiveFunc(){
        boolean isSecretAdditiveFunc = true;
        
        for(int i = 0 ;i<this.primeNum.size();i ++){
            int a = this.primeNum.get(i);
            for(int j = i ;j<this.primeNum.size();j++){
             int b = this.primeNum.get(j);
                // System.out.println(a+"+"+b);
                 if(secretFunc(a+b) != secretFunc(a) + secretFunc(b)){
                    isSecretAdditiveFunc = false;
                    break;
                 }
                
            }
        }
        
        return isSecretAdditiveFunc;
    
    }
    
    /**
     * Generates the prime numbers form 1-N
     * @return boolean 
     */
    private void generatePrimeNums(){
        this.primeNum = new ArrayList<Integer>();
        
        for(int i = 2;i<N;i++){
            if(isPrime(i)){
                this.primeNum.add(i);
            }
        }
    }
    
    /**
     * Evaluates if num is a prime number
     * @return boolean 
     */
    public static boolean isPrime(int num){
        boolean isPrime = true;
        if(num < 2){
            isPrime = false;
        } else if(num > 2) {
           for (int i = 2; i <= num/2; i++) {
                if (num % i == 0) {
                        isPrime = false;
                }
           }
        }
        return isPrime;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Secret sec = new Secret(100);
        System.out.println(sec.isSecretAdditiveFunc());
    }
    
}
