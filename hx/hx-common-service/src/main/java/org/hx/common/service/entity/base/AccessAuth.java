package org.hx.common.service.entity.base;

import java.io.Serializable;

public class AccessAuth implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -4201523614396852065L;

    /** 请求 URL */
    private String url;
    
    /** 当前接口是否需要登录 */
    private boolean isLogin;

    /** 当前接口的访问权限 */
    private String permission;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "AccessAuth [url=" + url + ", isLogin=" + isLogin + ", permission=" + permission + "]";
    }
    
    
}
