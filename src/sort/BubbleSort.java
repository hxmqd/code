package sort;

public class BubbleSort {
    public static void bubbleSort(int a[]){
        int n = a.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n - i; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
    //设置标志性变量，记录交换位置
    public static void bubbleSort_1(int a[]){
        int n = a.length;
        int i = n - 1;
        while(i > 0) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    pos = j;
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
            i = pos;
        }
    }

    public static void bubbleSort_2(int a[]){
        int n = a.length;
        int low = 0;
        int high = n - 1;
        int tmp, j;
        while(low < high){
            for(j = low; j < high; ++j) {
                if (a[j] < a[j - 1]) {
                    tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
                --high;
            }
            for(j = high; j>low; --j){
                if(a[j]<a[j-1]){
                    tmp = a[j]; a[j] = a[j-1]; a[j-1] = tmp;
                }
            }
            ++low;

            }
        }
}
