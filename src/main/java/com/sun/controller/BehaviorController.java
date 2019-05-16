package com.sun.controller;

import com.sun.model.Behavior;
import com.sun.model.TypeInfo;
import com.sun.service.BehaviorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping("")
public class BehaviorController {
    private static Logger log = LoggerFactory.getLogger(BehaviorController.class);

    @Autowired
    private BehaviorService service;


    @RequestMapping(value = "/behavior", method = RequestMethod.POST)
    @ResponseBody
    public String addBehavior(@RequestBody Behavior behavior) {
        service.postBehavior(behavior);
        return "add";
    }
}