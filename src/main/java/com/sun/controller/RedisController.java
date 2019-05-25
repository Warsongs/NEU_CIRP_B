package com.sun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class RedisController {
    @Autowired
    private RedisServiceImpl service;

    @ResponseBody
    @RequestMapping(value = "redisFlushAll", method = RequestMethod.DELETE)
    public String redisFlushAll(){
        service.flushAll();
        return "success";
    }





    /*@RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Object getByMyService(String key) {
        try {
            Object result = service.get(key);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "save", method = RequestMethod.GET)
    @ResponseBody
    public Object save(@RequestBody RedisStringModel model) {

    }　　*/
}
