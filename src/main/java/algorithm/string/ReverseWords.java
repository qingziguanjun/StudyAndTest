package algorithm.string;

public class ReverseWords {

	public static String reverseWords(String s) {
		 
	        String[] array = s.split(" ");
	        if(array.length == 0) return "";
			StringBuffer sb  = new StringBuffer("");
			
			for(int i =  array.length-1 ; i >= 0; i--){
				String temp = array[i];
				if(!temp.isEmpty() && !temp.contains(" ")){
					sb.append(array[i] + " ");
				}
				
			}
		
			if(sb.length() > 0){
			return sb.substring(0, sb.length()-1);
			}else{
				return "";
			}
		
    }
	public static void main(String[] args) {
		//String s = "the sky is blue";
		String s = "the sky is blue";
		//s = "  hello world!  ";
		//s="";
		String result = reverseWords(s);
		System.out.println(result + "####");
	}
}
