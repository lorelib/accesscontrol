package com.lorelib.accesscontrol.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限控制器
 * Created by listening on 2017/3/16.
 */
@RestController
@RequestMapping("access")
public class AccessController {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
