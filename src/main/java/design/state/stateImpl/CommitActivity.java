package design.state.stateImpl;

import design.state.Activity;

/**
 * @author songyi
 * @date 2020-04-11 17:33
 * @Description:
 */
public class CommitActivity implements Activity {

    // 给申请人发消息，每个状态都需要
    public void notifyApply() {

    }
    //通知审批人
    public void notifyAudit(){

    }

    //给第一级审批人发消息
    //初始化数据

    //todo
    // 每个类里都要有process（修改状态）, processMsgMap(发送消息用)
    // 历史进行中的数据，审批的时候现查，查出来记录？
    //

    public void commit(){
        doCommit();
        notifyApply();
    }


    public void doCommit(){

    }
}

