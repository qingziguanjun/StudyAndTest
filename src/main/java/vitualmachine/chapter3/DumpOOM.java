package vitualmachine.chapter3;

import java.util.Vector;

/**
 * -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/a.dump
 * @author sy
 *
 */
public class DumpOOM {

	public static void main(String[] args) {
		Vector v = new Vector();
		for(int i=0; i<25; i++){
			v.add(new byte[1*1024*1024]);
		}

	}

}
