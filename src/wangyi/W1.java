package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class W1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for(int i = 0; i<n; i++){
            num[i] = in.nextInt();
        }
        Arrays.sort(num);
        int temp = num[1] - num[0];
        int i;
        for(i = 2; i<n; i++){
            if(num[i] - num[i-1] != temp) {
                break;
            }
        }
        if(i == n && (num[i-1] - num[i-2]) == temp){
            System.out.print("Possible");
        }else{
            System.out.print("Impossible");
        }



    }
}
