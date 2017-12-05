package vitualmachine.chapter2;

/**
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:-UseTLAB -XX:+EliminateAllocations
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintHeapAtGC -XX:-UseTLAB -XX:+EliminateAllocations
 * 目录要先建好
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintHeapAtGC -XX:-UseTLAB -XX:+EliminateAllocations -Xloggc:D:/log/gc.log
 * 类加载顺序：-XX:+TraceClassLoading
 * 虚拟机明显配置：-XX:+PrintVMOptions
 * 虚拟机隐式配置：-XX:+PrintCommandLineFlags
 * 打印所有系统参数：-XX:+PrintFlagsFinal
 * @author sy
 *
 */
public class OnStackTest {
	
	public static class User{
		public int id = 0;
		public String name = "";
	}
	
	public static void alloc(){
		User u = new User();
		u.id = 5;
		u.name = "geym";
	}

	public static void main(String[] args) {
		long b =System.currentTimeMillis();
		for(int i = 0; i < 100000000; i++){
			alloc();
		}
		long e = System.currentTimeMillis();
		System.err.println(e-b);
	}
	

}
