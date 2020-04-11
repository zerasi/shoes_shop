package cn.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiController {

    private static final String qiantaiPath = "/qiantai/";

    @RequestMapping(value="/getPage")
    public String getPage(String pageName){
        return pageName;
    }

    @RequestMapping(value="/index")
    public String adminIndex(String pageName){
        return "index";
    }

    @RequestMapping(value="/home")
    public String home(String pageName){
        return "home";
    }

    @RequestMapping(value="/login")
    public String adminLogin(String pageName){
        return "/login";
    }

    @RequestMapping("/qiantai/{path}")
    public String post(@PathVariable("path") String path) {
        return qiantaiPath+path;
    }



}
