package com.dingHelper;

import com.dingHelper.auth.AuthHelper;
import com.dingHelper.department.Department;
import com.dingHelper.department.DepartmentHelper;

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

        //获取部门列表
        List<Department> departmentList = DepartmentHelper.listDepartments(accessToken);
        for (Department department : departmentList) {
            System.out.println("department = " + department);
        }


    }
}
