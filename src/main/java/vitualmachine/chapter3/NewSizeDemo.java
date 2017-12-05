package vitualmachine.chapter3;
/**
 * -XX:SurvivorRatio = eden/from = eden/to
 * 1m无法容纳容纳，都往老年代放：
 *   -Xmx20m -Xms20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * 7M足够大：但是要三次垃圾回收，为什么三次？  不过还是放不下10m，下面接着加大15M
 *   -Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 *   注意比率，这样就可以全部放下，没有垃圾回收了
 *   -Xmx20m -Xms20m -Xmn15m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 *   
 *   XX:NewRatio=老年代/新生代
 *   新生代只有6M左右，需要垃圾回收，最后
 *   -Xmx20m -Xms20m  -XX:NewRatio=2 -XX:+PrintGCDetails
 * @author sy
 *
 */
public class NewSizeDemo {
	public static void main(String[] args) {
		byte[] b = null;
		for(int i = 0; i < 1; i++){
		    System.out.println(i);
			b = new byte[1*1024*1024];
		}
	}
}
