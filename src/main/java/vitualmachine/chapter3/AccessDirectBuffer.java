package vitualmachine.chapter3;

import java.nio.ByteBuffer;

public class AccessDirectBuffer {

	public void directAccess(){
		long startTime =System.currentTimeMillis();
		ByteBuffer b = ByteBuffer.allocateDirect(500);
		for(int i=0; i < 100000; i++){
			for(int j=0; j<99; j++){
				b.putInt(j);
			}
			b.flip();
			for(int j=0; j<99; j++){
				
			}
		}
	}
}
