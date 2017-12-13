package vitualmachine.chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * 偏向锁提升性能,使用下面的参数很快
 * -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0 -client -Xmx512m -Xms512m
 * 禁用偏向锁：
 * -XX:-UseBiasedLocking -client -Xmx512M -Xms512m
 *
 */
public class Biased {
	public static List<Integer> numberList = new ArrayList<Integer>();
	public static void main(String[] args) throws InterruptedException{
		long begin = System.currentTimeMillis();
		int count = 0;
		int startNum =0;
		while(count < 10000000){
			numberList.add(startNum);
			startNum += 2;
			count++;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}

}
