package algorithm.sort;

public class Quick_sort {


public static void quicksort(int[] a, int left, int right) {
		int i, j, t, temp;
		if (left > right)
			return;

		temp = a[left]; 
		i = left;
		j = right;
		while (i != j) {
			while (a[j] >= temp && i < j)
				j--;
			while (a[i] <= temp && i < j)
				i++;
			// 交换
			if (i < j) {
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		// 基准替换
		a[left] = a[i];
		a[i] = temp;
		for(int k=0; k<a.length; k++){
			System.err.print(a[k] + " ");
		}
		System.out.println();
		quicksort(a, left, i - 1);// 
		quicksort(a, i + 1, right);// 
	}

	public static void main(String[] args) {
		int[] a={4,6,3,5,2,1};
		quicksort(a, 0, a.length-1);
		System.out.println("###########	");
		for(int i=0; i<a.length; i++){
			System.err.print(a[i] + " ");
		}
	
	}
}
