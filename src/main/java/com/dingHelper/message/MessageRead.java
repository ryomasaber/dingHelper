package com.dingHelper.message;

import java.util.List;

/**
 * Created by Saber on 2016/12/21.
 */
public class MessageRead {

    /**
     * 已读的人员userId
     */
    private List<String> readList;

    /**
     * 未读得到人员userId
     */
    private List<String> unreadList;

    public List<String> getReadList() {
        return readList;
    }

    public void setReadList(List<String> readList) {
        this.readList = readList;
    }

    public List<String> getUnreadList() {
        return unreadList;
    }

    public void setUnreadList(List<String> unreadList) {
        this.unreadList = unreadList;
    }

    @Override
    public String toString() {
        return "MessageRead{" +
                "readList=" + readList +
                ", unreadList=" + unreadList +
                '}';
    }
}
