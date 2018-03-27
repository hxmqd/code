package sort;

import java.util.Arrays;
import java.util.Date;

public class SelectSort {
	
	public static void sort(int[] a){
		long start = new Date().getTime();
		int N = a.length;
		for(int i = 0;i < N;i++){
			int min = i;
			for(int j=i+1;j<N;j++){
				if(a[j]<a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		System.out.println((new Date().getTime() - start)/1000+"Ãë");
		//System.out.println(Arrays.toString(a));
	}

}
