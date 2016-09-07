/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

/**
 *
 * @author mahinjm
 */
public class CoinChange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int arr[] = {1,2,5,12};
        int n = arr.length-1;
        int amount = 23;
        System.out.println(CoinChangeDP(arr, amount, n));

    }
    
    
    
    //Coin Change in Recursion
    public static int CoinChangeRecursion(int C[], int T,  int n){
        
        if(n==0){
            return 1;
        }
        
        if(n<1){
            return 0;
        }
        
        // Check total amount is greater than 0 and Total Coin use greater than 0
        if(T<=0 && n>0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= n; i++) {
            if(C[i] <= T) 
                min = Math.min(min, CoinChangeRecursion(C, T-C[i], n) + 1);
        }
        return min;
    }
    
    
    
    //Coin Change in Dynamic Programming
    public static int CoinChangeDP(int C[], int T,  int n){
        int result[] = new int[T+1];
        
        result[0]=0;
        
        int length = C.length-1;
        
        for(int j = 1; j <=T; j++) {
            result[j] = Integer.MAX_VALUE;
            for(int i = 0; i <= length; i++) {
                if(j >= C[i] && 1 + result[j-C[i]] < result[j] ) {
                    result[j] = 1 + result[j-C[i]];
                }
            }
        }
        
        return result[T];
    }
    
    
    
    //Coin Change in Loop
    public static int CoinChangeLoop(int C[], int T,  int n){
        int flag=0;
        int length = C.length-1;
        
        if(n==0){
            return 1;
        }
        
        if(n<1){
            return 0;
        }
        
        // Check total amount is greater than 0 and Total Coin use greater than 0
        if(T<=0 && n>0){
            return 0;
        }
        
        for(int i=length;i>=0;){
            if(T>=C[i]){
                T=T-C[i];
                ++flag;
            }else{
                length = length-i;
                i--;
            }
        }
        
        return flag;
    }
    
}
