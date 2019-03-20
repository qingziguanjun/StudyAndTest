package algorithm.sort.gaoji;

import array.findMax;

public class QuickSortFindKMax {

	public static void main(String[] args) {
		int[] a = {3,2,1,5,6,4};
		findMax(a, a.length, 2);
		MergeSort.PrintArray(a);

	}
	/**
	 * 
	 * // 快速排序，A 是数组，n 表示数组的大小
		quick_sort(A, n) {
		  quick_sort_c(A, 0, n-1)
		}
		// 快速排序递归函数，p,r 为下标
		quick_sort_c(A, p, r) {
		  if p >= r then return
		  
		  q = partition(A, p, r) // 获取分区点
		  quick_sort_c(A, p, q-1)
		  quick_sort_c(A, q+1, r)
		}

	 */
	public static void findMax(int[] a, int n, int k){
		int num = find(a , 0, n-1, k);
		System.out.println(num);
		System.out.println(a[num-1]);
	}
	
	public static int find(int[] a, int p, int r, int k) {
		if(p > r) return 0;
		
		int q = partition(a, p, r);
		if(q + 1 == k){
			return k;
		}else if(q + 1 > k){
			return find(a, p, q-1, k);
		}else{
			return find(a, q+1, r, k);
		}
		
		
		
	}
	public static int partition(int[] a, int p, int r) {
		int pivot = a[r];
		int i = p;
		// 选择最后一个作为标准
		// 开始 i j 都是p
		//如果 a[j] 比基准下，a[j] 就和a[i]换一下  i++
		//否则 i不变， j 继续遍历下一个  
		//这样就是  比基准小的都到左边了
		for(int j = p; j <= r; j++){
			if(a[j] > pivot){
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i = i+1;
			}
		}
		int temp = a[i];
		a[i] = a[r];
		a[r] = temp;
		return i;
	}

}
