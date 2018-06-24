package graph;

import java.util.Arrays;

public class Kruskal {

    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0,10,MAX,MAX,MAX,11,MAX,MAX,MAX},
                {10,0,18,MAX,MAX,MAX,16,MAX,12},
                {MAX,MAX,0,22,MAX,MAX,MAX,MAX,8},
                {MAX,MAX,22,0,20,MAX,MAX,16,21},
                {MAX,MAX,MAX,20,0,26,MAX,7,MAX},
                {11,MAX,MAX,MAX,26,0,17,MAX,MAX},
                {MAX,16,MAX,MAX,MAX,17,0,19,MAX},
                {MAX,MAX,MAX,16,7,MAX,19,0,MAX},
                {MAX,12,8,21,MAX,MAX,MAX,MAX,0}
        };
        kruskal(map);
    }

    public static void kruskal(int[][] map) {

        int num = map.length;

        int[] group = new int[num];
        int[] group_size = new int[num];

        for(int i = 0; i < group.length; i++){
            group[i] = i;
        }
        Arrays.fill(group_size, 1);

        boolean finished = false;

        int sum = 0, p = 0, q = 0;

        while(!finished){

            int min = Integer.MAX_VALUE;

            for(int i = 0; i < num; i++){
                for(int j = i + 1; j < num; j++){
                    if(map[i][j] < min){
                        if(group[i] != group[j]){
                            min = map[i][j];
                            p = i;
                            q = j;
                        }
                    }
                }
            }

            if(min == Integer.MAX_VALUE){
                continue;
            }
            System.out.println(p + " ---> " + q + " " + min);
            sum += min;

            if(group_size[p] >= group_size[q]){
                int tmp = group[q];
                for(int m = 0; m < group.length; m++){
                    if(group[m] == tmp){
                        group[m] = group[p];
                    }
                }
                group_size[p] += group_size[q];
            } else {
                int tmp = group[p];
                for(int m = 0; m < group.length; m++){
                    if(group[m] == tmp){
                        group[m] = group[q];
                    }
                }
                group_size[q] += group_size[p];

            }

            for(int i = 0; i < group.length; i++) {
                if(group[i] != group[0]){
                    finished = false;
                    break;
                }
                else{
                    finished = true;
                }
            }

            if(finished) {
                break;
            }

        }
        System.out.println(" sum:"+sum);

    }

}
