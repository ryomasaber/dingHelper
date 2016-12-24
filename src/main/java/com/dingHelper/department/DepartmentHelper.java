package com.dingHelper.department;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingHelper.Env;
import com.dingHelper.OApiException;
import com.dingHelper.OApiResultException;
import com.dingHelper.ResultCode;
import com.dingHelper.utils.HttpHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门管理工具类
 */
public class DepartmentHelper {

	/**
	 *  创建部门
	 * @param accessToken        accessToken
	 * @param name                部门名称
	 * @param parentId			上级部门id
	 * @param order				排序
	 * @param createDeptGroup   是否同步创建一个关联此部门的企业群, true表示是, false表示不是
	 * @return 创建的部门id
	 * @throws OApiException
	 */
	public static long createDepartment(String accessToken, String name, String parentId, String order, boolean createDeptGroup ) throws OApiException {
		String url = Env.OAPI_HOST + "/department/create?" + "access_token=" + accessToken;
		JSONObject args = new JSONObject();
		args.put("name", name);
		args.put("parentid", parentId);
		args.put("order", order);
		args.put("createDeptGroup", createDeptGroup);
		JSONObject response = HttpHelper.httpPost(url, args);
		if (response.containsKey("id")) {
			return response.getLong("id");
		}
		else {
			throw new OApiResultException("id");
		}
	}

	/**
	 * 创建部门
	 *
	 * @param accessToken accessToken
	 * @param department  参数(id为空)
	 * @return 部门id
	 * @throws OApiException
	 * @Author Saber
	 * @Date 2016/12/23 下午4:37
	 */
	public static Long createDepartment(String accessToken, Department department) throws OApiException {
		String url = Env.OAPI_HOST + "/department/create?" + "access_token=" + accessToken;
		department.setId(null);
		JSONObject response = HttpHelper.httpPost(url, JSONObject.toJSON(department));
		if (response.containsKey("id")) {
			return response.getLong("id");
		} else {
			throw new OApiResultException("id");
		}
	}

	public static Long createDepartmentWithCheck(String accessToken, Department department) throws OApiException {

		/**
		 * 遍历所有部门查找重名部门
		 */
		List<Department> departmentList = DepartmentHelper.listDepartments(accessToken);
		for (Department dept : departmentList) {
			if (dept.equals(department.getName())) {
				throw new OApiResultException("此部门已存在");
			}
		}
		//新增
		String url = Env.OAPI_HOST + "/department/create?" + "access_token=" + accessToken;
		department.setId(null);
		JSONObject response = HttpHelper.httpPost(url, JSONObject.toJSON(department));
		if (response.containsKey("id")) {
			return response.getLong("id");
		} else {
			throw new OApiResultException("id");
		}
	}

	/**
	 * 获取部门列表（ISV默认无调用权限）
	 * @param accessToken
	 * @return
	 * @throws OApiException
	 */
	public static List<Department> listDepartments(String accessToken) throws OApiException {
		String url = Env.OAPI_HOST + "/department/list?" + "access_token=" + accessToken;
		JSONObject response = HttpHelper.httpGet(url);
		if (response.containsKey("department")) {
			JSONArray arr = response.getJSONArray("department");
			List<Department> list  = new ArrayList();
			for (int i = 0; i < arr.size(); i++) {
				list.add(arr.getObject(i, Department.class));
			}
			return list;
		}
		else {
			throw new OApiResultException("department");
		}
	}

	/**
	 * 获取部门详情
	 *
	 * @param accessToken accessToken
	 * @param id          部门id
	 * @return
	 * @throws OApiException
	 */
	public static Department getDepartment(String accessToken, Long id) throws OApiException {
		String url = Env.OAPI_HOST + "/department/get?" + "access_token=" + accessToken + "&id=" + id;
		JSONObject json = HttpHelper.httpGet(url);

		if (json.getInteger("errcode") == 0) {
			Department department = JSON.toJavaObject(json, Department.class);
			return department;
		}

		return null;
	}


	/**
	 * 删除部门 （ISV默认无调用权限）
	 * @param accessToken    accessToken
	 * @param id			部门id
	 * @throws OApiException
	 */
	public static ResultCode deleteDepartment(String accessToken, Long id) throws OApiException{
		String url = Env.OAPI_HOST  + "/department/delete?" + "access_token=" + accessToken + "&id=" + id;
		JSONObject result = HttpHelper.httpGet(url);
		return JSON.parseObject(result.toJSONString(),ResultCode.class);
	}

	/**
	 * 更新部门
	 * @param accessToken            accessToken
	 * @param name                    名称
	 * @param parentId                父级部门id
	 * @param order                    排序
	 * @param id                    部门id
	 * @param autoAddUser            当群已经创建后，是否有新人加入部门会自动加入该群, true表示是, false表示不是
	 * @param deptManagerUseridList 部门的主管列表,取值为由主管的userid组成的字符串，不同的userid使用’| 符号进行分割
	 * @param deptHiding            是否隐藏部门, true表示隐藏, false表示显示
	 * @param deptPerimits            可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的的字符串，使用 | 符号进行分割
	 * @throws OApiException
	 */
	public static void updateDepartment(String accessToken, String name, String parentId, String order, long id, boolean autoAddUser, String deptManagerUseridList, boolean deptHiding, String deptPerimits) throws OApiException{
		String url = Env.OAPI_HOST  + "/department/update?" + "access_token=" + accessToken;
		JSONObject args = new JSONObject();
		args.put("name", name);
		args.put("parentid", parentId);
		args.put("order", order);
		args.put("id",id);
		args.put("autoAddUser",autoAddUser);
		args.put("deptManagerUseridList",deptManagerUseridList);
		args.put("deptHiding",deptHiding);
		args.put("deptPerimits",deptPerimits);

		HttpHelper.httpPost(url, args);
	}


	/**
	 * 更新部门
	 *
	 * @param accessToken accessToken
	 * @param department  参数
	 * @return
	 * @throws OApiException
	 */
	public static ResultCode updateDepartment(String accessToken, Department department) throws OApiException {
		String url = Env.OAPI_HOST + "/department/update?" + "access_token=" + accessToken;

		JSONObject result = HttpHelper.httpPost(url, JSONObject.toJSON(department));
		return JSON.parseObject(result.toJSONString(),ResultCode.class);
	}
}
