package sort;

import java.nio.IntBuffer;
import java.util.*;

/**
 * 平均时间复杂度 O(nlogn) 最坏 O(N2) 最好 O(nlogn)	不稳定
 */
public class QuickSort {

    public static void sort(int[] a) {

        helper2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    static void helper1(int a[], int left, int right) {
        if (left > right) return;
        int tmp = a[left];
        int i = left;
        int j = right;
        while (i < j) {
            //寻找右边第一个小于基准值的下标
            while (a[j] >= tmp && i < j) j--;
            a[i] = a[j];
            //寻找左边第一个大于基准值的下标
            while (a[i] <= tmp && i < j) i++;
            a[j] = a[i];
        }

        a[i] = tmp;
        helper1(a, left, i - 1);
        helper1(a, i + 1, right);
    }

    static void helper2(int a[], int left, int right){
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(left, right);
        for (Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator() ; iterator.hasNext(); ){

            left = iterator.next().getKey();
            right = map.get(left);

            iterator.remove();

            if(left >= right) continue;

            int i = left, j = right, temp = a[left];
            while(i < j){
                while(a[j] >= temp && i < j)  j--;
                a[i] = a[j];
                while(a[i] <= temp && i < j) i++;
                a[j] = a[i];
            }
            a[i] = temp;
            map.put(left, i -1);
            map.put(i+1, right);
            System.out.print("hello"+map.size());

        }

    }
}


