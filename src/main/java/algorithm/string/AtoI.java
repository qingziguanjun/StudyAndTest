package algorithm.string;

public class AtoI {
	//这个好难，不对
	 public static int myAtoi(String str) {
		 //索引位数
		    int i = 0;
		    int base =0;
		    int sign = 1;
		    if(str.length()==0)
	            return 0;
	        while(str.charAt(i) == ' ')
	            i++;
	        if(str.charAt(i)  == '-'){
	        	sign = -1;
	            i++;
	        }
	        else if(str.charAt(i) == '+')
	            i++;

	        if(str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9)
	            return 0;


		    // 索引有效数字字符
		    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {

		        // that statement is used to test if the num is bigger than INT_MAX after the str[i] is handled, if base > INT_MAX/10, 
		        // then base10+ str[i] -‘0’> base10>INT_MAX, or when base== INT_MAX/10, that means all the places are the same as INT_MAX except the ones place, so str[i]>‘7’ is needed. 
		        // 上面这段是LeetCode国外站对下面代码的解释。
		        // 简单来说就是
		        // 如果`base > MAX_VALUE/10`，那么`base*10 + new_value` > `base*10` > `MAX_VALUE`。这个应该很容易理解，这种情况下就会发生溢出。
		        // 若`base == INT_MAX/10`，而且`new_value = str.charAt(i++) - '0'`大于`7`，也会发生溢出。因为`MAX_VALUE = 2147483647`
		        if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
		            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		        }

		        // 计算转换值
		        base = 10 * base + (str.charAt(i++) - '0');
		    }

		    // 计算结果值
		    return base * sign;
		
	 }
	 public static void main(String[] args) {
		String a = "42";
		int b = myAtoi(a);
		System.out.println(b);
	}
}
