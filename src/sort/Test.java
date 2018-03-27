package sort;

public class Test {
	
	public static void main(String[] args){
		//SelectSort.sort(new int[]{2,3,4,1,9,3,4,6});
		int[] array = new int[10];
		BST bst = new BST();
		for (int i =0;i < 10;i++) {
			// array[i] = (int)(Math.random()*10);
			bst.put((int)(Math.random()*10), (int)(Math.random()*10));
		}
		//QuickSort.sort(array);
		System.out.println(bst.get(3));
	}

}
