package algorithm.digui;

public class ClimbStairs {

	public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else{
            return climbStairs(n-1) + climbStairs(n - 2);
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = climbStairs(37);
		int b = climbStairs2(37);
		System.out.println(a);
		System.out.println(b);

	}
	
	 public static  int climbStairs2(int n) {
	        int result = 0;
	        if(n == 1){
	            result = 1;
	        }else if(n == 2){
	            result = 2;
	        } // 楼梯阶数大于2
	        else if (n > 2) {
	            // 保存全部的解法
	            int[] ways = new int[n];

	            ways[0] = 1;
	            ways[1] = 2;

	            for (int i = 2; i < ways.length; i++) {
	                ways[i] = ways[i - 1] + ways[i - 2];
	            }

	            result = ways[ways.length - 1];
	        }
	        return result;
	        
	    }

}
