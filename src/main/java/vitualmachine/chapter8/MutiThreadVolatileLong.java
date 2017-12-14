package vitualmachine.chapter8;


/**
   代码有毒，不要执行
   说是修改t 为volitile就可以了，确实是，volitile在这次修改不依赖与上次值的时候是没有问题的，++是不行的
*/
public class MutiThreadVolatileLong {

	public static long t = 0;
	public static class ChangeT implements Runnable{
		private long to;
		public ChangeT(long to){
			this.to = to;
		}
		public void run() {
			while (true) {
				MutiThreadVolatileLong.t = to;
				Thread.yield();
			}
		}
		
	}
	public static class ReadT implements Runnable{

		public void run() {
			while(true){
				long tmp = MutiThreadVolatileLong.t;
				if(tmp != 111L && tmp != -999L && tmp != -444L  && tmp != 333L){
					System.out.println(tmp);
				}
				Thread.yield();
			}
		}
		
	}
	public static void main(String[] args) {
		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(-999L)).start();
		new Thread(new ChangeT(-444L)).start();
		new Thread(new ReadT()).start();

	}

}
