package design.state.stateImpl;

import design.state.Activity;

/**
 * @author songyi
 * @date 2020-04-11 17:33
 * @Description:
 */
public class RejectActivity implements Activity {

    private TaskNode current;
    // 通知申请人驳回
    public void notifyApply() {

    }

    public void reject(){
        //修改状态
        // 拒绝
        doReject();
        //
        //
    }

    public void doReject(){

    }
}
