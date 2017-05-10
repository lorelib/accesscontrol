package com.lorelib.hawk.webadmin.web.context;

import javax.servlet.ServletContextEvent;

/**
 * Created by wuqy on 2017-03-16.
 */
public class OptAdminContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("------------ 正在启动optcenter后台  ------------");
        super.contextInitialized(event);
        System.out.println("------------ optcenter后台启动成功  ------------");
    }
}
