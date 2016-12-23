package com.dingHelper.message;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingHelper.Env;
import com.dingHelper.OApiException;
import com.dingHelper.OApiResultException;
import com.dingHelper.utils.HttpHelper;

import java.util.List;

public class MessageHelper {

	public static class Receipt {
		String invaliduser;
		String invalidparty;
	}


	public static Receipt send(String accessToken, LightAppMessageDelivery delivery)
			throws OApiException {
		String url = Env.OAPI_HOST + "/message/send?" +
				"access_token=" + accessToken;

		JSONObject response = HttpHelper.httpPost(url, delivery.toJsonObject());
		if (response.containsKey("invaliduser") || response.containsKey("invalidparty")) {
			Receipt receipt = new Receipt();
			receipt.invaliduser = response.getString("invaliduser");
			receipt.invalidparty = response.getString("invalidparty");
			return receipt;
		}
		else {
			throw new OApiResultException("invaliduser or invalidparty");
		}
	}


	public static String send(String accessToken, ConversationMessageDelivery delivery)
		throws OApiException {
		String url = Env.OAPI_HOST + "/message/send_to_conversation?" +
				"access_token=" + accessToken;

		JSONObject response = HttpHelper.httpPost(url, delivery.toJsonObject());
		if (response.containsKey("receiver")) {
			return response.getString("receiver");
		}
		else {
			throw new OApiResultException("receiver");
		}
	}

	/**
	 * 获取消息已读未读状态
	 *
	 * @param accessToken accessToken
	 * @param messageId   消息id
	 * @Author Saber
	 * @Date 2016/12/23 上午10:44
	 */
	public static MessageRead getMessageStatus(String accessToken, String messageId) throws OApiException {
		String url = Env.OAPI_HOST + "/message/list_message_status?access_token=" + accessToken;
		JSONObject paramJOSN = new JSONObject();
		paramJOSN.put("messageId", messageId);
		JSONObject response = HttpHelper.httpPost(url, paramJOSN);
		if (response.getIntValue("errcode") == 0) {
			MessageRead messageRead = new MessageRead();
			//已读
			List<String> readList = JSON.parseArray(response.getString("read"), String.class);
			messageRead.setReadList(readList);
			//未读
			List<String> unreadList = JSON.parseArray(response.getString("unread"), String.class);
			messageRead.setUnreadList(unreadList);
			return messageRead;
		} else {
			throw new OApiResultException("errmsg");
		}
	}

	public static void main(String[] args) {
		String accessToken = "2290a9088d0a38489ca105bbe3fa02ed";
		String messageId = "b24fee6132843a4692190ac811dd90d1";
		//accessToken="11c48a9c625f38e794664c191b4527c8";
		messageId = "78732610fe02373193feb9e692dbc3e2";
		messageId = "b7fd2a47b7f236249f4850ca61df6a13";
		try {
			MessageRead messageRead = getMessageStatus(accessToken, messageId);
			//System.err.println("messageRead:"+messageRead.toString());
			System.err.println("已读数量:" + messageRead.getReadList().size() + "\n已读:" + messageRead.getReadList());
			System.err.println("未读数量:" + messageRead.getUnreadList().size() + "\n未读:" + messageRead.getUnreadList());
		} catch (OApiResultException e) {
			e.printStackTrace();
		} catch (OApiException e) {
			e.printStackTrace();
		}
	}
}
