package com.dingHelper.agent.request;


import java.util.Arrays;

/**
 * 设置微应用的可见范围 请求体
 * Created by Saber on 16/8/24.
 */
public class SetVisibleScopesReq {

    /**
     *  微应用agentId <br/>
     *  必须: 是
     */
    private Long agentId;
    /**
     *  是否仅限管理员可见，true代表仅限管理员可见
     *  必须: 否
     */
    private Boolean isHidden;
    /**
     *  设置可见的部门id列表，格式为JSON数组
     *  必须: 否
     */
    private String[] deptVisibleScopes;
    /**
     *  设置可见的员工id列表，格式为JSON数组
     *  必须: 否
     */
    private String[] userVisibleScopes;

    //无参构造方法
    public SetVisibleScopesReq() {
    }

    /**
     *  必须的参数
     * @param agentId  微应用agentId
     */
    public SetVisibleScopesReq(Long agentId) {
        this.agentId = agentId;
    }

//-------------------------------------------------------------
    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public String[] getDeptVisibleScopes() {
        return deptVisibleScopes;
    }

    public void setDeptVisibleScopes(String[] deptVisibleScopes) {
        this.deptVisibleScopes = deptVisibleScopes;
    }

    public String[] getUserVisibleScopes() {
        return userVisibleScopes;
    }

    public void setUserVisibleScopes(String[] userVisibleScopes) {
        this.userVisibleScopes = userVisibleScopes;
    }

    @Override
    public String toString() {
        return "SetVisibleScopesReq{" +
                "agentId=" + agentId +
                ", isHidden=" + isHidden +
                ", deptVisibleScopes=" + Arrays.toString(deptVisibleScopes) +
                ", userVisibleScopes=" + Arrays.toString(userVisibleScopes) +
                '}';
    }
}
