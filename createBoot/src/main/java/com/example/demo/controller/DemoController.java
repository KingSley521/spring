package com.example.demo.controller;

import com.example.demo.bean.DemoBean;
import com.example.demo.bean.User;
import com.example.demo.service.DemoService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wukun
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Resource
    public DemoService demoService;

    @GetMapping("/run")
    public String run() {
        log.debug("invoke API success");
        User user = new User();
        user.setName("Jack");
        user.setAge(22);
        Gson gson = new Gson();

        demoService.trySomething();
        return gson.toJson(user);
    }

    /**
     * @return
     */
    @GetMapping("/getUserInfo")
    public String userInfo() {
        log.debug("调用getUserInfo接口<<<<<<==============");

        User user = new User();


        return user.toString();
    }


}
