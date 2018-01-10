package nio.buffer;

import java.nio.CharBuffer;

/**
 * Buffer fill/drain example. This code uses the simplest means of filling and
 * draining a buffer: one element at a time.
 * 
 * @author Ron Hitchens (ron@ronsoft.com)
 */
public class BufferFillDrain {
	public static void main(String[] argv) throws Exception {
		CharBuffer buffer = CharBuffer.allocate(10);
		while (fillBuffer(buffer)) {
			buffer.flip();
			drainBuffer(buffer);
			buffer.clear();
		}
	}

	private static void drainBuffer(CharBuffer buffer) {
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get());
		}
		System.out.println("");
	}

	private static boolean fillBuffer(CharBuffer buffer) {
		if (index >= strings.length) {
			return (false);
		}
		String string = strings[index++];
		for (int i = 0; i < string.length(); i++) {
			buffer.put(string.charAt(i));
		}

		return (true);
	}

	private static int index = 0;
	private static String[] strings = { "A random string value",
			"The product of an infinite number of monkeys",
			"Hey hey we're the Monkees",
			"Opening act for the Monkees: Jimi Hendrix",
			"'Scuse me while I kiss this fly", // Sorry Jimi ;-)
			"Help Me! Help Me!", };
}
