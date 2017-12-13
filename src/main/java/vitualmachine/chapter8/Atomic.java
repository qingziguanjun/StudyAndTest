package vitualmachine.chapter8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/*
 * LongAddr 没有看出来比Atomic有优势啊？
 */
public class Atomic {
	private static final int MAX_THREADS=3;//线程数
	private static final int TASK_COUNT=3;//任务数
	private static final int TARGET_COUNT=100000000;//目标总数
	
	private LongAdder longAdder = new LongAdder();
	private AtomicLong acount = new AtomicLong(0L);
	private long count = 0;
	
	static CountDownLatch cdlsync = new CountDownLatch(TASK_COUNT);
	static CountDownLatch cdlatomic = new CountDownLatch(TASK_COUNT);
	static CountDownLatch cdladdr = new CountDownLatch(TASK_COUNT);
	
	
	protected synchronized long inc() {
		return ++count;
	}
	
	protected synchronized long getCount() {
		return count;
	}
	public void clearCount(){
		count = 0;
	}

	public class SyncThread implements Runnable{
		protected String name;
		protected long starttime;
		Atomic out;
		
		public SyncThread(Atomic o , long starttime){
			out = o;
			this.starttime = starttime;
		}

		public void run() {
			long v = out.getCount();
			while (v < TARGET_COUNT) {
				v = out.inc();
			}
			long endtime = System.currentTimeMillis();
			System.out.println("SyncThread spend: " + (endtime - starttime) + "ms"
					+ "  v=" + v);
			cdlsync.countDown();
		}
		
	}
	
	public void testSysn() throws InterruptedException{
		ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
		long starttime = System.currentTimeMillis();
		SyncThread sync = new SyncThread(this, starttime);
		for(int i=0; i<TASK_COUNT; i++){
			exe.submit(sync);
		}
		cdlsync.await();
		exe.shutdown();
	}
	
	
	public class AtomicThread implements Runnable{
		protected String name;
		protected long starttime;

		
		public AtomicThread(long starttime){
			this.starttime = starttime;
		}

		public void run() {
			long v = acount.get();
			while (v < TARGET_COUNT) {
				v = acount.incrementAndGet();
			}
			long endtime = System.currentTimeMillis();
			System.out.println("AtomicThread spend: " + (endtime - starttime) + "ms"
					+ "  v=" + v);
			cdlatomic.countDown();
		}
		
	}
	
	public void testAtomic() throws InterruptedException{
		ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
		long starttime = System.currentTimeMillis();
		AtomicThread atomic = new AtomicThread(starttime);
		for(int i=0; i<TASK_COUNT; i++){
			exe.submit(atomic);
		}
		cdlatomic.await();
		exe.shutdown();
	}
	
	public class LongAddrThread implements Runnable{
		protected String name;
		protected long starttime;

		
		public LongAddrThread(long starttime){
			this.starttime = starttime;
		}

		public void run() {
			long v = longAdder.sum();
			while (v < TARGET_COUNT) {
				longAdder.increment();
				v = longAdder.sum();
			}
			long endtime = System.currentTimeMillis();
			System.out.println("LongAddrThread spend: " + (endtime - starttime) + "ms"
					+ "  v=" + v);
			cdladdr.countDown();
		}
		
	}
	
	public void testLongAddr() throws InterruptedException{
		ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
		long starttime = System.currentTimeMillis();
		LongAddrThread atomic = new LongAddrThread(starttime);
		for(int i=0; i<TASK_COUNT; i++){
			exe.submit(atomic);
		}
		cdladdr.await();
		exe.shutdown();
	}
	
	
	public static void main(String[] args) throws InterruptedException{
		Atomic a = new Atomic();
		a.testSysn();
		a.testAtomic();
		a.testLongAddr();
	}
	
}
