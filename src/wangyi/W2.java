package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class W2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 0;
        int k  = 1;
        while(k < n){
            if(s.charAt(k) == s.charAt(k-1)) {
                dp[k] = 0;
                k++;
            }else{
                dp[k] = 2;
                k++;
                break;
            }
        }
        for(int i = k; i<n; i++) {
            if(s.charAt(i) != s.charAt(i-1)){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 1;
            }
        }
        int max = 0;
        for(int item : dp ){
            max = max > item ? max : item;
        }
        System.out.print(max);
    }
}
