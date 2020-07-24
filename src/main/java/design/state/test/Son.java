package design.state.test;

/**
 * @author songyi
 * @date 2020-04-14 15:18
 * @Description:
 */
public class Son extends Father{

    protected void  doJob(){
        System.out.println("子类的方法");
    }

    public static void main(String[] args) {
        Son s = new Son();
        s.doWork();
    }
}
