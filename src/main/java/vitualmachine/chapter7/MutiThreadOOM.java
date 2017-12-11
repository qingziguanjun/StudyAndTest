package vitualmachine.chapter7;

/**
 * 轻易不要执行，电脑死机
 * @author sy
 *
 */
public class MutiThreadOOM {
	public static class SleepThread implements Runnable{
		public void run() {
			while (true) {
				
			}
		}
	}
	public static void main(String[] args) {
		for(int i=0; i<2000; i++){
			new Thread(new SleepThread(),"Thread"+i).start();
			System.out.println("Thread" + i + " created");
		}
	}
}
