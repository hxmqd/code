package dp;

import java.util.Scanner;

//  狡猾的兔子有n个洞，编号为1到n，
//  兔子晚上只会在相邻的洞移动，猎人在白天检查其中一个洞。
//  输入n及检查天数k，接下来输入k个整数，代表检查白天检查洞的编号。
//  如果一定能抓住兔子，则输出yes,否则no
public class RabbitProblem {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] dp = new int[k][n];
        int[] visit = new int[k];
        for(int i = 0; i<k; i++) {
            visit[i] = in.nextInt();
        }
        for(int i= 0; i<n; i++){
            dp[0][i] = 1;
        }
        dp[0][visit[0]-1] = 0;
        for(int i = 0; i<k-1; i++){
            for(int j = 0; j<n; j++){
                dp[i+1][j] = 0;
            }
            for(int j = 0; j<n; j++){
                if(dp[i][j] == 1){
                    if(j==0){
                        dp[i+1][j+1] = 1;
                    } else if(j==n-1){
                        dp[i+1][j-1] = 1;
                    }else {
                        dp[i+1][j-1] = 1;
                        dp[i+1][j+1] = 1;
                    }
                    dp[i+1][visit[i+1]-1] = 0;
                }
            }
        }
        for(int i = 0; i<n; i++){
            if(dp[k-1][i] == 1){
                System.out.print("false");
                return;
            }
        }
        System.out.print("true");
    }
}
