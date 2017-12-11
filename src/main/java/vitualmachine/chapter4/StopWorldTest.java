package vitualmachine.chapter4;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

public class StopWorldTest {
	public static class MyThread extends Thread{
		Map map = new HashMap();
		@Override
		public void run(){
			try {
				while (true) {
					if(map.size()*512/1024/1024 >= 900){
						map.clear();
						System.out.println("clear map");
					}
					byte[] b1;
					for(int i = 0; i<100; i++){
						b1 = new byte[512];
						map.put(System.nanoTime(), b1);
					}
					Thread.sleep(1);
				}
			} catch (Exception e) {
			}
		}
	}
	public static class PrintThread extends Thread{
		public static final long startTime = System.currentTimeMillis();
		
		@Override
		public void run(){
			try {
				while (true) {
					long t = System.currentTimeMillis() - startTime;
					System.out.println(t/1000 + "." + t%100 + "s");
					Thread.sleep(100);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		MyThread t = new MyThread();
		PrintThread printThread = new PrintThread();
		t.start();
		printThread.start();
	}

}
