package com.example.demo.service.impl;

import com.example.demo.service.DemoService;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author wukun
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public void trySomething() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //dateTimeFormatter.getLocale();
    }

    public static void main(String[] args) {
        System.out.println("ssss");
    }
}
