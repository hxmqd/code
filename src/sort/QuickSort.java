package sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void sort(int[] a){
		
		helper(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	
	public static void helper(int[] a, int left, int right){
		if(left>right) return;
		int tmp = a[left];
		int i = left, j =right;
		while(i<j){
			while(a[j]>=tmp&&i<j){
				j--;
			}
			while(a[i]<=tmp&&i<j){
				i++;
			}
			if(i<j){
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		a[left] = a[i];
		a[i] = tmp;
		helper(a, left, i-1);
		helper(a, i+1, right);
	}

}

