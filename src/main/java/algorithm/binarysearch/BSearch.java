package algorithm.binarysearch;

/**
 * 各种变体
 * 
 * @author sy
 *
 */
public class BSearch {

	// 第一个等于数值的
	public static int bsearchFirst(int[] a, int n, int value) {

		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				if ((mid == 0) || (a[mid - 1] != value))
					return mid;
				else
					high = mid - 1;
			}
		}
		return -1;

	}

	// 最后一个等于数值的
	public static int bsearchLast(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				if ((mid == n-1) || (a[mid + 1] != value))
					return mid;
				else
					low = mid + 1;
			}
		}
		return -1;
	}
	//查找第一个大于等于给定值的元素
		public static int bsearchFirstBigger(int[] a, int n, int value) {
			int low = 0;
			int high = n - 1;
			while (low <= high) {
				int mid = low + ((high - low) >> 1);
				if (a[mid] > value) {
					high = mid - 1;
					if ((mid == 0) || (a[mid - 1] <= value))
						return mid;
				} else if (a[mid] < value) {
					low = mid + 1;
				}
				
			}
			return -1;
		}
	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 5, 6, 8, 8, 8, 8, 12, 56 };
		int location = bsearchFirst(a, a.length, 8);
		int location2 = bsearchLast(a, a.length, 8);
		System.out.println(location);
		System.out.println(location2);
	}
}
