package com.example.demo.controller;

import com.example.demo.annotation.LoginRequired;
import com.example.demo.annotation.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/a")
    @LoginRequired
    public String sourceA(){
        return "访问A资源";
    }

    @GetMapping("/b")
    public String sourceB(){
        return "访问B资源";
    }

    @GetMapping("/c/{user}/{sourceName}")
    @MyLog
    public String sourceC(@PathVariable("user") String user,
                          @PathVariable("sourceName") String sourceName){
        return "访问C资源";
    }
}
