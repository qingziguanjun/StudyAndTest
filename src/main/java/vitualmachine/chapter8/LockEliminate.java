package vitualmachine.chapter8;

/**关闭所消除，每次append都申请锁，速度变慢
 * -server -XX:+DoEscapeAnalysis -XX:-EliminateLocks -Xcomp -XX:-BackgroundCompilation -XX:BiasedLockingStartupDelay=0
 * @author sy
 *
 */
public class LockEliminate {
	private static final int CIRCLE = 2000000;
	public static void main(String[] args) throws InterruptedException{
		long start = System.currentTimeMillis();
		for(int i=0; i<CIRCLE; i++){
			createStringBuffer("JVM", "Diagnosis");
		}
		long bufferCost = System.currentTimeMillis() - start;
		System.out.println(bufferCost);
	}
	public static String createStringBuffer(String s1, String s2){
		StringBuffer sb = new StringBuffer();
		sb.append(s1);
		sb.append(s2);
		return sb.toString();
	}

}
