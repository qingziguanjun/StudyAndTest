package vitualmachine.chapter2;

/**
 *  用参数 -XX:+PrintGC执行
 * @author sy
 *
 */

public class GcTest {
	public static  void localvarGC1(){
		byte[] a = new byte[6*1024*1024];
		System.gc();
	}
	
	public static  void localvarGC2(){
		byte[] a = new byte[6*1024*1024];
		a=null;
		System.gc();
	}
	
	
	public static  void localvarGC3(){
		{
			byte[] a = new byte[6*1024*1024];
		}
		System.gc();
	}
	
	
	public static  void localvarGC4(){
		{
			byte[] a = new byte[6*1024*1024];
		}
		int c = 10;
		System.gc();
	}

	public static void main(String[] args) {
		localvarGC1();
		localvarGC2();
		localvarGC3();
		localvarGC4();
	}
}
