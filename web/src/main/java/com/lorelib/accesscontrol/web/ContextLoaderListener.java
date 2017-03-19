package com.lorelib.accesscontrol.web;

import javax.servlet.ServletContextEvent;

public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("------------ 正在启动AccessControl  ------------");
        super.contextInitialized(event);
        System.out.println("------------ AccessControl启动成功  ------------");
    }
}
