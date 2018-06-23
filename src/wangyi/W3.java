package wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class W3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = in.nextInt();
        }
        int[] pos = new int[n];
        for(int i = 0; i<n; i++){
            pos[i] = i;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j <= i; j++){
                if(pos[j]>i/2){
                    pos[j] = i - pos[j];
                }else{
                    pos[j] = i + pos[j];
                }
            }
        }
        System.out.print(Arrays.toString(pos));

    }
}
