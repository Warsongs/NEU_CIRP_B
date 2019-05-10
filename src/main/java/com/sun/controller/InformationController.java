package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.model.Information;
import com.sun.service.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class InformationController {
    private static Logger log = LoggerFactory.getLogger(InformationController.class);
    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/information", method = RequestMethod.POST)
    public String addInformation(Information information) {
        informationService.postInformation(information);
        return "add";
    }

    @RequestMapping(value = "/information/{id}", method = RequestMethod.GET)
    public String selectInformation(Information information) {
        Information i = informationService.getInformationById(information.getId());
        JSONObject json = new JSONObject();
        json.put("information", JSONObject.toJSON(i));
        return json.toJSONString();
    }

    @RequestMapping(value = "/information/{id}", method = RequestMethod.PUT)
    public String updateInformation(Information information) {
        informationService.putInformation(information);
        return "update";
    }

    @RequestMapping(value = "/information/{id}", method = RequestMethod.DELETE)
    public String deleteInformation(Information information) {
        informationService.deleteInformation(information.getId());
        return "delete";
    }
}
