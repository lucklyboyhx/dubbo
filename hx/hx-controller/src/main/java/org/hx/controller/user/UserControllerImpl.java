//package org.hx.controller.user;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.hx.common.service.entity.base.Result;
//import org.hx.common.service.entity.user.LoginReq;
//import org.hx.common.service.entity.user.User;
//
//public class UserControllerImpl implements UserController{
//
//    @Override
//    public Result login(LoginReq loginReq, HttpServletResponse httpRsp) {
//        System.out.println("登陆用户：" + loginReq.getUsername());
//        User user = new User();
//        user.setId("1");
//        user.setPassword("222");
//        user.setUsername("name");
//        List<String> resources = new ArrayList<String>();
//        resources.add("update");
//        resources.add("save");
//        user.setResources(resources);
//        return Result.newSuccessResult(user);
//    }
//
//}
