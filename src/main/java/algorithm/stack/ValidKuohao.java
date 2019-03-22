package algorithm.stack;

import java.util.Stack;

public class ValidKuohao {
	//使用栈确实非常巧妙啊
	//一开始肯定是左边的 不停的入栈就行
	//遇到右边的，就从栈推出一个pop  这个要和 i这时候对应的一样，不然就是错的
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
 
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
 
                char topChar = stack.pop();
                if(ch == ')' && topChar != '('){
                    return false;
                }else if(ch == ']' && topChar != '['){
                    return false;
                }else if(ch == '}' && topChar != '{'){
                    return false;
                }
            }
        }
 
        return stack.isEmpty();
    }
}
