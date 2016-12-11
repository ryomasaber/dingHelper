package com.dingHelper.agent;

import com.dingHelper.Contant;
import com.dingHelper.OApiException;
import com.dingHelper.ResultCode;
import com.dingHelper.agent.request.CreateReq;
import com.dingHelper.agent.request.SetVisibleScopesReq;
import com.dingHelper.agent.response.CreateRep;
import com.dingHelper.agent.response.VisibleScopesRep;
import com.dingHelper.utils.HttpHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 操作微应用相关
 * Created by Saber on 16/8/24.
 */
public class AgentHelper {

    private static final Logger logger = LoggerFactory.getLogger(AgentHelper.class.getCanonicalName());

    /**
     * 创建微应用
     * @param accessToken accessToken
     * @param createReq   请求包结构体
     * @return
     */
    public static CreateRep createAgent(String accessToken,CreateReq createReq){
        CreateRep createRep = null;
        String url = Contant.MICRO_APP_CREATE_HOST + accessToken;
        try {
            //执行请求
            JSONObject resultJSON = HttpHelper.httpPost(url, JSON.toJSONString(createReq));
            //解析响应
            createRep = JSON.parseObject(resultJSON.toString(), CreateRep.class);
            return createRep;
        } catch (OApiException e) {
            e.printStackTrace();
            logger.error(e.getMessage());

            ResultCode resultCode = JSON.parseObject(e.getMessage(), ResultCode.class);
            return (CreateRep)resultCode;
        }

    }

    /**
     * 获取企业设置的微应用可见范围
     * @param accessToken  accessToken
     * @param agentId      微应用id
     * @return
     */
    public static VisibleScopesRep getVisibleScopesRep(String accessToken,Long agentId){
        VisibleScopesRep visibleScopesRep =null;
        String url = Contant.MICRO_APP_VISIBLE_SCOPES_HOST + accessToken;

        JSONObject param = new JSONObject();
        param.put("agentId",agentId);

        try {
            //执行请求
            JSONObject resultJSON = HttpHelper.httpPost(url, JSON.toJSONString(param));
            //解析响应
            visibleScopesRep = JSON.parseObject(resultJSON.toString(), VisibleScopesRep.class);
            return visibleScopesRep;
        } catch (OApiException e) {
            e.printStackTrace();
            logger.error(e.getMessage());

            ResultCode resultCode = JSON.parseObject(e.getMessage(), ResultCode.class);
            return (VisibleScopesRep)resultCode;
        }
    }

    /**
     * 设置微应用的可见范围
     * @param accessToken           accessToken
     * @param setVisibleScopesReq   请求包结构体
     * @return
     */
    public static ResultCode setVisibleScopes(String accessToken,SetVisibleScopesReq setVisibleScopesReq){
        ResultCode resultCode = null;
        String url = Contant.MICRO_APP_SET_VISIBLE_SCOPES_HOST + accessToken;

        try {
            //执行请求
            JSONObject resultJSON = HttpHelper.httpPost(url, JSON.toJSONString(setVisibleScopesReq));
            //解析响应
            resultCode = JSON.parseObject(resultJSON.toString(), ResultCode.class);
            return resultCode;
        } catch (OApiException e) {
            e.printStackTrace();
            logger.error(e.getMessage());

            return JSON.parseObject(e.getMessage(), ResultCode.class);
        }

    }
}
