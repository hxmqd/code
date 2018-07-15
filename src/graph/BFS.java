package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Search
 */
public class BFS {

    static int[] visited;

    public static void main(String[] args) {
        int[][] map = new int[][]{
                { 0, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0 }};
        int n = map.length;
        visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                BFS(map, i);
            }
        }
    }

    public static void BFS(int[][] map, int start){
        int N = map.length;
        visited[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int front = queue.poll();
            System.out.print(front+" ");
            for(int i = 0; i <N; i++){
                if(visited[i] == 0 && map[front][i] == 1){
                    visited[i] = 1;
                    queue.offer(i);
                }
            }

        }

    }
}
