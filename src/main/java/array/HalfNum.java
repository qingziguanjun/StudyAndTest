package array;

public class HalfNum {
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
//			for(int k=0; k<a.length; k++){
//				System.err.print(a[k] + " ");
//			}
//			System.out.println();
			quicksort(a, left, i - 1);// 
			quicksort(a, i + 1, right);// 
		}
	    
	    public static  int majorityElement(int[] nums) {
	        int length = nums.length;
	        int num = 0;
	        quicksort(nums, 0, length -1);
	        if(length % 2 == 0){
	            num = length / 2;
	        }else{
	            num = length / 2 + 1;
	        }
	        System.out.println(num);
	        return nums[num];
	    }
	    public static void main(String[] args) {
			int[] a ={2,3,3,2,3,3,2,3,3,1,2,1,1,2,2,2,1,2,1,1,2,2,2,1,1,1,2,2,2,2,1,1,1,2,2,2,2,1,1,1,2,2,2,2,1,1,1,2,2,2,2,1,1,1,2,2,2,2,1};
			int b = majorityElement(a);
			System.out.println("************");
			System.out.println(b);
			int[] c = new int[6];
		}
}
