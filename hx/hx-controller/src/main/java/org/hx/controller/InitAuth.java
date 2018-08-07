package org.hx.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.hx.common.service.entity.base.AccessAuth;
import org.hx.common.service.util.AnnotationUtil;
import org.hx.common.service.util.ClassUtil;
import org.hx.controller.annotation.AuthScan;
import org.hx.controller.annotation.Login;
import org.hx.controller.annotation.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.common.utils.StringUtils;


@AuthScan("org.hx.controller")
@Component
public class InitAuth implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>运行初始化");
        // 加载接口访问权限
        loadAccessAuth();
    }
    
    private void loadAccessAuth() {
        // 获取待扫描的包名
        AuthScan authScan = AnnotationUtil.getAnnotationValueByClass(this.getClass(), AuthScan.class);
        String pkgName = authScan.value();
        System.out.println("pkgname>>>>>>>>" + pkgName);
        // 获取包下所有类
        List<Class<?>> classes = ClassUtil.getClasses(pkgName);
        if (CollectionUtils.isEmpty(classes)) {
            System.out.println("没有class>>>>>>>>>>>运行初始化");
            return;
        }
        
        for (Class clazz : classes) {
            RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            String classUrl = "";
            if (requestMapping != null) {
                System.out.println("111>>>>>>>>>>>>>" + requestMapping.value().length);
                classUrl = requestMapping.value()[0];
                System.out.println("classUrl>>>>>>>>>>" + classUrl);
            }
            
            Method[] methods = clazz.getMethods();
            if (methods==null || methods.length==0) {
                continue;
            }
            for(Method method : methods) {
                String methodUrl = "";
                RequestMapping methodMapping = AnnotationUtil.getAnnotationValueByMethod(method, RequestMapping.class);
                if (methodMapping != null) {
                    System.out.println("222>>>>>>>>>>>>>" + methodMapping.value().length);
                    methodUrl = methodMapping.value()[0];
                    System.out.println("methodUrl>>>>>>>>>>" + methodUrl);
                    
                    AccessAuth accessAuth = new AccessAuth();
                    accessAuth.setUrl(classUrl + methodUrl);
                    
                 // 获取@Permission的值
                    Permission permission = AnnotationUtil.getAnnotationValueByMethod(method, Permission.class);
                    if (permission!=null && StringUtils.isNotEmpty(permission.value())) {
                        accessAuth.setPermission(permission.value());
                        accessAuth.setLogin(true);
                    }

                    // 获取@Login的值
                    Login login = AnnotationUtil.getAnnotationValueByMethod(method, Login.class);
                    if (login!=null) {
                        accessAuth.setLogin(true);
                    }

                    System.out.println("accessAuth>>>>>>>>>" + accessAuth.toString());
                }
                
            }
        }
    }
}
