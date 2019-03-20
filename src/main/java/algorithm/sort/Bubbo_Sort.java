package algorithm.sort;

public class Bubbo_Sort {

	public static void main(String[] args) {
		int[] a = {3,5,7,2,54,3,4};
		bubbleSort(a);
	}
	public static void bubbleSort(int[] a){
		int n = a.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n -i-1; j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] =a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println();
		
	}
}
