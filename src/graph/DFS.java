package graph;

public class DFS {
    static int[] visited;
    public static void main(String[] args){
        int[][] map = new int[][]{
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 1, 1, 0}};
        int n = map.length;
        visited = new int[n];
        DFS(map, 0);



    }
    public static void DFS(int[][] map,int father){
        visited[father] = 1;
        System.out.println("visited"+father+"号结点");
        for(int i = 0; i < map.length; i++){
            if(visited[i]==0 && map[father][i] == 1){
                DFS(map, i);
            }
        }

    }
}
