package vitualmachine.chapter10;

public class PrintClassLoaderTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassLoader c1 = PrintClassLoaderTree.class.getClassLoader();
		while(c1 != null){
			System.out.println(c1);
			c1 = c1.getParent();
		}
	}

}
