package shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 广度优先搜索
 */
public class Dijkstra {

    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] map = new int[][] {
                { 0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX },
                { 10, 0, 18, MAX, MAX, MAX, 16, MAX, 12 },
                { MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8 },
                { MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21 },
                { MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX },
                { 11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX },
                { MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX },
                { MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX },
                { MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0 } };

        dijkstra(map, 1);
    }

   public static void dijkstra(int[][] map, int k){
        int n = map.length;
        boolean[] visted = new boolean[n];
        List<ArrayList<Integer>> path = new ArrayList<>();
        for(int i = 0; i < n; i++){
            path.add(new ArrayList<>());
            path.get(i).add(k);
        }
        Arrays.fill(visted, false);
        int[] distance = new int[n];
        for(int i = 0; i < n; i++){
            distance[i] = map[k][i];
        }
        visted[k] = true;
        boolean finished = false;
        while(!finished){
            int min = MAX;
            int t = 0;
            for(int i = 0; i < n; i++){
                if(!visted[i] && min > distance[i]){
                    min = distance[i];
                    t = i;
                }

            }
            visted[t] = true;
            path.get(t).add(t);
            for(int i = 0; i < n; i++){
                if(!visted[i]&& map[t][i] !=MAX && distance[i] > distance[t] + map[t][i]){
                    distance[i] = distance[t] + map[t][i];
                    path.get(i).add(t);
                }
            }
            for(boolean item : visted){
                if(!item){
                    finished = false;
                    break;
                }else{
                    finished = true;
                }
            }

        }

        System.out.println("从第"+k+"个结点到其他结点最短距离："+Arrays.toString(distance));
        for(int i = 0; i < path.size(); i++){
            System.out.println("到第"+i+"个结点路径："+path.get(i).toString());
        }
   }
}
