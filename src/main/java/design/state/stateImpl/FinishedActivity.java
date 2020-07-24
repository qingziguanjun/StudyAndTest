package design.state.stateImpl;

import design.state.Activity;

/**
 * @author songyi
 * @date 2020-04-11 17:33
 * @Description:
 */
public class FinishedActivity implements Activity {

    private TaskNode current;
    //通知申请人通过
    public void notifyApply() {

    }

    //
    public void finish(){
        //修改状态
        //赋权
        doFinish();
        //通知
        notifyApply();//todo Json变了要有变化
    }

    public void doFinish(){

    }
}
