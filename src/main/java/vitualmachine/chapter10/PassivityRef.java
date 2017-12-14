package vitualmachine.chapter10;

class Parent {
	static{
		System.out.println("Parent init");
	}
	public static int v = 10;
}
class Child extends Parent{
	static{
		System.out.println("Child init");
	}
}
/**
 * -XX:+TraceClassLoading
 * 子类被加载了，但是没有初始化
 * @author sy
 *
 */
public class PassivityRef{
	public static void main(String[] args) {
		System.out.println(Child.v);
	}
}