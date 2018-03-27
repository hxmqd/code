package sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void sort(int[] a){
		helper(a, 0, a.length-1);		
	}
	
	//自顶向上的归并排序
	public static void helper(int[] a){
		int N = a.length;
		for(int i = 1;i<N;i*=2){
			for(int j = 0; j < N-i; j+= i*2){
				mergeArray(a, j, j+i-1, Math.min(j+i*2-1, N-1));
			}
		}
	}
	//自顶向下的归并排序
	public static void helper(int[] a,int lo, int hi){
		if(hi<=lo) return;
		int mid = (lo+hi)/2;
		helper(a, lo, mid);
		helper(a, mid+1, hi);
		mergeArray(a, lo, mid, hi);
	}
	public static void mergeArray(int[] a,int first,int mid, int last){
		int i = first, j = mid +1;
		int m = mid, n = last;
		int k = 0;
		int temp[] = new int[last-first+1];
		while(i <= m && j <= n){
			if (a[i] <= a[j])
				temp[k++] = a[i++];
			else 
				temp[k++] =a[j++];
		}
		while(i <= m)
			temp[k++] = a[i++];
		while(j <= n)
			temp[k++] = a[j++];
		for(i = 0; i< k; i++){
			a[first + i] = temp[i];
		}
	}

}
