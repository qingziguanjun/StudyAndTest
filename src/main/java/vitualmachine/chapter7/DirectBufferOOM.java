package vitualmachine.chapter7;

import java.nio.ByteBuffer;
/*
 * -Xmx1g -XX:+PrintGCDetails
 * 64位的机器不会有这个问题，32位因为应用程序最大有限制
 */
public class DirectBufferOOM {

	public static void main(String[] args) {
		for(int i=0; i<10240; i++){
			ByteBuffer.allocateDirect(1024*1024);
			//System.out.println(i);
		}
	}

}
