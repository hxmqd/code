package sort;

import java.util.Arrays;
import java.util.Date;

public class InsertSort {
	
	public static void sort(int[] a){
		long start = new Date().getTime();
		int N = a.length;
		for(int i = 1;i < N;i++){
			for(int j = i-1;j >= 0;j--){
				if(a[j] > a[j+1]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				} else {
					break;
				}
			}
		}
		System.out.println((new Date().getTime() - start)/1000+"√Î");
		//System.out.println(Arrays.toString(a));
		
	}

}
