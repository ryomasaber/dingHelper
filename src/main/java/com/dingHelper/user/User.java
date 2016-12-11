package com.dingHelper.user;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class User {
	public String userid;
	public String name;
	public boolean active;
	public String avatar;
	public List<Long> department;
	public String position;
	public String mobile;
	public String email;
	public String openId;
	public int status;
	public JSONObject extattr;

	public User() {
	}

	public User(String userid, String name) {
		this.userid = userid;
		this.name = name;
	}

	@Override
	public String toString() {
		List<User> users;
		return "User[userid:" + userid + ", name:" + name + ", active:" + active + ", "
				+ "avatar:" + avatar + ", department:" + department +
				", position:" + position + ", mobile:" + mobile + ", email:" + email +
				", openId:" + openId + ", status:" + status +", extattr:" + extattr;
	}
}
