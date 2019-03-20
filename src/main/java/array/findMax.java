package array;

//https://leetcode.com/problems/first-missing-positive/submissions/
public class findMax {
	 public static int firstMissingPositive(int[] nums) {
	        int n = nums.length;
	        int t = 0;
	        for(int i = 0; i < n; i++){
	            t = nums[i];
	            if( t > 0 && t <= n && t != nums[t-1]){
	                int temp = nums[t-1];
	                nums[t-1] = t;
	                nums[i] = temp;
	            }
	        }
	        for(int i=0;i<n;i++){
	             if(nums[i] < 0 && i+1 < n && nums[i+1] >0 && n >2){
	                 continue;
	             }
	             if(nums[i] >=0 && nums[i] != (i+1))
	                   return i+1;
	         }
	        return n+1;

	            
	      
	    } 
	 public static void main(String[] args) {
		int[] a= {0,-1,3,1};
		firstMissingPositive(a);
	}
}
