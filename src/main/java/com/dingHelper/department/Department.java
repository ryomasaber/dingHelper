package com.dingHelper.department;

/**
 * {
 * "errcode": 0,
 * "errmsg": "ok",
 * "id": 2,
 * "name": "钉钉事业部",
 * "order" : 10,
 * "parentid": 1,
 * "createDeptGroup": true,
 * "autoAddUser": true,
 * "deptHiding" : true,
 * "deptPerimits" : "3|4",
 * "userPerimits" : "userid1|userid2",
 * "outerDept" : true,
 * "outerPermitDepts" : "1|2",
 * "outerPermitUsers" : "userid3|userid4",
 * "orgDeptOwner" : "manager1122",
 * "deptManagerUseridList" : "manager1122|manager3211"
 * }
 */
public class Department {

	private Long id;        //部门id
	private String name;        //部门名称
	private Long parentid;    //父部门id,根部门id为1
	private Integer order;    //在父部门中的次序值
	private Boolean createDeptGroup; //是否同步创建一个关联此部门的企业群, true表示是, false表示不是
	private Boolean autoAddUser;//当群已经创建后，是否有新人加入部门会自动加入该群, true表示是, false表示不是
	private Boolean deptHiding;//是否隐藏部门, true表示隐藏, false表示显示
	private String deptPerimits;//可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的的字符串，使用|符号进行分割
	private String userPerimits;//可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的的字符串，使用|符号进行分割
	private Boolean outerDept;//是否本部门的员工仅可见员工自己, 为true时，本部门员工默认只能看到员工自己
	private String outerPermitDepts;//本部门的员工仅可见员工自己为true时，可以配置额外可见部门，值为部门id组成的的字符串，使用|符号进行分割
	private String outerPermitUsers;//本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串，使用| 符号进行分割
	private String orgDeptOwner;//企业群群主
	private String deptManagerUseridList;//部门的主管列表,取值为由主管的userid组成的字符串，不同的userid使用|符号进行分割

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean getCreateDeptGroup() {
		return createDeptGroup;
	}

	public void setCreateDeptGroup(Boolean createDeptGroup) {
		this.createDeptGroup = createDeptGroup;
	}

	public Boolean getAutoAddUser() {
		return autoAddUser;
	}

	public void setAutoAddUser(Boolean autoAddUser) {
		this.autoAddUser = autoAddUser;
	}

	public Boolean getDeptHiding() {
		return deptHiding;
	}

	public void setDeptHiding(Boolean deptHiding) {
		this.deptHiding = deptHiding;
	}

	public String getDeptPerimits() {
		return deptPerimits;
	}

	public void setDeptPerimits(String deptPerimits) {
		this.deptPerimits = deptPerimits;
	}

	public String getUserPerimits() {
		return userPerimits;
	}

	public void setUserPerimits(String userPerimits) {
		this.userPerimits = userPerimits;
	}

	public Boolean getOuterDept() {
		return outerDept;
	}

	public void setOuterDept(Boolean outerDept) {
		this.outerDept = outerDept;
	}

	public String getOuterPermitDepts() {
		return outerPermitDepts;
	}

	public void setOuterPermitDepts(String outerPermitDepts) {
		this.outerPermitDepts = outerPermitDepts;
	}

	public String getOuterPermitUsers() {
		return outerPermitUsers;
	}

	public void setOuterPermitUsers(String outerPermitUsers) {
		this.outerPermitUsers = outerPermitUsers;
	}

	public String getOrgDeptOwner() {
		return orgDeptOwner;
	}

	public void setOrgDeptOwner(String orgDeptOwner) {
		this.orgDeptOwner = orgDeptOwner;
	}

	public String getDeptManagerUseridList() {
		return deptManagerUseridList;
	}

	public void setDeptManagerUseridList(String deptManagerUseridList) {
		this.deptManagerUseridList = deptManagerUseridList;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", parentid='" + parentid + '\'' +
				", order=" + order +
				", createDeptGroup=" + createDeptGroup +
				", autoAddUser=" + autoAddUser +
				", deptHiding=" + deptHiding +
				", deptPerimits='" + deptPerimits + '\'' +
				", userPerimits='" + userPerimits + '\'' +
				", outerDept=" + outerDept +
				", outerPermitDepts='" + outerPermitDepts + '\'' +
				", outerPermitUsers='" + outerPermitUsers + '\'' +
				", orgDeptOwner='" + orgDeptOwner + '\'' +
				", deptManagerUseridList='" + deptManagerUseridList + '\'' +
				'}';
	}
}
