package sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 平均 O(n2) 最好 O(n2) 最差(n2)
 */
public class SelectSort {
    //简单选择排序
    public static void sort(int[] a) {
        long start = new Date().getTime();
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        System.out.println((new Date().getTime() - start) / 1000 + "ms");
        //System.out.println(Arrays.toString(a));
    }

    //二元选择排序
    public static void selectTwoSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int min = i;
            int max = n - 1 - i;
            int tmp = 0;
            for (int j = i + 1; j < n - 1 - i; j++) {
                if (a[j] < a[min]) {
                    min = j;
                    continue;
                }
                if (a[j] > a[max]) {
                    max = j;
                }
            }
            tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
            tmp = a[max];
            a[max] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }

    }

}
