package array;

import java.util.ArrayList;
import java.util.List;

public class doubleNum {
	public static void main(String[] args) {
	    int[] nums = {4,3,2,7,8,2,3,1};
	    List<Integer> result = new ArrayList<Integer>();
         for(int i = 0; i < nums.length; i++){
            int temp = Math.abs(nums[i]);
            if(nums[temp-1]  >= 0){
                nums[temp-1] *= -1;
            }else{
                result.add(temp);
            }
        }
	}

}
