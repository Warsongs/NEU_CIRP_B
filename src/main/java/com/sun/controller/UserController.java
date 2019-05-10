package com.sun.controller;

// slf4j.Logger

import com.alibaba.fastjson.JSONObject;
import com.sun.model.User;
import com.sun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("")
// /user/**
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        userService.postUser(user);
        return "add";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String selectUser(@RequestBody User user) {
        User u = userService.getUserById(user.getId());
        JSONObject json = new JSONObject();
        json.put("user", JSONObject.toJSON(u));
        return json.toJSONString();
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user) {
        userService.putUser(user);
        return "update";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return "delete";
    }
}
