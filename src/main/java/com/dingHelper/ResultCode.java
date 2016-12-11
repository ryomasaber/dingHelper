package com.dingHelper;

import java.io.Serializable;

/**
 * 基础的响应码
 * Created by Saber on 16/8/24.
 */
public class ResultCode implements Serializable{

    private static final long serialVersionUID = 3312006345445716275L;

    /**
     * 返回码
     */
    private int errcode;
    /**
     * 对返回码的文本描述内容
     */
    private String errmsg;



    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
