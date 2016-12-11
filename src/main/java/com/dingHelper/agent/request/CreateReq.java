package com.dingHelper.agent.request;

/**
 * 创建微应用 请求体
 * Created by Saber on 16/8/24.
 */
public class CreateReq {

    /**
     * 微应用的图标。需要调用上传接口将图标上传到钉钉服务器后获取到的mediaId<br/>
     * 必须: 是
     */
    private String appIcon;
    /**
     * 微应用的名称。长度限制为1~10个字符
     * 必须: 是
     */
    private String appName;
    /**
     * 微应用的描述。长度限制为1~20个字符
     * 必须: 是
     */
    private String appDesc;
    /**
     * 微应用的移动端主页，必须以http开头或https开头
     * 必须: 是
     */
    private String homepageUrl;
    /**
     * 微应用的PC端主页，必须以http开头或https开头，如果不为空则必须与homepageUrl的域名一致
     * 必须: 否
     */
    private String pcHomepageUrl;
    /**
     * 微应用的OA后台管理主页，必须以http开头或https开头
     * 必须:
     */
    private String ompLink;


    //无参构造方法
    public CreateReq() {
    }

    /**
     * 必须的参数
     * @param appIcon       微应用的图标
     * @param appName       微应用的名称
     * @param appDesc       微应用的描述
     * @param homepageUrl   微应用的移动端主页
     */
    public CreateReq(String appIcon, String appName, String appDesc, String homepageUrl) {
        this.appIcon = appIcon;
        this.appName = appName;
        this.appDesc = appDesc;
        this.homepageUrl = homepageUrl;
    }



    //----------------------------------------------------------
    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getPcHomepageUrl() {
        return pcHomepageUrl;
    }

    public void setPcHomepageUrl(String pcHomepageUrl) {
        this.pcHomepageUrl = pcHomepageUrl;
    }

    public String getOmpLink() {
        return ompLink;
    }

    public void setOmpLink(String ompLink) {
        this.ompLink = ompLink;
    }

    @Override
    public String toString() {
        return "AgentCreate{" +
                "appIcon='" + appIcon + '\'' +
                ", appName='" + appName + '\'' +
                ", appDesc='" + appDesc + '\'' +
                ", homepageUrl='" + homepageUrl + '\'' +
                ", pcHomepageUrl='" + pcHomepageUrl + '\'' +
                ", ompLink='" + ompLink + '\'' +
                '}';
    }
}
