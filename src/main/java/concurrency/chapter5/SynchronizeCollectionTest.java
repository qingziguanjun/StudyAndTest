package concurrency.chapter5;

import java.util.Vector;

public class SynchronizeCollectionTest {
	
	private  Vector<String> vector = new Vector<String>();
	public void setList(){
		for(int i=0; i<10000; i++){
			vector.add("第" + i + "个");
		}
	}
	
	public  synchronized String getLast(){
		int lastIndex = vector.size()-1;
		return vector.get(lastIndex);
	}

	public  synchronized void deleteLast(){
		int lastIndex = vector.size()-1;
		vector.remove(lastIndex);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SynchronizeCollectionTest test = new SynchronizeCollectionTest();
		test.setList();
		for(int i=0; i<10000; i++){
		
			new Thread(new Runnable() {
				
				public void run() {
					test.getLast();
					
				}
			}).start();
		}
		for(int i=0; i<10000; i++){
			
			new Thread(new Runnable() {
				
				public void run() {
					test.deleteLast();
				}
			}).start();
		}
	}

}
