package com.dingHelper.agent.response;

import com.dingHelper.ResultCode;

import java.util.Arrays;

/**
 * 获取微应用可见范围返回 响应体
 * Created by Saber on 16/8/24.
 */
public class VisibleScopesRep extends ResultCode{

    /**
     * 是否仅限管理员可见
     */
    private boolean isHidden;
    /**
     * 微应用的可见部门id列表，格式为JSON数组
     */
    private long[] deptVisibleScopes;
    /**
     * 微应用的可见用户id列表，格式为JSON数组
     */
    private long[] userVisibleScopes;




//-----------------------------------------------------------------------
    public boolean isHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public long[] getDeptVisibleScopes() {
        return deptVisibleScopes;
    }

    public void setDeptVisibleScopes(long[] deptVisibleScopes) {
        this.deptVisibleScopes = deptVisibleScopes;
    }

    public long[] getUserVisibleScopes() {
        return userVisibleScopes;
    }

    public void setUserVisibleScopes(long[] userVisibleScopes) {
        this.userVisibleScopes = userVisibleScopes;
    }

    @Override
    public String toString() {
        return "VisibleScopesRep{" +
                "isHidden=" + isHidden +
                ", deptVisibleScopes=" + Arrays.toString(deptVisibleScopes) +
                ", userVisibleScopes=" + Arrays.toString(userVisibleScopes) +
                "} " + super.toString();
    }
}
