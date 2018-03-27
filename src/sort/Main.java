package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		
		char[] array = s.toCharArray();
		int[] hash = new int[10];
		Arrays.fill(hash,0);
		for(int i = 0;i < array.length; i++){
			hash[(int)(array[i]-'0')]++;
		}
		for(int i = 0;i<hash.length;i++){
			if(hash[i]==0) {
				if(i==0){
					System.out.println(10);break;
				} else {
					System.out.println(i);break;
				}
			}
		}
		int min = hash[1];int t = 1;
		for(int i = 1;i<hash.length;i++){
			if(min> hash[i]){
				t = i;
				min = hash[i];
			}
		}
			int sum = 0,base=1;
			for(int j=0;j<min;j++){
				sum+=t*base;
				base*=10;
			}
			System.out.println(sum);
		}
		

}
