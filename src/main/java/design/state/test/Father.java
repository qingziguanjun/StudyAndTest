package design.state.test;

/**
 * @author songyi
 * @date 2020-04-14 15:17
 * @Description:
 */
public class Father {

    public void doWork(){
        doJob();
    }

    protected void  doJob(){
        System.out.println("父类的方法");
    }
}
