package com.dingHelper.agent.request;

import com.dingHelper.OApiException;
import com.dingHelper.agent.AgentHelper;
import com.dingHelper.agent.response.AgentResponse;
import com.dingHelper.auth.AuthHelper;
import com.dingHelper.media.MediaHelper;

import java.io.File;

/**
 * Created by Saber on 2016/12/23.
 */
public class MainTest {

    /********
     * 测试企业   yfl1 Aptx4869
     ************/
    public static final String CORP_ID = "ding909520c640789245";
    public static final String SECRET = "LIlSU6DCjWMUA4ZQXrfHTA8-xxxDzHvtWn4L_ZDbMChquzTCOCl0lAd_qZN8HMOM";

    public static final String SSO_Secret = "TMPGk5kaRxtrLtgiLP9CvQlmywYAWfN45x0pi9IFO9WvrFwgnGAYiKImcfaI8Asi";

    public static void main(String[] args) throws OApiException {

        //获取accessToken
        String accessToken = AuthHelper.getAccessToken(CORP_ID, SECRET);
        System.err.println("accessToken=" + accessToken);

        //获取ticket
        String ticket = AuthHelper.getJsapiTicket(accessToken);
        System.err.println("ticket = " + ticket);

        //上传微应用图标并获取图标地址
        String appIconPath = System.getProperty("user.dir") + File.separatorChar + "appIcon.png";
        File appIconFile = new File(appIconPath);
        MediaHelper.MediaUploadResult mediaUploadResult = MediaHelper.upload(accessToken, MediaHelper.TYPE_IMAGE, appIconFile);
        String appIconMediaId = mediaUploadResult.media_id;
        System.err.println("logo 上传后的id " + appIconMediaId);

        //1.新增微应用
        AgentRequest agentRequest = new AgentRequest();
        agentRequest.setAppIcon(appIconMediaId);
        agentRequest.setAppName("测试应用");
        agentRequest.setAppDesc("测试使用 随便写点什么...");
        agentRequest.setHomepageUrl("http://www.baidu.com");
        AgentResponse addAgentResponse = AgentHelper.createAgent(accessToken, agentRequest);
        System.err.println("新增微应用结果 " + addAgentResponse.toString());
    }
}
