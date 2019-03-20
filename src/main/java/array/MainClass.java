package array;
class Solution {
    
    public int[] quicksort(int[] a, int left, int right) {
		int i, j, t, temp;
		if (left > right)
			return a;

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
        return a;
	}
    
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int num = 0;
        int[] temp = quicksort(nums, 0, length -1);
        if(length % 2 == 0){
            num = length / 2;
        }else{
            num = length / 2 + 1;
        }
        return temp[num];
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static void main(String[] args) {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "2 3 3 2 3 3 2 3 3 1 2 1 1 2 2 2 1 2 1 1 2 2 2 1 1 1 2 2 2 2 1 1 1 2 2 2 2 1 1 1 2 2 2 2 1 1 1 2 2 2 2 1 1 1 2 2 2 2 1";
      
            int[] nums = stringToIntegerArray(line);
            System.out.println(nums);
            
            int ret = new Solution().majorityElement(nums);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        
    }
}