package sort;

import java.util.Date;

public class ShellSort {
	
	 public static void sort(int[] data) {  
			long start = new Date().getTime();
	        int h = 1;  
	        while (h <= data.length / 3) {  
	            h = h * 3 + 1;  
	        }  
	        while (h > 0) {  
	            for (int i = h; i < data.length; i += h) {  
	                if (data[i] < data[i - h]) {  
	                    int tmp = data[i];  
	                    int j = i - h;  
	                    while (j >= 0 && data[j] > tmp) {  
	                        data[j + h] = data[j];  
	                        j -= h;  
	                    }  
	                    data[j + h] = tmp;  
	                }  
	            }  
	            // �������һ��hֵ  
	            h = (h - 1) / 3;  
	        }
			System.out.println((new Date().getTime() - start)/1000+"��");
	    }

}
