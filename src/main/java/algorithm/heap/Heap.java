package algorithm.heap;

public class Heap {
	private int[] a; // 数组，从下标 1 开始存储数据
	private int n; // 堆可以存储的最大数据个数
	private int count; // 堆中已经存储的数据个数

	public Heap(int capacity) {
		a = new int[capacity + 1];
		n = capacity;
		count = 0;
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void insert(int data) {
		if (count >= n)
			return; // 堆满了
		++count;
		a[count] = data;
		int i = count;
		/**
		 * 这个地方很关键，如何判断，二叉树是 一分2, 需要从1 开始， 每个下面都挂这两个， 这两个 除以2，得到的整数就是
		 */
		while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化

			swap(a, i, i / 2); // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
			i = i / 2;
		}
	}

	public void printArray() {
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.err.print(a[i] + " ");
		}
		System.out.println("#################");
	}

	public static void main(String[] args) {
		Heap h = new Heap(10);
		for (int i = 1; i < 11; i++) {
			h.insert(i);
			h.printArray();
		}

	}

	// ------------------------------------------
	// 删除数据

	public void removeMax() {
		if (count == 0)
			return; // 堆中没有数据
		a[1] = a[count];
		--count;
		heapify(a, count, 1);
	}

	private void heapify(int[] a, int n, int i) { // 自上往下堆化
		while (true) {
			int maxPos = i;
			if (i * 2 <= n && a[i] < a[i * 2])
				maxPos = i * 2;
			if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1])
				maxPos = i * 2 + 1;
			if (maxPos == i)
				break;
			swap(a, i, maxPos);
			i = maxPos;
		}
	}

}
