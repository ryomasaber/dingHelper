package com.dingHelper.agent.response;

import com.dingHelper.ResultCode;

/**
 * 创建微应用 响应体
 * Created by Saber on 16/8/24.
 */
public class AgentResponse extends ResultCode {

    /**
     * 创建的微应用id
     */
    private Long agentid;


    public Long getAgentid() {
        return agentid;
    }

    public void setAgentid(Long agentid) {
        this.agentid = agentid;
    }

    @Override
    public String toString() {
        return "AgentResponse{" +
                "agentid=" + agentid +
                "} " + super.toString();
    }
}
