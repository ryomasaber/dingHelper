package com.dingHelper.department;

import com.dingHelper.OApiException;
import com.dingHelper.ResultCode;
import com.dingHelper.auth.AuthHelper;

import java.util.List;

/**
 * Created by Saber on 2016/12/11.
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

        //todo 一、操作通讯录  =====================================================================================
        //1.1获取部门列表
        List<Department> departmentList = DepartmentHelper.listDepartments(accessToken);
        for (Department department : departmentList) {
            System.err.println("department = " + department);
        }

        //1.2获取单个部门
        Department department = DepartmentHelper.getDepartment(accessToken, 16371636L);
        System.err.println("department = " + department.toString());

        //1.3新增部门
        Department addParam = new Department();
        addParam.setParentid(1L);
        addParam.setAutoAddUser(false);
        addParam.setName("test(待删除)");
        Long id = DepartmentHelper.createDepartment(accessToken, addParam);
        System.err.println("新增的部门id = " + id);

        //1.4修改部门
        Department updateParam = new Department();
        updateParam.setId(id);
        updateParam.setName("test");
        ResultCode updateResultCode = DepartmentHelper.updateDepartment(accessToken, updateParam);
        System.err.println("修改部门结果 = " + updateResultCode.toString());

        //1.4删除部门
        ResultCode deleteResultCode = DepartmentHelper.deleteDepartment(accessToken, id);
        System.err.println("删除部门结果 " + deleteResultCode.toString());


//todo 二、操作微应用  =====================================================================================


    }
}
