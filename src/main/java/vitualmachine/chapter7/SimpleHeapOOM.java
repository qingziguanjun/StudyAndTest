package vitualmachine.chapter7;

import java.util.ArrayList;

/*
 * 最常见的java堆溢出，一直持有对象不释放
 */
public class SimpleHeapOOM {

	public static void main(String[] args) {
		ArrayList<byte[]> list = new ArrayList<byte[]>();
		for(int i=0; i<1024; i++){
			list.add(new byte[1024*1024]);
		}
	}

}
