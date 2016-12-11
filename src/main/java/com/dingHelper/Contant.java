package com.dingHelper;

/**
 * 静态常量
 * Created by Saber on 16/8/24.
 */
public class Contant {

    /**
     * 钉钉网关
     */
    public static final String OAPI_HOST = "https://oapi.dingtalk.com";

    /**
     * 创建微应用
     */
    public static final String MICRO_APP_CREATE_HOST =OAPI_HOST+"/microapp/create?access_token=";

    /**
     * 获取企业设置的微应用可见范围
     */
    public static final String MICRO_APP_VISIBLE_SCOPES_HOST =OAPI_HOST+"/microapp/visible_scopes?access_token=";

    /**
     * 设置微应用的可见范围
     */
    public static final String MICRO_APP_SET_VISIBLE_SCOPES_HOST =OAPI_HOST+"/microapp/set_visible_scopes?access_token=";
}
