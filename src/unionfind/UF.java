package unionfind;

import java.util.Arrays;

/**
 * 加权 quick-union 算法
 */
public class UF {

    private int[] parent;

    private int[] sz;

    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(sz, 1);
    }

    public int find(int x) {
        while (x != parent[x]) x = parent[x];
        return x;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            parent[i] = j;
            sz[j] += sz[i];
        } else {
            parent[j] = i;
            sz[i] += sz[j];
        }
    }


}
