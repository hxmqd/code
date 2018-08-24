package graph;

import java.util.Arrays;

public class Prim {

    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX},
                {10, 0, 18, MAX, MAX, MAX, 16, MAX, 12},
                {MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8},
                {MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21},
                {MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX},
                {11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX},
                {MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX},
                {MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX},
                {MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0}};
        prim(map);
    }

    public static void prim(int[][] a) {
        int n = a.length;
        int sum = 0;
        int u[] = new int[n];   // 结点是否访问过
        int w[] = new int[n];
        int b[] = new int[n];   // 初始化每个结点前驱结点为0结点

        Arrays.fill(u, 0);
        Arrays.fill(b, 0);

        // 初始化每个结点最短路径为到结点0的距离
        for (int i = 0; i < n; i++) {
            w[i] = a[0][i];
        }

        u[0] = 1;   //从0结点开始
        int min, k;
        for (int i = 1; i < n; i++) {
            min = MAX;
            k = 0;
            for (int j = 1; j < n; j++) {
                if (u[j] == 0 && w[j] < min) {   //得到到访问顶点到未访问顶点的最短路径以及对应顶点k
                    min = w[j];
                    k = j;
                }
            }
            u[k] = 1;
            sum += min;
            System.out.println(b[k] + " ---> " + k + " " + min);
            for (int j = 1; j < n; j++) {
                if (u[j] == 0 && a[k][j] < w[j]) {
                    w[j] = a[k][j];
                    b[j] = k;
                }
            }
        }
        System.out.print(" sum:" + sum);
    }
}
