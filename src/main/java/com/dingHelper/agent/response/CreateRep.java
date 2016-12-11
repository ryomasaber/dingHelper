package com.dingHelper.agent.response;

import com.dingHelper.ResultCode;

/**
 * 创建微应用 响应体
 * Created by Saber on 16/8/24.
 */
public class CreateRep extends ResultCode{

    /**
     * 创建的微应用id
     */
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CreateRep{" +
                "id=" + id +
                "} " + super.toString();
    }
}
