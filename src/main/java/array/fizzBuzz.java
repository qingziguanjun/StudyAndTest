package array;

import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.impl.NewPooledConnection;

public class fizzBuzz {
	
	public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        for(int i =1; i <= n; i++){
            String temp = ""+ n;
            if(n % 3 ==0 && n % 5 == 0){
                temp = "FizzBuzz";
            }else if(n % 3 ==0){
                temp = "Fizz";
            }else if(n % 5 ==0){
                temp = "Buzz";
            }
            list.add(temp);
        }
        return list;
    }

	public static void main(String[] args) {
		System.err.println( 2 ^ 2 ^ 3);

	}

}
