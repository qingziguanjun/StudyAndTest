package vitualmachine.chapter7;

import java.util.ArrayList;
import java.util.List;

public class StringTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i=0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
		
	}
	public void test(){
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1 == str2);
		System.out.println(str1 == str2.intern());
		System.out.println("abc"== str2.intern());
		System.out.println(str1.intern()== str2.intern());
		str1.length();
	}
}
