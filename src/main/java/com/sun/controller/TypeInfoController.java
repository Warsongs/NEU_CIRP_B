package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.model.TypeInfo;
import com.sun.service.TypeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("")
public class TypeInfoController {
    private static Logger log = LoggerFactory.getLogger(TypeInfoController.class);

    @Autowired
    private TypeInfoService typeInfoService;


    @RequestMapping(value = "/typeInfo", method = RequestMethod.POST)
    public String addTypeInfo(TypeInfo typeInfo) {
        typeInfoService.postTypeInfo(typeInfo);
        return "add";
    }

    @RequestMapping(value = "/typeInfo/{id}", method = RequestMethod.GET)
    public String selectTypeInfo(@RequestBody TypeInfo typeInfo) {
        TypeInfo t=typeInfoService.getTypeInfoById(typeInfo.getId());
        JSONObject json=new JSONObject();
        json.put("typeinfo",JSONObject.toJSON(t));
        return json.toJSONString();
    }

    @RequestMapping(value = "/typeInfo/{id}", method = RequestMethod.PUT)
    public String updateTypeInfo(@RequestBody TypeInfo typeInfo) {
        typeInfoService.putTypeInfo(typeInfo);
        return "update";
    }

    @RequestMapping(value = "/typeInfo/{id}", method = RequestMethod.DELETE)
    public String deleteTypeInfo(@RequestBody TypeInfo typeInfo) {
        typeInfoService.deleteTypeInfo(typeInfo.getId());
        return "delete";
    }
}
