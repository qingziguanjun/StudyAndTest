package design.state.stateImpl;

import design.state.Activity;

/**
 * @author songyi
 * @date 2020-04-11 17:33
 * @Description:
 */
public class ApproveActivity implements Activity {
    // current  next
    private TaskNode currentTask;

    private TaskNode nextTask;

    private String skipMis; // 自动跳过到下一级



    // 给申请人发通过消息
    public void notifyApply() {
        // process 活动

    }

    //通知下级审批人
    public void notifyNextAudit(){}

    public void  doApproveHuo(){

    }
    //具体的审批方法
    public void approveHuo(){
        //修改当前任务状态
        // 修改下一级任务状态
        doApproveHuo();
        // 通知下级审批人
        notifyNextAudit();//todo 小象的Json变了通知也要有变化
        notifyApply();
    }

    public void  doApproveHui(){

    }
    //具体的审批方法
    public void approveHui(){
        //修改当前任务状态
        // 修改下一级任务状态
        doApproveHui(); //
        // todo 会签的个数达到要求进行下面
            // 通知下级审批人
            notifyNextAudit();
            // 通知
            notifyApply();
    }

}
