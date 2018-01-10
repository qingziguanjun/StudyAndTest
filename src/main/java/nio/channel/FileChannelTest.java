package nio.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	public static void main(String[] args) throws IOException {
		String fileName ="D:\\internetware\\datarention\\demo.txt";
		//		，记住这很重要。一个连接到只读文件的 Channel 实例不能进行写操作，即使该实例所属
//		的类可能有 write( )方法。基于此，程序员需要知道通道是如何打开的，避免试图尝试一个底层 I/O
//		服务不允许的操作。
		// A ByteBuffer named buffer contains data to be written
		FileInputStream input = new FileInputStream (fileName);
		FileChannel channel = input.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(10);
		// This will compile but will throw an IOException
		// because the underlying file is read-only
		channel.write (buffer);
	}

}
