package algorithm.sort.gaoji;

import java.awt.print.Printable;

public class MergeSort {
	public static void main(String[] args) {
		int[] a = {3,5,7,2,54,3,4};
		merge_sort(a, a.length);
		PrintArray(a);
	}

	/**
	 * // 归并排序算法, A 是数组，n 表示数组大小
		merge_sort(A, n) {
		  merge_sort_c(A, 0, n-1)
		}
		
		// 递归调用函数
		merge_sort_c(A, p, r) {
		  // 递归终止条件
		  if p >= r  then return
		
		  // 取 p 到 r 之间的中间位置 q
		  q = (p+r) / 2
		  // 分治递归
		  merge_sort_c(A, p, q)
		  merge_sort_c(A, q+1, r)
		  // 将 A[p...q] 和 A[q+1...r] 合并为 A[p...r]
		  merge(A[p...r], A[p...q], A[q+1...r])
		}
	 * 
	 * 
	 */
	public static void merge_sort(int[] a, int n){
		merge_sort_c(a, 0, n-1);
	}

	public static void merge_sort_c(int[] a, int p, int r) {
		if(p >= r) return;
		int q = (p+r) / 2;
		merge_sort_c(a, p, q);
		merge_sort_c(a, q+1, r);
		//合并两个有序数组
		int i = p;
		int j = q+1;
		int k = 0;
		int[] temp = new int[r - p + 1];
		while(i <= q && j <= r){
			if(a[i] < a[j]){
				temp[k++] = a[i++];
			}else{
				temp[k++] = a[j++];
			}
		}
		while( i <= q) temp[k++] = a[i++];
		while(j <= r) temp[k++] = a[j++];
		PrintArray(temp);
		for(int m = 0; m < r - p + 1; m++){
			a[p+m] = temp[m];
		}
		
		
	}
	public static void PrintArray(int[] a){
		for(int i = 0; i< a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("--------------");
	}
}
