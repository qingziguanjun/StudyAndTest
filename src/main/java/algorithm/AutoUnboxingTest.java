package algorithm;
class AutoUnboxingTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3; 
        int c = 3;
        System.out.println(a == b); 
        System.out.println(a == c); 
    }
}
