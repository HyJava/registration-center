package com.hy.registrationcenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: HY
 * Date: 2019/7/3
 * Time: 15:35
 * Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
}
