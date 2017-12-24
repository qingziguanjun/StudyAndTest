package vitualmachine.chapter8;

public class VolatileTest {
	
	public static class MyThread extends Thread{
		private volatile boolean  stop = false;
		public void stopMe(){
			stop = true;
		}
		public void run(){
			int i =0;
			while(!stop){
				i++;
				System.out.println(i);
//				if(i > 100000){
//					System.out.println("Break Thread");
//					break;
//				}
			}
			System.out.println("Stop");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();
		t.start();
		Thread.sleep(1000);
		t.stopMe();
		Thread.sleep(1000);
	}

}
