package org.hx.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hx.common.service.entity.base.Result;
import org.hx.common.service.entity.user.LoginReq;
import org.hx.common.service.entity.user.User;
import org.hx.controller.annotation.Login;
import org.hx.controller.annotation.Permission;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController {

    /**
     * 登录
     * @param loginReq 登录请求参数
     * @param httpRsp HTTP响应
     * @return 登录是否成功
     */
//    @GetMapping("/login")
//    public Result login(LoginReq loginReq, HttpServletResponse httpRsp);
    @Login
    @Permission("update")
    @RequestMapping(method = RequestMethod.POST, value = "/login", consumes="application/json")
    public Result login2(@RequestBody LoginReq loginReq, HttpServletResponse httpRsp) {
        System.out.println("登陆用户：" + loginReq.getUsername());
        User user = new User();
        user.setId("1");
        user.setPassword(loginReq.getPassword());
        user.setUsername(loginReq.getUsername());
        List<String> resources = new ArrayList<String>();
        resources.add("update");
        resources.add("save");
        user.setPermissions(resources);
        return Result.newSuccessResult(user);
    }
}
