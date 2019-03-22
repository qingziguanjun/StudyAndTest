package algorithm.find;

public class Sqrt {

    public static int sqrt(int x) {
        if(x<=1) {
            return x;
        }
        
        int begin = 1;
        int end   = x;
        int middle = 0;
        while(begin<=end) {
            middle = begin + (end - begin)/2;
            System.out.println(begin +  " " + end  +  " " + middle +  " ");
            //不要写成middle*middle==x，会溢出
            if(middle == x/middle) {
                return middle;
            } else {
                if (middle < x/middle) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }    
        } 
        System.out.println(11111);
        System.out.println("##########");
        System.out.println(begin +  " " + end  +  " " + middle +  " ");
        //结束条件end一定<begin，所以返回end
        return end;
    }
	
	public static void main(String[] args) {
		int a = sqrt(99);
		System.out.println(a);
	}
}
