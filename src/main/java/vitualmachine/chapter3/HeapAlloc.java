package vitualmachine.chapter3;
/**
 * -Xmx20m -Xms5m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
 * @author sy
 *
 */
public class HeapAlloc {

	public static void main(String[] args) {
		print();
		
		byte[] b = new byte[1*1024*1024];
		System.out.println("分配了1M的空间给数据");
		
		print();
		
		b = new byte[4*1024*1024];
		System.out.println("分配了4M的空间给数据");
		
		print();
	}

	private static void print() {
		System.out.print("maxMemory=  ");
		System.out.println(Runtime.getRuntime().maxMemory()  + " bytes");
		System.out.print("free mem =  ");
		System.out.println(Runtime.getRuntime().freeMemory()  + "bytes");
		System.out.print("total mem = ");
		System.out.println(Runtime.getRuntime().totalMemory()  + " bytes");
	}

}
