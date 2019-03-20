package javalock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
	private final ReentrantLock lock = new ReentrantLock();
	   // ...

	   public void m() {
	     lock.lock();  // block until condition holds
	     try {
	       // ... method body
	     } finally {
	       lock.unlock();
	     }
	   }

}
