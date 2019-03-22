package algorithm.string;

public class ReverseArray {

	public static void reverseString(char[] s) {
		int i = 0 ,j = s.length -1;
		char temp;
		while(i < j){
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
		
		
	}
	public static void main(String[] args) {
		char[] a = {'a','b','d'};
		reverseString(a);
		System.err.println(a);
	}
}
